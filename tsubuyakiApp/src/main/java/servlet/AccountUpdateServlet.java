package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import logic.AccountLogic;
import model.AccountModel;
import validation.AccountValidation;

/**
 * Servlet implementation class AccountUpdateServlet
 */
@WebServlet("/AccountUpdate")
public class AccountUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/accountUpdate.jsp");
		dispatcher.forward(request, response);
		
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/accountUpdate.jsp");
				dispatcher.forward(request, response);
				
				return;
			}
			HttpSession session = request.getSession();
			if(session.getAttribute("user") == null) {
				response.sendRedirect("Login");
				
				return;
			}
			AccountModel sessionUser = (AccountModel)session.getAttribute("user");
			
			AccountModel updateUser = new AccountModel();
			updateUser.setId(sessionUser.getId());
			updateUser.setEmail(email);
			updateUser.setPassword(password);
			updateUser.setName(name);
			
			AccountLogic logic = new AccountLogic();
			int ret = logic.update(updateUser);
			switch(ret) {
			case 1:
				session.removeAttribute("user");
				response.sendRedirect("Main");
				
				return;
			case 23505:
				request.setAttribute("db_error", "このE-mailアドレスは既に登録されています");
				break;
			default:
				request.setAttribute("db_error", "エラーが発生しました");
				break;
			}
			
			request.setAttribute("user", updateUser);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/accountUpdate.jsp");
			dispatcher.forward(request, response);
			
			return;
		} catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			
			request.setAttribute("error", "エラーが発生しました");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			dispatcher.forward(request, response);
			return;
		}
	}

}
