package org.hacker.rank.demo;
import java.util.Scanner;

public class Hacker8 {
    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);
            try
            {
                int MIN_NEG_VALUE=-100;
//                int MIN_VALUE = 0;
                int MAX_VALUE = 100;
                String n=sc.next();
                int i = Integer.parseInt(n);
                if(i>=MIN_NEG_VALUE && i<=MAX_VALUE)
                {
                    System.out.println("Good Job");
                }
            }
            catch(Exception e)
            {
                System.out.println("Wrong answer");
            }

    }
}

//import java.util.*;
//import java.security.*;
//public class Solution {
// public static void main(String[] args) {
//
//  DoNotTerminate.forbidExit();
//
//  try {
//   Scanner in = new Scanner(System.in);
//   int n = in .nextInt();
//   in.close();
//   //String s=???; Complete this line below
//    String s=  String.valueOf(n);
//   //Write your code here
//        // Scanner sc = new Scanner(System.in);
//        // String s=in.next();
//        // int n;
//
//   if (n == Integer.parseInt(s)) {
//    System.out.println("Good job");
//   } else {
//    System.out.println("Wrong answer.");
//   }
//  } catch (DoNotTerminate.ExitTrappedException e) {
//   System.out.println("Unsuccessful Termination!!");
//  }
// }
//}
//
////The following class will prevent you from terminating the code using exit(0)!
//class DoNotTerminate {
//
// public static class ExitTrappedException extends SecurityException {
//
//  private static final long serialVersionUID = 1;
// }
//
// public static void forbidExit() {
//  final SecurityManager securityManager = new SecurityManager() {
//   @Override
//   public void checkPermission(Permission permission) {
//    if (permission.getName().contains("exitVM")) {
//     throw new ExitTrappedException();
//    }
//   }
//  };
//  System.setSecurityManager(securityManager);
// }
//}


