package ca.sykesdev.veinminer.Utils;

import org.bukkit.ChatColor;

public class Message {
    public static String formatMessage(String msg) {
        return ChatColor.translateAlternateColorCodes('&', "&6[" + " &fVeinMiner "
                + "&6]&f " + msg);
    }
}
