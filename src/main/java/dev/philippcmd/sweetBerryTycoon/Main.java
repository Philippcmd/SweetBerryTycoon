package dev.philippcmd.sweetBerryTycoon;

import dev.philippcmd.sweetBerryTycoon.command.info.VersionCommand;
import dev.philippcmd.sweetBerryTycoon.event.BerryHarvestListener;
import dev.philippcmd.sweetBerryTycoon.manager.CoinManager;
import dev.philippcmd.sweetBerryTycoon.command.economy.CoinsCommand;
import dev.philippcmd.sweetBerryTycoon.command.economy.AddCoinsCommand;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;
    private CoinManager coinManager;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        coinManager = new CoinManager(this);

        getCommand("version").setExecutor(new VersionCommand(this));
        getCommand("coins").setExecutor(new CoinsCommand(coinManager));
        getCommand("addcoins").setExecutor(new AddCoinsCommand(coinManager));

        final PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new BerryHarvestListener(this), this);

        getLogger().info("SweetBerry Tycoon system enabled");
    }

    @Override
    public void onDisable() {
        saveConfig(); // Persist any data to config
        getLogger().info("SweetBerry Tycoon system disabled.");
    }

    public static Main getInstance() {
        return instance;
    }

    public CoinManager getCoinManager() {
        return coinManager;
    }
}