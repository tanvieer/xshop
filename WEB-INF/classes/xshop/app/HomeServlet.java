package xshop.app;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.PrintWriter;
import java.io.IOException;


public class HomeServlet extends HttpServlet{

	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		  PrintWriter out = resp.getWriter();
		  out.println("<html>");
		  out.println("<body>");
		  out.println("<table >");
		  
		  out.println("<tr>");		  
		  out.println("<td></br><input type='button' value='Add Category' id='add_category' onclick='add_category()'  name='add_category'/> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</br></br></td>");
		  out.println("<td></br><input type='button' value='Add Supplier' id='add_supplier' onclick='add_supplier()'  name='add_supplier'/> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</br></br></td>");
		  out.println("<td></br><input type='button' value='Add Product' id='add_product' onclick='add_product()'  name='add_product'/>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</br></br></td>");
		  out.println("</tr>");
		 	   
	  
		  out.println("<tr>");	  
		  out.println("<td></br><input type='button' value='Show All Category' id='show_all_category' onclick='show_all_category()'  name='show_all_category'/> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</br></br></td>");
		  out.println("<td></br><input type='button' value='Show All Supplier' id='show_all_supplier' onclick='show_all_supplier()'  name='show_all_supplier'/> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</br></br></td>");
		  out.println("<td></br><input type='button' value='Show All Product' id='show_all_product' onclick='show_all_product()'  name='show_all_product'/>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</br></br></td>");
		  out.println("</tr>");
	
		  out.println("</table>");
		  out.println("</body>");
		  out.println("</html>");
		  
		  
		  
		out.println("<script type='text/javascript'>");
		out.println("function add_category(){document.location.href= 'category-add'; }");
		out.println("function delete_category(){document.location.href= 'category-delete'; }");
		out.println("function edit_category(){document.location.href= 'category-edit'; }");
		out.println("function show_all_category(){document.location.href= 'category-list'; }");
		
		out.println("function add_supplier(){document.location.href= 'supplier-add'; }");
		out.println("function delete_supplier(){document.location.href= 'supplier-delete'; }");
		out.println("function edit_supplier(){document.location.href= 'supplier-edit'; }");
		out.println("function show_all_supplier(){document.location.href= 'supplier-list'; }");
		
		
		out.println("function add_product(){document.location.href= 'product-add'; }");
		out.println("function delete_product(){document.location.href= 'product-delete'; }");
		out.println("function edit_product(){document.location.href= 'product-edit'; }");
		out.println("function show_all_product(){document.location.href= 'product-list'; }");

		
		out.println("</script>");
	}
}