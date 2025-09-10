package com.ui;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.WindowConstants;

import com.card.Card;
import com.wrapper.jpanel.ExtraMonsterPanel;
import com.wrapper.jpanel.FieldPanel;

public class MainWindow {
	private static final Logger logger = Logger.getLogger(MainWindow.class.getName());

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				var window = new MainWindow();
				window.mainFrame.setVisible(true);
			} catch (Exception e) {
				logger.log(Level.SEVERE, "An exception occured.", e);
			}
		});
	}

	ExtraMonsterPanel extraMonsterZoneLeft = new ExtraMonsterPanel();
	ExtraMonsterPanel extraMonsterZoneRight = new ExtraMonsterPanel();
	FieldPanel fieldPanel = new FieldPanel();
	GridBagConstraints gridBagConstExtraMonsterZoneLeft = new GridBagConstraints();
	GridBagConstraints gridBagConstExtraMonsterZoneRight = new GridBagConstraints();
	GridBagConstraints gridBagConstFieldPanel = new GridBagConstraints();
	GridBagLayout gridBagLayoutFieldPanel = new GridBagLayout();
	GridBagLayout gridBagLayoutMainFrame = new GridBagLayout();
	JFrame mainFrame = new JFrame();
	PlayerZonesHelper playerZonesHelper = new PlayerZonesHelper();
	OpponentZonesHelper opponentZonesHelper = new OpponentZonesHelper();
	JList<Card> testHand = new JList<>();

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	private void initExtraMonsterZones() {
		gridBagConstExtraMonsterZoneLeft.fill = GridBagConstraints.BOTH;
		gridBagConstExtraMonsterZoneLeft.insets = new Insets(0, 0, 5, 5);
		gridBagConstExtraMonsterZoneLeft.gridheight = 2;
		gridBagConstExtraMonsterZoneLeft.gridx = 3;
		gridBagConstExtraMonsterZoneLeft.gridy = 7;
		fieldPanel.add(extraMonsterZoneLeft, gridBagConstExtraMonsterZoneLeft);

		gridBagConstExtraMonsterZoneRight.fill = GridBagConstraints.BOTH;
		gridBagConstExtraMonsterZoneRight.insets = new Insets(0, 0, 5, 5);
		gridBagConstExtraMonsterZoneRight.gridheight = 2;
		gridBagConstExtraMonsterZoneRight.gridx = 5;
		gridBagConstExtraMonsterZoneRight.gridy = 7;
		fieldPanel.add(extraMonsterZoneRight, gridBagConstExtraMonsterZoneRight);
	}

	/**
	 * Initialize the contents of the mainFrame.
	 */
	private void initialize() {
		mainFrame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		mainFrame.setResizable(false);
		mainFrame.setBounds(59, 59, 802, 778);
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		gridBagLayoutMainFrame.columnWidths = new int[] { 0, 446, 0, 0 };
		gridBagLayoutMainFrame.rowHeights = new int[] { 0, 621, 0, 0 };
		gridBagLayoutMainFrame.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayoutMainFrame.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		mainFrame.getContentPane().setLayout(gridBagLayoutMainFrame);

		gridBagConstFieldPanel.insets = new Insets(0, 0, 5, 5);
		gridBagConstFieldPanel.fill = GridBagConstraints.BOTH;
		gridBagConstFieldPanel.gridx = 1;
		gridBagConstFieldPanel.gridy = 1;
		mainFrame.getContentPane().add(fieldPanel, gridBagConstFieldPanel);
		gridBagLayoutFieldPanel.columnWidths = new int[] { 0, 59, 59, 59, 59, 59, 59, 59, 0, 0 };
		gridBagLayoutFieldPanel.rowHeights = new int[] { 76, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 0, 76,
				0 };
		gridBagLayoutFieldPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayoutFieldPanel.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		fieldPanel.setLayout(gridBagLayoutFieldPanel);

		opponentZonesHelper.initOpponentZones(this);

		initExtraMonsterZones();

		playerZonesHelper.initPlayerZones(this);
	}
}
