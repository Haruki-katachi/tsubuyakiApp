package servlet;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logic.PostLogic;
import model.PostModel;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/PostDelete")
public class PostDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PostModel post = new PostModel();
			post.setId(Integer.parseInt(request.getParameter("postId")));
			
			PostLogic logic = new PostLogic();
			post = logic.findOne(post);
			
			request.setAttribute("post", post);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/deleteCheck.jsp");
			dispatcher.forward(request, response);
			
			return;
		} catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PostModel post = new PostModel();
			post.setId(Integer.parseInt(request.getParameter("postId")));
			
			PostLogic logic = new PostLogic();
			logic.deletePost(post);
			
			response.sendRedirect("Main");
			return;
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
