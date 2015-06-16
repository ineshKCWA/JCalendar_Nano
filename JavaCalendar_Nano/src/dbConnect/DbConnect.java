package dbConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DbConnect {
private static DbConnect instance=null;
	
	private static final String USERNAME = "teamnano";
	private static final String PASSWORD = "nano";
	private static final String CONN_STRING =
			"jdbc:mysql://localhost/calendardb";
	private Connection conn=null;
	
	private DbConnect() {			// private constructor 
	}
	
	public static DbConnect getInstance() {		// singleton object for connection
		if(instance==null){
			instance=new DbConnect();
		}
		return instance;
	} 
	private boolean openConnection(){
		try {
			conn=DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Connection getConnection(){
		if(conn==null){
			if(openConnection()){
				System.out.println("connection opened");
				return conn;
			}else{
				return null;
			}
		}
		return conn;
	}
}
