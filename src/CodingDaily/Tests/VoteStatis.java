package CodingDaily.Tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class VoteStatis {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        HashMap<String, Integer> map = new HashMap<>();
        int start = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == ',' || i == str.length()-1) {
                String temp = str.charAt(i) == ',' ? str.substring(start, i) : str.substring(start, i+1);
                start = i + 1;
                if (!map.containsKey(temp))
                    map.put(temp, 1);
                else {
                    int count = map.get(temp);
                    map.put(temp, count+1);
                }
            }
        }
        int max = 0;
        for (int i : map.values())
            if (max < i)
                max = i;
        ArrayList<String> list = new ArrayList<>();
        for (String string : map.keySet()) {
            if (!(string.charAt(0) <= 'Z' && string.charAt(0) >= 'A')){
                System.out.println("error.0001");
                return;
            }
            if (map.get(string) == max)
                list.add(string);
        }
        String ans = "ZZZZZZZZZZZZZZZZZZZ";
        for (String string : list) {
            if (string.charAt(0) < ans.charAt(0))
                ans = string;
            else if (string.charAt(0) == ans.charAt(0))
                ans = string.length()>ans.length() ? ans : string;
        }
        System.out.println(ans);
    }
}
