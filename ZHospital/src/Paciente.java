
public class Paciente extends Persona implements iCalcularEsperanza{

	//Atributos
	private String enfermedad;
	private String medicina;
	private int valorMedicina;
	private String seguroMedico;
	
	//Atributos generados
	private int ID;
	private Double valorFinal;
	
	private static int ID_DEF = 0;
	
	//Constructor
	public Paciente(String nombre, String fechaNacimiento, String enfermedad, String medicina, int valorMedicina,
			String seguroMedico) {
		super(nombre, fechaNacimiento);
		this.enfermedad = enfermedad;
		this.medicina = medicina;
		this.valorMedicina = valorMedicina;
		this.seguroMedico = seguroMedico;
		ID = generarID();
	}

	//Setters y getters
	public String getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}

	public String getMedicina() {
		return medicina;
	}

	public void setMedicina(String medicina) {
		this.medicina = medicina;
	}

	public int getValorMedicina() {
		return valorMedicina;
	}

	public void setValorMedicina(int valorMedicina) {
		this.valorMedicina = valorMedicina;
	}

	public String getSeguroMedico() {
		return seguroMedico;
	}

	public void setSeguroMedico(String seguroMedico) {
		this.seguroMedico = seguroMedico;
	}

	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	public Double getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(Double valorFinal) {
		this.valorFinal = valorFinal;
	}

	//Metodos
	@Override
	public String toString() {
		return "NOMBRE:" + getNombre() + "..........FECHA NACIMIENTO:" + getFechaNacimiento() + "..........EDAD:" + calcularEdad() + "..........ID:" + ID + "..........ENFERMEDAD:" + enfermedad + "..........MEDICINA:" + medicina + "..........VALOR:" + valorMedicina
				+ "..........SEGURO MEDICO:" + seguroMedico + "..........RECARGO:" + calcularRecargo() + "..........PRECIO FINAL:" + valorFinal + "..........ESPERANZA DE VIDA:" + calcularEsperanza();
	}
	
	private int generarID() {
		ID = ID_DEF;
		ID_DEF++;
		return ID;
	}
	
	public String calcularRecargo() {
		
		if (seguroMedico.contains("No Posee")) {
			valorFinal = (double)valorMedicina;
					
			return "No cobrar recargo";
		}
		else if (seguroMedico.contains("Swiss Medical")) {
			valorFinal = valorMedicina + valorMedicina*0.05;
			
			return "Cobrar un 5% de recargo";
		}
		else if (seguroMedico.contains("Assist Card")) {
			valorFinal = valorMedicina + valorMedicina*0.1;
			return "Cobrar un 10% de recargo";
		}
		else {
			return "El seguro medico no esta en la base de datos";
		}
	}

	@Override
	public String calcularEsperanza() {
		
		if (calcularEdad() >= 30 && enfermedad.contains("Alergia")) {
			return "Esperanza de vida baja";
		}else if (calcularEdad() <30 && enfermedad.contains("Rosacea")) {
			return "Esperanza de vida media";
		}else if (calcularEdad() <30) {
			return "Esperanza de vida alta";
		}else {
			return "Esperanza de vida media";
		}
		
		
	}
	
	
}
