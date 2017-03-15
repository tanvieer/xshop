package xshop.app;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.PrintWriter;
import java.io.IOException;

import xshop.entity.Supplier;
import xshop.core.SupplierService;
import java.util.List;


public class SupplierListServlet extends HttpServlet{
	   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		  PrintWriter out = resp.getWriter();


		  List<Supplier> ctList = new SupplierService().getAll();


		  out.println("<html>");

		  	out.println("<head>");
			out.println("<script>");
				out.println("function DeleteFunction(id)");
				    out.println("{window.location = 'supplier-delete?id='+id;}");

				out.println("function EditFunction(id)");
				    out.println("{window.location = 'supplier-edit?id='+id;}");


				
			out.println("</script>");

			out.println("</head>");

		  out.println("<body>");

		out.println("<a href='supplier-add'>Add New Supplier</a>");

		  out.println("<form method='post'>");
		  
		 out.println("<table border='1'>");
		  out.println("<tr>");
		    out.println("<th>Supplier ID</th>");
		    out.println("<th>Supplier Name</th>");
		    out.println("<th>Supplier Contact</th>");
		    out.println("<th colspan='2'>Action</th>");
		  out.println("</tr>");




		for(Supplier ct:ctList){
			out.println("<tr>");
		    out.println("<td>"+ct.getId()+"</td>");
		    out.println("<td>"+ct.getName()+"</td>");
		    out.println("<td>"+ct.getContact()+"</td>");

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
		
                //new SupplierService().remove(Integer.parseInt(req.getParameter("id")));

	  	PrintWriter out = resp.getWriter();

	  	out.println(req.getParameter("Delete"));

	  }
}
