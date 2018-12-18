package com.yishai.baseconverteractivity;
/**
 * Created by Yishai 308396761
 */

public class BaseConverter {
     private static char symbols[] = new char[] { '0','1','2','3','4','5','6','7','8','9',
             'A','B','C','D','E','F','G','H','I','J','K','L','M',
             'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'}; // Mark the numbers above base 10
    public static String convertFrom10(int num, int base) {
        return convert(num, base, 0, "");
        }
        private static String convert(int number, int base, int position, String result) { // recursion method
        if (number < Math.pow(base, position + 1)) {
            return symbols[(number / (int) Math.pow(base, position))] + result; //return String
        }
        else
            {
            int remainder = (number % (int) Math.pow(base, position + 1));
            return convert(number - remainder, base, position + 1,
                    symbols[remainder / (int) (Math.pow(base, position))] + result);
        }
    }
}
