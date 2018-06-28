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
 * Repräsentiert ein {@link JFrame}, in dem ein Spiel dargestellt werden kann. 
 * 
 * @author Julia Halbeisen
 * 
 * TODO {@link #model} löschen
 */
public class GameForm extends JFrame implements IGameForm, ActionListener, KeyListener, Observer {
	/**
	 * Die Spielstatistiken.
	 */
	private IGameStatistics model;
	
	/**
	 * Der Controller des Spiels.
	 */
	private IGameController controller;
	
	/**
	 * Label, in welchem die Zeit angezeigt wird.
	 */
	private JLabel timeLabel = new JLabel("0");
	
	/**
	 * Label, in welchem die Anzahl beseitigter Linien angezeigt wird.
	 */
	private JLabel linesLabel = new JLabel("0");
	
	/**
	 * Label, in welchem die Anzahl bestandener Level angezeigt wird.
	 */
	private JLabel levelLabel = new JLabel("0");
	
	/**
	 * Knopf, welcher ein neues Spiel startet.
	 */
	private JButton newGame;
	
	/**
	 * Knopf, welcher das Spiel beendet.
	 */
	private JButton endGameButton;
	
	/**
	 * Das anzuzeigende Spielfeld.
	 */
	private JPanel[][] playground;

	/**
	 * Initialisiert eine neue Instanz der {@link GameForm} Klasse.
	 */
	public GameForm(IGameController controller, IGameStatistics model) {
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(this);
		this.model = model;
		this.controller = controller;
		this.playground = new JPanel[this.controller.getFieldHeight() + 4][this.controller.getFieldWidth() + 8];
		this.newGame = new JButton("New Game");
		this.newGame.addActionListener(this);
		this.endGameButton = new JButton("End Game");
		this.endGameButton.addActionListener(this);

		this.setBounds(100, 100, this.controller.getFieldWidth() * 100 + 8 * 50, this.controller.getFieldHeight() * 100 + 4 * 50);
		this.setLayout(new GridLayout(this.controller.getFieldHeight() + 4, this.controller.getFieldWidth() + 8));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		for (int i = 0; i < this.controller.getFieldHeight() + 4; i++) {
			for (int y = 0; y < this.controller.getFieldWidth() + 8; y++) {
				this.playground[i][y] = new JPanel();
				this.playground[i][y].setBackground(Color.darkGray);
				this.playground[i][y].setBorder(BorderFactory.createLineBorder(Color.black));
				this.playground[i][y].setOpaque(true);
				this.add(this.playground[i][y]);
			}
		}

		for (int i = 0; i < this.playground.length; i++) {
			this.playground[i][0].setBackground(Color.gray);
			this.playground[i][0].setBorder(null);
			this.playground[i][1].setBackground(Color.gray);
			this.playground[i][1].setBorder(null);
			this.playground[i][2].setBackground(Color.gray);
			this.playground[i][2].setBorder(null);
			this.playground[i][this.controller.getFieldWidth() + 3].setBackground(Color.gray);
			this.playground[i][this.controller.getFieldWidth() + 3].setBorder(null);
			this.playground[i][this.controller.getFieldWidth() + 4].setBackground(Color.gray);
			this.playground[i][this.controller.getFieldWidth() + 4].setBorder(null);
			this.playground[i][this.controller.getFieldWidth() + 5].setBackground(Color.gray);
			this.playground[i][this.controller.getFieldWidth() + 5].setBorder(null);
			this.playground[i][this.controller.getFieldWidth() + 6].setBackground(Color.gray);
			this.playground[i][this.controller.getFieldWidth() + 6].setBorder(null);
			this.playground[i][this.controller.getFieldWidth() + 7].setBackground(Color.gray);
			this.playground[i][this.controller.getFieldWidth() + 7].setBorder(null);
		}

		for (int i = 0; i < this.playground[0].length; i++) {
			this.playground[0][i].setBackground(Color.gray);
			this.playground[0][i].setBorder(null);
			this.playground[1][i].setBackground(Color.gray);
			this.playground[1][i].setBorder(null);
			this.playground[this.controller.getFieldHeight() + 2][i].setBackground(Color.gray);
			this.playground[this.controller.getFieldHeight() + 2][i].setBorder(null);
			this.playground[this.controller.getFieldHeight() + 3][i].setBackground(Color.gray);
			this.playground[this.controller.getFieldHeight() + 3][i].setBorder(null);
		}

		this.playground[1][(int) (this.controller.getFieldWidth() / 2 + 3.5)].add(new JLabel("Tetris"));

		this.playground[5][1].add(new JLabel("Name:"));

		this.playground[2][this.controller.getFieldWidth() + 4].add(new JLabel("Next"));

		this.playground[3][this.controller.getFieldWidth() + 4]
				.setBorder(BorderFactory.createMatteBorder(5, 5, 0, 0, Color.black));
		this.playground[4][this.controller.getFieldWidth() + 4]
				.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Color.black));
		this.playground[5][this.controller.getFieldWidth() + 4]
				.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Color.black));
		this.playground[6][this.controller.getFieldWidth() + 4]
				.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 0, Color.black));
		this.playground[6][this.controller.getFieldWidth() + 5]
				.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.black));
		this.playground[6][this.controller.getFieldWidth() + 6]
				.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 5, Color.black));
		this.playground[5][this.controller.getFieldWidth() + 6]
				.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 5, Color.black));
		this.playground[4][this.controller.getFieldWidth() + 6]
				.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 5, Color.black));
		this.playground[3][this.controller.getFieldWidth() + 6]
				.setBorder(BorderFactory.createMatteBorder(5, 0, 0, 5, Color.black));
		this.playground[3][this.controller.getFieldWidth() + 5]
				.setBorder(BorderFactory.createMatteBorder(5, 0, 0, 0, Color.black));

		this.playground[8][this.controller.getFieldWidth() + 4].add(new JLabel("Time:"));
		this.playground[8][this.controller.getFieldWidth() + 5].add(this.timeLabel);
		this.playground[9][this.controller.getFieldWidth() + 4].add(new JLabel("Lines:"));
		this.playground[9][this.controller.getFieldWidth() + 5].add(this.linesLabel);
		this.playground[10][this.controller.getFieldWidth() + 4].add(new JLabel("Level:"));
		this.playground[10][this.controller.getFieldWidth() + 5].add(this.levelLabel);

		this.playground[12][this.controller.getFieldWidth() + 4].add(this.newGame);
		this.playground[14][this.controller.getFieldWidth() + 4].add(this.endGameButton);
	}

	/**
	 * Initialisiert die Spiel-Ansicht.
	 */
	public void activate() {
		this.setVisible(true);
		this.playground[6][1].removeAll();
		this.playground[6][1].add(new JLabel(this.model.getPlayerName()));
		this.reload();
	}

	/**
	 * Aktualisiert die View anhand des {@link #model}s.
	 * 
	 * TODO update
	 */
	private void reload() {
		for (int x = 0; x < this.controller.getFieldWidth(); x++) {
			for (int y = 0; y < this.controller.getFieldHeight(); y++) {
				this.playground[y + 2][x + 3].setBackground(this.model.getPoint(x, y).getColor());
			}
		}
		
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 4; y++) {
				this.playground[y + 3][this.controller.getFieldWidth() + x + 4].setBackground(Color.darkGray);
			}
		}
		
		for (int x = 0; x < this.model.getNextFigureSize().x; x++) {
			for (int y = 0; y < this.model.getNextFigureSize().y; y++) {

				if (this.model.getPointNextFigure(x, y) != null) {
					this.playground[y + 7 - this.model.getNextFigureSize().y][x + this.controller.getFieldWidth() + 4]
							.setBackground(this.model.getPointNextFigure(x, y).getColor());
				}
			}
		}
		
		this.linesLabel.setText(this.model.getLines());
		this.levelLabel.setText(this.model.getLevel());
		this.timeLabel.setText(this.model.getTime());
	}

	/**
	 * Löscht das aktuelle Objekt.
	 */
	public void deactivate() {
		this.dispose();
	}

	/**
	 * Handelt die Events der Buttons.
	 */
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == this.endGameButton) {
			this.controller.endGame();
			this.dispose();
		} else if (ae.getSource() == this.newGame) {
			this.controller.newGame();
			this.setFocusable(true);
			this.requestFocusInWindow();
		}

	}

	/**
	 * Handelt die Evends beim Drücken einer Taste.
	 */
	public void keyPressed(KeyEvent ke) {
	}

	/**
	 * Handelt die Evends beim Loslassen einer Taste.
	 */
	public void keyReleased(KeyEvent ke) {
		if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
			this.controller.down();
		} else if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
			this.controller.right();
		} else if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
			this.controller.left();
		}
	}

	/**
	 * Handelt die Evends beim Tippen einer Taste.
	 */
	public void keyTyped(KeyEvent ke) {
	}

	/**
	 * Handelt ein Update eines überwachbaren Objekts.
	 */
	public void update(Observable arg0, Object arg1) {
		this.reload();
	}
}
