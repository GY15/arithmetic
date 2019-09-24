package leetcode.middle.list;

import java.util.*;

public class Twitter {
    public static void main(String[] args) {
        Twitter t = new Twitter();
    t.postTweet(1,5); t.postTweet(2,3);
    t.postTweet(1,101); t.postTweet(2,13); t.postTweet(2,10);
    t.postTweet(1,2); t.postTweet(1,94); t.postTweet(2,505); t.postTweet(1,333);
    t.postTweet(2,22); t.postTweet(1,11); t.postTweet(1,205);
    t.postTweet(2,203); t.postTweet(1,201); t.postTweet(2,213);
    t.postTweet(1,200); t.postTweet(2,202); t.postTweet(1,204);
    t.postTweet(2,208); t.postTweet(2,233); t.postTweet(1,222);
    t.postTweet(2,211); t.getNewsFeed(1); t.follow(1,2); t.getNewsFeed(1);
    t.unfollow(1,2); t.getNewsFeed(1);
    }
    class Tweet {
        int time;
        int id;

        public Tweet(int time, int id) {
            this.time = time;
            this.id = id;
        }
    }

    Map<Integer, List<Tweet>> users;
    Map<Integer, Set<Integer>> followees;
    int articleID;
    int size = 10;

    public Twitter() {
        users = new HashMap<>();
        followees = new HashMap<>();
        articleID = 0;
    }

    public void postTweet(int userID, int tweetId) {
        List<Tweet> list = users.getOrDefault(userID, new ArrayList<>());
        if (list.size() == 0) {
            users.put(userID, list);
        }
        list.add(0, new Tweet(articleID++, tweetId));
        if (list.size() > size){
            list.remove(size);
        }
    }
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> follows = followees.getOrDefault(userId, new HashSet<>());
        List<Tweet> tweets = new ArrayList<>();
        updateList(tweets, users.getOrDefault(userId, new ArrayList<>()));
        for (int user: follows) {
            List<Tweet> temp = users.get(user);
            if (temp != null) {
                updateList(tweets, temp);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (Tweet t: tweets){
            res.add(t.id);
        }
        return res;
    }
    Comparator<Tweet> tweetComparator = new Comparator<Tweet>() {
        @Override
        public int compare(Tweet o1, Tweet o2) {
            return o2.time - o1.time;
        }
    };
    private void updateList(List<Tweet> res, List<Tweet> needMerge) {
        int index = 0;
        while (res.size() < size  && index < needMerge.size()) {
            res.add(needMerge.get(index++));
        }
        Collections.sort(res, tweetComparator);
        if (needMerge.size() == index || needMerge.get(index).time < res.get(res.size()-1).time){
            return;
        }
        while(needMerge.size() > index && needMerge.get(index).time > res.get(size-1).time){
            if (res.get(0).time < needMerge.get(index).time){
                res.add(0,needMerge.get(index++));
                if(res.size() > size){
                    res.remove(size);
                }
                continue;
            }
            int begin = 0;
            int end =  res.size();
            while (begin < end){
                int middle = (begin+end)/2;
                if (res.get(middle).time > needMerge.get(index).time){
                    begin = middle;
                    if(res.get(middle+1).time < needMerge.get(index).time){
                        break;
                    }
                }else{
                    end = middle;
                }
            }
            res.add(begin,needMerge.get(index++));
            if(res.size() > size){
                res.remove(size);
            }
        }
    }


    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if(followeeId == followerId){
            return;
        }
        Set<Integer> list = followees.getOrDefault(followerId,new HashSet<>());
        list.add(followeeId);
        followees.put(followerId,list);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> list = followees.getOrDefault(followerId,new HashSet<>());
        list.remove(followeeId);
    }
}
