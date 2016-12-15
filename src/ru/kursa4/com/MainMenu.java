package ru.kursa4.com;


import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenu extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void Start(final Fon fon)
	{
		
		//Кнопка - новая игра
		final JButton newGame = new JButton("");
		//Кнопка - настройки
		final JButton settings = new JButton("");
		//Кнопка - помощь 
		final JButton help = new JButton("");
		//Кнопка - выход
		final JButton exit = new JButton("");
		//"О программе"
		final JButton about = new JButton("");	
		


		//чуток эксперементов 
		//exit.setBorder(BorderFactory.createMatteBorder(1, 10, 1, 1, SystemColor.BLUE));
		//exit.setBorder(BorderFactory.createLineBorder(SystemColor.BLACK));
		
		
		//Настройки "Новая игра"	
		newGame.setBounds(75, 50, 200, 100);
		fon.add(newGame);
		newGame.setPressedIcon(new ImageIcon("res/Buttons/NewGameBtnPres.png"));
		
				newGame.setSelectedIcon(new ImageIcon("res/Buttons/NewGameBtnPres.png"));
				newGame.setIcon(new ImageIcon("res/Buttons/NewGameBtn.png"));
				newGame.setBorder(null);
				newGame.setContentAreaFilled(false);
	newGame.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		Inter i = new Inter();
		i.setVisible(false);
		
		//Process theProcess = null;
		
		//try {
		//	theProcess  = Runtime.getRuntime().exec("java -jar I:/Stuff/Java/Workspace/Kursa4/res/Game/Game.jar ru.kursa4.Main");
	//	} catch (IOException e) {
			// TODO Auto-generated catch block
	//		e.printStackTrace();
	//	}
		
	Main.main(null);
	//Main.initDisplay();
	//Main.GameLoop();
	//Main.CleanUp();	
	}
	});
	
	//Настройки "Помощь" :D	
	help.setBounds(75, 151, 200, 100);
	fon.add(help);
	help.setPressedIcon(new ImageIcon("res/Buttons/HelpPres.png"));
	help.setIcon(new ImageIcon("res/Buttons/Help.png"));
	help.setBorder(null);	
	help.setContentAreaFilled(false);
	help.addMouseListener(new MouseAdapter() {
		
		public void mouseClicked(MouseEvent arg0) {
			
			help.setVisible(false);
			settings.setVisible(false);
			exit.setVisible(false);
			newGame.setVisible(false);
			about.setVisible(false);
			Help h = new Help(fon);
			
		}
	});
	
	//Настройки "Настройки" :D	
	settings.setBounds(64, 280, 200, 100);
	fon.add(settings);
	settings.setBorder(null);
	settings.setContentAreaFilled(false);
	settings.setPressedIcon(new ImageIcon("res/Buttons/SettingsBtnPres.png"));
	settings.setIcon(new ImageIcon("res/Buttons/SettingsBtn.png"));
	settings.addMouseListener(new MouseAdapter() {
		
		public void mouseClicked(MouseEvent arg0) {
			
			help.setVisible(false);
			settings.setVisible(false);
			exit.setVisible(false);
			newGame.setVisible(false);
			about.setVisible(false);
			Settings s = new Settings();
			s.RunSet(fon);
		}
	});

	//Настройки "Выход"		
	exit.setBounds(64, 419, 200, 100);
	fon.add(exit);
	exit.setIcon(new ImageIcon("res/Buttons/ExitBtn.png"));
	exit.setPressedIcon(new ImageIcon("res/Buttons/ExitBtnPres.png"));
	exit.setContentAreaFilled(false);
	exit.setBorder(null);
	exit.addMouseListener(new MouseAdapter() {
		
		public void mouseClicked(MouseEvent arg0) {
			Inter i = new Inter();
			i.Close();
		}
	});
	
	
	//Настройки "О программе" :D		
	fon.add(about);
	about.setBounds(240, 530, 110, 40);
	about.setPressedIcon(new ImageIcon("res/Buttons/AboutPres.png"));	
	about.setIcon(new ImageIcon("res/Buttons/About.png"));
	about.setBorder(null);
	about.setContentAreaFilled(false);
	about.addMouseListener(new MouseAdapter() {
		
		public void mouseClicked(MouseEvent arg0) {
			
			help.setVisible(false);
			settings.setVisible(false);
			exit.setVisible(false);
			newGame.setVisible(false);
			about.setVisible(false);
			
			About abt = new About(fon);
			
		}
	});
	
		}
	
		
	}
	

