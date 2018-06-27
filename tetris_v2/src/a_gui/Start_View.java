package a_gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Repräsentiert ein Formular, welches beim Spielstart angezeigt wird.
 * 
 * @author Julia Halbeisen
 * @author Dominik Heckendorn
 * @version 1.0
 * */
public class Start_View extends JFrame implements ActionListener{
	/**
	 * Knopf zum Starten des Spiels.
	 */
	private JButton startGame;
	
	/**
	 * Text, welcher oberhalb des Textfeldes angezeigt wird.
	 */
	private JLabel text;
	
	/**
	 * Textfeld, in welchem der Name eingegeben wird.
	 */
	private JTextField guiname;
	
	/**
	 * Controller, an welchen die Befehle und Daten weitergegeben werden.
	 */
	private int_Game_Controller controller;
	
	/**
	 * Initialisiert eine neue Instanz der {@link Start_View} Klasse.
	 * 
	 * @param controller
	 * Controller, an welchen die Befehle und Daten weitergegeben werden.
	 */
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
	
		this.setBounds(100, 100, 700, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	/**
	 * Handelt die Events, welche beim Drücken eines Knopfs ausgeführt werden.
	 * 
	 * @param ae
	 * Die Event-Informationen.
	 */
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == this.startGame) {
			this.controller.setName(this.guiname.getText());
			this.controller.newGame();
			this.dispose();
		}
	}
}
