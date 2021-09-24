package Modelo;

public class PrestamosDTO {
	
	private int Id_prestamo;
	private String Estudiante;
	private String Libro;
	private String Fecha_prestamo;
	private String Fecha_devolucion;
	private int Sancion;
	
	public PrestamosDTO(String estudiante, String libro, String fecha_prestamo) {
		
		Estudiante = estudiante;
		Libro = libro;
		Fecha_prestamo = fecha_prestamo;
	}

	public int getId_prestamo() {
		return Id_prestamo;
	}

	public void setId_prestamo(int id_prestamo) {
		Id_prestamo = id_prestamo;
	}

	public String getEstudiante() {
		return Estudiante;
	}

	public void setEstudiante(String estudiante) {
		Estudiante = estudiante;
	}

	public String getLibro() {
		return Libro;
	}

	public void setLibro(String libro) {
		Libro = libro;
	}

	public String getFecha_prestamo() {
		return Fecha_prestamo;
	}

	public void setFecha_prestamo(String fecha_prestamo) {
		Fecha_prestamo = fecha_prestamo;
	}

	public String getFecha_devolucion() {
		return Fecha_devolucion;
	}

	public void setFecha_devolucion(String fecha_devolucion) {
		Fecha_devolucion = fecha_devolucion;
	}

	public int getSancion() {
		return Sancion;
	}

	public void setSancion(int sancion) {
		Sancion = sancion;
	}
	
	
	
	

}
