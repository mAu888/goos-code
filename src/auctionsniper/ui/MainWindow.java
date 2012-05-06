package auctionsniper.ui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class MainWindow extends  JFrame {
	public static final String MAIN_WINDOW_NAME = "Auction Sniper Main";
	public static final String SNIPER_STATUS_NAME = "sniper status";
	
	public static final String STATUS_JOINING = "Joining";
	public static final String STATUS_LOST = "Lost";
	
	private final JLabel sniperStatus = createLabel(STATUS_JOINING);
	
	public MainWindow() {
		super("Auction Sniper");
		
		setName(MAIN_WINDOW_NAME);
		
		add(sniperStatus);
		pack();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void showStatus(String status) {
		sniperStatus.setText(status);
	}

	private JLabel createLabel(String initialText) {
		JLabel label = new JLabel(initialText);
		label.setName(SNIPER_STATUS_NAME);
		label.setBorder(new LineBorder(Color.BLACK));
		return label;
	}
}
