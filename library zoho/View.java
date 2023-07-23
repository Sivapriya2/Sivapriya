import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class View {
	private Integer Book_id;
	private String Book_name;
	private String Author;
	private String Publisher;
	private Integer Dept_id;
	private Integer publication_year;
	
	public int getBook_id() {
		return Book_id;
	}
	public void setBook_id(Integer Book_id) {
		this.Book_id=Book_id;
	}
	public String getBook_name() {
		return Book_name;
	}
	public void setBook_name(String Book_name) {
		this.Book_name=Book_name;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String Author) {
		this.Author=Author;
	}
	public String getPublisher() {
		return Publisher;
	}
	public void setPublisher(String Publisher) {
		this.Publisher=Publisher;
	}
    public int getDept_id() {
		return Dept_id;
	}
	public void setDept_id(Integer Dept_id) {
		this.Dept_id=Dept_id;
	}
	public int getPublication_year() {
		return publication_year;
	}
	public void setPublication_year(Integer publication_year) {
		this.publication_year=publication_year;
	}
	public static List<View> getAllEmployees(){  
        List<View> list=new ArrayList<View>();  
          
        try{  
            Connection con=DB_Connector.getDbConnection();  
            PreparedStatement ps=con.prepareStatement("select * from book");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                View e=new View();  
                e.setBook_id(rs.getInt(1));  
                e.setBook_name(rs.getString(2));  
                e.setAuthor(rs.getString(3));
                e.setPublisher(rs.getString(4));  
                e.setDept_id(rs.getInt(5));  
                e.setPublication_year(rs.getInt(6));  
                list.add(e);  
                
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    } 
}
