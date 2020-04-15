package CodingDaily.Tests;

import java.util.Scanner;
public class luckyNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int K = in.nextInt();
        int sum = 0;
        int[] lotNum = new int[num];
        int[] times = new int[10];
        int theone = 0;
        int loss = 0;
        int gap = 1;
        for (int i = 0; i < num; i++){
            lotNum[i] = in.nextInt();
            sum += lotNum[i];
            times[lotNum[i]]++;
        }
        int mean = sum / num;
        for (int i = 1; i < 10; i++){
            if (times[theone] < times[i])
                theone = i;
            else if (times[theone] == times[i])
                if (Math.abs(mean-theone) > Math.abs(mean-i))
                    theone = i;
        }
        while (K > 0){
            for (int i = 0; i < num; i++){
                if (Math.abs(lotNum[i]-theone) == gap){
                    lotNum[i] = theone;
                    loss += gap;
                    K--;
                }
            }
            gap++;
        }
        System.out.println(loss);
        for (int i = 0; i < num; i++)
            System.out.print(lotNum[i]);
    }
}
