package ru.kursa4.com;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class inout {
	
	private String[] value = new String[14];
	private String[] read = new String[14];
	
	public void write(String[] temp)
	{	
		value = temp;
		PrintWriter pw = null;
		 try
	        {
			 pw = new PrintWriter(new FileOutputStream("settings.txt"));
	        }
	          catch(FileNotFoundException e)
	        {
	              System.out.println("Ошибка открытия файла settings.txt");
	             System.exit(0);
	         }
		 
		for (int i =0; i<this.value.length; i++)
		{  
			if (i == this.value.length -1 )
				pw.print(this.value[i]);	
			else
	          pw.println(this.value[i]);	         
		}
		 	 pw.flush();
	         pw.close();                
	}

	public String[] read()
	{
		BufferedReader fr = null;
		try {
			fr = new BufferedReader(new FileReader("settings.txt"));
		} catch (FileNotFoundException e) {			
            System.out.println("Ошибка открытия файла settings.txt");
           System.exit(0);
		}
		
		try {
			for (int i = 0 ; i < this.value.length; i++)
			{
					this.read[i] = fr.readLine();

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {			
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return this.read;
	}
	
	
}
