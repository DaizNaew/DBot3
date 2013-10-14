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
                
                //sets the required accesslevel, aka voice, hop, op, or normal user
                setMinAccessLevel(AccessLevel.NORMAL);
                
                //sets a description for this command
                setDescription("Description");
                
                //sets arguments a user can use to activate additional features, refer to CommandCore.java
                setArgumentsString("<Arguments neded if any>");
        
            }
    
    //This checks for all incomming messages in the irc chat. theese er determined as EVENTS, we are looking for Message Events.
    public void onMessage(MessageEvent<PircBotX> event) throws Exception
    {
        
        //this is a check to get the channel of the message, the user who sent it, and the full message.
        if (performGenericChecks(event.getChannel(), event.getUser(), event.getMessage().split(" ")))
        {
                //in here you do the response code. 
                //example:
            
            String dance1 = "\\o/";
            String dance2 = "\\o\\";
            String dance3 = "\\o/";
            String dance4 = "/o/";
            

                
                  //Messages.respond is a pull from the Messages class, this is to customize various messages, responds, actions etc.
                  
                  //first getChannel() is to make sure it's in the same channel as the command was activated from
                  //second ColorFormat.<CODE> is to colour the responce, theese can be customized in ColorFormat.java
                  //third getUser() is to check the user who sent it is the same as the one to refer to, and will return the name of the user in the repsonce.
                  //last is the responce, "<message>" for a message, or a String for more advanced responce
                  Messages.respond(getChannel(), ColorFormat.NORMAL, getUser(), "Everybody dance now!");
                  Messages.respond(getChannel(), ColorFormat.NORMAL, getUser(), dance1);
                  Messages.respond(getChannel(), ColorFormat.NORMAL, getUser(), dance2);
                  Messages.respond(getChannel(), ColorFormat.NORMAL, getUser(), dance3);
                  Messages.respond(getChannel(), ColorFormat.NORMAL, getUser(), dance4);
                  
                  
                 
        }
    }
    
    
}