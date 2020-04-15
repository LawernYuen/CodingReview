package CodingDaily.Tests;

import java.util.Scanner;

public class timeBefore {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int week = in.nextInt();
        String time = in.next();
        int gap = in.nextInt();
        int gapHour = gap / 60;
        int gapMin = gap % 60;
        int gapDay = gap / (24*60);
        int currentHr = (time.charAt(0)-'a'+49)*10 + (time.charAt(1)-'a'+49);
        int currentMin = (time.charAt(3)-'a'+49)*10 + (time.charAt(4)-'a'+49);
        if (currentHr >= gapHour){
            if (currentMin >= gapMin){
                System.out.println(week);
                System.out.print(currentHr-gapHour);
                System.out.print(":");
                System.out.println(currentMin-gapMin);
            }
            else {
                System.out.println(week);
                System.out.print(currentHr-gapHour-1);
                System.out.print(":");
                System.out.println(currentMin+60-gapMin);
            }
        }
        else {
            if (currentMin >= gapMin){
                System.out.println(week-gapDay);
                System.out.print(currentHr+24-gapHour);
                System.out.print(":");
                System.out.println(currentMin-gapMin);
            }
            else {
                System.out.println(week-gapDay);
                System.out.print(currentHr+24-gapHour-1);
                System.out.print(":");
                System.out.println(currentMin+60-gapMin);
            }
        }
    }
}
