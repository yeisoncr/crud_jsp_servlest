package co.empresa.crud.dao;

import java.sql.*;
import java.util.*;

import co.empresa.crud.modelo.Usuario;

public interface UsuarioDAO {
	public void insert(Usuario usuario) throws SQLException;

	public void delete(int id) throws SQLException;

	public void update(Usuario usuario) throws SQLException;

	public List<Usuario> selectAll();

	public Usuario  select (int id);
}

