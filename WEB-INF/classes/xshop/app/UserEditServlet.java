package xshop.app;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.PrintWriter;
import java.io.IOException;

import xshop.entity.UserInfo;
import xshop.core.UserService;

public class UserEditServlet extends HttpServlet{
	int idd;
	  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

	  		 idd = Integer.parseInt(req.getParameter("id"));
	  		//UserInfo user = new UserService().getById(id);


		  PrintWriter out = resp.getWriter();
		  out.println("<html>");
		  out.println("<body>");
		  out.println("<center>");
out.println("<a href='home'> HOME </a>");
out.println("<a href='user-login'>Login</a>");
out.println("<a href='user-add'>Registration</a>");

		  out.println("<form method='post'>");
out.println("User ID:<br/><input name='uid' /><br/>");
		  out.println("User Password:<br/><input name='pass' /><br/>");
		  out.println("User Name:<br/><input name='name' /><br/>");
		  out.println("User Type:<br/>");

		   out.println("<input type='radio' name='type' value='User'> User<br><input type='radio' name='type' value='Admin'> Admin<br>");

		  out.println("<input type='submit' value='Update'/>");
		  out.println("</form>");
		  out.println("</center>");
		  out.println("</body>");
		  out.println("</html>");
	  }
	  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			
		String userid = req.getParameter("uid");
        String pass = req.getParameter("pass");
        String name = req.getParameter("name");
        String type = req.getParameter("type");

        System.out.println(userid);
        System.out.println(pass);
        System.out.println(name);
        System.out.println(type);


        UserInfo user = new UserInfo(idd,userid,pass,name,type);  
                System.out.println(new UserService().edit(user));

                resp.sendRedirect("user-list");
	  }
}