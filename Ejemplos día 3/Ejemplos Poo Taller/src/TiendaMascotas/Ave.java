
package TiendaMascotas;

public class Ave extends Animal {
    private boolean puedeVolar;

    public Ave(String nombre, int edad, double precio, boolean puedeVolar) {
        super(nombre, edad, precio, "Ave");
        this.puedeVolar = puedeVolar;
    }

    @Override
    public String emitirSonido() {
        return "Pio, pio";
    }

    public String volar() {
        return puedeVolar ? 
            getNombre() + " est· volando." : 
            getNombre() + " no puede volar.";
    }

    // Getter espec√≠fico
    public boolean isPuedeVolar() {
        return puedeVolar;
    }
}
