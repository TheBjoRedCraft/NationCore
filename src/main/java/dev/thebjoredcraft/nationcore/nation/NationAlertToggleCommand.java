package dev.thebjoredcraft.nationcore.nation;

import dev.thebjoredcraft.nationcore.NationCore;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class NationAlertToggleCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(sender instanceof Player player){
            if(PlayerNationManager.getTeam(player.getName()).getDisplayName().equals("fire")){
                if(player.hasPermission("nations.region.fire.alert")){
                    NationCore.setPermission(player, "nations.region.fire.alert", false);
                }else{
                    NationCore.setPermission(player, "nations.region.fire.alert", true);
                }
            }else if(PlayerNationManager.getTeam(player.getName()).getDisplayName().equals("water")){
                if(player.hasPermission("nations.region.water.alert")){
                    NationCore.setPermission(player, "nations.region.water.alert", false);
                }else{
                    NationCore.setPermission(player, "nations.region.water.alert", true);
                }
            }else{
                player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du musst in einer Nation sein, um den Alert zu aktievieren."));
            }
        }
        return false;
    }
}
