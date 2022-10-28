
public class Personaje {
	
	//Atributos
	private String id;
	private String nombre;
	private String status;
	private String especie;
	private String tipo;
	private String genero;
	private String origen;
	private String localizacion;
	
	//Constructor
	public Personaje(String id, String nombre, String status, String especie, String tipo, String genero, String origen,
			String localizacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.status = status;
		this.especie = especie;
		this.tipo = tipo;
		this.genero = genero;
		this.origen = origen;
		this.localizacion = localizacion;
	}
	
	//Seters y getters
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getLocalizacion() {
		return localizacion;
	}
	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}
	
	
	//Metodos
	@Override
	public String toString() {
		return "Personaje [id=" + id + ", nombre=" + nombre + ", status=" + status + ", especie=" + especie + ", tipo="
				+ tipo + ", genero=" + genero + ", origen=" + origen + ", localizacion=" + localizacion + "]";
	}

	
	
}
