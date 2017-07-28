import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DbCart;
import customTools.DbUser;
import customTools.DbUserorder;
import model.Cart;
import model.User;
import model.Userorder;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		String action = request.getParameter("placeorder");
		
		User user = (User) session.getAttribute("user");
		
		if (action != null){
			//Create new Userorder entry, assign current user to it
			Userorder u = new Userorder();
			u.setUser(user);
			DbUserorder.insert(u);
			
			//Update our user's current order id field
			user.setCurrentorderid(DbUserorder.getCount());
			DbUser.update(user);
		}
		
		List<Cart> orderHistory = DbCart.listOfCarts(user.getUserid(),user.getCurrentorderid());
		
		session.setAttribute("user", user);
		session.setAttribute("orderHistory", orderHistory);
		
		response.sendRedirect(request.getContextPath() + "/orders.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
