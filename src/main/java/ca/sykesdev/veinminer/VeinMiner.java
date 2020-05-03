package ca.sykesdev.veinminer;

import ca.sykesdev.veinminer.Commands.VeinMinerCommandExecutor;
import ca.sykesdev.veinminer.Listeners.OreMinedListener;
import ca.sykesdev.veinminer.Utils.Message;
import ca.sykesdev.veinminer.Utils.VeinMinerTabComplete;
import org.bukkit.plugin.java.JavaPlugin;

public final class VeinMiner extends JavaPlugin {

    private boolean pluginEnabled = true;

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new OreMinedListener(this), this);
        this.getServer().getPluginCommand("veinminer").setExecutor(new VeinMinerCommandExecutor(this));
        this.getServer().getPluginCommand("veinminer").setTabCompleter(new VeinMinerTabComplete());
        this.getServer().getConsoleSender().sendMessage(Message.formatMessage("Plugin activated... Thanks for using VeinMiner!"));
    }

    @Override
    public void onDisable() {
        this.getServer().getConsoleSender().sendMessage(Message.formatMessage("Plugin deactivated... Bye bye!"));
    }

    public boolean getPluginEnabled() {
        return pluginEnabled;
    }

    public void setPluginEnabled(boolean enabled) {
        pluginEnabled = enabled;
    }
}
