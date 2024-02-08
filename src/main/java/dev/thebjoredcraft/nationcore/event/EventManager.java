package dev.thebjoredcraft.nationcore.event;

import dev.thebjoredcraft.nationcore.economy.shop.ShopHandler;
import dev.thebjoredcraft.nationcore.economy.shop.buy.guis.*;
import dev.thebjoredcraft.nationcore.nation.PlayerNationManager;
import dev.thebjoredcraft.nationcore.region.Region;
import dev.thebjoredcraft.nationcore.region.Regions;
import dev.thebjoredcraft.nationcore.rule.RuleManager;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class EventManager implements Listener {
    @EventHandler
    public void onMove(PlayerMoveEvent event){
        Player player = event.getPlayer();
        if(!Region.isInRegion(event.getFrom(), Regions.FIRE) && Region.isInRegion(event.getTo(), Regions.FIRE)){
            if(!event.getPlayer().hasPermission("nations.region.bypass")){
                for(Player target : Bukkit.getOnlinePlayers()){
                    if(target.hasPermission("nations.region.fire.alert")){
                        if (target != event.getPlayer()) {
                            if (PlayerNationManager.getTeam(event.getPlayer()).equals("water")) {
                                target.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Der Spieler<color:#40d1db> " + event.getPlayer().getName() + " <color:#3b92d1>hat deine Nation <bold>betreten!"));
                            }
                        }
                    }
                }
            }
        }else if(!Region.isInRegion(event.getFrom(), Regions.WATER) && Region.isInRegion(event.getTo(), Regions.WATER)){
            if(!event.getPlayer().hasPermission("nations.region.bypass")){
                for(Player target : Bukkit.getOnlinePlayers()){
                    if(target.hasPermission("nations.region.water.alert")){
                        if (target != event.getPlayer()) {
                            if (PlayerNationManager.getTeam(event.getPlayer()).equals("fire")) {
                                target.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Der Spieler<color:#40d1db> " + event.getPlayer().getName() + " <color:#3b92d1>hat deine Nation <bold>betreten!"));
                            }
                        }
                    }
                }
            }
        }
        if (!Region.isInRegion(event.getFrom(), Regions.SPAWN)) {
            if (Region.isInRegion(event.getTo(), Regions.SPAWN)) {
                event.getPlayer().sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast die <color:#40d1db>Spawnregion <color:#3b92d1>betreten"));
            }
        }

        if (event.getFrom().getBlockX() != event.getTo().getBlockX() || event.getFrom().getBlockZ() != event.getTo().getBlockZ()) {
            if (RuleManager.getAcceptedRules(player) == null) {
                RuleManager.setAcceptedRules(player, false);
            } else {
                if (!RuleManager.getAcceptedRules(player)) {
                    event.setCancelled(true);
                    player.sendMessage(MiniMessage.miniMessage().deserialize("<red>Du musst die Regeln akzeptieren! -> /rules accept | Regeln: /rules"));
                }
            }
        }
    }
    @EventHandler
    public void onClick(InventoryClickEvent event){
        PlayerBuyGuiDrops.handle(event);
        PlayerBuyGuiDye.handle(event);
        PlayerBuyGuiNaturBlocks.handle(event);
        PlayerBuyGuiOre.handle(event);
        PlayerBuyGuiSpecial.handle(event);
        PlayerBuyGuiStone.handle(event);
        PlayerBuyGuiWood.handle(event);
    }
    @EventHandler
    public void onInteract(PlayerInteractEntityEvent event){
        if(event.getRightClicked().getScoreboardTags().contains(ShopHandler.traderTag)){
            PlayerBuyGuiWood.open(event.getPlayer());
        }
    }
    @EventHandler
    public void onPortal(PlayerPortalEvent event){
        if(event.getCause().equals(PlayerTeleportEvent.TeleportCause.NETHER_PORTAL)){
            event.setCancelled(true);
            event.getPlayer().sendMessage(MiniMessage.miniMessage().deserialize("<bold>Der Nether ist deaktiviert!"));
        }else if(event.getCause().equals(PlayerTeleportEvent.TeleportCause.END_PORTAL) || event.getCause().equals(PlayerTeleportEvent.TeleportCause.END_GATEWAY)){
            event.setCancelled(true);
            event.getPlayer().sendMessage(MiniMessage.miniMessage().deserialize("<bold>Das End ist deaktiviert!"));
        }
    }
}
