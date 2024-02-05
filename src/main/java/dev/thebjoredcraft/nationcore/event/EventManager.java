package dev.thebjoredcraft.nationcore.event;

import dev.thebjoredcraft.nationcore.region.Region;
import dev.thebjoredcraft.nationcore.region.Regions;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class EventManager implements Listener {
    @EventHandler
    public void onMove(PlayerMoveEvent event){
        if(!Region.isInRegion(event.getFrom(), Regions.FIRE) && Region.isInRegion(event.getTo(), Regions.FIRE)){
            if(!event.getPlayer().hasPermission("nations.region.bypass")){
                for(Player target : Bukkit.getOnlinePlayers()){
                    if(target.hasPermission("nations.region.fire.alert")){
                        target.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Der Spieler<color:#40d1db> " + event.getPlayer().getName() + " <color:#3b92d1>hat deine Nation <bold>betreten!"));
                    }
                }
            }
        }else if(!Region.isInRegion(event.getFrom(), Regions.WATER) && Region.isInRegion(event.getTo(), Regions.WATER)){
            if(!event.getPlayer().hasPermission("nations.region.bypass")){
                for(Player target : Bukkit.getOnlinePlayers()){
                    if(target.hasPermission("nations.region.fire.alert")){
                        target.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Der Spieler<color:#40d1db> " + event.getPlayer().getName() + " <color:#3b92d1>hat deine Nation <bold>betreten!"));
                    }
                }
            }
        }
    }
}
