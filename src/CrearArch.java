import java.util.*;
import java.io.*;


public class CrearArch {


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
            //flota[i]= new Barco(x,y);
            f.writeObject (new Barco(x,y));
            System.out.println("Barco "+i+" se ha guardado en el archivo...");
        }

        /*for (int i = 0; i < flota.length; i++) {
            
            System.out.println(i+"barco x =" + flota[i].getX());
            System.out.println(i+"barco y =" + flota[i].getY());
            System.out.println(i+"barco vivo =" + flota[i].getVivo());
            for (int j = 0; j < 3; j++) {
                System.out.println(i+"barco-seccion" + i + " " + flota[i].secciones[j].getCoordenadaX());
                System.out.println(i+"barco- seccion" + i + " " + flota[i].secciones[j].getCoordenadaY());
                System.out.println(i+"barco - seccion" + i + " " + flota[i].secciones[j].getFuncional());
            }
        }*/




        f.close();
    }
    
}
