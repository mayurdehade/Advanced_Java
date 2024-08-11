
import java.io.IOException;
import java.sql.Connection;
import java.sql.ConnectionBuilder;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/add-product")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productname = request.getParameter("productname");
		int productqty = Integer.parseInt(request.getParameter("productQty"));
		int productprice = Integer.parseInt(request.getParameter("productprice"));
		
		System.out.println(productname + " "+ productqty+ " "+productprice);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/184product", "root", "mayur");
			
			String query = "INSERT INTO product(productname, productqty, productprice) VALUES(?, ?, ?)"; 
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, productname);
			ps.setInt(2, productqty);
			ps.setInt(3, productprice);
			
			//execute query
			int rows = ps.executeUpdate();
			if(rows>0) {
				request.setAttribute("msg", "Product Added Successfully");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("msg", "Something Went Wrong...!");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
