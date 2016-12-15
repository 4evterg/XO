package ru.kursa4.com;
import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.input.*;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;


public class Main {

	public static void main(String[] args)
	{		
		initDisplay();
		GameLoop();
		CleanUp();
	}
	
public static void initDisplay()
{
	inout io = new inout();
	String[] temp = io.read();
	
	try {
		Display.setVSyncEnabled(true);	
	
		Display.setDisplayMode(new DisplayMode(800, 600));
		Display.setTitle("XO   | R-restart |");
		Display.setResizable(true);		
		
		float a = (1/255f)*Float.valueOf(temp[5]);
		float b = (1/255f)*Float.valueOf(temp[6]);
		float c = (1/255f)*Float.valueOf(temp[7]);	
		Display.setInitialBackground(a, b, c);		
		
		Display.create();		
		
	} catch (LWJGLException e) {
		e.printStackTrace();
	}	
}

public static void CleanUp()

{
	Display.destroy();
}

public static void GameLoop()
{	
	inout io = new inout();
	String[] temp = io.read();
	
	Camera cam = new Camera(55, (float)Display.getWidth()/(float)Display.getHeight(), 0.3f, 100);
	
	GameGrid gg = new GameGrid(6, Integer.valueOf(temp[1]));
		while (!Display.isCloseRequested())
		{	
			
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			glLoadIdentity();	
			cam.useView();
			
			gg.Squers();	
			gg.Grid();	
			
			
			boolean rotate_right = Keyboard.isKeyDown(Keyboard.KEY_D);
			boolean rotate_left = Keyboard.isKeyDown(Keyboard.KEY_A);
			boolean restart = Keyboard.isKeyDown(Keyboard.KEY_R);
			
			if(restart)
			{				
				gg.Restart();
				Display.setTitle("XO." + "Сделано ходов: " + gg.x_o + "  | R-restart |");	
			}

			
			if (!gg.win)
			{	

				//Вращение игрового поля вправо влево
				if(rotate_right)
				{
						cam.moveLR(-0.33f,0);	
						cam.rotateY(-2f);
				}
				if(rotate_left)
				{
						cam.moveLR(0.33f,0);
						cam.rotateY(2f);			
				}			
			
				while (Keyboard.next())
				{
				    boolean pressed = Keyboard.getEventKeyState();
				    if(pressed && Keyboard.isKeyDown(Keyboard.KEY_I)) Inter.main(null);	
				    if(pressed && Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) gg.setKeyX(gg.getKeyX()-1);	
				    if(pressed && Keyboard.isKeyDown(Keyboard.KEY_LEFT)) gg.setKeyX(gg.getKeyX()+1);	   
				    if(pressed && Keyboard.isKeyDown(Keyboard.KEY_UP) && !Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) gg.setKeyY(gg.getKeyY()+1);	
				    if(pressed && Keyboard.isKeyDown(Keyboard.KEY_DOWN) && !Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) gg.setKeyY(gg.getKeyY()-1);			    
				    if(pressed && (Keyboard.isKeyDown(Keyboard.KEY_W))) gg.setKeyZ(gg.getKeyZ()+1);	
				    if(pressed && (Keyboard.isKeyDown(Keyboard.KEY_S))) gg.setKeyZ(gg.getKeyZ()-1);
				    
				    if(pressed && Keyboard.isKeyDown(Keyboard.KEY_SPACE)){			    			    	
				    	gg.Turn();	
				    	Display.setTitle("XO." + "Сделано ходов: " + gg.x_o + "  | R-restart |");
				    }			    
				}
			}
			
			if(gg.getWinner() && gg.winner != "Ничья")
				Display.setTitle("Аллиуя! После суровой игры в " + gg.x_o + " ходов, победил - " + gg.winner + "! Поздравляю, дружище!  | R-restart |");
			if( gg.winner == "Ничья")
				Display.setTitle("Ничья, господа! Победила дружба!  | R-restart |");
			
			Display.update();	
			Display.sync(60);								
		}
	

	}

}
