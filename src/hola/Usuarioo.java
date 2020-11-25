import java.util.*;
import java.util.Scanner.*;
import java.io.*;


public class Usuarioo
{ 
    String nombre;
    int edad;
    String ganador;
    int barcosHundidos;

        public boolean pedirDatos()
        {
            Scanner lee=new Scanner (System.in);
            System.out.println("Hola y Bienvenido seas a Battleship");
            System.out.println("¿Cual es su nombre?");
            nombre=lee.nextLine();
            try{
            System.out.println("¿Cual es su edad?");
            edad=lee.nextInt();
            } catch(InputMismatchException e) {System.out.println("ERROR: no es un numero ENTERO");}

            if (edad>=18)
            {
                System.out.println("Que disfrutes el juego");
                return true;
            }
                else 
                {
                    System.out.println ("LO SENTIMOS, el juego solo es para personas mayores de 18 años.");
                    return false;
                }
        }
        
        public void guardaUsuario() throws IOException
        {
            String nombre;
            Scanner lee= new Scanner(System.in);
            System.out.println("Dame el nombre del archivo binario: ");
            nombre = lee.nextLine();
            
            DataOutputStream f = new DataOutputStream (new FileOutputStream(nombre));
            
            f.close();
        }
         
        //public void LeerArch () 
        //{
        //private String nombre="temporal.dat";
        //try{
         //   ObjectInputStream f =new ObjectInputStream(new FileInputStream(this.ruta_a));
        //}


        //}


        
        public static void main (String [] args)
        {
               
        }

}