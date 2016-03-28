package com.nishikinomaki;

/**
 * Created by nishikinomaki on 16/3/29.
 * https://leetcode.com/problems/palindrome-number/
 * Determine whether an integer is a palindrome. Do this without extra space.
 *
 Could negative integers be palindromes? (ie, -1)
 If you are thinking of converting the integer to string, note the restriction of using extra space.
 You could also try reversing an integer. However, if you have solved the problem "Reverse Integer",
 you know that the reversed integer might overflow. How would you handle such case?

 There is a more generic way of solving this problem.
 * 判断一个数是否是回文
 * 回文数是指一个对称数,比如13931
 * 负数不是回文数
 * 不能申请额外的内存空间
 * 反转整数,注意规避越界问题
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x){
        if(x < 0){
            return false;
        }
        if(x < 10){
            return true;
        }
        if(x / 10 == 0){
            return false; //尾数为0的不是回文
        }
        if(x < 100 && x % 11 == 0) { // 11 - 99,只有能被11整除的数才是回文
            return true;
        }
        long reverseBase = x;
        long reverse = 0;
        long removeLast;
        while (reverseBase > 0) {
            removeLast = reverseBase % 10;
            reverse = reverse * 10  + removeLast;//先进位,然后追加尾数
            reverseBase = reverseBase / 10;//移除个位
        }
        return reverse == x;
    }


    public static void main(String[] args) {
        Integer x = 1000110001;
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        System.out.println(palindromeNumber.isPalindrome(x));
    }
}
