import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args){
        ArrayList<String> list = new ArrayList<String>();
        list.add("Lucy");
        list.add("Tom");
        list.add("Tommy");
        list.add("To");
        list.add("lucy");
        System.out.println(list);//[c, b, d, a]
        Collections.sort(list);//��list���Ͻ�������
        System.out.println(list);
        char ch = '��';
        System.out.println(ch);
    }
}