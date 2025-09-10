package com.wrapper.jscrollpane;

import javax.swing.JList;
import javax.swing.JScrollPane;

public class HandPane extends JScrollPane {
	private static final long serialVersionUID = -6015267957579133799L;

	public HandPane() {
	}

	public HandPane(JList<?> testHand) {
		super(testHand);
	}
}
