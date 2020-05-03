package ca.sykesdev.veinminer.Utils;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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

    public static Set<Block> getVein(Block ore) {
        Set<Block> connectedOres = new HashSet<>();
        LinkedList<Block> queue = new LinkedList<>();

        queue.add(ore);

        while((ore = queue.poll()) != null) {
            getConnectedOres(ore, connectedOres, queue);
        }
        return connectedOres;
    }

    private static void getConnectedOres(Block ore, Set<Block> connected, List<Block> pending) {
        Set<Block> results = connected;

        for (BlockFace face : faces) {
            Block b = ore.getRelative(face);

            if (b.getType() == ore.getType()) {
                if (results.add(b)) {
                    pending.add(b);
                }
            }
        }
    }

}
