//hackerRank

public static String biggerIsGreater(String w) {
    // Convert the string to a character array for easier manipulation
    char[] c = w.toCharArray();
    int len = w.length();
    
    // Step 1: Find the pivot point where s[i-1] < s[i]
    int pivotPoint = -1;
    for (int i = len - 1; i > 0; i--) {
        if (c[i - 1] < c[i]) {
            pivotPoint = i - 1;
            break;
        }
    }
    
    // If no pivot is found, that means the string is the largest permutation
    if (pivotPoint == -1) {
        return "no answer";
    }
    
    // Step 2: Find the rightmost character that is greater than the pivot
    int swapIndex = -1;
    for (int i = len - 1; i > pivotPoint; i--) {
        if (c[i] > c[pivotPoint]) {
            swapIndex = i;
            break;
        }
    }
    
    // Step 3: Swap the characters at pivotPoint and swapIndex
    char temp = c[pivotPoint];
    c[pivotPoint] = c[swapIndex];
    c[swapIndex] = temp;
    
    // Step 4: Reverse the substring to the right of pivotPoint
    int left = pivotPoint + 1;
    int right = len - 1;
    while (left < right) {
        temp = c[left];
        c[left] = c[right];
        c[right] = temp;
        left++;
        right--;
    }
    
    // Convert the character array back to string and return the result
    return new String(c);
}
