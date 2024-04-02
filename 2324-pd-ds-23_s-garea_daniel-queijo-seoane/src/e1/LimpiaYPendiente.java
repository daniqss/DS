package e1;

final class LimpiaYPendiente extends EstadoHabitacion {
    @Override
    public void serOcupada(Habitacion habitacion) {
        throw new IllegalStateException("Habitación no puede ocuparse");
    }

    @Override
    public void serLimpiada(Habitacion habitacion) {
        throw new IllegalStateException("Habitación ya limpia");
    }

    @Override
    public void serLiberada(Habitacion habitacion) { throw new IllegalStateException("Habitación no ocupada"); }

    @Override
    public void serAprobada(Habitacion habitacion) {
        habitacion.setEstado(new LimpiaYAprobada());
    }

    @Override
    public void serRevocada(Habitacion habitacion) { throw new IllegalStateException("Habitación no aprobada"); }


    @Override
    public String toString(Habitacion habitacion) {
        return "Limpiada por " + habitacion.getLimpiadaPor() + " y pendiente de aprobación";
    }
}
