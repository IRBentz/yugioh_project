package com.ui;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.ScrollPaneConstants;

import com.wrapper.jpanel.BanishmentPanel;
import com.wrapper.jpanel.DeckPanel;
import com.wrapper.jpanel.FieldSpellPanel;
import com.wrapper.jpanel.GraveyardPanel;
import com.wrapper.jpanel.MainMonsterPanel;
import com.wrapper.jpanel.PendulumSpellPanel;
import com.wrapper.jpanel.SpellPanel;
import com.wrapper.jscrollpane.HandPane;

public class PlayerZonesHelper {
	private GridBagConstraints gridBagConstPlayerBanishment = new GridBagConstraints();
	private GridBagConstraints gridBagConstPlayerDeck = new GridBagConstraints();
	private GridBagConstraints gridBagConstPlayerExtraDeck = new GridBagConstraints();
	private GridBagConstraints gridBagConstPlayerFieldSpellZone = new GridBagConstraints();
	private GridBagConstraints gridBagConstPlayerGraveyard = new GridBagConstraints();
	private GridBagConstraints gridBagConstPlayerHandPane = new GridBagConstraints();
	private GridBagConstraints gridBagConstPlayerMainMonsterZoneLeft = new GridBagConstraints();
	private GridBagConstraints gridBagConstPlayerMainMonsterZoneLeftMiddle = new GridBagConstraints();
	private GridBagConstraints gridBagConstPlayerMainMonsterZoneMiddle = new GridBagConstraints();
	private GridBagConstraints gridBagConstPlayerMainMonsterZoneMiddleRight = new GridBagConstraints();
	private GridBagConstraints gridBagConstPlayerMainMonsterZoneRight = new GridBagConstraints();
	private GridBagConstraints gridBagConstPlayerPendulumSpellZoneLeft = new GridBagConstraints();
	private GridBagConstraints gridBagConstPlayerPendulumSpellZoneRight = new GridBagConstraints();
	private GridBagConstraints gridBagConstPlayerSpellZoneLeftMiddle = new GridBagConstraints();
	private GridBagConstraints gridBagConstPlayerSpellZoneMiddle = new GridBagConstraints();
	private GridBagConstraints gridBagConstPlayerSpellZoneMiddleRight = new GridBagConstraints();
	private BanishmentPanel playerBanishment = new BanishmentPanel();
	private DeckPanel playerDeck = new DeckPanel();
	private DeckPanel playerExtraDeck = new DeckPanel();
	private FieldSpellPanel playerFieldSpellZone = new FieldSpellPanel();
	private GraveyardPanel playerGraveyard = new GraveyardPanel();
	private HandPane playerHandPane = new HandPane();
	private MainMonsterPanel playerMainMonsterZoneLeft = new MainMonsterPanel();
	private MainMonsterPanel playerMainMonsterZoneLeftMiddle = new MainMonsterPanel();
	private MainMonsterPanel playerMainMonsterZoneMiddle = new MainMonsterPanel();
	private MainMonsterPanel playerMainMonsterZoneMiddleRight = new MainMonsterPanel();
	private MainMonsterPanel playerMainMonsterZoneRight = new MainMonsterPanel();
	private PendulumSpellPanel playerPendulumSpellZoneLeft = new PendulumSpellPanel();
	private PendulumSpellPanel playerPendulumSpellZoneRight = new PendulumSpellPanel();
	private SpellPanel playerSpellZoneLeftMiddle = new SpellPanel();
	private SpellPanel playerSpellZoneMiddle = new SpellPanel();
	private SpellPanel playerSpellZoneMiddleRight = new SpellPanel();

	void initPlayerDecks(MainWindow mainWindow) {
		gridBagConstPlayerExtraDeck.gridheight = 2;
		gridBagConstPlayerExtraDeck.fill = GridBagConstraints.BOTH;
		gridBagConstPlayerExtraDeck.insets = new Insets(0, 0, 5, 5);
		gridBagConstPlayerExtraDeck.gridx = 1;
		gridBagConstPlayerExtraDeck.gridy = 12;
		mainWindow.fieldPanel.add(playerExtraDeck, gridBagConstPlayerExtraDeck);

		gridBagConstPlayerDeck.gridheight = 2;
		gridBagConstPlayerDeck.insets = new Insets(0, 0, 5, 5);
		gridBagConstPlayerDeck.fill = GridBagConstraints.BOTH;
		gridBagConstPlayerDeck.gridx = 7;
		gridBagConstPlayerDeck.gridy = 12;
		mainWindow.fieldPanel.add(playerDeck, gridBagConstPlayerDeck);
	}

