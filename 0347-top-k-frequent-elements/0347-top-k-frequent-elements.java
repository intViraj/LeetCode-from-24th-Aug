class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;

        HashMap<Integer,Integer> map=new HashMap<>();
        PriorityQueue<int[]> heap=new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
        int [] ans=new int[k];

        for(int i=0;i<n;i++){
            map.put(nums[i] , map.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer , Integer> entry : map.entrySet()){
            heap.add(new int []{entry.getKey() , entry.getValue()});
            if(heap.size()>k)heap.poll();
        }
        int idx=0;
        for(int i=1;i<=k;i++){
            ans[idx++]=heap.poll()[0];
        }
        return ans;
    }
}