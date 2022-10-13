import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import org.json.*;



public class CineApp {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		// constante para saber el numero de peliculas
				int numeroPeliculas = 10;
				//Leo la informacion de las peliculas desde fichero
				Scanner entrada = new Scanner(new File("src/archivoPeliculas"));
				JSONArray arrayJSON = new JSONArray();
							
				//La guardo en un JSONArray
				while (entrada.hasNext()) {
					String string = (String) entrada.nextLine();
					JSONObject objetoJSON = new JSONObject();
					
					//Corto el string para filtrar la informacion
					objetoJSON.put("nombre", string.split("-")[0]);
					objetoJSON.put( "recaudacionMundial",string.split("-")[1]);
					objetoJSON.put( "recaudacionLocal",string.split("-")[2]);
					objetoJSON.put( "recaudacionExtranjera",string.split("-")[3]);
					objetoJSON.put( "año",string.split("-")[4]);
					
					
					arrayJSON.put(objetoJSON);
					
					
					
				}
				
				
				//Creo un array de peliculas para usar en la clase cine
				Peliculas arrayPeliculas[]= new Peliculas[numeroPeliculas];

				//Defino los arrays para guardar mis atributos para meterlos en el constructor de peliculas
				String nombres[] = new String[arrayJSON.length()];
				String recaudacionesMundial[] = new String[arrayJSON.length()];
				String recaudacionesLocal[] = new String[arrayJSON.length()];
				String recaudacionesExtranjera[] = new String[arrayJSON.length()];
				String años[] = new String[arrayJSON.length()];
				
				//Inicializo el array de peliculas con los datos obtenidos del JSON
				for (int i = 0; i < arrayJSON.length(); i++) {
					JSONObject json = (JSONObject) arrayJSON.get(i);
					nombres[i] = json.get("nombre").toString();
					recaudacionesMundial[i] = json.get("recaudacionMundial").toString();
					recaudacionesLocal[i] = json.get("recaudacionLocal").toString();
					recaudacionesExtranjera[i] = json.get("recaudacionExtranjera").toString();
					años[i] = json.get("año").toString();
					
					arrayPeliculas[i] = new Peliculas(nombres[i], recaudacionesMundial[i], 
							recaudacionesLocal[i], recaudacionesExtranjera[i], años[i]);
					
				}
				
				//Creo una clase Cine y meto el array de mis peliculas
				Cine cine = new Cine("Yelmo Cines", "Málaga", 8, arrayPeliculas);
				
				//Creo un archivo para guardar la informacion
				//recordemos que el metodo informacionCine tiene como salida una lista de Strings
				
				String nombreArchivo = "informacionCine.txt";
				try {
					Path archivo = Paths.get(nombreArchivo);
					Files.write(archivo, cine.informacionCine(), StandardCharsets.UTF_8);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
				
	
				

	}

}
