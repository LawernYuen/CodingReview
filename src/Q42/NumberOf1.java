public class NumberOf1{
    public int numberOf1(int n){
        int count = 0;
        for (int i = 0; i < (int)Math.log10(n)+1; i++){
            int high = n / (int)Math.pow(10,i+1);
            int low = n % (int)Math.pow(10,i);
            int cur = (n - high*(int)Math.pow(10,i+1)) / (int)Math.pow(10,i);
//            System.out.println(high+" "+cur+" "+low);
            if (cur < 1)
                count += high*Math.pow(10,i);
            else if (cur == 1)
                count += high*Math.pow(10,i)+low+1;
            else
                count += (high+1)*Math.pow(10,i);
        }
        return count;
    }

    public static void main(String[] args){
        NumberOf1 demo = new NumberOf1();
        int num = demo.numberOf1(123);
        System.out.print(num);
    }
}