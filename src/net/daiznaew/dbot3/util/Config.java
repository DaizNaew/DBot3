package net.daiznaew.dbot3.util;

import java.io.*;
import java.util.Properties;

/**
 *
 * @author Daiz
 */

public class Config {

    
    
    private Properties configFile;

    private static Config instance;

    public Config() 
    {
        /* Here we will set up the config file for the mod 
         * First: Create a folder inside the config folder
         * Second: Create the actual config file
         */
        File file = new File(this.getLocation() + "/config");
        file.mkdir();
        Properties configFile = new Properties();

        /* Some basic debugging will go a long way */
        try
        {
            configFile.createNewFile();
        }
        catch (IOException e)
        {
            System.out.println("Could not create configuration file for TConstruct. Reason:");
            System.out.println(e);
        }

        //Load the configuration file
        configFile.load(configFile);
        
        //initialize default parameters
        
        // Save the config if not done
        config.save();
        
    }
        
        /*
        //need to add a lookup for existing file.
        configFile = new java.util.Properties();
        
        try
        {
    		//set the properties value
                //this should obviously be null for release.
    		configFile.setProperty("website", "http://snaiperskaya.net");
                configFile.setProperty("bpassword","dbotistrueforceofbux");
                configFile.setProperty("bname","DBot3");
                configFile.setProperty("buname","DBot3");
                configFile.setProperty("bfinger","You ought to be arrested for fingering a bot");
                configFile.setProperty("network","irc.rizon.net");
                configFile.setProperty("channel","#ircbottest");
                configFile.setProperty("bversion","3.0");
                
    		//save properties to project root folder
    		configFile.store(new FileOutputStream("config.cfg"), null);
 
    	} catch (IOException ex) {
    		ex.printStackTrace();
        }
        */

    private String getValue(String key)
    {
        return configFile.getProperty(key);
    }

    public static String getProperty(String key) 
    {
        if (instance == null) instance = new Config();
        return instance.getValue(key);
    }
    
    private File getLocation()
	{
		return new File(".");
	}
}