package com.mycompany.peliculas.vista;

//esta parte podría ser  web desk mobile 

import java.util.Scanner;
import com.mycompany.peliculas.servicio.*;

public class CatalogoPeliculasPresentacion{
	public static void main(String[] args){
		var opcion = -1;
		var scanner = new Scanner(System.in);
		
		/*explicitando que es una interface
		no comunicándose directo con la capa de datos, 
		ni de servicio, etc -> bajo acoplamiento y alta cohesión*/
		ICatalogoPeliculas catalogo = new CatalogoPeliculasImpl();
		
		while(opcion != 0){
			System.out.println("Elegir acción: \n"
				+ "1. Reiniciar catalogo peliculas \n" /*evitársele esta opción al usuario real*/
				+ "2. Agregar pelicula\n"
				+ "3. Listar peliculas\n"
				+ "4. Buscar pelicula \n"
				+ "0. Salir");
			opcion = Integer.parseInt(scanner.nextLine());
			
			/*acá no hace falta hacer manejo de excepciones
			para eso hice las otras capas*/
			switch(opcion){
				case 1:
						catalogo.iniciarCatalogoPeliculas();
						break;
				case 2:
						System.out.println("Introducir nombre de la pelicula: ");
						var nombrePelicula = scanner.nextLine();
						catalogo.agregarPelicula(nombrePelicula);
						break;
				case 3:
						catalogo.listarPeliculas();
						break;
				case 4:
						System.out.println("Introducir el nombre de la pelicula a buscar: ");
						var buscar = scanner.nextLine();
						catalogo.buscarPelicula(buscar);
						break;
				case 0:
						System.out.println("Cerrando aplicación");
						break;
				default:
						System.out.println("Opción no reconocida");
						break;
			}
		}
	}
}