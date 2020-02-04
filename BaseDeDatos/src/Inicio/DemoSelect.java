package Inicio;
import java. sql.Connection ;
import java.sql.DriverManager ;
import java.sql.SQLException ;
import java.sql.Statement ;

public class DemoSelect {
	
	public static void main(String[] args) {
		
		String usr = "sa";
		String pwd = "";
		String driver = "org.hsqldb.jdbcDriver";
		String url = "jdbc:hsqldb:hsql://localhost/xdb";
		
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,usr,pwd);
			String sql = "SELECT empno, ename , hiredate, deptno FROM emp";
			pstm = con.prepareStatement(sql);
		}
	}

}
