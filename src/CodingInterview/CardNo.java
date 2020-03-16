import java.util.Scanner;
public class CardNo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int totalNo = in.nextInt();
        int[] cardNo = new int[totalNo];
        if(totalNo <= 0)
            return;
        for(int i = 0; i < totalNo; i++){
            cardNo[i] = in.nextInt();
        }
        if(cardNo == null)
            return;
//        for (int i = 0; i < cardNo.length; i++)
//            System.out.print(cardNo[i]);
        QuickSort(cardNo, 0, cardNo.length-1);
        for (int i = 0; i < cardNo.length; i++)
            System.out.print(cardNo[i]);
        int sum1 = 0;
        int sum2 = 0;
        for(int i=cardNo.length-1; i>=0; i--){
            sum1 = sum1 + cardNo[i];
            i--;
            if (i < 0)
                break;
            sum2 = sum2 + cardNo[i];
        }
        System.out.println(" "+Math.abs(sum1-sum2));
    }

    private static void QuickSort(int[] a, int lo, int hi){
        if(hi <= lo || lo > a.length-1 || hi <= 0)
            return;
        int temp = partition(a, lo, hi);
        QuickSort(a, lo, temp-1);
        QuickSort(a, temp+1, hi);
    }
    private static int partition(int[] a, int lo, int hi){
        int key = a[lo];
        int i = lo, j = hi+1;
        while (true){
            while (a[++i] < key)
                if (i == hi)
                    break;
            while (a[--j] > key)
                if (j == lo)
                    break;
            if (i >= j)
                break;
            exch(a, i, j);
        }
        if (i > lo && a[i] > key)
            exch(a, lo, --i);
        else
            exch(a, lo, i);
        return i;
    }
    private static void exch(int[] a, int m, int n){
        int temp = a[m];
        a[m] = a[n];
        a[n] = temp;
    }
}