package co.empresa.crud.dao;

import co.empresa.crud.util.ConexionMySQL;
import co.empresa.crud.dao.UsuarioDaoMySQL;


public class UsuarioDaoFactory {
	public static UsuarioDAO getUsuarioDao(String type){
		switch (type) {
		case "mysql":
			return new UsuarioDaoMySQL();
		case "postgresql":
			return new UsuarioDaoPosgretSQL();
		default:
			return new UsuarioDaoPosgretSQL();
		}
	}
}