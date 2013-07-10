package net.daiznaew.dbot3.util.enums;


import net.daiznaew.dbot3.main.DaizBot;
import net.daiznaew.dbot3.Listeners.core.BotCommand;
import net.daiznaew.dbot3.util.Config;
import org.pircbotx.Channel;
import org.pircbotx.User;

/**
 *
 * @author Daiz
 * 
 * This enum is used to get the operator levels of the users in the channel.
 * very usable.
 * 
 */

public enum AccessLevel
{
    NORMAL(0, "&6Normal User"), VOICE(1, "&12Voiced User"), HALFOP(2, "&4Half Operator"), OP(3, "&8Operator"), SUPEROP(4, "&13Super Operator"), OWNER(5, "&5Owner");
    
    private static Channel CHANNEL = DaizBot.getBot().getChannel(Config.getProperty("channel"));
    
    private int level;
    private String string;
    
    private AccessLevel(int level, String string)
    {
        this.level = level;
        this.string = string;
    }

    public static boolean canAccess(AccessLevel level, BotCommand command)
    {
        if (command.getMinAccessLevel().getLevel() <= level.getLevel()) 
        {
            return true;
        } 
        else 
        {
            return false;
        }
    }

    public static AccessLevel getAccessLevel(Channel channel, User user)
    {
        if (channel == null) 
        {
            channel = CHANNEL;
        }
        
        if (channel.isOwner(user)) 
        {
            return OWNER;
        }
        
        if (channel.isSuperOp(user)) 
        {
            return SUPEROP;
        }
        
        if (channel.isOp(user)) 
        {
            return OP;
        }
        
        if (channel.isHalfOp(user)) 
        {
            return HALFOP;
        }
        
        if (channel.hasVoice(user)) 
        {
            return VOICE;
        }
        
        return NORMAL;
    }

    public int getLevel()
    {
        return level;
    }

    @Override
    public String toString()
    {
        return "&4" + string + "&n";
    }
}
