package dev.thebjoredcraft.nationcore.teleport;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class TpaAcceptCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player){
            if(args.length == 1){
                if (!TpaCommand.tpaRequests.containsKey(player)) {
                    player.sendMessage("You have no pending teleport requests.");
                }else {
                    Player requester = TpaCommand.tpaRequests.get(player);

                    player.teleport(requester.getLocation());
                    player.sendMessage("Teleported to " + requester.getName() + ".");

                    TpaCommand.tpaRequests.remove(player);
                }
            }
        }
        return false;
    }
}
