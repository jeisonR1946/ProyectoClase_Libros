package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class PrestamosDAO {

	Conexion cnn = new Conexion();
	Connection con = cnn.Conectar();
	PreparedStatement ps = null;
	ResultSet res = null;

	public boolean Insertar_Prestamo(PrestamosDTO p) {

		boolean resul = false;
		try {
			String sql = "insert into prestamo (estudiante,libro,fecha_prestamo) values(?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, p.getEstudiante());
			ps.setString(2, p.getLibro());
			ps.setString(3, p.getFecha_prestamo());
			resul = ps.executeUpdate() > 0;
			if (resul) {

				sql = "select Id_prestamo from prestamo order by  Id_prestamo desc limit 1 ";
				ps = con.prepareStatement(sql);
				res = ps.executeQuery();
				int codigo = 0;
				while (res.next()) {
					codigo = res.getInt(1);
				}
				sql = "update prestamo set Fecha_devolucion=Fecha_prestamo+7 where Id_prestamo=?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, codigo);
				resul = ps.executeUpdate() > 0;

				sql = "select Precio_unit from libro where isbn=?";
				ps = con.prepareStatement(sql);
				ps.setString(1, p.getLibro());
				res = ps.executeQuery();

				int precio = 0;
				while (res.next()) {
					precio = res.getInt(1);
				}
				
				sql = "select  count(Libro) from prestamo group  by libro having Libro=?";
				ps = con.prepareStatement(sql);
				ps.setString(1, p.getLibro());
				res = ps.executeQuery();

				int cantidad = 0;
				while (res.next()) {
					cantidad = res.getInt(1);
				}
				
				sql = "update libro set Acumulado = ? * ? where isbn=?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, precio);
				ps.setInt(2, cantidad);
				ps.setString(3, p.getLibro());
				resul = ps.executeUpdate() > 0;

			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "error al insertar el prestamo: " + ex);
		}
		return resul;

	}
	
	

}
