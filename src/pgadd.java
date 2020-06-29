

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class pgadd
 */
@WebServlet("/pgadd")
public class pgadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pgadd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String ownername=request.getParameter("ownername");
		String address=request.getParameter("address");
		String roomtype=request.getParameter("roomtype");
		String price=request.getParameter("price");
		String number=request.getParameter("number");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/juststay","root","123");
			String qr="insert into pg values(?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(qr);
			ps.setString(1, ownername);
			ps.setString(2, address);
			ps.setString(4, roomtype);
			ps.setString(5, price);
			ps.setString(3, number);
			int i=ps.executeUpdate();
			out.println(i+"record added");
			response.sendRedirect("pgshow");
			con.close();
		}catch(Exception e)
		{
			out.println(e);
		}
	}
	}



	