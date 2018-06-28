package a_gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Repräsentiert ein "Game Over"-Fenster.
 * 
 * @author Julia Halbeisen
 */
public class GameOverForm extends JFrame implements ActionListener {
	/**
	 * Der Button um ein neues Spiel zu starten.
	 */
	private JButton newGameButton;
	
	/**
	 * Der Button um das Spiel zu verlassen.
	 */
	private JButton exitButton;
	
	/**
	 * DasPanel, welches die Buttons beinhaltet.
	 */
	private JPanel panel;

	/**
	 * Ein Objekt, um das Spiel zu steuern.
	 */
	private GameController controller;

	/**
	 * Variablen werden konfiguriert, Fenster wird aufgerufen.
	 * 
	 * @param controller
	 * Controller, welcher dieses Objekt erstellt hat.
	 */
	public GameOverForm(GameController controller) {
		this.controller = controller;

		this.setLayout(new BorderLayout());
		this.newGameButton = new JButton("Repeat Game");
		this.exitButton = new JButton("Exit");
		this.panel = new JPanel();
		this.panel.setLayout(new GridLayout(1, 2));

		this.add(new JLabel("You failed!"), BorderLayout.NORTH);
		this.add(this.panel, BorderLayout.SOUTH);

		this.panel.add(this.newGameButton);
		this.panel.add(this.exitButton);

		this.newGameButton.addActionListener(this);
		this.exitButton.addActionListener(this);

		this.setBounds(100, 100, 700, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	/**
	 * Wenn Exit-Knopf gedrückt wird -> Spiel wird beendet. Wenn Repeat-Knopf.
	 * gedrückt wird -> Fenser wird ausgeblendet, Game wird neugestartet.
	 */
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == this.exitButton) {
			System.exit(0);
		} else if (ae.getSource() == this.newGameButton) {
			this.dispose();
			this.controller.newGame();
		}
	}
}
