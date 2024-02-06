package dev.thebjoredcraft.nationcore.economy.shop.buy.guis;

import dev.thebjoredcraft.nationcore.economy.shop.ShopHandler;
import dev.thebjoredcraft.nationcore.economy.shop.buy.ShopBuyItems;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerBuyGuiNaturBlocks {
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

        gui.setItem(28, ShopBuyItems.getGrass());
        gui.setItem(29, ShopBuyItems.getDirt());
        gui.setItem(30, ShopBuyItems.getCourseDirt());
        gui.setItem(31, ShopBuyItems.getRootedDirt());
        gui.setItem(32, ShopBuyItems.getSandStone());
        gui.setItem(33, ShopBuyItems.getSand());
        gui.setItem(34, ShopBuyItems.getSusSand());
        gui.setItem(37, ShopBuyItems.getRedSand());
        gui.setItem(38, ShopBuyItems.getRedSandStone());
        gui.setItem(39, ShopBuyItems.getSoulSand());
        gui.setItem(40, ShopBuyItems.getSpyGlass());
        gui.setItem(41, ShopBuyItems.getBottle());
        gui.setItem(42, ShopBuyItems.getGlass());
        gui.setItem(43, ShopBuyItems.getGravel());


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
                    player.openInventory(gui);
                }else if(ci.equals(ShopBuyItems.getDropsItem())){
                    player.openInventory(PlayerBuyGuiDrops.gui);
                }else if(ci.equals(ShopBuyItems.getSpecialItem())){
                    player.openInventory(PlayerBuyGuiSpecial.gui);
                }// top line
                else if(ci.equals(ShopBuyItems.getGrass())){
                    ShopHandler.buy(player, ShopBuyItems.getGrass());
                }else if(ci.equals(ShopBuyItems.getDirt())){
                    ShopHandler.buy(player, ShopBuyItems.getDirt());
                }else if(ci.equals(ShopBuyItems.getCourseDirt())){
                    ShopHandler.buy(player, ShopBuyItems.getCourseDirt());
                }else if(ci.equals(ShopBuyItems.getRootedDirt())){
                    ShopHandler.buy(player, ShopBuyItems.getRootedDirt());
                }else if(ci.equals(ShopBuyItems.getSandStone())){
                    ShopHandler.buy(player, ShopBuyItems.getSandStone());
                }else if(ci.equals(ShopBuyItems.getSand())){
                    ShopHandler.buy(player, ShopBuyItems.getSand());
                }else if(ci.equals(ShopBuyItems.getSusSand())){
                    ShopHandler.buy(player, ShopBuyItems.getSusSand());
                }else if(ci.equals(ShopBuyItems.getRedSand())){
                    ShopHandler.buy(player, ShopBuyItems.getRedSand());
                }else if(ci.equals(ShopBuyItems.getRedSandStone())){
                    ShopHandler.buy(player, ShopBuyItems.getRedSandStone());
                }else if(ci.equals(ShopBuyItems.getSoulSand())){
                    ShopHandler.buy(player, ShopBuyItems.getSoulSand());
                }else if(ci.equals(ShopBuyItems.getSpyGlass())){
                    ShopHandler.buy(player, ShopBuyItems.getSpyGlass());
                }else if(ci.equals(ShopBuyItems.getBottle())){
                    ShopHandler.buy(player, ShopBuyItems.getBottle());
                }else if(ci.equals(ShopBuyItems.getGlass())){
                    ShopHandler.buy(player, ShopBuyItems.getGlass());
                }else if(ci.equals(ShopBuyItems.getGravel())){
                    ShopHandler.buy(player, ShopBuyItems.getGravel());
                }
            }
        }
    }
}
