import java.io.Serializable;

public class Seccion implements Serializable {
    private static final long serialVersionUID = 2L;
    private int coordenadaY=0;
    private int coordenadaX=0;
    private boolean funcional=true;    

    public int getCoordenadaX() {
        return coordenadaX;
    }
    public int getCoordenadaY() {
        return coordenadaY;
    }
    public boolean getFuncional(){
        return funcional;
    }
    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }
    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }
    public void setFuncional(boolean funcional) {
        this.funcional = funcional;
    } 
}
