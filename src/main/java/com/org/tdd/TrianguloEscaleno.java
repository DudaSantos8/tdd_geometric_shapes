package com.org.tdd;

public class TrianguloEscaleno implements Calculadora {

    @Override
    public double calcularArea(double[] valores) {
        validarParametros(valores);

        double s = (valores[0] + valores[1] + valores[2]) / 2;
        double calc = s * (s - valores[0]) * (s - valores[1]) * (s - valores[2]);
        double area = Math.sqrt(calc);
        return Math.round(area * 1000.0) / 1000.0;
    }

    //A = raizQuadrada(s*(s−a)*(s−b)*(s−c)) formula de heron
    // s = semiperimetro do triangulo {soma dos lados dividido por 2}

    private void validarParametros(double[] parametros) {

        if(parametros.length != 3)
            throw new RuntimeException("O triangulo só calcula usando 3 medidas");

        for (double valor : parametros){
            if(valor == 0) throw new RuntimeException("Zero não calcula area");
            if(valor < 0) throw new RuntimeException("Não existe medida negativa para calcular area");
        }

        if(parametros[0] == parametros[1] && parametros[1] == parametros[2])
            throw new RuntimeException("Os lados precisam ser todos diferentes");
    }
}
