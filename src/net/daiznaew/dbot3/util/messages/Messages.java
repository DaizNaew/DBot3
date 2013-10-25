package net.daiznaew.dbot3.util.messages;

import net.daiznaew.dbot3.main.DaizBot;
import net.daiznaew.dbot3.util.enums.ColorFormat;
import org.pircbotx.Channel;
import org.pircbotx.Colors;
import org.pircbotx.User;
;


public class Messages
{
    public static String convertColors(ColorFormat format, String message)
    {
        message = format + message;
        message = message.replace("&n", Colors.NORMAL + format);
        message = message.replace("&b", Colors.BOLD);
        message = message.replace("&u", Colors.UNDERLINE);
        message = message.replace("&r", Colors.REVERSE);
        message = message.replace("&16", Colors.LIGHT_GRAY);
        message = message.replace("&15", Colors.DARK_GRAY);
        message = message.replace("&14", Colors.MAGENTA);
        message = message.replace("&13", Colors.BLUE);
        message = message.replace("&12", Colors.CYAN);
        message = message.replace("&11", Colors.TEAL);
        message = message.replace("&10", Colors.GREEN);
        message = message.replace("&9", Colors.YELLOW);
        message = message.replace("&8", Colors.OLIVE);
        message = message.replace("&7", Colors.PURPLE);
        message = message.replace("&6", Colors.BROWN);
        message = message.replace("&5", Colors.RED);
        message = message.replace("&4", Colors.DARK_GREEN);
        message = message.replace("&3", Colors.DARK_BLUE);
        message = message.replace("&2", Colors.BLACK);
        message = message.replace("&1", Colors.WHITE);
        return message;
    }

    public static void respond(Channel channel, ColorFormat format, User user, String message)
    {
        if (channel != null) {
            DaizBot.getBot().sendMessage(channel, convertColors(format, user.getNick() + ": " + message));
        }
        else {
            DaizBot.getBot().sendMessage(user, convertColors(format, user.getNick() + ": " + message));
        }
    }

    public static void respondRaw(Channel channel, ColorFormat format, User user, String message)
    {
        if (channel != null) {
            DaizBot.getBot().sendMessage(channel, user.getNick() + ": " + message);
        }
        else {
            DaizBot.getBot().sendMessage(user, user.getNick() + ": " + message);
        }
    }

    public static void sendMessage(Channel[] channels, ColorFormat format, String message)
    {
        for (Channel channel : channels) {
            sendMessage(channel, format, message);
        }
    }
    
    public static void sendMessage(Channel channel, String message)
    {
        DaizBot.getBot().sendMessage(channel, message);
    }
    
    public static void sendMessage(Channel channel, ColorFormat format, String message)
    {
        DaizBot.getBot().sendMessage(channel, convertColors(format, message));
    }

    public static void sendNotice(ColorFormat format, User user, String message)
    {
        DaizBot.getBot().sendNotice(user, convertColors(format, message));
    }
    
    public static void sendQuery(ColorFormat format, User user, String message)
    {
        DaizBot.getBot().sendMessage(user, convertColors(format, message));
    }
    
    public static void sendAction(String target, String action)
    {
        DaizBot.getBot().sendAction(target, action);
    }
}