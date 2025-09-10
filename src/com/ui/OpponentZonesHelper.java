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

public class OpponentZonesHelper {
	BanishmentPanel opponentBanishment = new BanishmentPanel();
	DeckPanel opponentDeck = new DeckPanel();
	DeckPanel opponentExtraDeck = new DeckPanel();
	FieldSpellPanel opponentFieldSpellZone = new FieldSpellPanel();
	GraveyardPanel opponentGraveyard = new GraveyardPanel();
	HandPane opponentHandPane = new HandPane();
	MainMonsterPanel opponentMainMonsterZoneLeft = new MainMonsterPanel();
	MainMonsterPanel opponentMainMonsterZoneLeftMiddle = new MainMonsterPanel();
	MainMonsterPanel opponentMainMonsterZoneMiddle = new MainMonsterPanel();
	MainMonsterPanel opponentMainMonsterZoneMiddleRight = new MainMonsterPanel();
	MainMonsterPanel opponentMainMonsterZoneRight = new MainMonsterPanel();
	PendulumSpellPanel opponentPendulumSpellZoneLeft = new PendulumSpellPanel();
	PendulumSpellPanel opponentPendulumSpellZoneRight = new PendulumSpellPanel();
	SpellPanel opponentSpellZoneLeftMiddle = new SpellPanel();
	SpellPanel opponentSpellZoneMiddle = new SpellPanel();
	SpellPanel opponentSpellZoneMiddleRight = new SpellPanel();
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

	void initOpponentDecks(MainWindow mainWindow) {
		gridBagConstOpponentDeck.gridheight = 2;
		gridBagConstOpponentDeck.fill = GridBagConstraints.BOTH;
		gridBagConstOpponentDeck.insets = new Insets(0, 0, 5, 5);
		gridBagConstOpponentDeck.gridx = 1;
		gridBagConstOpponentDeck.gridy = 2;
		mainWindow.fieldPanel.add(opponentDeck, gridBagConstOpponentDeck);

		gridBagConstOpponentExtraDeck.gridheight = 2;
		gridBagConstOpponentExtraDeck.fill = GridBagConstraints.BOTH;
		gridBagConstOpponentExtraDeck.insets = new Insets(0, 0, 5, 5);
		gridBagConstOpponentExtraDeck.gridx = 7;
		gridBagConstOpponentExtraDeck.gridy = 2;
		mainWindow.fieldPanel.add(opponentExtraDeck, gridBagConstOpponentExtraDeck);
	}

	void initOpponentSpellZones(MainWindow mainWindow) {
		gridBagConstOpponentPendulumSpellZoneLeft.fill = GridBagConstraints.BOTH;
		gridBagConstOpponentPendulumSpellZoneLeft.insets = new Insets(0, 0, 5, 5);
		gridBagConstOpponentPendulumSpellZoneLeft.gridheight = 2;
		gridBagConstOpponentPendulumSpellZoneLeft.gridx = 2;
		gridBagConstOpponentPendulumSpellZoneLeft.gridy = 3;
		mainWindow.fieldPanel.add(opponentPendulumSpellZoneLeft, gridBagConstOpponentPendulumSpellZoneLeft);

		gridBagConstOpponentSpellZoneLeftMiddle.fill = GridBagConstraints.BOTH;
		gridBagConstOpponentSpellZoneLeftMiddle.insets = new Insets(0, 0, 5, 5);
		gridBagConstOpponentSpellZoneLeftMiddle.gridheight = 2;
		gridBagConstOpponentSpellZoneLeftMiddle.gridx = 3;
		gridBagConstOpponentSpellZoneLeftMiddle.gridy = 3;
		mainWindow.fieldPanel.add(opponentSpellZoneLeftMiddle, gridBagConstOpponentSpellZoneLeftMiddle);

		gridBagConstOpponentSpellZoneMiddle.fill = GridBagConstraints.BOTH;
		gridBagConstOpponentSpellZoneMiddle.insets = new Insets(0, 0, 5, 5);
		gridBagConstOpponentSpellZoneMiddle.gridheight = 2;
		gridBagConstOpponentSpellZoneMiddle.gridx = 4;
		gridBagConstOpponentSpellZoneMiddle.gridy = 3;
		mainWindow.fieldPanel.add(opponentSpellZoneMiddle, gridBagConstOpponentSpellZoneMiddle);

		gridBagConstOpponentSpellZoneMiddleRight.fill = GridBagConstraints.BOTH;
		gridBagConstOpponentSpellZoneMiddleRight.insets = new Insets(0, 0, 5, 5);
		gridBagConstOpponentSpellZoneMiddleRight.gridheight = 2;
		gridBagConstOpponentSpellZoneMiddleRight.gridx = 5;
		gridBagConstOpponentSpellZoneMiddleRight.gridy = 3;
		mainWindow.fieldPanel.add(opponentSpellZoneMiddleRight, gridBagConstOpponentSpellZoneMiddleRight);

		gridBagConstOpponentPendulumSpellZoneRight.fill = GridBagConstraints.BOTH;
		gridBagConstOpponentPendulumSpellZoneRight.insets = new Insets(0, 0, 5, 5);
		gridBagConstOpponentPendulumSpellZoneRight.gridheight = 2;
		gridBagConstOpponentPendulumSpellZoneRight.gridx = 6;
		gridBagConstOpponentPendulumSpellZoneRight.gridy = 3;
		mainWindow.fieldPanel.add(opponentPendulumSpellZoneRight, gridBagConstOpponentPendulumSpellZoneRight);

		gridBagConstOpponentFieldSpellZone.fill = GridBagConstraints.BOTH;
		gridBagConstOpponentFieldSpellZone.insets = new Insets(0, 0, 5, 5);
		gridBagConstOpponentFieldSpellZone.gridheight = 2;
		gridBagConstOpponentFieldSpellZone.gridx = 7;
		gridBagConstOpponentFieldSpellZone.gridy = 4;
		mainWindow.fieldPanel.add(opponentFieldSpellZone, gridBagConstOpponentFieldSpellZone);
	}

