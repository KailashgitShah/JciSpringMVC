package com.jci.controller;

import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class ConvertWord_k {

    public String convertDigitToWord(int digit) {
        if (digit < 0 || digit > 9) {
            return "Invalid digit";
        }

        String[] digitsInWords = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        return digitsInWords[digit];
    }

    public String convertGroup(int group) {
        if (group == 0) {
            return ""; // Return empty string for zero group
        }

        StringBuilder groupWords = new StringBuilder();
        int hundreds = group / 100;
        int tensOnes = group % 100;

        if (hundreds > 0) {
            groupWords.append(convertDigitToWord(hundreds)).append(" hundred ");
        }

        if (tensOnes > 0) {
            if (tensOnes < 20) {
                groupWords.append(convertToWordsBelowTwenty(tensOnes));
            } else {
                int tens = tensOnes / 10;
                int ones = tensOnes % 10;
                if (tens > 0) {
                    String[] tensInWords = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
                    groupWords.append(tensInWords[tens]);
                }
                if (ones > 0) {
                    groupWords.append(" ");
                    groupWords.append(convertDigitToWord(ones));
                }
            }
        }

        return groupWords.toString().trim();
    }

    private String convertToWordsBelowTwenty(int number) {
        String[] wordsBelowTwenty = {
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
        };
        return wordsBelowTwenty[number];
    }

    public String convertToWords(long number) {
        if (number < 0) {
            return "minus " + convertToWords(-number); // Handle negative numbers
        }
        if (number == 0) {
            return "Zero"; // Handle zero separately
        }

        // Define a HashMap mapping place values and their corresponding words (in English)
        Map<Integer, String> placeValuesMap = new HashMap<>();
        placeValuesMap.put(3, "thousand");
        placeValuesMap.put(5, "lakh");
        placeValuesMap.put(7, "crore");

        StringBuilder words = new StringBuilder();

        // Process the number in chunks of two or three digits
        int chunkSize = 2;
        int i = 0; // Counter for place values
        boolean firstChunk = true;
        while (number > 0) {
            int chunk;
            if (firstChunk) {
                chunk = (int) (number % 1000); // Extract the last three digits for the first chunk
                firstChunk = false;
                chunkSize = 3;
            } else {
                chunk = (int) (number % 100); // Extract the last two digits for subsequent chunks
            }
            number /= chunkSize == 3 ? 1000 : 100; // Remove the last two or three digits from the number

            if (chunk > 0) {
                String groupWords = convertGroup(chunk);
                if (!groupWords.isEmpty()) {
                    words.insert(0, groupWords + " " + placeValuesMap.getOrDefault(i, "") + " ");
                }
            }
            i += chunkSize; // Increment the counter for the next chunk
            chunkSize = 2; // From now on, process chunks of two digits
        }

        return words.toString().trim();
    }

    public String convertDecimalPartToWords(String decimalPart) {
        StringBuilder words = new StringBuilder("point");
        for (char digitChar : decimalPart.toCharArray()) {
            int digit = Character.getNumericValue(digitChar);
            if (digit < 0 || digit > 9) {
                return "Invalid digit";
            }
            words.append(" ").append(convertDigitToWord(digit));
        }
        return words.toString();
    }

    public String convertNumberToWords(double number) {
        long integerPart = (long) number;
        String words = convertToWords(integerPart);

        String decimalPart = String.valueOf(number).split("\\.")[1];
        if (!decimalPart.equals("0")) {
            words += " " + convertDecimalPartToWords(decimalPart);
        }

        return words.trim();
    }

    public String convertNumberToCurrencyWords(double number) {
        String words = convertNumberToWords(number);
        return "Rupees " + words;
    }
}
