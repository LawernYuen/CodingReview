package CodingDaily.Tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
public class PalinGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int NoGroup = in.nextInt();
        ArrayList<String> strlist = new ArrayList<>(NoGroup);
        ArrayList<String> strlistO = new ArrayList<>(NoGroup);
        for (int i = 0; i < NoGroup; i++){
            InputStreamReader is = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(is);
            try{
                String str = br.readLine();
                strlistO.add(str);
            }
            catch(IOException e){
                e.printStackTrace();
            }
//            Scanner inS = new Scanner(System.in);
//            String str = inS.next();
        }
        for (int i = 0; i < NoGroup; i++){
            String str = strlistO.get(i);
            int NoOdd = 0;
            int[] table = new int[26];
            for (int j = 0; j < str.length(); j++){
                char temp1 = str.charAt(j);
                int temp2 = temp1 - '0' - 49;
                table[temp2]++;
            }
            for (int j = 0; j < 26; j++)
                if (table[j] % 2 != 0)
                    NoOdd++;
            if (NoOdd % 2 != 0 || NoOdd == 0)
                strlist.add("Cassidy");
            else
                strlist.add("Eleanore");
        }
        for (String strOut : strlist)
            System.out.println(strOut);
    }
}
