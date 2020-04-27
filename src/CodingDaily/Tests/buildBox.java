package CodingDaily.Tests;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class buildBox {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int numGroup = in.nextInt();
        for (int i = 0; i < numGroup; i++){
            HashMap<Integer, Integer> map = new HashMap<>();
            HashMap<Integer, Integer> timesMap = new HashMap<>();
            for (int j = 0; j < 6; j++) {
                int temp1 = in.nextInt();
                int temp2 = in.nextInt();
                if (temp1 == 0 || temp2 == 0) {
                    System.out.println("IMPOSSIBLE");
                    return;
                }
                int temp3 = temp1 + temp2;
                addEntry(map, temp1);
                addEntry(map, temp2);
                addEntry(timesMap, temp3);
            }
            Set<Integer> set = map.keySet();
            Set<Integer> timesset = timesMap.keySet();
            if (set.size() > 3 || timesset.size() > 3) {
                System.out.println("IMPOSSIBLE");
                return;
            }
            else {
                for (int no : set){
                    int count = map.get(no);
                    if (count % 4 != 0) {
                        System.out.println("IMPOSSIBLE");
                        return;
                    }
                }
                for (int no : timesset){
                    int count = timesMap.get(no);
                    if (count % 2 != 0) {
                        System.out.println("IMPOSSIBLE");
                        return;
                    }
                }
                System.out.println("POSSIBLE");
            }
        }
    }
    private static void addEntry(HashMap<Integer, Integer> map, int key){
        if (!map.containsKey(key))
            map.put(key, 1);
        else {
            int times = map.get(key);
            map.put(key, times + 1);
        }
    }
}
