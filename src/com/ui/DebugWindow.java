package com.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

public class DebugWindow extends JFrame {

	private static final long serialVersionUID = 6720686700487402244L;

	private JPanel mainPanel = new JPanel(new GridLayout());
	private JScrollPane mainScroll = new JScrollPane(mainPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
			ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	private String mainText = "";
	private JTextArea mainTextArea = new JTextArea(1, 1);
	private static final String PRINT_IDEN = "%PLN%";

	public DebugWindow() {
		setTitle("Output Window");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		final int width = 1200;
		final int height = 800;
		Dimension windowDim = new Dimension(width, height);
		setPreferredSize(windowDim);
		setMinimumSize(windowDim);
		setMaximumSize(windowDim);

		mainTextArea.setLineWrap(true);
		mainTextArea.setWrapStyleWord(true);
		mainTextArea.setFont(new Font("Consolas", 0, 12));
		mainTextArea.setForeground(new Color(200, 200, 200));

		mainPanel.add(mainTextArea);
		mainTextArea.setBackground(new Color(50, 50, 50));
		mainPanel.setBackground(mainTextArea.getBackground());
		add(mainScroll);
		pack();

		setVisible(true);
	}

	public void print(String text) {
		print(text, false);
	}

	public void print(String newText, boolean printToSystem) {
		if (newText.substring(0, PRINT_IDEN.length()).equals(PRINT_IDEN))
			newText = newText.substring(PRINT_IDEN.length());
		if (printToSystem)
			System.out.print(newText);

		mainText += newText;
		mainTextArea.setText(mainText);
	}

	public void println(String text) {
		println(text, false);
	}

	public void println(String newText, boolean printToSystem) {
		print(PRINT_IDEN + newText + "\n", printToSystem);
	}
}
