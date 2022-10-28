import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class PersonajeApp {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		//Declaro la URL para obtener informacion de la API
		URL url = new URL("https://rickandmortyapi.com/api/character");
		//Realizo la conexion
		HttpsURLConnection conexion = (HttpsURLConnection) url.openConnection();

		//Declaro el metodo de Accion
		conexion.setRequestMethod("GET");
		conexion.connect();

		//Establezco un tiempo de conexion
		
	
		//Declaro el String donde voy a guardar la informacion
		
		StringBuilder informacionEnString = new StringBuilder();
		

			
		
		Scanner entrada = new Scanner(url.openStream());
			
		while (entrada.hasNext()) {
			informacionEnString.append(entrada.nextLine()); //Guardo los datos en un StringBuilder
				
				
		}
		
		
	
		
		//Los almaceno en un JSON
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(informacionEnString.toString());
		
		//me creo un array de json para informar sobre todos los personajes
		JSONObject personajesJSON[] = new JSONObject[20];
		Personaje personajes[] = new Personaje[20];
		
		JSONArray array = (JSONArray) json.get("results");

	
		//Lista para el txt donde guardo los personajes
		List <String> lista = new ArrayList<>();
		
		for (int i = 0; i < personajesJSON.length; i++) {
			personajesJSON[i] = (JSONObject) array.get(i);
			personajes[i] = new Personaje(personajesJSON[i].get("id").toString(), personajesJSON[i].get("name").toString(), 
					personajesJSON[i].get("status").toString(), personajesJSON[i].get("species").toString(), personajesJSON[i].get("type").toString(),
					personajesJSON[i].get("gender").toString(), personajesJSON[i].get("origin").toString().replaceAll("\"name\":\"", "nombre: ").replace("\",\"url\":\"", "--URL:"), personajesJSON[i].get("location").toString());
			
			lista.add(personajes[i].toString());
		}
		
		//Genro el txt donde tengo que imprimir la informacion
		
		String nombreArchivo = "personajes_Rick&Morty.txt";	
		
		try {
			
			Path archivo = Paths.get(nombreArchivo);
			Files.write(archivo, lista, StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

}
