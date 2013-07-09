package net.daiznaew.dbot3.Listeners;

import java.util.List;
import net.daiznaew.dbot3.Listeners.core.BotCommand;
import net.daiznaew.dbot3.util.enums.AccessLevel;
import net.daiznaew.dbot3.util.enums.ColorFormat;
import net.daiznaew.dbot3.util.twitter.TwitterReferences;
import net.daiznaew.dbot3.util.messages.Messages;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;
import twitter4j.*;
import twitter4j.auth.OAuthAuthorization;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author Daiz
 */

public class TwitterFeed extends BotCommand 
{

    public TwitterFeed()
    {
        getAliases().add("!news");       
        
        setMinAccessLevel(AccessLevel.NORMAL);   
        
        setDescription("This is used to pull the news from our twitter.");
        setArgumentsString("");
    }
    
    Twitter twitter = TwitterFactory.getSingleton();
    
    @Override
    @SuppressWarnings("empty-statement")
    public void onMessage(MessageEvent<PircBotX> event) throws Exception
    {
        if (performGenericChecks(event.getChannel(), event.getUser(), event.getMessage().split(" ")))
        {            
            if (getArgs().length == 1 )
            {

        ConfigurationBuilder builder = new ConfigurationBuilder();
        
    	builder.setOAuthAccessToken(TwitterReferences.ACCESS_TOKEN);
    	builder.setOAuthAccessTokenSecret(TwitterReferences.ACCESS_TOKEN_SECRET);
    	builder.setOAuthConsumerKey(TwitterReferences.CONSUMER_KEY);
    	builder.setOAuthConsumerSecret(TwitterReferences.CONSUMER_SECRET);

        OAuthAuthorization auth = new OAuthAuthorization(builder.build());
        Twitter twitter = new TwitterFactory().getInstance(auth);
        
        //defines the user to lookup
        String[] srch = new String[] {"DaizNaew"};

              ResponseList<User> users = twitter.lookupUsers(srch);
              for (User user : users) 
              {
                    if (user.getStatus() != null)
                    {
                    List<Status> statuses = twitter.getUserTimeline(user.getName(), new Paging(1,1));
                        for (Status status3 : statuses)
                        {
                            Messages.respond(getChannel(), ColorFormat.NORMAL, getUser(), "@DaizNaew: "+ status3.getText()+" - https://twitter.com/DaizNaew");
                        }
                    }
              }
            } else { showUsage(); }            
        }
    }
}
