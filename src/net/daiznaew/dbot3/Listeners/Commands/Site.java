package net.daiznaew.dbot3.Listeners.Commands;

import net.daiznaew.dbot3.Listeners.core.BotCommand;
import net.daiznaew.dbot3.util.Config;
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

public class Site extends BotCommand
{
    private final String sname;
    
    public Site()
    {
        getAliases().add("!site");
        getAliases().add("!website");
        setMinAccessLevel(AccessLevel.NORMAL);
        setArgumentsString("");
        setDescription("This goes to our website.");
        
        sname = Config.getProperty("website");
    }
    
    @Override
    @SuppressWarnings("empty-statement")
    public void onMessage(MessageEvent<PircBotX> event) throws Exception
    {
        if (performGenericChecks(event.getChannel(), event.getUser(), event.getMessage().split(" ")))
        {
            if (getArgs().length == 1)
            {
                Messages.respond(getChannel(), ColorFormat.NORMAL, getUser(), "All of the server info can be found on our website, at:");
                Messages.respond(getChannel(), ColorFormat.NORMAL, getUser(), sname);
            } else {
                showUsage();
            }
        }
    }
}