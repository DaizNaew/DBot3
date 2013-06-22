/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daiznaew.dbot3.Listeners.Commands;

import net.daiznaew.dbot3.Listeners.core.BotCommand;
import net.daiznaew.dbot3.main.DaizBot;
import net.daiznaew.dbot3.util.enums.AccessLevel;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;

/**
 *
 * @author Daiz
 */
public class JoinChannel extends BotCommand 
{
    
    public JoinChannel() 
    {
        getAliases().add("!join");
        getAliases().add("!invite");
        getAliases().add("!j");
        getAliases().add("!goto");
        setMinAccessLevel(AccessLevel.OP);        
        setArgumentsString("<Channel>");
        setDescription("This command is used to move the bot.");
    }
    
    @Override
    @SuppressWarnings("empty-statement")
    public void onMessage(MessageEvent<PircBotX> event) throws Exception
    {
        if (performGenericChecks(event.getChannel(), event.getUser(), event.getMessage().split(" ")))
        {
            if (getArgs().length == 2)
            {
                String channel = getArgs()[1];
                {
                    DaizBot.bot.joinChannel(channel);
                }
            } else {
                showUsage();
            }
        }
    }
    
}
