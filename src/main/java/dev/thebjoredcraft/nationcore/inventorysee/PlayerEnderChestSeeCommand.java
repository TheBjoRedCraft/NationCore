package dev.thebjoredcraft.nationcore.inventorysee;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PlayerEnderChestSeeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player && args.length == 1){
            Player target = Bukkit.getPlayer(args[0]);
            if(target == null){
                player.sendMessage(MiniMessage.miniMessage().deserialize("<bold>Der Spieler wurde nicht gefunden!"));
            }else{
                player.openInventory(target.getEnderChest());
            }
        }else{
            sender.sendMessage(MiniMessage.miniMessage().deserialize("<bold>Player:/endchestsee <player>"));
        }
        return false;
    }
}
