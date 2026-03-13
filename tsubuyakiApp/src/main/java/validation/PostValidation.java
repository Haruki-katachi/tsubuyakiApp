package validation;

import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;

public class PostValidation extends Validation {
	
	public PostValidation(HttpServletRequest request) {
		super(request);
	}

	@Override
	public Map<String, String> validate() {
		if(request.getParameter("post") != null) {
			if(!ValidationUtil.isMinLength(request.getParameter("post"), 1)) {
				this.errors.put("post", "投稿を入力してください");
			}
			if(!ValidationUtil.isMaxLength(request.getParameter("post"), 280)) {
				this.errors.put("post", "投稿は280文字以下にしてください");
			}
		} else if(request.getParameter("reply") != null) {
			if(!ValidationUtil.isMinLength(request.getParameter("reply"), 1)) {
				this.errors.put("post", "投稿を入力してください");
			}
			if(!ValidationUtil.isMaxLength(request.getParameter("reply"), 280)) {
				this.errors.put("post", "投稿は280文字以下にしてください");
			}
		}
		
		return errors;
	}

}
