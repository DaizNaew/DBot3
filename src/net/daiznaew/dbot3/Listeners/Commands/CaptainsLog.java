/*
 * This was requested by snaiperskaya.
 * I bring him this because he is so kawaii desu~ <3
 * 
 */

package net.daiznaew.dbot3.Listeners.Commands;

import java.io.*;
import net.daiznaew.dbot3.Listeners.core.BotCommand;
import net.daiznaew.dbot3.util.enums.AccessLevel;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;

/**
 *
 * @author Daiz
 */

public class CaptainsLog extends BotCommand 
{
    BufferedWriter out;
    BufferedReader in;
    String read;

    public CaptainsLog()
    {
        
        
        getAliases().add("!log");
        setMinAccessLevel(AccessLevel.OP);        
        setArgumentsString("<Message>");
        setDescription("A command to log things, usefull for snoosnoo.");
    }
    
    @Override
    @SuppressWarnings("empty-statement")
    public void onMessage(MessageEvent<PircBotX> event) throws Exception
    {
        if (performGenericChecks(event.getChannel(), event.getUser(), event.getMessage().split(" ")))
        {
            
            if (getArgs().length >= 2)
            {
                
                String quote = "";
                
                for (int i = 1; i < getArgs().length; i++)
                {
                    quote += getArgs()[i] + " ";
                }
                quote = quote.substring(0, quote.length());
                out = new BufferedWriter(new FileWriter("captainslogs.txt",true));
                
                out.write(quote);
                out.newLine();
                out.close();
                
            } else {showUsage();}
        }
    }
}