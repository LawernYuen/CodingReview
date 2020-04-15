package CodingDaily.Tests;

import java.util.Scanner;
public class buyGifts {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int NumPerson = in.nextInt();
        int NumGift = in.nextInt();
        int redbag = in.nextInt();
        int newGift = in.nextInt();
        if (NumPerson == 0 || (NumGift%NumPerson) == 0)
            System.out.println(0);
        else if (NumGift < NumPerson){
            if (redbag < newGift)
                System.out.println((NumPerson-NumGift)*redbag);
            else
                System.out.println((NumPerson-NumGift)*newGift);
        }
        else {
            int minNum = Math.min(redbag, newGift);
            int remain = NumGift % NumPerson;
            int m1 = (NumPerson-remain)*minNum;
            int m2 = 0;
            while (NumGift % (NumPerson-m2) != 0)
                m2++;
            m2 = m2 * minNum;
            System.out.println(Math.min(m1, m2));
        }
    }
}
