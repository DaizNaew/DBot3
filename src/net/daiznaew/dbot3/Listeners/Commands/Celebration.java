package net.daiznaew.dbot3.Listeners.Commands;

import net.daiznaew.dbot3.Listeners.core.BotCommand;
import net.daiznaew.dbot3.util.enums.AccessLevel;
import net.daiznaew.dbot3.util.enums.ColorFormat;
import net.daiznaew.dbot3.util.messages.Messages;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;

/**
 *
 * @author Daiz
 */

//A test to show how to program new commands
public class Celebration extends BotCommand {
    
    //creates a constructor for the various information, which botcommand class needs
    public Celebration()
            {
                
                //this determines the word that will activate this particular class
                getAliases().add("!Celebrate");
                getAliases().add("!Dance");
                
                //sets the required accesslevel, aka voice, hop, op, or normal user
                setMinAccessLevel(AccessLevel.NORMAL);
                
                //sets a description for this command
                setDescription("Performs a celebratory dance");
                
                //sets arguments a user can use to activate additional features, refer to CommandCore.java
                setArgumentsString("");
        
            }
    
    public void onMessage(MessageEvent<PircBotX> event) throws Exception
    {
        
        if (performGenericChecks(event.getChannel(), event.getUser(), event.getMessage().split(" ")))
        {
            
            String dance1 = "\\o/";
            String dance2 = "\\o\\";
            String dance3 = "\\o/";
            String dance4 = "/o/";
            
                  Messages.respond(getChannel(), ColorFormat.NORMAL, getUser(), "Everybody dance now!");
                  Messages.respond(getChannel(), ColorFormat.NORMAL, getUser(), dance1);
                  Messages.respond(getChannel(), ColorFormat.NORMAL, getUser(), dance2);
                  Messages.respond(getChannel(), ColorFormat.NORMAL, getUser(), dance3);
                  Messages.respond(getChannel(), ColorFormat.NORMAL, getUser(), dance4);}
    }
}