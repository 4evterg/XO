package ru.kursa4.com;

import static org.lwjgl.opengl.GL11.*;

public class GameGrid {	
		
	//кол-во линий в кубе т.е кол-во доступных клеток
	private int LinesRows;// = 2
	
	//физический размер куба
	private float cubesize;
	
	private int keyX;
	private int keyY;
	private int keyZ;
	
	public boolean win;
	public int x_o; //счетчик ходов
	
	private byte[][][] Turns; //данные о метках на поле(0-ничего, 1 - стоит крестик, 2 - стоит нолик)
	private boolean lock;	
	
	public String winner;
	private boolean isXwin;
	
	inout io = new inout();
	String[] colors = io.read();

	public GameGrid(float cubesize, int LinesRows)
	{
		this.cubesize = cubesize;
		this.LinesRows = LinesRows;
		this.keyX = 0;
		this.keyY = 0;
		this.keyZ = 0;
		this.x_o = 0;
		this.isXwin = true;
		this.win = false;
		
		Turns = new byte[LinesRows][LinesRows][LinesRows];
		
		Restart();
	}
	
	public void Restart()
	{
		for (int i = 0; i<LinesRows; i++)
			for (int t = 0; t<LinesRows; t++)
				for (int c = 0; c<LinesRows; c++)
					Turns[i][t][c] = 0;	
		this.keyX = 0;
		this.keyY = 0;
		this.keyZ = 0;
		x_o = 0;	
		this.win = false;
		this.isXwin = true;
	}
	
	public void setKeyX(int key)
	{		
		if (key < LinesRows && key >= 0)
			this.keyX = key;
	}
	
	public int getKeyX()
	{
		return this.keyX;		
	}
		
	
	public void setKeyY(int key)
	{		
		if (key < LinesRows  && key >= 0)
			this.keyY = key;
	}
	
	public int getKeyY()
	{
		return this.keyY;		
	}
	
	public void setKeyZ(int key)
	{		
		if (key < LinesRows  && key >= 0)
			this.keyZ = key;
	}
	
	public int getKeyZ()
	{
		return this.keyZ;		
	}	
	
	public void Turn()
	{
		if(Turns[keyX][keyY][keyZ] == 0)
		{
			if (x_o%2 == 0)
			{
			Turns[keyX][keyY][keyZ] = 1;	
			}
			else Turns[keyX][keyY][keyZ] = 2;	
			x_o++;
		}
		
		WinAlgo w = new WinAlgo(Turns, this.lock);
		
		if (w.Winneris() == true)
		{			
			if (x_o%2 == 0)	
			{
				winner = "Нулик";	
				this.isXwin = false;
			}			
			this.win = true;	
		}
	}
	
	public boolean getWinner()
	{
		boolean answer = false;
		if (this.win == true)
		{
			this.winner = "X";
			 if(x_o%2 == 0)
			 {
				 this.winner = "O";	
			 }	
			 answer = true;
		}
		return answer;
		
	}			
	
