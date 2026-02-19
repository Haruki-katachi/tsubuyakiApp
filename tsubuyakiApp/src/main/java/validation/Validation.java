package validation;

import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;

public abstract class Validation {
	protected HttpServletRequest request;
	protected Map<String, String> errors;
	
	public Validation(HttpServletRequest request) {
		this.request = request;
		this.errors = new HashMap<String, String>();
	}
	
	public boolean hasErrors() {
		if(errors.size() > 0) {
			return true;
		}
		return false;
	}
	
	public abstract Map<String, String> validate();
}
