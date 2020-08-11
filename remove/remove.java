import java.io.*;
import java.sql.*;
import javax.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class remove extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException {
		  
      res.setContentType("text/html");

      PrintWriter out =res.getWriter();
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				String jdbcUrl="jdbc:mysql://localhost:3306/Library";
				String username="root";
				String password="root";
				Connection conn=null;
				
				conn=DriverManager.getConnection(jdbcUrl,username,password);
				Statement stmt=conn.createStatement();
				
				String x=req.getParameter("bookid");
				String sql="delete from book where bookid='"+x+"'";
				stmt.executeUpdate(sql);
				RequestDispatcher rd=req.getRequestDispatcher("/removed.html");
				rd.include(req,res);
			}
			catch(ClassNotFoundException ce)
			{
				out.println("class not found");
			}			
		catch(SQLException e)
		{
			throw new RuntimeException("Cannot Connect databases !",e);
		}
	}
}
