package assignment.dao;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.assignment.UserForm;

public class AssignmentDao {
    
    private Connection conn;
    
    public AssignmentDao() throws SQLException, ClassNotFoundException {
        
    	try {
        Class.forName("oracle.jdbc.driver.OracleDriver"); 
        conn = DriverManager.getConnection("jdbc:oracle:thin:@//qaexadb-ol0i6-scan.dbsn.qavcn.oraclevcn.com:1521/PDBGECD.dbsn.qavcn.oraclevcn.com","pcssandbox", "pcssbox#1");
        System.out.println("Database connection established.");
    	}catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error connecting to database: " + e.getMessage());
        }
    	}
    
    public List<UserForm> executeQuery() throws SQLException {
    	List<UserForm> users = new ArrayList<UserForm>();
    	try {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from pcssandbox.user_details");
        while(rs.next()) {
    		UserForm uf = new UserForm();
    		
    		uf.setUid(String.valueOf(rs.getInt("user_id")));
    		uf.setDob(String.valueOf(rs.getDate("date_of_birth")));
    		uf.setLname(rs.getString("last_name"));
    		uf.setGender(rs.getString("gender"));
    		uf.setEmail(rs.getString("email_id"));
    		uf.setEmailnot(rs.getString("FLAG_EMAIL_NOTIFICATION"));
    		uf.setAdress1(rs.getString("address_line_1"));
    		uf.setAdress2(rs.getString("address_line_2"));
    		uf.setState(rs.getString("state"));
    		uf.setCity(rs.getString("city"));
    		uf.setPincode(rs.getString("pincode"));
    		String name= rs.getString("first_name");
    		uf.setFname(name);
            
    		users.add(uf);
    	}
    	}catch(Exception e) {
			System.out.println("error while fetching users "+e);	  
		}
        
        return users;
    }
    
    public String insert(int uid, String fname, String lname, String gender, String dob, String email, String ef, String address1, String address2, String city, String state,String pincode) throws SQLException{
    	UserForm uf = getItem(uid);
    	if(uf.getFname()!=null) {
    		uf.setUid(String.valueOf(uid));
    		uf.setLname(lname);
    		uf.setGender(gender);
    		uf.setEmail(email);
    		uf.setEmailnot(ef);
    		uf.setAdress1(address1);
    		uf.setAdress2(address2);
    		uf.setState(state);
    		uf.setCity(city);
    		uf.setDob(dob);
    		uf.setPincode(pincode);
    		uf.setFname(fname);
    		String u = update(uf);
    		return u;
    	}else {
    		 try {
                 PreparedStatement pstmt = conn.prepareStatement("INSERT INTO PCSSANDBOX.USER_DETAILS (USER_ID,FIRST_NAME,LAST_NAME,GENDER,DATE_OF_BIRTH,EMAIL_ID,FLAG_EMAIL_NOTIFICATION,ADDRESS_LINE_1,ADDRESS_LINE_2,CITY,STATE,PINCODE) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
                 pstmt.setInt(1, uid);
                 pstmt.setString(2, fname);
                 pstmt.setString(3, lname);
                 pstmt.setString(4, gender);
                 Date datex;
                try {
              	   datex = Date.valueOf(dob);
                }catch(Exception e) {
              	  System.out.println("error in entered date : "+e);
              	  datex= Date.valueOf("2001-01-01");
                }
                 
                 
                 pstmt.setDate(5,datex);
                 pstmt.setString(6,email);
                 System.out.println("checkbox"+ef);
                 pstmt.setString(7,"O");
                 pstmt.setString(8,address1);
                 pstmt.setString(9, address2);
                 pstmt.setString(10, city);
                 pstmt.setString(11, state);
                 pstmt.setString(12, pincode);
                
                 
                 int rowsAffected = pstmt.executeUpdate();
                 System.out.println("Rows affected: " + rowsAffected);
                 return uid+" User Added Succesfully!!";
                 
                 
             } catch (SQLException e) {
                 System.err.println("Error executing SQL query: " + e.getMessage());
                 return "Some error occured!!";
             }
    	}
       
        

    }
    
    public void delete(int idx)throws SQLException {
    	try {
    	PreparedStatement stmnt = conn.prepareStatement("delete from pcssandbox.user_details where user_id= ?");
    	stmnt.setInt(1, idx);
    	 int rowsDeleted = stmnt.executeUpdate();
    	}catch(Exception e) {
			System.out.println("error while deleting"+e);
		}
    }
    
    public UserForm getItem(int id) throws SQLException{
    	UserForm uf = new UserForm();
    	try {
    	PreparedStatement stmnt = conn.prepareStatement("select * from pcssandbox.user_details where user_id=?");
    	stmnt.setInt(1, id);
    	ResultSet rs= stmnt.executeQuery();
    	while(rs.next()) {
    		uf.setUid(String.valueOf(rs.getInt("user_id")));
    		uf.setLname(rs.getString("last_name"));
    		uf.setGender(rs.getString("gender"));
    		uf.setEmail(rs.getString("email_id"));
    		uf.setEmailnot(rs.getString("FLAG_EMAIL_NOTIFICATION"));
    		uf.setAdress1(rs.getString("address_line_1"));
    		uf.setAdress2(rs.getString("address_line_2"));
    		uf.setState(rs.getString("state"));
    		uf.setCity(rs.getString("city"));
    		uf.setDob(String.valueOf(rs.getDate("date_of_birth")));
    		uf.setPincode(rs.getString("pincode"));
    		String name= rs.getString("first_name");
    		uf.setFname(name);
    	}
    	}catch(Exception e) {
			System.out.println("error while getting Id "+e);
		}
    	return uf;
    }
    
    public String update(UserForm userform) throws SQLException {
		try {
			int uid = Integer.parseInt(userform.getUid());
			String fname = userform.getFname();
			String lname = userform.getLname();
			String gender = userform.getGender();
			String email = userform.getEmail();
			String emailnot = userform.getEmailnot();
			String address1 = userform.getAdress1();
			String address2 = userform.getAdress2();
			Date dob = Date.valueOf(userform.getDob());
			String city = userform.getCity();
			String state = userform.getState();
			String pincode = userform.getPincode();
			System.out.println(fname);
			System.out.println(lname);
			System.out.println(email);
			System.out.println(pincode);
			System.out.println(uid);
			System.out.println(gender);
			System.out.println(dob);
			System.out.println(state);
			System.out.println("city is"+city);
			
			 String sql = "update pcssandbox.user_details set user_id=?, first_name=?, last_name=?, gender=?, date_of_birth=?, email_id=?, flag_email_notification=?, address_line_1=?, address_line_2=?, city=?, state=?, pincode=? where user_id=? ";
			 PreparedStatement pstmt = conn.prepareStatement(sql);
			 pstmt.setInt(1, uid);
	         pstmt.setString(2, fname);
	         pstmt.setString(3, lname);
	         pstmt.setString(4, gender);
	         pstmt.setDate(5,dob);
	         pstmt.setString(6,email);
	         pstmt.setString(7,"O");
	         pstmt.setString(8,address1);
	         pstmt.setString(9, address2);
	         pstmt.setString(10, city);
	         pstmt.setString(11, state);
	         pstmt.setString(12, pincode);
	         pstmt.setInt(13, uid);
	         
	         int rowsaffected = pstmt.executeUpdate();
	         System.out.println("no of row updated"+rowsaffected);
	         return uid+" Update Successfull!!";
			
		
		}catch(Exception e) {
			System.out.println("error while updating "+e);
			  return "Update Failed!!";
		}
    }
    
    public String getId() throws SQLException{
    	try {
    		Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX(user_id) FROM PCSSANDBOX.USER_DETAILS");
            int id=0;
            if(rs.next()) {
            	id=rs.getInt(1);
            	
            }
            id+=1;
            System.out.println("id generated is"+id);
            String ids= Integer.toString(id); 
    		return ids;
    	}catch(Exception e) {
			System.out.println("error while generating id "+e);
			  return "404";
		}
    }
   
    public void close() throws SQLException {
        
        if (conn != null) {
            conn.close();
        }
    }

	
}
