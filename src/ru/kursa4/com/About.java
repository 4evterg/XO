package ru.kursa4.com;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class About extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public About(final Fon fon) {
		
		setBorder(null);
		setBounds(100, 100, 350, 600);
		
		//Кнопка назад
		final JButton btnBack = new JButton("");
		final JButton Hack = new JButton("");
		
		Hack .setBounds(0, 0, 350, 500);	
		fon.add(Hack);
		Hack .setIcon(new ImageIcon("res/Titul.png"));
		Hack .setBorder(null);
		Hack .setContentAreaFilled(false);
		
		//Настройка "назад"
		btnBack.setBounds(10, 518, 110, 40);			
		fon.add(btnBack);
		btnBack.setPressedIcon(new ImageIcon("res/Buttons/BackPres.png"));
		btnBack.setIcon(new ImageIcon("res/Buttons/Back.png"));
		btnBack.setBorder(null);
		btnBack.setContentAreaFilled(false);
		btnBack.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				
				 btnBack.setVisible(false);
				 Hack.setVisible(false);
				MainMenu mm = new MainMenu();
				mm.Start(fon);
						
			}
		});
	}

}
