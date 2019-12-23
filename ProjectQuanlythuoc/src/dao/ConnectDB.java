package dao;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

public class ConnectDB {
	public static Connection con = null;
	private static ConnectDB instance = new ConnectDB();
	public static ConnectDB getInstance() {
		return instance;
	}
	public ConnectDB() {		
		try {
			String url = "jdbc:sqlserver://localhost:1433;databasename=QLThuoc";
			String user = "sa";
			String password = "12345678";
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void disconnect() {
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public Connection getConnection() {
		return con;
	}

}
