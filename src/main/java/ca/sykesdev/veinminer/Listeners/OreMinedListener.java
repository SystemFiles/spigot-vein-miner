package ca.sykesdev.veinminer.Listeners;

import ca.sykesdev.veinminer.Utils.OreAPI;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.Arrays;
import java.util.List;

public class OreMinedListener implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onBlockBreak(BlockBreakEvent event) {
        Block broken = event.getBlock();
        List<Material> validBlocks = Arrays.asList(OreAPI.oreTypes);

        if (validBlocks.contains(broken.getType())) {
            for (Block b : OreAPI.getVein(broken)) {
                b.breakNaturally();
            }
        }
    }
}
