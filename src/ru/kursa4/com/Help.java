package ru.kursa4.com;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Help {

	public Help(final Fon fon)
	{
		//Кнопка назад
				final JButton btnBack = new JButton("");
				final JButton Hack = new JButton("");
				
				Hack .setBounds(0, 0, 350, 500);	
				fon.add(Hack);
				Hack.setIcon(new ImageIcon("res/HelpImg.png"));
				Hack.setBorder(null);
				Hack.setContentAreaFilled(false);
				
				btnBack.setBounds(10, 518, 110, 40);			
				fon.add(btnBack);
				btnBack.setPressedIcon(new ImageIcon("res/Buttons/BackPres.png"));
				btnBack.setIcon(new ImageIcon("res/Buttons/Back.png"));
				btnBack.setBorder(null);
				btnBack.setContentAreaFilled(false);
				btnBack.addMouseListener(new MouseAdapter() {
					
					public void mouseClicked(MouseEvent arg0) {
						
						Hack.setVisible(false);
						 btnBack.setVisible(false);
						MainMenu mm = new MainMenu();
						mm.Start(fon);
								
					}
				});		
	}
	
}
