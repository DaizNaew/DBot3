/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daiznaew.dbot3.Listeners.Commands;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;
import net.daiznaew.dbot3.Listeners.core.BotCommand;
import net.daiznaew.dbot3.util.enums.ColorFormat;
import net.daiznaew.dbot3.util.enums.AccessLevel;
import net.daiznaew.dbot3.util.messages.ErrorMessages;
import net.daiznaew.dbot3.util.messages.Messages;
import net.daiznaew.dbot3.util.NumberMethods;

/**
 *
 * @author Daiz
 */
public class Calculator extends BotCommand {
    
    public Calculator()
    {
        getAliases().add("!calculate");
        getAliases().add("!calc");
        
        setMinAccessLevel(AccessLevel.VOICE);

        setDescription("A simple calculator");


        setArgumentsString("<number1> <+-*/^%> <number2>|sqrt <number>");
    }

    @Override
    @SuppressWarnings("empty-statement")
    public void onMessage(MessageEvent<PircBotX> event) throws Exception
    {
        if (performGenericChecks(event.getChannel(), event.getUser(), event.getMessage().split(" ")))
        {
            if (getArgs().length == 4)
            {
                String operation = getArgs()[2];

                if (NumberMethods.isDouble(getArgs()[1]) && NumberMethods.isDouble(getArgs()[3]))
                {
                    double num1 = Double.valueOf(getArgs()[1]);
                    double num2 = Double.valueOf(getArgs()[3]);
                    switch (operation)
                    {
                        case "+":
                            Messages.respond(getChannel(), ColorFormat.NORMAL, getUser(), num1 + " + " + num2 + " = &b" + (num1 + num2));
                            break;
                        case "-":
                            Messages.respond(getChannel(), ColorFormat.NORMAL, getUser(), num1 + " - " + num2 + " = &b" + (num1 - num2));
                            break;
                        case "*":
                            Messages.respond(getChannel(), ColorFormat.NORMAL, getUser(), num1 + " * " + num2 + " = &b" + (num1 * num2));
                            break;
                        case "/":
                            Messages.respond(getChannel(), ColorFormat.NORMAL, getUser(), num1 + " / " + num2 + " = &b" + (num1 / num2));
                            break;
                        case "^":
                            Messages.respond(getChannel(), ColorFormat.NORMAL, getUser(), num1 + " ^ " + num2 + " = &b" + (Math.pow(num1, num2)));
                            break;
                        case "%":
                            Messages.respond(getChannel(), ColorFormat.NORMAL, getUser(), num1 + "% of " + num2 + " = &b" + (num2 / 100 * num1));
                            break;
                        default:
                            ErrorMessages.invalidOperation(getChannel(), getUser());
                            break;
                    }
                } else ErrorMessages.invalidNumber(getChannel(), event.getUser());
            } else if (getArgs().length == 3)
            {
                String operation = getArgs()[1];

                if (NumberMethods.isDouble(getArgs()[2]))
                {
                    double number = Double.valueOf(getArgs()[2]);
                    switch (operation)
                    {
                        case "sqrt":
                            Messages.respond(getChannel(), ColorFormat.NORMAL, getUser(), "The square root of " + number + " = &b" + Math.sqrt(number));
                            break;
                        default:
                            ErrorMessages.invalidOperation(getChannel(), getUser());
                            break;
                    }
                } else ErrorMessages.invalidNumber(getChannel(), event.getUser());
            } else showUsage();
        }
    }
}

