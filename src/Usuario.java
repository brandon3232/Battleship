import java.util.Scanner.*;
import java.io.*;
impor java.swing.JOptionPane;


public class Usuario
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
        
        public void guardaUsuario(int barcosHundidos, boolean persona) throws IOException
        {
            
            DataOutputStream f = new DataOutputStream (new FileOutputStream(nombre, true));
            do {
               nombre

            }

            //            f.writeInt(l);
            //            f.writeInt(c);

            //se tiene que guardar los datos:
            //nombre
            //edad
            //si ganó o perdiò
            //numero de barcos hundidos
            f.close();
        }
         
        public void LeerArch () 
        {
            File archivo = new File ("archivo");
            FileReader f = new FileReader (archivo);
            BufferedReader b = new BufferedReader(f);

            String linea = b.readLine();
            File archivo = null;
            FileReader fr = null;
            BufferedReader br = null;

            try {
               
                archivo = new File ("archivo.txt");
                f = new FileReader (archivo);
                b = new BufferedReader(f);
                String linea;
                   while((linea=b.readLine())!=null)
                   System.out.println(linea);
            }
            catch(Exception e){
                e.printStackTrace();
             }finally{
                try{                    
                   if( null != f ){   
                      f.close();     
                   }                  
                }catch (Exception e2){ 
                   e2.printStackTrace();
                }
             }
          }
       }

        


        
        public static void main (String [] args)
        {
               
        }

