package CodingDaily.Tests;

public class Sits {
    public int GetMaxStaffs (char[][] pos) {
        int[][] counts = new int[pos.length][pos[0].length];
        int flag = 0;
        if (pos[0][0] == '.') {
            counts[0][0] = 1;
            flag = 1;
        }
        for (int i = 1; i < pos.length; i++) {
            if (pos[i][0] == '.' && flag == 0) {
                counts[i][0] = counts[i-1][0] + 1;
                flag = 1;
            }
            else {
                counts[i][0] = counts[i-1][0];
                flag = 0;
            }
        }
        for (int i = 1; i < pos[0].length; i++){
            if (pos[0][i] == '.' && flag == 0) {
                counts[0][i] = counts[0][i-1] + 1;
                flag = 1;
            }
            else {
                counts[0][i] = counts[0][i-1];
                flag = 0;
            }
        }
        for (int i = 1; i < pos.length; i++){
            for (int j = 1; j < pos[0].length; j++){
                if (pos[i][j] == '.') {
                    if (pos[i - 1][j - 1] == '.' && pos[i - 1][j] == '.' && pos[i][j - 1] == '.')
                        counts[i][j] = Math.max(Math.max(counts[i][j - 1], counts[i - 1][j]), counts[i - 1][j - 1] + 1);
                    else if (pos[i - 1][j - 1] == '.' && pos[i - 1][j] == '.')
                        counts[i][j] = Math.max(Math.max(counts[i - 1][j], counts[i][j - 1]+1), counts[i - 1][j - 1] + 1);
                    else if (pos[i - 1][j - 1] == '.' && pos[i][j - 1] == '.')
                        counts[i][j] = Math.max(Math.max(counts[i][j - 1], counts[i - 1][j]+1), counts[i - 1][j - 1] + 1);
                    else if (pos[i - 1][j - 1] == '.')
                        counts[i][j] = Math.max(Math.max(counts[i][j - 1], counts[i - 1][j]), counts[i - 1][j - 1]) + 1;
                    else
                        counts[i][j] = Math.max(Math.max(counts[i][j - 1], counts[i - 1][j]), counts[i - 1][j - 1]);
                }
                else
                    counts[i][j] = Math.max(Math.max(counts[i][j - 1], counts[i - 1][j]), counts[i - 1][j - 1]);
            }
        }
        return counts[pos.length-1][pos[0].length-1];
    }

    public static void main(String[] args) {
        char[][] pos = {{'*','.','*','*','.'},{'*','.','*','*','*'},{'*','.','*','*','.'}};
        Sits demo = new Sits();
        demo.GetMaxStaffs(pos);
    }
}
