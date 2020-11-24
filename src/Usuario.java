import java.lang.*;
import java.util.*;
import java.util.Scanner.*;


public class Usuario { 

    public static void main (String args [])
    {
        Scanner lee=new Scanner (System.in);
        String nombre;
        int edad;
        System.out.println("Hola y Bienvenido seas a Battleship");
        System.out.println("¿Cual es su nombre?");
        nombre=lee.nextLine();
        System.out.println("¿Cual es su edad?");
        edad=lee.nextInt();

        if (edad>=18)
        {
            System.out.println("Que disfrutes el juego");
        }
            else 
            {
                System.out.println ("LO SENTIMOS, el juego solo es para personas mayores de 18 años");
            }
    }
}
