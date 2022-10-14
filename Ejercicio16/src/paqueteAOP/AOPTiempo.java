package paqueteAOP;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect //Le indica a java que esta clase es el aspecto a ejecutar
	//A posteriori o antes de las acciones

@Component //Como vamos a ejecutarlo, y que es una clase 
// Candidata a tener metodos ejecutables 

public class AOPTiempo {
	
	@Before("execution(* mostrarTiempo(String))")
	public void log()
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss");  
        LocalDateTime hoy = LocalDateTime.now();
        System.out.println("A día de: "+ formatter.format(hoy));
	}
	
}
