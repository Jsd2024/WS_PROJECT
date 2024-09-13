package org.hacker.rank.demo;

import java.util.Scanner;

public class Hacker5 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int c =0;
//        for(int i =1; i<=3; i++) {
        while (!in.hasNextInt()){
            System.out.println((c+1)+" "+in.nextLine());
            c++;
        }
    }
}
