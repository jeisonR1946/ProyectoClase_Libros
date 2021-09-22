package Modelo;

public class LibroDTO {
	
	private String ISBN;
	private String Titulo;
	private String Editorial;
	private String Autor;
	private int No_paginas;
	
	
	public LibroDTO(String iSBN, String titulo, String editorial, String autor, int no_paginas) {
		ISBN = iSBN;
		Titulo = titulo;
		Editorial = editorial;
		Autor = autor;
		No_paginas = no_paginas;
	}


	public String getISBN() {
		return ISBN;
	}


	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}


	public String getTitulo() {
		return Titulo;
	}


	public void setTitulo(String titulo) {
		Titulo = titulo;
	}


	public String getEditorial() {
		return Editorial;
	}


	public void setEditorial(String editorial) {
		Editorial = editorial;
	}


	public String getAutor() {
		return Autor;
	}


	public void setAutor(String autor) {
		Autor = autor;
	}


	public int getNo_paginas() {
		return No_paginas;
	}


	public void setNo_paginas(int no_paginas) {
		No_paginas = no_paginas;
	}
	
	

}
