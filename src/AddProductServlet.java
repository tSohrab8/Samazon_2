

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DbProduct;
import model.Product;
import model.User;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
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
		User u = (User) session.getAttribute("user");
		
		if (u.getRole().equals("standard")){
			response.sendRedirect(request.getContextPath());
			return;
		}

		String name = request.getParameter("name");
		String description = request.getParameter("description");
		Integer count = Integer.parseInt(request.getParameter("count"));
		System.out.println("reaches");
		Float price = Float.parseFloat(request.getParameter("price"));
		String url = request.getParameter("url");
		
		Product prod = new Product();
		prod.setProductname(name);
		prod.setDescription(description);
		prod.setProductcount(count);
		prod.setPrice(price);
		prod.setImageURL(url);
		
		DbProduct.insert(prod);
		
		response.sendRedirect(request.getContextPath());
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
