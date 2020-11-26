import java.util.Scanner.*;
import java.io.*;

public class Usuario implements Serializable {

    private String nombre;
    private int edad;
    private boolean ganador; //Verdadero si es ganador; falso contrario
    private int barcosHundidos;

    public Usuario(String nombre, int edad) {
        this.nombre = nombre; this.edad = edad;
    }

    public void crearArchivo() throws IOException {
        DataOutputStream a = new DataOutputStream(
            new FileOutputStream(nombre + "_" + edad + ".bin", true)
        );
        Scanner lee = new Scanner();
    }

    public void setGanador(boolean ganador) {
        this.ganador = ganador;
    }

    public void setBarcosHundidos(int barcosHundidos) {
        this.barcosHundidos = barcosHundidos;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public boolean getGanador() {
        return this.ganador;
    }

    public int getBarcosHundidos() {
        return this.barcosHundidos;
    }
    
    public void guardaUsuario() throws IOException {
        FileOutputStream nombre = new FileOutputStream(nombre, true);
        DataOutputStream file = new DataOutputStream(fo);

        file.writeObject(this);
        file.close();
        nombre.close();

        // se tiene que guardar los datos:
        // nombre
        // edad
        // si ganó o perdiò
        // numero de barcos hundidos
    }

    public static Usuario leerArchBin (String nAr) throws IOException
        {
            
        DataInputStream nombre = new DataInputStream(new FileInptStream(nAr));
        DataOutputStream file = new DataOutputStream(fo);

        Usuario usuario = (Usuario) file.readObject();
        file.close();
        nombre.close();
        return usuario;
        }

  
}
