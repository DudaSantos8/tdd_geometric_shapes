package com.org.tdd;

public class TrianguloEquilatero implements Calculadora {
    @Override
    public double calcularArea(double[] valores) {
        validarParametros(valores);
        double calc = valores[0] * valores[0];
        return calc * (Math.sqrt(3) / 4);
    }

    private void validarParametros(double[] parametros) {
        if(parametros[0] != parametros[1] && parametros[1] != parametros[2])
            throw new RuntimeException("Os lados precisam ser todos iguais");

        if(parametros.length != 3)
            throw new RuntimeException("O triangulo só calcula usando 3 medidas");

        for (double valor : parametros){
            if(valor == 0) throw new RuntimeException("Zero não calcula area");
            if(valor < 0) throw new RuntimeException("Não existe medida negativa para calcular area");
        }
    }
}
