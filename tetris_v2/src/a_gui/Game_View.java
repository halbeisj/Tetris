package a_gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * In dem Fenster, das diese Klasse darstellt, wird der Spielverlauf angezeigt
 * 
 * @author Julia Halbeisen
 * @author Dominik Heckendorn
 * @version 1.0
 * */
public class Game_View extends JFrame implements int_Game_View, ActionListener, KeyListener, Observer {
	/**
	 * Model aus welchem die Daten geladen werden sollen
	 */
	private int_Game_Model model;
	
	/**
	 * Controller an welchem die Befehle weitergegeben werden sollen
	 */
	private int_Game_Controller controller;
	
	/**
	 * JLabel, in welchem die Zeit angezeigt wird
	 */
	private JLabel time = new JLabel("0");
	
	/**
	 * JLabel in welchem die Anzahl beseitigter Linien angezeigt wird
	 */
	private JLabel lines = new JLabel("0");
	
	/**
	 * JLabel in welchem die Anzahl bestandener Level angezeigt wird
	 */
	private JLabel level = new JLabel("0");
	
	/**
	 * Knopf welcher ein neues Spiel startet
	 */
	private JButton newGame;
	
	/**
	 * Knopf welcher das Spiel beendet (es wird die End_View aufgerufen)
	 * 
	 * @see End_View
	 */
	private JButton endGame;
	
	/**
	 * Ganzes Frame, dem schlussendlich die verschiedenen JLabels hinzugefügt werden (erleichtert Handhabung der Hinzufügung von Content über das GridLayout)
	 */
	private JPanel[][] panelHolder;

