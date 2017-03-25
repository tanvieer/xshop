package xshop.app;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xshop.entity.Category;
import xshop.core.CategoryService;

public class CategoryDeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		PrintWriter out = resp.getWriter();

		out.println(new CategoryService().remove(id));
		out.println(id);
		// resp.sendRedirect("http://localhost:82/xshop/category-list");
		resp.sendRedirect("category-list");
	}
}