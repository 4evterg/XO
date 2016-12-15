package ru.kursa4.com;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;

public class Inter extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inter frame = new Inter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inter() {

		setIconImage(Toolkit.getDefaultToolkit().getImage("res/icon.png"));
		setTitle("XO");
		setResizable(false);		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 350, 600);		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Fon fon = new Fon();
		fon.setBounds(0, 0, 344, 572);
		
		contentPane.add(fon);
		fon.setLayout(null);
		
		MainMenu MM = new MainMenu();
		MM.Start(fon);
		
		MM.setVisible(false);
	}
	
	public void Close()
	{	
		System.exit(0);
	}
}
