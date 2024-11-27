package com.org.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RetanguloTestes {

    private static Calculadora retangulo;

    @BeforeEach
    public void setUp(){
        retangulo = new Retangulo();
    }

    @Test
    public void testeCasoOsDoisLadosSeremIguais(){
        RuntimeException exception = assertThrows(RuntimeException.class, ()->
        {retangulo.calcularArea(new double[]{5,5});});
        assertEquals("Os lados precisam ser diferentes", exception.getMessage());
    }

    @Test
    public void testeCasoOsLadosSeremDiferentes(){
        double resposta = retangulo.calcularArea(new double[]{2, 5});

        assertEquals(10, resposta);
    }

    @Test
    public void testeCasoOsLadosSeremZeroAbsoluto(){
        RuntimeException exception = assertThrows(RuntimeException.class, ()->
        {retangulo.calcularArea(new double[]{0,0});});
        assertEquals("Zero não calcula area", exception.getMessage());
    }

    @Test
    public void testeCasoOsLadosSeremNegativos(){
        RuntimeException exception = assertThrows(RuntimeException.class, ()->
        {retangulo.calcularArea(new double[]{-5,-5});});
        assertEquals("Não existe medida negativa para calcular area", exception.getMessage());
    }

    @Test
    public void testeCasoMaisDeDuasMedidasForemPassadas(){
        RuntimeException exception = assertThrows(RuntimeException.class, ()->
        {retangulo.calcularArea(new double[]{3,3,3});});
        assertEquals("O retangulo só calcula usando 2 medidas", exception.getMessage());
    }
}
