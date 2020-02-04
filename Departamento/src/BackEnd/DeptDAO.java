package BackEnd;

import ConectorBD.UConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.ResourceBundle;
import java.util.Vector;

public class DeptDAO { /// DAOS Se gestionan los accesos a bases de datos
	
	public Collection<DeptDTO> buscarTodos(){ //Voy a devolver una coleccion de datos sacados de la base
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			con = UConnection.getConnection();
			String sql = "SELECT depno, dname, loc FROM dept";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			Vector<DeptDTO> ret = new Vector<DeptDTO>();
			DeptDTO dto = null;
			while(rs.next()) {
				
				dto = new DeptDTO();             //Buen ejemplo de guardar en un array on add
				dto.setDepno(rs.getInt("depno"));
				dto.setDname(rs.getString("dname"));
				dto.setLoc(rs.getString("loc"));
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
