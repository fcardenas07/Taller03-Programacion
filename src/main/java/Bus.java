import java.util.ArrayList;

public class Bus {
    private final String patente;
    private final String marca;
    private final String modelo;
    private final ArrayList<Viaje> viajes = new ArrayList<Viaje>();
    private Conductor conductor;

    public Bus(String patente, String marca, String modelo) {
        validarPrametros(patente, marca, modelo);

        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getPatente() {
        return patente;
    }

    private void validarPrametros(String patente, String marca, String modelo) {
        if (patente == null || patente.length() < 6) {
            throw new IllegalArgumentException("Patente no valida");
        }

        if (marca == null || marca.isBlank()) {
            throw new IllegalArgumentException("Marca no valida");
        }

        if (modelo == null || modelo.isBlank()) {
            throw new IllegalArgumentException("Modelo no valida");
        }
    }

    public ArrayList<Viaje> getViajes() {
        return viajes;
    }

    public void asociarConductor(Conductor conductor) {
        this.conductor = conductor;
    }
}