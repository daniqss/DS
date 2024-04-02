package e1;

public class Habitacion {
    private final int numero;
    private boolean reservada;

    private final String anadidaPor;
    private String reservadaPor;
    private String limpiadaPor;
    private String aprobadaPor;

    private EstadoHabitacion estado;


    public Habitacion (int numero, String anadidaPor) {
        this.numero = numero;
        this.anadidaPor = anadidaPor;
        this.reservada = false;
        this.reservadaPor = null;
        this.estado = new LimpiaYAprobada();
        this.limpiadaPor = null;
        this.aprobadaPor = anadidaPor;
    }

    public int getNumero() { return numero; }
    public boolean getReservada() { return reservada; }
    public EstadoHabitacion getEstado() { return estado; }
    public String getLimpiadaPor() { return limpiadaPor; }
    public String getAprobadaPor() { return aprobadaPor; }

    public void setEstado(EstadoHabitacion estado) { this.estado = estado; }
    public void setLimpiadaPor(String nombreLimpiador) { this.limpiadaPor = nombreLimpiador; }
    public void setAprobadaPor(String nombreSupervisor) { this.aprobadaPor = nombreSupervisor; }

    public void serReservada(String huesped) {
        if (!reservada) {
            if (estado.estadoReservable(this)) {
                reservada = true;
                reservadaPor = huesped;
            }
            else throw new IllegalStateException("Habitación no disponible para reserva");
        }
        else throw new IllegalStateException("Habitación ya reservada");

    }

    public void serOcupada() {
        try {
            estado.serOcupada(this);

        } catch (IllegalStateException e) {
            throw e;
        }
    }

    public void serDesreservada() {
        if (!reservada) {
            throw new IllegalStateException("Habitación no reservada");
        }
        reservada = false;
        reservadaPor = null;
    }

    public void serLimpiada(Limpiador limpiador) {
        try {
            estado.serLimpiada(this);
            setLimpiadaPor(limpiador.getNombre());

        } catch (IllegalStateException e) {
            throw e;
        }
    }

    public void serLiberada() {
        try {
            estado.serLiberada(this);
            setLimpiadaPor(null);

        } catch (IllegalStateException e) {
            throw e;
        }
    }

    public void serAprobada(Supervisor supervisor) {
        try {
            estado.serAprobada(this);
            setAprobadaPor(supervisor.getNombre());

        } catch (IllegalStateException e) {
            throw e;
        }

    }

    public void serRevocada (Supervisor supervisor) {
        try {
            estado.serRevocada(this);
            setAprobadaPor(null);

        } catch (IllegalStateException e) {
            throw e;
        }
    }

    public void imprimirHabitacion () {
        System.out.print("Habitacion no. " + numero + ": ");

        if (reservada) { System.out.print("Reservada por: " + reservadaPor + "."); }
        else { System.out.print("No reservada."); }

        System.out.println(" " + estado.toString(this));
    }
}





