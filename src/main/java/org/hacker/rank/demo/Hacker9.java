package org.hacker.rank.demo;
import java.io.*;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Hacker9 {
    public static void main(String []argh) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(("C:\\Users\\aninmazu\\git\\WS_PROJECT\\src\\main\\resources\\out.txt")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int month = Integer.parseInt(firstMultipleInput[0]);

        int day = Integer.parseInt(firstMultipleInput[1]);

        int year = Integer.parseInt(firstMultipleInput[2]);

        String res = Result.findDay(month, day, year);

        bufferedWriter.write(res);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }


}
class Result {

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */

    public static String findDay(int month, int day, int year) {
        String reultDayOfWeek = null;
        try {
            // Construct the date string in the format "dd-MM-yyyy"
            String dateString = String.format("%02d-%02d-%04d", day, month, year);
            // Define the date format that matches the constructed date string
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            // Parse the date string into a Date object
            Date date = simpleDateFormat.parse(dateString);
            // Output the Date object
            SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE", Locale.ENGLISH);
            reultDayOfWeek = dayFormat.format(date);
        } catch (ParseException e) {
            // Handle exception if parsing fails
            System.out.println("Invalid date format: " + e.getMessage());
        }

        return reultDayOfWeek.toUpperCase();
    }

}

