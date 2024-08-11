
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/get-product")
public class GetProduct extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String productname = request.getParameter("productName");
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/184product", "root", "mayur");
			String query = "SELECT * FROM product WHERE productname=?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, productname);
			ResultSet rs = statement.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("productname");
				int qty = rs.getInt("productqty");
				int price = rs.getInt("productprice");
				
				request.setAttribute("id", id);
				request.setAttribute("name", name);
				request.setAttribute("qty", qty);
				request.setAttribute("price", price);
				RequestDispatcher rd = request.getRequestDispatcher("product-by-name.jsp");
				rd.forward(request, response);
				
			}
			else {
				request.setAttribute("error", "Product not found!");
				RequestDispatcher rd = request.getRequestDispatcher("product-by-name.jsp");
				rd.forward(request, response);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
