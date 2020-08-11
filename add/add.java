import java.io.*;
import java.sql.*;
import javax.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class add extends HttpServlet
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
				
				String x=req.getParameter("studid");
				String b=req.getParameter("bookid");
				String y=req.getParameter("bookname");
				String z=req.getParameter("bookauthor");
				String e=req.getParameter("edition");
				String year=req.getParameter("year");
				String date=req.getParameter("date");
				String sql="insert into book values('"+x+"','"+y+"','"+b+"','"+z+"','"+e+"','"+year+"','"+date+"')";
				stmt.executeUpdate(sql);
				RequestDispatcher rd=req.getRequestDispatcher("/added.html");
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
