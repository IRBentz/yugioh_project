package com.card.component;

import java.lang.reflect.InvocationTargetException;

public interface CardComponentInterface {
	CardComponentInterface DEFAULT = null;

	default <T> T castTo(Class<T> t) {
		if (t.isInstance(this))
			return t.cast(this);
		new RuntimeException("Invalid cast from " + this.getClass().toString() + " to " + t.toString()).printStackTrace();
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
	
	public interface SubInterface extends CardComponentInterface {
		@Override
		String getComponentName();
		
		default String getName() {
			try {
				return String.class.cast(Enum.class.getMethod("name").invoke(this));
			} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
			return null;
		}
	}
}