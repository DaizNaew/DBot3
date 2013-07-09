package net.daiznaew.dbot3.Listeners.Commands;

import net.daiznaew.dbot3.Listeners.core.BotCommand;
import net.daiznaew.dbot3.main.DaizBot;
import net.daiznaew.dbot3.util.enums.AccessLevel;
import org.pircbotx.PircBotX;
import org.pircbotx.User;
import org.pircbotx.hooks.events.MessageEvent;

/**
 *
 * @author Daiz
 */

public class AccessList extends BotCommand {
    
    public AccessList()
    {
        getAliases().add("!add");
        setMinAccessLevel(AccessLevel.OP);        
        setArgumentsString("<Level> <User>");
        setDescription("This is used to create an auto access list.");
    }
    
    @Override
    @SuppressWarnings("empty-statement")
    public void onMessage(MessageEvent<PircBotX> event) throws Exception
    {
        if (performGenericChecks(event.getChannel(), event.getUser(), event.getMessage().split(" ")))
        {
            if (getArgs().length == 4)
            {
                String operation = getArgs()[1];
                String operable = getArgs()[2];
                String argument = getArgs()[3];
                User user = DaizBot.getBot().getUser(operable);
                String hostMask = user.getHostmask();
                
            }
        }
    }
    

}
