/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package holamc1;

/**
 *
 * @author marti
 */
public class condicionales {
    
    public static void main(String[] args) {
        int edad = 15;
        boolean tieneBoleto = true;
        boolean vieneAfulto = false;
        
        if (tieneBoleto == false){
            System.out.println("No puede entrar no tiene boleto");
        }else{
            if(edad >= 18){
                //Si tiene boleto y es mayor de edad
                System.out.println("Puede entrar mayor de edad");
            }else{
                if(vieneAfulto == true){
                    //Si tiene boleto, es menor pero viene con adulto
                    System.out.println("Puede entrar, menor con adulto");
                }else{
                    System.out.println("No puede entrar, es menor sin adulto");
                }
            }
        }
    }
    
    
}
