package co.edu.uniquindio.poo;

public class Triangulo extends FiguraGeometrica{
    private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;

        assert base > 0;
        assert altura > 0;

    }
    @Override
    public double calcularArea(){
        return (base *altura)/2;
    }
    public double getBase() {
        return base;
    }
    public double getAltura() {
        return altura;
    }
   
    
    
}
