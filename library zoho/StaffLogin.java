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

public class StaffLogin extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		String r_id=req.getParameter("Staff_id");
		String r_pwd=req.getParameter("Password");
		HttpSession session=req.getSession();
		resp.addHeader("Access-Control-Allow-Origin","*");
		PrintWriter out=resp.getWriter();
		Boolean loggedin=false;
		Statement st=null;
		try {
			Connection con=DB_Connector.getDbConnection();
			st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from staff");
			while(rs.next()) {
				String Staff_id=rs.getString("Staff_Id");
				String Password=rs.getString("Password");
				if(r_id.equals(Staff_id) && r_pwd.equals(Password))
				{
					session.setAttribute("Staff_id",Staff_id);
				   
				    JSONObject jo=new JSONObject ();
				    jo.put("Status","Success");
				    jo.put("Staff_id",Staff_id);
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
