package paqueteVuelos;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect //Le indica a java que este es el aspecto a ejecutar antes  
//o a posteriori de las acciones
@Component //Como vamos a ejecutarlo, y que es una clase candidata 
	// a tener metodos ejecutables
public class AOPVuelos {
	
	@Before("execution(public int generarGananciaTotal(Vuelos[]))")
	public void log() {
		System.out.println("Warning! Generando Ganancias Totales");
	}

}
