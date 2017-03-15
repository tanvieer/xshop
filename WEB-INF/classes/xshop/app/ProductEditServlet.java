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
        out.println("<h1>Update Product</h1>"); 
        out.println("<a href='add-product'>Add a product</a>"); 
        String cid=request.getParameter("id");  
        int id=Integer.parseInt(cid);  
         
        ProductService ct=new ProductService();
        Product ptedit= ct.getById(id);

        
         System.out.println(ptedit);

        out.print("<form  method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+ptedit.getId()+"'/></td></tr>");  
        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+ptedit.getName()+"'/></td></tr>");
        System.out.println(ptedit.getName());  
        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+ptedit.getStock()+"'/></td></tr>");
        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+ptedit.getBuyingPrice()+"'/></td></tr>");
        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+ptedit.getSellingPrice()+"'/></td></tr>");
        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+ptedit.isStatus()+"'/></td></tr>");
        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+ptedit.getCategoryId()+"'/></td></tr>");
        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+ptedit.getSupplierId()+"'/></td></tr>");

        out.print("</td></tr>");  

        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
       
          
         
}
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Product product =  new Product(Integer.parseInt(req.getParameter("id")),req.getParameter("name"),Integer.parseInt(req.getParameter("stock")),Float.parseFloat(req.getParameter("buying_Price")),Float.parseFloat(req.getParameter("Selling_price")),Boolean.parseBoolean(req.getParameter("status")),Integer.parseInt(req.getParameter("category_id")),Integer.parseInt(req.getParameter("supplier_id")));  
      
        new ProductService().edit(product);
        resp.sendRedirect("list-product"); 
        
      }


}