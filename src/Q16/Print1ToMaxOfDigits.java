public class Print1ToMaxOfDigits{
    // 模拟加法一个一个来
    public void print1ToMaxOfDigits1(int n){
        if (n <= 0)
            return;
        char[] number = new char[n];
        for (int k = 0; k < number.length; k++)
            number[k] = '0';
        while (!increment(number))
            printCharNumber(number);
    }

    private boolean increment(char[] number){
        int nTakeOver = 0; //进位，只由非最后位置的数字之间相加产生，为0或1
        for (int i = number.length-1; i >= 0; i--){
            int nSum = (number[i] - '0') + nTakeOver; //把当前操作位转化成int以便操作，且进位
            if (i == number.length - 1)
                nSum++; //人为操作加一
            if (nSum >= 10){
                if (i == 0)
                    return true;
                nTakeOver = 1; //产生进位
                nSum -= 10;
                number[i] = (char) (nSum + '0');
            }
            else {
                number[i] = (char) (nSum + '0');
                break; //高位不变，可以跳出循环了
            }
        }
        return false;
    }

    private void printCharNumber(char[] number){
        boolean isBeginning0 = true;
        for (int i = 0; i < number.length; i++){
            if (isBeginning0 && number[i] != '0')
                isBeginning0 = false;
            if (!isBeginning0)
                System.out.print(number[i]);
        }
        System.out.println();
    }

    // 直接按位0到9都来一遍，递归实现
    private void print1ToMaxOfDigits2(int n){
        if (n <= 0)
            return;
        char[] number = new char[n];
        for (int k = 0; k < number.length; k++)
            number[k] = '0';
        for (int i = 0; i <= 9; i++)
            number[0] = (char) (i + '0');
            makeNumber(number, 0);
    }

    private void makeNumber(char[] number, int index){
        if (index == number.length-1){
            printCharNumber(number);
            return;
        }
        for (int i = 0; i <= 9; i++){
            number[index+1] = (char) (i + '0');
            makeNumber(number, index+1);
        }
    }
}