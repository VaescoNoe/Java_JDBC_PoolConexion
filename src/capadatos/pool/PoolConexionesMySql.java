package capadatos.pool;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class PoolConexionesMySql {

	public static DataSource getDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUsername("root");
		ds.setPassword("");
		ds.setUrl("jdbc:mysql://localhost:3306/sga?useSSL=false");
		ds.setInitialSize(5);
		return ds;
	}
	
	public static Connection getConexion() throws SQLException{
		return getDataSource().getConnection();
	}
}
