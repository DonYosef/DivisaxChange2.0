package com.example.divisaxchange.controllers;

public class CalculoDivisas {

    public Double convercionDeMoneda(Double rate, Double base){
        double resultado = rate * base;
        return resultado;
    }

    public static double redondear(double numero) {

        double numeroMultiplicado = numero * 100;
        int parteEntera = (int) numeroMultiplicado;
        double parteDecimal = numeroMultiplicado - parteEntera;

        if (parteDecimal >= 0.5) {
            return (parteEntera / 100.0) + 0.01; // Redondear hacia arriba
        } else {
            return parteEntera / 100.0; // Redondear hacia abajo
        }
    }

    public static int redondearSinDecimal(double numero) {
        double numeroMultiplicado = numero * 100;
        int parteEntera = (int) numeroMultiplicado;
        double parteDecimal = numeroMultiplicado - parteEntera;

        if (parteDecimal >= 0.5) {
            return (int) Math.ceil(numero); // Redondear hacia arriba
        } else {
            return (int) Math.floor(numero); // Redondear hacia abajo
        }
    }

}
