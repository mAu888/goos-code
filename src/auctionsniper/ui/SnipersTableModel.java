package auctionsniper.ui;

import static auctionsniper.ui.MainWindow.STATUS_JOINING;

import javax.swing.table.AbstractTableModel;

import auctionsniper.SniperState;

public class SnipersTableModel extends AbstractTableModel {
	private final static SniperState STARTING_UP = new SniperState("", 0, 0);
	private String statusText = STATUS_JOINING;
	private SniperState sniperState = STARTING_UP;
	
	public void setStatusText(String newStatusText) {
		statusText = newStatusText;
		fireTableRowsUpdated(0, 0);
	}

	@Override
	public int getColumnCount() {
		return Column.values().length;
	}

	@Override
	public int getRowCount() {
		return 1;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (Column.at(columnIndex)) {
		case ITEM_IDENTIFIER:
			return sniperState.itemId;
		case LAST_BID:
			return sniperState.lastBid;
		case LAST_PRICE:
			return sniperState.lastPrice;
		case SNIPER_STATUS:
			return statusText;
		default:
			return null;
		}
	}

	public void sniperStatusChanged(SniperState newSniperState,
			String newStatusText) {
		sniperState = newSniperState;
		statusText = newStatusText;
		fireTableRowsUpdated(0, 0);
	}

}
