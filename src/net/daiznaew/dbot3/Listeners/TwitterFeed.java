/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daiznaew.dbot3.Listeners;

import java.util.List;
import net.daiznaew.dbot3.Listeners.core.BotCommand;
import net.daiznaew.dbot3.util.enums.AccessLevel;
import net.daiznaew.dbot3.util.enums.ColorFormat;
import net.daiznaew.dbot3.util.references.References;
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
        
    	builder.setOAuthAccessToken(References.ACCESS_TOKEN);
    	builder.setOAuthAccessTokenSecret(References.ACCESS_TOKEN_SECRET);
    	builder.setOAuthConsumerKey(References.CONSUMER_KEY);
    	builder.setOAuthConsumerSecret(References.CONSUMER_SECRET);

        OAuthAuthorization auth = new OAuthAuthorization(builder.build());
        Twitter twitter = new TwitterFactory().getInstance(auth);
        String[] srch = new String[] {"DaizNaew"};

              ResponseList<User> users = twitter.lookupUsers(srch);
              for (User user : users) {
                    if (user.getStatus() != null)
                    {
                    List<Status> statuses = twitter.getUserTimeline(user.getName(), new Paging(1,1));
                        for (Status status3 : statuses)
                        {
                            Messages.respond(getChannel(), ColorFormat.NORMAL, getUser(), "@DaizNaew: "+ status3.getText()+" - https://twitter.com/DaizNaew");
                        }
                    }
              }
            } else {
                showUsage();
            }
            
        }
    }
}
