package Twitter;
import twitter4j.*;
import twitter4j.api.SearchResource;
import twitter4j.conf.ConfigurationBuilder;

import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;


public class TStreamer {

	
	//NikeStoreId  = 17351972
	//cr1tterp0wer = 1317397044
	String consumerKey, consumerSecret, accessToken, tokenSecret, twitterId;
	TwitterStream  ts;
	TwitterFactory tf;
	SListener      sl;
	FilterQuery    fq;
	Twitter   twitter;
	
	public TStreamer(String _consumerKey, String _consumerSecret, String _accessToken,
			         String _tokenSecret, String _twitterId)
	{
	  consumerKey    = _consumerKey;
	  consumerSecret = _consumerSecret;
	  accessToken    = _accessToken;
	  tokenSecret    = _tokenSecret;
	  twitterId      = _twitterId;
	}
	
	public void launch()
	{
	  System.out.println();
	  
	  ConfigurationBuilder cb = new ConfigurationBuilder();
	  cb.setDebugEnabled(true)
	    .setOAuthConsumerKey(consumerKey)
		.setOAuthConsumerSecret(consumerSecret)
		.setOAuthAccessToken(accessToken)
		.setOAuthAccessTokenSecret(tokenSecret);
	  
	 // tf      = new TwitterFactory(cb.build());
	 //   twitter = tf.getInstance();
	  ts   = new TwitterStreamFactory(cb.build()).getInstance();

	  sl   = new SListener();
	  fq   = new FilterQuery();
	  
	  long[] stringQuery = {Integer.parseInt("1317397044")};
	  fq.follow(stringQuery);
	  ts.addListener(sl);
	  ts.filter(fq);
	  
}
	
	public void listUsers(String _user, int _pageNumber) throws TwitterException
	{
		String user = _user;
		int pageNumber = 1;
		ResponseList<User> UsersList = twitter.searchUsers(user, pageNumber);
	    
		for( User users: UsersList)
		{
		  if(users.getStatus() != null)
			System.out.println("@" +users.getScreenName() + " - " + users.getId());
		}
	}
	
	public void query(String _queryName) throws TwitterException
	{
		Query query    = new Query(_queryName);
		QueryResult qr = twitter.search(query);
		
		 for (Status status : qr.getTweets()) 
		   System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText()); 
	}
	
	public void showUserInfoById(int _id) throws TwitterException
	{

        User user  = twitter.showUser(_id);
        RateLimitStatus rateLimitStatus = user.getRateLimitStatus();
        
        System.out.println("@" +user.getScreenName() + " - " + user.getId());
        System.out.println("Description:         "   + user.getDescription());
        System.out.println("Followers:           "   + user.getFollowersCount());
        System.out.println("Current Tweet/Reply: "   + user.getStatus().getText());
        System.out.println("URL Entity:          "   + user.getURLEntity());

        System.out.println("SecondsUntilReset: " + rateLimitStatus.getSecondsUntilReset());
        
	}
	
	public void showHomeTweetsList(Twitter _twitter) throws TwitterException
	{
	     List<Status> HomeTweetsList  = _twitter.getHomeTimeline();
	     System.out.println("Number showing: " + HomeTweetsList.size());
	
		for (Status t : HomeTweetsList) {
	      System.out.println("ID: " + t.getUser().getId() +" - " +t.getCreatedAt() + ": " + t.getText());
		}
	}
	
	public void getCookieUsingCookieHandler(String _url) { 
	    try {       
	        // Instantiate CookieManager;
	        // make sure to set CookiePolicy
	        CookieManager manager = new CookieManager();
	        manager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
	        CookieHandler.setDefault(manager);

	        // get content from URLConnection;
	        // cookies are set by web site
	        URL url = new URL(_url);
	        URLConnection connection = url.openConnection();
	        connection.getContent();

	        // get cookies from underlying
	        // CookieStore
	        CookieStore cookieJar =  manager.getCookieStore();
	        List <HttpCookie> cookies =
	            cookieJar.getCookies();
	        for (HttpCookie cookie: cookies) {
	          System.out.println("CookieHandler retrieved cookie: " + cookie);
	        }
	       //[<Cookie geoloc=cc=US,rc=CA,tp=vhigh,tz=PST,la=37.7795,lo=-122.4195,bw=5000 for .www.nike.com/>]>
	        
	    } catch(Exception e) {
	        System.out.println("Unable to get cookie using CookieHandler");
	        e.printStackTrace();
	    }
	}  
	
}
