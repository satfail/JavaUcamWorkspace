package ConectorBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ResourceBundle;

public class DemoMetaData {
	
	public static void main(String[] args) {
		
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		
		try {
			
			con = UConnection.getConnection();
			String sql = "";
			sql += "SELECT emp.empno AS empno ";
			sql += "      , emp.ename AS ename ";
			sql += "      , emp.hiredate AS fecha ";
			sql += "      , dept.dname AS dname ";
			sql += "      , dept.loc AS loc ";
			sql += "FROM emp, dept ";
			sql += "WHERE emp.depno = dept.depno";
			
			int n = 100;
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			pstm.setFetchSize(3); //Incrementa el rendimiento rs.next va de 3 en 3 en vez de 1 a 1, se ejucta una vez realiza la consulta
			//Es para querys que dan como resultado grandes cantidades de datos, no tiene sentido para pocos
			
			ResultSetMetaData md = rs.getMetaData(); //Da los resultados cojo METADATA
			_mostrarMetaData(md);
			_mostrarData(rs);
			
			String sql2= "";
			sql2 += "INSERT INTO dept (depno, dname, loc) ";
			sql2 += "VALUES(?,?,?)";
			pstm = con.prepareStatement(sql2);
			
			for (int i = 100; i < 150; i++) {
				
				pstm.setInt(1, i);
				pstm.setString(2, "PruebaBatch ("+i+")");
				pstm.setString(3, "PruebaBatch ("+i+")");
				pstm.addBatch();//Guarda todo para luego meterlo
			}
			int rtdo [] = pstm.executeBatch(); //Mete los datos
		}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		finally
		{
			try
			{
				if( rs!=null ) rs.close();
				if( pstm!=null ) pstm.close();
				if( con!=null ) con.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}

	}
	
	public static void _mostrarMetaData (ResultSetMetaData md) throws Exception {
		
		int cantCols = md.getColumnCount(); //pillo cantidad de columnas es un array
		
		System.out.println(cantCols + " Columnas Obtenidas");
		System.out.println();
		
		for (int i = 1; i <= cantCols; i++) {
			System.out.print("Columna Nº " + i + " ");
			System.out.print("Label: " + md.getColumnLabel(i) + ", ");  //label de la posicion i
			System.out.print("Type : " + md.getColumnType(i) + ", ");	// codigo tipo de dato de la posicion i
			System.out.print(md.getColumnTypeName(i) + ", ");			// nombre tipo de dato de la posicion i
			System.out.println("Precision: " + md.getPrecision(i));		// precision del tipo de datos
		}
		System.out.println();
	}
	
	public static void _mostrarData(ResultSet rs) throws Exception{
		
		int cantCols = rs.getMetaData().getColumnCount();
		while (rs.next()) {
			
			for (int i= 1 ; i <= cantCols ; i++) {
				System.out.print(rs.getString(i));
				System.out.print(i < cantCols ? " ," : " "); //Si es menor , si es mayor espacio
			}
			System.out.println();
		}
	}

}
