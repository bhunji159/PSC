package model;
import java.sql.*;

import java.util.Observable;

public class LoginModel extends Observable {
	private boolean isValid = false;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public LoginModel() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/dbserver?serverTimezone=UTC";
			String id = "root";
			String pw = "5636";
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    conn = DriverManager.getConnection(dbURL, id, pw);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int login(String userID, String userPassword) {
		String SQL = "SELECT userPassword FROM dbserver WHERE userID=?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1,  userID);
			rs=pstmt.executeQuery();
			if(rs.next() ) {
				if(rs.getString(1).equals(userPassword)) {
					isValid = true;
					setChanged();
				    notifyObservers();
					return 1;
				}
				else
					isValid = false;
				    setChanged();
				    notifyObservers();
					return 0;
			}
			return -1;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -2;
	}
	
	public boolean getIsValid() {
		return isValid;
	}

}
