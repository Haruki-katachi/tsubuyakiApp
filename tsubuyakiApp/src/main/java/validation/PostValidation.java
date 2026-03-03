package validation;

import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;

public class PostValidation extends Validation {
	
	public PostValidation(HttpServletRequest request) {
		super(request);
	}

	@Override
	public Map<String, String> validate() {
		if(!ValidationUtil.isMinLength(request.getParameter("post"), 1)) {
			this.errors.put("post", "投稿を入力してください");
		}
		if(!ValidationUtil.isMaxLength(request.getParameter("post"), 280)) {
			this.errors.put("post", "投稿は全角140字、半角280字以下にしてください");
		}
		
		return errors;
	}

}
