package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.LinkedList;
import java.util.function.Predicate;

public class Parque {
    private final String nombre ;
    private final String descripcion;
    private final Municipio municipio;
    private final Collection <Zona> listaZonas;

    public Parque(String nombre, String descripcion, Municipio municipio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.municipio = municipio;
        assert nombre != null && !nombre.isBlank();
        assert descripcion != null && !nombre.isBlank();
        this.listaZonas = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Collection<Zona> getListaZonas() {
        return listaZonas;
    }

    public Municipio getMunicipio() {
        return municipio;
    }
    public void agregarzona (Zona zona){
        assert !existeZonaParque(zona.getNombre());
        listaZonas.add(zona);
    }

    public double calcularValor (){
        return listaZonas.stream().mapToDouble(n -> n.calcularValorZona()).sum() + municipio.getSobreCosto();

        }

    public double calcularValortotal(double sobreCosto, double subTotal){
        double total = 0;
        total = sobreCosto + subTotal;
        return total;

    }

    private boolean existeZonaParque(String nombre){
        Predicate<Zona> nombreIgual = zona -> zona.getNombre().equals(nombre);
        return listaZonas.stream().filter(nombreIgual).findAny().isPresent();
    }

    

    
}
