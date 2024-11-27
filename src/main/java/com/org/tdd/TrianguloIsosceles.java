package com.org.tdd;

public class TrianguloIsosceles implements Calculadora {
    @Override
    public double calcularArea(double[] valores) {
        validarParametros(valores);

        double calc = 0.25*valores[1];//base vezes um quarto
        double calc2 = (4 * (Math.pow(valores[0], 2))) - (Math.pow(valores[1],2));//4 vezes o lado ao quadrado menos base ao quadrado
        double area = calc * (Math.sqrt(calc2));// calculo 1 vezes a raiz quadrada do calculo 2
        return Math.round(area * 100.0) / 100.0;// aredondamento para duas casas decimais
    }

    private void validarParametros(double[] parametros) {

        if(parametros.length != 2) throw new RuntimeException("O triangulo isosceles precisa somente do lado e da base");
        for (double valor : parametros){
            if(valor == 0) throw new RuntimeException("Zero não calcula area");
            if(valor < 0) throw new RuntimeException("Não existe medida negativa para calcular area");
        }
        if(!(parametros[1] < (parametros[0]*2)))
            throw new RuntimeException("A base de um triângulo isósceles deve ser menor que o dobro de seu lado.");
    }
}
