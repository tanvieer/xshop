import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  

import xshop.entity.UserInfo;
import xshop.core.UserService;

public class ChangePasswordServlet extends HttpServlet{
	int idd;
 	String db_userid;
    String db_pass;
    String db_name;
    String db_type;

	  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

	  	System.out.println("dhukse");  
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
out.println("<a href='home'> HOME </a>");
out.println("<a href='user-list'>Show ALL</a>");
out.println("<a href='user-add'>Add New</a>");

		  out.println("<form method='post'>");
out.println("User ID:<br/><input name='uid' readonly value = "+db_userid+" /><br/>");
		  out.println("User Password:<br/><input name='pass' value = "+db_pass+"/><br/>");
		  out.println("User Name:<br/><input name='name' readonly value = "+db_name+"/><br/>");
		  out.println("User Type: "+db_type+"<br/>");

		  out.println("<input type='submit' value='Update'/>");
		  out.println("</form>");
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