import java.util.*;
import java.io.*;


public class crearArch {
    public static void main(String[] args) throws IOException{
        int x;
        int y;
        String nomarch;
        Scanner lee = new Scanner (System.in);

        
        System.out.println("\nDame el nombre del archivo serializado: ");
        nomarch = lee.nextLine();
        
        ObjectOutputStream f = new ObjectOutputStream (new FileOutputStream(nomarch));
        
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
