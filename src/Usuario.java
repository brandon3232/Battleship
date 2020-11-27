import java.util.Scanner.*;
import java.io.*;

public class Usuario {
    private String nombre;
    private int edad;
    private boolean ganador;
    private int barcosHundidos;

    public Usuario(String nombre, int edad) {
        this.nombre = nombre; this.edad = edad;
    }

    public void setGanador(boolean ganador) {
        this.ganador = ganador;
    }
    public void setBarcosHundidos(int barcosHundidos) {
        this.barcosHundidos = barcosHundidos;
    }


    public void guardaUsuario() throws IOException {
        

        

        FileOutputStream fo = new FileOutputStream("datosUsuarios", true);
        DataOutputStream file = new DataOutputStream(fo);

        file.writeUTF(nombre);
        file.writeInt(edad);
        if (ganador) {
            file.writeUTF("ganador");
        }else{
            file.writeUTF("perdedor");
        }
        file.writeInt(barcosHundidos);
        file.close();

    }

    public static void leerArchBin () throws IOException
        {
        DataInputStream file = new DataInputStream(new FileInputStream("datosUsuarios"));
        String nombre;
        int edad;
        String ganador;
        int barcosHundidos;
        try {
            while (true) {
                nombre=file.readUTF();
                edad=file.readInt();
                ganador=file.readUTF();
                barcosHundidos=file.readInt();

                System.out.println(nombre+"\t\t"+edad+" años\t"+"\t"+ganador+"\t"+barcosHundidos+" barcos hundidos");
            }
        } catch (EOFException e) {}
        file.close();
        
        }
    
        
    
}
