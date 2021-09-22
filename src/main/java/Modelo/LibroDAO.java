package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class LibroDAO {
	
	Conexion cnn= new Conexion();
	Connection con= cnn.Conectar();
	PreparedStatement ps= null;
	ResultSet res= null;
	
	public boolean Inserta_Libro(LibroDTO lib) {
	    boolean resul=false;
		try {
		String sql="insert into libro values(?,?,?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, lib.getISBN());
		ps.setString(2, lib.getTitulo());
		ps.setString(3, lib.getEditorial());
		ps.setString(4, lib.getAutor());
		ps.setInt(5, lib.getNo_paginas());
		resul=ps.executeUpdate()>0;	
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null,"error al insertar: "+ex);
		}
		return resul;
	}
	
	public LibroDTO Buscar_Libro(String Isbn) {
		
		LibroDTO lib= null;
		try {
		String sql="select * from libro where ISBN=?";	
		ps=con.prepareStatement(sql);
		ps.setString(1, Isbn);
		res=ps.executeQuery();
		while(res.next()) {
			lib = new LibroDTO(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getInt(5));
		}
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null,"Error al consultar" +e);
		}
	
		return lib;
	}
	
	public boolean Actualizar_Libro(LibroDTO lib) {
	    boolean resul=false;
		try {
		String sql="update libro set titulo=?, editorial=?, autor=?, No_paginas=? where isbn=?";
		ps = con.prepareStatement(sql);
		ps.setString(1, lib.getTitulo());
		ps.setString(2, lib.getEditorial());
		ps.setString(3, lib.getAutor());
		ps.setInt(4, lib.getNo_paginas());
		ps.setString(5, lib.getISBN());
		resul=ps.executeUpdate()>0;	
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null,"error al actualizar: "+ex);
		}
		return resul;
	}
	
	public boolean Eliminar_Libro(String isbn) {
	    boolean resul=false;
		try {
		String sql="delete from libro where isbn=?";
		ps = con.prepareStatement(sql);		
		ps.setString(1, isbn);
		resul=ps.executeUpdate()>0;	
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null,"error al eliminar: "+ex);
		}
		return resul;
	}

}
