package CodingDaily.Tests;

import java.util.Scanner;
public class getNodeIdx {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        for (int i = 0; i < num; i++){
            long node = in.nextLong();
            int layer = in.nextInt();
            int layerNo = 0;
            if (layer == 1){
                System.out.println(1);
                continue;
            }
            long temp = node;
            while (temp != 0){
                temp = temp >> 1;
                layerNo++;
            }
            if (layer >= layerNo){
                System.out.println(-1);
                continue;
            }
            for (int j = layerNo; j > layer; j--)
                node = node >> 1;
            System.out.println(node);
        }
    }
}
