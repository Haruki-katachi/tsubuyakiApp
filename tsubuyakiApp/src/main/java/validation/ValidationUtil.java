package validation;

public class ValidationUtil {
	public static boolean isMaxLength(String str, int length) {
		return str.length() <= length;
	}
	
	public static boolean isMinLength(String str, int length) {
		return str.length() >= length;
	}
	
	
}
