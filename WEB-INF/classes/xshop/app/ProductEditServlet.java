package xshop.app;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.PrintWriter;
import java.io.IOException;

import xshop.entity.Product;
import xshop.core.ProductService;

public class ProductEditServlet extends HttpServlet{
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
      
        PrintWriter out=response.getWriter();

out.println("<a href='home'> HOME </a></br>");  
        out.println("<h1>Update Product</h1>"); 
        out.println("<a href='product-add'>Add Product</a>"); 
        String cid=request.getParameter("id");  
        int id=Integer.parseInt(cid);  
         
        ProductService ct=new ProductService();
        Product ptedit= ct.getById(id);

        

        out.println("<form  method='post'>");  
        out.println("<table>");  
        out.println("<tr><td></td><td><input type='hidden' name='id' value='"+ptedit.getId()+"'/></td></tr>");  
        out.println("<tr><td>Name:</td><td><input type='text' name='name' value='"+ptedit.getName()+"'/></td></tr>");  
        out.println("<tr><td>Stock:</td><td><input type='text' name='stock' value='"+ptedit.getStock()+"'/></td></tr>");
        out.println("<tr><td>Buying Price:</td><td><input type='text' name='buying_Price' value='"+ptedit.getBuyingPrice()+"'/></td></tr>");
        out.println("<tr><td>Selling Price:</td><td><input type='text' name='selling_price' value='"+ptedit.getSellingPrice()+"'/></td></tr>");
        out.println("<tr><td>Status:</td><td><select name='status'><option value='1'>Available</option><option value='0'>Not Available</option></select></td></tr>");
        out.println("<tr><td>Category:</td><td><input type='text' name='category_id' value='"+ptedit.getCategoryId()+"'/></td></tr>");
        

        out.println("<tr><td>Supplier:</td><td><input type='text' name='supplier_id' value='"+ptedit.getSupplierId()+"'/></td></tr>");

        out.println("</td></tr>");  

        out.println("<tr><td colspan='2'><input type='submit' value='Confirm Edit'/></td></tr>");  
        out.println("</table>");  
        out.println("</form>");  
       
          
         
}
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
    boolean sts;
    int temp = Integer.parseInt(req.getParameter("status"));
    if(temp == 1) sts = true;
    else sts = false;

    Product product =  new Product(Integer.parseInt(req.getParameter("id")),req.getParameter("name"),Integer.parseInt(req.getParameter("stock")),Float.parseFloat(req.getParameter("buying_Price")),Float.parseFloat(req.getParameter("selling_price")),sts,Integer.parseInt(req.getParameter("category_id")),Integer.parseInt(req.getParameter("supplier_id")));  
      

 /*PrintWriter out=resp.getWriter();  
 out.println(req.getParameter("status"));
 out.println(sts);*/

        new ProductService().edit(product);
        resp.sendRedirect("product-list"); 
        
      }


}