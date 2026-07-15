package yugioh.io;

public enum SqlTypes {
	INTEGER(Integer.class), TEXT(String.class);

	private Class<?> dataType;

	SqlTypes(Class<?> clazz) {
		dataType = clazz;
	}

	public Class<?> getDataType() {
		return dataType;
	}

	@Override
	public String toString() {
		return "[" + name() + ", " + dataType.getCanonicalName() + "]";
	}
}
