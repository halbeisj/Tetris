package a_gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Diese Klasse dient dazu einen  beliebigen Spielernamen einzugeben und das Spiel mit einem Button zu starten.
 * 
 * @author Julia Halbeisen
 * @author Dominik Heckendorn
 * @version 1.0
 * */
public class Start_View extends JFrame implements ActionListener{
	/**
	 * Knopf mit welchem das Spiel gestartet wird
	 */
	private JButton startGame;
	
	/**
	 * Text, welcher oberhalb des Textfeldes angezeigt wird
	 */
	private JLabel text;
	
	/**
	 * Textfeld, in welchem der Name eingegeben wird
	 */
	private JTextField guiname;
	
	/**
	 * Controller, an welchen die Befehle und Daten weitergegeben werden
	 */
	private int_Game_Controller controller;
	
	/**
	 * Konstruktor, welcher die Variablen konfiguriert
	 * Added den ActionListener
	 * Macht das Fenster sichtbar
	 * 
	 * @param controller Controller, an welchen die Befehle und Daten weitergegeben werden
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
	 * Wenn ein Knopf gedrückt wird, wird diese Methode aufgerufen
	 * startGame -> Game wird gestartet
	 * 
	 * @param ae ActionEvent, mit welchem die Methode aufgerufen wird
	 * 
	 * @see int_Game_Controller
	 */
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == this.startGame) {
			this.controller.setName(this.guiname.getText());
			this.controller.newGame();
			this.dispose();
		}
	}
}
