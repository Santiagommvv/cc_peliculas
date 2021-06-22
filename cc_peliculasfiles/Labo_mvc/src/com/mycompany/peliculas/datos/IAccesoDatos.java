package com.mycompany.peliculas.datos;

import com.mycompany.peliculas.excepciones.*;
import com.mycompany.peliculas.domain.Pelicula;

import java.util.List;

public interface IAccesoDatos{
	//"nombreRecurso" y no "nombreArchivo" en caso que quiera extender la implementacion a una base de datos
	boolean existe(String nombreRecurso) throws AccesoDatosEx;
	
	List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx;
	
	void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx;
	
	String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx;
	
	void crear(String nombreRecurso) throws AccesoDatosEx;
	
	void borrar(String nombreRecurso) throws AccesoDatosEx;
}