class Solution 
{
    public int lastStoneWeight(int[] stones) {
        // Create a max-heap using a PriorityQueue by inverting the values
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // Add all stones to the max-heap
        for (int stone : stones) {
            maxHeap.add(stone);
        }

        // Smash stones until one or zero stones are left
        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.poll(); // Heaviest stone
            int stone2 = maxHeap.poll(); // Second heaviest stone

            if (stone1 != stone2) {
                maxHeap.add(stone1 - stone2); // Add the resulting stone back
            }
        }

        // Return the last stone weight or 0 if no stones are left
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
