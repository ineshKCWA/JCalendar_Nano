package dbConnect;

import java.sql.Connection;



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
	
}
