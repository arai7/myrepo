class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int len1 = firstList.length;
        int len2 = secondList.length;

        int start = 0;
        int end = 1;

        int itr1 = 0;
        int itr2 = 0;

        List<int[]> overlaps = new ArrayList<>();

        while(itr1 < len1 && itr2 < len2){
            int[] A = new int[2];
            int[] B = new int[2];
            int[] ovrlap = new int[2];

            //set interval which begins earlier in A and vice versa
            if(firstList[itr1][start] <= secondList[itr2][start] ){
                A = firstList[itr1];
                B = secondList[itr2];
            }
            else{
                B = firstList[itr1];
                A = secondList[itr2];
            }

            //idenity and store overlap
            if(B[start] <= A[end]){
                ovrlap[start] = B[start];
                ovrlap[end] = Math.min(A[end], B[end]);
                overlaps.add(ovrlap);
            }
            
            if(firstList[itr1][end] < secondList[itr2][end]){
                itr1++;
            }
            else{
                itr2++;
            }
        }

        return overlaps.toArray(new int[overlaps.size()][]);
    }
}
