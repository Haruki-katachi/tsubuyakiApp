package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logic.PostLogic;
import model.PostModel;
import validation.PostValidation;

/**
 * Servlet implementation class InvididualServlet
 */
@WebServlet("/Individual")
public class IndividualServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndividualServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PostModel post = new PostModel();
			post.setId(Integer.parseInt(request.getParameter("id")));
		
			PostLogic logic = new PostLogic();
			post = logic.findOne(post);
			
			request.setAttribute("post", post);
			
			List<PostModel> replyList = logic.findByReply(post);
			
			request.setAttribute("replyList", replyList);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/individual.jsp");
			dispatcher.forward(request, response);
			
			return;
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int accountId = Integer.parseInt(request.getParameter("accountId"));
		Integer toId = Integer.parseInt(request.getParameter("toId"));
		String reply = request.getParameter("reply");
		
		try {
			PostValidation validation = new PostValidation(request);
			Map<String, String> errors = validation.validate();
			
			if(validation.hasErrors()) {
				request.setAttribute("errors", errors);
				
				request.setAttribute("reply", reply);
				
				PostModel post = new PostModel();
				post.setId((Integer)toId);
				
				PostLogic logic = new PostLogic();
				post = logic.findOne(post);
				
				request.setAttribute("post", post);
				
				List<PostModel> replyList = logic.findByReply(post);
				
				request.setAttribute("replyList", replyList);
				
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/individual.jsp");
				dispatcher.forward(request, response);
				
				return;
			}
			
			PostModel model = new PostModel();
			model.setAccountId(accountId);
			model.setToId(toId);
			model.setItem(reply);
			
			PostLogic logic = new PostLogic();
			int ret = logic.createRply(model);
			if(ret != 1) {
				errors.put("dbError", "エラーが発生しました");
				request.setAttribute("errors", errors);
			}
			
			PostModel post = new PostModel();
			post.setId((Integer)toId);
			
			post = logic.findOne(post);
			
			request.setAttribute("post", post);
			
			List<PostModel> replyList = logic.findByReply(post);
			
			request.setAttribute("replyList", replyList);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/individual.jsp");
			dispatcher.forward(request, response);
			
			return;
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			
			
		}
	}

}
