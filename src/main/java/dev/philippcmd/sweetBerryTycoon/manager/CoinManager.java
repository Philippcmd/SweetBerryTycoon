package dev.philippcmd.sweetBerryTycoon.manager;

import dev.philippcmd.sweetBerryTycoon.Main;

import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;


public class CoinManager {

    private final Main plugin;

    public CoinManager(Main plugin) {
        this.plugin = plugin;
    }

    public int getCoins(UUID uuid) {
        FileConfiguration config = plugin.getConfig();
        return config.getInt("players." + uuid + ".coins", 0);
    }

    public void setCoins(UUID uuid, int amount) {
        plugin.getConfig().set("players." + uuid + ".coins", amount);
        plugin.saveConfig();
    }

    public void addCoins(UUID uuid, int amount) {
        int current = getCoins(uuid);
        setCoins(uuid, current + amount);
    }

    public void removeCoins(UUID uuid, int amount) {
        int current = getCoins(uuid);
        setCoins(uuid, Math.max(0, current - amount));
    }
}