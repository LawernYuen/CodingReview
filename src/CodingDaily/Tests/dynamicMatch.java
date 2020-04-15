package CodingDaily.Tests;

import java.util.ArrayList;
import java.util.Scanner;
public class dynamicMatch {
    private static int[] times;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        ArrayList<String> strList = new ArrayList<>(k);
        ArrayList<String> strSet = new ArrayList<>();
        for (int i = 0; i < k; i++){
            String temp = in.next();
            strList.add(temp);
        }
        for (int i = 0; i < n; i++){
            times = new int[1];
            int ans = 0;
            String opt = in.next();
            if (opt.charAt(0) == '+'){
                int no = (opt.charAt(1)-'a'+49);
                String temp = strList.get(no);
                if (!strSet.contains(temp))
                    strSet.add(temp);
            }
            else if (opt.charAt(0) == '-'){
                int no = (opt.charAt(1)-'a'+49);
                String temp = strList.get(no);
                if (strSet.contains(temp))
                    strSet.remove(temp);
            }
            else {
                String str = opt.substring(1, opt.length());
                for (int j = 0; j < strSet.size(); j++){
                    if (containSub(str, strSet.get(j)))
                        ans += times[0];
                }
            }
            System.out.println(ans);
        }
    }
    private static boolean containSub(String MotherStr, String SonStr){
        for (int i = 0; i < MotherStr.length(); i++){
            if (MotherStr.charAt(i) == SonStr.charAt(0)){
                for (int j = 0; j < SonStr.length(); j++){

                }
            }
        }
        if (times[0] != 0)
            return true;
        else
            return false;
    }
}
