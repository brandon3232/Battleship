import java.util.Scanner;
import java.util.ArrayList;


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

    public static Tablero iniciaTablero(){

        //int n = (int) (Math.random() * (5 - 1)) + 1;
                //switch (n) {
                // case 1:
                Tablero t = new Tablero("flota1"); 
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
                return t;
    }
    
    public static Usuario creaUsuario(){

        int edad = 0;
        String nombre = "";
        Scanner scanner = new Scanner (System.in);
        Usuario usuario;
        
        System.out.println("Hola y Bienvenido seas a Battleship");
        System.out.println("¿Cual es su nombre?");
        nombre = scanner.nextLine();
        
        try {
            System.out.println("¿Cual es su edad?");
            edad = Integer.parseInt(scanner.nextLine());

            if (edad >= 18) {
                System.out.println("Que disfrutes el juego");
                
            } else {
                System.out.println("LO SENTIMOS, el juego solo es para personas mayores de 18 años.");
                System.exit(0);
            }

        } catch (Exception e) {
            System.out.println("ERROR: no es un numero ENTERO");
            System.exit(0);
        }

        usuario = new Usuario(nombre, edad);
        return usuario;

    }

//---------------------------------MAIN---------------------------------//
    public static void main(String[] args ) {

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        Scanner scanner = new Scanner (System.in);
        int tiroX;
        int tiroY;
        int numTiros=10;
        int numBarcosHundidos=0;
        int d=0;
        Tablero t;
        Usuario usuario;
          
        for(;;) {
            d = menu();
        switch (d){
            case 1:
            t=iniciaTablero();  
            usuario=creaUsuario();
           
            do{
                System.out.println("Seleccione la linea en la que desea tirar:");
                tiroY = scanner.nextInt();
                System.out.println("Seleccione la columna en la que desea tirar:");
                tiroX = scanner.nextInt();//TODO:poner try-catch por si mete algo que no sea numero y crear excepcion
                //por si introduce una coordenada fuera de rango

                clearConsole();
                

                switch (t.checaCasilla(tiroX, tiroY)) {
                    case 1,2:
                        System.out.println("YA HABIAS ELEGIDO ESA CASILLA");
                        numTiros = numTiros - 1;
                    break;
                    case 3:
                        System.out.println("HAZ ACERTADO");//TODO: implementar un aviso cuando se a hundido un barco
                        t.matriz[tiroY][tiroX].setCheck(true);
                        for (int i = 0; i < 10; i++) {
                                t.flota[i].buscaBarco(tiroX, tiroY);
                        }
                    break;
                    case 4:
                        System.out.println("HAZ FALLADO, NO HAY BARCO");
                        t.matriz[tiroY][tiroX].setCheck(true);
                        numTiros = numTiros - 1;
                    break;
                }

                numBarcosHundidos = t.barcosHundidos();        
                t.actualizaTablero(); 

                System.out.println("Intendos restantes:"+numTiros+"\t\t Barcos Hundidos: "+(numBarcosHundidos));
                    
            }while (!(numTiros==0 || numBarcosHundidos==10));
            
             if (numBarcosHundidos == 10)
                {
                   System.out.println ("FELICIDADES...!!!!! , HAZ HUNDIDO TODOS LOS BARCOS");
            
                    usuario.setGanador(true);
                    usuario.setBarcosHundidos(numBarcosHundidos);
             }else{

                 System.out.println ("GAME OVER, HAZ AGOTADO TUS TIROS");
                 usuario.setGanador(false);
                    usuario.setBarcosHundidos(numBarcosHundidos);
             }
             usuarios.add(usuario);
            
                break;
            case 2:
             for (Usuario user : usuarios) {
                 System.out.println(user.getNombre() + " " + user.getEdad() + " años " + (user.getGanador() ? "Es ganador " : "Perdio ") + user.getBarcosHundidos() + " barcos hundidos." );
             }
                break;
            case 3: 
             System.exit(0);
                break;
        }
        }
        
    }
    public static final void clearConsole()
    {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                System.out.print("\033\143");
        } catch (Exception e) {System.out.println("ERROR: no se puedo limpiar la consola");}
    }
}