	void initPlayerMonsterZones(MainWindow mainWindow) {
		gridBagConstPlayerMainMonsterZoneLeft.fill = GridBagConstraints.BOTH;
		gridBagConstPlayerMainMonsterZoneLeft.insets = new Insets(0, 0, 5, 5);
		gridBagConstPlayerMainMonsterZoneLeft.gridheight = 2;
		gridBagConstPlayerMainMonsterZoneLeft.gridx = 2;
		gridBagConstPlayerMainMonsterZoneLeft.gridy = 9;
		mainWindow.fieldPanel.add(playerMainMonsterZoneLeft, gridBagConstPlayerMainMonsterZoneLeft);

		gridBagConstPlayerMainMonsterZoneLeftMiddle.fill = GridBagConstraints.BOTH;
		gridBagConstPlayerMainMonsterZoneLeftMiddle.insets = new Insets(0, 0, 5, 5);
		gridBagConstPlayerMainMonsterZoneLeftMiddle.gridheight = 2;
		gridBagConstPlayerMainMonsterZoneLeftMiddle.gridx = 3;
		gridBagConstPlayerMainMonsterZoneLeftMiddle.gridy = 9;
		mainWindow.fieldPanel.add(playerMainMonsterZoneLeftMiddle, gridBagConstPlayerMainMonsterZoneLeftMiddle);

		gridBagConstPlayerMainMonsterZoneMiddle.fill = GridBagConstraints.BOTH;
		gridBagConstPlayerMainMonsterZoneMiddle.insets = new Insets(0, 0, 5, 5);
		gridBagConstPlayerMainMonsterZoneMiddle.gridheight = 2;
		gridBagConstPlayerMainMonsterZoneMiddle.gridx = 4;
		gridBagConstPlayerMainMonsterZoneMiddle.gridy = 9;
		mainWindow.fieldPanel.add(playerMainMonsterZoneMiddle, gridBagConstPlayerMainMonsterZoneMiddle);

		gridBagConstPlayerMainMonsterZoneMiddleRight.fill = GridBagConstraints.BOTH;
		gridBagConstPlayerMainMonsterZoneMiddleRight.insets = new Insets(0, 0, 5, 5);
		gridBagConstPlayerMainMonsterZoneMiddleRight.gridheight = 2;
		gridBagConstPlayerMainMonsterZoneMiddleRight.gridx = 5;
		gridBagConstPlayerMainMonsterZoneMiddleRight.gridy = 9;
		mainWindow.fieldPanel.add(playerMainMonsterZoneMiddleRight, gridBagConstPlayerMainMonsterZoneMiddleRight);

		gridBagConstPlayerMainMonsterZoneRight.fill = GridBagConstraints.BOTH;
		gridBagConstPlayerMainMonsterZoneRight.insets = new Insets(0, 0, 5, 5);
		gridBagConstPlayerMainMonsterZoneRight.gridheight = 2;
		gridBagConstPlayerMainMonsterZoneRight.gridx = 6;
		gridBagConstPlayerMainMonsterZoneRight.gridy = 9;
		mainWindow.fieldPanel.add(playerMainMonsterZoneRight, gridBagConstPlayerMainMonsterZoneRight);
	}

