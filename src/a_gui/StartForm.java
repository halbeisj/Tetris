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
public class StartForm extends JFrame implements ActionListener{
	/**
	 * Knopf zum Starten des Spiels.
	 */
	private JButton startGameButton;
	
	/**
	 * Text, welcher oberhalb des Textfeldes angezeigt wird.
	 */
	private JLabel playerNameLabel;
	
	/**
	 * Textfeld, in welchem der Name eingegeben wird.
	 */
	private JTextField playerNameTextBox;
	
	/**
	 * Controller, an welchen die Befehle und Daten weitergegeben werden.
	 */
	private IGameController controller;
	
	/**
	 * Initialisiert eine neue Instanz der {@link StartForm} Klasse.
	 * 
	 * @param controller
	 * Controller, an welchen die Befehle und Daten weitergegeben werden.
	 */
	public StartForm(IGameController controller) {
		this.startGameButton = new JButton("Spiel starten");
		this.playerNameLabel = new JLabel("Geben Sie bitte Ihren Namen ein!");
		this.playerNameTextBox = new JTextField("Name");
		this.controller = controller;
		
		this.startGameButton.addActionListener(this);
		this.setLayout(new BorderLayout());
		
		this.add(startGameButton, BorderLayout.SOUTH);
		this.add(this.playerNameLabel, BorderLayout.NORTH);
		this.add(this.playerNameTextBox, BorderLayout.CENTER);
	
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
		if(ae.getSource() == this.startGameButton) {
			this.controller.setPlayerName(this.playerNameTextBox.getText());
			this.controller.newGame();
			this.dispose();
		}
	}
}
