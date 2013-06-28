package net.daiznaew.dbot3.Listeners.core;

import net.daiznaew.dbot3.util.enums.AccessLevel;
import net.daiznaew.dbot3.util.enums.ColorFormat;
import net.daiznaew.dbot3.util.messages.ErrorMessages;
import net.daiznaew.dbot3.util.messages.Messages;
import java.util.ArrayList;
import net.daiznaew.dbot3.util.references.CommandReferences;
import org.pircbotx.Channel;
import org.pircbotx.PircBotX;
import org.pircbotx.User;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

    /**
     * 
     * @author Daiz Naew
     * 
     * This class is used to control the listeners, and how they function.
     * It's being extended in all the listener classes, and holds the main functions.
     * everything is being built in this class for easier usage, and more flexibility.
     * 
     */

public abstract class BotCommand extends ListenerAdapter<PircBotX>
{
    private ArrayList<String> aliases = new ArrayList<>();
    private String[] args;
    private User user;
    private String description;
    private Channel channel;
    
        //gets the channel
    public Channel getChannel()
    {
        return channel;
    }

        //sets current channel to later call
    public void setChannel(Channel channel)
    {
        this.channel = channel;
    }
        
        //initializing the accesslevel control and arguments control
    private AccessLevel minAccessLevel;
    private String argumentsString;

        //gets the aliases for commands
    public ArrayList<String> getAliases()
    {
        return aliases;
    }
        
        //gets the listeners
    public static BotCommand getCommand(String command)
    {
        for (BotCommand botCommand : CommandReferences.getCommands())
        {
            if (botCommand.isAlias(command)) return botCommand;
        }
        return null;
    }

        //used to figure out the Aliases for the commands
    public String getAliasesString()
    {
        String returnValue = "";

        for (String alias : aliases)
        {
            returnValue += alias.replace("!", "") + "&15|&n";
        }

        return returnValue.substring(0, returnValue.length() - 6);
    }

        //returns the arguments for the commands
    public String[] getArgs()
    {
        return args;
    }

        //returns the required argument, if any.
    public String getArgumentsString()
    {
        return "&b&14" + argumentsString + "&n";
    }

        //returns the description of the command
    public String getDescription()
    {
        return "&7" + description + "&n";
    }

        //returns the access level required to use the command
    public AccessLevel getMinAccessLevel()
    {
        return minAccessLevel;
    }

        //returns the user trying to use the command
    public User getUser()
    {
        return user;
    }

        //turns the aliases for the commands valid
    public boolean isAlias(String alias)
    {
        for (String temp : aliases) {
            if (temp.equalsIgnoreCase(alias)) {return true;}
        }
        return false;
    }

        //utilizes the information we are getting to make the command checker.
        //It's checking the chat for valid commands and info.
    @Override
    public abstract void onMessage(MessageEvent<PircBotX> event) throws Exception;

    public boolean performGenericChecks(Channel channel, User user, String args[])
    {
        setChannel(channel);
        setUser(user);
        setArgs(args);
        
        {
            if (args[0].startsWith("!"))
            {
                if (isAlias(args[0]))
                {
                    if (AccessLevel.canAccess(AccessLevel.getAccessLevel(channel, user), this))
                    {
                            return true;
                    } else { ErrorMessages.notHighEnoughAccessLevel(getChannel(), user); }
                }
            }
        }
        return false;
    }

        //validates the aliases for the commands
    public void setAliases(ArrayList<String> aliases)
    {
        this.aliases = aliases;
    }

        //validates the arguments for the commands
    public void setArgs(String[] args)
    {
        this.args = args;
    }

        //validates the arguments for the command
    public void setArgumentsString(String argumentsString)
    {
        this.argumentsString = argumentsString;
    }

        //validates the description for the command
    public void setDescription(String description)
    {
        this.description = description;
    }

        //validates the access level required to use the command
    public void setMinAccessLevel(AccessLevel minAccessLevel)
    {
        this.minAccessLevel = minAccessLevel;
    }

        //validates the user for the command
    public void setUser(User user)
    {
        this.user = user;
    }

    /** 
    * 
    *   public void setWorksWhenDeactivated(boolean worksWhenDeactivated)
    *   {
    *       this.worksWhenDeactivated = worksWhenDeactivated;
    *   }
    * 
    **/

        //show the valid usages of the command trying to call, also being called in the help command
    public void showUsage() throws Exception
    {
        Messages.sendMessage(getChannel(), ColorFormat.NORMAL, user.getNick() + ": " + getAliasesString() + " " + getArgumentsString());
    }

}
