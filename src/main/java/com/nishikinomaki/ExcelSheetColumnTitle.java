package com.nishikinomaki;
/**
 * Copyright by fenqile.com
 *
 * @author Jax
 * @version 2016/3/11.
 *
 * @see {https://leetcode.com/problems/excel-sheet-column-title/}
 * 168. Excel Sheet Column Title My Submissions Question
 *
    Given a positive integer, return its corresponding column title as appear in an Excel sheet.

    For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB

    解题关键:26进制
 */
public class ExcelSheetColumnTitle {

    private static final String[] asciiWords = new String[26];

    static {
        int asciiA = 65;
        for (int i = 0; i < asciiWords.length ; i++  ) {
            int ascii = asciiA + i;
            asciiWords[i] = "" + (char)ascii;
        }
    }

    public String convertToTitle(int n){

        if (n <= 0) {
            throw new RuntimeException("param n must greater than zero");
        }

        String result = "";
        String word = "";
        while (n > 0) {
            int remainder = n % 26;
            if (remainder == 0)
                remainder = 26;
            word = asciiWords[remainder - 1];
            result = word + result;
            n = (n - 1) / 26;
        }
        return result;
    }

    public static void main(String[] args) {

        ExcelSheetColumnTitle testExcel = new ExcelSheetColumnTitle();
        for(int n=1; n < 500 ; n++){
            System.out.println(testExcel.convertToTitle(n));
        }
    }
}
