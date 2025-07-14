package com.card.component;

import java.lang.reflect.InvocationTargetException;

public interface CardSubcomponentInterface extends CardComponentInterface{
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