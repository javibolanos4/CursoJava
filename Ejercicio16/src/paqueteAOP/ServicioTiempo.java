package paqueteAOP;

import org.springframework.stereotype.Service;

@Service
public class ServicioTiempo {
	public void mostrarTiempo(String tiempoBarcelona) {
		
		System.out.println("Este es el tiempo en Barcelona: \n" + tiempoBarcelona); 
	}

}
