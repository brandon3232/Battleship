import java.util.Scanner;
import java.util.InputMismatchException;

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
        Tablero t;
        String tablero;
        int n = (int) (Math.random() * (5 - 1)) + 1;
        tablero="flota"+n;
        t= new Tablero(tablero);
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
        
        while (true) {
            try {
                System.out.println("¿Cual es su edad?");
                edad = Integer.parseInt(scanner.nextLine());
    
                if (edad >= 18) {
                    System.out.println("Que disfrutes el juego");
                    break;
                    
                } else {
                    System.out.println("LO SENTIMOS, el juego solo es para personas mayores de 18 años.");
                    System.exit(0);
                }
    
            } catch (Exception e) {
                System.out.println("ERROR: no es un numero ENTERO");
            }
        }

        usuario = new Usuario(nombre, edad);
        return usuario;

    }

//---------------------------------MAIN---------------------------------//
    public static void main(String[] args ) {

        Scanner scanner = new Scanner (System.in);
        int numTiros=10;
        int numBarcosHundidos=0;
        int d=0;
        Tablero t;
        Usuario usuario;
          
        
        d = menu();
        switch (d){
            case 1:

            t=iniciaTablero();  
            usuario=creaUsuario();
           
            do{
                try{
                    int tiroX=0;
                    int tiroY=0;

                    System.out.println("Seleccione la linea en la que desea tirar:");
                    tiroY = scanner.nextInt();
                    System.out.println("Seleccione la columna en la que desea tirar:");
                    tiroX = scanner.nextInt();
                    clearConsole();
                    

                    switch (t.checaCasilla(tiroX, tiroY)) {
                        case 1,2:
                            System.out.println("YA HABIAS ELEGIDO ESA CASILLA\n");
                            numTiros = numTiros - 1;
                        break;

                        case 3:
                            System.out.println("HAZ ACERTADO\n");
                            t.matriz[tiroY][tiroX].setCheck(true);
                            for (int i = 0; i < 10; i++) {
                                    t.flota[i].buscaBarco(tiroX, tiroY);
                            }
                        break;

                        case 4:
                            System.out.println("HAZ FALLADO, NO HAY BARCO\n");
                            t.matriz[tiroY][tiroX].setCheck(true);
                            numTiros = numTiros - 1;
                        break;
                    }
                }catch (InputMismatchException e) {
                    System.out.println("Error1: Solo puede ingresar numeros enteros");
                    scanner.next();
                }catch (ArrayIndexOutOfBoundsException e){
                    
                    System.out.println ("Error2: Coordenada fuera de lugar");
                    scanner.next();
                }


                numBarcosHundidos = t.barcosHundidos();        
                t.actualizaTablero(); 

                System.out.println("Intendos restantes:"+numTiros+"\t\t\t\t Barcos Hundidos: "+(numBarcosHundidos));
                    
            }while (!(numTiros==0 || numBarcosHundidos==10));
            
             if (numBarcosHundidos == 10)
                {
                   System.out.println ("FELICIDADES...!!!!! , HAZ HUNDIDO TODOS LOS BARCOS");
            
                    usuario.setGanador(true);
                    usuario.setBarcosHundidos(numBarcosHundidos);
             }else{

                clearConsole();
                t.mostrarBarcos();
                System.out.println ("GAME OVER, HAZ AGOTADO TUS TIROS\t\t"+numBarcosHundidos+" barcos hundidos");
                usuario.setGanador(false);
                usuario.setBarcosHundidos(numBarcosHundidos);
             }
            
             
             try  {
                usuario.guardaUsuario();
            } catch (Exception e) {
                System.out.println("ERROR:" + e.toString());
            }
                break;
            case 2:
            try {
                Usuario.leerArchBin();
            } catch (Exception e) {}
                break;
            case 3: 
             System.exit(0);
                break;
        
        }
    }


    public static final void clearConsole()
    {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                for (int i = 0; i < 25; i++) {
                    System.out.println("");
                }
            else
                System.out.print("\033\143");
        } catch (Exception e) {System.out.println("ERROR: no se puedo limpiar la consola");}
    }
}
