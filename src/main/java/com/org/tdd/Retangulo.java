package com.org.tdd;

public class Retangulo implements Calculadora{
    @Override
    public double calcularArea(double[] valores) {
        validarParametros(valores);
        return valores[0] * valores[1];
    }

    private void validarParametros(double[] parametros){
        if(parametros.length != 2)
            throw new RuntimeException("O retangulo só calcula usando 2 medidas");

        if(parametros[0] < 0 || parametros[1] < 0)
            throw new RuntimeException("Não existe medida negativa para calcular area");

        if(parametros[0] == 0 || parametros[1] == 0)
            throw new RuntimeException("Zero não calcula area");

        if(parametros[0] == parametros[1])
            throw new RuntimeException("Os lados precisam ser diferentes");
    }
}
