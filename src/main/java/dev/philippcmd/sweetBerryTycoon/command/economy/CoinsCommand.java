package dev.philippcmd.sweetBerryTycoon.command.economy;

import dev.philippcmd.sweetBerryTycoon.manager.CoinManager;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CoinsCommand implements CommandExecutor {

    private final CoinManager coinManager;

    public CoinsCommand(CoinManager coinManager) {
        this.coinManager = coinManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        int coins = coinManager.getCoins(player.getUniqueId());
        player.sendMessage("You have " + coins + " coins.");
        return true;
    }
}

