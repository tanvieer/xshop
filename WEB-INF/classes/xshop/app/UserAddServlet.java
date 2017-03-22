package xshop.app;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.PrintWriter;
import java.io.IOException;

import xshop.entity.UserInfo;
import xshop.core.UserService;
import java.util.List;

public class UserAddServlet extends HttpServlet{
	  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		  PrintWriter out = resp.getWriter();
		  out.println("<html>");
		  out.println("<body>");
		out.println("<a href='home'> HOME </a>");
		out.println("<a href='user-list'>Show ALL User</a>");
                out.println("<h1>Registration</h1>");
		  out.println("<form method='post'>");
		  out.println("User ID:<br/><input name='uid' /><br/>");
		  out.println("User Password:<br/><input name='pass' /><br/>");
		  out.println("Confirm Password:<br/><input name='c_pass' /><br/>");

		  out.println("User Name:<br/><input name='name' /><br/>");
		  out.println("User Type:<br/>");

		   out.println("<input type='radio' name='type' value='User'> User<br><input type='radio' name='type' value='Admin'> Admin<br>");

		  out.println("<input type='submit' value='Save'/>");
		  out.println("</form>");
		  out.println("</body>");
		  out.println("</html>");
	  }
	  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
        

        String userid = req.getParameter("uid");
        String pass = req.getParameter("pass");
        String name = req.getParameter("name");
        String type = req.getParameter("type");
        String cpass = req.getParameter("c_pass");

        System.out.println(userid);
        System.out.println(pass);
        System.out.println(name);
        System.out.println(type);

        boolean check = true;

        List<UserInfo> ctList = new UserService().getAll();
        PrintWriter out = resp.getWriter();

        for(UserInfo ct:ctList){

        	String oldid = ct.getUserId();
        	System.out.println("test: "+oldid);
        	if(userid.equals(oldid)){
        		check = false;
        		break;
        	}
        }

        if(pass.equals(cpass) && check){
        	 UserInfo user = new UserInfo(userid,pass,name,type);  
                System.out.println(new UserService().add(user));
                resp.sendRedirect("user-list");

        }
        else if(!check){
        	out.println("User id already exist");
        }
        else {
        	
        	out.println("Password not matched");
        }
       
	  }
}