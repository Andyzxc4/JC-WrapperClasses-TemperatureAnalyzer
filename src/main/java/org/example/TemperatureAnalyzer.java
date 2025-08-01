package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TemperatureAnalyzer {
    public static void main(String[] args) {

        Scanner scanObj = new Scanner(System.in);

        double day1TempPrimitive = getValidTemperature(scanObj, "Enter Day 1 High Temperature (e.g., 28.5): ");
        double day2TempPrimitive = getValidTemperature(scanObj, "Enter Day 2 High Temperature (e.g., 28.5): ");
        double day3TempPrimitive = getValidTemperature(scanObj, "Enter Day 3 High Temperature (e.g., 28.5): ");

        System.out.println("\n===== Temperature Analysis =====");

        System.out.println("\nParsed Day 1 Temp (primitive double): " + day1TempPrimitive);
        System.out.println("Parsed Day 2 Temp (primitive double): " + day2TempPrimitive);

        // Convert primitives to Double wrapper objects
        Double day1TempWrapper = Double.valueOf(day1TempPrimitive);
        Double day2TempWrapper = Double.valueOf(day2TempPrimitive);
        Double day3TempWrapper = Double.valueOf(day3TempPrimitive);

        // compare Day 1 and Day 2 temperatures
        int comparison = day1TempWrapper.compareTo(day2TempWrapper);
        if (comparison == 0) {
            System.out.printf("\nDay 1 (%.1f°C) temp. was the same as Day 2 (%.1f°C) temp.", day1TempWrapper, day2TempPrimitive);
        } else if (comparison > 0) {
            System.out.printf("\nDay 1 (%.1f°C) temp. was warmer than Day 2 (%.1f°C) temp.", day1TempWrapper, day2TempPrimitive);
        } else {
            System.out.printf("\nDay 1 (%.1f°C) temp. was cooler than Day 2 (%.1f°C) temp.", day1TempWrapper, day2TempPrimitive);
        }

        // extract to float and int
        float day1TempFloat = day1TempWrapper.floatValue();
        int day2TempInt = day2TempWrapper.intValue();

        System.out.println("\n\nExtracted Day 1 Temp (primitive float from Double wrapper): " + day1TempFloat);
        System.out.println("Extracted Day 2 Temp (primitive int from Double wrapper, truncated): " + day2TempInt);

        ArrayList<Double> tempsWrapper = new ArrayList<>(Arrays.asList(
                day1TempWrapper, day2TempWrapper, day3TempWrapper));

        System.out.println("\nThe highest temperature recorded was: " + maxTemp(tempsWrapper) + "°C");

        scanObj.close();
    }

    // helper method to handle input parsing with retry
    public static double getValidTemperature(Scanner scanner, String prompt) {
        double temperature = 0.0;
        boolean valid = false;

        while (!valid) {
            System.out.print(prompt);
            String input = scanner.next();
            try {
                temperature = Double.parseDouble(input);
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid numeric temperature.");
            }
        }

        return temperature;
    }

    //  max temp method to get the max temp based on 3 dates
    public static Double maxTemp(ArrayList<Double> temps) {
        //  store first the initial value temp then compare later on to replace the highest/max temp
        Double maxTemp = temps.getFirst();

        // enhanced for loop to compare each of temps Double, if current temp is greater than maxTemp, it will replace.
        for (Double temp : temps) {
            if (temp.compareTo(maxTemp) > 0) {
                maxTemp = temp;
            }
        }

        //  return the maxTemp after enhanced for loop
        return maxTemp;
    }
}
