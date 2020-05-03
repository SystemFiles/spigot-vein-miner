package ca.sykesdev.veinminer;

import ca.sykesdev.veinminer.Listeners.OreMinedListener;
import ca.sykesdev.veinminer.Utils.Message;
import org.bukkit.plugin.java.JavaPlugin;

public final class VeinMiner extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new OreMinedListener(), this);
        this.getServer().getConsoleSender().sendMessage(Message.formatMessage("Plugin activated... Thanks for using VeinMiner!"));
    }

    @Override
    public void onDisable() {
        this.getServer().getConsoleSender().sendMessage(Message.formatMessage("Plugin deactivated... Bye bye!"));
    }
}