	//Отрисовуем сетку игрового поля
	public void Grid()
	{	
		//Отступы между линиям сетки куба :З
		float space = cubesize/LinesRows;     
		glPushMatrix();
		{
			float c1 = (1/255f)*Float.valueOf(colors[2]);
			float c2 = (1/255f)*Float.valueOf(colors[3]);
			float c3 = (1/255f)*Float.valueOf(colors[4]);
			glColor3f(c1, c2, c3);		
			glTranslatef(0, 0, -10);
			glRotatef(1,1,1,1);
			
			glLineWidth(6);			

			glBegin(GL_LINES);		
			{			
				for(float x= space; x<cubesize; x+=space)
				{
					for(float z= space; z<cubesize; z+=space)
						{							 
							//X line
						 glVertex3f(0, x, z);
						 glVertex3f(cubesize, x, z);
							 
							//Y line 							  
						 glVertex3f(x, 0, z);
						 glVertex3f(x, cubesize, z);
							
							//Z line		  
						 glVertex3f(x, z, 0);
						 glVertex3f(x, z, cubesize);
						}			  
				}
				  
			}
			glEnd();
		}
		glPopMatrix();				
	}

	
	//Рисуем кубики для выбора хода
	public void Squers()
	{		

		//Отступы между линиям сетки куба 
		float space = cubesize/LinesRows;
		float space2 = cubesize/LinesRows;
		float cubesSpaceUp = 0f; 
		float cubesSpaceDwn =  space;
		
		float cubesSpaceDwnX = cubesSpaceDwn;
		float cubesSpaceDwnY = cubesSpaceDwn;
		float cubesSpaceDwnZ = cubesSpaceDwn;	
	    
				
		glPushMatrix();
		{			
			glTranslatef(0, 0, -10);
			glRotatef(1,1,1,1);	
			//glColor3f(1f, 1.0f, 1f);
			glColor3f(0, 1, 0);
			
			int x = 0;		
			for (float a = cubesSpaceUp; a<cubesize; a+=space2)
			{	
				float circlespaceX = cubesSpaceDwn/2;
				int y = 0;				
				for (float d = cubesSpaceUp; d<cubesize; d+=space2)
				{	
					int z = 0;	
					float circlespaceZ = cubesSpaceDwn/2;
					for (float c = cubesSpaceUp; c<cubesize; c+=space2)
					{ 
//Рисуем крестики-----------------------------------------------------------------------------------------------------				
						if (this.Turns[z][y][x] == 1)
								{
					
								float c1 = (1/255f)*Float.valueOf(colors[8]);
								float c2 = (1/255f)*Float.valueOf(colors[9]);
								float c3 = (1/255f)*Float.valueOf(colors[10]);
								glColor3f(c1, c2, c3);		
								
								
								if (this.win && this.winner == "X") //подсвечиваем победителя
									glColor3f(1, 1, 0);	
								
								glLineWidth(20);
								glBegin(GL_LINES);		
								{	//X line
								glVertex3f(c+space/(space*4), d+space/(space*4), a+space/2);
									
								glVertex3f(cubesSpaceDwnX-+space/(space*4), cubesSpaceDwnY-+space/(space*4), a+space/2);
									
								glVertex3f(c+space/(space*4), cubesSpaceDwnY+space/(space*4), a+space/2);		  
								 glVertex3f(cubesSpaceDwnX-space/(space*4), d-space/(space*4), a+space/2);		
								}
								glEnd();	
								glColor3f(c1, c2, c3);	
							}							
													
							
//Риусем нолики-----------------------------------------------------------------------------------------------------
							if (this.Turns[z][y][x] == 2)
							{
								float c1 = (1/255f)*Float.valueOf(colors[11]);
								float c2 = (1/255f)*Float.valueOf(colors[12]);
								float c3 = (1/255f)*Float.valueOf(colors[13]);
								glColor3f(c1, c2, c3);																	
									
								if (this.win && this.winner == "O") //подсвечиваем победителя
									glColor3f(1, 1, 0);	
								
								glLineWidth(20);								
								glBegin(GL_LINE_LOOP);
								{
									for (int i = 0; i < 256; i++) {
									  double angle = 2*Math.PI*i/256;
									  glVertex3f((float)((space/3)*Math.cos(angle)+circlespaceZ), (float)((space/3)*Math.sin(angle)+circlespaceX), a+space/2);

									}
								}
								glEnd();	
								glColor3f(0, 1, 0);	
							}						
												
						glBegin(GL_QUADS);		
						{	
							
							if (y == this.keyY && z == this.keyX && x==this.keyZ && this.Turns[z][y][x] !=0)
								glColor3f(1, 0.5f, 1);	

							if (y == this.keyY && z == this.keyX && x==this.keyZ )
							{	
							  	
							  glVertex3f(c, d, a);
							  glVertex3f(c, cubesSpaceDwnY, a);			  
							  glVertex3f(cubesSpaceDwnX, cubesSpaceDwnY, a);						  
							  glVertex3f(cubesSpaceDwnX, d, a);				  
							 							  
						      glVertex3f(c, d, a); 
							  glVertex3f(c, d, cubesSpaceDwnZ);
							  glVertex3f(cubesSpaceDwnX, d, cubesSpaceDwnZ); 						  
							  glVertex3f(cubesSpaceDwnX, d, a);						  
							  
							  	
							  glVertex3f(c, d, a); 
							  glVertex3f(c, cubesSpaceDwnY, a); 
							  glVertex3f(c, cubesSpaceDwnY, cubesSpaceDwnZ); 			  
							  glVertex3f(c, d, cubesSpaceDwnZ);	
							  
							 
							  glVertex3f(c, d, a+space); 
							  glVertex3f(c, cubesSpaceDwnY, a+space); 
							  glVertex3f(cubesSpaceDwnX, cubesSpaceDwnY,  a+space);	
							  glVertex3f(cubesSpaceDwnX, d, a+space);
							  
							  glVertex3f(c, d+space, a); 
							  glVertex3f(c, d+space, cubesSpaceDwnZ); 
						      glVertex3f(cubesSpaceDwnX, d+space, cubesSpaceDwnZ);						  
							  glVertex3f(cubesSpaceDwnX, d+space, a);		  
						
							  glVertex3f(c+space, d, a); 
							  glVertex3f(c+space, cubesSpaceDwnY, a); 
							  glVertex3f(c+space, cubesSpaceDwnY, cubesSpaceDwnZ);						  
							  glVertex3f(c+space, d, cubesSpaceDwnZ); 
							}
						}						
						glEnd();
						circlespaceZ +=space;
						glColor3f(0, 1, 0);
						cubesSpaceDwnX+=space;						
						z++;
				    }
					circlespaceX +=space;
					cubesSpaceDwnX = cubesSpaceDwn;
					cubesSpaceDwnY+=space;
					y++;										
				}
				cubesSpaceDwnY = cubesSpaceDwn;
				cubesSpaceDwnZ+=space;
				x++;				
			}
		}
		glPopMatrix();			
	}

}
