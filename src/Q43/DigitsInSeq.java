public class DigitsInSeq{
    public int digitsInSeq(int n){
        if (n < 0)
            return -1;
        int digit = 1, num = 10;
        int temp = num, digit1 = 0, digit2 = 0;
        while (true){
            if (n < num){
                if (digit == 1)
                    return n;
                else {
                    digit1 = (n - temp) / digit;
                    digit2 = (n - temp) % digit;
                    System.out.println(digit1+" "+digit2+" "+digit);
                    digit1 = (int)Math.pow(10,digit-1) + digit1 + 1;
                    System.out.println(digit1+" "+digit2+" "+digit);
                    return (int)(digit1 / Math.pow(10,digit-digit2));
                }
            }
            temp = num;
            digit++;
            num = num + (int) (9*Math.pow(10,digit-1)*digit);
        }
    }

    public static void main(String[] args){
        DigitsInSeq demo = new DigitsInSeq();
        int num = demo.digitsInSeq(50);
        System.out.print(num);
    }
}