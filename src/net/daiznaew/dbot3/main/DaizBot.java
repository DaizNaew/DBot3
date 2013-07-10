
package net.daiznaew.dbot3.main;

import org.pircbotx.PircBotX;
import net.daiznaew.dbot3.Listeners.core.BotCommand;
import net.daiznaew.dbot3.util.Config;
import net.daiznaew.dbot3.util.references.CommandReferences;

/**
 *
 * @author Daiz
 */
public class DaizBot 
{

        //initializing Pircbot
    public static PircBotX bot = new PircBotX(); 
        
        //Initializing the channels to join
    private static String CHANNEL = Config.getProperty("channel");
    
        //builds the strings from the config.
    private static String NAME = Config.getProperty("bname");
    private static String PASSWORD = Config.getProperty("bpassword");
    private static String USER = Config.getProperty("buname");
    private static String FINGER = Config.getProperty("bfinger");
    private static String VERSION = Config.getProperty("bversion");
    private static String NETWORK = Config.getProperty("network");
    
    //disabled until further notice
   /* 
        //Caller to call the main channel of the bot
    public static Channel getMainChannel()
    {
        return bot.getChannel(References.CHANNELS_MAIN);
    }
    */
        //Caller to call the main function
    public static PircBotX getBot()
    {
        return bot;
    }
    
    
        //Add the classes to the listener
    public static void addListeners()
    {
        for (BotCommand command : CommandReferences.commands)
        {
            bot.getListenerManager().addListener(command);
        }
    }
    
    /*
        //Returns the amount of channels joined
    public static Channel[] getChannels()
    {
        Channel[] returnValue = new Channel[channels.length];
        
        for (int i = 0; i < returnValue.length; i++){
            returnValue[i] = bot.getChannel(channels[i]);
        }
        
        return returnValue;
    }
    */
        
            
        public static void main(String[] args) throws Exception 
        {
                
                //bot initializing main info
            bot.setName(NAME);
            bot.setVerbose(true);
            bot.setMessageDelay(500L);
            bot.setLogin(USER);
            bot.setVersion(VERSION);
            bot.setFinger(FINGER);
            
                //joining the IRC and identifying the bot
            bot.connect(NETWORK);
            bot.identify(PASSWORD);
            bot.joinChannel(CHANNEL);
            
                //adds the listeners we already initialized to the main program, this will activate them.
            addListeners();
            
            /*
                //joins the channels specified in "reference" and in this class
            for (String channel : channels){
                bot.joinChannel(channel);
            }
            */
            
        }
        
            //Used to call if we want to disconnect from IRC
        public static void disconnect()
        {
            try 
                {
                    bot.disconnect();
                    System.exit(0);
                } 
            catch (Exception e){}
        }
}