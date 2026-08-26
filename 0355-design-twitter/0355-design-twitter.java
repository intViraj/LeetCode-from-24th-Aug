class Twitter {
    HashMap<Integer,HashSet<Integer>> map=new HashMap<>();
    HashMap<Integer,List<int []>> post=new HashMap<>();
    int count=0;
    public Twitter() {
    }
    
    public void postTweet(int userId, int tweetId) {
        post.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{count++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> posts=new ArrayList<>();
        HashSet<Integer> userfollowing = map.getOrDefault(userId, new HashSet<>());
        userfollowing.add(userId);
        PriorityQueue<int[]> heap=new PriorityQueue<>((a,b) -> Integer.compare(b[0] , a[0]));
        for(Integer id : userfollowing ){
            List<int[]> l = post.get(id);
            if (l != null) {
                for (int[] a : l) {
                    heap.add(a);
                }
            }
        }
        while(!heap.isEmpty() && posts.size()<10){
            int tweet=heap.poll()[1];
            posts.add(tweet);
        }
        return posts;
    }
    
    public void follow(int followerId, int followeeId) {
        map.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (map.containsKey(followerId)) {
            map.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */