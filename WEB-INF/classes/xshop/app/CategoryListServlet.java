package xshop.app;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.PrintWriter;
import java.io.IOException;

import xshop.entity.Category;
import xshop.core.CategoryService;
import java.util.List;


public class CategoryListServlet extends HttpServlet{
	   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		  PrintWriter out = resp.getWriter();


		  List<Category> ctList = new CategoryService().getAll();


		  out.println("<html>");

		  	out.println("<head>");
			out.println("<script>");
				out.println("function DeleteFunction(id)");
				    out.println("{window.location = 'category-delete?id='+id;}");

				out.println("function EditFunction(id)");
				    out.println("{window.location = 'category-edit?id='+id;}");


				
			out.println("</script>");

			out.println("</head>");

		  out.println("<body>");

		out.println("<a href='category-add'>Add New Category</a>");

		  out.println("<form method='post'>");
		  
		 out.println("<table border='1'>");
		  out.println("<tr>");
		    out.println("<th>Category ID</th>");
		    out.println("<th>Category Name</th>");
		    out.println("<th colspan='2'>Action</th>");
		  out.println("</tr>");




		for(Category ct:ctList){
			out.println("<tr>");
		    out.println("<td>"+ct.getId()+"</td>");
		    out.println("<td>"+ct.getName()+"</td>");

		    out.println("<td> <input type='button' name='Delete' value='Delete' onclick='DeleteFunction("+ct.getId()+")'> </td>");
		    out.println("<td> <input type='button' name='Edit' value='Edit' onclick='EditFunction("+ct.getId()+")'>  </td>");

		 	out.println("</tr>");
		}
		



		out.println("</table>");




		  out.println("</form>");
		  out.println("</body>");
		  out.println("</html>");
	  }
	  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
                //new CategoryService().remove(Integer.parseInt(req.getParameter("id")));

	  	PrintWriter out = resp.getWriter();

	  	out.println(req.getParameter("Delete"));

	  }
}



//out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getPassword()+"</td><td>"+e.getEmail()+"</td><td>"+e.getCountry()+"</td><td><a href='EditServlet?id="+e.getId()+"'>edit</a></td><td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");