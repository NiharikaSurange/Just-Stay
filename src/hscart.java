

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class hscart
 */
@WebServlet("/hscart")
public class hscart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hscart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String roomtype=request.getParameter("roomtype");
		String price=request.getParameter("price");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/juststay","root","123");
			String qr="insert into cart values(?,?,?,?)";
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(qr);
			ps.setString(1, name);
			ps.setString(2, address);
			ps.setString(3, roomtype);
			ps.setString(4, price);
			out.println("<center><h1>WELCOME TO CART</h1></center>");
			out.println("<body background=hotel.jpg>");
			out.println("<center>");
			out.println("<tr>");
			out.println("<td>");
			out.println(name);
			out.println("</td>");
			out.println("<td>");
			out.println(address);
			out.println("</td>");
			out.println("<td>");
			out.println(roomtype);
			out.println("</td>");
			out.println("<td>");
			out.println(price);
			//out.println("<a href=delpro?name="+name+">DELETE</a>");
			out.println("</td>");
			out.println("<td>");
			//out.println("<a href=updpro?name="+name+"& address="+address+" &roomtype="+roomtype+" &price="+price+">UPDATE</a>");
			out.println("<td>");
			//ssout.println("</tr>");
			
			out.println("<form action=hsbook>");
			out.println("<input type= submit value=BOOK />");
			out.println("</form>");
			out.println("</center>");
			out.println("</body>");
//			out.println("<td>");
//			out.println("<a href=hscart?name="+name+" & address="+address+" & roomtype="+roomtype+" & price= "+price+">ADD TO CART</a>");
//			out.println("</td>");
//			
			{
				out.println("</table>");
				out.println("</body>");
			}
			int i=ps.executeUpdate();
			con.close();
			
			}catch(Exception e)
		    {
				out.println(e);
			}

	}

}
