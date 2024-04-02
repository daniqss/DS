package e1;

final class Sucia extends EstadoHabitacion {
    @Override
    public void serOcupada(Habitacion habitacion) { throw new IllegalStateException("Habitación no puede ocuparse"); }

    @Override
    public void serLimpiada(Habitacion habitacion) {
        habitacion.setEstado(new LimpiaYPendiente());
    }

    @Override
    public void serLiberada(Habitacion habitacion) { throw new IllegalStateException("Habitación no ocupada"); }

    @Override
    public void serAprobada(Habitacion habitacion) {
        throw new IllegalStateException("Habitación no limpia");
    }

    @Override
    public void serRevocada(Habitacion habitacion) { throw new IllegalStateException("Habitación no limpia"); }

    @Override
    public String toString(Habitacion habitacion) {
        return "Pendiente de limpieza";
    }
}
