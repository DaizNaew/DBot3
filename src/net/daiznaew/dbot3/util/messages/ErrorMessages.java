package net.daiznaew.dbot3.util.messages;

import net.daiznaew.dbot3.util.enums.ColorFormat;
import org.pircbotx.Channel;
import org.pircbotx.User;

public class ErrorMessages
{
    public static void alreadyActivated(Channel channel, User user)
    {
        Messages.respond(channel, ColorFormat.ERROR, user, "I'm already activated, retard!");
    }

    public static void alreadyDeactivated(Channel channel, User user)
    {
        Messages.respond(channel, ColorFormat.ERROR, user, "I'm already deactivated, retard!");
    }

    public static void invalidNumber(Channel channel, User user)
    {
        Messages.respond(channel, ColorFormat.ERROR, user, "It seems you have input the wrong arguments!");
    }

    public static void invalidOperation(Channel channel, User user)
    {
        Messages.respond(channel, ColorFormat.ERROR, user, "I simply cannot do this!");
    }

    public static void invalidQuoteUsage(Channel channel, User user)
    {
        Messages.respond(channel, ColorFormat.ERROR, user, "Invalid usage. Check a list of commands with &b!quotes help");
    }

    public static void minOverMax(Channel channel, User user)
    {
        Messages.respond(channel, ColorFormat.ERROR, user, "The specified minimum is over the specified maximum!");
    }

    public static void notCommand(Channel channel, User user, String command)
    {
        Messages.respond(channel, ColorFormat.ERROR, user, "Command &b'" + command + "'&n not found. Type &b!help&n for more info.");
    }

    public static void notEnoughQuotes(Channel channel, User user)
    {
        Messages.respond(channel, ColorFormat.ERROR, user, "There are not that many quotes! Check the quotes list with &b!quotes");
    }

    public static void notFoundPlayer(Channel channel, User user, String player)
    {
        Messages.respond(channel, ColorFormat.ERROR, user, "Couldn't find the player &b'" + player + "'");
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

    public static void quoteAlreadyExists(Channel channel, User user)
    {
        Messages.respond(channel, ColorFormat.ERROR, user, "That quote already exists, retard!");
    }

    public static void quoteDoesntExist(Channel channel, User user)
    {
        Messages.respond(channel, ColorFormat.ERROR, user, "That quote doesn't exist, retard!");
    }

    public static void invalidUrl(Channel channel, User user, String url)
    {
        Messages.respond(channel, ColorFormat.ERROR, user, "Invalid URL: " + url);
    }

    public static void notEnoughMoney(Channel channel, User user)
    {
        Messages.respond(channel, ColorFormat.ERROR, user, "You don't have enough money to do that!");
    }
    
    public static void invalidUser(Channel channel, User user, String other)
    {
        Messages.respond(channel, ColorFormat.ERROR, user, other + " doesn't exist in my database!");

    }

    public static void notChallengedToFlip(Channel channel, User user)
    {
        Messages.respond(channel, ColorFormat.ERROR, user, "Nobody challenged you to a coin flip, retard!");
    }

    public static void invalidPoll(Channel channel, User user)
    {
        Messages.respond(channel, ColorFormat.ERROR, user, "There is no poll with that ID!");
    }

    public static void pollAlreadyStarted(Channel channel, User user)
    {
        Messages.respond(channel, ColorFormat.ERROR, user, "That poll is already running!");
    }

    public static void invalidPollChoice(Channel channel, User user)
    {
        Messages.respond(channel, ColorFormat.ERROR, user, "That is an invalid choice!");
    }

    public static void notEnoughMoneyOther(Channel channel, User user, String other)
    {
        Messages.respond(channel, ColorFormat.ERROR, user, other + " doesn't have enough money to do that!");
    }
}
