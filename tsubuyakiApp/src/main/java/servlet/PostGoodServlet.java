package servlet;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logic.GoodLogic;
import model.GoodModel;

/**
 * Servlet implementation class GoodServlet
 */
@WebServlet("/PostGood")
public class PostGoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostGoodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int accountId = Integer.parseInt(request.getParameter("accountId"));
		int postId = Integer.parseInt(request.getParameter("postId"));
		try {
			GoodLogic logic = new GoodLogic();
			GoodModel good = logic.findOne(accountId, postId);
			if(good == null) {
				logic.create(accountId, postId);
				response.sendRedirect("/tsubuyakiApp/Individual?id=" + postId);
				
				return;
			} else if(good != null) {
				if(good.getIsGood() == 1) {
					good.setIsGood(0);
				} else if(good.getIsGood() == 0) {
					good.setIsGood(1);
				}
				
				logic.update(good);
				response.sendRedirect("/tsubuyakiApp/Individual?id=" + postId);
				
				return;
			}
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			
			request.setAttribute("error", "エラーが発生しました");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			dispatcher.forward(request, response);
			return;
		}
	}

}
