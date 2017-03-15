package xshop.app;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.PrintWriter;
import java.io.IOException;

import xshop.entity.Product;
import xshop.entity.Category;
import xshop.core.ProductService;
import xshop.core.CategoryService;
import xshop.entity.Supplier;
import xshop.core.SupplierService;
import java.util.List;

public class ProductAddServlet extends HttpServlet{
	  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		  
	  	List<Category> ctList = new CategoryService().getAll();
	  	List<Supplier> spList = new SupplierService().getAll();

		
		

		  PrintWriter out = resp.getWriter();
		  out.println("<html>");
		  out.println("<body>");
		  out.println("<form method='post'>");

		  out.println("Product Name:<br/><input name='name' /><br/>");
		  out.println("Product Stock:<br/><input name='stock' /><br/>");
		  out.println("Product Buying Price:<br/><input name='buying_Price' /><br/>");
		  out.println("Product Selling Price:<br/><input name='selling_price' /><br/>");
		  out.println("Product Status:<br/><select name='status'><option value='1'>Available</option><option value='0'>Not Available</option></select><br/>");
		  out.println("Product Category:<br/>");

		  out.println("<select name='category_id' >");
		  	for(Category ct:ctList){
			    out.println("<option value="+ct.getId()+">"+ct.getName()+"</option>");
			}
		  out.println("</select> </br>");


		  out.println("Product Supplier:</br>");
		  out.println("<select name='supplier_id' >");
		  	for(Supplier ct:spList){
			    out.println("<option value="+ct.getId()+">"+ct.getName()+"</option>");
			}
		  out.println("</select> </br>");


		  out.println("<input type='submit' value='Save'/>");
		  out.println("</form>");
		  out.println("</body>");
		  out.println("</html>");
		  out.println("<a href='product-list'>Show Product List</a>");
	  }
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
	boolean sts;
    int temp = Integer.parseInt(req.getParameter("status"));
    System.out.println(req.getParameter("status"));
     System.out.println(temp);
    if(temp == 1) sts = true;
    else sts = false;

    System.out.println(sts);

  Product product =  new Product(req.getParameter("name"),Integer.parseInt(req.getParameter("stock")),Float.parseFloat(req.getParameter("buying_Price")),Float.parseFloat(req.getParameter("selling_price")),sts,Integer.parseInt(req.getParameter("category_id")),Integer.parseInt(req.getParameter("supplier_id")));  
                new ProductService().add(product);
                resp.sendRedirect("product-list"); 
	  }

}