	void initOpponentZones(MainWindow mainWindow) {
		opponentHandPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		opponentHandPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		gridBagConstOpponentHandPane.gridwidth = 7;
		gridBagConstOpponentHandPane.insets = new Insets(0, 0, 5, 5);
		gridBagConstOpponentHandPane.fill = GridBagConstraints.BOTH;
		gridBagConstOpponentHandPane.gridx = 1;
		gridBagConstOpponentHandPane.gridy = 0;
		mainWindow.fieldPanel.add(opponentHandPane, gridBagConstOpponentHandPane);

		initOpponentSpellZones(mainWindow);

		initOpponentDecks(mainWindow);

		gridBagConstOpponentGraveyard.fill = GridBagConstraints.BOTH;
		gridBagConstOpponentGraveyard.insets = new Insets(0, 0, 5, 5);
		gridBagConstOpponentGraveyard.gridheight = 2;
		gridBagConstOpponentGraveyard.gridx = 1;
		gridBagConstOpponentGraveyard.gridy = 4;
		mainWindow.fieldPanel.add(opponentGraveyard, gridBagConstOpponentGraveyard);

		initOpponetMainMonsterZone(mainWindow);

		gridBagConstOpponentBanishment.fill = GridBagConstraints.BOTH;
		gridBagConstOpponentBanishment.insets = new Insets(0, 0, 5, 5);
		gridBagConstOpponentBanishment.gridheight = 2;
		gridBagConstOpponentBanishment.gridx = 1;
		gridBagConstOpponentBanishment.gridy = 6;
		mainWindow.fieldPanel.add(opponentBanishment, gridBagConstOpponentBanishment);
	}

	void initOpponetMainMonsterZone(MainWindow mainWindow) {
		gridBagConstOpponentMainMonsterZoneLeft.fill = GridBagConstraints.BOTH;
		gridBagConstOpponentMainMonsterZoneLeft.insets = new Insets(0, 0, 5, 5);
		gridBagConstOpponentMainMonsterZoneLeft.gridheight = 2;
		gridBagConstOpponentMainMonsterZoneLeft.gridx = 2;
		gridBagConstOpponentMainMonsterZoneLeft.gridy = 5;
		mainWindow.fieldPanel.add(opponentMainMonsterZoneLeft, gridBagConstOpponentMainMonsterZoneLeft);

		gridBagConstOpponentMainMonsterZoneLeftMiddle.fill = GridBagConstraints.BOTH;
		gridBagConstOpponentMainMonsterZoneLeftMiddle.insets = new Insets(0, 0, 5, 5);
		gridBagConstOpponentMainMonsterZoneLeftMiddle.gridheight = 2;
		gridBagConstOpponentMainMonsterZoneLeftMiddle.gridx = 3;
		gridBagConstOpponentMainMonsterZoneLeftMiddle.gridy = 5;
		mainWindow.fieldPanel.add(opponentMainMonsterZoneLeftMiddle, gridBagConstOpponentMainMonsterZoneLeftMiddle);

		gridBagConstOpponentMainMonsterZoneMiddle.fill = GridBagConstraints.BOTH;
		gridBagConstOpponentMainMonsterZoneMiddle.insets = new Insets(0, 0, 5, 5);
		gridBagConstOpponentMainMonsterZoneMiddle.gridheight = 2;
		gridBagConstOpponentMainMonsterZoneMiddle.gridx = 4;
		gridBagConstOpponentMainMonsterZoneMiddle.gridy = 5;
		mainWindow.fieldPanel.add(opponentMainMonsterZoneMiddle, gridBagConstOpponentMainMonsterZoneMiddle);

		gridBagConstOpponentMainMonsterZoneMiddleRight.fill = GridBagConstraints.BOTH;
		gridBagConstOpponentMainMonsterZoneMiddleRight.insets = new Insets(0, 0, 5, 5);
		gridBagConstOpponentMainMonsterZoneMiddleRight.gridheight = 2;
		gridBagConstOpponentMainMonsterZoneMiddleRight.gridx = 5;
		gridBagConstOpponentMainMonsterZoneMiddleRight.gridy = 5;
		mainWindow.fieldPanel.add(opponentMainMonsterZoneMiddleRight, gridBagConstOpponentMainMonsterZoneMiddleRight);

		gridBagConstOpponentMainMonsterZoneRight.fill = GridBagConstraints.BOTH;
		gridBagConstOpponentMainMonsterZoneRight.insets = new Insets(0, 0, 5, 5);
		gridBagConstOpponentMainMonsterZoneRight.gridheight = 2;
		gridBagConstOpponentMainMonsterZoneRight.gridx = 6;
		gridBagConstOpponentMainMonsterZoneRight.gridy = 5;
		mainWindow.fieldPanel.add(opponentMainMonsterZoneRight, gridBagConstOpponentMainMonsterZoneRight);
	}

}
