package co.empresa.crud.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import java.util.*;

import co.empresa.crud.modelo.Usuario;
import co.empresa.crud.util.Conexion;

public class UsuarioDao {
	
	private Conexion conexion; 
	private static final String INSERT_USUARIO_SQL = "INSERT INTO usuario (nombre, email, pais) VALUES (?,?,?);";
	private static final String DELETE_USUARIO_SQL = "DELETE FROM usuario WHERE id = ? ;";
	private static final String UPDATE_USUARIO_SQL = "UPDATE  usuario SET  nombre = ?, email = ?, pais = ? WHERE id = ?;";
	private static final String SELECT_USUARIO_BY_ID = "SELECT * FROM usuario WHERE id = ?;";
	private static final String SELECT_ALL_USUARIOS = "SELECT * FROM usuario;";
	public UsuarioDao() {
		super();
		this.conexion = Conexion.getConexion();
	}
	
	
	public void insert(Usuario usuario) throws SQLException {
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(INSERT_USUARIO_SQL);
			preparedStatement.setString(1, usuario.getNombre());
			preparedStatement.setString(2, usuario.getEmail());
			preparedStatement.setString(3, usuario.getPais());
			conexion.execute();			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
	}
	
	public void delete(int id) throws SQLException {
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(DELETE_USUARIO_SQL);
			preparedStatement.setInt(1, id);

			conexion.execute();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	public void update(Usuario usuario )  throws SQLException {
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(UPDATE_USUARIO_SQL);
			preparedStatement.setString(1, usuario.getNombre());
			preparedStatement.setString(2, usuario.getEmail());
			preparedStatement.setString(3, usuario.getPais());
			preparedStatement.setInt(4, usuario.getId());
			conexion.execute();			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public List<Usuario> selectAll() {
		List<Usuario> usuarios = new ArrayList<>();
		try {
			conexion.setPreparedStatement(SELECT_ALL_USUARIOS);
			
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String email = rs.getString("email");
				String pais = rs.getString("pais");
				usuarios.add(new Usuario(id,nombre,email,pais));
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return usuarios;
		
	}
	
	public Usuario select(int id) {
		Usuario usuario = null;
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_USUARIO_BY_ID);
			preparedStatement.setInt(1, id);
			
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				String nombre = rs.getString("nombre");
				String email = rs.getString("email");
				String pais = rs.getString("pais");
				usuario = new Usuario(id,nombre,email,pais);
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return usuario;
		
	}
}
