import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StaffReg {
	Connection con=DB_Connector.getDbConnection(); 
	public void create(Staff s) {
		String sql="insert into staff values(?,?,?,?,?,?)";
		try {
			
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, s.getStaff_id());
			ps.setString(2, s.getStaff_name());
			ps.setString(3, s.getEmail());
			ps.setString(4, s.getMobile());
			ps.setInt(5, s.getDept_id());
			ps.setString(6, s.getPassword());
			ps.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public void update(Staff s) {
		String sql="update staff set Staff_name=?,Email=?,Mobile=?,Dept_id=?,Password=? where Staff_id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, s.getStaff_name());
			ps.setString(2, s.getEmail());
			ps.setString(3, s.getMobile());
			ps.setInt(4, s.getDept_id());
			ps.setString(5, s.getPassword());
			ps.setInt(6, s.getStaff_id());
			ps.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public void delete(Integer Staff_id) {
		String sql="delete from staff where Staff_id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, Staff_id);
			ps.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public List<Staff> getStaff(){
		List<Staff> staff=new ArrayList<>();
		String sql="select * from staff;";
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				Staff s=new Staff();
				s.setStaff_id(rs.getInt(1));
				s.setStaff_name(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setMobile(rs.getString(4));
				s.setDept_id(rs.getInt(5));
				s.setPassword(rs.getString(6));
				staff.add(s);
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return staff;
	}
	public Staff getStaff(Integer Staff_id) {
		Staff s=new Staff();
		String sql="select * from staff where Staff_id="+Staff_id;
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				s.setStaff_id(rs.getInt(1));
				s.setStaff_name(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setMobile(rs.getString(4));
				s.setDept_id(rs.getInt(5));
				s.setPassword(rs.getString(6));
				
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return s;
	}

}
