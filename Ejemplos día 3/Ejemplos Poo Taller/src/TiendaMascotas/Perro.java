package TiendaMascotas;

// La clase Perro hereda de Animal (extiende sus atributos y m�todos)
public class Perro extends Animal {
    
    // Atributo PRIVADO exclusivo de Perro (encapsulamiento)
    private String raza;

    // Constructor de la clase Perro
    public Perro(String nombre, int edad, double precio, String raza) {
        // super() llama al constructor de la clase padre (Animal)
        // "Perro" se pasa como especie fija para todos los objetos Perro
        super(nombre, edad, precio, "Perro");
        
        // this.raza asigna el valor del par�metro al atributo de la clase
        this.raza = raza;
    }

    // Sobrescribe el m�todo abstracto emitirSonido() de Animal
    @Override  // Indica que estamos redefiniendo un m�todo del padre
    public String emitirSonido() {
        return "�Guau!";  // Sonido espec�fico de los perros
    }

    // M�todo EXCLUSIVO de Perro (no existe en Animal)
    public String traerPelota() {
        // getNombre() es heredado de la clase Animal
        return getNombre() + " trajo la pelota.";
    }

    // Getter para el atributo raza (parte del encapsulamiento)
    public String getRaza() {
        return raza;  // Permite leer el valor desde fuera de la clase
    }
}