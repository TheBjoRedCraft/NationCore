package dev.thebjoredcraft.nationcore.nation;

import dev.thebjoredcraft.nationcore.region.Regions;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class NationCommand implements CommandExecutor {
    public static HashMap<Player, Regions> invites = new HashMap<>();
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player){
            if(args.length == 2 && args[0].equalsIgnoreCase("invite")){
                Player target = Bukkit.getPlayer(args[1]);
                if(target != null){
                    if(player.hasPermission("nations.region.water")) {
                        invites.put(target, Regions.WATER);
                    }else if(player.hasPermission("nations.region.fire")){
                        invites.put(target, Regions.FIRE);
                    }else{
                        player.sendMessage(MiniMessage.miniMessage().deserialize("<bold>Du musst in einer Nation sein, um Leute einladen zu können!"));
                    }
                }
            }
        }
        return false;
    }
}
