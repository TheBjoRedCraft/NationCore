package dev.thebjoredcraft.nationcore.teleport;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class TpaCommand implements CommandExecutor {
    public static HashMap<Player, Player> tpaRequests = new HashMap<>();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player) {
            if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);

                if (target == null || !target.isOnline()) {
                    player.sendMessage("Player not found or offline.");
                    return true;
                }
                tpaRequests.put(target, player);
                target.sendMessage(player.getName() + " has requested to teleport to you. Type /tpaccept or /tpdeny to respond.");
                player.sendMessage("TPA request sent to " + target.getName() + ".");
                return true;

            }
        }
        return false;
    }
}
