package org.anasantana.utils;

import java.util.regex.Pattern;

public class CarValidator {

    private static final Pattern PLATE_PATTERN = Pattern.compile("^[A-Z]{3}[0-9][A-Z0-9][0-9]{2}$");

    public static boolean isValidPlate(String plate) {
        return plate != null && PLATE_PATTERN.matcher(plate).matches();
    }

    public static boolean isValidYear(int year) {
        return year >= 1886 && year <= java.time.Year.now().getValue(); // ano do primeiro carro até hoje
    }

    public static boolean isValidChassis(String chassis) {
        return chassis != null && chassis.length() >= 10; // exemplo simples
    }
}
