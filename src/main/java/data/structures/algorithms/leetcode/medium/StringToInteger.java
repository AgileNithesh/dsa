package data.structures.algorithms.leetcode.medium;

public class StringToInteger {


    /*
    Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.

    The algorithm for myAtoi(string s) is as follows:

    Whitespace: Ignore any leading whitespace (" ").
    Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity
    if neither present.
    Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered
    or the end of the string is reached. If no digits were read, then the result is 0.
    Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the
    integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and
    integers greater than 231 - 1 should be rounded to 231 - 1.
    */
    static void main() {
        IO.println(myAtoi("1873462879431"));
    }


    public static int myAtoi(String s) {

        int i = 0;
        long res = 0;
        int sign = 1;

        if(s.length() == 0){
            return 0;
        }

        // skip leading spaces
        while(i<s.length() && s.charAt(i) == ' '){
            i++;
        }

        if(i == s.length()) return 0;

        if(s.charAt(i) == '-'){
            sign = -1;
            i++;
        } else if(s.charAt(i) == '+'){
            i++;
        }

        while(i < s.length() && Character.isDigit(s.charAt(i))) {

            res = (res * 10) + (s.charAt(i) - '0');

            if(res * sign > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            } else if(res * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            i++;
        }
        return (int) (res * sign);

    }


    /*public static int myAtoi(String s) {

        s = s.trim();
        boolean negative = false;

        if (s.isEmpty()) {
            return 0;
        }


        StringBuilder digits = new StringBuilder();
        for (char c : s.toCharArray()) {
            if(c == '-'){
                if (digits.isEmpty()){
                    digits.append(c);
                    negative = true;
                }
            } else if (c == '+') {
                if (digits.isEmpty()) {
                    digits.append(c);
                }
            } else if (Character.isDigit(c)) {
                digits.append(c);
            } else {
                break;
            }
        }

        String digits_string = digits.toString();

        if(digits_string.isEmpty()){
            return 0;
        }

        try {
            return Integer.parseInt(digits_string);
        } catch (Exception e) {
            IO.print(e.getMessage());
            return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }


    }*/

    /*public static int myAtoi(String s) {

        s = s.trim();
        boolean negative = false;

        if (s.isEmpty()) {
            return 0;
        }

        if (s.charAt(0) == '-') {
            negative = true;
            s = s.substring(1);
        } else if(s.charAt(0) == '+'){
            s = s.substring(1);
        }

        StringBuilder digits = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                digits.append(c);
            } else {
                break;
            }
        }

        String digits_string = digits.toString();

        if(digits_string.isEmpty()){
            return 0;
        }

        try {
            int num = Integer.parseInt(digits_string);
            return negative ? -num : num;
        } catch (Exception e) {
            IO.print(e.getMessage());
            return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }


    }*/

}
