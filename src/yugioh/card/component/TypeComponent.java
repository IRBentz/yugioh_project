package yugioh.card.component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum TypeComponent implements CardComponentInterface.SubInterface {
	NORMAL(0x10), EFFECT(0x10), FUSION(0x40), RITUAL(0x80), TRAPMONSTER(0x100), SPIRIT(0x200), UNION(0x400), GEMINI(0x800), TUNER(0x1000), SYNCHRO(0x2000), FLIP(0x200000), TOON(0x400000), XYZ(0x800000), PENDULUM(0x1000000), LINK(0x4000000);

	private final CardComponent cardComponent = CardComponent.TYPE;

	final int numericIden;
	public int getNumericIden() {
		return numericIden;
	}

	TypeComponent(final int numericIden) {
		this.numericIden = numericIden;
	}

	@Override
	public String getComponentName() {
		return cardComponent.getComponentName();
	}

	public static List<TypeComponent> evalIntToList(int num) {
		if(num <= 0) {
			return new ArrayList<>();
		}
		for(TypeComponent arrow : Arrays.asList(values()).reversed()) {
			if(num >= arrow.numericIden) {
				List<TypeComponent> matchedList = evalIntToList(num - arrow.numericIden);
				matchedList.add(arrow);
				return matchedList;
			}
		}
		return new ArrayList<>();
	}
}

/*
TYPE_NORMAL      = 0x10
TYPE_EFFECT      = 0x20
TYPE_FUSION      = 0x40
TYPE_RITUAL      = 0x80
TYPE_TRAPMONSTER = 0x100
TYPE_SPIRIT      = 0x200
TYPE_UNION       = 0x400
TYPE_GEMINI      = 0x800
TYPE_TUNER       = 0x1000
TYPE_SYNCHRO     = 0x2000
 */
