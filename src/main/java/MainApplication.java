import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.cubic.helpers.DataBaseConnection;



public class MainApplication {

	public static void main(String[] args) {
		System.out.println("First test run");
		DataBaseConnection.createConnection();
		Connection c = DataBaseConnection.createConnection();
		
		String insertSql = "insert into customers(first_name,last_name,phone,email,address,gender,dob)\n" + 
				"values('Lok', 'Dhungana', 2404416191,'lokdhungana@yahoo.com', '9525 copps Hill Dr','M',' 2018-03-16');";
		Statement stmt = null;
		try {
			stmt = c.createStatement();
			stmt.executeUpdate(insertSql);
			c.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		//select
		String selectsql = "select = from customers";
		try {
			ResultSet rs = stmt.executeQuery(selectsql);
			while(rs.next()) {
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				int phone = rs.getInt("phone");
				String email =rs.getString("email");
				System.out.println("name : "+ firstName + " " + lastName + " , "+ "phone : " + phone + "email : " + email );
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		try {
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}