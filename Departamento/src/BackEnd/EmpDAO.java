package BackEnd;

import ConectorBD.UConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.ResourceBundle;
import java.util.Vector;

public class EmpDAO {
	
	public Collection<EmpDTO> buscarXDept(int depno){
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {

			con = UConnection.getConnection();
			String sql = "";
			sql += "SELECT empno, ename, hiredate, depno "; //Cuidado con no dejar espacios entre sumas sql
			sql += "FROM emp ";
			sql += "WHERE depno = ? "; //fallo aqui
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, depno); // o aqui
			rs = pstm.executeQuery();
			
			Vector<EmpDTO> ret = new Vector<EmpDTO>();
			EmpDTO dto = null;
			while(rs.next()) {
				
				dto = new EmpDTO();             //Buen ejemplo de guardar en un array on add
				dto.setEmpno(rs.getInt("empno"));
				dto.setEname(rs.getString("ename"));
				dto.setDate(rs.getDate("hiredate"));
				dto.setDepno(rs.getInt("depno"));
				ret.add(dto);
			}
			return ret;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("Error al crear la conexion",ex);
		}
		
		finally {
			
			try {
				if(rs != null) rs.close();
				if(pstm != null) pstm.close();
				
			}
			catch(Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException("Error al crear la conexion",ex);
			}
		}
		
		
	
		
	}

}
