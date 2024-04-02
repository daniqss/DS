package e1;

public class Supervisor extends Empleado {
    public Supervisor(String nombre) { super(nombre); }

    public void aprobarLimpieza(Habitacion habitacion) {
        habitacion.serAprobada(this);
    }

    public void revocarLimpieza(Habitacion habitacion) {
        try {habitacion.serRevocada(this); }
        catch (IllegalStateException e) { throw e; }
    }

    public Habitacion anadirHabitacion(int numero) {
        return new Habitacion(numero, getNombre());
    }
}
