package CodingDaily.Tests;

import java.util.ArrayList;
import java.util.Scanner;

public class FuncStack {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] callCount = new int[n];
        int[] size = new int[n];
        ArrayList<ArrayList<Integer>> allList = new ArrayList<>(n);
        boolean[] isEntrance = new boolean[n];
        for (int i = 0; i < n; i++) {
            callCount[i] = in.nextInt();
            isEntrance[i] = true;
        }
        for (int i = 0; i < n; i++){
            ArrayList<Integer> list = new ArrayList<>();
            int temp = in.nextInt();
            size[i] = in.nextInt();
            for (int j = 0; j < callCount[i]; j++){
                int tempp = in.nextInt();
                isEntrance[tempp-1] = false;
                list.add(tempp);
            }
            allList.add(list);
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            int currentSize = 0;
            if (isEntrance[i]){
                currentSize += size[i];
                ArrayList<Integer> currentList = allList.get(i);
                if (currentList.isEmpty())
                    ans = Math.max(ans, currentSize);
                else {
                    int temp = 0;
                    for (int j = 0; j < currentList.size(); j++) {
                        temp = getNext(allList, currentList.get(j) - 1, size);
                        ans = Math.max(ans, temp);
                    }
                    ans += temp;
                }
            }
        }
        System.out.println(ans);
    }
    private static int getNext(ArrayList<ArrayList<Integer>> allList, int idx, int[] size){
        ArrayList<Integer> currentList = allList.get(idx);
        if (currentList.isEmpty())
            return size[idx];
        int count = size[idx];
        int ans = 0;
        for (int i = 0; i < currentList.size(); i++){
            int temp = getNext(allList, currentList.get(i)-1, size);
            ans = Math.max(ans, temp);
        }
        return count+ans;
    }
}
