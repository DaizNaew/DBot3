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
    String readnext;
    
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
                int linenum = Integer.valueOf(getArgs()[1]) + 1;
                
                in = new BufferedReader(new FileReader("captainslogs.txt"));
                
                int linecount = 1;
                
                readnext = in.readLine();
                read = "No entries found! Please make the Captain sit down and write something before we all die!!";
                
                while(linenum > 0 && readnext != null)
                {
                read = readnext;
                readnext = in.readLine();
                linenum--;
                linecount++;
                }
                
                Messages.respond(getChannel(), ColorFormat.NORMAL, getUser(), "Captain's Log entry #" +linecount.toString()+ ": " +read+ " Log ended.");
                
                in.close();
            }
        }
    }
}
