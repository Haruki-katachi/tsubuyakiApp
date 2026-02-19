package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logic.AccountLogic;
import model.AccountModel;
import validation.AccountValidation;

/**
 * Servlet implementation class AccountRegisterServlet
 */
public class AccountRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/accountRegister.jsp");
		dispatcher.forward(request, response);
		
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		
		try {
			AccountValidation validation = new AccountValidation(request);
			Map<String, String> errors = validation.validate();
			
			if(validation.hasErrors()) {
				request.setAttribute("errors", errors);
				
				Map<String, String> user = new HashMap<String, String>();
				user.put("email", email);
				user.put("password", password);
				user.put("name", name);
				request.setAttribute("user", user);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/accountRegister.jsp");
				dispatcher.forward(request, response);
				
				return;
			}
			
			AccountModel user = new AccountModel();
			user.setEmail(email);
			user.setPassword(password);
			user.setName(name);
			
			AccountLogic logic = new AccountLogic();
			int ret = logic.create(user);
			
			switch(ret) {
			case 1:
				response.sendRedirect("Login");
				return;
			case 23505:
				request.setAttribute("db_error", "このE-mailアドレスは既に登録されています");
				break;
			default:
				request.setAttribute("db_error", "エラーが発生しました");
				break;
			}
			
			request.setAttribute("user", user);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/accountRegister.jsp");
			dispatcher.forward(request, response);
			
			return;
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
