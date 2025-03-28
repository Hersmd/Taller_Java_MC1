package TiendaMascotas;

// Importaciones necesarias para usar List y ArrayList
import java.util.ArrayList;

/**
 * Clase que representa a un cliente de la tienda de mascotas.
 * Permite comprar mascotas y gestionar su lista de animales adquiridos.
 */
public class Cliente {
    // ==================== ATRIBUTOS ====================
    private String nombre;           // Nombre del cliente (ej: "Juan")
    private double presupuesto;      // Dinero disponible para comprar (ej: 200.0)
    private ArrayList<Animal> mascotas; // Lista de mascotas compradas

    // ==================== CONSTRUCTOR ====================
    /**
     * Constructor para crear un nuevo cliente.
     * @param nombre Nombre del cliente
     * @param presupuesto Cantidad de dinero inicial
     */
    public Cliente(String nombre, double presupuesto) {
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.mascotas = new ArrayList<>(); // Inicializa lista vacía
    }

    // ==================== MÉTODOS PRINCIPALES ====================

    /**
     * Intenta comprar una mascota de la tienda por su nombre.
     * @param tienda Referencia a la tienda de mascotas
     * @param nombreMascota Nombre del animal a comprar
     */
    public void comprarMascota(TiendaMascotas tienda, String nombreMascota) {
        // Recorre la lista de animales disponibles en la tienda
        for (Animal animal : tienda.getListaAnimales()) {
            // Verifica si el nombre coincide y hay presupuesto suficiente
            if (animal.getNombre().equals(nombreMascota) && animal.getPrecio() <= presupuesto) {
                if (animal.getPrecio() <= presupuesto) {
                    // Proceso de compra:
                    tienda.venderAnimal(nombreMascota); // Elimina de la tienda
                    mascotas.add(animal);               // Añade a la lista del cliente
                    presupuesto -= animal.getPrecio();  // Reduce el presupuesto
                    
                    System.out.println(nombre + " compró a " + nombreMascota + 
                                      ". Presupuesto restante: $" + presupuesto);
                    return; // Termina el método después de la compra exitosa
                } else {
                    System.out.println("Error: Presupuesto insuficiente para " + nombreMascota);
                    return;
                }
            }
        }
        // Si no encontró la mascota:
        System.out.println("Error: No se pudo comprar " + nombreMascota + 
                         " (¿no existe o falta presupuesto?)");
    }

    /**
     * Muestra la lista de mascotas adquiridas por el cliente.
     * Formato: Nombre | Especie
     */
    public void mostrarMascotas() {
        if (mascotas.isEmpty()) {
            System.out.println(nombre + " no tiene mascotas.");
        } else {
            System.out.println("\n--- Mascotas de " + nombre + " ---");
            for (Animal mascota : mascotas) {
                System.out.println(mascota.getNombre() + " | " + mascota.getEspecie());
            }
        }
    }

    // ==================== GETTERS (Opcionales) ====================
    // (Podrían añadirse para acceder a los atributos privados)
    public String getNombre() {
        return nombre;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public ArrayList<Animal> getMascotas() {
        return mascotas;
    }
}