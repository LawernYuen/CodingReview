package CodingDaily.LeCo;

public class dungenGameNo174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int[] min = new int[dungeon[0].length];
        int[] cur = new int[dungeon[0].length];
        for (int i = 0; i < dungeon.length; i++){
            for (int j = 0; j < dungeon[0].length; j++){
                if (i == 0 && j == 0){
                    cur[j] = dungeon[i][j];
                    min[j] = Math.min(0, dungeon[i][j]);
                }
                else if (i == 0){
                    cur[j] = cur[j-1] + dungeon[i][j];
                    min[j] = Math.min(min[j-1], cur[j]);
                }
                else if (j == 0){
                    cur[j] = cur[j] + dungeon[i][j];
                    min[j] = Math.min(min[j], cur[j]);
                }
                else {
                    cur[j] = min[j] > min[j-1] ? cur[j]+dungeon[i][j] : cur[j-1]+dungeon[i][j];
                    min[j] = min[j] > min[j-1] ? Math.min(min[j], cur[j]) : Math.min(min[j-1], cur[j]);
                }
            }
        }
        return min[dungeon[0].length-1] > 0 ? 1 : 1-min[dungeon[0].length-1];
    }

    public static void main(String[] args) {
        int[][] dungeon = {{1,-3,3},{0,-2,0},{-3,-3,-3}};
        dungenGameNo174 demo = new dungenGameNo174();
        int ans = demo.calculateMinimumHP(dungeon);
        System.out.println(ans);
    }
}
