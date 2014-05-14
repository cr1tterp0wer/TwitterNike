package MAIN;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


import Twitter.TStreamer;

public class TwitterNike {

	static TStreamer tl;
    static String username, password;
	
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
	
	private static void launch()
	{
		tl.launch();
	}
	
	private static boolean init(String[] _args)
	{
		String[] args = _args;
		
		if(args.length == 7)
		{
		  //Intantiate your vars
		  username = args[0];
		  password = args[1];
		  tl     = new TStreamer(args[2], args[3], args[4],args[5],args[6]);
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
			  
			  //Intantiate your vars
			  username = split[0];
			  password = split[1];
			  tl     = new TStreamer(split[2], split[3], split[4], split[5], split[6]);
			  
			  return true;
			}catch(IOException e){System.out.println(e.getMessage());}
			
		}
		System.out.println("Error: Illegal Arguments!");
		return false;
		
	}
	
	
	public static String getUsername(){ return username;}
	public static String getPassword(){ return password;}
}


