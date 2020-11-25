import java.util.Scanner;
import java.io.*;

public class Battleship {

    public static int menu(){
        int desicion;
        Scanner scanner = new Scanner (System.in);
        
          System.out.println("-------------BATTLESHIP----------");
          System.out.println("---------------MENU--------------");
          System.out.println("¿Que desea hacer?");
          System.out.println("1. Jugar");
          System.out.println("2. Ver puntajes");
          System.out.println("3. Salir");
          desicion = scanner.nextInt(); 

     return desicion;
    }
    

    public static void main(String args []) throws IOException{
        Scanner scanner = new Scanner (System.in);
        int tiroX, tiroY, numTiros=10,numBarcosHundidos=0;
        int d=0;
        Tablero t;
        boolean usuario;
          
        d = menu();
        switch (d){
            case 1:
                //int n = (int) (Math.random() * (5 - 1)) + 1;
                //switch (n) {
                // case 1:
                     t = new Tablero("flota1"); 
                //      break;
                //    case 2:
                //       t = new Tablero("flota2");
                //        break;
                //    case 3:
                //       t = new Tablero("flota3");
                //     break;
                //    case 4:
                //      t = new Tablero("flota4");
                //       break;
                //}
            
                //usuario= Usuario.pideDatos();
                //if (!usuario){
                // System.out.println("Tienes que ser mayor de edad para poder jugar ..!!!!")
                // System.exit(0);
                //}
           
                do{
                    System.out.println("Seleccione la linea en la que desea tirar:");
                    tiroX = scanner.nextInt();
                    System.out.println("Seleccione la columna en la que desea tirar:");
                    tiroY = scanner.nextInt();//TODO:poner try-catch por si mete algo que no sea numero y crear excepcion
                    //por si introduce una coordenada fuera de rango

                    for(int clear = 0; clear < 1000; clear++) 
                    { 
                    System.out.println("\b") ; 
                    } 
                 switch (t.checaCasilla(tiroX, tiroY)) {
                     case 1,2:
                            System.out.println("YA HABIAS ELEGIDO ESA CASILLA");
                            numTiros = numTiros - 1;
                        break;
                        case 3:
                            System.out.println("HAZ ACERTADO");//TODO: implementar un aviso cuando se a hundido un barco
                            t.matriz[tiroX][tiroY].setCheck(true);
                            for (int i = 0; i < 10; i++) {
                                 t.flota[i].buscaBarco(tiroX, tiroY);
                            }
                        break;
                        case 4:
                            System.out.println("HAZ FALLADO, NO HAY BARCO");
                            t.matriz[tiroX][tiroY].setCheck(true);
                            numTiros = numTiros - 1;
                        break;
                    }
                    numBarcosHundidos = t.barcosHundidos();        
                    t.actualizaTablero(); 
                    System.out.println("Intendos restantes:"+numTiros+"\t\t Barcos Hundidos: "+numBarcosHundidos);
                       
                }while (numTiros!=0 || numBarcosHundidos!=10);
            
             if (numBarcosHundidos == 10)
                {
                   System.out.println ("FELICIDADES...!!!!! , HAZ HUNDIDO TODOS LOS BARCOS");
                    //TODO: Manda a traer el metodo para guardar el usuario junto con la palabra GANADOR
             }else{
                 System.out.println ("GAME OVER, HAZ AGOTADO TUS TIROS");
                 //TODO: Manda a traer el metodo para guardar el usuario junto con la palabra PERDEDOR y el numero de barcos hundidos
             }
            
                break;
            case 2:
             //TODO: Mandar a traer el metodo que muestra a los usuarios ingresados con sus puntuajes
                break;
            case 3: 
             System.exit(0);
                break;
        }
        
    }
}
