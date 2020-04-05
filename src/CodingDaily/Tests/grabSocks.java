package CodingDaily.Tests;

import java.util.Scanner;
public class grabSocks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numGroup = in.nextInt();
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int numColor = in.nextInt();
            int count = 0;
            int countSole = 0;
            while (numColor != 0){
                int currentNum = in.nextInt();
                if (currentNum >= 1)
                    count++;
                if (currentNum <= 1)
                    countSole++;
                numColor--;
            }
            if (countSole >= numColor)
                System.out.println(-1);
            else
                System.out.println(++count);
        }
    }
}
