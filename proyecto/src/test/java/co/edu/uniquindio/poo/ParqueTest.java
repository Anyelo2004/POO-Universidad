package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

public class ParqueTest {
    private static final Logger LOG = Logger.getLogger(RectanguloTest.class.getName());

    @Test 
    public void ParqueNombreNulo (){
        LOG.info("Inicio teste parque con nombre nulo");
        assertThrows(Throwable.class, () -> new Parque(null, "D1", Municipio.FILANDIA));
        LOG.info("Fin test parque con nombre nulo ");
    }

    @Test
    public void ParqueNombreVacio (){
        LOG.info("Inicio test parque con nombre vacio");
        assertThrows(Throwable.class, () -> new Parque("", "D1", Municipio.ARMENIA));
        LOG.info("Fin test parque con nombre vacio");
    }

    @Test 
    public void ParqueDescripcionNula (){
        LOG.info("Inicio test parque con descripcion nula");
        assertThrows(Throwable.class, () -> new Parque("A", null, Municipio.CORDOBA));
        LOG.info("Fin test parque con descripcion nula ");
    }

    @Test
    public void ParqueDescripcionVacia (){
        LOG.info("Inicio test parque con descripcion vacia");
        assertThrows(Throwable.class, () -> new Parque("A", " ", Municipio.MONTENEGRO));
        LOG.info("Fin test parque con descripcion vacia");
    }

    @Test
    public void ValorParqueSinZonas (){
        LOG.info("Inicio test Valor parque sin zonas");
        Parque parque = new Parque("Las flores", "Parque para niños y mascotas", Municipio.SALENTO);
        assertEquals(50000, parque.calcularValor());
        LOG.info("Fin test Valor parque sin zonas");
    }

    @Test 
    public void ValorParqueZonaCircular (){
        LOG.info("Inicio test valor de un parque con zona circular");
        Parque parque = new Parque("Las flores", "Parque infantil para niños y mascotas", Municipio.CALARCA);
        parque.agregarzona(new Zona("Zona de mascotas", Material.ARENA, new Circulo(10)));
        assertEquals(3151592.65, parque.calcularValor(),0.05);
        LOG.info("Inicio test valor de un parque con zona circular");
    }

    @Test
    public void ValorParqueCuatroZonas (){
        LOG.info("Inicio test valor parque con cuatro zonas");
        Parque parque = new Parque("Las flores", "Parque infantil para niños y mascotas", Municipio.CALARCA);
        parque.agregarzona(new Zona("Zona mascotas", Material.ARENA, new Circulo(10)));
        parque.agregarzona(new Zona("Zona rectangular", Material.GRAMA_SINTETICA, new Rectangulo(10, 20)));
        parque.agregarzona(new Zona("Zona cuadrada", Material.GRAMA_NATURAL, new Cuadrado(10)));
        parque.agregarzona(new Zona("Zona triangular", Material.ARENA, new Triangulo(10, 20)));

        assertEquals(13151592.65, parque.calcularValor(),0.05);
        LOG.info("Fin test valor parque con cuatro zonas");
    }

    @Test
    public void ParqueZonasIgualNombre (){
        LOG.info("Inicio test parques con igual nombre");
        Parque parque = new Parque("Las flores", "Parque infantil para niños y mascotas", Municipio.CALARCA);
        parque.agregarzona(new Zona("Zona mascotas", Material.ARENA, new Circulo(10)));
        assertThrows(Throwable.class, () -> parque.agregarzona(new Zona("Zona mascotas", Material.GRAMA_NATURAL, new Cuadrado(4))));
        LOG.info("Fin test parques con igual nombre");
    }
}
