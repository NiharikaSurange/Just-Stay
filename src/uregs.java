

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class uregs
 */
@WebServlet("/uregs")
public class uregs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public uregs() {
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
		String lname=request.getParameter("lname");
		String email=request.getParameter("email");
		String gender=request.getParameter("r");
		String city=request.getParameter("city");
		String address=request.getParameter("address");
		String no=request.getParameter("no");
		String pwd=request.getParameter("pwd");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/juststay","root","123");
			String qr="insert into user values(?,?,?,?,?,?,?,?)";
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(qr);
			ps.setString(1, name);
			ps.setString(2, lname);
			ps.setString(3, email);
			ps.setString(4, gender);
			ps.setString(5, city);
			ps.setString(6, address);
			ps.setString(7, no);
			ps.setString(8, pwd);
			int i=ps.executeUpdate();
			if(i>0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("ulogin.html");
				rd.forward(request, response);
			}else
			{
				RequestDispatcher rd=request.getRequestDispatcher("dispatcher.html");
				rd.include(request, response);
				out.println("Registration failed");
			}
			}catch(Exception e)
		{
				out.println(e);
			
		}
		
		
	}

}
