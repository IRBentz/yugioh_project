package com.testing;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.card.component.CardComponent;

public class EnumClassLoading {
	public static void main(String[] args) {
		CardComponent component = CardComponent.TYPE;
		Logger logger = Logger.getLogger(EnumClassLoading.class.getName());
		try {
			Class<?> clazz = Class.forName("com.card.component." + component.getName() + "Component");
			Arrays.asList(clazz.getEnumConstants()).forEach(componentEnum -> logger.log(Level.INFO, componentEnum.toString()));
		} catch (SecurityException | ClassNotFoundException e) {
			logger.log(Level.SEVERE, "An error occured", e);
		}
	}
}
