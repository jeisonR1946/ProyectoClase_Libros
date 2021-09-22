package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Modelo.LibroDAO;
import Modelo.LibroDTO;

/**
 * Servlet implementation class Libro
 */
@WebServlet("/Libro")
public class Libro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Libro() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LibroDAO libDao = new LibroDAO();
		if (request.getParameter("registrar") != null) {
			String codIsbn, titulo, editorial, autor;
			int paginas;
			codIsbn = request.getParameter("isbn");
			titulo = request.getParameter("titulo");
			editorial = request.getParameter("editorial");
			autor = request.getParameter("autor");
			paginas = Integer.parseInt(request.getParameter("paginas"));
			LibroDTO libDto = new LibroDTO(codIsbn, titulo, editorial, autor, paginas);
			if (libDao.Inserta_Libro(libDto)) {
		//		JOptionPane.showMessageDialog(null, "Libro Registrado Exitosamente.");
				response.sendRedirect("Libros.jsp?men=Libro Registrado Exitosamente.");
			} else {
		//		JOptionPane.showMessageDialog(null, "El libro no se Registro.");
				response.sendRedirect("Libros.jsp?men=El libro no se Registro.");
			}
		}

		if (request.getParameter("consultar") != null) {

			String codigo, titulo, editorial, autor;
			int paginas;
			codigo = request.getParameter("codigo");
			LibroDTO lib = libDao.Buscar_Libro(codigo);
			if (lib != null) {

				codigo = lib.getISBN();
				titulo = lib.getTitulo();
				editorial = lib.getEditorial();
				autor = lib.getAutor();
				paginas = lib.getNo_paginas();
				response.sendRedirect("Libros.jsp?codigo=" + codigo + "&&titulo=" + titulo + "&&editorial=" + editorial
						+ "&&autor=" + autor + "&&paginas=" + paginas);

			}else {
				response.sendRedirect("Libros.jsp?men=El libro no existe");
			}

		}

		if (request.getParameter("actualizar") != null) {
			String codIsbn, titulo, editorial, autor;
			int paginas;
			codIsbn = request.getParameter("cod");
			titulo = request.getParameter("titulo");
			editorial = request.getParameter("editorial");
			autor = request.getParameter("autor");
			paginas = Integer.parseInt(request.getParameter("paginas"));
			LibroDTO libDto_Act = new LibroDTO(codIsbn, titulo, editorial, autor, paginas);
			if (libDao.Actualizar_Libro(libDto_Act)) {
			//	JOptionPane.showMessageDialog(null, "Libro se Actualizo Exitosamente.");
				response.sendRedirect("Libros.jsp?men=Libro Actualizado Exitosamente.");
			} else {
			//	JOptionPane.showMessageDialog(null, "El libro no se Modifico.");
				response.sendRedirect("Libros.jsp?men=El libro no se Modifico.");
			}
		}

		if (request.getParameter("eliminar") != null) {
			String codIsbn;
			codIsbn = request.getParameter("cod");
			int op = JOptionPane.showConfirmDialog(null, "Seguro dese eliminar el libro: " + codIsbn);
			if (op == 0) {

				if (libDao.Eliminar_Libro(codIsbn)) {
					response.sendRedirect("Libros.jsp?men=Libro eliminado");
				} else {
					response.sendRedirect("Libros.jsp?men=Libro NO eliminado");
				}
			}
		}
		
		
		
	}
}
