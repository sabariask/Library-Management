import java.io.*;
import java.sql.*;
import javax.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class signupadmin extends HttpServlet
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
				
				String x=req.getParameter("adminid");
				String y=req.getParameter("adminname");
				String dob=req.getParameter("dob");
				String c=req.getParameter("clg");
				String sql="insert into signupadmin values('"+x+"','"+y+"','"+dob+"','"+c+"')";
				stmt.executeUpdate(sql);
				RequestDispatcher rd=req.getRequestDispatcher("/signuped.html");
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
