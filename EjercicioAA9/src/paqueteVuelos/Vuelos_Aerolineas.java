package paqueteVuelos;

import org.springframework.stereotype.Service;

@Service
public class Vuelos_Aerolineas {

	
	public int generarGananciaTotal(Vuelos arrayVuelos[]) {
		int suma = 0;
		for (int i = 0; i < arrayVuelos.length; i++) {
			suma += arrayVuelos[i].gananciaNeta();
		}
		return suma;
		
	}

}
