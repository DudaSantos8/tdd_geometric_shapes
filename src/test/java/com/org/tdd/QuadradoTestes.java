package com.org.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public record QuadradoTestes() {

    private static Calculadora quadrado;

    @BeforeEach
    public void setUp(){
        quadrado = new Quadrado();
    }

    @Test
    public void testeCasoOsDoisLadosSeremIguais(){
        double resposta = quadrado.calcularArea(new double[]{2, 2});

        assertEquals(4, resposta);
    }

    @Test
    public void testeCasoSoUmLadoForPassado(){
        double resposta = quadrado.calcularArea(new double[]{2});

        assertEquals(4, resposta);
    }

    @Test
    public void testeCasoOsLadosSeremDiferentes(){
        RuntimeException exception = assertThrows(RuntimeException.class, ()->
            {quadrado.calcularArea(new double[]{2,5});});
        assertEquals("Os lados precisam ser iguais", exception.getMessage());
    }

    @Test
    public void testeCasoOsLadosSeremZeroAbsoluto(){
        RuntimeException exception = assertThrows(RuntimeException.class, ()->
        {quadrado.calcularArea(new double[]{0,0});});
        assertEquals("Zero não calcula area", exception.getMessage());
    }

    @Test
    public void testeCasoOsLadosSeremNegativos(){
        RuntimeException exception = assertThrows(RuntimeException.class, ()->
        {quadrado.calcularArea(new double[]{-5,-5});});
        assertEquals("Não existe medida negativa para calcular area", exception.getMessage());
    }

    @Test
    public void testeCasoMaisDeDuasMedidasForemPassadas(){
        RuntimeException exception = assertThrows(RuntimeException.class, ()->
        {quadrado.calcularArea(new double[]{3,3,3});});
        assertEquals("O quadrado só calcula usando até 2 medidas", exception.getMessage());
    }

}
