class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    boolean odd;
    int len=0;
    public MedianFinder() {
        right=new PriorityQueue<>();
        left=new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
       if(left.isEmpty() || left.peek()>num){
        left.add(num);
       }else{
        right.add(num);
       }

       if(right.size()>left.size()){
        left.add(right.poll());
       }else if(Math.abs(left.size()-right.size())>1){
        right.add(left.poll());
       }

    }

    
    public double findMedian() {
        if(left.size()==right.size()){
            double a=(double)left.peek();
            double b=(double)right.peek();
            return (double)(a+b)/2;
        }
        return (double)left.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */