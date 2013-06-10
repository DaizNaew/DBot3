/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daiznaew.dbot3.Listeners.Commands;

import net.daiznaew.dbot3.Listeners.core.BotCommand;
import net.daiznaew.dbot3.util.enums.AccessLevel;
import net.daiznaew.dbot3.util.enums.ColorFormat;
import net.daiznaew.dbot3.util.messages.ErrorMessages;
import net.daiznaew.dbot3.util.messages.Messages;
import net.daiznaew.dbot3.util.references.CommandReferences;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;

/**
 *
 * @author Daiz
 */
public class Help extends BotCommand
{
    public Help() 
    {
        getAliases().add("!help");
        getAliases().add("!commands");

        setDescription("Shows this message");

        setMinAccessLevel(AccessLevel.NORMAL);

        setArgumentsString("");
    }
    
    @Override
    public void onMessage(MessageEvent<PircBotX> event) throws Exception
    {
        if (performGenericChecks(event.getChannel(), event.getUser(), event.getMessage().split(" ")))
        {
            if (getArgs().length == 1)
            {
                Messages.sendQuery(ColorFormat.NORMAL, getUser(), "This'll show all available commands, use !help <command> for more info.");
                Messages.sendQuery(ColorFormat.NORMAL, getUser(), "Commands:");

                for (BotCommand command : CommandReferences.getCommands())
                {
                    String commandHelp = "!" + command.getAliasesString() + " " + command.getArgumentsString() + " - " + command.getDescription() + " - Access Level: " + command.getMinAccessLevel().toString();
                    Messages.sendQuery(ColorFormat.NORMAL, getUser(), commandHelp);
                }

            } else if (getArgs().length == 2)
            {
                String argument = getArgs()[1];
                BotCommand command = argument.startsWith("!") ? BotCommand.getCommand(argument) : BotCommand.getCommand(argument.replace(argument, "!" + argument));

                if (command != null)
                {
                    Messages.sendNotice(ColorFormat.NORMAL, getUser(), "!" + command.getAliasesString() + " " + command.getArgumentsString() + " - " + command.getDescription() + " - Access Level: " + command.getMinAccessLevel());
                } else ErrorMessages.notCommand(getChannel(), getUser(), getArgs()[1]);
            } else showUsage();
        
        }
    }
    
}
