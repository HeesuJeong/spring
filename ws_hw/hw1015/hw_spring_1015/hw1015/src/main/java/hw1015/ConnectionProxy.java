package hw1015;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProxy {
	//객체 생성 없이 호출하기 위해 static 함수로
	public static Connection getConnection() throws SQLException {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/homework?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8", "ssafy",
					"ssafy");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
