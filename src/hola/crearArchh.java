import java.util.*;
import java.io.*;


public class crearArchh {
    public static void main(String[] args) throws IOException{
        int x;
        int y;
        String nomarch;
        Scanner lee = new Scanner (System.in);
        

        
        System.out.println("\nDame el nombre del archivo serializado: ");
        nomarch = lee.nextLine();
        ObjectOutputStream f = new ObjectOutputStream (new FileOutputStream(nomarch));
        
        for(int i = 0; i < 10; i++){
            System.out.println("\nBARCO "+i+":");
            System.out.println("coordenada X: ");
            x = lee.nextInt();
            System.out.println("Coordenada Y: ");
            y = lee.nextInt();
            f.writeObject (new Barco(x,y));
            System.out.println("Barco "+i+" se ha guardado en el archivo...");
        }
        f.close();
    }  
        
    
}//public void guardaUsuario() throws IOException
        //{
            //String nombre;
            //Scanner lee= new Scanner(System.in);
            //System.out.println("Dame el nombre del archivo binario: ");
            //nombre = lee.nextLine();
            
            //DataOutputStream f = new DataOutputStream (new FileOutputStream(nombre));
            
            //f.close();
        //}
