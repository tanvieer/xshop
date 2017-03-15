package xshop.app;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.PrintWriter;
import java.io.IOException;

import xshop.entity.Category;
import xshop.core.CategoryService;

public class CategoryEditServlet extends HttpServlet{
	  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

	  		int id = Integer.parseInt(req.getParameter("id"));
	  		Category category = new CategoryService().getById(id);


		  PrintWriter out = resp.getWriter();
		  out.println("<html>");
		  out.println("<body>");
out.println("<a href='home'> HOME </a>");
out.println("<a href='category-list'>Show ALL</a>");
out.println("<a href='category-add'>Add New</a>");

		  out.println("<form method='post'>");
		  out.println("Category Id:<br/><input name='id' readonly value="+category.getId()+" /><br/>");
		  out.println("New Name:<br/><input name='n_name' value="+category.getName()+"  /><br/>");
		  out.println("<input type='submit' value='Update'/>");
		  out.println("</form>");
		  out.println("</body>");
		  out.println("</html>");
	  }
	  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			
			Category category = new Category(Integer.parseInt(req.getParameter("id")), req.getParameter("n_name"));
                new CategoryService().edit(category);

                resp.sendRedirect("category-list");
	  }
}