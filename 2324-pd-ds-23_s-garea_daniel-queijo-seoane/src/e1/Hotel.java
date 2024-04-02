package e1;

import java.util.List;
import java.util.ArrayList;

public class Hotel {
    private final List<Habitacion> habitaciones;

    public Hotel() {
        habitaciones = new ArrayList<>();
    }

    public void anadirHabitacion(Supervisor supervisor) {
        Habitacion habitacion = supervisor.anadirHabitacion(habitaciones.size() + 1);
        habitaciones.add(habitacion);
    }

    private Habitacion buscarHabitacion(int numeroHabitacionDeseada) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumero() == numeroHabitacionDeseada) {
                return habitacion;
            }
        }
        throw new IllegalStateException("Habitación no encontrada");
    }

    public void reservarHabitacion (int numeroHabitacion, String huesped) {
        try {
            Habitacion habitacion = buscarHabitacion(numeroHabitacion);
            try { habitacion.serReservada(huesped); }
            catch (IllegalStateException e) {
                System.out.println(e.getMessage());
                throw e;
            }

        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void terminarReserva (int numeroHabitacion) {
        try {
            Habitacion habitacion = buscarHabitacion(numeroHabitacion);
            try {
                habitacion.serDesreservada();
                habitaciones.remove(habitacion);
            }
            catch (IllegalStateException e) {
                System.out.println(e.getMessage());
                throw e;
            }

        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void ocuparHabitacion (int numeroHabitacion) {
        try {
            Habitacion habitacion = buscarHabitacion(numeroHabitacion);
            try { habitacion.serOcupada(); }
            catch (IllegalStateException e) {
                System.out.println(e.getMessage());
                throw e;
            }

        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void limpiarHabitacion(int numeroHabitacion, Limpiador limpiador) {
        try {
            Habitacion habitacion = buscarHabitacion(numeroHabitacion);
            limpiador.limpiar(habitacion);

        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void liberarHabitacion(int numeroHabitacionDeseada) {
        try {
            Habitacion habitacion = buscarHabitacion(numeroHabitacionDeseada);
            try { habitacion.serLiberada(); }
            catch (IllegalStateException e) {
                System.out.println(e.getMessage());
                throw e;
            }

        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void aprobarHabitacion(int numeroHabitacionDeseada, Supervisor supervisor) {
        try {
            Habitacion habitacion = buscarHabitacion(numeroHabitacionDeseada);
            try { supervisor.aprobarLimpieza(habitacion); }
            catch (IllegalStateException e) {
                System.out.println(e.getMessage());
                throw e;
            }

        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void revocarHabitacion(int numeroHabitacionDeseada, Supervisor supervisor) {
        try {
            Habitacion habitacion = buscarHabitacion(numeroHabitacionDeseada);
            try { supervisor.revocarLimpieza(habitacion); }
            catch (IllegalStateException e) {
                System.out.println(e.getMessage());
                throw e;
            }

        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public ArrayList<Habitacion> obtenerHabitaciones(boolean reservada) {
        if (habitaciones.isEmpty()) {
            throw new IllegalStateException("No hay habitaciones");
        }

        ArrayList<Habitacion> habitaciones = new ArrayList<>();
        for (Habitacion habitacion : this.habitaciones) {
            if (habitacion.getReservada() == reservada) {
                habitaciones.add(habitacion);
            }

        }
        if (habitaciones.isEmpty()) {
            throw new IllegalStateException("No hay habitaciones");
        }
        return habitaciones;
    }

    public ArrayList<Habitacion> obtenerHabitaciones() {
        if (this.habitaciones.isEmpty()) {
            throw new IllegalStateException("No hay habitaciones");
        }

        return new ArrayList<>(this.habitaciones);
    }

    public ArrayList<Habitacion> obtenerHabitaciones(EstadoHabitacion estado) {
        if (habitaciones.isEmpty()) {
            throw new IllegalStateException("No hay habitaciones");
        }

        ArrayList<Habitacion> habitaciones = new ArrayList<>();
        for (Habitacion habitacion : this.habitaciones) {
            if (habitacion.getEstado().equals(estado)) {
                habitaciones.add(habitacion);
            }

        }
        return habitaciones;
    }

    public void listarHabitaciones() {
        if (habitaciones.isEmpty()) {
            System.out.println("No hay habitaciones");
            return;
        }

        System.out.println("************************");
        System.out.println("Hotel UDC Hills");
        System.out.println("************************");
        for (Habitacion habitacion : habitaciones) {
            habitacion.imprimirHabitacion();
        }
        System.out.println("************************\n");
    }
}
