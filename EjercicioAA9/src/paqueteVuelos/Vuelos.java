package paqueteVuelos;

public class Vuelos implements iVuelos {
	
	//Atributos
	private String ciudad;
	private int cantidadPasajes;
	private String vuelo;
	
	//Constructor
	public Vuelos(String ciudad, int cantidadPasajes, String vuelo) {
		super();
		this.ciudad = ciudad;
		this.cantidadPasajes = cantidadPasajes;
		this.vuelo = vuelo;
	}

	
	//Getters y setters
	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getCantidadPasajes() {
		return cantidadPasajes;
	}

	public void setCantidadPasajes(int cantidadPasajes) {
		this.cantidadPasajes = cantidadPasajes;
	}

	public String getVuelo() {
		return vuelo;
	}

	public void setVuelo(String vuelo) {
		this.vuelo = vuelo;
	}
	
	//Metodos
	@Override
	public int gananciaNeta() {
		
		return cantidadPasajes * 50;
	}
	
	@Override
	public int cantidadPasajeros() {
		
		return cantidadPasajes / 2;
	}


	@Override
	public String toString() {
		return "Vuelos [ciudad=" + ciudad + ", cantidadPasajes=" + cantidadPasajes + ", vuelo=" + vuelo + "]";
	}
	
	

}
