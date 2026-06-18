class Twitter {
    class Tweet {
        public int time;
        public int tweetId;

        Tweet(int time, int tweetId) {
            this.time = time;
            this.tweetId = tweetId;
        }
    }

    int time;
    HashMap<Integer, List<Tweet>> mapping;
    HashMap<Integer, Set<Integer>> follows;

    public Twitter() {
        time = 0;
        mapping = new HashMap<>();
        follows = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        mapping.putIfAbsent(userId, new ArrayList<>());
        mapping.get(userId).add(new Tweet(time++, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {

        Set<Integer> users = new HashSet<>();
        List<Tweet> candidates = new ArrayList<>();

        // user follows itself
        users.add(userId);

        // add followees
        users.addAll(follows.getOrDefault(userId, new HashSet<>()));

        for (int usr : users) {

            List<Tweet> list = mapping.getOrDefault(usr, new ArrayList<>());

            int size = list.size();
            int start = Math.max(0, size - 10);

            for (int i = start; i < size; i++) {
                candidates.add(list.get(i));
            }
        }

        // sort by time descending
        candidates.sort((a, b) -> b.time - a.time);

        List<Integer> recent = new ArrayList<>();
        for (int i = 0; i < Math.min(10, candidates.size()); i++) {
            recent.add(candidates.get(i).tweetId);
        }

        return recent;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        follows.putIfAbsent(followerId, new HashSet<>());
        follows.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        if (follows.containsKey(followerId)) {
            follows.get(followerId).remove(followeeId);
        }
    }
}
