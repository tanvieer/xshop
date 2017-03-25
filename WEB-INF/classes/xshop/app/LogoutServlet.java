package xshop.app;
import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  

public class LogoutServlet extends HttpServlet{
	  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		  PrintWriter out = resp.getWriter();

    try{


           Cookie ckr[]=req.getCookies();  
            for(int i=0;i<ckr.length;i++){  

                ckr[i].setMaxAge(0);
                resp.addCookie(ckr[i]);
            } 

            Cookie ckrp[]=req.getCookies();  
            for(int i=0;i<ckrp.length;i++){  
             System.out.println("LogoutServlet cookie delet hoise. length ="+ ckrp.length);//printing name and value of cookie  
            } 

        }catch (Exception e){}

          HttpSession session = req.getSession(false);
            if (session != null) {
                session.invalidate();
                out.println("LogoutServlet Successfully logged out");

                resp.sendRedirect("user-login");
            }
            else {
                out.println("LogoutServlet Already Empty Session");
                resp.sendRedirect("user-login");
            }
		 
	  }
	  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
        
	  }
}