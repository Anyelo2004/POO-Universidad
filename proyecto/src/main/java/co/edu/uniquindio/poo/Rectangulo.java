package co.edu.uniquindio.poo;

public class Rectangulo extends FiguraGeometrica{
    private double ancho;
    private double alto;

    public Rectangulo(double ancho, double alto){
        this.ancho = ancho;
        this.alto = alto;

        assert ancho> 0;
        assert alto> 0;
    }
    @Override
    public double calcularArea(){
        return ancho *alto;
    }
    public double getAncho() {
        return ancho;
    }
    public double getAlto() {
        return alto;
    }


 
    
    
}
