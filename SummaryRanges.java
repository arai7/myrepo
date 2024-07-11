class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> strList = new ArrayList<String>();
        int start=0;
        int end=0;



        if(nums.length == 0){
            return strList;
        }
        if(nums.length == 1){
            strList.add(Integer.toString(nums[0]));
            return strList;
        }
        String ele = "";
        Boolean isConsecutive = false;

        for(int i = 0 ; i< nums.length - 1 ; i++){
            if(nums[i] + 1 == nums[i+1]){
                ele = String.valueOf(nums[start]) + "->";
                isConsecutive = true;
            }else{
                isConsecutive = false;
            }

            if(!isConsecutive){
                if(ele.contains("->")){
                    ele+= String.valueOf(nums[i]);
                    strList.add(ele);
                    start = i+1;
                    ele = "";
                }
                else{
                    strList.add(String.valueOf(nums[i]));
                    start = i+1;
                }
            }

        }
        if(start == nums.length-1)
            strList.add(String.valueOf(nums[start]));
        else{
            strList.add(String.valueOf(nums[start]) + "->" + String.valueOf(nums[nums.length-1]));
        }
        return strList;
    }
}
