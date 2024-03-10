package com.alura.conversor.temperatura;

public class ConvertirTemperatura {

    public double celsiusParaFahrenheit(int celsius) {
        // (celsius * 9/5) + 32; Sin casting to double
        return ((double) (celsius * 9) /5) + 32;
    }

    public double fahrenheitParaCelsius(int fahrenheit) {
        // (fahrenheit - 32) * 5/9; Sin casting to double
        return ((double) (fahrenheit - 32) * 5) / 9;
    }

    public double celsiusParaKelvin(int celsius) {
        // celsius + 273.15; Sin casting to double
        return (double) celsius + 273.15;
    }

    public double kelvinParaCelsius(int kelvin) {
        // kelvin - 273.15; Sin casting to double
        return (double) kelvin - 273.15;
    }

    public double fahrenheitParaKelvin(int fahrenheit) {
        // (fahrenheit - 32) * 5/9 + 273.15; Sin casting to double
        return ((double) (fahrenheit - 32) * 5) / 9 + 273.15;
    }

    public double kelvinParaFahrenheit(int kelvin) {
        // (kelvin - 273.15) * 9/5 + 32; Sin casting to double
        return ((double) (kelvin - 273.15) * 9) / 5 + 32;
    }
}