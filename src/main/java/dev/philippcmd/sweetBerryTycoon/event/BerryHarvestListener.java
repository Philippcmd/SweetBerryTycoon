package dev.philippcmd.sweetBerryTycoon.event;

import dev.philippcmd.sweetBerryTycoon.Main;

import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class BerryHarvestListener implements Listener {

    private final Main plugin;

    public BerryHarvestListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBerryHarvest(PlayerInteractEvent event) {
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;

        Block block = event.getClickedBlock();
        if (block == null || block.getType() != Material.SWEET_BERRY_BUSH) return;

        Ageable ageable = (Ageable) block.getBlockData();
        if (ageable.getAge() >= 2) {
            Player player = event.getPlayer();
            UUID uuid = player.getUniqueId();
            plugin.getCoinManager().addCoins(player.getUniqueId(), 5);
        }
    }
}
