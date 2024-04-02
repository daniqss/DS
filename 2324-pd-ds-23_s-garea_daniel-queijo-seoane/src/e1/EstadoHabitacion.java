package e1;

public abstract sealed class EstadoHabitacion permits LimpiaYAprobada, LimpiaYPendiente, Sucia, Ocupada {
    public abstract void serOcupada(Habitacion habitacion);
    public abstract void serLimpiada(Habitacion habitacion);
    public abstract void serLiberada(Habitacion habitacion);
    public abstract void serAprobada(Habitacion habitacion);
    public abstract void serRevocada(Habitacion habitacion);

    public abstract String toString(Habitacion habitacion);

    public boolean estadoReservable(Habitacion habitacion) { return false; }
    public boolean equals(EstadoHabitacion estado) { return this.getClass().equals(estado.getClass()); }
}
