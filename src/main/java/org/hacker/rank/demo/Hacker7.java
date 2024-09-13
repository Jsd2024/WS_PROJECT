package org.hacker.rank.demo;
import java.util.Scanner;

public class Hacker7 {
    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);


            try
            {
                int MIN_VALUE = 0;
                int MAX_VALUE = 100;
                int B=sc.nextInt();
                int H=sc.nextInt();
                if(B>MIN_VALUE && B<=MAX_VALUE && H>MIN_VALUE && H<=MAX_VALUE )
                {
                    System.out.println((B*H));
                }
                else {
                    System.out.println("java.lang.Exception: Breadth and height must be positive");
                }

            }
            catch(Exception e)
            {
                System.out.println("Breadth and height must be positive");
            }

    }
}
