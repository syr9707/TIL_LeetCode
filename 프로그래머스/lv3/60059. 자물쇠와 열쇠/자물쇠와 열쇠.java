import java.util.*;

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int point = key.length - 1;     
        for(int x = 0; x < point + lock.length; x++) { 
            for(int y = 0; y < point + lock.length; y++) {
                for(int r = 0; r < 4; r++) {
                    int[][] newLock = new int[lock.length + key.length * 2][lock.length + key.length * 2]; 
                    for(int i = 0; i < lock.length; i++) {
                        for(int j = 0; j < lock.length; j++) {
                            newLock[i + point][j + point] = lock[i][j];
                        }
                    }
                    match(newLock, key, r, x, y);
                    if(check(newLock, point, lock.length)) return true;
                }
            }
        }
        return false;
    }
    
    public void match(int[][] newLock, int[][] key, int rot, int x, int y) {
        int len = key.length;
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if(rot == 0) {
                    newLock[x + i][y + j] += key[i][j];
                } else if(rot == 1) { 
                    newLock[x + i][y + j] += key[j][len - i - 1];
                } else if(rot == 2) {
                    newLock[x + i][y + j] += key[len - i - 1][len- j - 1];
                } else { 
                    newLock[x + i][y + j] += key[len - j - 1][i];
                }
            }
        }
    }
    
    public boolean check(int[][] newLock, int point, int len) {
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if(newLock[point + i][point + j] != 1) return false;
            }
        }
        return true;
    }
}
