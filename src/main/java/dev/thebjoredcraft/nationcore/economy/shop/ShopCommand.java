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
            PlayerBuyGuiWood.open(player);
        }
        return false;
    }
}
