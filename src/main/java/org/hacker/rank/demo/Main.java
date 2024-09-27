package org.hacker.rank.demo;

//import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.Optional;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    @Autowired
    RestTemplate rs;
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");
        ResponseEntity<Hacker1> response = new ResponseEntity<>( new Hacker1(),HttpStatus.OK);
        if(response.hasBody() && Optional.ofNullable(response.getBody()).isPresent())
        {
            String[] words = new String[10];

            Optional<String> checkNull = Optional.ofNullable(words[5]);

            if (checkNull.isPresent()) {
                String word = words[5].toLowerCase();
                System.out.print(word+response);
            }
            else
                System.out.println("word is null"+response);
        }
        else
        {
            System.out.println("response is null"+response);
        }

//[1]
//		Scanner scan = new Scanner(System.in);
//		String[] vars = new String[3];
//		for(int i = 0; i < vars.length; i++) {
//			vars[i] = scan.next();
//		}
//		for (String var : vars) {
//			boolean b = var.chars().allMatch(Character::isDigit);
//			if (checkInt(var)) {
//				System.out.println("scan :");
//				System.out.println(var);
//			}
//		}
//[2]
//		Scanner sc=new Scanner(System.in);
//		int x=sc.nextInt();
//		double y=sc.nextDouble();
//		sc.nextLine();
//		String s=sc.nextLine();
//		System.out.println("String: "+s);
//		System.out.println("Double: "+y);
//		System.out.println("Int: "+x);



        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }

    private static boolean checkInt(String arg) {
        try {

            Integer.parseInt(arg);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}