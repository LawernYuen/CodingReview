package CodingDaily.Tests;

import java.util.LinkedList;
import java.util.Scanner;
public class selfQueue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numGroup = in.nextInt();
        for (int i = 0; i < numGroup; i++){
            int num = in.nextInt();
            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j < num; j++){
                String str = in.next();
                String opt = str.substring(0, 3);
                if (opt.equals("PUS")) {
                    int temp = in.nextInt();
                    list.add(temp);
                }
                else if (opt.equals("TOP")){
                    if (list.size() <= 0)
                        System.out.println(-1);
                    else
                        System.out.println(list.get(0));
                }
                else if (opt.equals("POP")){
                    if (list.size() <= 0)
                        System.out.println(-1);
                    else
                        list.remove(0);
                }
                else if (opt.equals("SIZ"))
                    System.out.println(list.size());
                else if (opt.equals("CLE"))
                    list.clear();
            }
        }
    }
}
