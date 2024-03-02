package dev.thebjoredcraft.nationcore.death;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.world.PortalCreateEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

public class DeathCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player){
            if(DeathManager.getDead(player) == null){
                DeathManager.setDead(player, false);
            }else{
                if(DeathManager.getDead(player)){
                    if(player.hasPotionEffect(PotionEffectType.GLOWING)){
                        player.removePotionEffect(PotionEffectType.GLOWING);
                    }
                    DeathManager.setDead(player, false);
                }else{
                    DeathManager.setDead(player, true);
                    player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, Integer.MAX_VALUE, 1, false, false));
                }
            }
        }
        return false;
    }
}
