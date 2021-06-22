
package com.mycompany.peliculas.domain;

//clase dominio del sistema , también puede conocerse como clase de "entidad"
//por ejemplo en JDBC Pelicula es una tabla en la base de datos y los atriutos son una columna, 

// esta clase, si fuese con intención de distribuirla en distintos servidores, debería implementar Serializable

public class Pelicula{
	//privado como si fuera un java bean
	private String nombre;
	
	public Pelicula(){
		
	}
	
	public Pelicula(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre){
		
	}
	
	/*la importancia de mandar 
	a imprimir solo el atributo es que va a servir
	para que el método buscar no tenga que complejizarse
	y solo exista la pelicula por nombre*/
	@Override
	public String toString(){
		return this.nombre;
	}
}