    class Twitter {

        /** Initialize your data structure here. */
        class Tweet {
            public int tweetId;
            public int timestamp;
            public Tweet next;
            public Tweet(int tweetId, int timestamp) {
                this.tweetId = tweetId;
                this.timestamp = timestamp;
            }
        }

        class User {
            public int userId;
            public Tweet tweetHead;
            public Set<Integer> followSet;
            public User(int userId) {
                this.userId = userId;
                followSet = new HashSet<>();
            }
        }

        private static int timestamp = 0;
        private Map<Integer, User> userMap;

        public Twitter() {
            userMap = new HashMap<>();
        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            User user = userMap.get(userId);
            if (user == null) {
                user = new User(userId);
                userMap.put(userId, user);
            }
            Tweet tweet = new Tweet(tweetId, timestamp++);
            tweet.next = user.tweetHead;
            user.tweetHead = tweet;
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            PriorityQueue<Tweet> pq = new PriorityQueue<>(1, new Comparator<Tweet>() {
                @Override
                public int compare(Tweet t1, Tweet t2) {
                    return t2.timestamp - t1.timestamp;
                }
            });
            User user = userMap.get(userId);
            if (user != null) {
                if (user.tweetHead != null) {
                    pq.offer(user.tweetHead);
                }
                Set<Integer> followSet = user.followSet;
                for (int following : followSet) {
                    if (following == user.userId)   continue;
                    User followingUser = userMap.get(following);;
                    if (followingUser != null && followingUser.tweetHead != null) {
                        pq.offer(followingUser.tweetHead);
                    }
                }
            }
            List<Integer> ans = new ArrayList<>();
            while (!pq.isEmpty() && ans.size() < 10) {
                Tweet tweet = pq.poll();
                ans.add(tweet.tweetId);
                if (tweet.next != null) {
                    pq.offer(tweet.next);
                }
            }
            return ans;
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            User user = userMap.get(followerId);
            if (user == null) {
                user = new User(followerId);
                userMap.put(followerId, user);
            }
            user.followSet.add(followeeId);
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            User user = userMap.get(followerId);
            if (user == null) {
                return;
            }
            user.followSet.remove(followeeId);
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