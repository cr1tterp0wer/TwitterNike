package Twitter;
import MAIN.TwitterNike;
import Selenium.Sscraper;
import twitter4j.DirectMessage;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.User;
import twitter4j.UserList;


public class SListener implements StatusListener {

	Sscraper scraper;
	
	public SListener()
	{
	  scraper = new Sscraper(TwitterNike.getUsername(), TwitterNike.getPassword());
	}
	
	
	 @Override
     public void onStatus(Status status) {
		  doit(status);
	
     } 
     
     
	 public void doit(Status status){

		 String inputStatus    = status.getText();

		 String[]  split              = inputStatus.split(" is now available ");
		 String[] splitBuff = split[1].split("\\s");
		 split[1]           = splitBuff[0];
		 String buff        = "http.*";
		 //   System.out.println("******String[0]: " + split[0] + " String[1] " + split[1]); 
		 if(split[1].matches(buff) && !scraper.isLaunched())
		 {
			 //  System.out.println("WE MATCH-> LAUNCH: " + split[0] + " - " + split[1]);
			 scraper.launch(split[1]);
		 }


	 }


	@Override
	public void onException(Exception arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onDeletionNotice(StatusDeletionNotice arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onScrubGeo(long arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onStallWarning(StallWarning arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onTrackLimitationNotice(int arg0) {
		// TODO Auto-generated method stub
		
	}

}
