package validation;

import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.validator.routines.RegexValidator;

public class ValidationUtil {
	public static boolean isMaxLength(String str, int length) {
		return str.length() <= length;
	}
	
	public static boolean isMinLength(String str, int length) {
		return str.length() >= length;
	}
	
	public static boolean isEmail(String email) {
		EmailValidator validator = EmailValidator.getInstance();
		return validator.isValid(email);
	}
	
	public static boolean isPassword(String password) {
		RegexValidator validator = new RegexValidator("^[0-9a-zA-Z]{8,20}$");
		return validator.isValid(password);
	}
	
	
}
