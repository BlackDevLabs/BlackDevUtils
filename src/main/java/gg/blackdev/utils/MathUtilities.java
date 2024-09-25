package gg.blackdev.utils;

public class MathUtilities {

    // ========== Exponential Calculation ==========
    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    // ========== Square Root ==========
    public static double squareRoot(double number) {
        return Math.sqrt(number);
    }

    // ========== Trigonometric Functions ==========
    public static double sine(double angle) {
        return Math.sin(Math.toRadians(angle)); // Angle should be in degrees
    }

    public static double cosine(double angle) {
        return Math.cos(Math.toRadians(angle)); // Angle should be in degrees
    }

    public static double tangent(double angle) {
        return Math.tan(Math.toRadians(angle)); // Angle should be in degrees
    }

    // ========== Rounding ==========
    public static double roundToDecimalPlaces(double number, int decimalPlaces) {
        double factor = Math.pow(10, decimalPlaces);
        return Math.round(number * factor) / factor;
    }
}
