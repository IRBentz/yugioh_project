package yugioh.card.component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum LinkArrowComponent implements CardComponentInterface.SubInterface {
	DOWN_LEFT(0x1), DOWN(0x2), DOWN_RIGHT(0x4), LEFT(0x8), RIGHT(0x20), UP_LEFT(0x40), UP(0x80), UP_RIGHT(0x100);

	private final CardComponent cardComponent = CardComponent.LINK_ARROW;

	final int numericIden;
	public int getNumericIden() {
		return numericIden;
	}

	LinkArrowComponent(final int numericIden) {
		this.numericIden = numericIden;
	}
	@Override
	public String getComponentName() {
		return cardComponent.getComponentName();
	}

	public static List<LinkArrowComponent> evalIntToList(int num) {
		if(num <= 0) {
			return new ArrayList<>();
		}
		for(LinkArrowComponent arrow : Arrays.asList(values()).reversed()) {
			if(num >= arrow.numericIden) {
				List<LinkArrowComponent> matchedList = evalIntToList(num - arrow.numericIden);
				matchedList.add(arrow);
				return matchedList;
			}
		}
		return new ArrayList<>();
	}
}
/*
DL 0x1 1
D 0x2 2
DR 0x4 4
L 0x8 8
R 0x20 32
UL 0x40 64
U 0x80 128
UR 0x100 256
 */
