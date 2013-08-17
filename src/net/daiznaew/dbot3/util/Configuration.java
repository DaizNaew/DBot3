package net.daiznaew.dbot3.util;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import org.ini4j.*;

/**
 *
 * @author Daiz
 */

public class Configuration 
{
    
    public void CreateIni(String filename) throws IOException 
    {
        Wini ini = new Wini(new File(filename));
        int age = ini.get("happy", "age", int.class);
        double height = ini.get("happy", "height", double.class);
        String dir = ini.get("happy", "homeDir");
        
    }
    
    public void StoreDate (String filename) throws IOException
    {
        Wini ini = new Wini(new File(filename));

        ini.put("sleepy", "age", 55);
        ini.put("sleepy", "weight", 45.6);
        ini.store();
    }
    
}