package com.ui;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

import com.wrapper.DeckPanel;
import com.wrapper.FieldPanel;

public class MainWindow {
	private static Logger logger = Logger.getLogger(MainWindow.class.getName());

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

	JPanel extraMonsterZoneLeft = new JPanel();
	JPanel extraMonsterZoneRight = new JPanel();
	FieldPanel fieldPanel = new FieldPanel();
	JFrame mainFrame = new JFrame();
	GridBagConstraints gridBagConstExtraMonsterZoneLeft = new GridBagConstraints();
	GridBagConstraints gridBagConstExtraMonsterZoneRight = new GridBagConstraints();
	GridBagConstraints gridBagConstFieldPanel = new GridBagConstraints();
	GridBagConstraints gridBagConstOpponentBanishment = new GridBagConstraints();
	GridBagConstraints gridBagConstOpponentDeck = new GridBagConstraints();
	GridBagConstraints gridBagConstOpponentExtraDeck = new GridBagConstraints();
	GridBagConstraints gridBagConstOpponentFieldSpellZone = new GridBagConstraints();
	GridBagConstraints gridBagConstOpponentGraveyard = new GridBagConstraints();
	GridBagConstraints gridBagConstOpponentHandPane = new GridBagConstraints();
	GridBagConstraints gridBagConstOpponentMainMonsterZoneLeft = new GridBagConstraints();
	GridBagConstraints gridBagConstOpponentMainMonsterZoneLeftMiddle = new GridBagConstraints();
	GridBagConstraints gridBagConstOpponentMainMonsterZoneMiddle = new GridBagConstraints();
	GridBagConstraints gridBagConstOpponentMainMonsterZoneMiddleRight = new GridBagConstraints();
	GridBagConstraints gridBagConstOpponentMainMonsterZoneRight = new GridBagConstraints();
	GridBagConstraints gridBagConstOpponentPendulumSpellZoneLeft = new GridBagConstraints();
	GridBagConstraints gridBagConstOpponentPendulumSpellZoneRight = new GridBagConstraints();
	GridBagConstraints gridBagConstOpponentSpellZoneLeftMiddle = new GridBagConstraints();
	GridBagConstraints gridBagConstOpponentSpellZoneMiddle = new GridBagConstraints();
	GridBagConstraints gridBagConstOpponentSpellZoneMiddleRight = new GridBagConstraints();
	GridBagConstraints gridBagConstPlayerBanishment = new GridBagConstraints();
	GridBagConstraints gridBagConstPlayerDeck = new GridBagConstraints();
	GridBagConstraints gridBagConstPlayerExtraDeck = new GridBagConstraints();
	GridBagConstraints gridBagConstPlayerFieldSpellZone = new GridBagConstraints();
	GridBagConstraints gridBagConstPlayerGraveyard = new GridBagConstraints();
	GridBagConstraints gridBagConstPlayerHandPane = new GridBagConstraints();
	GridBagConstraints gridBagConstPlayerMainMonsterZoneLeft = new GridBagConstraints();
	GridBagConstraints gridBagConstPlayerMainMonsterZoneLeftMiddle = new GridBagConstraints();
	GridBagConstraints gridBagConstPlayerMainMonsterZoneMiddle = new GridBagConstraints();
	GridBagConstraints gridBagConstPlayerMainMonsterZoneMiddleRight = new GridBagConstraints();
	GridBagConstraints gridBagConstPlayerMainMonsterZoneRight = new GridBagConstraints();
	GridBagConstraints gridBagConstPlayerPendulumSpellZoneLeft = new GridBagConstraints();
	GridBagConstraints gridBagConstPlayerPendulumSpellZoneRight = new GridBagConstraints();
	GridBagConstraints gridBagConstPlayerSpellZoneLeftMiddle = new GridBagConstraints();
	GridBagConstraints gridBagConstPlayerSpellZoneMiddle = new GridBagConstraints();
	GridBagConstraints gridBagConstPlayerSpellZoneMiddleRight = new GridBagConstraints();
	GridBagLayout gridBagLayoutFieldPanel = new GridBagLayout();
	GridBagLayout gridBagLayoutMainFrame = new GridBagLayout();
	JPanel opponentBanishment = new JPanel();
	DeckPanel opponentDeck = new DeckPanel();
	DeckPanel opponentExtraDeck = new DeckPanel();
	JPanel opponentFieldSpellZone = new JPanel();
	JPanel opponentGraveyard = new JPanel();
	JScrollPane opponentHandPane = new JScrollPane();
	JPanel opponentMainMonsterZoneLeft = new JPanel();
	JPanel opponentMainMonsterZoneLeftMiddle = new JPanel();
	JPanel opponentMainMonsterZoneMiddle = new JPanel();
	JPanel opponentMainMonsterZoneMiddleRight = new JPanel();
	JPanel opponentMainMonsterZoneRight = new JPanel();
	JPanel opponentPendulumSpellZoneLeft = new JPanel();
	JPanel opponentPendulumSpellZoneRight = new JPanel();
	JPanel opponentSpellZoneLeftMiddle = new JPanel();
	JPanel opponentSpellZoneMiddle = new JPanel();
	JPanel opponentSpellZoneMiddleRight = new JPanel();
	JPanel playerBanishment = new JPanel();
	DeckPanel playerDeck = new DeckPanel();
	DeckPanel playerExtraDeck = new DeckPanel();
	JPanel playerFieldSpellZone = new JPanel();
	JPanel playerGraveyard = new JPanel();
	JScrollPane playerHandPane = new JScrollPane();
	JPanel playerMainMonsterZoneLeft = new JPanel();
	JPanel playerMainMonsterZoneLeftMiddle = new JPanel();
	JPanel playerMainMonsterZoneMiddle = new JPanel();
	JPanel playerMainMonsterZoneMiddleRight = new JPanel();
	JPanel playerMainMonsterZoneRight = new JPanel();
	JPanel playerPendulumSpellZoneLeft = new JPanel();
	JPanel playerPendulumSpellZoneRight = new JPanel();
	JPanel playerSpellZoneLeftMiddle = new JPanel();
	JPanel playerSpellZoneMiddle = new JPanel();
	JPanel playerSpellZoneMiddleRight = new JPanel();
	
	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
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
		gridBagLayoutFieldPanel.rowHeights = new int[] { 76, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 0, 76, 0 };
		gridBagLayoutFieldPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayoutFieldPanel.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 1.0, Double.MIN_VALUE };
		fieldPanel.setLayout(gridBagLayoutFieldPanel);

		opponentHandPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		opponentHandPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		gridBagConstOpponentHandPane.gridwidth = 7;
		gridBagConstOpponentHandPane.insets = new Insets(0, 0, 5, 5);
		gridBagConstOpponentHandPane.fill = GridBagConstraints.BOTH;
		gridBagConstOpponentHandPane.gridx = 1;
		gridBagConstOpponentHandPane.gridy = 0;
		fieldPanel.add(opponentHandPane, gridBagConstOpponentHandPane);

		gridBagConstOpponentDeck.gridheight = 2;
		gridBagConstOpponentDeck.fill = GridBagConstraints.BOTH;
		gridBagConstOpponentDeck.insets = new Insets(0, 0, 5, 5);
		gridBagConstOpponentDeck.gridx = 1;
		gridBagConstOpponentDeck.gridy = 2;
		fieldPanel.add(opponentDeck, gridBagConstOpponentDeck);

		gridBagConstOpponentPendulumSpellZoneLeft.fill = GridBagConstraints.BOTH;
		gridBagConstOpponentPendulumSpellZoneLeft.insets = new Insets(0, 0, 5, 5);
		gridBagConstOpponentPendulumSpellZoneLeft.gridheight = 2;
		gridBagConstOpponentPendulumSpellZoneLeft.gridx = 2;
		gridBagConstOpponentPendulumSpellZoneLeft.gridy = 3;
		fieldPanel.add(opponentPendulumSpellZoneLeft, gridBagConstOpponentPendulumSpellZoneLeft);

		gridBagConstOpponentSpellZoneLeftMiddle.fill = GridBagConstraints.BOTH;
		gridBagConstOpponentSpellZoneLeftMiddle.insets = new Insets(0, 0, 5, 5);
		gridBagConstOpponentSpellZoneLeftMiddle.gridheight = 2;
		gridBagConstOpponentSpellZoneLeftMiddle.gridx = 3;
		gridBagConstOpponentSpellZoneLeftMiddle.gridy = 3;
		fieldPanel.add(opponentSpellZoneLeftMiddle, gridBagConstOpponentSpellZoneLeftMiddle);

		gridBagConstOpponentSpellZoneMiddle.fill = GridBagConstraints.BOTH;
		gridBagConstOpponentSpellZoneMiddle.insets = new Insets(0, 0, 5, 5);
		gridBagConstOpponentSpellZoneMiddle.gridheight = 2;
		gridBagConstOpponentSpellZoneMiddle.gridx = 4;
		gridBagConstOpponentSpellZoneMiddle.gridy = 3;
		fieldPanel.add(opponentSpellZoneMiddle, gridBagConstOpponentSpellZoneMiddle);

		gridBagConstOpponentSpellZoneMiddleRight.fill = GridBagConstraints.BOTH;
		gridBagConstOpponentSpellZoneMiddleRight.insets = new Insets(0, 0, 5, 5);
		gridBagConstOpponentSpellZoneMiddleRight.gridheight = 2;
		gridBagConstOpponentSpellZoneMiddleRight.gridx = 5;
		gridBagConstOpponentSpellZoneMiddleRight.gridy = 3;
		fieldPanel.add(opponentSpellZoneMiddleRight, gridBagConstOpponentSpellZoneMiddleRight);

		gridBagConstOpponentPendulumSpellZoneRight.fill = GridBagConstraints.BOTH;
		gridBagConstOpponentPendulumSpellZoneRight.insets = new Insets(0, 0, 5, 5);
		gridBagConstOpponentPendulumSpellZoneRight.gridheight = 2;
		gridBagConstOpponentPendulumSpellZoneRight.gridx = 6;
		gridBagConstOpponentPendulumSpellZoneRight.gridy = 3;
		fieldPanel.add(opponentPendulumSpellZoneRight, gridBagConstOpponentPendulumSpellZoneRight);

		gridBagConstOpponentExtraDeck.gridheight = 2;
		gridBagConstOpponentExtraDeck.fill = GridBagConstraints.BOTH;
		gridBagConstOpponentExtraDeck.insets = new Insets(0, 0, 5, 5);
		gridBagConstOpponentExtraDeck.gridx = 7;
		gridBagConstOpponentExtraDeck.gridy = 2;
		fieldPanel.add(opponentExtraDeck, gridBagConstOpponentExtraDeck);

		gridBagConstOpponentGraveyard.fill = GridBagConstraints.BOTH;
		gridBagConstOpponentGraveyard.insets = new Insets(0, 0, 5, 5);
		gridBagConstOpponentGraveyard.gridheight = 2;
		gridBagConstOpponentGraveyard.gridx = 1;
		gridBagConstOpponentGraveyard.gridy = 4;
		fieldPanel.add(opponentGraveyard, gridBagConstOpponentGraveyard);

		gridBagConstOpponentFieldSpellZone.fill = GridBagConstraints.BOTH;
		gridBagConstOpponentFieldSpellZone.insets = new Insets(0, 0, 5, 5);
		gridBagConstOpponentFieldSpellZone.gridheight = 2;
		gridBagConstOpponentFieldSpellZone.gridx = 7;
		gridBagConstOpponentFieldSpellZone.gridy = 4;
		fieldPanel.add(opponentFieldSpellZone, gridBagConstOpponentFieldSpellZone);

		
		gridBagConstOpponentMainMonsterZoneLeft.fill = GridBagConstraints.BOTH;
		gridBagConstOpponentMainMonsterZoneLeft.insets = new Insets(0, 0, 5, 5);
		gridBagConstOpponentMainMonsterZoneLeft.gridheight = 2;
		gridBagConstOpponentMainMonsterZoneLeft.gridx = 2;
		gridBagConstOpponentMainMonsterZoneLeft.gridy = 5;
		fieldPanel.add(opponentMainMonsterZoneLeft, gridBagConstOpponentMainMonsterZoneLeft);
		opponentMainMonsterZoneLeft.setLayout(null);

		
		gridBagConstOpponentMainMonsterZoneLeftMiddle.fill = GridBagConstraints.BOTH;
		gridBagConstOpponentMainMonsterZoneLeftMiddle.insets = new Insets(0, 0, 5, 5);
		gridBagConstOpponentMainMonsterZoneLeftMiddle.gridheight = 2;
		gridBagConstOpponentMainMonsterZoneLeftMiddle.gridx = 3;
		gridBagConstOpponentMainMonsterZoneLeftMiddle.gridy = 5;
		fieldPanel.add(opponentMainMonsterZoneLeftMiddle, gridBagConstOpponentMainMonsterZoneLeftMiddle);

		
		gridBagConstOpponentMainMonsterZoneMiddle.fill = GridBagConstraints.BOTH;
		gridBagConstOpponentMainMonsterZoneMiddle.insets = new Insets(0, 0, 5, 5);
		gridBagConstOpponentMainMonsterZoneMiddle.gridheight = 2;
		gridBagConstOpponentMainMonsterZoneMiddle.gridx = 4;
		gridBagConstOpponentMainMonsterZoneMiddle.gridy = 5;
		fieldPanel.add(opponentMainMonsterZoneMiddle, gridBagConstOpponentMainMonsterZoneMiddle);

		
		gridBagConstOpponentMainMonsterZoneMiddleRight.fill = GridBagConstraints.BOTH;
		gridBagConstOpponentMainMonsterZoneMiddleRight.insets = new Insets(0, 0, 5, 5);
		gridBagConstOpponentMainMonsterZoneMiddleRight.gridheight = 2;
		gridBagConstOpponentMainMonsterZoneMiddleRight.gridx = 5;
		gridBagConstOpponentMainMonsterZoneMiddleRight.gridy = 5;
		fieldPanel.add(opponentMainMonsterZoneMiddleRight, gridBagConstOpponentMainMonsterZoneMiddleRight);

		
		gridBagConstOpponentMainMonsterZoneRight.fill = GridBagConstraints.BOTH;
		gridBagConstOpponentMainMonsterZoneRight.insets = new Insets(0, 0, 5, 5);
		gridBagConstOpponentMainMonsterZoneRight.gridheight = 2;
		gridBagConstOpponentMainMonsterZoneRight.gridx = 6;
		gridBagConstOpponentMainMonsterZoneRight.gridy = 5;
		fieldPanel.add(opponentMainMonsterZoneRight, gridBagConstOpponentMainMonsterZoneRight);

		
		gridBagConstOpponentBanishment.fill = GridBagConstraints.BOTH;
		gridBagConstOpponentBanishment.insets = new Insets(0, 0, 5, 5);
		gridBagConstOpponentBanishment.gridheight = 2;
		gridBagConstOpponentBanishment.gridx = 1;
		gridBagConstOpponentBanishment.gridy = 6;
		fieldPanel.add(opponentBanishment, gridBagConstOpponentBanishment);

		
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

		
		gridBagConstPlayerBanishment.fill = GridBagConstraints.BOTH;
		gridBagConstPlayerBanishment.insets = new Insets(0, 0, 5, 5);
		gridBagConstPlayerBanishment.gridheight = 2;
		gridBagConstPlayerBanishment.gridx = 7;
		gridBagConstPlayerBanishment.gridy = 8;
		fieldPanel.add(playerBanishment, gridBagConstPlayerBanishment);

		
		gridBagConstPlayerMainMonsterZoneLeft.fill = GridBagConstraints.BOTH;
		gridBagConstPlayerMainMonsterZoneLeft.insets = new Insets(0, 0, 5, 5);
		gridBagConstPlayerMainMonsterZoneLeft.gridheight = 2;
		gridBagConstPlayerMainMonsterZoneLeft.gridx = 2;
		gridBagConstPlayerMainMonsterZoneLeft.gridy = 9;
		fieldPanel.add(playerMainMonsterZoneLeft, gridBagConstPlayerMainMonsterZoneLeft);

		
		gridBagConstPlayerMainMonsterZoneLeftMiddle.fill = GridBagConstraints.BOTH;
		gridBagConstPlayerMainMonsterZoneLeftMiddle.insets = new Insets(0, 0, 5, 5);
		gridBagConstPlayerMainMonsterZoneLeftMiddle.gridheight = 2;
		gridBagConstPlayerMainMonsterZoneLeftMiddle.gridx = 3;
		gridBagConstPlayerMainMonsterZoneLeftMiddle.gridy = 9;
		fieldPanel.add(playerMainMonsterZoneLeftMiddle, gridBagConstPlayerMainMonsterZoneLeftMiddle);

		
		gridBagConstPlayerMainMonsterZoneMiddle.fill = GridBagConstraints.BOTH;
		gridBagConstPlayerMainMonsterZoneMiddle.insets = new Insets(0, 0, 5, 5);
		gridBagConstPlayerMainMonsterZoneMiddle.gridheight = 2;
		gridBagConstPlayerMainMonsterZoneMiddle.gridx = 4;
		gridBagConstPlayerMainMonsterZoneMiddle.gridy = 9;
		fieldPanel.add(playerMainMonsterZoneMiddle, gridBagConstPlayerMainMonsterZoneMiddle);

		
		gridBagConstPlayerMainMonsterZoneMiddleRight.fill = GridBagConstraints.BOTH;
		gridBagConstPlayerMainMonsterZoneMiddleRight.insets = new Insets(0, 0, 5, 5);
		gridBagConstPlayerMainMonsterZoneMiddleRight.gridheight = 2;
		gridBagConstPlayerMainMonsterZoneMiddleRight.gridx = 5;
		gridBagConstPlayerMainMonsterZoneMiddleRight.gridy = 9;
		fieldPanel.add(playerMainMonsterZoneMiddleRight, gridBagConstPlayerMainMonsterZoneMiddleRight);

		
		gridBagConstPlayerMainMonsterZoneRight.fill = GridBagConstraints.BOTH;
		gridBagConstPlayerMainMonsterZoneRight.insets = new Insets(0, 0, 5, 5);
		gridBagConstPlayerMainMonsterZoneRight.gridheight = 2;
		gridBagConstPlayerMainMonsterZoneRight.gridx = 6;
		gridBagConstPlayerMainMonsterZoneRight.gridy = 9;
		fieldPanel.add(playerMainMonsterZoneRight, gridBagConstPlayerMainMonsterZoneRight);

		
		gridBagConstPlayerFieldSpellZone.fill = GridBagConstraints.BOTH;
		gridBagConstPlayerFieldSpellZone.insets = new Insets(0, 0, 5, 5);
		gridBagConstPlayerFieldSpellZone.gridheight = 2;
		gridBagConstPlayerFieldSpellZone.gridx = 1;
		gridBagConstPlayerFieldSpellZone.gridy = 10;
		fieldPanel.add(playerFieldSpellZone, gridBagConstPlayerFieldSpellZone);

		
		gridBagConstPlayerGraveyard.fill = GridBagConstraints.BOTH;
		gridBagConstPlayerGraveyard.insets = new Insets(0, 0, 5, 5);
		gridBagConstPlayerGraveyard.gridheight = 2;
		gridBagConstPlayerGraveyard.gridx = 7;
		gridBagConstPlayerGraveyard.gridy = 10;
		fieldPanel.add(playerGraveyard, gridBagConstPlayerGraveyard);

		
		gridBagConstPlayerPendulumSpellZoneLeft.fill = GridBagConstraints.BOTH;
		gridBagConstPlayerPendulumSpellZoneLeft.insets = new Insets(0, 0, 5, 5);
		gridBagConstPlayerPendulumSpellZoneLeft.gridheight = 2;
		gridBagConstPlayerPendulumSpellZoneLeft.gridx = 2;
		gridBagConstPlayerPendulumSpellZoneLeft.gridy = 11;
		fieldPanel.add(playerPendulumSpellZoneLeft, gridBagConstPlayerPendulumSpellZoneLeft);

		
		gridBagConstPlayerSpellZoneLeftMiddle.fill = GridBagConstraints.BOTH;
		gridBagConstPlayerSpellZoneLeftMiddle.insets = new Insets(0, 0, 5, 5);
		gridBagConstPlayerSpellZoneLeftMiddle.gridheight = 2;
		gridBagConstPlayerSpellZoneLeftMiddle.gridx = 3;
		gridBagConstPlayerSpellZoneLeftMiddle.gridy = 11;
		fieldPanel.add(playerSpellZoneLeftMiddle, gridBagConstPlayerSpellZoneLeftMiddle);

		
		gridBagConstPlayerSpellZoneMiddle.fill = GridBagConstraints.BOTH;
		gridBagConstPlayerSpellZoneMiddle.insets = new Insets(0, 0, 5, 5);
		gridBagConstPlayerSpellZoneMiddle.gridheight = 2;
		gridBagConstPlayerSpellZoneMiddle.gridx = 4;
		gridBagConstPlayerSpellZoneMiddle.gridy = 11;
		fieldPanel.add(playerSpellZoneMiddle, gridBagConstPlayerSpellZoneMiddle);

		
		gridBagConstPlayerSpellZoneMiddleRight.fill = GridBagConstraints.BOTH;
		gridBagConstPlayerSpellZoneMiddleRight.insets = new Insets(0, 0, 5, 5);
		gridBagConstPlayerSpellZoneMiddleRight.gridheight = 2;
		gridBagConstPlayerSpellZoneMiddleRight.gridx = 5;
		gridBagConstPlayerSpellZoneMiddleRight.gridy = 11;
		fieldPanel.add(playerSpellZoneMiddleRight, gridBagConstPlayerSpellZoneMiddleRight);

		gridBagConstPlayerPendulumSpellZoneRight.fill = GridBagConstraints.BOTH;
		gridBagConstPlayerPendulumSpellZoneRight.insets = new Insets(0, 0, 5, 5);
		gridBagConstPlayerPendulumSpellZoneRight.gridheight = 2;
		gridBagConstPlayerPendulumSpellZoneRight.gridx = 6;
		gridBagConstPlayerPendulumSpellZoneRight.gridy = 11;
		fieldPanel.add(playerPendulumSpellZoneRight, gridBagConstPlayerPendulumSpellZoneRight);

		gridBagConstPlayerExtraDeck.gridheight = 2;
		gridBagConstPlayerExtraDeck.fill = GridBagConstraints.BOTH;
		gridBagConstPlayerExtraDeck.insets = new Insets(0, 0, 5, 5);
		gridBagConstPlayerExtraDeck.gridx = 1;
		gridBagConstPlayerExtraDeck.gridy = 12;
		fieldPanel.add(playerExtraDeck, gridBagConstPlayerExtraDeck);

		gridBagConstPlayerDeck.gridheight = 2;
		gridBagConstPlayerDeck.insets = new Insets(0, 0, 5, 5);
		gridBagConstPlayerDeck.fill = GridBagConstraints.BOTH;
		gridBagConstPlayerDeck.gridx = 7;
		gridBagConstPlayerDeck.gridy = 12;
		fieldPanel.add(playerDeck, gridBagConstPlayerDeck);

		playerHandPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		playerHandPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		gridBagConstPlayerHandPane.gridwidth = 7;
		gridBagConstPlayerHandPane.insets = new Insets(0, 0, 0, 5);
		gridBagConstPlayerHandPane.fill = GridBagConstraints.BOTH;
		gridBagConstPlayerHandPane.gridx = 1;
		gridBagConstPlayerHandPane.gridy = 15;
		fieldPanel.add(playerHandPane, gridBagConstPlayerHandPane);
	}
}
