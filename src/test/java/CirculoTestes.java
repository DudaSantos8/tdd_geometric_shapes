import com.org.tdd.Calculadora;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CirculoTestes {
    private static Calculadora circulo;

    @BeforeEach
    public void setUp(){
        circulo = new Circulo();
    }

    @Test
    public void testeCasoMedidasCertasForemPassadas(){
        double resposta = circulo.calcularArea(new double[]{10});
        assertEquals( 78.5,resposta);
    }

    @Test
    public void testeCasoOsLadosSeremZeroAbsoluto(){
        RuntimeException exception = assertThrows(RuntimeException.class, ()->
        {circulo.calcularArea(new double[]{0});});
        assertEquals("Zero não calcula area", exception.getMessage());
    }

    @Test
    public void testeCasoOsLadosSeremNegativos(){
        RuntimeException exception = assertThrows(RuntimeException.class, ()->
        {circulo.calcularArea(new double[]{-10});});
        assertEquals("Não existe medida negativa para calcular area", exception.getMessage());
    }

    @Test
    public void testeCasoMaisDeDuasMedidasForemPassadas(){
        RuntimeException exception = assertThrows(RuntimeException.class, ()->
        {circulo.calcularArea(new double[]{3,3});});
        assertEquals("O circulo só precisa do diametro", exception.getMessage());
    }
}
