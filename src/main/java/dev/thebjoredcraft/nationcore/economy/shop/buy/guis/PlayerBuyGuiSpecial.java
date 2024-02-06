package dev.thebjoredcraft.nationcore.economy.shop.buy.guis;

import dev.thebjoredcraft.nationcore.economy.shop.ShopHandler;
import dev.thebjoredcraft.nationcore.economy.shop.buy.ShopBuyItems;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerBuyGuiSpecial {
    public static Inventory gui = Bukkit.createInventory(null, 54, "Stein");
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

        gui.setItem(28, ShopBuyItems.getShield());
        gui.setItem(29, ShopBuyItems.getCrossBow());
        gui.setItem(30, ShopBuyItems.getBow());
        gui.setItem(31, ShopBuyItems.getBed());
        gui.setItem(32, ShopBuyItems.getTotem());
        gui.setItem(33, ShopBuyItems.getTrident());
        gui.setItem(34, ShopBuyItems.getBeacon());
        gui.setItem(37, ShopBuyItems.getTurtleHelmet());
        gui.setItem(38, ShopBuyItems.getEndPortalFrame());
        gui.setItem(39, ShopBuyItems.getDragonHead());


    }

    public static void handle(InventoryClickEvent event){
        if(event.getClickedInventory().equals(gui)){
            Player player = (Player) event.getWhoClicked();
            ItemStack ci = event.getCurrentItem();

            event.setCancelled(true);
            if(ci != null){
                if(ci.equals(ShopBuyItems.getWoodItem())){
                    player.openInventory(PlayerBuyGuiWood.gui);
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
                    player.openInventory(gui);
                }// top line
                else if(ci.equals(ShopBuyItems.getShield())){
                    ShopHandler.buy(player, ShopBuyItems.getShield());
                }else if(ci.equals(ShopBuyItems.getCrossBow())){
                    ShopHandler.buy(player, ShopBuyItems.getCrossBow());
                }else if(ci.equals(ShopBuyItems.getBow())){
                    ShopHandler.buy(player, ShopBuyItems.getBow());
                }else if(ci.equals(ShopBuyItems.getBed())){
                    ShopHandler.buy(player, ShopBuyItems.getBed());
                }else if(ci.equals(ShopBuyItems.getTotem())){
                    ShopHandler.buy(player, ShopBuyItems.getTotem());
                }else if(ci.equals(ShopBuyItems.getTrident())){
                    ShopHandler.buy(player, ShopBuyItems.getTrident());
                }else if(ci.equals(ShopBuyItems.getBeacon())){
                    ShopHandler.buy(player, ShopBuyItems.getBeacon());
                }else if(ci.equals(ShopBuyItems.getTurtleHelmet())){
                    ShopHandler.buy(player, ShopBuyItems.getTurtleHelmet());
                }else if(ci.equals(ShopBuyItems.getEndPortalFrame())){
                    ShopHandler.buy(player, ShopBuyItems.getEndPortalFrame());
                }else if(ci.equals(ShopBuyItems.getDragonHead())){
                    ShopHandler.buy(player, ShopBuyItems.getDragonHead());
                }
            }
        }
    }
}
