package org.formacion.srp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Recomendador {

	//Devuelve una lista de objetos del tipo pelicula
	//Recomendaciones no deberia recomendar peliculas ya vistas por el cliente. 
	public List<Pelicula> recomendaciones (Cliente cliente) {
		
		List<Pelicula> recomendadas = new ArrayList<>();
		
		for (Pelicula favorita: cliente.getFavoritas()) {
			recomendadas.addAll(BBDD.PELIS_POR_DIRECTOR.get(favorita.getDirector()));
		}
		
		//Debemos quitar las peliculas favoritas de la lista
		recomendadas.removeAll(cliente.getFavoritas());
		
		return recomendadas;
	}
	
	//Devuelve recomendaciones en un CSV.
	//AMBAS FUNCIONES DEBERIAN ESTAR EN CLASES DISTINTAS YA QUE SON RESPONSABILIDADES DISTINTAS, MOVEMOS ESTO A EXPORTADORCSV 
	
	/*public String recomendacionesCSV (Cliente cliente) {
		
		return recomendaciones(cliente).stream()
		      .map(p -> (p.getTitulo() + "," + p.getDirector() + "," + p.getGenero()))
		      .collect(Collectors.joining("\n"));
	} */
}

