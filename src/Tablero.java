
import java.io.*;


public class Tablero {
    public static final int BARCO_Y_CHECK=1;
    public static final int NO_BARCO_Y_CHECK=2;
    public static final int BARCO_Y_NO_CHECK=3;
    public static final int NO_BARCO_Y_NO_CHECK=4;


    Casilla[][] matriz = new Casilla [10][10];
    Barco[] flota= new Barco[10];

    //imprime el tablero inicial
    public static void inicializaTablero(){
        for (int i = 0; i < 10; i++) {
            System.out.print("\t" + i);
        }

        System.out.println("\n");
        for (int i = 0; i < 10; i++) {

            System.out.print((i));
            for (int j = 0; j<10; j++) {
                System.out.print("\t-");
            }

            System.out.println("\n");
        }
    }

    //metodo que lee un archivo serializado con los objetos barco, los mete en el arreglo flota
    // y asigna las coordenadas correspondientes de cada barco en la matriz 
    public void leeArchivo()throws IOException, ClassNotFoundException{
        ObjectInputStream file = new ObjectInputStream (new FileInputStream("flota1"));
        Barco barco;
        int x;
        int y;
        //mete los objetos barco que se sacan del archivo y los mete en arreglo flota 
        for (int k = 0; k < 10; k++) {
            flota[k]=new Barco();
            barco = (Barco)file.readObject();
            flota[k]=barco;
        }
        file.close();
        //usa las coordenadas de cada barco para llenar la matriz e indicar que hay barco en esas coordenadas
        for (int i = 0; i < 10; i++) {
            
            for (int j = 0; j < 3; j++) {
                x=flota[i].secciones[j].getCoordenadaX();
                y=flota[i].secciones[j].getCoordenadaY();
                matriz[x][y].setHayBarco(true);
            }
        }
    }

    //metodo que actualiza el estado de cada casilla dependiendo su estado
    public void actualizaTablero(){
        for (int i = 0; i < 10; i++) {
            System.out.print("\t" + i);
        }
        System.out.println("\n");
        for (int i = 0; i < 10; i++) {

            System.out.print((i));
            for (int j = 0; j<10; j++) {
                
                if (checaCasilla(i, j)==BARCO_Y_NO_CHECK||checaCasilla(i, j)==NO_BARCO_Y_NO_CHECK) {
                    System.out.print("\t-");
                }else{
                    if (checaCasilla(i, j)==NO_BARCO_Y_CHECK) {
                        System.out.print("\t0");
                    }else{
                        System.out.println("\tB");
                    }
                }
            }
            System.out.println("\n");
        }
    }

    //metodo que ferifica el estado de la casilla en las coordenadas ingresadas y regresa los 4 
    // estados posibles de esa casilla
    public int checaCasilla(int x, int y){
        if (!matriz[x][y].getHayBarco()&&!matriz[x][y].getCheck()) {
            return NO_BARCO_Y_NO_CHECK;
        }else{
            if (matriz[x][y].getHayBarco()&&!matriz[x][y].getCheck()) {
                return BARCO_Y_NO_CHECK;
            }else{
                if (!matriz[x][y].getHayBarco()&&matriz[x][y].getCheck()) {
                    return NO_BARCO_Y_CHECK;
                }else{  
                    return BARCO_Y_CHECK;
                }
            }
        }
    }

    public static void main(String args[]) throws ClassNotFoundException{
        Tablero t= new Tablero();
        try {
            t.leeArchivo();
            inicializaTablero();
            t.actualizaTablero();
        } catch (IOException e) {
            System.out.println("ERROR: no se pudo abrir el archivo");
            System.exit(0);
        }
        //leer();    
    }    
    
    // metodo para hacer pruebas de lectura del archivo serializado
    public static void leer() {
        Barco b;
        try {
            ObjectInputStream f = new ObjectInputStream (new FileInputStream("flota1"));
            for (int k = 0; k < 10; k++) {
            
                b = (Barco)f.readObject();
                System.out.println(b);
            }
            f.close();
        } catch (Exception e) {
            System.out.println("ERROR: no se pudo abrir el archivo");
            System.exit(0);
        }

    }
} 
