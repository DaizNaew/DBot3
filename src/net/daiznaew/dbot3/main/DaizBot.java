
package net.daiznaew.dbot3.main;

import net.daiznaew.dbot3.listeners.core.Help;
import net.daiznaew.dbot3.Listeners.Messages;
import org.pircbotx.Channel;
import org.pircbotx.PircBotX;
import net.daiznaew.dbot3.util.references.References;
import net.daiznaew.dbot3.Listeners.Commands.Calculator;
import net.daiznaew.dbot3.Listeners.TwitterFeed;
import net.daiznaew.dbot3.Listeners.Commands.DegreesCalc;
import net.daiznaew.dbot3.Listeners.Commands.Tweeting;
import net.daiznaew.dbot3.Listeners.Commands.PackLink;
/**
 *
 * @author Daiz
 */
public class DaizBot 
{
    
    public static PircBotX bot = new PircBotX(); 
        
    private static String[] channels = { References.CHANNELS_MAIN };
    
    public static Channel getMainChannel()
    {
        return bot.getChannel(References.CHANNELS_MAIN);
    }
    public static PircBotX getBot()
    {
        return bot;
    }
    
        public static Channel[] getChannels()
    {
        Channel[] returnValue = new Channel[channels.length];
        
        for (int i = 0; i < returnValue.length; i++){
            returnValue[i] = bot.getChannel(channels[i]);
        }
        
        return returnValue;
    }
        
    
        public static void main(String[] args) throws Exception 
        {
            
            bot.setName(References.BOT_NAME);
            bot.setVerbose(true);
            bot.setMessageDelay(500L);
            bot.setLogin(References.BOT_USER_NAME);
            bot.setVersion(References.BOT_VERSION);
            bot.setFinger(References.BOT_FINGER);
            
            
            bot.connect(References.NETWORK_NAME);
            bot.identify(References.BOT_PASSWORD);
            
            bot.getListenerManager().addListener(new Messages());
            bot.getListenerManager().addListener(new Help());
            bot.getListenerManager().addListener(new Calculator());
            bot.getListenerManager().addListener(new TwitterFeed());
            bot.getListenerManager().addListener(new DegreesCalc());
            bot.getListenerManager().addListener(new Tweeting());
            bot.getListenerManager().addListener(new PackLink());
            
            for (String channel : channels){
                bot.joinChannel(channel);
            }
            
        }
        
        public static void disconnect()
    {
        try 
        {
            bot.disconnect();
            System.exit(0);
        } 
        catch (Exception e)
        {
        }
    }
    
}
