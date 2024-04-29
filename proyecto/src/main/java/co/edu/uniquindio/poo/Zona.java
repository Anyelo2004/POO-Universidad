package co.edu.uniquindio.poo;

public class Zona {
    private final String nombre;
    private final Material material;
    private final FiguraGeometrica figuraGeometrica;
    public Zona(String nombre, Material material, FiguraGeometrica figuraGeometrica) {
        this.nombre = nombre;
        this.material = material;
        this.figuraGeometrica = figuraGeometrica;
    }

    public double calcularValorZona(){
        double subTotal= 0;
        subTotal= figuraGeometrica.calcularArea() *material.getValorMetroCuadrado();
        return subTotal;
    }
    public String getNombre() {
        return nombre;
    }
    public Material getMaterial() {
        return material;
    }
    public FiguraGeometrica getFiguraGeometrica() {
        return figuraGeometrica;
    }
    
    
}

