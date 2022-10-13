
public class Peliculas {
	
	//Atributos
	private String nombre;
	private String recaudacionMundial;
	private String recaudacionLocal;
	private String recaudacionExtranjera;
	private String año;
	
	//Constructor
	public Peliculas(String nombre, String recaudacionMundial, String recaudacionLocal, String recaudacionExtranjera,
			String año) {
		super();
		this.nombre = nombre;
		this.recaudacionMundial = recaudacionMundial;
		this.recaudacionLocal = recaudacionLocal;
		this.recaudacionExtranjera = recaudacionExtranjera;
		this.año = año;
	}
	
	
	//GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRecaudacionMundial() {
		return recaudacionMundial;
	}

	public void setRecaudacionMundial(String recaudacionMundial) {
		this.recaudacionMundial = recaudacionMundial;
	}

	public String getRecaudacionLocal() {
		return recaudacionLocal;
	}

	public void setRecaudacionLocal(String recaudacionLocal) {
		this.recaudacionLocal = recaudacionLocal;
	}

	public String getRecaudacionExtranjera() {
		return recaudacionExtranjera;
	}

	public void setRecaudacionExtranjera(String recaudacionExtranjera) {
		this.recaudacionExtranjera = recaudacionExtranjera;
	}

	public String getAño() {
		return año;
	}

	public void setAño(String año) {
		this.año = año;
	}

	//METODOS
	@Override
	public String toString() {
		return "nombre=" + nombre + ", recaudacionMundial=" + recaudacionMundial + ", recaudacionLocal="
				+ recaudacionLocal + ", recaudacionExtranjera=" + recaudacionExtranjera + ", año=" + año + "\n";
	}
	
	
	
	
	
	
	
	
	
	
	

}
