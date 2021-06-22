package com.mycompany.peliculas.servicio;
//esto está orientado "más" al uso del usuario(respecto a la capa de datos obviusly)

public interface ICatalogoPeliculas{
	//public static final
	String NOMBRE_RECURSO = "peliculas.txt";
	
	//ya no es nombre de recurso
	void agregarPelicula(String nombrePelicula);
	
	void listarPeliculas();
	
	void buscarPelicula(String buscar);
	
	void iniciarCatalogoPeliculas();
	
}