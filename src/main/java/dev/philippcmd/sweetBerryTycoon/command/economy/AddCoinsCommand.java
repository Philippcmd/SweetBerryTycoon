package dev.philippcmd.sweetBerryTycoon.command.economy;

import dev.philippcmd.sweetBerryTycoon.manager.CoinManager;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AddCoinsCommand implements CommandExecutor {

    private final CoinManager coinManager;

    public AddCoinsCommand(CoinManager coinManager) {
        this.coinManager = coinManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 2) {
            sender.sendMessage("Usage: /addcoins <player> <amount>");
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            sender.sendMessage("Player not found.");
            return true;
        }

        int amount;
        try {
            amount = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            sender.sendMessage("Amount must be a valid number.");
            return true;
        }

        coinManager.addCoins(target.getUniqueId(), amount);
        sender.sendMessage("Gave " + amount + " coins to " + target.getName());
        target.sendMessage("You received " + amount + " coins!");
        return true;
    }
}