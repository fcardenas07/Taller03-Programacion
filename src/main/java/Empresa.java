import java.time.LocalDate;
import java.util.ArrayList;

public class Empresa {
    private final String rut;
    private final String direccion;
    private final ArrayList<String> redesSociales;
    private final ArrayList<Bus> buses = new ArrayList<>();
    private final ArrayList<Conductor> conductores = new ArrayList<>();

    public Empresa(String rut, String direccion, ArrayList<String> redesSociales) {
        this.rut = rut;
        this.direccion = direccion;
        this.redesSociales = redesSociales;
    }

    public void agregarBus(Bus bus) {
        if (patenteExistente(bus.getPatente())) throw new IllegalArgumentException("Patente Existente");

        buses.add(bus);
    }

    private boolean patenteExistente(String patente) {
        return buses.stream().anyMatch(bus -> bus.getPatente().equals(patente));
    }

    public void agregarConductor(Conductor conductor) {
        if (conductorExistente(conductor)) throw new IllegalArgumentException("Conductor existente");

        conductores.add(conductor);
    }

    private boolean conductorExistente(Conductor conductor) {
        return conductores.stream()
                .anyMatch(conductor1 -> conductor1.getNombre().equals(conductor.getNombre()) &&
                        conductor1.getApellido().equals(conductor.getApellido()));
    }

    public void descontinuarBus(String patente) {
        int indice = buscarBusPorPatente(patente);
        if (indice == -1) throw new RuntimeException("No existe bus con esa patente");

        buses.remove(indice);
    }

    public int buscarBusPorPatente(String patente) {
        for (int i = 0; i < buses.size(); i++) {
            if (buses.get(i).getPatente().equals(patente)) {
                return i;
            }
        }
        return -1;
    }

    public void filtrarBuses(String ciudadDestino, String horaSalida, String horaLlegada) {
        throw new UnsupportedOperationException();
    }

    public int contarCantidadDeBuses() {
        return buses.size();
    }

    public int contarViajesPorDia(LocalDate fecha) {
        throw new UnsupportedOperationException();
    }

    public void asociarViaje(String patente, Viaje viaje) {
        int indice = buscarBusPorPatente(patente);
        if (indice == -1) throw new RuntimeException("No existe bus con esa patente");

        buses.get(indice).getViajes().add(viaje);
    }

    public ArrayList<Bus> getBuses() {
        return buses;
    }

    public ArrayList<Conductor> getConductores() {
        return conductores;
    }
}