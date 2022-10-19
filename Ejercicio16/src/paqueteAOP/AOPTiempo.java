package paqueteAOP;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect //Le indica a java que este es el aspecto a ejecutar antes  
		//o a posteriori de las acciones
@Component //Como vamos a ejecutarlo, y que es una clase candidata 
			// a tener metodos ejecutables

public class AOPTiempo {
	
	@Before("execution(* mostrarTiempo(String))")
	public void log() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime hoy = LocalDateTime.now();
		System.out.println("A día de : " + formatter.format(hoy));
	}

}
