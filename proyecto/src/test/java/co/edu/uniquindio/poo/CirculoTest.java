package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

public class CirculoTest {
    private static final Logger LOG = Logger.getLogger(AppTest.class.getName());
    
@Test
public void calcularAreaCirculo(){
    LOG.info("Inicio area circulo");
    Circulo circulo = new Circulo(10);
    double areaCalculada= circulo.calcularArea();
    assertEquals(314.159, areaCalculada,0.05);
    LOG.info("Finaliza area circulo");
}

 @Test
    public void AreaCirculoNegativa (){
        LOG.info("Inicio teste calcular el area de un circulo cuando el radio es negativo");
        assertThrows(Throwable.class, ()-> new Circulo(-10));
        LOG.info("Inicio teste calcular el area de un circulo cuando el radio es negativo");
    }
    
}