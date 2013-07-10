package net.daiznaew.dbot3.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import org.pircbotx.Channel;

/**
 *
 * @author Daiz
 */

public class Config {

    
    
    private Properties configFile;

    private static Config instance;

    private Config() 
    {
        configFile = new java.util.Properties();
        try {
    		//set the properties value
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
        }

    private String getValue(String key) 
    {
        return configFile.getProperty(key);
    }

    public static String getProperty(String key) 
    {
        if (instance == null) instance = new Config();
        return instance.getValue(key);
    }

}