package com.org.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TrianguloIsoscelesTestes {
    private static Calculadora triangulo;

    @BeforeEach
    public void setUp(){
        triangulo = new TrianguloIsosceles();
    }

    @Test
    public void testeCasoMedidasCertasForemPassadas(){
        double resposta = triangulo.calcularArea(new double[]{10,15});
        assertEquals(49.61 , resposta);
    }

    @Test
    public void testeCasoMedidasErradasForemPasssadas(){
        RuntimeException exception = assertThrows(RuntimeException.class, ()->
        {triangulo.calcularArea(new double[]{10,20});});
        assertEquals("A base de um triângulo isósceles deve ser menor que o dobro de seu lado.", exception.getMessage());
    }

    @Test
    public void testeCasoOsLadosSeremZeroAbsoluto(){
        RuntimeException exception = assertThrows(RuntimeException.class, ()->
        {triangulo.calcularArea(new double[]{0,0});});
        assertEquals("Zero não calcula area", exception.getMessage());
    }

    @Test
    public void testeCasoOsLadosSeremNegativos(){
        RuntimeException exception = assertThrows(RuntimeException.class, ()->
        {triangulo.calcularArea(new double[]{-5,-5});});
        assertEquals("Não existe medida negativa para calcular area", exception.getMessage());
    }

    @Test
    public void testeCasoMaisDeTresMedidasForemPassadas(){
        RuntimeException exception = assertThrows(RuntimeException.class, ()->
        {triangulo.calcularArea(new double[]{3,3,3});});
        assertEquals("O triangulo isosceles precisa somente do lado e da base", exception.getMessage());
    }
}
