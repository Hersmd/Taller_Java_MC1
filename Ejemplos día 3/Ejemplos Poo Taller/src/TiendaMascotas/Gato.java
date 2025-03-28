package TiendaMascotas;

public class Gato extends Animal {
    private final boolean tienePeloLargo;

    public Gato(String nombre, int edad, double precio, boolean tienePeloLargo) {
        super(nombre, edad, precio, "Gato");
        this.tienePeloLargo = tienePeloLargo;
    }

    @Override
    public String emitirSonido() {
        return "¡Miau!";
    }

    public String arañar() {
        return getNombre() + " está arañando el sofá.";
    }

    // Getter específico
    public boolean isTienePeloLargo() {
        return tienePeloLargo;
    }
}