package EjemploPooSimple;

// La clase Espada representa el "molde" o plantilla para crear objetos de tipo espada
// En POO, una clase define las características y comportamientos que tendrán sus objetos
class Espada {
    // ATRIBUTOS (características de la espada)
    // Estos son los datos que guardará cada objeto espada
    private String material;  // Qué material está hecha (ej: madera, hierro)
    private int daño;        // Cuánto daño causa al atacar
    private int durabilidad;  // Cuántos usos resiste antes de romperse

    // CONSTRUCTOR - Método especial que se usa al crear un nuevo objeto Espada
    // Sirve para inicializar los atributos del objeto
    public Espada(String material, int daño, int durabilidad) {
        // this.material se refiere al atributo de la clase
        // material (sin this) es el parámetro que recibimos
        this.material = material;      // Asignamos el material recibido
        this.daño = daño;             // Asignamos el daño recibido
        this.durabilidad = durabilidad; // Asignamos la durabilidad recibida
    }

    // MÉTODOS (acciones que puede realizar la espada)
    
    // Muestra la información de la espada
    public void mostrarInfo() {
        System.out.println("Espada de " + material);
        System.out.println("Daño: " + daño);
        System.out.println("Durabilidad: " + durabilidad);
    }
    
    // Simula un ataque con la espada
    public void atacar() {
        durabilidad--;  // Cada ataque reduce la durabilidad en 1
        System.out.println("La espada atacó, durabilidad tras el ataque: " + durabilidad);
    }
}