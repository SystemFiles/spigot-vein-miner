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

    private VeinMiner plugin;

    public OreMinedListener(VeinMiner plugin) {
        this.plugin = plugin;
    }

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
