

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class urpgshow
 */
@WebServlet("/urpgshow")
public class urpgshow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public urpgshow() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out =response.getWriter();
		//response.setContentType("text/html");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/juststay","root","123");
			String qr="select * from pg";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(qr);
			if(rs.next())
			{
				out.println("<body background=hotel.jpg>");
				out.println("<table border=1 align=center>");
				do
				{
					String name=rs.getString("ownername");
					String address=rs.getString("address");
					String roomtype=rs.getString("roomtype");
					String price=rs.getString("price");
					String number=rs.getString("number");
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
					//out.println("<td>");
					out.println(number);
					out.println("</td>");
					//out.println("<a href=updpro?name="+name+"& price="+price+" &cat="+cat+" &cmp="+cmp+">UPDATE</a>");
					out.println("<td>");
					//out.println("</tr>");
					out.println("<form action=pgbook>");
					out.println("<input type= submit value=book />");
					out.println("</form>");
					out.println("</td>");
					out.println("</tr>");
					}while(rs.next());
					{
						out.println("</table>");
						out.println("</body>");
					}
			}else
				{
					out.println("no records found");
				}
				con.close();
			
		} catch (Exception e) {
			out.println(e);
		}

	



	}

}

