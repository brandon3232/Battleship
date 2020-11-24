import java.util.Scanner;

public class Battleship {
    public static void main(String args []){
        int desicion;
        int tiroX, tiroY, numTiros=10;
        Scanner scanner = new Scanner (System.in);
        
          System.out.println("-------------BATTLESHIP----------");
          System.out.println("---------------MENU--------------");
          System.out.println("¿Que desea hacer?");
          System.out.println("1. Jugar");
          System.out.println("2. Ver puntajes");
          System.out.println("3. Salir");
          desicion = scanner.nextInt(); 
          
        
        switch (desicion){
            case 1:
            int n = (int) (Math.random() * (5 - 1)) + 1;
            if (n == 1){
                //Poner aqui las instrucciones para abrir el primer archivo
                if (n == 2){
                    //Poner aqui las instrucciones para abrir el segundo archivo
                    if (n == 3){
                        //Poner aqui las instrucciones para abrir el tercer archivo
                        if (n == 4){
                            //Poner aqui las instrucciones para abrir el cuarto archivo
                        }
                    }
                }
            }
            //Mandar a traer el metodo usuario para registrarlo
            //Mandar a traer el metodo para imprimir el tablero
            do{
            System.out.println("Seleccione la linea en la que desea tirar:");
            tiroX = scanner.nextInt();
            System.out.println("Seleccione la columna en la que desea tirar:");
            tiroY = scanner.nextInt();
            //Mandar a traer el metodo de actualiza tablero, tambien en ese metodo se dice si acerto o no
            if (//Si acerto el tiro)
                {
                    //Mandar a traer el metodo que checa las partes del barco
                }else
                {
                    numTiros = numTiros - 1;
                }
            //Actualizar tablero    
            }while (numTiros!=0 || numBarcosHundidos == 10);
            if (numBarcosHundidos == 10)
            {
                System.out.println ("FELICIDADES...!!!!! , Haz hundido todos los barcos");
                //Manda a traer el metodo para guardar los puntajes
            }else{
                System.out.println ("GAME OVER, haz agotado todos tus tiros ): ");
                //Manda a traer el metodo para guardar los puntajes
            }
            
            break;
            case 2:
            //Mandar a traer el metodo que muestra a los usuarios ingresados con sus puntuajes
            case 3: 
             System.exit(0);
        }
        
    }
}
