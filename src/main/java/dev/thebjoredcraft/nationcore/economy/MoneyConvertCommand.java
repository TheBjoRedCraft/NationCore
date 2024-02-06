package dev.thebjoredcraft.nationcore.economy;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.server.MapInitializeEvent;
import org.jetbrains.annotations.NotNull;

public class MoneyConvertCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player){
            if(args.length == 2 && args[0].equalsIgnoreCase("item")){
                int amount = Integer.parseInt(args[1]);
                MoneyManager.convertToItem(player, amount);
            }else if(args.length == 1 && args[0].equalsIgnoreCase("data")){
                MoneyManager.convertToData(player);
            }else{
                player.sendMessage(MiniMessage.miniMessage().deserialize("<bold>/convertmoney <item|data>"));
            }
        }
        return false;
    }
}
