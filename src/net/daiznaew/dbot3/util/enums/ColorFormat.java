package net.daiznaew.dbot3.util.enums;

public enum ColorFormat
{
    /*
     * Colors in the "Colors" class:
     * 
     * NORMAL &n
     * BOLD &b
     * UNDERLINE &u
     * REVERSE &r
     * 
     * WHITE &1
     * BLACK &2
     * DARK_BLUE &3
     * DARK_GREEN &4
     * RED &5
     * BROWN &6
     * PURPLE &7
     * OLIVE &8
     * YELLOW &9
     * GREEN &10
     * TEAL &11
     * CYAN &12
     * BLUE &13
     * MAGENTA &14
     * DARK_GRAY &15
     * LIGHT_GRAY &16
     */
    
    NORMAL("&13"),  // Blue text text
    QUOTE("&12&r&3"),  // Dark blue text on cyan background
    ERROR("&5&r&1"),   // White text on red background
    CASINO("&1&r&14"), 
    POLL("&1&r&11");
    
    private ColorFormat(String format)
    {
        this.format = format;
    }

    private String format;

    @Override
    public String toString()
    {
        return format;
    }
}
