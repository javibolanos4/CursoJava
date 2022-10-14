package paqueteAOP;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration //indico que es la clase de configuracion donde está el proxy
@ComponentScan("paqueteAOP") //Le indico el paquete en el que lo puede hacer
@EnableAspectJAutoProxy //Relacionamiento de las distintas clases entre si
public class ConfiguradorAOPTiempo {

}
