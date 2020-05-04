package ca.sykesdev.veinminer.Utils;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VeinMinerTabComplete implements TabCompleter {

    /**
     * Basic tab completion for enabling and disabling the features of this plugin
     * @param sender Sender of command
     * @param command command sent
     * @param alias any aliases
     * @param args any arguments sent with command
     * @return List of possible suggestions for commands/arguments
     */
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> commands = new ArrayList<>();
        List<String> completions = new ArrayList<>();
        if (args.length == 1) {
            commands.add("enable");
            commands.add("disable");
            StringUtil.copyPartialMatches(args[0], commands, completions);
        }

        Collections.sort(completions);
        return completions;
    }
}
