package ca.sykesdev.veinminer.Utils;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class OreAPI {

    private static final BlockFace[] faces = {
            BlockFace.UP,
            BlockFace.DOWN,
            BlockFace.EAST,
            BlockFace.WEST,
            BlockFace.NORTH,
            BlockFace.SOUTH
    };

    public static final Material[] oreTypes = {
            Material.COAL_ORE,
            Material.IRON_ORE,
            Material.LAPIS_ORE,
            Material.GOLD_ORE,
            Material.REDSTONE_ORE,
            Material.DIAMOND_ORE,
            Material.EMERALD_ORE,
            Material.NETHER_QUARTZ_ORE,
    };

    private OreAPI() {
        // Block instantiation..
    }

    /**
     * Will get all the connected ores in a vein of ores
     * @param ore The starting ore
     * @return The set of ores connected to the start (or in the vein)
     */
    public static Set<Block> getAllConnected(Block ore) {
        Set<Block> results = new HashSet<>();
        LinkedList<Block> queue = new LinkedList<>();
        queue.add(ore);

        Block current = queue.poll();
        while (current != null) {
            for (BlockFace face : faces) {
                Block connected = current.getRelative(face);

                if (connected.getType() == ore.getType()) {
                    if (results.add(connected)) {
                        queue.add(connected);
                    }
                }
            }
            current = queue.poll();
        }
        return results;
    }

}
