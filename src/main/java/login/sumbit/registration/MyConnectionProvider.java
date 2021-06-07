package login.sumbit.registration;

import java.sql.Connection;
import java.sql.DriverManager;


public class MyConnectionProvider implements MyProvider {
	
	static Connection conn=null;
	
	public static Connection getConnect() {
		
		try {
		Class.forName("org.postgresql.Driver");
		conn=DriverManager.getConnection(urlDB, usernameDB, passwordDB);
			
		}catch(Exception e){
			System.out.println(e);
		}
		return conn;
	}

}
