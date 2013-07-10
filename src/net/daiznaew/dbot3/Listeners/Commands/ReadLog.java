
package net.daiznaew.dbot3.Listeners.Commands;

import java.io.BufferedReader;
import java.io.FileReader;
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

public class ReadLog extends BotCommand {
    
    BufferedReader in;
    String read;
    
    public ReadLog()
    {
        getAliases().add("!read");
        setMinAccessLevel(AccessLevel.NORMAL);        
        setArgumentsString("<Number>");
        setDescription("A command to read the logs");
    }
    
    @Override
    @SuppressWarnings("empty-statement")
    public void onMessage(MessageEvent<PircBotX> event) throws Exception
    {
        if (performGenericChecks(event.getChannel(), event.getUser(), event.getMessage().split(" ")))
        {
            if(getArgs().length == 2)
            {
                //identifies the number for the log line
                int linenum = Integer.valueOf(getArgs()[1]);
                
                //finds the text file to read
                in = new BufferedReader(new FileReader("captainslogs.txt"));
                
                //this checks for the line we are requesting
                while(linenum > 0)
                {
                read = in.readLine();
                linenum--;
                }
                
                //responds
                Messages.respond(getChannel(), ColorFormat.NORMAL, getUser(), "Captain's Log: "+read+" Log ended.");
                
                //prepares for a new reading
                in.close();
            }
        }
    }
}
