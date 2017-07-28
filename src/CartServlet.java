

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DbCart;
import customTools.DbProduct;
import customTools.DbUserorder;
import model.Cart;
//import model.Cart;
import model.Product;
import model.User;
import model.Userorder;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
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
		String nextURL;
		
	    if (session.getAttribute("user") == null){
	        //http://stackoverflow.com/questions/13638446/checking-servlet-session-attribute-value-in-jsp-file
	        nextURL = "/login.jsp";
	        response.sendRedirect(request.getContextPath() + nextURL);
	        return;//return prevents an error; Don't believe me? Take it out.
	    }
	    
		User u = (User) session.getAttribute("user");
		int orderid = u.getCurrentorderid();
		
		if (request.getParameter("remove") != null){
			int remove = Integer.parseInt(request.getParameter("remove"));
			DbCart.delete(DbCart.getCart(remove));
		}

		if ((request.getParameter("productid") != null) && (request.getParameter("quantity") != null)){
			int productid = Integer.parseInt(request.getParameter("productid"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			Cart c = new Cart();
			Product p = DbProduct.getProduct(productid);
			Userorder uo = DbUserorder.getUserOrder(orderid);
			c.setProduct(p);
			c.setQuantity(quantity);
			c.setUserorder(uo);
	
			DbCart.insert(c);
		}
		
		Userorder uo = DbUserorder.getUserOrder(orderid);
		
		List<Cart> shoppingCart = DbCart.listOfCarts(uo);
		double subtotal = 0;
		Iterator<Cart> iter = shoppingCart.iterator();
		
		while(iter.hasNext()){
			Cart c = iter.next();
			subtotal += (c.getProduct().getPrice() * c.getQuantity());
		}
		
		session.setAttribute("shoppingCart", shoppingCart);
		session.setAttribute("subtotal", subtotal);
		getServletContext().getRequestDispatcher("/cart.jsp").forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
