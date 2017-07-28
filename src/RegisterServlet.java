

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import customTools.DbUser;
import customTools.DbUserorder;
import model.User;
import model.Userorder;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User n = new User();
		n.setUsername(name);
		n.setEmail(email);
		n.setPw(password);
		n.setCurrentorderid(DbUserorder.getCount() + 1);
		n.setRole("standard");
		DbUser.insert(n);
		
		Userorder u = new Userorder();
		u.setUser(DbUser.getUserByEmail(email));
		u.setOrderid(DbUserorder.getCount() + 1);
		DbUserorder.insert(u);
		
		request.setAttribute("message", "Your account has been registered. Please log in.");
		getServletContext().getRequestDispatcher("/login.jsp").forward(request,response);
		//response.sendRedirect(request.getContextPath() + "/login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
