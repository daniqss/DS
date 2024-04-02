package e1;

final class LimpiaYAprobada extends EstadoHabitacion {
    @Override
    public void serOcupada(Habitacion habitacion) {
        if (habitacion.getReservada()) {
            habitacion.setEstado(new Ocupada());
        }
        else throw new IllegalStateException("Habitación no reservada");
        habitacion.setEstado(new Ocupada());
    }

    @Override
    public void serLimpiada(Habitacion habitacion) {
        throw new IllegalStateException("Habitación ya limpia");
    }

    @Override
    public void serLiberada(Habitacion habitacion) { throw new IllegalStateException("Habitación no ocupada"); }

    @Override
    public void serAprobada(Habitacion habitacion) {
        throw new IllegalStateException("Habitación ya aprobada");
    }

    @Override
    public void serRevocada(Habitacion habitacion) { habitacion.setEstado(new Sucia()); }

    @Override
    public boolean estadoReservable(Habitacion habitacion) { return true; }

    @Override
    public String toString(Habitacion habitacion) { return "Aprobada por " + habitacion.getAprobadaPor(); }
}