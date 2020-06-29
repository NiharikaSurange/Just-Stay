

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
 * Servlet implementation class htupd
 */
@WebServlet("/htupd")
public class htupd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public htupd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
			String qr="update hotel set price=?,roomtype=?,address=? where name=?";
			PreparedStatement ps=con.prepareStatement(qr);
			ps.setString(1, price);
			ps.setString(2, roomtype);
			ps.setString(3, address);
			ps.setString(4, name);
			int i=ps.executeUpdate();
			out.println(i+"record updated");
			response.sendRedirect("htshow");
			con.close();
		}catch(Exception e)
		{
			out.println(e);
		}
	}
}


