package net.daiznaew.dbot3.Listeners.Commands;

/**
 *
 * @author Daiz
 */

import java.awt.Color;
import java.net.URLDecoder;
import java.net.URLEncoder;
import net.daiznaew.dbot3.Listeners.core.BotCommand;
import net.daiznaew.dbot3.util.enums.AccessLevel;
import net.daiznaew.dbot3.util.enums.ColorFormat;
import net.daiznaew.dbot3.util.messages.Messages;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;
import org.jsoup.*;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GoogleSearch extends BotCommand {
    
    public GoogleSearch() {
        
        
        getAliases().add("!g");
        getAliases().add("!search");
        getAliases().add("!google");
        
        setMinAccessLevel(AccessLevel.VOICE);
        
        setDescription("A command used to search through google.");
        
        setArgumentsString("<Search query>");
    }
    
    @Override
    public void onMessage(MessageEvent<PircBotX> event) throws Exception
    {
        if (performGenericChecks(event.getChannel(), event.getUser(), event.getMessage().split(" ")))
        {
            if (getArgs().length >= 2 ) 
            {
                String google = "http://www.google.com/search?q=";
                String charset = "UTF-8";
                String search = "";
                String userAgent = "DBot 3 (+https://github.com/DaizNaew/DBot3)";
                
                for (int i = 1; i < getArgs().length; i++)
                {
                    search += getArgs()[i] + " ";
                }
                
                Elements links = Jsoup.connect(google + URLEncoder.encode(search, charset)).userAgent(userAgent).get().select("li.g>h3>a");
                
                for (Element link : links)
                {
                    String title = link.text();
                    String url = link.absUrl("href"); // Google returns URLs in format "http://www.google.com/url?q=<url>&sa=U&ei=<someKey>".
                    url = URLDecoder.decode(url.substring(url.indexOf('=') + 1, url.indexOf('&')), "UTF-8");

                    if (!url.startsWith("http")) 
                    {
                        continue; // Ads/news/etc.
                    }
                    

                    Messages.respond(getChannel(), ColorFormat.NORMAL, getUser(), "Search results for: "+  search + "Title: "+title+" Url: "+url);
                
                } 
            } else { showUsage(); }
        }
    }
}
