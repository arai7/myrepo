//hackerrank

public static int migratoryBirds(List<Integer> arr) {
    // Write your code here
        int max = 0;
        int[] freq = new int[6];
        
        for(int i : arr){
            freq[i]++;
        }
        int maxfreq = 0;
        for(int i = 1; i <= 5; i++){
            if(freq[i] > maxfreq){
                maxfreq = freq[i];
                max = i;
            }
        }
        
        return max;
    }
