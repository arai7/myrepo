class Solution 
{
    public int findKthLargest(int[] nums, int k) 
    {
        // Create a min-heap with a size of k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add elements to the heap
        for (int num : nums) {
            minHeap.add(num);

            // If heap size exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // The root of the heap is the kth largest element
        return minHeap.peek();
    }
}
