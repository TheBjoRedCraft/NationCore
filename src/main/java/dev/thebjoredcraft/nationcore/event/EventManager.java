package dev.thebjoredcraft.nationcore.event;

import com.destroystokyo.paper.event.player.PlayerPostRespawnEvent;
import dev.thebjoredcraft.nationcore.death.DeathManager;
import dev.thebjoredcraft.nationcore.economy.shop.ShopHandler;
import dev.thebjoredcraft.nationcore.economy.shop.buy.guis.*;
import dev.thebjoredcraft.nationcore.nation.PlayerNationManager;
import dev.thebjoredcraft.nationcore.region.Region;
import dev.thebjoredcraft.nationcore.region.Regions;

import io.papermc.paper.event.player.PlayerTradeEvent;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.*;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;
import org.bukkit.event.raid.RaidTriggerEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EventManager implements Listener {
    @EventHandler
    public void onMove(PlayerMoveEvent event){
        Player player = event.getPlayer();
        if(!Region.isInRegion(event.getFrom(), Regions.FIRE) && Region.isInRegion(event.getTo(), Regions.FIRE)){
            if(!event.getPlayer().hasPermission("nations.region.bypass")){
                for(Player target : Bukkit.getOnlinePlayers()){
                    if(target.hasPermission("nations.region.fire.alert")){
                        if (target != event.getPlayer()) {
                            if (PlayerNationManager.getTeam(event.getPlayer().getName()).getDisplayName().equals("water")) {
                                target.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Der Spieler<color:#40d1db> " + event.getPlayer().getName() + " <color:#3b92d1>hat deine Nations-Gebiet <bold>betreten!"));
                            }
                        }
                    }
                }
            }
            event.getPlayer().sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast die "+ Regions.FIRE.getName() + " <color:#3b92d1>betreten!"));
        }else if(!Region.isInRegion(event.getFrom(), Regions.WATER) && Region.isInRegion(event.getTo(), Regions.WATER)){
            if(!event.getPlayer().hasPermission("nations.region.bypass")){
                for(Player target : Bukkit.getOnlinePlayers()){
                    if(target.hasPermission("nations.region.water.alert")){
                        if (target != event.getPlayer()) {
                            if (PlayerNationManager.getTeam(event.getPlayer().getName()).getDisplayName().equals("fire")) {
                                target.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Der Spieler<color:#40d1db> " + event.getPlayer().getName() + " <color:#3b92d1>hat deine Nations-Gebiet <bold>betreten!"));

                            }
                        }
                    }
                }
            }
            event.getPlayer().sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast die "+ Regions.WATER.getName() + " <color:#3b92d1>betreten!"));
        }else if(Region.isInRegion(event.getFrom(), Regions.WATER) && !Region.isInRegion(event.getTo(), Regions.WATER)){
            if(!event.getPlayer().hasPermission("nations.region.bypass")){
                for(Player target : Bukkit.getOnlinePlayers()){
                    if(target.hasPermission("nations.region.water.alert")){
                        if (target != event.getPlayer()) {
                            if (PlayerNationManager.getTeam(event.getPlayer().getName()).getDisplayName().equals("fire")) {
                                target.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Der Spieler<color:#40d1db> " + event.getPlayer().getName() + " <color:#3b92d1>hat deine Nations-Gebiet <bold>verlassen!"));
                            }
                        }
                    }
                }
            }
            event.getPlayer().sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast die "+ Regions.WATER.getName() + " <color:#3b92d1>verlassen!"));
        }if(Region.isInRegion(event.getFrom(), Regions.FIRE) && !Region.isInRegion(event.getTo(), Regions.FIRE)){
            if(!event.getPlayer().hasPermission("nations.region.bypass")){
                for(Player target : Bukkit.getOnlinePlayers()){
                    if(target.hasPermission("nations.region.fire.alert")){
                        if (target != event.getPlayer()) {
                            if (PlayerNationManager.getTeam(event.getPlayer().getName()).getDisplayName().equals("water")) {
                                target.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Der Spieler<color:#40d1db> " + event.getPlayer().getName() + " <color:#3b92d1>hat deine Nations-Gebiet <bold>verlassen!"));
                            }
                        }
                    }
                }
            }
            event.getPlayer().sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast die "+ Regions.FIRE.getName() + " <color:#3b92d1>verlassen!"));
        }
        if (!Region.isInRegion(event.getFrom(), Regions.SPAWN)) {
            if (Region.isInRegion(event.getTo(), Regions.SPAWN)) {
                event.getPlayer().sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast den "+ Regions.SPAWN.getName() + " <color:#3b92d1>betreten!"));
            }
        }else if (Region.isInRegion(event.getFrom(), Regions.SPAWN)) {
            if (!Region.isInRegion(event.getTo(), Regions.SPAWN)) {
                event.getPlayer().sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast den "+ Regions.SPAWN.getName() + " <color:#3b92d1>verlassen!"));
            }
        }
        if (!Region.isInRegion(event.getFrom(), Regions.SPAWN_REGION)) {
            if (Region.isInRegion(event.getTo(), Regions.SPAWN_REGION)) {
                event.getPlayer().sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast die "+ Regions.SPAWN_REGION.getName() + " <color:#3b92d1>betreten!"));
            }
        }else if (Region.isInRegion(event.getFrom(), Regions.SPAWN_REGION)) {
            if (!Region.isInRegion(event.getTo(), Regions.SPAWN_REGION)) {
                event.getPlayer().sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast die "+ Regions.SPAWN_REGION.getName() + " <color:#3b92d1>verlassen!"));
            }
        }
        if(Region.isInRegion(event.getFrom(), Regions.SPAWN) && !Region.isInRegion(event.getTo(), Regions.SPAWN)){
            if(DeathManager.getDead(player) == null){
                DeathManager.setDead(player, false);
            }else{
                if(DeathManager.getDead(player)) {
                    event.getPlayer().sendMessage(MiniMessage.miniMessage().deserialize("<bold>Du bist tot. Du kannst den "+ Regions.SPAWN.getName() + " nicht verlassen!"));
                    event.setCancelled(true);
                }
            }
        }
        if(Region.isInRegion(event.getFrom(), Regions.MAP) && !Region.isInRegion(event.getTo(), Regions.MAP)){
            if(!player.hasPermission("nations.region.map.bypass")){
                event.setTo(event.getFrom());
                player.sendMessage(MiniMessage.miniMessage().deserialize("<red>Achtung! Du kannst die Welt nicht verlassen!"));
            }
        }
    }
    @EventHandler
    public void onInteractGeneral(PlayerInteractEvent event){
        if(event.getInteractionPoint() != null){
            if(Region.isInRegion(event.getInteractionPoint(), Regions.WATER) && !PlayerNationManager.getTeam(event.getPlayer().getName()).getDisplayName().equals("water")) {
                if (!event.getPlayer().hasPermission("nations.nationprot.bypass")) {
                    event.setCancelled(true);
                    event.getPlayer().sendMessage(MiniMessage.miniMessage().deserialize("<red>Du kannst hier nicht interagieren!"));
                }
            }else if(Region.isInRegion(event.getInteractionPoint(), Regions.FIRE) && !PlayerNationManager.getTeam(event.getPlayer().getName()).getDisplayName().equals("fire")) {
                if (!event.getPlayer().hasPermission("nations.nationprot.bypass")) {
                    event.setCancelled(true);
                    event.getPlayer().sendMessage(MiniMessage.miniMessage().deserialize("<red>Du kannst hier nicht interagieren!"));
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
            if(ShopHandler.isVisible) {
                PlayerBuyGuiWood.open(event.getPlayer());
            }else{
                event.getPlayer().sendMessage(MiniMessage.miniMessage().deserialize("<red>Der Shop-Händler ist aktuell auf Reisen! Bitte komm später wieder..."));
            }
        } else if(event.getRightClicked() instanceof Player player){
            if(event.getPlayer().getItemInHand().getType().equals(Material.DIAMOND_BLOCK)) {
                if (DeathManager.getDead(player) == null) {
                    DeathManager.setDead(player, false);
                } else {
                    if (DeathManager.getDead(player)) {
                        event.getPlayer().getItemInHand().setAmount(event.getPlayer().getItemInHand().getAmount() -1);

                        DeathManager.setDead(player, false);

                        player.sendMessage(MiniMessage.miniMessage().deserialize("<bold>Du wurdest wiederbelebt!"));
                        event.getPlayer().sendMessage(MiniMessage.miniMessage().deserialize("<bold>Du hast " + player.getName() + " wiederbelebt!"));

                        if(player.hasPotionEffect(PotionEffectType.GLOWING)){
                            player.removePotionEffect(PotionEffectType.GLOWING);
                        }
                    }
                }
            }
        }
        if(Region.isInRegion(event.getRightClicked().getLocation(), Regions.FIRE) && !PlayerNationManager.getTeam(event.getPlayer().getName()).getDisplayName().equals("fire")){
            if(!event.getPlayer().hasPermission("nations.nationprot.bypass")) {
                event.setCancelled(true);
                event.getPlayer().sendMessage(MiniMessage.miniMessage().deserialize("<red>Du kannst hier nicht interagieren!"));
            }
        }else if(Region.isInRegion(event.getRightClicked().getLocation(), Regions.WATER) && !PlayerNationManager.getTeam(event.getPlayer().getName()).getDisplayName().equals("water")){
            if(!event.getPlayer().hasPermission("nations.nationprot.bypass")) {
                event.setCancelled(true);
                event.getPlayer().sendMessage(MiniMessage.miniMessage().deserialize("<red>Du kannst hier nicht interagieren!"));
            }
        }else if(Region.isInRegion(event.getRightClicked().getLocation(), Regions.SPAWN_REGION) && !event.getPlayer().hasPermission("nations.spawnprot.bypass")){
            if(!event.getPlayer().hasPermission("nations.nationprot.bypass")) {
                event.setCancelled(true);
                event.getPlayer().sendMessage(MiniMessage.miniMessage().deserialize("<red>Du kannst hier nicht interagieren!"));
            }
        }
    }
    @EventHandler
    public void onRespawn(PlayerPostRespawnEvent event){
        Player player = event.getPlayer();
        if(DeathManager.getDead(player) == null){
            DeathManager.setDead(player, false);
        }else{
            if(DeathManager.getDead(player)){
                player.teleport(player.getWorld().getSpawnLocation());
                player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, Integer.MAX_VALUE, 1, false, false));
            }
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
    @EventHandler
    public void onDeath(PlayerDeathEvent event){
        if(!event.getPlayer().hasPermission("nations.death.bypass")) {
            DeathManager.handleDeath(event.getPlayer());
        }
    }
    @EventHandler
    public void onDamage(EntityDamageEvent event){
        if(event.getEntity() instanceof Player player){
            if(DeathManager.getDead(player) == null){
                DeathManager.setDead(player, false);
            }else{
                if(DeathManager.getDead(player)){
                    event.setCancelled(true);
                }
            }
        }
    }
    @EventHandler
    public void onPlace(BlockPlaceEvent event){
        if(Region.isInRegion(event.getBlock().getLocation(), Regions.FIRE) && !PlayerNationManager.getTeam(event.getPlayer().getName()).getDisplayName().equals("fire")){
            if(!event.getPlayer().hasPermission("nations.nationprot.bypass")) {
                event.setCancelled(true);
                event.getPlayer().sendMessage(MiniMessage.miniMessage().deserialize("<red>Du kannst hier nicht bauen!"));
            }
        }else if(Region.isInRegion(event.getBlock().getLocation(), Regions.WATER) && !PlayerNationManager.getTeam(event.getPlayer().getName()).getDisplayName().equals("water")){
            if(!event.getPlayer().hasPermission("nations.nationprot.bypass")) {
                event.setCancelled(true);
                event.getPlayer().sendMessage(MiniMessage.miniMessage().deserialize("<red>Du kannst hier nicht bauen!"));
            }
        }else if(Region.isInRegion(event.getBlock().getLocation(), Regions.SPAWN_REGION) && !event.getPlayer().hasPermission("nations.spawnprot.bypass")){
            if(!event.getPlayer().hasPermission("nations.nationprot.bypass")) {
                event.setCancelled(true);
                event.getPlayer().sendMessage(MiniMessage.miniMessage().deserialize("<red>Du kannst hier nicht bauen!"));
            }
        }
    }
    @EventHandler
    public void onBreak(BlockBreakEvent event){
        if(Region.isInRegion(event.getBlock().getLocation(), Regions.FIRE) && !PlayerNationManager.getTeam(event.getPlayer().getName()).getDisplayName().equals("fire")){
            if(!event.getPlayer().hasPermission("nations.nationprot.bypass")) {
                event.setCancelled(true);
                event.getPlayer().sendMessage(MiniMessage.miniMessage().deserialize("<red>Du kannst hier nicht abbauen!"));
            }
        }else if(Region.isInRegion(event.getBlock().getLocation(), Regions.WATER) && !PlayerNationManager.getTeam(event.getPlayer().getName()).getDisplayName().equals("water")){
            if(!event.getPlayer().hasPermission("nations.nationprot.bypass")) {
                event.setCancelled(true);
                event.getPlayer().sendMessage(MiniMessage.miniMessage().deserialize("<red>Du kannst hier nicht abbauen!"));
            }
        }else if(Region.isInRegion(event.getBlock().getLocation(), Regions.SPAWN_REGION) && !event.getPlayer().hasPermission("nations.spawnprot.bypass")){
            if(!event.getPlayer().hasPermission("nations.nationprot.bypass")) {
                event.setCancelled(true);
                event.getPlayer().sendMessage(MiniMessage.miniMessage().deserialize("<red>Du kannst hier nicht bauen!"));
            }
        }
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        if(PlayerNationManager.getTeam(event.getPlayer().getName()) == null){
            PlayerNationManager.joinTeam(event.getPlayer().getName(), "nothing");
        }
    }
    @EventHandler
    public void onTrade(PlayerTradeEvent event){
        Player player = event.getPlayer();
        if(!player.hasPermission("nations.trade.bypass")){
            event.setCancelled(true);
            player.sendMessage(MiniMessage.miniMessage().deserialize("<red>Du kannst nicht handeln!"));
        }
    }
    @EventHandler
    public void onEntityExplode(EntityExplodeEvent event){
        if(event.getEntity().getType().equals(EntityType.ENDER_CRYSTAL)){
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void onRaid(RaidTriggerEvent event){
        Player player = event.getPlayer();
        if(!player.hasPermission("nations.raid.bypass")){
            event.setCancelled(true);

            player.sendMessage(MiniMessage.miniMessage().deserialize("<red>Du kannst keine Raids starten!"));
            player.removePotionEffect(PotionEffectType.BAD_OMEN);
        }
    }
    @EventHandler
    public void onBlockExplosion(BlockExplodeEvent event){
        if(event.getBlock().getType().equals(Material.TNT) ||event.getBlock().getType().equals(Material.RESPAWN_ANCHOR)){
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void onEntityInteract(PlayerInteractAtEntityEvent event){
        Player player = event.getPlayer();
        if(event.getRightClicked().getType().equals(EntityType.ZOMBIE_VILLAGER)) {
            if (!player.hasPermission("nations.villagerheal.bypass")) {
                event.setCancelled(true);

                player.sendMessage(MiniMessage.miniMessage().deserialize("<red>Du kannst nicht mit Zombie Villagern interagieren!"));
            }
        }
    }
    @EventHandler
    public void onBlockDamage(EntityDamageByBlockEvent event){
        if(event.getDamager().getType().equals(Material.RESPAWN_ANCHOR)){
            event.setCancelled(true);
            event.getEntity().sendMessage(MiniMessage.miniMessage().deserialize("<red>Du machst keinen Schaden mit Respawn Anchorn!"));
        }
    }
    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event){
        if(event.getDamager().getType().equals(EntityType.ENDER_CRYSTAL)){
            event.setCancelled(true);
            event.getEntity().sendMessage(MiniMessage.miniMessage().deserialize("<red>Du machst keinen Schaden mit Ender Kristallen!"));
        }
    }
    @EventHandler
    public void onTransform(EntityTransformEvent event){
        if(event.getEntity().getType().equals(EntityType.ZOMBIE_VILLAGER)){
            event.setCancelled(true);
        }
    }
}
