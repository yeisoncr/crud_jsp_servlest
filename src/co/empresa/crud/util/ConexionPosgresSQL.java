package co.empresa.crud.util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConexionPosgresSQL {
	
	private Connection con = null;
	private static ConexionPosgresSQL db;
	private java.sql.PreparedStatement preparedStatement;

	private static final String url = "jdbc:postgresql://localhost:5432/";
	private static final String dbName = "sistema";
	private static final String driver = "com.postgresql.Driver";
	private static final String userName = "root";
	private static final String password = "yeison";
	
	
	public ConexionPosgresSQL() {
		try {
			Class.forName(driver).newInstance();
			con = (Connection)DriverManager.getConnection(url + dbName, userName, password);

		} catch (InstantiationException e) {
			e.printStackTrace();

		} catch (IllegalAccessException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cerrarConexion() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ConexionPosgresSQL getConexion() {
		if (db == null)
			db = new ConexionPosgresSQL();
		return db;
	}

//metodo para consultar
	public ResultSet query() throws SQLException {
		ResultSet res = preparedStatement.executeQuery();
		return res;
	}

//metodo para actualizar
	public int execute() throws SQLException {
		int result = preparedStatement.executeUpdate();
		return result;
	}

//metodo para hacer la conexion
	public Connection getCon() {
		return this.con;
	}

	public java.sql.PreparedStatement setPreparedStatement(String sql) throws SQLException {
		this.preparedStatement = con.prepareStatement(sql);
		return this.preparedStatement;
	}


}
