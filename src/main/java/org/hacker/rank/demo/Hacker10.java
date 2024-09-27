package org.hacker.rank.demo;
//import org.apache.commons.lang3.ObjectUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Hacker10 {
    public static void main(String []argh)
    {
        Scanner in = new Scanner(System.in);
            try
            {
//                String S = in.next();
//                int start = in.nextInt();
//                int end = in.nextInt();
//                String sub = S.substring(start, end);
//                System.out.println(sub);

                //2=2*(2-1);
                //Bx=B*Bx-1//2^3=2*(2*2)//x=2,B=2
                //x=0,B=2, B^0=1=2*(2^0-0)=2
                //x=1,B=2, B^1=2=2*(2^1-1)=2

                //x=2,B=2, B^2=2^2=2*(2^2-1)
                //Xm-->output.m=x

                int B = 2; // Base value
                int x = 3; // Exponent
                int result = calculateBx(B, x);

                System.out.println(B + "^" + x + " = " + result);
            }
            catch(Exception e)
            {
                System.out.println("Wrong answer");
            }
    }
    public static int calculateBx(int B, int x) {
        System.out.println("Bx = "+B+"^"+x);

        if (x == 0) {
            return 1; // Base case: B^0 = 1
        }
        return B * calculateBx(B, x - 1); // Recursive call
    }
}

//PrepareJavaStringsJava Strings Introduction
// https://www.hackerrank.com/challenges/java-strings-introduction/problem?isFullScreen=true
// Given a string, , and two indices,  and , print a substring consisting of all characters in the inclusive range from  to . You'll find the String class' substring method helpful in completing this challenge.
//
//Input Format
//
//The first line contains a single string denoting .
//The second line contains two space-separated integers denoting the respective values of  and .
//
//Constraints
//
//String  consists of English alphabetic letters (i.e., ) only.
//Output Format
//
//Print the substring in the inclusive range from  to .
//
//Sample Input
//
//Helloworld
//3 7
//Sample Output
//
//lowo
//Explanation
//
//In the diagram below, the substring is highlighted in green: