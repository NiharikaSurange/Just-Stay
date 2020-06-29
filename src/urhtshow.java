

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
 * Servlet implementation class urhsshow
 */
@WebServlet("/urhtshow")
public class urhtshow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public urhtshow() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out =response.getWriter();
		response.setContentType("text/html");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/juststay","root","123");
			String qr="select * from hotel";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(qr);
			if(rs.next())
			{
				out.println("<body background=hotel.jpg>");
				out.println("<table border=1 align=center>");
				out.println("<th>NAME</th><th>ADDRESS</th><th>ROOMTYPE</th><th>PRICE</th>");
				do
				{
					String name=rs.getString("name");
					String address=rs.getString("address");
					String roomtype=rs.getString("roomtype");
					String price=rs.getString("price");
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
					
					out.println("<td>");
					out.println("<a href=htcart?name="+name+" & address="+address+" & roomtype="+roomtype+" & price= "+price+">ADD TO CHOICE</a>");
					out.println("</td>");
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
