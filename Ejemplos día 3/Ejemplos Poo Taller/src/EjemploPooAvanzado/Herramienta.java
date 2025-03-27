// Definición del paquete donde se encuentra la clase
package EjemploPooAvanzado;

/**
 * Clase abstracta 'Herramienta' que actúa como superclase (clase base).
 * Las clases abstractas no se pueden instanciar directamente, solo sirven como plantilla
 * para otras clases hijas que heredarán sus atributos y métodos.
 */
abstract class Herramienta {
    // ATRIBUTOS (protegidos para que las subclases puedan acceder)
    protected String material;   // Material de la herramienta (ej: "Madera", "Hierro")
    protected int durabilidad;  // Puntos de durabilidad restantes

    /**
     * Constructor de la clase Herramienta.
     * @param material Tipo de material de la herramienta.
     * @param durabilidad Puntos iniciales de durabilidad.
     */
    public Herramienta(String material, int durabilidad) {
        this.material = material;      // Asigna el material recibido
        this.durabilidad = durabilidad; // Asigna la durabilidad recibida
    }

    /**
     * MÉTODO ABSTRACTO (sin implementación aquí).
     * Cada subclase DEBE implementar su propia versión de 'usar()'.
     * Esto permite POLIMORFISMO: diferentes herramientas tendrán comportamientos distintos.
     */
    public abstract void usar();

    /**
     * Muestra información básica de la herramienta.
     * Método concreto (ya implementado) que heredarán todas las subclases.
     */
    public void mostrarInfo() {
        System.out.println("Material: " + material);
        System.out.println("Durabilidad: " + durabilidad);
    }

    /**
     * Verifica si la herramienta está rota (durabilidad <= 0).
     * @return true si está rota, false si aún es usable.
     */
    public boolean estaRota() {
        return durabilidad <= 0;  // Retorna true si no tiene durabilidad
    }
    
    public int getDurabilidad(){
        return this.durabilidad;
    }
}