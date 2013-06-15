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

public abstract class BotCommand extends ListenerAdapter<PircBotX>
{
    private ArrayList<String> aliases = new ArrayList<>();
    private String[] args;
    private User user;
    private String description;
    private Channel channel;
    
    public Channel getChannel()
    {
        return channel;
    }

    public void setChannel(Channel channel)
    {
        this.channel = channel;
    }

    private AccessLevel minAccessLevel;
    private String argumentsString;
    private boolean worksWhenDeactivated;


    public ArrayList<String> getAliases()
    {
        return aliases;
    }
    
    public static BotCommand getCommand(String command)
    {
        for (BotCommand botCommand : CommandReferences.getCommands())
        {
            if (botCommand.isAlias(command)) return botCommand;
        }
        return null;
    }

    public String getAliasesString()
    {
        String returnValue = "";

        for (String alias : aliases)
        {
            returnValue += alias.replace("!", "") + "&15|&n";
        }

        return returnValue.substring(0, returnValue.length() - 6);
    }

    public String[] getArgs()
    {
        return args;
    }

    public String getArgumentsString()
    {
        return "&b&14" + argumentsString + "&n";
    }

    public String getDescription()
    {
        return "&7" + description + "&n";
    }

    public AccessLevel getMinAccessLevel()
    {
        return minAccessLevel;
    }

    public User getUser()
    {
        return user;
    }

    public boolean isAlias(String alias)
    {
        for (String temp : aliases) {
            if (temp.equalsIgnoreCase(alias)) {return true;}
        }
        return false;
    }

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

    public void setAliases(ArrayList<String> aliases)
    {
        this.aliases = aliases;
    }

    public void setArgs(String[] args)
    {
        this.args = args;
    }

    public void setArgumentsString(String argumentsString)
    {
        this.argumentsString = argumentsString;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setMinAccessLevel(AccessLevel minAccessLevel)
    {
        this.minAccessLevel = minAccessLevel;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public void setWorksWhenDeactivated(boolean worksWhenDeactivated)
    {
        this.worksWhenDeactivated = worksWhenDeactivated;
    }

    public void showUsage() throws Exception
    {
        Messages.sendMessage(getChannel(), ColorFormat.NORMAL, user.getNick() + ": " + getAliasesString() + " " + getArgumentsString());
    }

}
