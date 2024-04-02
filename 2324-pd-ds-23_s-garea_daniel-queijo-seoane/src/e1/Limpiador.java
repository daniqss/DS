package e1;

public class Limpiador extends Empleado {
    public Limpiador(String nombre) {
        super(nombre);
    }

    public void limpiar(Habitacion habitacion) {
        habitacion.serLimpiada(this);
    }
}
