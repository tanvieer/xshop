package xshop.app;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import xshop.entity.UserInfo;
import xshop.core.UserService;

public class UserChangePasswordServlet extends HttpServlet {
    int idd;
    String db_userid;
    String db_pass;
    String db_name;
    String db_type;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        try {

            resp.setContentType("text/html");
            System.out.println("UserChangePasswordServlet TEST BEFORE SESSION ON");
            HttpSession session = req.getSession(false);
            System.out.println("UserChangePasswordServlet TEST AFTER SESSION ON");

            if (session != null) {
                idd = (int) session.getAttribute("id");
                db_userid = (String) session.getAttribute("userid");
                db_pass = (String) session.getAttribute("password");
                db_name = (String) session.getAttribute("name");
                db_type = (String) session.getAttribute("type");

                out.println("<html>");
                out.println("<body>");
                out.println("<center>");
                out.println("<a href='home'> HOME </a>");
                out.println("<h1>Change Password</h1>");

                out.println("<form method='post'>");
                out.println("User ID:<br/><input name='uid' readonly value = "
                        + db_userid + " /><br/>");
                out.println("User Password:<br/><input value = " + db_pass
                        + " name='pass' /><br/>");
                out.println("User Name:<br/><input name='name' value = "
                        + db_name + " readonly /><br/>");
                out.println("User Type: " + db_type + "<br/>");

                out.println("<input type='submit' value='Update'/>");
                out.println("</form>");
                out.println("</center>");
                out.println("</body>");
                out.println("</html>");

            } else
                System.out.println(" UserChangePasswordServlet NULL PAISE");
        } catch (Exception e) {
            System.out.println("\n\n\n");
            System.out.println(e);

            System.out.println("UserChangePasswordServlet EXCEPTION PAISE");

            // out.close();
            // resp.sendRedirect("user-login");
        }

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String userid = db_userid;
        String pass = req.getParameter("pass");
        String name = db_name;
        String type = db_type;

        System.out.println("UserChangePasswordServlet " + userid);
        System.out.println("UserChangePasswordServlet " + pass);
        System.out.println("UserChangePasswordServlet " + name);
        System.out.println("UserChangePasswordServlet " + type);

        UserInfo user = new UserInfo(idd, userid, pass, name, type);
        System.out.println(new UserService().edit(user));

        try {
            HttpSession session = req.getSession();
            session.setAttribute("password", pass);
        } catch (Exception e) {
            System.out.println(e);
        }

        resp.sendRedirect("user-logout");
    }

}