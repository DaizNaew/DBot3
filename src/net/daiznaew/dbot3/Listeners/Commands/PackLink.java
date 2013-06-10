/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daiznaew.dbot3.Listeners.Commands;

import net.daiznaew.dbot3.Listeners.core.BotCommand;
import net.daiznaew.dbot3.util.enums.AccessLevel;
import net.daiznaew.dbot3.util.enums.ColorFormat;
import net.daiznaew.dbot3.util.messages.Messages;
import net.daiznaew.dbot3.util.references.References;
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
                Messages.sendQuery(ColorFormat.NORMAL, getUser(), "The platform link is: "+References.PACK_DOWNLOAD);
            }
            else {
                showUsage();
            }
        }
    }
}