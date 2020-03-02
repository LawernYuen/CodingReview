import java.util.ArrayList;

public class Permutation{
    public ArrayList<String> permutation(String str){
        ArrayList<String> list = new ArrayList<String>();
        if (str == null || str.length() == 0)
            return list;
        permutationCore(str.toCharArray(), 0, list);
        return list;
    }

    private void permutationCore(char[] str, int index, ArrayList<String> list){
        if (index == str.length-1) {
            if (!list.contains(String.valueOf(str)))
                list.add(String.valueOf(str));
            System.out.println(index + " " + list);
        }
        else {
            for (int i = index; i < str.length; i++){
                char temp = str[index];
                str[index] = str[i];
                str[i] = temp;
                System.out.println("core with index="+index+" i="+i);
                permutationCore(str, index+1, list);
                str[i] = str[index];
                str[index] = temp;
            }
        }
    }

    public static void main(String[] args){
        Permutation demo = new Permutation();
        demo.permutation("abc");
    }
}