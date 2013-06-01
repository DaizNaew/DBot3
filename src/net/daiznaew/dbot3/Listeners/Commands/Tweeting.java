/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daiznaew.dbot3.Listeners.Commands;

import net.daiznaew.dbot3.listeners.core.BotCommand;
import net.daiznaew.dbot3.util.enums.AccessLevel;
import net.daiznaew.dbot3.util.references.References;
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
        setArgumentsString("This is used to update twitter news");
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
        
    	builder.setOAuthAccessToken(References.ACCESS_TOKEN);
    	builder.setOAuthAccessTokenSecret(References.ACCESS_TOKEN_SECRET);
    	builder.setOAuthConsumerKey(References.CONSUMER_KEY);
    	builder.setOAuthConsumerSecret(References.CONSUMER_SECRET);

        OAuthAuthorization auth = new OAuthAuthorization(builder.build());
        Twitter twitter = new TwitterFactory().getInstance(auth);
                
                
                String quote = "";
                for (int i = 2; i < getArgs().length; i++)
                {
                    quote += getArgs()[i] + " ";
                }
                quote = quote.substring(0, quote.length());
                twitter.updateStatus(quote);
           
                }
                else showUsage();
            }
        }
    }
