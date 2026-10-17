package yugioh.io.exception;

import org.json.JSONException;

public class DBJSONExcpetion extends JSONException implements DBException {
	private static final long serialVersionUID = 1L;

	public DBJSONExcpetion(String message) {
		super(message);
	}
	
}
