package org.hacker.rank.demo;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.*;


public class Hacker2 {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        Double input= sc.nextDouble();
        Locale localeUs = Locale.getDefault();//en-US
        Locale localeIn = new Locale(Locale.ENGLISH.getLanguage(),"IN");
        Locale localeFr = new Locale(Locale.FRENCH.getLanguage(),Locale.FRANCE.getCountry());
        Locale localeCh = new Locale(Locale.CHINESE.getLanguage(),Locale.CHINA.getCountry());
        List<Locale> listLocale= new ArrayList<>();
        listLocale = List.of(localeUs, localeIn, localeFr, localeCh);

        listLocale
                .stream()
                .forEach((locale) -> {
                    // Get the currency instance for the locale
                    Currency currency = Currency.getInstance(locale);
                    // Get the currency formatter for the locale
                    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
                    // Format the amount
                    String formattedAmount = currencyFormatter.format(input);
                    switch (locale.getDisplayCountry()){
                        case "United States":
                            System.out.println("US: " + formattedAmount);
                            break;
                        case "India":
                            System.out.println("India: " + formattedAmount);
                            break;
                        case "France":
                            System.out.println("France: " + formattedAmount);
                            break;
                        case "China":
                            System.out.println("China: " + formattedAmount);
                            break;
                    }
                });

    }
}


//PrepareJavaIntroductionJava Output Formatting
//Java Output Formatting
// Java's System.out.printf function can be used to print formatted output. The purpose of this exercise is to test your understanding of formatting output using printf.
//
//To get you started, a portion of the solution is provided for you in the editor; you must format and print the input to complete the solution.
//
//Input Format
//
//Every line of input will contain a String followed by an integer.
//Each String will have a maximum of  alphabetic characters, and each integer will be in the inclusive range from  to .
//
//Output Format
//
//In each line of output there should be two columns:
//The first column contains the String and is left justified using exactly  characters.
//The second column contains the integer, expressed in exactly  digits; if the original input has less than three digits, you must pad your output's leading digits with zeroes.
//
//Sample Input
//
//java 100
//cpp 65
//python 50
//Sample Output
//
//================================
//java           100
//cpp            065
//python         050
//================================
//Explanation
//
//Each String is left-justified with trailing whitespace through the first  characters. The leading digit of the integer is the  character, and each integer that was less than  digits now has leading zeroes.