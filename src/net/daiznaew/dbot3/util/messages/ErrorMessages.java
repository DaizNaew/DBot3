package net.daiznaew.dbot3.util.messages;

import net.daiznaew.dbot3.util.enums.ColorFormat;
import org.pircbotx.Channel;
import org.pircbotx.User;

public class ErrorMessages
{

    public static void invalidNumber(Channel channel, User user)
    {
        Messages.respond(channel, ColorFormat.ERROR, user, "It seems you have input the wrong arguments!");
    }

    public static void invalidOperation(Channel channel, User user)
    {
        Messages.respond(channel, ColorFormat.ERROR, user, "I simply cannot do this!");
    }

    public static void minOverMax(Channel channel, User user)
    {
        Messages.respond(channel, ColorFormat.ERROR, user, "The specified minimum is over the specified maximum!");
    }

    public static void notCommand(Channel channel, User user, String command)
    {
        Messages.respond(channel, ColorFormat.ERROR, user, "Command &b'" + command + "'&n not found. Type &b!help&n for more info.");
    }
    
    public static void notFoundUser(Channel channel, User user, String player)
    {
        Messages.respond(channel, ColorFormat.ERROR, user, "Couldn't find the user &b'" + player + "'");
    }

    public static void notHighEnoughAccessLevel(Channel channel, User user)
    {
        Messages.respond(channel, ColorFormat.ERROR, user, "You do not have the required access level to perform that command.");
    }

    public static void notLink(Channel channel, User user, String link)
    {
        Messages.respond(channel, ColorFormat.ERROR, user, "&b'" + link + "' &nis not a valid link, retard! Get a list of links with &b!links");
    }

    public static void invalidUrl(Channel channel, User user, String url)
    {
        Messages.respond(channel, ColorFormat.ERROR, user, "Invalid URL: " + url);
    }
}
