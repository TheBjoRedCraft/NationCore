package dev.thebjoredcraft.nationcore.economy.shop.buy.guis;

import dev.thebjoredcraft.nationcore.economy.shop.ShopHandler;
import dev.thebjoredcraft.nationcore.economy.shop.buy.ShopBuyItems;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerBuyGuiDrops {
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

        gui.setItem(28, ShopBuyItems.getBone());
        gui.setItem(29, ShopBuyItems.getString());
        gui.setItem(30, ShopBuyItems.getFeather());
        gui.setItem(31, ShopBuyItems.getEgg());
        gui.setItem(32, ShopBuyItems.getLeather());
        gui.setItem(33, ShopBuyItems.getRabbitHide());
        gui.setItem(34, ShopBuyItems.getHoneyComb());
        gui.setItem(37, ShopBuyItems.getBlaze());
        gui.setItem(38, ShopBuyItems.getShulker());
        gui.setItem(39, ShopBuyItems.getGunpowder());
        gui.setItem(40, ShopBuyItems.getCookedBeef());
        gui.setItem(41, ShopBuyItems.getPotato());
        gui.setItem(42, ShopBuyItems.getBread());
        gui.setItem(43, ShopBuyItems.getChicken());


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
                    player.openInventory(gui);
                }else if(ci.equals(ShopBuyItems.getSpecialItem())){
                    player.openInventory(PlayerBuyGuiSpecial.gui);
                }// top line
                else if(ci.equals(ShopBuyItems.getBone())){
                    ShopHandler.buy(player, ShopBuyItems.getBone());
                }else if(ci.equals(ShopBuyItems.getString())){
                    ShopHandler.buy(player, ShopBuyItems.getString());
                }else if(ci.equals(ShopBuyItems.getFeather())){
                    ShopHandler.buy(player, ShopBuyItems.getFeather());
                }else if(ci.equals(ShopBuyItems.getEgg())){
                    ShopHandler.buy(player, ShopBuyItems.getEgg());
                }else if(ci.equals(ShopBuyItems.getLeather())){
                    ShopHandler.buy(player, ShopBuyItems.getLeather());
                }else if(ci.equals(ShopBuyItems.getRabbitHide())){
                    ShopHandler.buy(player, ShopBuyItems.getRabbitHide());
                }else if(ci.equals(ShopBuyItems.getHoneyComb())){
                    ShopHandler.buy(player, ShopBuyItems.getHoneyComb());
                }else if(ci.equals(ShopBuyItems.getBlaze())){
                    ShopHandler.buy(player, ShopBuyItems.getBlaze());
                }else if(ci.equals(ShopBuyItems.getShulker())){
                    ShopHandler.buy(player, ShopBuyItems.getShulker());
                }else if(ci.equals(ShopBuyItems.getGunpowder())){
                    ShopHandler.buy(player, ShopBuyItems.getGunpowder());
                }else if(ci.equals(ShopBuyItems.getCookedBeef())){
                    ShopHandler.buy(player, ShopBuyItems.getCookedBeef());
                }else if(ci.equals(ShopBuyItems.getPotato())){
                    ShopHandler.buy(player, ShopBuyItems.getPotato());
                }else if(ci.equals(ShopBuyItems.getBread())){
                    ShopHandler.buy(player, ShopBuyItems.getBread());
                }else if(ci.equals(ShopBuyItems.getChicken())){
                    ShopHandler.buy(player, ShopBuyItems.getChicken());
                }
            }
        }
    }
}
