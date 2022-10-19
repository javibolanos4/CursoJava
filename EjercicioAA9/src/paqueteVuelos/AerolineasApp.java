package paqueteVuelos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AerolineasApp {

	public static void main(String[] args) throws FileNotFoundException {
		
		int numeroVuelos = 4; //Variable que recoge el numero de vuelos que hay
		//Creo un Array con el nombre de los archivos
		String nombreArchivos[] = {"src/BARCELONA.txt","src/BERLIN.txt","src/BUENOSAIRES.txt","src/MADRID.txt"};
		
		//Creo un array con los datos de los vuelos
		String arrayCiudad[] = new String[numeroVuelos];
		Integer arrayCantidadPasajes[] = new Integer[numeroVuelos];
		String arrayVuelo[] = new String[numeroVuelos];
		
		//Leo Cada uno de los archivos
		for (int i = 0; i < nombreArchivos.length; i++) {
			Scanner entrada = new Scanner(new File(nombreArchivos[i]));
			
			int contador = 0;
			while (entrada.hasNext()) {
				String string = (String) entrada.nextLine();
				
				if (contador == 0) {
					arrayCiudad[i] = string;
					contador ++;
				}else if (contador == 1) {
					arrayCantidadPasajes[i] = Integer.parseInt(string.split(":")[1].replace(" ", ""));
					contador++;
				}else if (contador == 2) {
					arrayVuelo[i] = string.split(":")[1];
					contador = 0;
				}
							
			}
				
		}
		
		//Me creo un array con los vuelos y los inicializo
		Vuelos arrayVuelos[] = new Vuelos[numeroVuelos];
		
		for (int i = 0; i < arrayVuelos.length; i++) {
			arrayVuelos[i] = new Vuelos(arrayCiudad[i], arrayCantidadPasajes[i], arrayVuelo[i]);
		}
		
		//Genero la conexion para AOP
		
		AnnotationConfigApplicationContext ca = new AnnotationConfigApplicationContext(ConfiguradorVuelos.class);
		Vuelos_Aerolineas servicio = ca.getBean(Vuelos_Aerolineas.class);
		ca.close();
		
		//utilizo el servicio
		int gananciaTotal = servicio.generarGananciaTotal(arrayVuelos);
		
		
		//Creo unas Aeroilinea y guardo la indormacion en una lista
		Aerolineas aerolinea = new Aerolineas("Iberia", "Madrid", "Joaquin");
		
		List<String> lista = new ArrayList<>();
		
		lista.add("Nombre Aerolinea: " + aerolinea.getNombre());
		lista.add("Ubicacion Aerolinea: " + aerolinea.getUbicacion());
		lista.add("CEO: " + aerolinea.getCeo());
		lista.add("*************");
		for (int i = 0; i < arrayVuelos.length; i++) {
			lista.add(arrayVuelos[i].getCiudad());
			lista.add("Cantidad de Pasajes: " + arrayVuelos[i].getCantidadPasajes());
			lista.add("Turno: " + arrayVuelos[i].getVuelo());
			lista.add("Ganancia Neta: " + arrayVuelos[i].gananciaNeta());
			lista.add("Cantidad de Pasajeros: " + arrayVuelos[i].cantidadPasajeros());
			lista.add("-------------------");
		}
		lista.add("******************");
		lista.add("GANANCIA TOTAL: " + gananciaTotal);
		
		//imprimo la lista en un archivo txt
		
		//Para el nombre del archivo cojo la fecha de hoy
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM.yyyy");
		LocalDateTime hoy = LocalDateTime.now();
		
		
		String nombreArchivo = "resumenVentas" + dtf.format(hoy) +".txt";
		
		try {
			Path archivo = Paths.get(nombreArchivo);
			Files.write(archivo, lista, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
