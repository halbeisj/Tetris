package a_gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**Diese Klasse wird aufgerufen, wenn man das Spiel beendet oder verloren hat. 
 * Die Klasse bestitzt einen exit Button und einen Button um das Spiel nochmals neuzustarten.
 * 
 * @author Julia Halbeisen
 * @author Dominik Heckendorn
 * @version 1.0
 * */
public class End_View extends JFrame implements ActionListener {
	private JButton repeatGame;
	private JButton exit;
	private JPanel south;
	private Game_Controller controller;

	
	public End_View(Game_Controller controller) {
		this.controller = controller;
		
		this.setLayout(new BorderLayout());
		this.repeatGame = new JButton("Repeat Game");
		this.exit = new JButton("Exit");
		this.south = new JPanel();
		this.south.setLayout(new GridLayout(1, 2));
		
		this.add(new JLabel("You failed!"), BorderLayout.NORTH);
		this.add(this.south, BorderLayout.SOUTH);
		
		this.south.add(this.repeatGame);
		this.south.add(this.exit);
		
		this.repeatGame.addActionListener(this);
		this.exit.addActionListener(this);
		
		this.setBounds(100, 100, 700, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == this.exit) {
			System.exit(0);
		}
		else if(ae.getSource() == this.repeatGame) {
			this.dispose();
			this.controller.newGame();
		}
	}
	
	
}
