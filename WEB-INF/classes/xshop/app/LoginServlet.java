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

public class LoginServlet extends HttpServlet{
	  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		  PrintWriter out = resp.getWriter();
		  out.println("<html>");
out.println("<head>");
out.println("<script>");
out.println("function registration()");
out.println("{window.location = 'user-add';}");

out.println("</script>");
out.println("</head>");



		  out.println("<body>");
		out.println("<a href='home'> HOME </a>");
                out.println("<h1>Login</h1>");

		  out.println("<form method='post'>");
		  out.println("User ID:<br/><input name='uid' /><br/>");
		  out.println("User Password:<br/><input name='pass' /><br/>");
		  
		  out.println("<input type='submit' value='Login'/>");
                  out.println("<input type='button' onClick='registration()' value='Registration'/>");
		  out.println("</form>");
		  out.println("</body>");
		  out.println("</html>");
          out.close();  
	  }
	  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
        

                String userid = req.getParameter("uid");
                String pass = req.getParameter("pass");



                UserService us=new UserService();
                UserInfo user= us.getByUserId(userid);
                PrintWriter out = resp.getWriter();


                if(user != null){
                        int db_id = user.getId();
                        String db_userid = user.getUserId();
                        String db_pass = user.getPassword();
                        String db_name = user.getName();
                        String db_type = user.getUserType();

                        if(pass.equals(db_pass)){
                         try{  
                           HttpSession session=req.getSession();  
                                session.setAttribute("id",db_id);
                                session.setAttribute("userid",db_userid);
                                session.setAttribute("password",db_pass);
                                session.setAttribute("name",db_name);
                                session.setAttribute("type",db_type);

                                out.println("Successfully logged in!!");

                                if(db_type.equals("Admin"))
                                    resp.sendRedirect("user-admin");
                                else  if(db_type.equals("User"))
                                    resp.sendRedirect("user-user");
                            }
                         catch(Exception e){System.out.println(e);}  
                        }
                        else out.println("Password not matched!!");
                }
                else {
                        
                        out.println("Username not exist!!");

                }


                 out.close();  
                
	  }
}