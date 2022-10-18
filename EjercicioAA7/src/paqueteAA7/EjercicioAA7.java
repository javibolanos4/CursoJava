package paqueteAA7;

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

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EjercicioAA7 {

	public static void main(String[] args) throws IOException, ParseException {
		//Declaro la URL para conectarme con la API
		URL urlBarcelona = new URL ("https://www.el-tiempo.net/api/json/v2/provincias/08");
		
		//Realizo las conexiones
		
		HttpsURLConnection conexionBarcelona = (HttpsURLConnection) urlBarcelona.openConnection();
		
		//Declaro el metodo de acccion
		conexionBarcelona.setRequestMethod("GET");
		conexionBarcelona.connect();
		
		//Establezco un tiempo de conexion
		 int tiempoRespuesta = conexionBarcelona.getResponseCode();
		//Declaro el String donde voy a guardar la informacion
			
			StringBuilder informacionEnString = new StringBuilder();
		 
		 if (tiempoRespuesta != 200) {
			 throw new RuntimeException("Respuesta" + tiempoRespuesta);
		}else {
			Scanner entrada = new Scanner(urlBarcelona.openStream());
			
			while (entrada.hasNext()) {
				
				informacionEnString.append(entrada.nextLine());//Guardo los datos en un StringBuiler
				
			}

		}
		 
		 //Ahora paso a JSON
		 JSONParser parser = new JSONParser();
		 JSONObject json = (JSONObject) parser.parse(informacionEnString.toString());
		 
		 String tiempoHoy = json.get("today").toString().split("\"")[3];
		 String tiempoMañana = json.get("tomorrow").toString().split("\"")[3];
		 //System.out.println(tiempoHoy);
		 //System.out.println(tiempoMañana);
		 
		 
		 //Creo el archivo Jenkins
		 String nombreArchivo = "tiempoJenkins.txt";
		 //Creo una lista en la que escribo el código jenkins
		 List <String> lista = new ArrayList<>();
		 lista.add("import java.text.SimpleDateFormat\r\n"
		 		+ "pipeline {\r\n"
		 		+ "    agent any\r\n"
		 		+ "    stages{\r\n"
		 		+ "        stage('MostrarTiempo'){\r\n"
		 		+ "            steps{\r\n"
		 		+ "                script{\r\n"
		 		+ "                    println \"El tiempo para hoy es: \r\n" + tiempoHoy + "\"\n"
		 		+ "                    println \"El tiempo para mañana es: \r\n" + tiempoMañana + "\"\n"
		 		+ "                }\r\n"
		 		+ "            }\r\n"
		 		+ "        }\r\n"
		 		+ "    }\r\n"
		 		+ "}");
		 
		 
		 
		 try {
			 Path archivo = Paths.get(nombreArchivo);
			 Files.write(archivo, lista, StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
