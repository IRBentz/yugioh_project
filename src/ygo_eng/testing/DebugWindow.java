package ygo_eng.testing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class DebugWindow extends JFrame {

	private static final long serialVersionUID = 6720686700487402244L;

	private JPanel mainPanel = new JPanel(new GridLayout());
	private JScrollPane mainScroll = new JScrollPane(mainPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	private String mainText = "";
	private JTextArea mainTextArea = new JTextArea(1, 1);
	private final String printIden = "%PLN%";

	public DebugWindow() {
		setTitle("Output Window");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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

		/*
		 * for(Card card: Backend.card_db) { mainText += card.toString() + "\n\n";
		 * mainTextArea.setText(mainText); } mainText = mainText.substring(0,
		 * mainText.length() - 4);
		 *
		 * mainTextArea.setText(mainText);
		 */
	}

	public void print(String text) {
		print(text, false);
	}

	public void print(String newText, boolean print_to_system) {
		if (newText.substring(0, printIden.length()).equals(printIden))
			newText = newText.substring(printIden.length());
		if (print_to_system)
			System.out.print(newText);

		mainText += newText;
		mainTextArea.setText(mainText);
	}

	public void println(String text) {
		println(text, false);
	}

	public void println(String newText, boolean print_to_system) {
		print(printIden + newText + "\n", print_to_system);
	}
}
