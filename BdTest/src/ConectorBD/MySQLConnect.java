package ConectorBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MySQLConnect
{
	public static void main(String[] args)
	{
		/*String usr="root";
		String pwd="";			//Previo a la creacion de la clase UConnection
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost/departamento";*/
		
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement pstm=null;
		
		try
		{
			//Class.forName(driver); //Previo a la creacion de la clase Uconnection
			con = UConnection.getConnection();
			
			System.out.println(con.getClass().getName());
			
			String sql="SELECT depno,dname,loc FROM dept"; //Pillo sentencia

			
			pstm = con.prepareStatement(sql);		//La preparo
			
			rs = pstm.executeQuery();				// Executequery devuelve un tipo ResultSet que apunta a la posicion 0

			while( rs.next() ) //Se mueve por rs hasta llegar a NULL y devuelve False
			{
				System.out.print( rs.getInt("depno")+", " );
				System.out.print( rs.getString("dname")+", " );	//Accedemos a los campos de la fila
				System.out.print( rs.getString("loc")+", " );			
				System.out.println("");
			}
			
			//Prueba de Insert depno clave primaria
			String sql_insert ="";
			sql_insert+="INSERT INTO emp (depno, empno, ename,hiredate) ";
			sql_insert+="VALUES(?,?,?,?)";  //pstm puede parametrizar las entradas
			
			pstm = con.prepareStatement(sql_insert);
			
			pstm.setInt(1, 5);			//primero entra el parametro luego el valor
			pstm.setInt(2, 120);
			pstm.setString(3, "Borrame");
			pstm.setDate(4, java.sql.Date.valueOf("2010-03-04"));
			
			int rtdo = pstm.executeUpdate();  //Retorna un entero
			
			if (rtdo == 1)
			{
				System.out.println("Fila insertada correctamente");
			}
			
			else {
				
				throw new RuntimeException("No se pudo insertar fila");
			}
		
			
			Delete("Borrame",con,rs,pstm); //Funcion para Delete le paso la conexion activa y las variables ya creadas
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
	
	
	public static void Delete (String nombre, Connection con, ResultSet rs,PreparedStatement pstm) {
		
		//Utilizo el commit false para confirmar el exito de la operacion en la base de datos
		//Si entra en el if le doy true, todo ok
		//Si no funciona hago un rollback a la conexion y cierro el statement creado
		
		
		try {
			con.setAutoCommit(false);
			String sql ="";
			sql+="DELETE FROM emp WHERE ename = ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, nombre);
			int rtdo = pstm.executeUpdate();
			
			if (rtdo == 1)
				con.commit();//Todo ok vuelvo a true
			else
				throw new RuntimeException("Error");
		}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		
		finally {
			
			try {
				
				if(con != null) con.rollback();
				if(pstm != null) pstm.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
			
		}
	}
}
