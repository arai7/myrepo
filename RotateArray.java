class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length<=1)
            return;
        
        int n = nums.length;
        if(k>n){
            k = k%n;
        }
        //SOLUTION 1
        // int[] copy = Arrays.copyOf(nums, n);

        // for(int i = 0; i < n; i++){
        //     //System.out.println("i is "+i);
        //     //System.out.println("(i+k)%n is "+(i+k)%n);
        //     nums[(i+k)%n]=copy[i];
        // }

        //SOLUTION 2
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = k; i < n; i++){
            map.put(i, nums[i]);
        }
        for(int i = 0; i < n; i++){
            if(i<k){
                nums[(i+k)%n]=nums[i];
            }
            else{
                nums[(i+k)%n]=map.get(i);
            }
        }

    }
}
