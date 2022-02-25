import java.util.Arrays;

public class Leetcode1561 {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int i, j;
        i = 0;
        j = piles.length-2;
        int sum = 0;
        /**
         * I use i=1 as the start state, and make i+2n = j-2n as the end condition
         * the game is not select the mid in each three subarrays.
         * so I use two pointers, the former pointer go right 1 step each time with the latter going left 2 step.
         * when i < j , there are no more 3-pair coins exists.
         */
        while(i < j){
            sum += piles[j];
            i++;
            j -= 2;
        }
        return sum;
    }
}
