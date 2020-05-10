package ca.sykesdev.veinminer.Listeners;

import ca.sykesdev.veinminer.Utils.OreAPI;
import ca.sykesdev.veinminer.VeinMiner;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.*;

public class OreMinedListener implements Listener {

    private Map<Material, Integer> oreExpMap = new HashMap<>();

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
        // Map all ores for exp drop amounts
        oreExpMap.put(Material.COAL_ORE, 2);
        oreExpMap.put(Material.REDSTONE_ORE, 5);
        oreExpMap.put(Material.LAPIS_ORE, 5);
        oreExpMap.put(Material.EMERALD_ORE, 7);
        oreExpMap.put(Material.DIAMOND_ORE, 7);
        oreExpMap.put(Material.NETHER_QUARTZ_ORE, 7);

        // Get the ore that was broken
        Block broken = event.getBlock();
        List<Material> validBlocks = Arrays.asList(OreAPI.oreTypes);

        // Check if block type is valid and plugin is enabled and player is on survival mode...
        if (validBlocks.contains(broken.getType())
                && this.plugin.getPluginEnabled()
                && event.getPlayer().getGameMode() == GameMode.SURVIVAL) {

            Set<Block> connectedOres = OreAPI.getAllConnected(broken);

            // Drop EXP if xp ore
            if (oreExpMap.containsKey(broken.getType())) {
                ExperienceOrb orb = broken.getWorld().spawn(broken.getLocation()
                        .add(0.5, 0.5, 0.5), ExperienceOrb.class);
                orb.setExperience(oreExpMap.get(broken.getType()) * connectedOres.size());
            }

            // Loop through all connected blocks and break them naturally
            for (Block b : connectedOres) {
                // Break the connected ore
                b.breakNaturally();
            }
        }
    }
}
