package com.card.component;

import static com.card.component.CardComponent.LinkArrow;

public enum LinkArrowComponent implements CardSubcomponentInterface {
	Down, DownLeft, DownRight, Left, Right, Up, UpLeft, UpRight;

	private final CardComponent cardComponent = LinkArrow;

	@Override
	public String getComponentName() {
		return cardComponent.getComponentName();
	}
	
	@Override
	public LinkArrowComponent match(String name) {
		for (LinkArrowComponent linkArrowComponent : LinkArrowComponent.class.getEnumConstants())
			if (linkArrowComponent.name().equals(name))
				return linkArrowComponent;
		return null;
	}
	
	@Override
	public String getName() {
		return this.name();
	}
}