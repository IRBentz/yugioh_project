package ygo_eng.engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class QueDB_Builder implements KeyListener {
	private static JFrame frame;
	private static JTextField textField;

	public static void queUser() {
		frame = new JFrame("Use new backend? y/n");
		textField = new JTextField(20);
		textField.addKeyListener(new QueDB_Builder());
		frame.add(textField);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == 'y') {
			Backend.useNewFileFormat = true;
			Backend.useNewFileLoading = true;
			Backend.start("src//ygo_eng//file_pointers_new.txt");
			frame.setVisible(false);
		} else if (e.getKeyChar() == 'n') {
			Backend.start("src//ygo_eng//file_pointers.txt");
			frame.setVisible(false);
		}
	}
}