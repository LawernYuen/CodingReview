package CodingDaily.Tests;

import java.util.ArrayList;
import java.util.Scanner;

public class getInfo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String operate = in.next();
        String str = in.next();
        ArrayList<ArrayList<String>> ansList = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '[') {
                String currntOp = str.substring(start, i);
                if (currntOp.equals(operate)){
                    ArrayList<String> list = new ArrayList<>();
                    int j = i+1, innerStart = j;
                    while (true){
                        if (str.charAt(j) == '=')
                            innerStart = j + 1;
                        if (str.charAt(j) == ',' || str.charAt(j) == ']'){
                            String tempString = str.substring(innerStart, j);
                            list.add(tempString);
                        }
                        if (str.charAt(j) == ']')
                            break;
                        j++;
                    }
                    ansList.add(list);
                    start = j+2;
                    i = j+1;
                }
                else {
                    while (str.charAt(i) != ']')
                        i++;
                    start = i+2;
                    i++;
                }
            }
        }
        for (ArrayList<String> list : ansList) {
            for (String s : list) System.out.print(s + " ");
            System.out.println();
        }
        if (ansList.isEmpty())
            System.out.println("FAIL");
    }
}
