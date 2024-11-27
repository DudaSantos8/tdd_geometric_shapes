package com.org.tdd;

public class Quadrado implements Calculadora {

    @Override
    public double calcularArea(double[] valores) {
        validarParametros(valores);
        if(valores.length == 1) return valores[0]*valores[0];
        return valores[0] * valores[1];
    }

    private void validarParametros(double[] parametros){
        if(parametros.length > 2)
            throw new RuntimeException("O quadrado só calcula usando até 2 medidas");

        if(parametros.length > 1){
            if(parametros[0] != parametros[1])
                throw new RuntimeException("Os lados precisam ser iguais");
        }
        for(double parametro : parametros){
            if(parametro == 0)
                throw new RuntimeException("Zero não calcula area");
            if(parametro < 0)
                throw new RuntimeException("Não existe medida negativa para calcular area");
        }
    }
}
