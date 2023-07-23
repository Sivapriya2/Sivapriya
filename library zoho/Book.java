import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Book {
	Connection con=DB_Connector.getDbConnection();
	public void create(View b) {
		String sql="insert into book values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, b.getBook_id());
			ps.setString(2, b.getBook_name());
			ps.setString(3, b.getAuthor());
			ps.setString(4, b.getPublisher());
			ps.setInt(5, b.getDept_id());
			ps.setInt(6, b.getPublication_year());
			ps.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public void update(View b) {
		String sql="update book set Book_name=?,Author=?,Publisher=?,Dept_id=?,publication_year=? where Book_id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, b.getBook_name());
			ps.setString(2, b.getAuthor());
			ps.setString(3, b.getPublisher());
			ps.setInt(4, b.getDept_id());
			ps.setInt(5, b.getPublication_year());
			ps.setInt(6, b.getBook_id());
			ps.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public void delete(Integer Book_id) {
		String sql="delete from book where Book_id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, Book_id);
			ps.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public List<View> getBook(){
		List<View> book=new ArrayList<>();
		String sql="select * from book;";
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				View b=new View();
				b.setBook_id(rs.getInt(1));
				b.setBook_name(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPublisher(rs.getString(4));
				b.setDept_id(rs.getInt(5));
				b.setPublication_year(rs.getInt(6));
				book.add(b);
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return book;
	}
	public View getView(Integer Book_id) {
		View b=new View();
		String sql="select * from book where Book_id="+Book_id;
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				b.setBook_id(rs.getInt(1));
				b.setBook_name(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPublisher(rs.getString(4));
				b.setDept_id(rs.getInt(5));
				b.setPublication_year(rs.getInt(6));
				
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return b ;
	}

}
