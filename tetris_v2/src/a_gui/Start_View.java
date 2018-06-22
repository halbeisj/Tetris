package a_gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**Diese Klasse dient dazu einen  beliebigen Spielernamen einzugeben und das Spiel mit einem Button zu starten.
 * 
 * @author Julia Halbeisen
 * @author Dominik Heckendorn
 * @version 1.0
 * */
public class Start_View extends JFrame implements ActionListener{
	private String strname;
	private JButton startGame;
	private JLabel text;
	private JTextField guiname;
	private int_Game_Controller controller;
	
	public Start_View(int_Game_Controller controller) {
		this.startGame = new JButton("Spiel starten");
		this.text = new JLabel("Geben Sie bitte Ihren Namen ein!");
		this.guiname = new JTextField("Name");
		this.controller = controller;
		
		this.startGame.addActionListener(this);
		this.setLayout(new BorderLayout());
		
		this.add(startGame, BorderLayout.SOUTH);
		this.add(this.text, BorderLayout.NORTH);
		this.add(this.guiname, BorderLayout.CENTER);
		
		this.setSize(100, 100);
		this.setBounds(100, 100, 700, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == this.startGame) {
			this.controller.setName(this.guiname.getText());
			this.controller.newGame();
			this.dispose();
		}
	}
}
