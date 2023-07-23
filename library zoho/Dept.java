import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Dept {
	Connection con=DB_Connector.getDbConnection();
	public List<Department> getDepartment(){
		List<Department> department=new ArrayList<>();
		String sql="select * from department;";
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				Department d=new Department();
				d.setDept_name(rs.getString(1));
				d.setDept_id(rs.getInt(2));
				department.add(d);
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return department;
	}
	public Department getDepartment(Integer Dept_id) {
		Department d=new Department();
		String sql="select * from department where Dept_id="+Dept_id;
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				
				d.setDept_name(rs.getString(1));
				d.setDept_id(rs.getInt(2));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return d;
	}
	public void create(Department d) {
		String sql="insert into department values(?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, d.getDept_name());
			ps.setInt(2, d.getDept_id());
			ps.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public void update(Department d) {
		String sql="update department set Dept_name=? where Dept_id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, d.getDept_name());
			ps.setInt(2, d.getDept_id());
			ps.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public void delete(Integer Dept_id) {
		String sql="delete from department where Dept_id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, Dept_id);
			ps.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
