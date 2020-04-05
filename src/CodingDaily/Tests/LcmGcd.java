package CodingDaily.Tests;

import java.util.Scanner;

public class LcmGcd {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int num = in.nextInt();
            if (num == 1)
                System.out.println(1);
            else
                System.out.println(num*(num-1)-1);
        }
    }
}
