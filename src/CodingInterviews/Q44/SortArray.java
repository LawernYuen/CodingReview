import java.util.ArrayList;
import java.util.Collections;

public class SortArray{
    public String pringMinNum(int[] num){
        if (num == null || num.length <= 0)
            return "";
        ArrayList<String> list = new ArrayList<String>();
        for (int n : num)
            list.add(String.valueOf(number));
        Collections.sort(list, new Comparator<String>(){
            public int compare(String s1, String s2){
                String a = s1 + s2;
                String b = s2 + s1;
                return a.compareTo(b);
            }
        });
        StringBuilder str = new StringBuilder();
        for (String s : list)
            s.append(s);
        return str.toString();
    }
}