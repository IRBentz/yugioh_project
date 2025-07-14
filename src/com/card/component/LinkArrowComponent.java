package com.card.component;

import static com.card.component.CardComponent.LinkArrow;

public enum LinkArrowComponent implements CardSubcomponentInterface {
	Down, DownLeft, DownRight, Left, Right, Up, UpLeft, UpRight;

	private final CardComponent cardComponent = LinkArrow;

	@Override
	public String getComponentName() {
		return cardComponent.getComponentName();
	}
}