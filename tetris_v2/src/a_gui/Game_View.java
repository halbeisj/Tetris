package a_gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/***/
public class Game_View extends JFrame implements int_Game_View {
	private KeyListener keyl;
	private int_Game_Model model;
	private int_Game_Controller controller;
	private JLabel nextFigure;
	private JLabel time;
	private JLabel lines;
	private JLabel level;
	private JButton newGame;
	private JButton endGame;
	private JLabel name;
	private JPanel[][] panelHolder;
	
	public Game_View(int_Game_Controller controller) {
		this.controller = controller;
		this.panelHolder = new JPanel[this.controller.getHeight() + 4][this.controller.getWidth() + 7];
		
		this.setBounds(100, 100, this.controller.getWidth() * 50 + 7 * 50, this.controller.getHeight() * 50 + 4 * 50);
		this.setLayout(new GridLayout(this.controller.getHeight() + 4, this.controller.getWidth() + 7));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		for(int i = 0; i < this.controller.getHeight() + 4; i++) {
			for(int y = 0; y < this.controller.getWidth() + 7; y++) {
				this.panelHolder[i][y] = new JPanel();
				this.panelHolder[i][y].setBackground(Color.darkGray);
				this.panelHolder[i][y].setBorder(BorderFactory.createLineBorder(Color.black));
				this.panelHolder[i][y].setOpaque(true);
				this.add(this.panelHolder[i][y]);
			}
		}
		
		for(int i = 0; i < this.panelHolder.length; i++) {
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
		}
		
		for(int i = 0; i < this.panelHolder[0].length; i++) {
			System.out.println(Integer.toString(i));
			this.panelHolder[0][i].setBackground(Color.gray);
			this.panelHolder[0][i].setBorder(null);
			this.panelHolder[1][i].setBackground(Color.gray);
			this.panelHolder[1][i].setBorder(null);
			this.panelHolder[this.controller.getHeight() + 2][i].setBackground(Color.gray);
			this.panelHolder[this.controller.getHeight() + 2][i].setBorder(null);
			this.panelHolder[this.controller.getHeight() + 3][i].setBackground(Color.gray);
			this.panelHolder[this.controller.getHeight() + 3][i].setBorder(null);
		}
		
		this.panelHolder[0][(int) (this.controller.getWidth() / 2 + 3.5)].add(new JLabel("Tetris"));
	}
	
	public void activate() {
		this.setVisible(true);
	}
	
	public void deactivate() {
		this.setVisible(false);
	}
	
	private void reloadModel(){
		
	}
	

}
