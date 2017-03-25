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

public class UserListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		List<UserInfo> ctList = new UserService().getAll();

		out.println("<html>");

		out.println("<head>");
		out.println("<script>");
		out.println("function DeleteFunction(id)");
		out.println("{window.location = 'user-delete?id='+id;}");

		out.println("function EditFunction(id)");
		out.println("{window.location = 'user-edit?id='+id;}");

		out.println("</script>");

		out.println("</head>");

		out.println("<body>");
		out.println("<center>");
		out.println("<a href='home'> HOME </a>");
		out.println("<a href='user-add'>Registration</a>");

		out.println("<form method='post'>");

		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<th>User ID</th>");
		out.println("<th>User Name</th>");
		out.println("<th>User Password</th>");
		out.println("<th>User Type</th>");
		out.println("<th colspan='2'>Action</th>");
		out.println("</tr>");

		for (UserInfo ct : ctList) {
			out.println("<tr>");
			out.println("<td>" + ct.getUserId() + "</td>");
			out.println("<td>" + ct.getName() + "</td>");
			out.println("<td>" + ct.getPassword() + "</td>");
			out.println("<td>" + ct.getUserType() + "</td>");

			out.println("<td> <input type='button' name='Delete' value='Delete' onclick='DeleteFunction("
					+ ct.getId() + ")'> </td>");
			out.println("<td> <input type='button' name='Edit' value='Edit' onclick='EditFunction("
					+ ct.getId() + ")'>  </td>");

			out.println("</tr>");
		}

		out.println("</table>");

		out.println("</form>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// new userService().remove(Integer.parseInt(req.getParameter("id")));

		// PrintWriter out = resp.getWriter();

		// out.println(req.getParameter("Delete"));

	}
}
