package MAIN;
import twitter4j.*;
import twitter4j.api.SearchResource;
import twitter4j.conf.ConfigurationBuilder;

import java.io.IOException;
import java.util.List;


public class TwitterNike {

	public static TwitterFactory tf;
	public static Twitter twitter;
	
	
	public static void main(String[] args) throws TwitterException, IOException{
		
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey("QzdVtRIpzsfACX5v8fPMvgQpH")
		  .setOAuthConsumerSecret("jynF6cgfjUbchWBru9CmzfoaO0tOpXrFPvnAQP479ZtYutE2oB")
		  .setOAuthAccessToken("1317397044-IQ3AzpX64rey7SI4BUBCZPDnR7yAIGoyj2195eB")
		  .setOAuthAccessTokenSecret("vkmuvx8lutiPurIlljRd0Gc2Jfh8GEDhCDUCwMCBM1bLM");
		tf = new TwitterFactory(cb.build());
		twitter = tf.getInstance();
		
       listUsers("lyft",1);
	   //NikeStore 17351972
       //showHomeTweetsList();
	   //showUserInfoById(569569550);
		
		
	}
	
	public static void listUsers(String _user, int _pageNumber) throws TwitterException
	{
		String user = _user;
		int pageNumber = 1;
		ResponseList<User> UsersList = twitter.searchUsers(user, pageNumber);
	    
		for( User users: UsersList)
		{
			if(users.getStatus() != null)
			{
				System.out.println("@" +users.getScreenName() + " - " + users.getId());
			}
		}
		
	}
	
	
	public static void query(String _queryName) throws TwitterException
	{
		Query query    = new Query(_queryName);
		QueryResult qr = twitter.search(query);
		
		 for (Status status : qr.getTweets()) {
		   System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText()); }
	}
	
	public static void showUserInfoById(int _id) throws TwitterException
	{

        User user  = twitter.showUser(_id);
        RateLimitStatus rateLimitStatus = user.getRateLimitStatus();
        
        System.out.println("@" +user.getScreenName() + " - " + user.getId());
        System.out.println("Description:         " + user.getDescription());
        System.out.println("Followers:           " + user.getFollowersCount());
        System.out.println("Current Tweet/Reply: " + user.getStatus().getText());
        System.out.println("URL Entity:          " + user.getURLEntity());

        System.out.println("SecondsUntilReset: " + rateLimitStatus.getSecondsUntilReset());
        
	}
	
	public static void showHomeTweetsList() throws TwitterException
	{
	     List<Status> HomeTweetsList  = twitter.getHomeTimeline();
	     System.out.println("Number showing: " + HomeTweetsList.size());
	
		for (Status t : HomeTweetsList) {
	      System.out.println(t.getCreatedAt() + ": " + t.getText());
		}
			
	        
	}

}