	/**
	 * Konstrukter, welcher alle Variabeln konfiguriert und die verschiedenen JLabel und JPanels konfiguriert
	 * 
	 * @param controller Controller, an welchen die Befehle weitergegeben werden sollen
	 * @param model Model aus welchem die Daten geladen werden sollen
	 */
	public Game_View(int_Game_Controller controller, int_Game_Model model) {
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(this);
		this.model = model;
		this.controller = controller;
		this.panelHolder = new JPanel[this.controller.getHeight() + 4][this.controller.getWidth() + 8];
		this.newGame = new JButton("New Game");
		this.newGame.addActionListener(this);
		this.endGame = new JButton("End Game");
		this.endGame.addActionListener(this);

		this.setBounds(100, 100, this.controller.getWidth() * 100 + 8 * 50, this.controller.getHeight() * 100 + 4 * 50);
		this.setLayout(new GridLayout(this.controller.getHeight() + 4, this.controller.getWidth() + 8));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		for (int i = 0; i < this.controller.getHeight() + 4; i++) {
			for (int y = 0; y < this.controller.getWidth() + 8; y++) {
				this.panelHolder[i][y] = new JPanel();
				this.panelHolder[i][y].setBackground(Color.darkGray);
				this.panelHolder[i][y].setBorder(BorderFactory.createLineBorder(Color.black));
				this.panelHolder[i][y].setOpaque(true);
				this.add(this.panelHolder[i][y]);
			}
		}

		for (int i = 0; i < this.panelHolder.length; i++) {
			this.panelHolder[i][0].setBackground(Color.gray);
			this.panelHolder[i][0].setBorder(null);
			this.panelHolder[i][1].setBackground(Color.gray);
			this.panelHolder[i][1].setBorder(null);
			this.panelHolder[i][2].setBackground(Color.gray);
			this.panelHolder[i][2].setBorder(null);
			this.panelHolder[i][this.controller.getWidth() + 3].setBackground(Color.gray);
			this.panelHolder[i][this.controller.getWidth() + 3].setBorder(null);
			this.panelHolder[i][this.controller.getWidth() + 4].setBackground(Color.gray);
			this.panelHolder[i][this.controller.getWidth() + 4].setBorder(null);
			this.panelHolder[i][this.controller.getWidth() + 5].setBackground(Color.gray);
			this.panelHolder[i][this.controller.getWidth() + 5].setBorder(null);
			this.panelHolder[i][this.controller.getWidth() + 6].setBackground(Color.gray);
			this.panelHolder[i][this.controller.getWidth() + 6].setBorder(null);
			this.panelHolder[i][this.controller.getWidth() + 7].setBackground(Color.gray);
			this.panelHolder[i][this.controller.getWidth() + 7].setBorder(null);
		}

		for (int i = 0; i < this.panelHolder[0].length; i++) {
			this.panelHolder[0][i].setBackground(Color.gray);
			this.panelHolder[0][i].setBorder(null);
			this.panelHolder[1][i].setBackground(Color.gray);
			this.panelHolder[1][i].setBorder(null);
			this.panelHolder[this.controller.getHeight() + 2][i].setBackground(Color.gray);
			this.panelHolder[this.controller.getHeight() + 2][i].setBorder(null);
			this.panelHolder[this.controller.getHeight() + 3][i].setBackground(Color.gray);
			this.panelHolder[this.controller.getHeight() + 3][i].setBorder(null);
		}

		this.panelHolder[1][(int) (this.controller.getWidth() / 2 + 3.5)].add(new JLabel("Tetris"));

		this.panelHolder[5][1].add(new JLabel("Name:"));

		this.panelHolder[2][this.controller.getWidth() + 4].add(new JLabel("Next"));

		this.panelHolder[3][this.controller.getWidth() + 4]
				.setBorder(BorderFactory.createMatteBorder(5, 5, 0, 0, Color.black));
		this.panelHolder[4][this.controller.getWidth() + 4]
				.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Color.black));
		this.panelHolder[5][this.controller.getWidth() + 4]
				.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Color.black));
		this.panelHolder[6][this.controller.getWidth() + 4]
				.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 0, Color.black));
		this.panelHolder[6][this.controller.getWidth() + 5]
				.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.black));
		this.panelHolder[6][this.controller.getWidth() + 6]
				.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 5, Color.black));
		this.panelHolder[5][this.controller.getWidth() + 6]
				.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 5, Color.black));
		this.panelHolder[4][this.controller.getWidth() + 6]
				.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 5, Color.black));
		this.panelHolder[3][this.controller.getWidth() + 6]
				.setBorder(BorderFactory.createMatteBorder(5, 0, 0, 5, Color.black));
		this.panelHolder[3][this.controller.getWidth() + 5]
				.setBorder(BorderFactory.createMatteBorder(5, 0, 0, 0, Color.black));

		this.panelHolder[8][this.controller.getWidth() + 4].add(new JLabel("Time:"));
		this.panelHolder[8][this.controller.getWidth() + 5].add(this.time);
		this.panelHolder[9][this.controller.getWidth() + 4].add(new JLabel("Lines:"));
		this.panelHolder[9][this.controller.getWidth() + 5].add(this.lines);
		this.panelHolder[10][this.controller.getWidth() + 4].add(new JLabel("Level:"));
		this.panelHolder[10][this.controller.getWidth() + 5].add(this.level);

		this.panelHolder[12][this.controller.getWidth() + 4].add(this.newGame);
		this.panelHolder[14][this.controller.getWidth() + 4].add(this.endGame);
	}

	/**
	 * Methode, welche das Fenster sichtbar macht und den Namen konfiguriert
	 * Das Model wird zum ersten Mal neu geladen und der Name wird gesetzt
	 * 
	 * @see int_Game_Model
	 */
	public void activate() {
		this.setVisible(true);
		this.panelHolder[6][1].removeAll();
		this.panelHolder[6][1].add(new JLabel(this.model.getName()));
		this.reloadModel();
	}

	/**
	 * Methode, welche das Fenster unsichtbar macht und zerstört
	 */
	public void deactivate() {
		this.dispose();
	}

	/**
	 * Methode, welche das Model neu in die View lädt
	 */
	private void reloadModel() {
		for (int x = 0; x < this.controller.getWidth(); x++) {
			for (int y = 0; y < this.controller.getHeight(); y++) {
				this.panelHolder[y + 2][x + 3].setBackground(this.model.getPoint(x, y).getColor());
			}
		}
		this.reloadNextFigure();
	}

	/**
	 * Methode, welche die nächste Figur vom Model in die View lädt
	 * 
	 * @see int_Game_Model
	 * @see Point_DTO
	 */
	private void reloadNextFigure() {
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 4; y++) {
				this.panelHolder[y + 3][this.controller.getWidth() + x + 4].setBackground(Color.darkGray);
			}
		}
		for (int x = 0; x < this.model.getNextFigureSize().x; x++) {
			for (int y = 0; y < this.model.getNextFigureSize().y; y++) {

				if (this.model.getPointNextFigure(x, y) != null) {
					this.panelHolder[y + 7 - this.model.getNextFigureSize().y][x + this.controller.getWidth() + 4]
							.setBackground(this.model.getPointNextFigure(x, y).getColor());
				}
			}
		}
	}

	/**
	 * Prüft ob Knöpfe gedrückt wurden
	 * endGame -> Spiel wird beendet
	 * newGame -> Spiel wird neu gestartet
	 * 
	 * @see int_Game_Controller
	 */
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == this.endGame) {
			this.controller.endGame();
			this.dispose();
		} else if (ae.getSource() == this.newGame) {
			this.controller.newGame();
			this.setFocusable(true);
			this.requestFocusInWindow();
		}

	}

	/**
	 * Prüft ob Knöpfe gedrückt wurden
	 * Pfeil nach unten -> Figur wird nach unten verschoben
	 * Pfeil nach rechts -> Figur wird nach rechts verschoben
	 * Pfeil nach links -> Figur wird nach links verschoben
	 * 
	 * @see int_Game_Controller
	 */
	public void keyPressed(KeyEvent ke) {
	}

	public void keyReleased(KeyEvent ke) {
		if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
			this.controller.down();
		} else if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
			this.controller.right();
		} else if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
			this.controller.left();
		}

	}

	public void keyTyped(KeyEvent ke) {
	}

	/**
	 * Wird ausgeführt, wenn ein überwachte Klasse notifyObservers aufruft
	 * Model wird neu in die View geladen
	 * 
	 * @see int_Game_Model
	 */
	public void update(Observable arg0, Object arg1) {
		this.reloadModel();
		this.lines.setText(this.model.getLines());
		this.level.setText(this.model.getLevel());
		this.time.setText(this.model.getTime());
	}

}
