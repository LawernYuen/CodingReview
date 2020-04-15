package CodingDaily.Tests;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
public class moveCubes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int K = in.nextInt();
        int numColor = 0;
        int[] array = new int[num];
        for (int i = 0; i < num; i++){
            array[i] = in.nextInt();
            if (array[i] > numColor)
                numColor = array[i];
        }
        ArrayList<LinkedList<Integer>> cubeList = new ArrayList<>(numColor);
        for (int i = 0; i < numColor; i++)
            cubeList.add(new LinkedList<>());
        cubeList.get(0).add(1);
        int prev = array[0];
        int temp = 0;
        for (int j = 1; j <= numColor; j++) {
            for (int i = 1; i < num; i++) {
                if (j == array[i] && prev == array[i]) {
                    temp = cubeList.get(j-1).peek();
                    cubeList.get(j-1).remove(cubeList.get(j-1).size());
                    cubeList.get(j-1).add(++temp);
                }
                else if (j == array[i])
                    cubeList.get(j-1).add(1);
                else if (j != array[i] && prev == array[i])
                    cubeList.get(j-1).add(-1);
                else {
                    temp = cubeList.get(j-1).peek();
                    cubeList.get(j-1).remove(cubeList.get(j-1).size());
                    cubeList.get(j-1).add(--temp);
                }
            }
        }
    }
}
