/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daiznaew.dbot3.util.references;

import net.daiznaew.dbot3.Listeners.Commands.Calculator;
import net.daiznaew.dbot3.Listeners.Commands.CommandCore;
import net.daiznaew.dbot3.Listeners.Commands.DegreesCalc;
import net.daiznaew.dbot3.Listeners.Commands.Help;
import net.daiznaew.dbot3.Listeners.Commands.PackLink;
import net.daiznaew.dbot3.Listeners.Commands.Site;
import net.daiznaew.dbot3.Listeners.Commands.Tweeting;
import net.daiznaew.dbot3.Listeners.TwitterFeed;
import net.daiznaew.dbot3.Listeners.core.BotCommand;

/**
 *
 * @author Daiz
 */
public class CommandReferences {
    
    public static Calculator commandCalculate = new Calculator();
    public static DegreesCalc commandDegreesCalc = new DegreesCalc();
    public static PackLink commandPackLink = new PackLink();
    public static Tweeting commandTweeting = new Tweeting();
    public static TwitterFeed commandTwitterFeed = new TwitterFeed();
    public static Help commandHelp = new Help();
    public static Site commandSite = new Site();
    public static CommandCore commandCore = new CommandCore();
    
    public static BotCommand[] commands = {commandCalculate, commandDegreesCalc, commandPackLink, commandTweeting, commandTwitterFeed, commandHelp, commandSite, commandCore };
    
    public static BotCommand[] getCommands()
    {
        return commands;
    }
    
}
