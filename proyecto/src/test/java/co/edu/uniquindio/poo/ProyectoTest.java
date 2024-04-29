package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

public class ProyectoTest {
    private static final Logger LOG = Logger.getLogger(RectanguloTest.class.getName());

    @Test
    public void ValorProyectoSinParques() {
        LOG.info("Inicio test ValorProyectoSinParques");

        var proyecto = new Proyecto();

        assertEquals(0.0, proyecto.calcularValorProyecto());

        LOG.info("Fin test ValorProyectoSinParques");
    }

    @Test
    public void obtenerParqueNombre (){
        LOG.info("Inicio test Obtener un parque por su nombre");
        Proyecto proyecto = new Proyecto();
        Parque parque = new Parque("Las flores", "Parque infantil para niños y mascotas", Municipio.GENOVA);
        proyecto.añadirParque(parque);
        assertEquals(parque, proyecto.getParqueNombre("Las flores"));
        LOG.info("Fin test Obtener un parque por su nombre");
    }

    @Test
    public void ParqueNombreNoExistente (){
        LOG.info("Inicio test para obtener un parque con un nombre existente");
        Proyecto proyecto = new Proyecto();

        assertThrows(Throwable.class, () -> proyecto.getParqueNombre("Las flores"));
        LOG.info("Fin test para obtener un parque con un nombre existente");
    }

    @Test
    public void ParquesIguales (){
        LOG.info("Inicio test parques con igual nombre");
        Proyecto proyecto = new Proyecto();
        Parque parque= new Parque("Nubecitas", "Parque infantil para niños menores a 5 años", Municipio.PIJAO);
        proyecto.añadirParque(parque);
        assertThrows(Throwable.class, () -> proyecto.añadirParque(parque));
        LOG.info("Fin test parques con igual nombre");
    }

    @Test
    public void MunicipiosSinParque (){
        LOG.info("Inicio test municipios sin parques");
        Proyecto proyecto = new Proyecto();
        assertEquals(0, proyecto.getParqueMunicipio("CALARCA").size());
        LOG.info("Fin test municipios sin parques");
    }

    @Test
    public void MunicipioInexistente (){
        LOG.info("Inicio teste obtener un municipio inexistente");
        Proyecto proyecto = new Proyecto();
        assertEquals(0, proyecto.getParqueMunicipio("QUIMBAYA").size());
        LOG.info("Fin teste obtener un municipio inexistente");
    }

    @Test
    public void ParquesMunicipio (){
        LOG.info("Inicio teste obtener lista ordenada de acuerdo a los municipios");
        Proyecto proyecto = new Proyecto();
        var parque1 = new Parque("P1", "D1", Municipio.ARMENIA);
        var parque2 = new Parque("P2", "D2", Municipio.CORDOBA);
        var parque3 = new Parque("P3", "D3", Municipio.MONTENEGRO);
        var parque4 = new Parque("P4", "D4", Municipio.ARMENIA);
        var parque5 = new Parque("P5", "D5", Municipio.MONTENEGRO);
        var parque6 = new Parque("P6", "D6", Municipio.CORDOBA);

        proyecto.añadirParque(parque1);
        proyecto.añadirParque(parque2);
        proyecto.añadirParque(parque3);
        proyecto.añadirParque(parque4);
        proyecto.añadirParque(parque5);
        proyecto.añadirParque(parque6);

        Collection<Parque> listaEsperada = List.of(parque1,parque4);

        assertIterableEquals(listaEsperada, proyecto.getParqueMunicipio("ARMENIA"));
        LOG.info("Fin teste obtener lista ordenada de acuerdo a los municipios");
    }

    @Test
    public void ParquesOrdenValor (){
        LOG.info("Inicio test parques ordenados por valor");
        Proyecto proyecto = new Proyecto();

        var parque1 = new Parque("P1", "D1", Municipio.PIJAO);
        var parque2 = new Parque("P2", "D2", Municipio.CORDOBA);
        var parque3 = new Parque("P3", "D3", Municipio.BUENAVISTA);
        var parque4 = new Parque("P4", "D4", Municipio.PIJAO);
        var parque5 = new Parque("P5", "D5", Municipio.CORDOBA);
        var parque6 = new Parque("P6", "D6", Municipio.BUENAVISTA);

        Zona zona = new Zona("Zona", Material.ASFALTO, new Cuadrado(15));

        parque1.agregarzona(zona);
        parque2.agregarzona(zona);
        parque3.agregarzona(zona);
        parque4.agregarzona(zona);
        parque5.agregarzona(zona);
        parque6.agregarzona(zona);

        proyecto.añadirParque(parque1);
        proyecto.añadirParque(parque2);
        proyecto.añadirParque(parque3);
        proyecto.añadirParque(parque4);
        proyecto.añadirParque(parque5);
        proyecto.añadirParque(parque6);

        Collection <Parque> listaEsperada = List.of(parque2, parque5, parque3, parque6, parque1,parque4);
        assertIterableEquals(listaEsperada, ((Object) proyecto).listaOrdenada());
        LOG.info("Fin test parques ordenados por valor");
    }
}
