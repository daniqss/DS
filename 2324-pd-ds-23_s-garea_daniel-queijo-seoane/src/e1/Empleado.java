package e1;

abstract class Empleado {
    private final String nombre;

    public Empleado(String nombre) { this.nombre = nombre; }

    String getNombre() { return nombre; }

}

