// Declaración del paquete al que pertenece la clase
package TiendaMascotas;

/**
 * Clase abstracta Animal que representa las características y comportamientos
 * básicos de un animal en el sistema de la tienda de mascotas.
 * 
 * Al ser abstracta, no puede ser instanciada directamente, solo sirve como
 * base para otras clases concretas (como Perro, Gato, Ave).
 */
public abstract class Animal {
    // ==============================================
    // ATRIBUTOS ENCAPSULADOS (private)
    // ==============================================
    
    private String nombre;    // Nombre del animal (ej: "Rex")
    private int edad;        // Edad en años (ej: 3)
    private double precio;   // Precio en dólares (ej: 150.50)
    private String especie;  // Tipo de animal (ej: "Perro")

    // ==============================================
    // CONSTRUCTOR
    // ==============================================
    public Animal(String nombre, int edad, double precio, String especie) {
        this.nombre = nombre;    // Asigna el nombre recibido al atributo
        this.edad = edad;        // Asigna la edad recibida al atributo
        this.precio = precio;    // Asigna el precio recibido al atributo
        this.especie = especie;  // Asigna la especie recibida al atributo
    }
    
    // ==============================================
    // GETTERS (ENCAPSULAMIENTO)
    // ==============================================
    //supongamos que ya creamos una instancia, con identificador perro 1
    //perro1.nombre; para acceder si fuera publico
    //perro1.getNombre(); para acceder siendo privado
    public String getNombre() {
        //Aquí podemos poner codigo, como por ejemplo para darle algún formato al nombre, por ejemplo en minusculas
        //String nombre_formato = this.nombre.toLowerCase()
        return this.nombre; 
    }

    public int getEdad() {
        return edad;
    }

    public double getPrecio() {
        return precio;
    }

    public String getEspecie() {
        return especie;
    }
    
    // ==============================================
    // MÉTODOS DE COMPORTAMIENTO
    // ==============================================
    
    /**
     * Método abstracto que debe ser implementado por las subclases.
     * Cada animal hará un sonido diferente.
     */
    public abstract String emitirSonido();

    /**
     * Método concreto que representa la acción de comer.
     * No es abastracto porque simplemente va a mostrar un mensaje de que está comiendo concentrado
     * Pero lo podríamos hacer abstracto si quisieramos que cada clase coma algo en específico, por ejemplo: un hueso, un ratón, semillas...
     */
    public void comer() {
        System.out.println(this.nombre + " está comiendo concentrado.");
    }
    
}