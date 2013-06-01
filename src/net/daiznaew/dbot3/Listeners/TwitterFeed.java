/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daiznaew.dbot3.Listeners;

import java.util.List;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;
import twitter4j.*;
import twitter4j.auth.OAuthAuthorization;
import twitter4j.conf.ConfigurationBuilder;
import net.daiznaew.dbot3.util.references.References;

/**
 *
 * @author Daiz
 */
public class TwitterFeed extends ListenerAdapter {
        
        
        @Override
        public void onMessage (MessageEvent event )throws Exception {
        if (event.getMessage().equalsIgnoreCase("!news")){            
        
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
                             event.getBot().sendMessage(event.getChannel(),"@DaizNaew: "+ status3.getText()+" - https://twitter.com/DaizNaew");
                     }
                    }
              }
        }
        }
}