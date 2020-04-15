package CodingDaily.Tests;

import java.util.ArrayList;
import java.util.Scanner;
public class drawCards {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int NoCards = in.nextInt();
        ArrayList<Integer> times = new ArrayList<>(NoCards);
        ArrayList<Integer> money = new ArrayList<>(NoCards);
        for (int i = 0; i < NoCards; i++){
            Scanner temp = new Scanner(System.in);
            int temp1 = temp.nextInt();
            money.add(temp1);
            int temp2 = temp.nextInt();
            times.add(temp2);
        }
        int time = 1;
        int mon = 0;
        while (!times.isEmpty()){
            int max = getmax(times, money);
            time += times.get(max);
            mon += money.get(max);
            times.remove(max);
            money.remove(max);
            time--;
            if (time <= 0)
                break;
        }
        System.out.println(mon);
    }
    private static int getmax(ArrayList<Integer> times, ArrayList<Integer> money){
        int ans = 0;
        for (int i = 1; i < times.size(); i++){
            if (times.get(ans) < times.get(i))
                ans = i;
            else if (times.get(ans) == times.get(i))
                if (money.get(ans) < money.get(i))
                    ans = i;
        }
        return ans;
    }
}
