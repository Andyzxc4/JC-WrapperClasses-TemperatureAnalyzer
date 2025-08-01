package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TemperatureAnalyzer {
    public static void main(String[] args) {

        //  scanner object
        Scanner scanObj = new Scanner(System.in);

        System.out.print("Enter Day 1 High Temperature (e.g., 28.5): ");
        String day1TempStr = scanObj.next();

        System.out.print("Enter Day 2 High Temperature (e.g., 28.5): ");
        String day2TempStr = scanObj.next();

        System.out.print("Enter Day 3 High Temperature (e.g., 28.5): ");
        String day3TempStr = scanObj.next();

        System.out.println("\n===== Temperature Analysis =====");
        try {
            //  convert String temp to double primitive type using Double.parseDouble method
            double day1TempPrimitive = Double.parseDouble(day1TempStr);
            double day2TempPrimitive = Double.parseDouble(day2TempStr);
            double day3TempPrimitive = Double.parseDouble(day3TempStr);

            System.out.println("\nParsed Day 1 Temp (primitive double): " + day1TempPrimitive);
            System.out.println("Parsed Day 2 Temp (primitive double): " + day2TempPrimitive);

            /*
                convert primitive temps (double) to Double Wrapper Object using valueOf() method.
                we can set them directly, since Java will do autoboxing implicitly.
                for the purpose of the activity, we use valueOf() to convert/unbox to Double wrapper
             */
            Double day1TempWrapper = Double.valueOf(day1TempPrimitive);
            Double day2TempWrapper = Double.valueOf(day2TempPrimitive);
            Double day3TempWrapper = Double.valueOf(day3TempPrimitive);

            if(day1TempWrapper.compareTo(day2TempWrapper) == 0) {
                System.out.printf("\nDay 1 (%s) temp. was same to Day 2 (%s) temp.", day1TempWrapper, day2TempPrimitive);
            } else if(day1TempWrapper.compareTo(day2TempWrapper) > 0) {
                System.out.printf("\nDay 1 (%s) temp. was warmer than Day 2 (%s) temp.", day1TempWrapper, day2TempPrimitive);
            } else if(day1TempWrapper.compareTo(day2TempWrapper) < 0) {
                System.out.printf("\nDay 1 (%s) temp. was cooler than Day 2 (%s) temp.", day1TempWrapper, day2TempPrimitive);
            }

            float day1TempFloat = day1TempWrapper.floatValue();
            int day1TempInt = day2TempWrapper.intValue();

            System.out.println("\n\nExtracted Day 1 Temp (primitive float from Double wrapper): " + day1TempFloat);
            System.out.println("\nExtracted Day 2 Temp (primitive int from Double wrapper, truncated): " + day1TempInt);

            ArrayList<Double> tempsWrapper = new ArrayList<>(Arrays.asList(
                    day1TempWrapper, day2TempWrapper, day3TempWrapper));

            System.out.println("\nThe highest temperature recorded was: " + maxTemp(tempsWrapper));

        } catch (NumberFormatException e) {
            System.out.println("Invalid Input(s). You can't input a String/Characters for temperature...");
        }

        // close scanner object
        scanObj.close();
    }

    public static Double maxTemp(ArrayList<Double> temps) {
        Double maxTemp = temps.getFirst();

        for (Double temp : temps) {
            if (temp.compareTo(maxTemp) > 0) {
                maxTemp = temp;
            }
        }

        return maxTemp;

    }
}