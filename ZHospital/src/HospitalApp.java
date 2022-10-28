import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class HospitalApp {
	
	public static void main(String[] args) throws FileNotFoundException {
			
		
		//Primero tengo que leer la base de datos y los guardo en un set para eliminar duplicados
		
		Scanner entrada = new Scanner(new File("src/datos.txt"));
		Set <String> conjunto = new TreeSet<String>();
		
		while (entrada.hasNext()) {
			String string = (String) entrada.nextLine();
			conjunto.add(string);
			
		}
		
		//Lo paso a una lista para poder acceder a los datos
		List <String> lista = new ArrayList<String>(conjunto);
		int tamañoLista = lista.size();
		
		//Me creo un array de pacientes en los que voy a guardar la informacion
		Paciente pacientes[] = new Paciente[5];
		int contador = 0;
		
		while (contador < tamañoLista) {
			pacientes[contador] = new Paciente(lista.get(contador).split("-")[0].replaceAll("[^\\dA-Za-z]", ""), lista.get(contador).split("-")[1],
					lista.get(contador).split("-")[2], lista.get(contador).split("-")[3], Integer.parseInt(lista.get(contador).split("-")[4]),
					lista.get(contador).split("-")[5]);
			//System.out.println(pacientes[contador].toString());
			contador ++ ;
		}
		
		//Limpio la lista para reutilizarla e imprinir el archivo
		lista.clear();
		contador = 0;
		while (contador < tamañoLista) {
			lista.add(pacientes[contador].toString());
			contador ++ ;
		}
		
		//Genro el txt donde tengo que imprimir la informacion
		
		String nombreArchivo = "pacientesEstado.txt";	
		
		try {
			
			Path archivo = Paths.get(nombreArchivo);
			Files.write(archivo, lista, StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
