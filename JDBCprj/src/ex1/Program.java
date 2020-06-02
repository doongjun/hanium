package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import oracle.sql.DATE;

public class Program {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT * FROM MEMBER WHERE AGE>=24";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "dongjun", "skrduqrlf56");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
			while(rs.next()) {
			int id = rs.getInt("ID");
			int age = rs.getInt("AGE");
			String name = rs.getString("NAME");
			Date regdate = rs.getDate("REGDATE");
			
			System.out.printf("ID : %d, 나이 : %d, 이름 : %s 날짜 : %s \n", id,age,name,regdate);
			}
		
		
		rs.close();
		st.close();
		con.close();
		
		

	}

}
