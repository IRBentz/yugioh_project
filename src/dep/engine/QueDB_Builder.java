package dep.engine;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.engine.Global;
@Deprecated
public class QueDB_Builder implements KeyListener {
	private static JFrame frame;
	private static JTextField textField;

	public static void queUser() {
		frame = new JFrame("Use backend version:");
		frame.setPreferredSize(new Dimension(300, 60));
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
		System.out.println("QueDB:\t\t" + e.getKeyChar() + " was typed.");
		if(Character.isDigit(e.getKeyChar())) {
			Global.back_ver = Integer.parseInt(String.valueOf(e.getKeyChar()));
			if(Global.back_ver > -1 && Global.back_ver < 4) {
				frame.setVisible(false);
				//Backend.start();
				System.exit(0);
			}
		}
	}
}