
import java.io.*;


public class Tablero {
    public static final int BARCO_Y_CHECK=1;
    public static final int NO_BARCO_Y_CHECK=2;
    public static final int BARCO_Y_NO_CHECK=3;
    public static final int NO_BARCO_Y_NO_CHECK=4;


    Casilla[][] matriz = new Casilla [10][10];
    Barco[] flota= new Barco[10];

    //al llamar este constructor lo que pasarà es que se leerá automaticamente el archivo
    //serializado, se asignaran las coordenadas de los barcos y aparecerá el tablero en pantalla
    public Tablero(String file){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                matriz[i][j]=new Casilla();
            }
        }

        try {
            leeArchivo(file);
            inicializaTablero();
        } catch (IOException e) {
            System.out.println("ERROR: no se pudo abrir el archivo");
            System.exit(0);
        } catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

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
    public void leeArchivo(String nameFile)throws IOException, ClassNotFoundException{
        ObjectInputStream file = new ObjectInputStream (new FileInputStream(nameFile));
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
                matriz[y][x].setHayBarco(true);
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
                
                if (checaCasilla(j, i)==BARCO_Y_NO_CHECK||checaCasilla(j, i)==NO_BARCO_Y_NO_CHECK) {
                    System.out.print("\t-");
                }else{
                    if (checaCasilla(j, i)==NO_BARCO_Y_CHECK) {
                        System.out.print("\t0");
                    }else{
                        System.out.print("\tB");
                    }
                }
            }
            System.out.println("\n");
        }
    }

    //metodo que ferifica el estado de la casilla en las coordenadas ingresadas y regresa los 4 
    // estados posibles de esa casilla
    public int checaCasilla(int x, int y){
        if (!matriz[y][x].getHayBarco()&&!matriz[y][x].getCheck()) {
            return NO_BARCO_Y_NO_CHECK;
        }else{
            if (matriz[y][x].getHayBarco()&&!matriz[y][x].getCheck()) {
                return BARCO_Y_NO_CHECK;
            }else{
                if (!matriz[y][x].getHayBarco()&&matriz[y][x].getCheck()) {
                    return NO_BARCO_Y_CHECK;
                }else{  
                    return BARCO_Y_CHECK;
                }
            }
        }
    } 
    
    public void mostrarBarcos(){
        for (int i = 0; i < 10; i++) {
            System.out.print("\t" + i);
        }
        System.out.println("\n");
        for (int i = 0; i < 10; i++) {

            System.out.print((i));
            for (int j = 0; j<10; j++) {
                
                if (matriz[i][j].getHayBarco()) {
                    System.out.print("\tB");
                }else{
                    System.out.print("\t-");
                }
            }
            System.out.println("\n");
        }
    }


    public int barcosHundidos(){
        int contador=0;
        for (int i = 0; i < 10; i++) {
            if (!flota[i].getVivo()) {
                contador+=1;
            }
        }
        return contador;

    }
} 