	void initPlayerSpellZones(MainWindow mainWindow) {
		gridBagConstPlayerFieldSpellZone.fill = GridBagConstraints.BOTH;
		gridBagConstPlayerFieldSpellZone.insets = new Insets(0, 0, 5, 5);
		gridBagConstPlayerFieldSpellZone.gridheight = 2;
		gridBagConstPlayerFieldSpellZone.gridx = 1;
		gridBagConstPlayerFieldSpellZone.gridy = 10;
		mainWindow.fieldPanel.add(playerFieldSpellZone, gridBagConstPlayerFieldSpellZone);

		gridBagConstPlayerPendulumSpellZoneLeft.fill = GridBagConstraints.BOTH;
		gridBagConstPlayerPendulumSpellZoneLeft.insets = new Insets(0, 0, 5, 5);
		gridBagConstPlayerPendulumSpellZoneLeft.gridheight = 2;
		gridBagConstPlayerPendulumSpellZoneLeft.gridx = 2;
		gridBagConstPlayerPendulumSpellZoneLeft.gridy = 11;
		mainWindow.fieldPanel.add(playerPendulumSpellZoneLeft, gridBagConstPlayerPendulumSpellZoneLeft);

		gridBagConstPlayerSpellZoneLeftMiddle.fill = GridBagConstraints.BOTH;
		gridBagConstPlayerSpellZoneLeftMiddle.insets = new Insets(0, 0, 5, 5);
		gridBagConstPlayerSpellZoneLeftMiddle.gridheight = 2;
		gridBagConstPlayerSpellZoneLeftMiddle.gridx = 3;
		gridBagConstPlayerSpellZoneLeftMiddle.gridy = 11;
		mainWindow.fieldPanel.add(playerSpellZoneLeftMiddle, gridBagConstPlayerSpellZoneLeftMiddle);

		gridBagConstPlayerSpellZoneMiddle.fill = GridBagConstraints.BOTH;
		gridBagConstPlayerSpellZoneMiddle.insets = new Insets(0, 0, 5, 5);
		gridBagConstPlayerSpellZoneMiddle.gridheight = 2;
		gridBagConstPlayerSpellZoneMiddle.gridx = 4;
		gridBagConstPlayerSpellZoneMiddle.gridy = 11;
		mainWindow.fieldPanel.add(playerSpellZoneMiddle, gridBagConstPlayerSpellZoneMiddle);

		gridBagConstPlayerSpellZoneMiddleRight.fill = GridBagConstraints.BOTH;
		gridBagConstPlayerSpellZoneMiddleRight.insets = new Insets(0, 0, 5, 5);
		gridBagConstPlayerSpellZoneMiddleRight.gridheight = 2;
		gridBagConstPlayerSpellZoneMiddleRight.gridx = 5;
		gridBagConstPlayerSpellZoneMiddleRight.gridy = 11;
		mainWindow.fieldPanel.add(playerSpellZoneMiddleRight, gridBagConstPlayerSpellZoneMiddleRight);

		gridBagConstPlayerPendulumSpellZoneRight.fill = GridBagConstraints.BOTH;
		gridBagConstPlayerPendulumSpellZoneRight.insets = new Insets(0, 0, 5, 5);
		gridBagConstPlayerPendulumSpellZoneRight.gridheight = 2;
		gridBagConstPlayerPendulumSpellZoneRight.gridx = 6;
		gridBagConstPlayerPendulumSpellZoneRight.gridy = 11;
		mainWindow.fieldPanel.add(playerPendulumSpellZoneRight, gridBagConstPlayerPendulumSpellZoneRight);
	}

	void initPlayerZones(MainWindow mainWindow) {
		gridBagConstPlayerBanishment.fill = GridBagConstraints.BOTH;
		gridBagConstPlayerBanishment.insets = new Insets(0, 0, 5, 5);
		gridBagConstPlayerBanishment.gridheight = 2;
		gridBagConstPlayerBanishment.gridx = 7;
		gridBagConstPlayerBanishment.gridy = 8;
		mainWindow.fieldPanel.add(playerBanishment, gridBagConstPlayerBanishment);

		initPlayerMonsterZones(mainWindow);

		gridBagConstPlayerGraveyard.fill = GridBagConstraints.BOTH;
		gridBagConstPlayerGraveyard.insets = new Insets(0, 0, 5, 5);
		gridBagConstPlayerGraveyard.gridheight = 2;
		gridBagConstPlayerGraveyard.gridx = 7;
		gridBagConstPlayerGraveyard.gridy = 10;
		mainWindow.fieldPanel.add(playerGraveyard, gridBagConstPlayerGraveyard);

		initPlayerSpellZones(mainWindow);

		initPlayerDecks(mainWindow);

		playerHandPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		playerHandPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		gridBagConstPlayerHandPane.gridwidth = 7;
		gridBagConstPlayerHandPane.insets = new Insets(0, 0, 0, 5);
		gridBagConstPlayerHandPane.fill = GridBagConstraints.BOTH;
		gridBagConstPlayerHandPane.gridx = 1;
		gridBagConstPlayerHandPane.gridy = 15;
		mainWindow.fieldPanel.add(playerHandPane, gridBagConstPlayerHandPane);
	}
}
