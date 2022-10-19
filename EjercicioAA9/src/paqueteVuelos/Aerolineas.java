package paqueteVuelos;

public class Aerolineas {
	
	//Atributos
	private String nombre;
	private String ubicacion;
	private String ceo;
	
	//Constructor
	public Aerolineas(String nombre, String ubicacion, String ceo) {
		super();
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.ceo = ceo;
	}

	//Getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
	
	

}
