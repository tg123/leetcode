public class Solution {
    
    int minHealthReach(int hp, int room){
        hp -= room;
        if(hp <= 0){
            return 1;
        }

        return hp;
    }
    
    public int calculateMinimumHP(int[][] dungeon) {
        
        final int mx = dungeon.length;
        final int my = dungeon[0].length;
        
        dungeon[mx - 1][my - 1] = minHealthReach(1, dungeon[mx - 1][my - 1]);
        
        for(int i = mx - 2; i >= 0; i--){
            dungeon[i][my - 1] = minHealthReach(dungeon[i + 1][my - 1], dungeon[i][my - 1]);
        }

        for(int j = my - 2; j >= 0; j--){
            dungeon[mx - 1][j] = minHealthReach(dungeon[mx - 1][j + 1], dungeon[mx - 1][j]);
        }


        for(int i = mx - 2; i >= 0; i--){
            for(int j = my - 2; j >= 0; j--){
                dungeon[i][j] = minHealthReach(Math.min(dungeon[i + 1][j], dungeon[i][j + 1]), dungeon[i][j]);
            }
        }
        
        return dungeon[0][0];
        
    }
}
