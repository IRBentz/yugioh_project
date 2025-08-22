package com.card.component;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

public interface CardComponentInterface {
	CardComponentInterface DEFAULT = null;
	Logger logger = Logger.getLogger(CardComponentInterface.class.getName());
	
	/**
	 * @deprecated 
	 * @since 0.0.1
	 * @param <T>
	 * @param Class to cast to
	 * @return Object this is called on cast to class T or null
	 */
	@Deprecated(since="0.0.1", forRemoval=true)
	default <T> T castTo(Class<T> t) {
		if (t.isInstance(this))
			return t.cast(this);
		new RuntimeException("Invalid cast from " + this.getClass().toString() + " to " + t.toString()).printStackTrace();
		return null;
	}
	
	/**
	 * 
	 * @return Object name this is called on in camel case
	 */
	default String getName() {
		String[] sa;
		try {
			sa = ((String) Enum.class.getMethod("name").invoke(this)).split("_");
			StringBuilder sb = new StringBuilder();
			for (String s : sa) {
				sb.append(s.substring(0,1)).append(s.substring(1).toLowerCase());
			}
			return sb.toString();
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			logger.log(Level.SEVERE, "An error occured", e);
		}
		return null;
	}
	
	/**
	 * 
	 * @return See {@link getName()}
	 */
	default String getComponentName() {
		return getName();
	}
	
	/**
	 * 
	 * @param name to match to <CardComponentInterface> enum.
	 * @return matched enum as an <CardComponentInterface> object.
	 */
	default CardComponentInterface match(String name) {
		for (CardComponentInterface component : this.getClass().getEnumConstants())
			try {
				if (CardComponentInterface.class.getMethod("getName").invoke(component).equals(name))
					return component;
			} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
				logger.log(Level.SEVERE, "An error occured", e);
			}
		return null;
	}
	
	interface SubInterface extends CardComponentInterface {
		@Override
		String getComponentName();
	}
}
