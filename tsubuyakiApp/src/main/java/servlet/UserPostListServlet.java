package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import logic.PostLogic;
import model.AccountModel;
import model.PostModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Servlet implementation class UserPostListServlet
 */
@WebServlet("/UserPostList")
public class UserPostListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserPostListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			if(session.getAttribute("user") == null) {
				response.sendRedirect("Login");
				
				return;
			}
			AccountModel user = (AccountModel)session.getAttribute("user");
			PostLogic logic = new PostLogic();
			
			List<PostModel> postList = logic.findByAccountId(user);
			request.setAttribute("postList", postList);
			
			request.setAttribute("listType", "投稿一覧");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/listView.jsp");
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
