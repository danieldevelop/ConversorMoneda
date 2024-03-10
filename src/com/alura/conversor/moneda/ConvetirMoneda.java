package com.alura.conversor.moneda;

public class ConvetirMoneda {
    private double monedaPesos;

    public double PesosADolares(double valor) {
        double monedaDolar = valor / TasaConversion.TASA_CONVERSION_DOLAR;
        return (double) Math.round(monedaDolar * 100d) / 100;
    }

    public double PesosAEuro(double valor) {
        double monedaEuro = valor / TasaConversion.TASA_CONVERSION_EURO;
        return (double) Math.round(monedaEuro * 100d) / 100;
    }

    public double PesosALibra(double valor) {
        double monedaLibra = valor / TasaConversion.TASA_CONVERSION_LIBRA;
        return (double) Math.round(monedaLibra * 100d) / 100;
    }

    public double PesosAYen(double valor) {
        double monedaYen = valor / TasaConversion.TASA_CONVERSION_YEN;
        return (double) Math.round(monedaYen * 100d) / 100;
    }

    public double PesosAWonCoreano(double valor) {
        double monedaWonCoreano = valor / TasaConversion.TASA_CONVERSION_WON_COREANO;
        return (double) Math.round(monedaWonCoreano * 100d) / 100;
    }

    public double DolaresAPesos(double valor) {
        monedaPesos = TasaConversion.TASA_CONVERSION_DOLAR * valor;
        return (double) Math.round(monedaPesos * 100d) / 100;
    }

    public double EuroAPesos(double valor) {
        monedaPesos = TasaConversion.TASA_CONVERSION_EURO * valor;
        return (double) Math.round(monedaPesos * 100d) / 100;
    }

    public double LibreAPesos(double valor) {
        monedaPesos = TasaConversion.TASA_CONVERSION_LIBRA * valor;
        return (double) Math.round(monedaPesos * 100d) / 100;
    }

    public double YenAPesos(double valor) {
        monedaPesos = TasaConversion.TASA_CONVERSION_YEN * valor;
        return (double) Math.round(monedaPesos * 100d) / 100;
    }

    public double WonCoreanoAPesos(double valor) {
        monedaPesos = TasaConversion.TASA_CONVERSION_WON_COREANO * valor;
        return (double) Math.round(monedaPesos * 100d) / 100;
    }
}
