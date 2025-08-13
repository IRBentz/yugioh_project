package com.testing;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import com.card.component.CardComponent;

public class EnumClassLoading {
	public static void main(String args[]) {
		CardComponent component = CardComponent.TYPE;
		try {
			Arrays.asList(Class.forName("com.card.component." + component.name() + "Component").getEnumConstants()).forEach(System.out::println);
			Arrays.asList(Class.forName("com.card.component." + component.name() + "Component").getClass().getMethod("getEnumConstants").invoke(Object.class)).forEach(enums -> System.out.println(enums));
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | SecurityException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
