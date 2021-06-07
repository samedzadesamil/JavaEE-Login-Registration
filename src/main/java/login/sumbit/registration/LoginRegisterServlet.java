package login.sumbit.registration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/loginRegister")
public class LoginRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerDAO cd=new CustomerDAOImpl();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String sumbitType=request.getParameter("sumbit");
		Customer c=cd.getCustomer(username, password);
		
		
		if(sumbitType.equals("login")&&c!=null &&c.getName()!=null) {
			request.setAttribute("message", c.getName());
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}else if(sumbitType.equals("register")) {
			Customer customer=new Customer();
			customer.setName(name);
			customer.setUsername(username);
			customer.setPassword(password);
			cd.insertCustomer(customer);
			request.setAttribute("successMessage", "Indi daxil ola bilersiniz");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			request.setAttribute("message", "giris bilgileri sehvdir qeydiyyatdan kecin");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
