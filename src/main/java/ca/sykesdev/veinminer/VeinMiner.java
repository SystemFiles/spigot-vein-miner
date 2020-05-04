package ca.sykesdev.veinminer;

import ca.sykesdev.veinminer.Commands.VeinMinerCommandExecutor;
import ca.sykesdev.veinminer.Listeners.OreMinedListener;
import ca.sykesdev.veinminer.Utils.Message;
import ca.sykesdev.veinminer.Utils.VeinMinerTabComplete;
import org.bukkit.plugin.java.JavaPlugin;

public final class VeinMiner extends JavaPlugin {

    // Determine whether or not to enable features of this plugin
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

    /**
     * Get enabled status
     * @return If plugin features allowed
     */
    public boolean getPluginEnabled() {
        return pluginEnabled;
    }

    /**
     * Set enabled status
     * @param enabled The new enabled status
     */
    public void setPluginEnabled(boolean enabled) {
        pluginEnabled = enabled;
    }
}
