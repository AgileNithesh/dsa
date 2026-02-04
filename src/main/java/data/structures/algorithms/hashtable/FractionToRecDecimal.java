package data.structures.algorithms.hashtable;

import java.sql.Struct;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FractionToRecDecimal {

    /**
     *
     * Given two integers representing the numerator and denominator of a fraction,
     * return the fraction in string format.
     * If the fractional part is repeating, enclose the repeating part in parentheses
     * If multiple answers are possible, return any of them.
     * It is guaranteed that the length of the answer string is less than 104 for all the given inputs.
     * Note that if the fraction can be represented as a finite length string, you must return it.
     *
     * Example 1:
     *
     * Input: numerator = 1, denominator = 2
     * Output: "0.5"
     * Example 2:
     *
     * Input: numerator = 2, denominator = 1
     * Output: "2"
     * Example 3:
     *
     * Input: numerator = 4, denominator = 333
     * Output: "0.(012)"
     *
     */

    static void main() {
        IO.println(fractionToDecimal(-1,-2147483648));
    }

    public static String fractionToDecimal(int numerator, int denominator) {

        StringBuilder result = new StringBuilder();

        // only either of them is negative
        if((numerator < 0) ^ (denominator < 0)) result.append("-");

        // bcz Math.abs(-2147483648) --> stays negative since the positive range is only till 2147483647
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        long rem = num % den;

        // integer part
        result.append(numerator/denominator);

        if(rem == 0) return result.toString();

        Map<Long, Integer> map = new HashMap<>();
        result.append(".");
        while(rem !=0){

            if(map.containsKey(rem)) {

                result.insert(map.get(rem),"(");
                result.append(")");
                break;
            }

            map.put(rem, result.length());
            rem = rem * 10;
            result.append(rem/den);
            rem = rem % den;

        }

        return result.toString();
    }

}
