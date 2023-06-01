import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Viaje {
	private final String ciudadOrigen;
	private final String ciudadDestino;
	private final LocalTime horaSalida;
	private final LocalTime horaLlegada;
	private final ArrayList<String> pasajeros;
	private final LocalDate fecha;


	public Viaje(String ciudadOrigen,
				 String ciudadDestino,
				 LocalTime horaSalida,
				 LocalTime horaLlegada,
				 ArrayList<String> pasajeros,
				 LocalDate fecha) {
		this.ciudadOrigen = ciudadOrigen;
		this.ciudadDestino = ciudadDestino;
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.pasajeros = pasajeros;
		this.fecha = fecha;
	}

	public int getPasajeros() {
		return pasajeros.size();
	}

	public void agregarPasajero(String pasajero) {
		pasajeros.add(pasajero);
	}

	public String getCiudadDestino() {
		return ciudadDestino;
	}

	public LocalTime getHoraLlegada() {
		return horaLlegada;
	}

	public LocalTime getHoraSalida() {
		return horaSalida;
	}
}