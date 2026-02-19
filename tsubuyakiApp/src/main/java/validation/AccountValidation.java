package validation;

import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;

public class AccountValidation extends Validation {

	public AccountValidation(HttpServletRequest request) {
		super(request);
	}

	@Override
	public Map<String, String> validate() {
		
		if(!ValidationUtil.isEmail(this.request.getParameter("email"))) {
			this.errors.put("email", "正しいE-mailアドレスを入力してください");
		}
		
		if(!ValidationUtil.isPassword(this.request.getParameter("password"))) {
			this.errors.put("password", "半角英数字で8文字以上20文字以下で入力してください");
		}
		
		if(!ValidationUtil.isMinLength(this.request.getParameter("name"), 1)) {
			this.errors.put("name", "ニックネームは必ず入力してください");
		}
		
		if(!ValidationUtil.isMaxLength(this.request.getParameter("name"), 50)) {
			this.errors.put("name", "ニックネームは50文字以下で入力してください");
		}
		
		return this.errors;
	}
	
	
}
