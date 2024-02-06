package dev.thebjoredcraft.nationcore.economy.shop.buy.guis;

import dev.thebjoredcraft.nationcore.economy.shop.ShopHandler;
import dev.thebjoredcraft.nationcore.economy.shop.buy.ShopBuyItems;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerBuyGuiWood {
    public static Inventory gui = Bukkit.createInventory(null, 54, "Holz");
    public static void open(Player player){
        for (int i = 0; i < 54; i++) {
            gui.setItem(i, ShopBuyItems.getFiller());
        }
        gui.setItem(10, ShopBuyItems.getWoodItem());
        gui.setItem(11, ShopBuyItems.getStoneItem());
        gui.setItem(12, ShopBuyItems.getOreItem());
        gui.setItem(13, ShopBuyItems.getDyeItem());
        gui.setItem(14, ShopBuyItems.getGrassItem());
        gui.setItem(15, ShopBuyItems.getDropsItem());
        gui.setItem(16, ShopBuyItems.getSpecialItem());

        gui.setItem(28, ShopBuyItems.getOak());
        gui.setItem(29, ShopBuyItems.getSpruce());
        gui.setItem(30, ShopBuyItems.getBirch());
        gui.setItem(31, ShopBuyItems.getJungle());
        gui.setItem(32, ShopBuyItems.getAcacia());
        gui.setItem(33, ShopBuyItems.getDarkOak());
        gui.setItem(34, ShopBuyItems.getMangrove());
        gui.setItem(37, ShopBuyItems.getCherry());
    }

    public static void handle(InventoryClickEvent event){
        if(event.getClickedInventory().equals(gui)){
            Player player = (Player) event.getWhoClicked();
            ItemStack ci = event.getCurrentItem();

            event.setCancelled(true);
            if(ci != null){
                if(ci.equals(ShopBuyItems.getWoodItem())){
                    player.openInventory(gui);
                }else if(ci.equals(ShopBuyItems.getStoneItem())){
                    player.openInventory(PlayerBuyGuiStone.gui);
                }else if(ci.equals(ShopBuyItems.getOreItem())){
                    player.openInventory(PlayerBuyGuiOre.gui);
                }else if(ci.equals(ShopBuyItems.getDyeItem())){
                    player.openInventory(PlayerBuyGuiDye.gui);
                }else if(ci.equals(ShopBuyItems.getGrassItem())){
                    player.openInventory(PlayerBuyGuiNaturBlocks.gui);
                }else if(ci.equals(ShopBuyItems.getDropsItem())){
                    player.openInventory(PlayerBuyGuiDrops.gui);
                }else if(ci.equals(ShopBuyItems.getSpecialItem())){
                    player.openInventory(PlayerBuyGuiSpecial.gui);
                }// top line
                else if(ci.equals(ShopBuyItems.getOak())){
                    ShopHandler.buy(player, ShopBuyItems.getOak());
                }else if(ci.equals(ShopBuyItems.getSpruce())){
                    ShopHandler.buy(player, ShopBuyItems.getSpruce());
                }else if(ci.equals(ShopBuyItems.getBirch())){
                    ShopHandler.buy(player, ShopBuyItems.getBirch());
                }else if(ci.equals(ShopBuyItems.getJungle())){
                    ShopHandler.buy(player, ShopBuyItems.getJungle());
                }else if(ci.equals(ShopBuyItems.getAcacia())){
                    ShopHandler.buy(player, ShopBuyItems.getAcacia());
                }else if(ci.equals(ShopBuyItems.getDarkOak())){
                    ShopHandler.buy(player, ShopBuyItems.getDarkOak());
                }else if(ci.equals(ShopBuyItems.getMangrove())){
                    ShopHandler.buy(player, ShopBuyItems.getMangrove());
                }else if(ci.equals(ShopBuyItems.getCherry())){
                    ShopHandler.buy(player, ShopBuyItems.getCherry());
                }
            }
        }
    }
}