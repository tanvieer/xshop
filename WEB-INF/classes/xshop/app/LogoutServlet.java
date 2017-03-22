package xshop.app;
import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  

public class LogoutServlet extends HttpServlet{
	  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		  PrintWriter out = resp.getWriter();

          HttpSession session = req.getSession(false);
            if (session != null) {
                session.invalidate();
                out.println("Successfully logged out");
            }
            else {
                out.println("Already Empty Session");
            }
		 
	  }
	  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
        
	  }
}