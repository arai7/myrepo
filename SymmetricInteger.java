class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int res = 0;
        for(int i = low; i <= high; i++){
            String num = String.valueOf(i);
            if (num.length() % 2 != 0) {
                continue;
            }
            if(checkSymm(num))
                res++;
        }
        return res;
    }

    public boolean checkSymm(String num){
        int half = num.length()/2;
        String first = num.substring(0, half);
        String second = num.substring(half);

        int sum1 = 0, sum2 = 0;

        for (char c : first.toCharArray()) {
            sum1 += c - '0';
        }
        for (char c : second.toCharArray()) {
            sum2 += c - '0';
        }

        if(sum1 == sum2)
            return true;
        return false;
    }
}
