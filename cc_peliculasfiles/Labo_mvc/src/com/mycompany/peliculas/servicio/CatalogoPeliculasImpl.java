package com.mycompany.peliculas.servicio;

/*podría implementar más métodos que no estuvieran definidos
 en la interface, pero quien hiciera uso de la interface
 no tendría acceso a esos métodos y por eso no está hecho así
*/
import com.mycompany.peliculas.excepciones.*;
import com.mycompany.peliculas.datos.IAccesoDatos;
import com.mycompany.peliculas.datos.AccesoDatosImpl;
import com.mycompany.peliculas.domain.Pelicula;

public class CatalogoPeliculasImpl implements ICatalogoPeliculas{
	private final IAccesoDatos datos;
	
	/*acá es útil haber usado interface
	podría asignar a this.datos cualquier implementación
	aprovecharía así para conectar a una base de datos
	esto es simil a el concepto de inyección de dependencias*/
	public CatalogoPeliculasImpl(){
		this.datos = new AccesoDatosImpl();
		//this.datos. podría llamar a los métodos de la interface
	}
	
	@Override
	public void agregarPelicula(String nombrePelicula){
		Pelicula pelicula = new Pelicula(nombrePelicula);
		boolean anexar = false;
		try {
			anexar = datos.existe(NOMBRE_RECURSO);
			datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
		} catch(AccesoDatosEx ex){
			System.out.println("Error de acceso a datos");
			ex.printStackTrace(System.out);
		}
	}
	
	@Override
	public void listarPeliculas(){
		try {
			var peliculas = this.datos.listar(NOMBRE_RECURSO);
			for(var pelicula : peliculas){
				/*señala que éste método ya no tiene
				nada que ver con el archivo, tiene que ver
				con la constante NOMBRE_RECURSO
				Eso supuestamente hace recomendable trabajar
				con esta nueva capa de datos*/
				System.out.println("pelicula = " + pelicula);
			}
		} catch (AccesoDatosEx ex) 
                        /*para captar un tipo más genérico*/
			/*decidimos no seguir propagando la excepción
			porque lo siguiente es la capa de visualización
			por ende lo manda al system out
			en lugar de propagarla, ya la "procesa"*/
			{ 
                        System.out.println("Error de acceso de datos");
			ex.printStackTrace(System.out);
		}
	}
	
	@Override
	public void buscarPelicula(String buscar){
		String resultado = null;
		try {
			resultado = this.datos.buscar(NOMBRE_RECURSO, buscar);
		} catch (AccesoDatosEx ex){
			System.out.println("Error de acceso de datos en el método buscar pelicula");
			ex.printStackTrace(System.out);
		}
		System.out.println("resultado = " + resultado);
	}
	
	@Override
	public void iniciarCatalogoPeliculas(){
		try {
			if(this.datos.existe(NOMBRE_RECURSO)){
				datos.borrar(NOMBRE_RECURSO);
				datos.crear(NOMBRE_RECURSO);
			} else {
				datos.crear(NOMBRE_RECURSO);
			}
		} catch (AccesoDatosEx ex){
			System.out.println("Error al iniciar catálogo de peliculas");
			ex.printStackTrace(System.out);
		}
	}
}