package net.daiznaew.dbot3.Listeners.Commands;

import javax.management.timer.Timer;
import net.daiznaew.dbot3.Listeners.core.BotCommand;
import net.daiznaew.dbot3.main.DaizBot;
import net.daiznaew.dbot3.util.enums.AccessLevel;
import net.daiznaew.dbot3.util.enums.ColorFormat;
import net.daiznaew.dbot3.util.messages.Messages;
import net.daiznaew.dbot3.util.Config;
import org.pircbotx.Channel;
import org.pircbotx.PircBotX;
import org.pircbotx.User;
import org.pircbotx.hooks.events.MessageEvent;

/**
 *
 * @author Daiz
 */

public class CommandCore extends BotCommand 
{
    private static String NETWORK = Config.getProperty("network");

    public CommandCore() 
    {
        getAliases().add("!do");
        setMinAccessLevel(AccessLevel.HALFOP);        
        setArgumentsString("<Action> <Operable> <Optional Argument>");
        setDescription("This is the new core command center.");
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
                
                switch (operation)
                {
                    
                    case "kick":
                        DaizBot.getBot().kick(event.getChannel(), user, argument);
                        Messages.sendNotice(ColorFormat.NORMAL, user, "http://i.imgur.com/OA3pP8l.jpg");
                        break;
                        
                    case "kb":
                        DaizBot.getBot().ban(getChannel(), hostMask);
                        DaizBot.getBot().kick(event.getChannel(), user, argument);
                        Messages.sendNotice(ColorFormat.NORMAL, user, "http://i.imgur.com/OA3pP8l.jpg");
                        break;
                }
            }
            
            if (getArgs().length == 3)
            {
                String operation = getArgs()[1];
                String operable = getArgs()[2];
                User user = DaizBot.getBot().getUser(operable);
                String hostMask = user.getHostmask();
                
                switch (operation)
                {
                    
                    case "kick":
                        DaizBot.getBot().kick(event.getChannel(), user);
                        Messages.sendNotice(ColorFormat.NORMAL, user, "http://i.imgur.com/OA3pP8l.jpg");
                        break;
                        
                    case "ban":
                        DaizBot.getBot().ban(getChannel(), hostMask);
                        break;
                        
                    case "kb":
                        DaizBot.getBot().ban(getChannel(), hostMask);
                        DaizBot.getBot().kick(event.getChannel(), user);
                        Messages.sendNotice(ColorFormat.NORMAL, user, "http://i.imgur.com/OA3pP8l.jpg");
                        break;
                        
                    case "join":
                        DaizBot.bot.joinChannel(operable);
                        break;
                        
                    case "leave":
                        Channel channel = DaizBot.getBot().getChannel(operable);
                        DaizBot.bot.partChannel(channel);
                        break;
                    
                    case "op":
                        DaizBot.bot.op(event.getChannel(), user);
                        break;
                        
                    case "hop":
                        DaizBot.bot.halfOp(event.getChannel(), user);
                        break;
                        
                    case "voice":
                        DaizBot.bot.voice(event.getChannel(), user);
                        break;                        
                }
            }
            
                if (getArgs().length == 2)
                {
                    String operation = getArgs()[1];
                    switch (operation)
                    {
                        case "leave":
                            DaizBot.bot.partChannel(event.getChannel());
                            break;
                            
                        case "stop":
                            System.exit(1);
                            break;
                            
                    }
                }
            } 
        }
    }