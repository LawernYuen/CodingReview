package CodingDaily.Tests;

import java.util.Scanner;
public class shortestPath {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numGroups = in.nextInt();
        double min = Integer.MAX_VALUE;
        for (int i = 0; i < numGroups; i++){
            int num = in.nextInt();
            long[][] A = new long[num][2];
            for (int j = 0; j < num; j++){
                A[j][0] = in.nextLong();
                A[j][1] = in.nextLong();
            }
            for (int j = 0; j < num; j++){
                long b0 = in.nextLong();
                long b1 = in.nextLong();
                for (int k = 0; k < num; k++) {
                    if (min != 0) {
                        double temp = Math.sqrt(Math.pow(A[k][0] - b0, 2) + Math.pow(A[k][1] - b1, 2));
                        if (temp < min)
                            min = temp;
                    }
                }
            }
            int temp = (int)(min*1000);
            StringBuilder str = new StringBuilder();
            if (temp == 0){
                System.out.println("0.000");
                continue;
            }
            char idx1 = (char)(temp-temp/10*10 + '0');
            str.insert(0, idx1);
            temp = temp / 10;
            if (temp == 0){
                str.insert(0, "0.00");
                System.out.println(str);
                continue;
            }
            char idx2 = (char)(temp-temp/10*10 + '0');
            str.insert(0, idx2);
            temp = temp / 10;
            if (temp == 0){
                str.insert(0, "0.0");
                System.out.println(str);
                continue;
            }
            char idx3 = (char)(temp-temp/10*10 + '0');
            str.insert(0, idx3);
            temp = temp / 10;
            if (temp == 0){
                str.insert(0, "0.");
                System.out.println(str);
                continue;
            }
            char idx4 = (char)(temp-temp/10*10 + '0');
            str.insert(0, '.');
            str.insert(0, idx4);
            System.out.println(str);
        }
    }
}
