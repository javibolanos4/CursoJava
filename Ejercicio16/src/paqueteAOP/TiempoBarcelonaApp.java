package paqueteAOP;

import java.io.IOException;

import java.net.URL;
import java.util.Scanner;


import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TiempoBarcelonaApp {

	public static void main(String[] args) throws IOException, ParseException {
		//Conexion para la AOP
		
		AnnotationConfigApplicationContext ca = new AnnotationConfigApplicationContext(ConfiguradorAOPTiempo.class);
		ServicioTiempo servicio = ca.getBean(ServicioTiempo.class);
		ca.close();
		
		//Declaro la URL para obtener informacion de la API
		URL urlBarcelona = new URL("https://www.el-tiempo.net/api/json/v2/provincias/08");
		
		//Realizo la conexion
		HttpsURLConnection conexionBarcelona = (HttpsURLConnection) urlBarcelona.openConnection();
		
		//Declaro el metodo de Accion
		conexionBarcelona.setRequestMethod("GET");
		conexionBarcelona.connect();
		
		//Establezco un tiempo de conexion
		int tiempoRespuesta = conexionBarcelona.getResponseCode();
		
		//Declaro el String donde voy a guardar la informacion
		
		StringBuilder informacionEnString = new StringBuilder();
		
		if (tiempoRespuesta != 200) {
			throw new RuntimeException("Respuesta" + tiempoRespuesta);
			
		} else {
			Scanner entrada = new Scanner(urlBarcelona.openStream());
			
			while (entrada.hasNext()) {
				informacionEnString.append(entrada.nextLine()); //Guardo los datos en un StringBuilder
				
				
			}
		}
		
		//Ahora paso a JSON
		
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(informacionEnString.toString());
		
		String tiempoBarcelona = json.get("today").toString().split("\"")[3];
		
		//Utilizo el servicio
		servicio.mostrarTiempo(tiempoBarcelona);
		
	}

}
