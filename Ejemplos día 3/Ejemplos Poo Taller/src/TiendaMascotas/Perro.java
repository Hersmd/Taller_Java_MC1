package TiendaMascotas;

// La clase Perro hereda de Animal (extiende sus atributos y métodos)
public class Perro extends Animal {
    
    // Atributo PRIVADO exclusivo de Perro (encapsulamiento)
    private String raza;

    // Constructor de la clase Perro
    public Perro(String nombre, int edad, double precio, String raza) {
        // super() llama al constructor de la clase padre (Animal)
        // "Perro" se pasa como especie fija para todos los objetos Perro
        super(nombre, edad, precio, "Perro");
        
        // this.raza asigna el valor del parámetro al atributo de la clase
        this.raza = raza;
    }

    // Sobrescribe el método abstracto emitirSonido() de Animal
    @Override  // Indica que estamos redefiniendo un método del padre
    public String emitirSonido() {
        return "¡Guau!";  // Sonido específico de los perros
    }

    // Método EXCLUSIVO de Perro (no existe en Animal)
    public String traerPelota() {
        // getNombre() es heredado de la clase Animal
        return getNombre() + " trajo la pelota.";
    }

    // Getter para el atributo raza (parte del encapsulamiento)
    public String getRaza() {
        return raza;  // Permite leer el valor desde fuera de la clase
    }
}