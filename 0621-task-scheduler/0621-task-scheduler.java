class Solution {
    public int leastInterval(char[] tasks, int n) {
        int len=tasks.length;
        int [] freq=new int [26];
        PriorityQueue<Integer> heap=new PriorityQueue<>(Collections.reverseOrder());
        int count=0;
        for(char x : tasks){
            freq[x-'A']++;
        }
        for(int i=0;i<26;i++){
            if(freq[i]!=0){
                heap.add(freq[i]);
            }
        }
        while(!heap.isEmpty()){
            List<Integer> l=new ArrayList<>();
            for(int i=1;i<=n+1;i++){
                if(!heap.isEmpty()){
                    int curr=heap.poll();
                    curr--;
                    l.add(curr);
                }
            }
            for(int x : l){
                if(x>0)heap.add(x);
            }
            if(heap.isEmpty()){
                count +=l.size();
            }else{
                count+=n+1;
            }
        }
        return count;
    }
}