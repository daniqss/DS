package e1;

final class Ocupada extends EstadoHabitacion {
    public void serOcupada(Habitacion habitacion) { throw new IllegalStateException("Habitación ya está ocuparse"); }

    @Override
    public void serLimpiada(Habitacion habitacion) {
        throw new IllegalStateException("Habitación ocupada");
    }

    @Override
    public void serLiberada(Habitacion habitacion) { habitacion.setEstado(new Sucia()); }

    @Override
    public void serAprobada(Habitacion habitacion) {
        throw new IllegalStateException("Habitación ocupada");
    }

    @Override
    public void serRevocada(Habitacion habitacion) { throw new IllegalStateException("Habitación ocupada"); }


    @Override
    public String toString(Habitacion habitacion) {
        return "Ocupada";
    }
}
