import com.org.tdd.Calculadora;

public class Circulo implements Calculadora {

    @Override
    public double calcularArea(double[] valores) {
        validarParametros(valores);
        return 3.14 * Math.pow((valores[0]/2), 2);
    }

    private void validarParametros(double[] parametros){
        if(parametros.length != 1)
            throw new RuntimeException("O circulo só precisa do diametro");

        if(parametros[0] == 0)
            throw new RuntimeException("Zero não calcula area");
        if(parametros[0] < 0)
            throw new RuntimeException("Não existe medida negativa para calcular area");
    }
}
