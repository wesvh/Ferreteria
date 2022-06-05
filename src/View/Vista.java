/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Vista {

    private Scanner leer;
    private Scanner numerar;

    public Vista() {
        leer = new Scanner(System.in);
    }

    public String leerDatoString(String mensaje) {
        System.out.println(mensaje);
        String dato = leer.nextLine();
        return dato;
    }
    
     public int leerDatoInt(String mensaje) {
        System.out.println(mensaje);
        int dato = numerar.nextInt();
        return dato;
    }
}
