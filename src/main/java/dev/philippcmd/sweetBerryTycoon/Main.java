package dev.philippcmd.sweetBerryTycoon;

import dev.philippcmd.sweetBerryTycoon.manager.CoinManager;
import dev.philippcmd.sweetBerryTycoon.command.economy.CoinsCommand;
import dev.philippcmd.sweetBerryTycoon.command.economy.AddCoinsCommand;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;
    private CoinManager coinManager;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig(); // Create config.yml if it doesn't exist

        coinManager = new CoinManager(this);

        getCommand("coins").setExecutor(new CoinsCommand(coinManager));
        getCommand("addcoins").setExecutor(new AddCoinsCommand(coinManager));

        getLogger().info("CoinSystem enabled.");
    }

    @Override
    public void onDisable() {
        saveConfig(); // Persist any data to config
        getLogger().info("CoinSystem disabled.");
    }

    public static Main getInstance() {
        return instance;
    }

    public CoinManager getCoinManager() {
        return coinManager;
    }
}