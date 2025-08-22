package com.card.component;

public enum LinkArrowComponent implements CardComponentInterface.SubInterface {
	DOWN, DOWN_LEFT, DOWN_RIGHT, LEFT, RIGHT, UP, UP_LEFT, UP_RIGHT;

	private final CardComponent cardComponent = CardComponent.LINK_ARROW;

	@Override
	public String getComponentName() {
		return cardComponent.getComponentName();
	}
}
