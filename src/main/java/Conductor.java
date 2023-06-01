public class Conductor {
	private String nombre;
	private String apellido;

	private int numeroTelefonico;

	private Licencia licencia;

	public Conductor(String nombre, String apellido, int numeroTelefonico, Licencia licencia) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.numeroTelefonico = numeroTelefonico;
		this.licencia = licencia;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getApellido() {
		return this.apellido;
	}
}