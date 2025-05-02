class Solution {
    public int climbStairs(int n) {

        HashMap<Integer, Integer> memo = new HashMap<>();

        if(n == 1 || n == 2){
            return n;
        }

        return countClimb(n, memo);

        //return climbStairs(n-1) + climbStairs(n-2);
    }

    public int countClimb(int n, HashMap<Integer, Integer> memo){
        if(n == 1){
            memo.put(1, 1);
            return 1;
        }
        if(n == 2){
            memo.put(2, 2);
            return 2;
        }
        if(memo.containsKey(n)){
            return memo.get(n);
        }

        memo.put(n, (countClimb(n-1, memo) + countClimb(n-2, memo)));
        return memo.get(n);
    }
}
