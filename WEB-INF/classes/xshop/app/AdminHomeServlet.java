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

import javax.servlet.*;  
import javax.servlet.http.*;  

public class AdminHomeServlet extends HttpServlet{
	  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
        PrintWriter out = resp.getWriter();
        int db_id;
        String db_userid;
        String db_pass;
        String db_name;
        String db_type;

       try{  
  
            resp.setContentType("text/html");   
            //System.out.println("TEST BEFORE SESSION ON");   
            HttpSession session=req.getSession(false); 
            //System.out.println("TEST AFTER SESSION ON");  

            if(session != null) {
                db_id = (int)session.getAttribute("id");
                db_userid = (String)session.getAttribute("userid");
                db_pass = (String)session.getAttribute("password");
                db_name = (String)session.getAttribute("name");
                db_type = (String)session.getAttribute("type");

                if(db_type.equals("Admin")){




            out.println("<html>");
            out.println("<head>");
            out.println("<script>");
            out.println("function registration()");
            out.println("{window.location = 'user-add';}");

            out.println("</script>");
            out.println("</head>");



            out.println("<body>");

            //out.println("<a href='home'> HOME </a>");
             out.println("<center>");
             out.println("<h1>Welcome '"+db_name+"'</h1></br>");
             out.println("<a href='user-profile'>Profile</a></br>");
             out.println("<a href='user-changepass'>Change Password</a></br>");
             out.println("<a href='user-list'>View Users</a></br>");
             out.println("<a href='user-logout'>Logout</a></br>");
             out.println("</center>");

              out.println("</body>");
              out.println("</html>");



                }
                else {

                    System.out.println("ADMIN USER NA");
                    //out.close();  
                    resp.sendRedirect("user-logout");
                 }
            }
            else {
                System.out.println("NULL PAISE");
                //out.close();  
                resp.sendRedirect("user-logout");
            }

            

           
      
        }
        catch(Exception e){
            System.out.println("\n\n\n");
            System.out.println(e);

            System.out.println("EXCEPTION PAISE");

            //out.close();  
            resp.sendRedirect("user-login");
        }  

















	  }
	  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
           
	  }
}