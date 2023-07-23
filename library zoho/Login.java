
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.JSONObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
public class Login extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		String r_sid=req.getParameter("Stud_id");
		String r_pwd=req.getParameter("Password");
		HttpSession session=req.getSession();
		resp.addHeader("Access-Control-Allow-Origin","*");
		PrintWriter out=resp.getWriter();
		Boolean loggedin=false;
		Statement st=null;
		try {
			Connection con=DB_Connector.getDbConnection();
			st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from student");
			while(rs.next()) {
				String Stud_id=rs.getString("Stud_Id");
				String Password=rs.getString("Password");
				if(r_sid.equals(Stud_id) && r_pwd.equals(Password))
				{
					session.setAttribute("Stud_id",Stud_id);
				   
				    JSONObject jo=new JSONObject ();
				    jo.put("Status","Success");
				    jo.put("Stud_id",Stud_id);
				    out.println(jo.toString());
				    loggedin=true;
				    break;
				    
			}
		}
		if(loggedin==false) {
			JSONObject jo=new JSONObject();
			jo.put("Status", "Failed");
			out.print(jo.toString());
			
		}
		
		}catch (Exception e) {
			JSONObject jo=new JSONObject();
			jo.put("Status", "Failed");
			jo.put("Exception",e);
            out.print(jo.toString());
			// TODO: handle exception
		}
	
		
}
}
		

