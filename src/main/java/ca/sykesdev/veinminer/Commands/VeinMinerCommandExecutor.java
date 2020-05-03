package ca.sykesdev.veinminer.Commands;

import ca.sykesdev.veinminer.Utils.Message;
import ca.sykesdev.veinminer.VeinMiner;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class VeinMinerCommandExecutor implements CommandExecutor {

    private VeinMiner plugin;

    public VeinMinerCommandExecutor(VeinMiner plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("veinminer")) {
            if (args.length >= 1) {
                switch (args[0]) {
                    case "disable":
                        this.plugin.setPluginEnabled(false);
                        sender.sendMessage(Message.formatMessage("Vein mining disabled!"));
                        break;
                    case "enable":
                        this.plugin.setPluginEnabled(true);
                        sender.sendMessage(Message.formatMessage("Vein mining enabled!"));
                        break;
                    default:
                        sender.sendMessage(Message.formatMessage("Unknown arguments... " +
                                "please see command usage details.."));
                }
                return true;
            }
        }

        return false;
    }
}
