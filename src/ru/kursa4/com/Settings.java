package ru.kursa4.com;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Settings {


private JFormattedTextField textField_G = new JFormattedTextField(new Double(0));//текстбокс для зеленого канала
private JFormattedTextField textField_R = new JFormattedTextField(new Double(0));//текстбокс для красного канала
private JFormattedTextField textField_B = new JFormattedTextField(new Double(0));//текстбокс для синешл канала
private int count_colors;
private int count_sizes;	
private boolean check_YN;
private String [] temp = new String [14];
private boolean d = true;

//класс для работы с нашим файлом настроек :З
final inout io = new inout();

	//Из текстового файла передаём начальные значения полям
	public Settings()
	{
		if (d)
		{
			temp = io.read();
			for (int i = 0; i<temp.length; i++)
				System.out.println(temp[i]);
		}

		 count_sizes = Integer.valueOf(temp[1]);
		 count_colors = 0;
			
		 //Загружаем значение режима диагоналей
		 if(Integer.valueOf(temp[0]) == 0)			
			 check_YN = false;
		 else check_YN = true;		 
	}	
	
	public void RunSet(final Fon fon)
	{	
				
//--------------------------------------------ДЕКОРАТИВНАЯ ЧАСТЬ-----------------------------------------------------------------	
		
		
		//надпись "Размер поля"
		final JButton CubeSize = new JButton("");
		//надпись "с диагоалями?"
		final JButton diagonals = new JButton("");
		//надпись "цвет"
		final JButton Colorr = new JButton("");
		
		//буква R
		final JButton R = new JButton("");
		//буква G
		final JButton G = new JButton("");
		//буква B
		final JButton B = new JButton("");		
				

		//настройка CubeSize	
				CubeSize.setIcon(new ImageIcon("res/Settings/CubeSize.png"));
				CubeSize.setBorder(null);
				CubeSize.setContentAreaFilled(false);
				CubeSize.setBounds(13, 182, 200, 54);
				fon.add(CubeSize);
				
	    //настройка Diagonals
				diagonals.setIcon(new ImageIcon("res/Settings/diagonals.png"));
				diagonals.setBounds(13, 247, 240, 80);
				diagonals.setBorder(null);
				diagonals.setContentAreaFilled(false);
				fon.add(diagonals);

				
	   //настройка	Color
				Colorr.setSelectedIcon(new ImageIcon("res/Settings/COLOR.png"));
				Colorr.setIcon(new ImageIcon("res/Settings/COLOR.png"));
				Colorr.setBounds(13, 11, 120, 60);
				Colorr.setBorder(null);
				Colorr.setContentAreaFilled(false);
				fon.add(Colorr);			

			
		//настройки буквы R
				R.setIcon(new ImageIcon("res/Settings/R.png"));
				R.setBounds(39, 80, 60, 60);
				R.setBorder(null);
				R.setContentAreaFilled(false);
				fon.add(R);
				
		//настройки буквы  G
				G.setIcon(new ImageIcon("res/Settings/G.png"));
				G.setBounds(109, 82, 60, 60);
				G.setBorder(null);
				G.setContentAreaFilled(false);
				fon.add(G);
				
		//настройки буквы B
				B.setIcon(new ImageIcon("res/Settings/B.png"));
				B.setBounds(179, 80, 60, 60);
				B.setBorder(null);
				B.setContentAreaFilled(false);
				fon.add(B);
				
				
				
//----------------------------------------ФУНКЦИОНАЛЬНАЯ ЧАСТЬ-----------------------------------------------------------------
				

				
				
				//Кнопка назад
				final JButton btnBack = new JButton("");
				//кнопка задающая размер поля
				final JButton size = new JButton("");
				//Кнопка ДАНЕТ (диагонали)
				final JButton diag_yes_no = new JButton("");
				//Надпись "куб"
				final JButton cubeselect = new JButton("");
				

				
				//настройка Cubeselect
				cubeselect.setIcon(new ImageIcon("res/Settings/color1.png"));
				cubeselect.setSelectedIcon(new ImageIcon("res/Settings/color1.png"));
				cubeselect.setBounds(132, 10, 120, 60);
				cubeselect.setContentAreaFilled(false);
				cubeselect.setBorder(null);	
				fon.add(cubeselect);
				cubeselect.addMouseListener(new MouseAdapter() {
					
					public void mouseClicked(MouseEvent arg0) {
						count_colors++;
											  
						if(count_colors == 4)
							count_colors = 0;
						
						  textField_R.setValue(new Float(temp[2+(3*count_colors)]));
						  textField_G.setValue(new Float(temp[3+(3*count_colors)]));
						  textField_B.setValue(new Float(temp[4+(3*count_colors)]));
						  
						cubeselect.setIcon(new ImageIcon("res/Settings/color" + count_colors +".png"));				
					}
				});	
				

				
				//настройка кнопки ДАНЕТ (диагонали)
				if(check_YN  == true)
				diag_yes_no.setIcon(new ImageIcon("res/Settings/Yes.png"));
				else diag_yes_no.setIcon(new ImageIcon("res/Settings/No.png"));
				diag_yes_no.setBounds(250, 253, 60, 60);
				diag_yes_no.setBorder(null);
				diag_yes_no.setContentAreaFilled(false);
				
				diag_yes_no.addMouseListener(new MouseAdapter() {					
					public void mouseClicked(MouseEvent arg0) {
						if(check_YN  == true)
							{						
							diag_yes_no.setIcon(new ImageIcon("res/Settings/No.png"));
							check_YN = false;
							//io.write("0", 0);
							temp[0] = "0";
							}
						else
							{
							diag_yes_no.setIcon(new ImageIcon("res/Settings/Yes.png"));
							check_YN = true;
							//io.write("1", 0);
							temp[0] = "1";
							}
					}
				});					
				fon.add(diag_yes_no);
				
				//настройка Size			
				size.setIcon(new ImageIcon("res/Settings/size" + count_sizes + ".png"));
				size.setBounds(250, 182, 60, 60);
				size.setBorder(null);
				size.setContentAreaFilled(false);
				fon.add(size);
				size.addMouseListener(new MouseAdapter() {
					
					public void mouseClicked(MouseEvent arg0) {						
						count_sizes++;
						if(count_sizes >= 6)
							count_sizes = 3;
						size.setIcon(new ImageIcon("res/Settings/size" + (count_sizes) +".png"));	
						temp[1] = String.valueOf(count_sizes);
					}
				});	
				
				//настройка "красного тексбокса"
				textField_R.setValue(new Double(temp[2]));
				textField_R.setBorder(null);
				textField_R.setColumns(10);
				textField_R.setBounds(40, 135, 60, 20);
				fon.add(textField_R);
				textField_R.addFocusListener(new FocusAdapter() {
					@Override
					public void focusLost(FocusEvent arg0) {
						if(Integer.valueOf(textField_R.getText()) > 255)
							textField_R.setValue(new Double("255"));
						if(Integer.valueOf(textField_R.getText()) < 0)
							textField_R.setValue(new Double("0"));
						temp[(2+(3*count_colors))] = textField_R.getText();
					}
				});
				
				//настройка "зеленого тексбокса"				
				textField_G.setValue(new Double(temp[3]));	
				textField_G.setBorder(null);			
				textField_G.setColumns(10);				
				textField_G.setBounds(110, 135, 60, 20);
				fon.add(textField_G);
				textField_G.addFocusListener(new FocusAdapter() {
					@Override
					public void focusLost(FocusEvent arg0) {	
						if(Integer.valueOf(textField_G.getText()) > 255)
							textField_G.setValue(new Double("255"));
						if(Integer.valueOf(textField_G.getText()) < 0)
							textField_G.setValue(new Double("0"));
						temp[(3+(3*count_colors))] = textField_G.getText();
					}
				});
				
				//настройка "синего тексбокса"		
				textField_B.setValue(new Double(temp[4]));	
				textField_B.setBorder(null);
				textField_B.setColumns(10);
				textField_B.setBounds(180, 135, 60, 20);
				fon.add(textField_B);
				textField_B.addFocusListener(new FocusAdapter() {
					@Override
					public void focusLost(FocusEvent arg0) {
						if(Integer.valueOf(textField_B.getText()) > 255)
							textField_B.setValue(new Double("255"));
						if(Integer.valueOf(textField_B.getText()) < 0)
							textField_B.setValue(new Double("0"));
						temp[(4+(3*count_colors))] = textField_B.getText();
					}
				});
				
				//Настройки "назад"
				btnBack.setBounds(10, 518, 110, 40);			
				fon.add(btnBack);
				btnBack.setPressedIcon(new ImageIcon("res/Buttons/BackPres.png"));
				btnBack.setIcon(new ImageIcon("res/Buttons/Back.png"));
				btnBack.setBorder(null);
				btnBack.setContentAreaFilled(false);
				btnBack.addMouseListener(new MouseAdapter() {
					
					public void mouseClicked(MouseEvent arg0) {
						io.write(temp);							
							
						cubeselect.setVisible(false);
						CubeSize.setVisible(false);
						diagonals.setVisible(false);
						Colorr.setVisible(false);
						R.setVisible(false);
						G.setVisible(false);
						B.setVisible(false);
						diag_yes_no.setVisible(false);
						size.setVisible(false);
						textField_R.setVisible(false);
						textField_G.setVisible(false);
						textField_B.setVisible(false);
						btnBack.setVisible(false);					
						
						MainMenu mm = new MainMenu();
						mm.Start(fon);
								
					}
				});	
	}
}
