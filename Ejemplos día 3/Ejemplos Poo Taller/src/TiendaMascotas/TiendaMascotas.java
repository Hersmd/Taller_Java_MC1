package TiendaMascotas;

import java.util.ArrayList; // Importación para usar ArrayList

/**
 * Clase TiendaMascotas que gestiona el inventario de animales y las ventas.
 */
public class TiendaMascotas {
    // ==================== ATRIBUTOS ====================
    private ArrayList<Animal> listaAnimales; // Lista para almacenar los animales en inventario
    private double ganancias; // Acumulador de las ganancias por ventas

    // ==================== CONSTRUCTOR ====================
    /**
     * Constructor que inicializa una tienda vacía:
     */
    public TiendaMascotas() {
        this.listaAnimales = new ArrayList<>(); // Inicializa la lista vacía
        this.ganancias = 0; // Inicializa ganancias en cero
    }

    // ==================== MÉTODOS PRINCIPALES ====================

    /**
     * Agrega un animal al inventario de la tienda
     * @param animal Objeto Animal (Perro, Gato o Ave) a agregar
     */
    public void agregarAnimal(Animal animal) {
        listaAnimales.add(animal); // Añade el animal a la lista
        System.out.println(animal.getNombre() + " (" + animal.getEspecie() + ") añadido al inventario.");
    }

    /**
     * Vende un animal por su nombre y actualiza las ganancias
     * @param nombre Nombre del animal a vender
     */
    public void venderAnimal(String nombre) {
        for (Animal animal : listaAnimales) {
            if (animal.getNombre().equals(nombre)) {
                listaAnimales.remove(animal); // Elimina de la lista
                ganancias += animal.getPrecio(); // Suma el precio a ganancias
                System.out.println(nombre + " vendido por $" + animal.getPrecio());
                return; // Termina el método después de encontrar y vender
            }
        }
        System.out.println("Error: " + nombre + " no encontrado en el inventario.");
    }

    /**
     * Muestra el inventario actual de animales con sus detalles
     * Formato: Nombre | Especie | Precio
     */
    public void mostrarInventario() {
        if (listaAnimales.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            System.out.println("\n--- Inventario ---");
            for (Animal animal : listaAnimales) {
                System.out.println(animal.getNombre() + " | " + animal.getEspecie() + " | $" + animal.getPrecio());
            }
        }
    }

    // ==================== GETTERS ====================

    /**
     * @return Ganancias acumuladas por ventas
     */
    public double getGanancias() {
        return ganancias;
    }

    /**
     * @return Lista completa de animales en inventario
     */
    public ArrayList<Animal> getListaAnimales() {
        return listaAnimales;
    }
}