package com.org.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TrianguloEquilateroTestes {
    private static Calculadora triangulo;

    @BeforeEach
    public void setUp(){
        triangulo = new TrianguloEquilatero();
    }

    @Test
    public void testeCasoOsLadosSeremTodosIguais(){
        double resposta = triangulo.calcularArea(new double[]{3, 3, 3});

        assertEquals(3.8971143170299736, resposta);
    }

    @Test
    public void testeCasoOsLadosSeremDiferentes(){
        RuntimeException exception = assertThrows(RuntimeException.class, ()->
        {triangulo.calcularArea(new double[]{4,5,3});});
        assertEquals("Os lados precisam ser todos iguais", exception.getMessage());
    }

    @Test
    public void testeCasoOsLadosSeremZeroAbsoluto(){
        RuntimeException exception = assertThrows(RuntimeException.class, ()->
        {triangulo.calcularArea(new double[]{0,0,0});});
        assertEquals("Zero não calcula area", exception.getMessage());
    }

    @Test
    public void testeCasoOsLadosSeremNegativos(){
        RuntimeException exception = assertThrows(RuntimeException.class, ()->
        {triangulo.calcularArea(new double[]{-5,-5, -5});});
        assertEquals("Não existe medida negativa para calcular area", exception.getMessage());
    }

    @Test
    public void testeCasoMaisDeTresMedidasForemPassadas(){
        RuntimeException exception = assertThrows(RuntimeException.class, ()->
        {triangulo.calcularArea(new double[]{3,3,3,3});});
        assertEquals("O triangulo só calcula usando 3 medidas", exception.getMessage());
    }
}
