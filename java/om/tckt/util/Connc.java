package om.tckt.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connc {
	public static Connection con = null;
	public static void main(String[] args) {
		getConnect();
	}
	public static Connection getConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/training";
			String user = "root";
			String password = "root123";
			con = DriverManager.getConnection(url, user, password);
			System.out.println("hellos");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
