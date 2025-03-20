package javaPrograms;

import java.util.HashMap;

public class Solution {

    public static int RomanToInt(String s) {
        // Create a map to store the Roman numeral characters and their corresponding integer values
        HashMap<Character, Integer> RomanMap = new HashMap<>();
        RomanMap.put('I', 1);
        RomanMap.put('V', 5);
        RomanMap.put('X', 10);
        RomanMap.put('L', 50);
        RomanMap.put('C', 100);
        RomanMap.put('D', 500);
        RomanMap.put('M', 1000);

        int result = 0;

        // Iterate through the string to calculate the integer value of the Roman numeral
        for (int i = 0; i < s.length(); i++) {
            int curValue = RomanMap.get(s.charAt(i));
            int nextVal = (i + 1 < s.length()) ? RomanMap.get(s.charAt(i + 1)) : 0;

            // If the current value is less than the next value, subtract the current value
            if (curValue < nextVal) {
                result -= curValue;
            } else {
                result += curValue;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Test the RomanToInt method with some examples
        System.out.println(Solution.RomanToInt("III"));      // Output: 3
        System.out.println(Solution.RomanToInt("LVIII"));    // Output: 58
        System.out.println(Solution.RomanToInt("MCMXCIV"));  // Output: 1994
    }
}
