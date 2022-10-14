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
		
		//Conexion con para la AOP
		AnnotationConfigApplicationContext ca = new AnnotationConfigApplicationContext(ConfiguradorAOPTiempo.class);
		ServicioTiempo servicio = ca.getBean(ServicioTiempo.class);
		ca.close();
		
		// Declaro la url para obtener informacion de la API
		URL urlBarcelona = new URL ("https://www.el-tiempo.net/api/json/v2/provincias/08");
		

		//Realizo las conexiones conexion
		HttpsURLConnection conexionBarcelona = (HttpsURLConnection) urlBarcelona.openConnection();
		
		//Declaro el metodo de accion
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
				
				informacionEnString.append(entrada.nextLine());//Guardo los datos en un StringBuiler
				
			}
	

		}
		
		//Ahora paso a JSON
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(informacionEnString.toString());
	
		//Utilizo el metodo  de servicios para mostrar la informacion
		servicio.mostrarTiempo(json.get("today").toString().split("\"")[3]);
		
		

	}

}
