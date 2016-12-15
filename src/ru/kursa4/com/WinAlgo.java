package ru.kursa4.com;

public class WinAlgo {

	private byte[][][] Turns;
	
	public boolean lock;
	
	inout io = new inout();
	String[] temp = io.read();
	
	public WinAlgo(byte[][][] Turns, boolean lock)
	{
		this.Turns = Turns;	
		this.lock = lock; 
	}
	
	public boolean isitdraw()
	{
		int count = 0;
		boolean answer = false;
		for (int i = 0; i<Turns.length; i++)
			for (int t = 0; t<Turns.length; t++)
				for (int c = 0; c<Turns.length; c++)
					if(Turns[i][t][c] != 0)
						count++;
		if (count == (Integer.valueOf(temp[1])*Integer.valueOf(temp[1])*Integer.valueOf(temp[1])))
				answer = true;
		return answer;
	}
	
	public boolean Winneris()
	{
		
		boolean win = false;
		
		//i <3 циклы 
		for (byte i = 1; i<3; i++)
		{
			for (byte a = 0; a< Turns.length; a++)
			{
				for (byte b = 0; b< Turns.length; b++)
				{
					byte [] counts = new byte [13];					
					
					for (byte x = 0; x< counts.length; x++)
						counts[x] = 0;
					
					byte t = (byte)(Turns.length-1);
					
					for (byte c = 0; c<Turns.length; c++)
					{
						//Проверка линий------------------------------------------------------------------
						//Проверка линий по игрикам
						if (Turns[a][b][c] == i)
						{							
							counts[0]++;
							if (counts[0] == Turns.length)
							{
								win = true;	
								break;									
							}
						}
						
						//Проверка линий по иксам
						if (Turns[c][b][a] == i)
						{
							counts[1]++;
							if (counts[1] == Turns.length)
							{
								win = true;	
								break;
							}
						}
						
						//Проверка линий по зетам
						if (Turns[b][c][a] == i)
						{
							counts[2]++;
							if (counts[2] == Turns.length)
							{
								win = true;	
								break;
							}
						}
						
						if(Integer.valueOf(temp[0]) == 1)
						{
						//Проверка диагоналей------------------------------------------------------------
						//Проверка главной диагонали плоскости икс
						if (Turns[c][c][b] == i)
						{
							counts[3]++;
							if (counts[3] == Turns.length)
							{
								win = true;	
								break;
							}
						}
						
						//Проверка побочной диагонали плоскости икс
						if (Turns[t][c][b] == i)
						{
							counts[4]++;
							if (counts[4] == Turns.length)
							{
								win = true;	
								break;
							}
						}
						
						//Проверка главной диагонали плоскости зет
						if (Turns[b][c][c] == i)
						{
							counts[5]++;
							if (counts[5] == Turns.length)
							{
								win = true;	
								break;
							}
						}
						
						//Проверка побочной диагонали плоскости зет
						if (Turns[b][c][t] == i)
						{
							counts[6]++;
							if (counts[6] == Turns.length)
							{
								win = true;	
								break;
							}
						}
						
						//Проверка главной диагонали плоскости игрек 
						if (Turns[c][b][c] == i)
						{
							counts[7]++;
							if (counts[7] == Turns.length)
							{
								win = true;	
								break;
							}
						}
						
						//Проверка побочной диагонали плоскости игрек 
						if (Turns[t][b][c] == i)
						{						
							counts[8]++;
							if (counts[8] == Turns.length)
							{
								win = true;	
								break;
							}
						}
						
						//Проверка нижней побочной диагонали куба
						if (Turns[c][c][c] == i)
						{					
							counts[9]++;
							if (counts[9] == Turns.length)
							{
								win = true;	
								break;
							}
						}
						
						//Проверка побочной диагонали куба
						if (Turns[t][c][t] == i)
						{
							counts[10]++;
							if (counts[10] == Turns.length)
							{
								win = true;	
								break;
							}
						}
						
						//Проверка главной диагонали куба
						if (Turns[t][t][c] == i)
						{
							counts[11]++;
							if (counts[11] == Turns.length)
							{
								win = true;	
								break;
							}
						}
						
						//Проверка главной нижней диагонали куба
						if (Turns[c][t][t] == i)
						{
							counts[12]++;
							if (counts[12] == Turns.length)
							{
								win = true;	
								break;
							}
						}
						
						}
						
						if (win == true)
							this.lock = true;
						
						t--;						
					}					
				}				
			}				
		}							
		return win;	
	}
}
