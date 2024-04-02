package e1;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HotelTest {

    @Test
    public void hotelTest() {
        Hotel hotel = new Hotel();
        ArrayList<Habitacion> habitaciones;
        Supervisor supervisor = new Supervisor("Juan");
        assertEquals(supervisor.getNombre(), "Juan");
        Limpiador limpiador = new Limpiador("Pedro");
        assertEquals(limpiador.getNombre(), "Pedro");

        hotel.anadirHabitacion(supervisor);
        hotel.anadirHabitacion(supervisor);
        habitaciones = hotel.obtenerHabitaciones();
        assertThrows(IllegalStateException.class, () -> hotel.terminarReserva(1));
        assertThrows(IllegalStateException.class, () ->
                hotel.reservarHabitacion(3, "Manolo Lama")
        );
        Habitacion habitacion = hotel.obtenerHabitaciones(false).get(0);
        assertFalse(habitacion.getReservada());
        Habitacion habitacion1 = hotel.obtenerHabitaciones().get(0);
        assertTrue(habitacion1.getEstado().estadoReservable(habitacion1));
        hotel.listarHabitaciones();
        // NO RESERVADA, LIMPIA Y PENDIENTE

        hotel.reservarHabitacion(1, "Pepe Viyuela");
        hotel.reservarHabitacion(2, "Carmen Machi");
        hotel.listarHabitaciones();
        assertThrows(IllegalStateException.class, () -> hotel.limpiarHabitacion(1, limpiador));
        assertThrows(IllegalStateException.class, () -> hotel.aprobarHabitacion(1, supervisor));
        assertThrows(IllegalStateException.class, () -> hotel.liberarHabitacion(1));
        hotel.terminarReserva(1);
        hotel.ocuparHabitacion(2);
        Habitacion habitacion2 = hotel.obtenerHabitaciones().get(0);
        assertFalse(habitacion2.getEstado().estadoReservable(habitacion2));
        Throwable e = assertThrows(IllegalStateException.class, () -> hotel.ocuparHabitacion(2));
        assertEquals(e.getMessage(), "Habitación ya está ocuparse");
        assertThrows(IllegalStateException.class, () -> hotel.limpiarHabitacion(2, limpiador));
        assertThrows(IllegalStateException.class, () -> hotel.aprobarHabitacion(2, supervisor));
        assertThrows(IllegalStateException.class, () -> hotel.revocarHabitacion(2, supervisor));
        assertThrows(IllegalStateException.class, () -> hotel.ocuparHabitacion(2));
        hotel.listarHabitaciones();
        // RESERVADA, OCUPADA

        hotel.liberarHabitacion(2);
        assertThrows(IllegalStateException.class, () -> hotel.ocuparHabitacion(2));
        assertThrows(IllegalStateException.class, () -> hotel.liberarHabitacion(2));
        assertThrows(IllegalStateException.class, () -> hotel.aprobarHabitacion(2, supervisor));
        assertThrows(IllegalStateException.class, () -> hotel.revocarHabitacion(2, supervisor));
        hotel.listarHabitaciones();
        // RESERVADA, SUCIA

        hotel.limpiarHabitacion(2, limpiador);
        hotel.aprobarHabitacion(2, supervisor);
        habitaciones = hotel.obtenerHabitaciones(new LimpiaYAprobada());

        hotel.revocarHabitacion(2, supervisor);
        hotel.limpiarHabitacion(2, limpiador);
        hotel.listarHabitaciones();
        assertThrows(IllegalStateException.class, () -> hotel.ocuparHabitacion(2));
        assertThrows(IllegalStateException.class, () -> hotel.limpiarHabitacion(2, limpiador));
        assertThrows(IllegalStateException.class, () -> hotel.liberarHabitacion(2));
        assertThrows(IllegalStateException.class, () -> hotel.revocarHabitacion(2, supervisor));
        // RESERVADA, LIMPIA Y PENDIENTE

        hotel.aprobarHabitacion(2, supervisor);
        habitaciones = hotel.obtenerHabitaciones();

        hotel.terminarReserva(2);
        hotel.listarHabitaciones();
        assertThrows(IllegalStateException.class, hotel::obtenerHabitaciones);






    }
}
