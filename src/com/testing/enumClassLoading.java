package com.testing;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import com.card.component.CardComponent;

public class enumClassLoading {
	public static void main(String args[]) {
		CardComponent component = CardComponent.Type;
		try {
			Arrays.asList(Class.forName("com.card.component." + component.name() + "Component").getEnumConstants()).forEach(method -> System.out.println(method));
			Arrays.asList(Class.forName("com.card.component." + component.name() + "Component").getClass().getMethod("getEnumConstants").invoke(Object.class)).forEach(enums -> System.out.println(enums));
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | SecurityException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
