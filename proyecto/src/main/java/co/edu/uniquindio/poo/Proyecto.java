package co.edu.uniquindio.poo;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.function.Predicate;

public class Proyecto {

    private final Collection<Parque> listaParques;

    /*
     * Método constructor de la clase Proyecto
     */
    public Proyecto (){
        listaParques = new LinkedList<>();
    }

    /*
     * Método para obtener la lista no modificable de parques infantiles 
     */
    public Collection<Parque> getListaParques() {
        return listaParques;
    }

    /*
     * Método para añadir un parque infantil al proyecto
     */
    public void añadirParque (Parque parque){
        assert !existeParque(parque.getNombre());
        listaParques.add(parque);
    }

    /*
     * Método para calcular el valor total del proyectp
     */
    public double calcularValorProyecto (){
        return listaParques.stream().mapToDouble(n -> n.calcularValor()).sum();
    }

    /*
     * Método para obtener un parque infantil por su nombre
     */
    public Parque getParqueNombre (String nombre){
        Predicate<Parque> nombreIgual = parque -> parque.getNombre().equals(nombre);
        var posibleParque = listaParques.stream().filter(nombreIgual).findAny();
        assert posibleParque.isPresent();
        return posibleParque.get();
    }

    /*
     * Método para obtener los parques ordenados por el nombre de municipio
     */
    public Collection<Parque> getParqueMunicipio(String municipio){
        var comparador = Comparator.comparing(Parque :: getNombre);
        var parquesOrdenados = listaParques.stream().filter(parque -> parque.getMunicipio().name().equals(municipio)).sorted(comparador).toList();
        return Collections.unmodifiableCollection(parquesOrdenados);
    }

    /*
     * Método para obtener la lista de parques por valor ascendente
     */
    public Collection<Parque> listaOrdenada (){
        var comparador = Comparator.comparing(Parque :: calcularValor);
        var parquesOrdenadosValor = listaParques.stream().sorted(comparador).toList();
        return Collections.unmodifiableCollection(parquesOrdenadosValor);
    }
    
    /*
     * Método privado para determinar si existe un parque infantil con nombre igual
     */
    private boolean existeParque(String nombre){
        Predicate<Parque> nombreIgual = parque -> parque.getNombre().equals(nombre);
        return listaParques.stream().filter(nombreIgual).findAny().isPresent();
    }

   

}
   
  
