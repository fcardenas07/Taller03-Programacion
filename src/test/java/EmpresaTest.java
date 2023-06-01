import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EmpresaTest {
    private Empresa empresa;

    @BeforeEach
    void setUp() {
        empresa = new Empresa("1234567-1", "direccion", new ArrayList<>());

        empresa.agregarBus(new Bus("AABB12", "Mercedes", "X123"));
        empresa.agregarBus(new Bus("AABB13", "Mercedes", "X123"));
        empresa.agregarBus(new Bus("AABB14", "Mercedes", "X123"));
        empresa.agregarBus(new Bus("AABB15", "Mercedes", "X123"));

        empresa.agregarConductor(new Conductor("Juan", "Perez", 1231231231, Licencia.A1));
        empresa.agregarConductor(new Conductor("Jon", "Perez", 1231231232, Licencia.A1));

        empresa.asociarViaje("AABB12",
                new Viaje("Temuco", "Traiguen", LocalTime.of(20, 0),
                        LocalTime.of(21, 0),
                        new ArrayList<>(),
                        LocalDate.of(2023, 8, 1) ));

        empresa.asociarViaje("AABB13",
                new Viaje("Temuco", "Traiguen", LocalTime.of(10, 0),
                        LocalTime.of(22, 0),
                        new ArrayList<>(),
                        LocalDate.of(2023, 8, 1) ));
    }

    @Test
    void debeAgregarBus_cuandoLaPatenteNoSeRepite() {
        empresa.agregarBus(new Bus("AABB16", "Mercedes", "X123"));

        int size = empresa.contarCantidadDeBuses();
        assertEquals(5, size);
    }

    @Test
    void debeArrojarExcepcion_cuandoLaPatenteSeRepite() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> empresa.agregarBus(new Bus("AABB15", "Mercedes", "X123")));

        assertEquals("Patente Existente", exception.getMessage());
    }

    @Test
    void debeAgregarConductor_cuandoLaPatenteNoSeRepite() {
        empresa.agregarConductor(new Conductor("Pedro", "Perez", 1231231231, Licencia.A1));

        int size = empresa.getConductores().size();
        assertEquals(3, size);
    }

    @Test
    void debeArrojarExcepcion_cuandoSeRepiteConductor() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> empresa.agregarConductor(new Conductor("Jon", "Perez", 1231231232, Licencia.A1)));

        assertEquals("Conductor existente", exception.getMessage());
    }

    @Test
    void descontinuarBus() {
        empresa.descontinuarBus("AABB15");

        int buses = empresa.contarCantidadDeBuses();

        assertEquals(3, buses);
    }
    

    @Test
    void asociarViaje() {
        String patente = "AABB15";

        Viaje viaje =  new Viaje("Temuco",
                "Pucon",
                LocalTime.of(20, 0),
                LocalTime.of(21, 0),
                new ArrayList<>(),
                LocalDate.of(2023, 8, 1));
        empresa.asociarViaje(patente, viaje);

        int size = empresa.getBuses().get(3).getViajes().size();

        assertEquals(1, size);
    }


    @Test
    void filtrarBuses() {
        ArrayList<Bus> buses = empresa.filtrarBuses("Traiguen", LocalTime.of(9, 0), LocalTime.of(23, 0));

        int size = buses.size();

        assertEquals(2, size);
    }
}