public class Seccion {
    private int coordenadaY;
    private int coordenadaX;
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
