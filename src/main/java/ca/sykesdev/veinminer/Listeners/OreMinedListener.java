package ca.sykesdev.veinminer.Listeners;

import ca.sykesdev.veinminer.Utils.OreAPI;
import ca.sykesdev.veinminer.VeinMiner;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.Arrays;
import java.util.List;

public class OreMinedListener implements Listener {

    // Instance of plugin
    private VeinMiner plugin;

    /**
     * Constructor for OreMinedListener
     * @param plugin The plugin instance
     */
    public OreMinedListener(VeinMiner plugin) {
        this.plugin = plugin;
    }

    /**
     * Handles every time the player breaks a block in the world and checks if it
     * is a valid block and the plugin features are allowed, as well as valid gamemode
     * @param event The event being triggered (BlockBreakEvent in this case)
     */
    @EventHandler(ignoreCancelled = true)
    public void onBlockBreak(BlockBreakEvent event) {
        Block broken = event.getBlock();
        List<Material> validBlocks = Arrays.asList(OreAPI.oreTypes);

        // Check if block type is valid and plugin is enabled and player is on survival mode...
        if (validBlocks.contains(broken.getType())
                && this.plugin.getPluginEnabled()
                && event.getPlayer().getGameMode() == GameMode.SURVIVAL) {

            // Loop through all connected blocks and break them naturally
            for (Block b : OreAPI.getAllConnected(broken)) {
                b.breakNaturally();
            }
        }
    }
}
