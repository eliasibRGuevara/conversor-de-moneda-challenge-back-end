package modelos;

public class Contenido {
    private String monedaAConvertir;
    private String monedaConvertidaA;
    private double valorDeMonedaConvertida;

    public Contenido(String monedaAConvertir, String monedaConvertida, double valorDeMonedaConvertida) {
        this.monedaAConvertir = monedaAConvertir;
        this.monedaConvertidaA = monedaConvertida;
        this.valorDeMonedaConvertida = valorDeMonedaConvertida;
    }

    public String getMonedaAConvertir() {
        return monedaAConvertir;
    }

    public String getMonedaConvertida() {
        return monedaConvertidaA;
    }

    public double getValorDeMonedaConvertida() {
        return valorDeMonedaConvertida;
    }

    @Override
    public String toString() {
        return "Conversión:" +
                "monedaAConvertir= '" + monedaAConvertir + '\'' +
                ", monedaConvertidaA= '" + monedaConvertidaA + '\'' +
                ", valorDeMonedaConvertida= " + valorDeMonedaConvertida;
    }
}

