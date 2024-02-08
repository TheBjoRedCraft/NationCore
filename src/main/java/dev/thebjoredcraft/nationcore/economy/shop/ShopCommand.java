package dev.thebjoredcraft.nationcore.economy.shop;

import dev.thebjoredcraft.nationcore.economy.shop.buy.guis.PlayerBuyGuiWood;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ShopCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player){
            if(args.length == 1 && args[0].equalsIgnoreCase("setup") && player.hasPermission("nations.shop.summon")){
                ShopHandler.summon(player.getLocation());
            }else {
                PlayerBuyGuiWood.open(player);
            }
        }
        return false;
    }
}
