package net.daiznaew.dbot3.Listeners.Commands;

import net.daiznaew.dbot3.Listeners.core.BotCommand;
import net.daiznaew.dbot3.util.enums.AccessLevel;
import net.daiznaew.dbot3.util.enums.ColorFormat;
import net.daiznaew.dbot3.util.messages.Messages;
import net.daiznaew.dbot3.util.twitter.TwitterReferences;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;
import twitter4j.*;
import twitter4j.auth.OAuthAuthorization;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author Daiz
 */

public class Tweeting extends BotCommand {

    public Tweeting()
    {
        getAliases().add("!tweet");        
        setMinAccessLevel(AccessLevel.OP);        
        setArgumentsString("<Message>");
        setDescription("This is used to update twitter news.");
    }
    
    Twitter twitter = TwitterFactory.getSingleton();
    
    @Override
    @SuppressWarnings("empty-statement")
    public void onMessage(MessageEvent<PircBotX> event) throws Exception
    {
        if (performGenericChecks(event.getChannel(), event.getUser(), event.getMessage().split(" ")))
        {            
            if (getArgs().length >= 2 )
            {

        ConfigurationBuilder builder = new ConfigurationBuilder();
        
        //builds the access to the twitter, references does not exist on github for privacy reasons
    	builder.setOAuthAccessToken(TwitterReferences.ACCESS_TOKEN);
    	builder.setOAuthAccessTokenSecret(TwitterReferences.ACCESS_TOKEN_SECRET);
    	builder.setOAuthConsumerKey(TwitterReferences.CONSUMER_KEY);
    	builder.setOAuthConsumerSecret(TwitterReferences.CONSUMER_SECRET);

        //builds the authorizer and authorizes for valid twitter instance
        OAuthAuthorization auth = new OAuthAuthorization(builder.build());
        Twitter twitter = new TwitterFactory().getInstance(auth);
                
                //this gets the message we want to tweet
                String quote = "";
                for (int i = 1; i < getArgs().length; i++)
                {
                    quote += getArgs()[i] + " ";
                }
                
                //compiles the tweet into a usable twitter tweet and uploads it
                quote = quote.substring(0, quote.length());
                twitter.updateStatus(quote);
                
                //informs the user that it has been done
                Messages.respond(getChannel(), ColorFormat.NORMAL, getUser(), "Twitter updated successfully!");
           
                } else { showUsage();
            }
        }
    }
}