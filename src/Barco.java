import java.io.Serializable;

public class Barco implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private int coordenadaX=0;
    private int coordenadaY=0;
    private boolean vivo=true;
    Seccion[] secciones=new Seccion[3];

    public Barco(){
        for (int j = 0; j < secciones.length; j++) {
            secciones[j]=new Seccion();
        }
    }

    //costructor que resive 2 coordenadas para asignarlas tanto al barco
    //como a cada una de sus secciones
    public Barco(int x, int y){
        coordenadaX=x;
        coordenadaY=y;
        for (int i = 0; i < secciones.length; i++) {
            secciones[i]=new Seccion();
            secciones[i].setCoordenadaX(x+i);
            secciones[i].setCoordenadaY(y);
        
        }
    }

    public int getX() {
        return coordenadaX;
    }

    public int getY() {
        return coordenadaY;
    }

    public boolean getVivo() {
        return vivo;
    }

    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    // metodo que busca la seccion en las coordenadas que se le pasen y cambia el estado de
    // la variable funcional de esa seccion a false indicando que a sido undida
    public  void  modificaFuncionalSeccion (int x ,int y) {
        for (int i = 0; i < 3 ; i++) {
            if(secciones[i].getCoordenadaX() == x&&secciones[i].getCoordenadaY()==y) {
                secciones[i].setFuncional( false );
            }
        }
    }
    // metodo que verifica todas las secciones de cada barco, si las 3 estan
    // undidas cambiarà el estado de la variable vivo del barco a false
    // indicando que este barco ya a sido undido
    public  void  actualizarVivo () {
        int undidosTotales = 0 ;
        for ( int i = 0 ; i < secciones.length;i++) {
            if (!(secciones[i].getFuncional())) {
                undidosTotales+=1 ;
            }
        }
        if (undidosTotales == 3 ) {
            vivo = false ;
        }
    }
}
