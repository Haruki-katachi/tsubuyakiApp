package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logic.PostLogic;
import model.PostModel;
import validation.PostValidation;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PostLogic logic = new PostLogic();
			
			List<PostModel> postList = logic.findAll();
			request.setAttribute("postList", postList);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
			
			return;
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int accountId = Integer.parseInt(request.getParameter("accountId"));
		String post = request.getParameter("post");
		
		try {
			PostValidation validation = new PostValidation(request);
			Map<String, String> errors = validation.validate();
			
			if(validation.hasErrors()) {
				request.setAttribute("errors", errors);
			
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
				dispatcher.forward(request, response);
			
				return;
			}
			
			PostModel model = new PostModel();
			model.setAccountId(accountId);
			model.setItem(post);
		
			PostLogic logic = new PostLogic();
			int ret = logic.createPost(model);
			if(ret != 1) {
				errors.put("dbError", "エラーが発生しました");
				request.setAttribute("errors", errors);
			}
			List<PostModel> postList = logic.findAll();
			request.setAttribute("postList", postList);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
			
			return;
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
