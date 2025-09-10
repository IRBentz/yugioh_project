package com.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CardRendererPane extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel monsterPanel;
	private JPanel nameIconPanel;
	private JLabel cardName;
	private JLabel cardIcon;
	private JPanel starPanel;
	private JPanel cardImagePanel;
	private JLabel cardImageLabel;
	private JPanel cardTextBoxPanel;
	private JLabel monsterTypeLabel;
	private JLabel monsterLoreLabel;
	private JLabel atkLabel;
	private JLabel defLabel;
	private JLabel cardNumberLabel;

	/**
	 * Create the panel.
	 */
	public CardRendererPane() {

		initComponents();
	}

	private void initCardImagePanel() {
		cardImagePanel = new JPanel();
		var gbc_cardImagePanel = new GridBagConstraints();
		gbc_cardImagePanel.insets = new Insets(0, 0, 5, 5);
		gbc_cardImagePanel.fill = GridBagConstraints.BOTH;
		gbc_cardImagePanel.gridx = 1;
		gbc_cardImagePanel.gridy = 3;
		monsterPanel.add(cardImagePanel, gbc_cardImagePanel);
		var gbl_cardImagePanel = new GridBagLayout();
		gbl_cardImagePanel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_cardImagePanel.rowHeights = new int[] { 0, 0 };
		gbl_cardImagePanel.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_cardImagePanel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		cardImagePanel.setLayout(gbl_cardImagePanel);

		cardImageLabel = new JLabel("Card Image Here");
		cardImageLabel.setOpaque(true);
		cardImageLabel.setBackground(new Color(245, 255, 250));
		var gbc_cardImageLabel = new GridBagConstraints();
		gbc_cardImageLabel.insets = new Insets(0, 0, 0, 5);
		gbc_cardImageLabel.gridx = 1;
		gbc_cardImageLabel.gridy = 0;
		cardImagePanel.add(cardImageLabel, gbc_cardImageLabel);
	}

	private void initCardTextBoxPanel() {
		cardTextBoxPanel = new JPanel();
		var gbc_cardTextBoxPanel = new GridBagConstraints();
		gbc_cardTextBoxPanel.insets = new Insets(0, 0, 5, 5);
		gbc_cardTextBoxPanel.fill = GridBagConstraints.BOTH;
		gbc_cardTextBoxPanel.gridx = 1;
		gbc_cardTextBoxPanel.gridy = 4;
		monsterPanel.add(cardTextBoxPanel, gbc_cardTextBoxPanel);
		var gbl_cardTextBoxPanel = new GridBagLayout();
		gbl_cardTextBoxPanel.columnWidths = new int[] { 360, 60, 60, 0 };
		gbl_cardTextBoxPanel.rowHeights = new int[] { 30, 0, 30, 0 };
		gbl_cardTextBoxPanel.columnWeights = new double[] { 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_cardTextBoxPanel.rowWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		cardTextBoxPanel.setLayout(gbl_cardTextBoxPanel);

		monsterTypeLabel = new JLabel("Monster Types Here");
		var gbc_monsterTypeLabel = new GridBagConstraints();
		gbc_monsterTypeLabel.gridwidth = 3;
		gbc_monsterTypeLabel.insets = new Insets(0, 0, 5, 0);
		gbc_monsterTypeLabel.anchor = GridBagConstraints.WEST;
		gbc_monsterTypeLabel.gridx = 0;
		gbc_monsterTypeLabel.gridy = 0;
		cardTextBoxPanel.add(monsterTypeLabel, gbc_monsterTypeLabel);

		monsterLoreLabel = new JLabel("Monster Lore Here");
		var gbc_monsterLoreLabel = new GridBagConstraints();
		gbc_monsterLoreLabel.gridwidth = 3;
		gbc_monsterLoreLabel.anchor = GridBagConstraints.NORTH;
		gbc_monsterLoreLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_monsterLoreLabel.insets = new Insets(0, 0, 5, 0);
		gbc_monsterLoreLabel.gridx = 0;
		gbc_monsterLoreLabel.gridy = 1;
		cardTextBoxPanel.add(monsterLoreLabel, gbc_monsterLoreLabel);

		cardNumberLabel = new JLabel("Card Number Here");
		var gbc_cardNumberLabel = new GridBagConstraints();
		gbc_cardNumberLabel.anchor = GridBagConstraints.WEST;
		gbc_cardNumberLabel.insets = new Insets(0, 0, 0, 5);
		gbc_cardNumberLabel.gridx = 0;
		gbc_cardNumberLabel.gridy = 2;
		cardTextBoxPanel.add(cardNumberLabel, gbc_cardNumberLabel);

		atkLabel = new JLabel("ATK - ?");
		var gbc_atkLabel = new GridBagConstraints();
		gbc_atkLabel.insets = new Insets(0, 0, 0, 5);
		gbc_atkLabel.gridx = 1;
		gbc_atkLabel.gridy = 2;
		cardTextBoxPanel.add(atkLabel, gbc_atkLabel);

		defLabel = new JLabel("DEF - ?");
		var gbc_defLabel = new GridBagConstraints();
		gbc_defLabel.gridx = 2;
		gbc_defLabel.gridy = 2;
		cardTextBoxPanel.add(defLabel, gbc_defLabel);
	}

	private void initComponents() {
		setBackground(Color.DARK_GRAY);
		setSize(new Dimension(590, 860));
		setPreferredSize(new Dimension(591, 860));
		var gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 20, 0, 20, 0 };
		gridBagLayout.rowHeights = new int[] { 20, 0, 20, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		initMonsterPanel();
	}

	private void initMonsterPanel() {
		monsterPanel = new JPanel();
		monsterPanel.setBackground(Color.ORANGE);
		var gbc_monsterPanel = new GridBagConstraints();
		gbc_monsterPanel.insets = new Insets(0, 0, 5, 5);
		gbc_monsterPanel.fill = GridBagConstraints.BOTH;
		gbc_monsterPanel.gridx = 1;
		gbc_monsterPanel.gridy = 1;
		add(monsterPanel, gbc_monsterPanel);
		var gbl_monsterPanel = new GridBagLayout();
		gbl_monsterPanel.columnWidths = new int[] { 0, 510, 0, 0 };
		gbl_monsterPanel.rowHeights = new int[] { 20, 50, 50, 420, 0, 0, 0 };
		gbl_monsterPanel.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_monsterPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		monsterPanel.setLayout(gbl_monsterPanel);

		initNameIconPanel();

		starPanel = new JPanel();
		var gbc_starPanel = new GridBagConstraints();
		gbc_starPanel.insets = new Insets(0, 0, 5, 5);
		gbc_starPanel.fill = GridBagConstraints.BOTH;
		gbc_starPanel.gridx = 1;
		gbc_starPanel.gridy = 2;
		monsterPanel.add(starPanel, gbc_starPanel);

		initCardImagePanel();

		initCardTextBoxPanel();
	}

	private void initNameIconPanel() {
		nameIconPanel = new JPanel();
		var gbc_nameIconPanel = new GridBagConstraints();
		gbc_nameIconPanel.insets = new Insets(0, 0, 5, 5);
		gbc_nameIconPanel.fill = GridBagConstraints.BOTH;
		gbc_nameIconPanel.gridx = 1;
		gbc_nameIconPanel.gridy = 1;
		monsterPanel.add(nameIconPanel, gbc_nameIconPanel);
		nameIconPanel.setLayout(new BorderLayout(0, 0));

		cardName = new JLabel("Monster Name");
		cardName.setFont(new Font("Dialog", Font.BOLD, 35));
		nameIconPanel.add(cardName, BorderLayout.WEST);

		cardIcon = new JLabel("");
		cardIcon.setAlignmentX(Component.RIGHT_ALIGNMENT);
		cardIcon.setMaximumSize(new Dimension(40, 40));
		cardIcon.setIconTextGap(0);
		cardIcon.setMinimumSize(new Dimension(40, 40));
		nameIconPanel.add(cardIcon, BorderLayout.EAST);
	}

}
