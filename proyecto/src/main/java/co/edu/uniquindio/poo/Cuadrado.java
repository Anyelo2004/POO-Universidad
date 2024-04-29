package co.edu.uniquindio.poo;

public class Cuadrado extends Rectangulo {
    private double lado;
    public Cuadrado(double lado){
        super(lado, lado);
        this.lado = lado;
        assert lado > 0;
    }
    @Override
    public double calcularArea(){
        return Math.pow(lado, 2);
    }
  
    

    
}
