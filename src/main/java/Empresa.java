import java.util.ArrayList;

public class Empresa {
    private final String rut;
    private final String direccion;
    private final ArrayList<String> redesSociales;
    private ArrayList<Bus> buses = new ArrayList<>();
    private ArrayList<Conductor> conductores = new ArrayList<>();

    public Empresa(String rut, String direccion, ArrayList<String> redesSociales) {
        this.rut = rut;
        this.direccion = direccion;
        this.redesSociales = redesSociales;
    }

    public void agregarBus(Bus bus) {
        buses.add(bus);
    }

    public void agregarConductor(Conductor conductor) {
        conductores.add(conductor);
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
        throw new UnsupportedOperationException();
    }

    public int contarViajesPorDia(String fecha) {
        throw new UnsupportedOperationException();
    }

    public void asociarViaje() {
        throw new UnsupportedOperationException();
    }
}