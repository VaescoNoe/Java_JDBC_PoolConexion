package poolconexiones;


import capadatos.pool.PoolConexionesMySql;
import capadatos.pool.PoolConexionesOracle;
import java.sql.*;


public class TestPoolConexion {

	public static void main(String... args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = PoolConexionesMySql.getConexion();
				System.out.println("Pool de MySql");
			ps = conn.prepareStatement("SELECT * FROM persona");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int index = 1;
				System.out.println(" "+rs.getInt(index++));
				System.out.println(" "+rs.getString(index++));
				System.out.println(" "+rs.getString(index));
				System.out.println();
			}
			conn.close();
			
			conn = PoolConexionesOracle.getConexion();
				System.out.println("Pool de Oracle");
			ps = conn.prepareStatement("SELECT * FROM employees WHERE employee_id in (100,101,102)");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int index = 1;
				System.out.println(" "+rs.getInt(index++));
				System.out.println(" "+rs.getString(index++));
				System.out.println(" "+rs.getString(index));
				System.out.println();
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
}
