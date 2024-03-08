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
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.Map;

public class EventManager implements Listener {
    public static Map<String, ItemStack[]> playerInventories = new HashMap<>();
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
                        ItemStack toRemove = new ItemStack(Material.DIAMOND_BLOCK);

                        toRemove.setAmount(1);

                        event.getPlayer().getInventory().removeItem(toRemove);
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

            Player player = event.getEntity();
            String playerName = player.getName();
            ItemStack[] playerItems = player.getInventory().getContents();

            playerInventories.put(playerName, playerItems);
            event.getDrops().clear();
            int dropCount = playerItems.length / 2;

            for (int i = 0; i < dropCount; i++) {
                ItemStack item = playerItems[i];
                if (item != null && !item.getType().equals(Material.AIR)) {
                    player.getWorld().dropItemNaturally(player.getLocation(), item);
                }
            }

            ItemStack[] remainingItems = new ItemStack[playerItems.length - dropCount];
            System.arraycopy(playerItems, dropCount, remainingItems, 0, remainingItems.length);
            playerInventories.put(playerName, remainingItems);

            Location deathLocation = player.getLocation();
            Block block = deathLocation.getBlock();
            block.setType(Material.CHEST);
            Chest chest = (Chest) block.getState();
            Inventory chestInventory = chest.getBlockInventory();

            for (int i = 0; i < dropCount; i++) {
                ItemStack remainingItem = playerItems[dropCount + i];
                if (remainingItem != null && !remainingItem.getType().equals(Material.AIR)) {
                    chestInventory.addItem(remainingItem);
                }
            }

            // Inform the player about the dropped items
            player.sendMessage("50% of your items dropped at your death location, and the remaining 50% were stored in a chest.");
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
}
