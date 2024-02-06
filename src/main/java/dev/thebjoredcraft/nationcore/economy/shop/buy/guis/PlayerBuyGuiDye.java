package dev.thebjoredcraft.nationcore.economy.shop.buy.guis;

import dev.thebjoredcraft.nationcore.economy.shop.ShopHandler;
import dev.thebjoredcraft.nationcore.economy.shop.buy.ShopBuyItems;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerBuyGuiDye {
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

        gui.setItem(28, ShopBuyItems.getRed());
        gui.setItem(29, ShopBuyItems.getOrange());
        gui.setItem(30, ShopBuyItems.getYellow());
        gui.setItem(31, ShopBuyItems.getLime());
        gui.setItem(32, ShopBuyItems.getGreen());
        gui.setItem(33, ShopBuyItems.getCyan());
        gui.setItem(34, ShopBuyItems.getLight_Blue());
        gui.setItem(37, ShopBuyItems.getBlue());
        gui.setItem(38, ShopBuyItems.getPurple());
        gui.setItem(39, ShopBuyItems.getMagenta());
        gui.setItem(40, ShopBuyItems.getPink());
        gui.setItem(41, ShopBuyItems.getWhite());
        gui.setItem(42, ShopBuyItems.getLight_Gray());
        gui.setItem(43, ShopBuyItems.getBlack());


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
                    player.openInventory(gui);
                }else if(ci.equals(ShopBuyItems.getGrassItem())){
                    player.openInventory(PlayerBuyGuiNaturBlocks.gui);
                }else if(ci.equals(ShopBuyItems.getDropsItem())){
                    player.openInventory(PlayerBuyGuiDrops.gui);
                }else if(ci.equals(ShopBuyItems.getSpecialItem())){
                    player.openInventory(PlayerBuyGuiSpecial.gui);
                }// top line
                else if(ci.equals(ShopBuyItems.getRed())){
                    ShopHandler.buy(player, ShopBuyItems.getRed());
                }else if(ci.equals(ShopBuyItems.getOrange())){
                    ShopHandler.buy(player, ShopBuyItems.getOrange());
                }else if(ci.equals(ShopBuyItems.getYellow())){
                    ShopHandler.buy(player, ShopBuyItems.getYellow());
                }else if(ci.equals(ShopBuyItems.getLime())){
                    ShopHandler.buy(player, ShopBuyItems.getLime());
                }else if(ci.equals(ShopBuyItems.getGreen())){
                    ShopHandler.buy(player, ShopBuyItems.getGreen());
                }else if(ci.equals(ShopBuyItems.getCyan())){
                    ShopHandler.buy(player, ShopBuyItems.getCyan());
                }else if(ci.equals(ShopBuyItems.getLight_Blue())){
                    ShopHandler.buy(player, ShopBuyItems.getLight_Blue());
                }else if(ci.equals(ShopBuyItems.getBlue())){
                    ShopHandler.buy(player, ShopBuyItems.getBlue());
                }else if(ci.equals(ShopBuyItems.getPurple())){
                    ShopHandler.buy(player, ShopBuyItems.getPurple());
                }else if(ci.equals(ShopBuyItems.getMagenta())){
                    ShopHandler.buy(player, ShopBuyItems.getMagenta());
                }else if(ci.equals(ShopBuyItems.getPink())){
                    ShopHandler.buy(player, ShopBuyItems.getPink());
                }else if(ci.equals(ShopBuyItems.getWhite())){
                    ShopHandler.buy(player, ShopBuyItems.getWhite());
                }else if(ci.equals(ShopBuyItems.getLight_Gray())){
                    ShopHandler.buy(player, ShopBuyItems.getLight_Gray());
                }else if(ci.equals(ShopBuyItems.getBlack())){
                    ShopHandler.buy(player, ShopBuyItems.getBlack());
                }
            }
        }
    }
}
