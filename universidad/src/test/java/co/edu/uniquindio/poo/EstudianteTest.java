/**
 * Clase para probar el funcionamiento del código
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class EstudianteTest {
    private static final Logger LOG = Logger.getLogger(EstudianteTestTest.class.getName());

    @Test

    public void datoscompletos(){
        LOG.info("inicio de la prueba datos completos");
        public void datosCompletos(){ Estudiante estudiante = new Estudiante("Carlos", "Casas Gomez", "234561", "3121452587", "ccasas@gmail.com", "33");
        assertEquals("Carlos",estudiante.nombres());
        assertEquals("arias",estudiante.apellidos());
        assertEquals("@",estudiante.nombres());
        assertEquals("Carlos",estudiante.nombres());
        assertEquals("Carlos",estudiante.nombres());
        assertEquals("Carlos",estudiante.nombres());
    }
    @Test
    public void datosNulos(){
        LOG.info("Inicio de la prueba datos completos");
        Estudiante estudiante = new Estudiante("Carlos","Casas Gomez","234561","314256363","ccasas@gmail.com",(byte)33);
        assertEquals("Carlos",estudiante.nombres());
        assertEquals("arias",estudiante.apellidos());
        assertEquals("@",estudiante.nombres());
        assertEquals("Carlos",estudiante.nombres());
        assertEquals("Carlos",estudiante.nombres());
        assertEquals("Carlos",estudiante.nombres());


}

   
   
    }

