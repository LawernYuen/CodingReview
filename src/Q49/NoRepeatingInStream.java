public class NoRepeatingInStream{
    private int index;
    private int[] occurence;

    public NoRepeatingInStream(){
        index = 0;
        occurence = new int[256];
        for (int i = 0; i < 256; i++)
            occurence[i] = -1;
    }

    public void insert(char ch){
        if (occurence[(int)ch] == -1)
            occurence[(int)ch] = index;
        else if (occurence[(int)ch] >= 0)
            occurence[(int)ch] = -2;
        index++;
    }

    public char getFirst(){
        int minIndex = Integer.MAX_VALUE;
        char ch = '#';
        for (int i = 0; i < 256; i++)
            if (occurence[i] >= 0 && occurence[i] < minIndex){
                ch = (char) i;
                minIndex = occurence[i];
            }
        return ch;
    }
}