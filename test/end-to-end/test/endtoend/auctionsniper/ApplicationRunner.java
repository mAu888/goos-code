package test.endtoend.auctionsniper;

import auctionsniper.*;
import auctionsniper.ui.MainWindow;

import static test.endtoend.auctionsniper.FakeAuctionServer.XMPP_HOSTNAME;
import static auctionsniper.ui.MainWindow.*;

public class ApplicationRunner {
	public static final String SNIPER_ID = "sniper";
	public static final String SNIPER_PASSWORD = "sniper";
	public static final String SNIPER_XMPP_ID = String.format("%s@%s/%s", SNIPER_ID, "127.0.0.1", Main.AUCTION_RESOURCE);
	
	private AuctionSniperDriver driver;
	
	public void startBiddingIn(final FakeAuctionServer auction) {
		Thread thread = new Thread("Test application") {
			@Override public void run() {
				try {
					Main.main(XMPP_HOSTNAME, SNIPER_ID, SNIPER_PASSWORD, auction.getItemId());
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		};
		thread.setDaemon(true);
		thread.start();
		
		driver = new AuctionSniperDriver(1000);
		driver.showsSniperStatus(STATUS_JOINING);
	}
	
	public void showsSniperHasLostAuction() {
		driver.showsSniperStatus(STATUS_LOST);
	}
	
	public void hasShownSniperIsBidding() {
		driver.showsSniperStatus(MainWindow.STATUS_BIDDING);
	}
	
	public void stop() {
		if(driver != null) {
			driver.dispose();
		}
	}
}
