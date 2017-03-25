package xshop.app;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.PrintWriter;
import java.io.IOException;

import xshop.entity.Product;
import xshop.core.ProductService;
import java.util.List;

public class ProductListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		List<Product> ctList = new ProductService().getAll();

		out.println("<html>");
		out.println("<a href='home'> HOME </a>");
		out.println("<a href='product-add'>Add Product</a>");

		out.println("<head>");

		out.println("</head>");

		out.println("<body>");

		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<th>Product ID</th>");
		out.println("<th>Product Name</th>");
		out.println("<th>Product Stock</th>");
		out.println("<th>Product buying_Price</th>");
		out.println("<th>Product Selling_Price</th>");
		out.println("<th>Product Status</th>");
		out.println("<th>Product CategoryID</th>");
		out.println("<th>Product suppilerID</th>");
		out.println("<th colspan='2'>Action</th>");
		out.println("</tr>");

		for (Product ct : ctList) {
			out.println("<tr>");
			out.println("<td>" + ct.getId() + "</td>");
			out.println("<td>" + ct.getName() + "</td>");
			out.println("<td>" + ct.getStock() + "</td>");
			out.println("<td>" + ct.getBuyingPrice() + "</td>");
			out.println("<td>" + ct.getSellingPrice() + "</td>");
			out.println("<td>" + ct.isStatus() + "</td>");
			out.println("<td>" + ct.getCategoryId() + "</td>");
			out.println("<td>" + ct.getSupplierId() + "</td>");

			out.println("<td><a href='product-delete?id=" + ct.getId()
					+ "'>Delete</a></td>");
			out.println("<td><a href='product-edit?id=" + ct.getId()
					+ "'>Edit</a></td>");

			out.println("</tr>");
		}

		out.println("</table>");

		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		PrintWriter out = resp.getWriter();

		out.println(req.getParameter("Delete"));

	}
}
