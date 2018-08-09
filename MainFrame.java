package gui;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class MainFrame extends JFrame implements ActionListener {
	
	private Timer timer;
	private Game game;
	private StartPanel startPanel;
	private CardLayout cards;
	
	private static final long serialVersionUID = -4096437714753423995L;

	MainFrame() {
		super("Animation Demo");
		
		cards = new CardLayout();
		startPanel = new StartPanel();
		game = new Game();
		
		startPanel.setListener(new StartPanelListener() {
			public void startGame() {
				cards.show(MainFrame.this.getContentPane(), "game");
			}
		});
		
		timer = new Timer(20, this);
		
		setSize(600, 500);
		setLayout(cards);
		
		add(startPanel, "start");
		add(game, "game");
		
		timer.start();
		
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		game.update();
	}
}
