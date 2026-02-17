package servlet;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import logic.AccountLogic;
import model.AccountModel;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
		
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AccountModel user = new AccountModel();
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		try {
			AccountLogic logic = new AccountLogic();
			user = logic.findOne(user);
			
			if(user == null) {
				request.setAttribute("error", "E-mailアドレスまたはパスワードが違います");
				
				user = new AccountModel();
				user.setEmail(request.getParameter("email"));
				user.setPassword(request.getParameter("password"));
				request.setAttribute("user", user);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
				dispatcher.forward(request, response);
				
				return;
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			response.sendRedirect("Main");
			
			return;
		} catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return;
		}
	}

}
