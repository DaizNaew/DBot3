/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daiznaew.dbot3.Listeners.Commands;

import net.daiznaew.dbot3.Listeners.core.BotCommand;
import net.daiznaew.dbot3.util.enums.AccessLevel;
import net.daiznaew.dbot3.util.enums.ColorFormat;
import net.daiznaew.dbot3.util.messages.Messages;
import net.daiznaew.dbot3.util.twitter.TwitterReferences;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;

/**
 *
 * @author Daiz
 */
public class PackLink extends BotCommand
{
    
    public PackLink() 
            {
        getAliases().add("!packlink");
        getAliases().add("!pack");
        getAliases().add("!download");
        getAliases().add("!launcher");
        
        
        setMinAccessLevel(AccessLevel.VOICE);
        
        setDescription("This is to get the pack for the server.");
        setArgumentsString("");
    }
    
    @Override
    @SuppressWarnings("empty-statement")
    public void onMessage(MessageEvent<PircBotX> event) throws Exception
    {
        if (performGenericChecks(event.getChannel(), event.getUser(), event.getMessage().split(" ")))
        {
            if (getArgs().length == 1)
            {
                Messages.sendQuery(ColorFormat.NORMAL, getUser(), "You'll need technic launcher to use our pack: http://www.technicpack.net/");
                Messages.sendQuery(ColorFormat.NORMAL, getUser(), "Before running the pack, open the launcher settings (Upper-right corner) and select the amount of memory you wish to allocate, as well as check the box for \"Increase PermGen Size.\"");
                Messages.sendQuery(ColorFormat.NORMAL, getUser(), "Now that you're all ready, you can use <!pack UHS> for info on our UHS pack, or <!pack 3> for our new server pack.");        
            }
            
            if (getArgs().length == 2)
            {
                String operation = getArgs()[1];
                
                        
                
                switch (operation) 
                {
                    
                    case "UHS":
                        Messages.sendQuery(ColorFormat.NORMAL, getUser(), "The platform link for our Legacy UHS server is: "+TwitterReferences.PACK_DOWNLOAD_UHS);
                        break;
                        
                    case "3":
                        Messages.sendQuery(ColorFormat.NORMAL, getUser(), "The platform link for our new 1.6.4 server is: "+TwitterReferences.PACK_DOWNLOAD_3);
                        break;
                    
                }
            }
        }
    }
}