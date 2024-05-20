import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Design_Twitter_Feed {
    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
        twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
        twitter.follow(1, 2);    // User 1 follows user 2.
        twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
        twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        twitter.unfollow(1, 2);  // User 1 unfollows user 2.
        twitter.getNewsFeed(1);
    }

    static class Twitter {
        HashMap<Integer,Integer> postedTweets=new HashMap<>();
        List<Integer> follower=new ArrayList<>();
        List<Integer> followee=new ArrayList<>();
        List<Integer> allTweets=new ArrayList<>();

        public Twitter()
        {

        }

        public void postTweet(int userId, int tweetId)
        {
            postedTweets.put(tweetId,userId);
            allTweets.add(tweetId);
        }

        public List<Integer> getNewsFeed(int userId)
        {
            List<Integer> res=new ArrayList<>();
            List<Integer> validFollowers=new ArrayList<>();

            for(int i=0;i<follower.size();i++)
            {
                if(follower.get(i)==userId)
                {
                    validFollowers.add(followee.get(i));
                }
            }

            int counter=0;

            for(int i=allTweets.size()-1;i>=0;i--)
            {
                int tweetPoster=postedTweets.get(allTweets.get(i));
                if(tweetPoster==userId || validFollowers.contains(tweetPoster))
                {
                    if(counter<10)
                    {
                        res.add(allTweets.get(i));
                        counter++;
                    }
                }
            }
            return res;
        }

        public void follow(int followerId, int followeeId)
        {
            follower.add(followerId);
            followee.add(followeeId);
        }

        public void unfollow(int followerId, int followeeId)
        {
            for(int i=0;i<follower.size();i++)
            {
                if(follower.get(i)==followerId && followee.get(i)==followeeId)
                {
                    follower.remove(i);
                    followee.remove(i);
                }
            }
        }
    }
}
