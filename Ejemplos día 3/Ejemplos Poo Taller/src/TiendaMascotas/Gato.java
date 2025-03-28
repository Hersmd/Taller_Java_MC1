package TiendaMascotas;

public class Gato extends Animal {
    private final boolean tienePeloLargo;

    public Gato(String nombre, int edad, double precio, boolean tienePeloLargo) {
        super(nombre, edad, precio, "Gato");
        this.tienePeloLargo = tienePeloLargo;
    }

    @Override
    public String emitirSonido() {
        return "�Miau!";
    }

    public String ara�ar() {
        return getNombre() + " est� ara�ando el sof�.";
    }

    // Getter espec�fico
    public boolean isTienePeloLargo() {
        return tienePeloLargo;
    }
}