package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.LibroDAO;
import Modelo.LibroDTO;
import Modelo.PrestamosDAO;
import Modelo.PrestamosDTO;

/**
 * Servlet implementation class Prestamo
 */
@WebServlet("/Prestamo")
public class Prestamo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Prestamo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("consultarlib") != null) {

			LibroDAO libDao =  new LibroDAO();
			LibroDTO lib=null;

			String codigo, titulo;
			codigo = request.getParameter("codigo");

			lib = libDao.Buscar_Libro(codigo);
			if (lib != null) {

				codigo = lib.getISBN();
				titulo = lib.getTitulo();
				response.sendRedirect("Prestamos.jsp?isbn=" + codigo + "&&titulo=" + titulo);

			} else {
				response.sendRedirect("Prestamos.jsp?men=El libro no existe");
			}

		}
		
		if(request.getParameter("registrar")!=null) {
			
			
			String isbn,estudiante,fecha;
			isbn=request.getParameter("isbnlib");
			estudiante = request.getParameter("est");
			fecha= request.getParameter("fecha");
			PrestamosDTO p = new PrestamosDTO(estudiante, isbn, fecha);
			PrestamosDAO pDAO = new PrestamosDAO();
			if(pDAO.Insertar_Prestamo(p)) {
				response.sendRedirect("Prestamos.jsp?men=Se registro el prestamo exitosamente");
				
			} else {
				response.sendRedirect("Prestamos.jsp?men=El prestamo NO se  exitosamente");
			}
		}

	}

}
