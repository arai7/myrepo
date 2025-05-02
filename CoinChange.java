class Solution {
    public int coinChange(int[] coins, int amount) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        int result = backtrack(coins, amount, memo);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public int backtrack(int[] coins, int rem, HashMap<Integer, Integer> memo){
        if(rem < 0){
            return Integer.MAX_VALUE;
        }

        if(rem == 0){
            return 0;
        }

        if(memo.containsKey(rem)){
            return memo.get(rem);
        }

        int min = Integer.MAX_VALUE;

        for(int coin : coins){
            
            int res = backtrack(coins, rem - coin, memo);
            if(res != Integer.MAX_VALUE)
                min = Math.min(min, res+1);
        }

        memo.put(rem, min);
        return min;
    }
}
