package ca.sykesdev.veinminer.Utils;

import org.bukkit.ChatColor;

public class Message {
    /**
     * Basic formatter for message output from plugin
     * @param msg The message to embed
     * @return The formatted message
     */
    public static String formatMessage(String msg) {
        return ChatColor.translateAlternateColorCodes('&', "&6[" + " &fVeinMiner "
                + "&6]&f " + msg);
    }
}
