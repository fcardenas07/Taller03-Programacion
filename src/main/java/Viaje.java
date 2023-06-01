import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Viaje {
	private String ciudadOrigen;
	private String ciudadDestino;
	private LocalTime horaSalida;
	private LocalTime horaLlegada;
	private ArrayList<String> pasajeros;
	private LocalDate fecha;

	public int getPasajeros() {
		throw new UnsupportedOperationException();
	}

	public void agregarPasajero() {
		throw new UnsupportedOperationException();
	}
}