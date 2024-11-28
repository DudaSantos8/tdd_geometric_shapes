package com.org.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HexagonoTeste {
    private static Calculadora hexagono;

    @BeforeEach
    public void setUp(){
        hexagono = new Hexagono();
    }

    @Test
    public void testeCasoMedidasCertasForemPassadas(){
        double resposta = hexagono.calcularArea(new double[]{8});
        assertEquals(166.28, resposta);
    }

    @Test
    public void testeCasoOsLadosSeremZeroAbsoluto(){
        RuntimeException exception = assertThrows(RuntimeException.class, ()->
        {hexagono.calcularArea(new double[]{0});});
        assertEquals("Zero não calcula area", exception.getMessage());
    }

    @Test
    public void testeCasoOsLadosSeremNegativos(){
        RuntimeException exception = assertThrows(RuntimeException.class, ()->
        {hexagono.calcularArea(new double[]{-5});});
        assertEquals("Não existe medida negativa para calcular area", exception.getMessage());
    }

    @Test
    public void testeCasoMaisDeDuasMedidasForemPassadas(){
        RuntimeException exception = assertThrows(RuntimeException.class, ()->
        {hexagono.calcularArea(new double[]{3,3});});
        assertEquals("O hexagono só precisa de 1 medida", exception.getMessage());
    }
}
