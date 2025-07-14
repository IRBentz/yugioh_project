package com.card.component;

import java.lang.reflect.InvocationTargetException;

public interface CardComponentInterface {
	default <T> T castTo(Class<T> t) {
		if (t.isInstance(this))
			return t.cast(this);
		return null;
	}
	default String getComponentName() {
		try {
			return String.class.cast(Enum.class.getMethod("name").invoke(this));
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	default CardComponentInterface match(String name) {
		for (CardComponentInterface component : this.getClass().getEnumConstants())
			try {
				if (Enum.class.getMethod("name").invoke(component).equals(name))
					return component;
			} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
		return null;
	}
}