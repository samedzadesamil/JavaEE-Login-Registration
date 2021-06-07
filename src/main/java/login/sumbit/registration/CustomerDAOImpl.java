package login.sumbit.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerDAOImpl implements CustomerDAO {
	static Connection conn;
	static PreparedStatement ps;
	static Statement st;
	

	@Override
	public int insertCustomer(Customer customer) {
		int status=0;
		try {
			conn=MyConnectionProvider.getConnect();
			ps=conn.prepareStatement("insert into customer(username,password,name) values(?,?,?)");
			ps.setString(1, customer.getUsername());
			ps.setString(2, customer.getPassword());
			ps.setString(3, customer.getName());
			status=ps.executeUpdate();
			conn.close();
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return status;
	}

	@Override
	public Customer getCustomer(String username, String password) {
		Customer customer=new Customer();
		
		try {
			conn=MyConnectionProvider.getConnect();
			ps=conn.prepareStatement("select * from customer where username=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet resultSet=ps.executeQuery();
			while(resultSet.next()) {
				customer.setUsername(resultSet.getString("username"));
				customer.setPassword(resultSet.getString("password"));
				customer.setName(resultSet.getString("name"));	
			}
			
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		
		return customer;
	}

}
