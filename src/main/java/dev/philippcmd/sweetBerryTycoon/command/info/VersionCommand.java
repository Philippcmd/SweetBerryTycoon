package dev.philippcmd.sweetBerryTycoon.command.info;

import dev.philippcmd.sweetBerryTycoon.Main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class VersionCommand implements CommandExecutor {

    private final Main plugin;

    public VersionCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Retrieve version from plugin.yml
        String version = plugin.getDescription().getVersion();
        sender.sendMessage("You are currently running SweetBerryTycoon v" + version);
        return true;
    }
}
