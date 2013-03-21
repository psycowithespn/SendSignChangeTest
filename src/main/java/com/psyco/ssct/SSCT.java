package com.psyco.ssct;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class SSCT extends JavaPlugin {

    public void onEnable() {
        getCommand("testchange").setExecutor(this);
        getCommand("testfake").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("testchange")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                Block block = player.getTargetBlock(null, 30);
                if (block.getType() == Material.SIGN_POST || block.getType() == Material.WALL_SIGN || true) {
                    player.sendSignChange(block.getLocation(), args);
                    player.sendMessage("Fake changed sign at target location");
                }
            }
        } else {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                Block block = player.getTargetBlock(null, 30);
                player.sendBlockChange(block.getLocation(), Material.SIGN_POST, (byte) 0x0);
                player.sendMessage("Created fake sign at target location");
            }
        }
        return true;
    }
}
