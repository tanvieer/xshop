package xshop.app;
import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  

import xshop.entity.UserInfo;
import xshop.core.UserService;

public class UserProfileServlet extends HttpServlet{
	int idd;
 	String db_userid;
    String db_pass;
    String db_name;
    String db_type;

	  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{


	  	PrintWriter out = resp.getWriter();

        try{  
  
            resp.setContentType("text/html");   
            System.out.println("TEST BEFORE SESSION ON");   
            HttpSession session=req.getSession(false); 
            System.out.println("TEST AFTER SESSION ON");  

            if(session != null) {
                idd = (int)session.getAttribute("id");
                db_userid = (String)session.getAttribute("userid");
                db_pass = (String)session.getAttribute("password");
                db_name = (String)session.getAttribute("name");
                db_type = (String)session.getAttribute("type");










          out.println("<html>");
		  out.println("<body>");
		  out.println("<center>");
out.println("<a href='home'> HOME </a></br><hr>");

out.println("User ID: <b>"+db_userid+"</b><br/>");
		  out.println("User Password: <b>"+db_pass+"</b><br/>");
		  out.println("User Name: <b>"+db_name+"</b><br/>");
		  out.println("User Type: <b>"+db_type+"</b><br/>");

		  out.println("</center>");
		  out.println("</body>");
		  out.println("</html>");




            }
            else  System.out.println("NULL PAISE");  
        }
       catch(Exception e){
        System.out.println("\n\n\n");
        System.out.println(e);

        System.out.println("EXCEPTION PAISE");

            //out.close();  
           // resp.sendRedirect("user-login");
        }  



		  
	  }
	  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			
	  }
}