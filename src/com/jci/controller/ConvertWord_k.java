package com.jci.controller;

import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map; 

@Component
public class ConvertWord_k {
  public  String convertDigitToWord(int digit) {
	        if (digit < 0 || digit > 9) {
	            return "Invalid digit";
	        }

	        String[] digitsInWords = {"zero", "one", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
	        return digitsInWords[digit];
	    }

	    public  String convertGroup(int group) {
	        if (group == 0) {
	            return ""; // Return empty string for zero group
	        }

	        StringBuilder groupWords = new StringBuilder();
	        int hundreds = group / 100;
	        int tensOnes = group % 100;

	        if (hundreds > 0) {
	            groupWords.append(convertDigitToWord(hundreds)).append(" Hundred ");
	        }

	        if (tensOnes > 0) {
	            if (tensOnes < 20) {
	                groupWords.append(convertDigitToWord(tensOnes));
	            } else {
	                int tens = tensOnes / 10;
	                int ones = tensOnes % 10;
	                if (tens > 0) {
	                    groupWords.append(convertDigitToWord(tens) + "ty ");
	                }
	                if (ones > 0) {
	                    groupWords.append(convertDigitToWord(ones));
	                }
	            }
	        }

	        return groupWords.toString().trim();
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
	        placeValuesMap.put(3, "Thousand");
	        placeValuesMap.put(6, "Million");
	        placeValuesMap.put(9, "Billion");
	        placeValuesMap.put(12, "Trillion");

	        StringBuilder words = new StringBuilder();

	        // Process the number in chunks of three digits
	        int chunkSize = 3;
	        int i = 0; // Counter for place values
	        while (number > 0) {
	            int chunk = (int) (number % 1000); // Extract the last three digits
	            number /= 1000; // Remove the last three digits from the number

	            if (chunk > 0) {
	                String groupWords = convertGroup(chunk);
	                if (!groupWords.isEmpty()) {
	                    words.insert(0, groupWords + " " + placeValuesMap.getOrDefault(i, "") + " ");
	                }
	            }
	            i += chunkSize; // Increment the counter for the next chunk
	        }

	        return words.toString().trim();
	    }

	   
	

	}



