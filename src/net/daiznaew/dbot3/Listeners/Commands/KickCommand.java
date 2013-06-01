/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daiznaew.dbot3.Listeners.Commands;

import net.daiznaew.dbot3.listeners.core.BotCommand;
import net.daiznaew.dbot3.util.enums.AccessLevel;
import net.daiznaew.dbot3.util.enums.ColorFormat;
import net.daiznaew.dbot3.util.messages.ErrorMessages;
import net.daiznaew.dbot3.util.messages.Messages;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;

/**
 *
 * @author Daiz
 */
public class KickCommand extends BotCommand 
{
    public KickCommand() 
            {
                
        getAliases().add("!kick");
        getAliases().add("!ban");
        
        setMinAccessLevel(AccessLevel.OP);
        
        setArgumentsString("<kick/ban> <player name>");
    
            }
    
    @Override
    @SuppressWarnings("empty-statement")
    public void onMessage(MessageEvent<PircBotX> event) throws Exception
    {
        if (performGenericChecks(event.getChannel(), event.getUser(), event.getMessage().split(" ")))
        {
            if (getArgs().length == 3)
            {
                String playerName = getArgs()[3];
                String operation = getArgs()[2];
                String admin = "";
                
                if (getArgs()[1].equalsIgnoreCase(admin))
                {
                    switch (operation)
                    {
                        case "!kick":
                           // Messages.sendAction(action, playerName);
                        
                    }
                }

                } 
                else 
                {
                   // ErrorMessages.notFoundPlayer(getChannel(), getUser(), playerName);
                };
        }
    }
}
