package dev.thebjoredcraft.nationcore.inventorysee;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class PlayerArmorSeeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player && args.length == 1){
            Player target = Bukkit.getPlayer(args[0]);
            if(target == null){
                player.sendMessage(MiniMessage.miniMessage().deserialize("<bold>Der Spieler wurde nicht gefunden!"));
            }else{
                Inventory inv = Bukkit.createInventory(null, InventoryType.PLAYER);
                inv.setContents(target.getInventory().getArmorContents());
                player.openInventory(inv);
            }
        }else{
            sender.sendMessage(MiniMessage.miniMessage().deserialize("<bold>Player:/armorsee <player>"));
        }
        return false;
    }
}
