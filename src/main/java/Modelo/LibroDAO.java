package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class LibroDAO {

	Conexion cnn = new Conexion();
	Connection con = cnn.Conectar();
	PreparedStatement ps = null;
	ResultSet res = null;

	public boolean Inserta_Libro(LibroDTO lib) {
		boolean resul = false;
		try {
			String sql = "insert into libro values(?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, lib.getISBN());
			ps.setString(2, lib.getTitulo());
			ps.setString(3, lib.getEditorial());
			ps.setString(4, lib.getAutor());
			ps.setInt(5, lib.getNo_paginas());
			ps.setInt(6, 0);
			ps.setInt(7, 0);
			resul = ps.executeUpdate() > 0;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "error al insertar: " + ex);
		}
		return resul;
	}

	public LibroDTO Buscar_Libro(String Isbn) {

		LibroDTO lib = null;
		try {
			String sql = "select * from libro where ISBN=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, Isbn);
			res = ps.executeQuery();
			while (res.next()) {
				lib = new LibroDTO(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
						res.getInt(5));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al consultar" + e);
		}

		return lib;
	}

	public boolean Actualizar_Libro(LibroDTO lib) {
		boolean resul = false;
		try {
			String sql = "update libro set titulo=?, editorial=?, autor=?, No_paginas=? where isbn=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, lib.getTitulo());
			ps.setString(2, lib.getEditorial());
			ps.setString(3, lib.getAutor());
			ps.setInt(4, lib.getNo_paginas());
			ps.setString(5, lib.getISBN());
			resul = ps.executeUpdate() > 0;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "error al actualizar: " + ex);
		}
		return resul;
	}

	public boolean Eliminar_Libro(String isbn) {
		boolean resul = false;
		try {
			String sql = "delete from libro where isbn=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, isbn);
			resul = ps.executeUpdate() > 0;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "error al eliminar: " + ex);
		}
		return resul;
	}

	public boolean CargarLibros(String url) {

		boolean result = false;
		try {

			String sql = "load data infile '"+url+"' into table libro fields terminated by ',' lines terminated by '\r\n' ";
			ps = con.prepareStatement(sql);
			//ps.setString(1, url);
			result = ps.executeUpdate() > 0;

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "error al insertar libro: " + ex);


		}

		return result;

	}
	
	public ArrayList<LibroDTO> cargar_select() {
		
		LibroDTO lib =null;
		ArrayList<LibroDTO> lista =  new ArrayList<>();
		try {
			String sql ="select  * from libro";
			ps = con.prepareStatement(sql);
			res = ps.executeQuery();
			while(res.next()) {
				lib= new LibroDTO(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getInt(5));
				lista.add(lib);
			}
		} catch (Exception ex) {
			// TODO: handle exception
		}
		return lista;
		
	}

}
