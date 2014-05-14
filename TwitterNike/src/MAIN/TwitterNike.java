package MAIN;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Selenium.Sscraper;
import Twitter.Tlistener;

public class TwitterNike {

	static Tlistener tl;
	static Sscraper  scrape;
	
	//arg[0] = username,  arg[1] = pass  :store.Nike.com
	//arg[2] = ConsumerKey, arg[3] = ConsumerSecret
	//arg[4] = AccessToken, arg[5] = TokenSecret
	//arg[6] = TwitterId
	public static void main(String[] args)
	{
		if(init(args))
		{
			launch();
		}
			

	}
	
	public static void launch()
	{
		
		
	}
	
	public static boolean init(String[] _args)
	{
		String[] args = _args;
		
		if(args.length == 7)
		{
      	  scrape = new Sscraper( args[0], args[1] );
		  tl     = new Tlistener(args[2], args[3], args[4],args[5],args[6]);
		  return true;
		}
		//manage with a file
		else if(args.length == 1)
		{
			try{
			  BufferedReader br = new BufferedReader(new FileReader(args[0]));
			  StringBuffer stringBuffer = new StringBuffer();
			  String line = null;
			 
			  while((line = br.readLine())!=null){
			 
			   stringBuffer.append(line).append("\n");
			  }
			   
			  String   input = stringBuffer.toString();
			  String[] split = input.split("\\s+");
			  
			  for(int i=0;i<split.length;i++)
				  System.out.println(split[i]);
			  return true;
			}catch(IOException e){System.out.println(e.getMessage());}
			
		}
		return false;
		
	}
}


