package com.org.tdd;

public class Hexagono implements Calculadora {
    @Override
    public double calcularArea(double[] valores) {
        validarParametros(valores);
        double calc = (3 * (Math.sqrt(3)) / 2) * Math.pow(valores[0], 2);

        return Math.round(calc * 100.0) / 100.0;// aredondamento para duas casas decimais
    }
    // = (√3/2 * a) * (6 * a) /2 formula

    private void validarParametros(double[] parametros){
        if(parametros.length != 1)
            throw new RuntimeException("O hexagono só precisa de 1 medida");

            if(parametros[0] == 0)
                throw new RuntimeException("Zero não calcula area");
            if(parametros[0] < 0)
                throw new RuntimeException("Não existe medida negativa para calcular area");
    }
}
