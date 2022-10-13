import java.util.ArrayList;

import java.util.List;



public class Cine {

	//Atributos
	private String nombre;
	private String localidad;
	private int numeroSalas;
	private Peliculas listaPeliculas[]= new Peliculas[10];
	
	//Constructor
	public Cine(String nombre, String localidad, int numeroSalas, Peliculas[] listaPeliculas) {
		super();
		this.nombre = nombre;
		this.localidad = localidad;
		this.numeroSalas = numeroSalas;
		this.listaPeliculas = listaPeliculas;
	}
	
	//GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public int getNumeroSalas() {
		return numeroSalas;
	}

	public void setNumeroSalas(int numeroSalas) {
		this.numeroSalas = numeroSalas;
	}

	public Peliculas[] getListaPeliculas() {
		return listaPeliculas;
	}

	public void setListaPeliculas(Peliculas[] listaPeliculas) {
		this.listaPeliculas = listaPeliculas;
	}
	

		
	//Metodos

	
	public List<String> informacionCine() {
		List <String> lista = new ArrayList<>();
		lista.add("La informacion del cine es la siguiente: \n" 
				+ "Nombre: "  + nombre +
				"\nLocalidad: " + localidad + 
				"\nNumero de Salas: " + numeroSalas + "\nPeliculas: \n");
		for (int i = 0; i < listaPeliculas.length; i++) {
			lista.add(listaPeliculas[i].toString());
			
		}
		return lista;
	}
	
}
