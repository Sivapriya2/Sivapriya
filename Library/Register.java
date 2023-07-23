import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class Register {
	Connection con=DB_Connector.getDbConnection();
	public static int save(Student s){  
        int status=0;  
        try{        
        	Connection con=DB_Connector.getDbConnection();
            PreparedStatement ps=con.prepareStatement("insert into student(Stud_id,Stud_name,Reg_no,Dept_id,Email,Mobile,Password) values(?,?,?,?,?,?,?)");  
            ps.setInt(1, s.getStud_id());
			ps.setString(2, s.getStud_name());
			ps.setString(3, s.getReg_no());
			ps.setInt(4, s.getDept_id());
			ps.setString(5, s.getEmail());
			ps.setString(6, s.getMobile());
			ps.setString(7, s.getPassword());
			ps.executeUpdate();
            status=ps.executeUpdate();    
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
	public void update(Student s) {
		String sql="update student set Stud_name=?,Reg_no=?,Dept_id=?,Email=?,Mobile=?,Password=? where Stud_id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, s.getStud_name());
			ps.setString(2, s.getReg_no());
			ps.setInt(3,s.getDept_id());
			ps.setString(4, s.getEmail());
			ps.setString(5, s.getMobile());
			ps.setString(6, s.getPassword());
			ps.setInt(7, s.getStud_id());
			ps.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public void delete(Integer Stud_id) {
		String sql="delete from student where Stud_id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, Stud_id);
			ps.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public List<Student> getStudent(){
		List<Student> students=new ArrayList<>();
		String sql="select * from student;";
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				Student u=new Student();
				u.setStud_id(rs.getInt(1));
				u.setStud_name(rs.getString(2));
				u.setReg_no(rs.getString(3));
				u.setDept_id(rs.getInt(4));
				u.setEmail(rs.getString(5));
				u.setMobile(rs.getString(6));
				u.setPassword(rs.getString(7));
				students.add(u);
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return students;
	}
	public Student getStudent(Integer Stud_id) {
		Student s=new Student();
		String sql="select * from student where Stud_id="+Stud_id;
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				s.setStud_id(rs.getInt(1));
				s.setStud_name(rs.getString(2));
				s.setReg_no(rs.getString(3));
				s.setDept_id(rs.getInt(4));
				s.setEmail(rs.getString(5));
				s.setMobile(rs.getString(6));
				s.setPassword(rs.getString(7));
				
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return s;
	}
    

}
