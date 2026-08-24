class Solution {
    public boolean isNStraightHand(int[] hand, int gSize) {
        int n=hand.length;
        if(n%gSize!=0)return false;
        TreeMap<Integer,Integer> map=new TreeMap<>();

        for(int i=0;i<n;i++){
            map.put(hand[i] , map.getOrDefault(hand[i],0)+1);
        }
        while (!map.isEmpty()) {
            int key = map.firstKey();
            for (int i = 0; i < gSize; i++) {
                int card = key + i;
                if (!map.containsKey(card)) {
                    return false;
                }
                int freq = map.get(card);
                if (freq == 1) {
                    map.remove(card);
                } else {
                    map.put(card, freq - 1);
                }
            }
        }
        return true;
    }
}