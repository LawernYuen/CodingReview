public class SeqOfPostorder{
    public boolean verifySeqOfPostorder(int[] sequence){
        if (sequence == null || sequence.length)
            return false;
        return verifyCore(sequence, 0, sequence.length-1);
    }

    private boolean verifyCore(int[] sequence, int start, int end){
        if (start >= end)
            return true;
        // left preceedings
        int index = start;
        while (sequence[index] < sequence[end])
            index++;
        int mid = index;
        // right preceedings
        while (sequence[index] > sequence[end])
            index++;
        if (index != end)
            return false;
        return verifyCore(sequence, start, mid-1)
                && verifyCore(sequence, mid, end-1);
    }
}