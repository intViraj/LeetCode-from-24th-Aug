class KthLargest {
    PriorityQueue<Integer> heap=new PriorityQueue<>();
    int kth;
    public KthLargest(int k, int[] nums) {
        for (int x : nums) {
            heap.add(x);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        kth=k;
    }
    
    public int add(int val) {
        heap.add(val);
        if (heap.size() > kth) {
            heap.poll();
        }
        return heap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */