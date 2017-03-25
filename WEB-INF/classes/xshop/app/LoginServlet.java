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

public class LoginServlet extends HttpServlet {
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    PrintWriter out = resp.getWriter();

    Cookie[] cookies = req.getCookies();

    if (cookies != null && cookies.length > 2) {

      String db_id = "";
      String db_userid = "";
      String db_pass = "";
      String db_name = "";
      String db_type = "";
      System.out.println("login servlet cookie null paini");

      for (Cookie cookie : cookies) {
        // System.out.println("login servlet test loop");
        if (cookie.getName().equals("id")) {
          db_id = cookie.getValue();
        }

        else if (cookie.getName().equals("userid")) {
          db_userid = cookie.getValue();
        }

        else if (cookie.getName().equals("name")) {
          db_name = cookie.getValue();
        }

        else if (cookie.getName().equals("type")) {
          db_type = cookie.getValue();
        }
      }

      UserService us = new UserService();
      UserInfo user = us.getByUserId(db_userid);
      db_pass = user.getPassword();
      // db_pass = "cookie";
      System.out.println(" login servlet test db pass =" + db_pass);

      try {
        System.out
            .println("login servlet cookie theke session set kora start");
        HttpSession session = req.getSession();
        session.setAttribute("id", user.getId());
        session.setAttribute("userid", db_userid);
        session.setAttribute("password", db_pass);
        session.setAttribute("name", db_name);
        session.setAttribute("type", user.getUserType());

        System.out
            .println("login servlet cookie theke session set kora end");

        if (db_type.equals("Admin"))
          resp.sendRedirect("user-admin");
        else if (db_type.equals("User"))
          resp.sendRedirect("user-user");

      } catch (Exception e) {
        System.out
            .println("login servlet Cookie check a exception paise");
      }
    } else {

      System.out.println("login servlet cookie null paise");

      int d_id;
      String d_userid;
      String d_pass;
      String d_name;
      String d_type;

      try {

        resp.setContentType("text/html");
        // System.out.println("TEST BEFORE SESSION ON");
        HttpSession ssn = req.getSession(false);
        // System.out.println("TEST AFTER SESSION ON");

        if (ssn != null) {
          System.out.println("test 1");
          d_userid = (String) ssn.getAttribute("userid");
          System.out.println("test 2");
          d_id = (int) ssn.getAttribute("id");
          System.out.println("test 3");
          d_pass = (String) ssn.getAttribute("password");
          System.out.println("test 4");
          d_name = (String) ssn.getAttribute("name");
          System.out.println("test 5");
          d_type = (String) ssn.getAttribute("type");
          System.out.println("test 6");

          System.out.println("login servlet check session d_id= "
              + d_id);
          System.out.println("login servlet check session d_userid= "
              + d_userid);
          System.out.println("login servlet check session d_pass= "
              + d_pass);
          System.out.println("login servlet check session d_name= "
              + d_name);
          System.out.println("login servlet check session d_type= "
              + d_type);

          if (d_type.equals("Admin"))
            resp.sendRedirect("user-admin");
          else if (d_type.equals("User"))
            resp.sendRedirect("user-user");

        }
      } catch (Exception e) {
        System.out.println("LoginServlet sesson check exception");
      }

      out.println("<html>");
      out.println("<head>");
      out.println("<script>");
      out.println("function registration()");
      out.println("{window.location = 'user-add';}");

      out.println("</script>");
      out.println("</head>");

      out.println("<body>");
      out.println("<center>");
      out.println("<a href='home'> HOME </a>");
      out.println("<h1>Login</h1>");

      out.println("<form method='post'>");
      out.println("User ID:<br/><input name='uid' required /><br/>");
      out.println("User Password:<br/><input name='pass' required /><br/></br>");
      out.println("<input type='checkbox' name='remember' value='remember'> Remember Me<br>");

      out.println("<input type='submit' value='Login'/>");
      out.println("<input type='button' onClick='registration()' value='Registration'/>");
      out.println("</form>");
      out.println("</center>");
      out.println("</body>");
      out.println("</html>");
    }

  }

  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    String userid = req.getParameter("uid");
    String pass = req.getParameter("pass");
    String remember = req.getParameter("remember");

    UserService us = new UserService();
    UserInfo user = us.getByUserId(userid);
    PrintWriter out = resp.getWriter();

    System.out.println("login servlet null check");
    if (user != null) {
      int db_id = user.getId();
      String db_userid = user.getUserId();
      String db_pass = user.getPassword();
      String db_name = user.getName();
      String db_type = user.getUserType();

      if (pass.equals(db_pass)) {
        try {
          HttpSession session = req.getSession();
          session.setAttribute("id", db_id);
          session.setAttribute("userid", db_userid);
          session.setAttribute("password", db_pass);
          session.setAttribute("name", db_name);
          session.setAttribute("type", db_type);
          System.out
              .println("login servlet doPost a session add hoise");

          if (remember != null) {

            Cookie ck = new Cookie("id", String.valueOf(db_id));// creating
                                      // cookie
                                      // object
            ck.setMaxAge(10000);
            resp.addCookie(ck);// adding cookie in the response

            ck = new Cookie("userid", db_userid);
            ck.setMaxAge(10000);
            resp.addCookie(ck);

            ck = new Cookie("name", db_name);
            ck.setMaxAge(10000);
            resp.addCookie(ck);

            ck = new Cookie("type", db_type);
            ck.setMaxAge(10000);
            resp.addCookie(ck);
            System.out
                .println("login servlet doPost a cookie add hoise");

          }

          out.println("Successfully logged in!!");

          if (db_type.equals("Admin"))
            resp.sendRedirect("user-admin");
          else if (db_type.equals("User"))
            resp.sendRedirect("user-user");
        } catch (Exception e) {
          System.out.println(e);
        }
      } else
        out.println("Password not matched!!");
    } else {

      out.println("Username not exist!!");

    }

    out.close();

  }
}