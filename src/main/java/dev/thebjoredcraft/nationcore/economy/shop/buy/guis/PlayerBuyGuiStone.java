package dev.thebjoredcraft.nationcore.economy.shop.buy.guis;

import dev.thebjoredcraft.nationcore.economy.shop.ShopHandler;
import dev.thebjoredcraft.nationcore.economy.shop.buy.ShopBuyItems;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerBuyGuiStone {
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

        gui.setItem(28, ShopBuyItems.getStone());
        gui.setItem(29, ShopBuyItems.getCobble());
        gui.setItem(30, ShopBuyItems.getMossyCobble());
        gui.setItem(31, ShopBuyItems.getStoneBricks());
        gui.setItem(32, ShopBuyItems.getSmoothStone());
        gui.setItem(33, ShopBuyItems.getDripStoneBlock());
        gui.setItem(34, ShopBuyItems.getDripStonePointed());
        gui.setItem(37, ShopBuyItems.getBlackStone());
        gui.setItem(38, ShopBuyItems.getGlowStone());
        gui.setItem(39, ShopBuyItems.getEndStone());
        gui.setItem(40, ShopBuyItems.getTerracotta());

        player.openInventory(gui);
    }

    public static void handle(InventoryClickEvent event){
        if(event.getClickedInventory() != null) {
            if (event.getClickedInventory().equals(gui)) {
                Player player = (Player) event.getWhoClicked();
                ItemStack ci = event.getCurrentItem();

                event.setCancelled(true);
                if (ci != null) {
                    if (ci.equals(ShopBuyItems.getWoodItem())) {
                        PlayerBuyGuiWood.open(player);
                    } else if (ci.equals(ShopBuyItems.getStoneItem())) {
                        open(player);
                    } else if (ci.equals(ShopBuyItems.getOreItem())) {
                        PlayerBuyGuiOre.open(player);
                    } else if (ci.equals(ShopBuyItems.getDyeItem())) {
                        PlayerBuyGuiDye.open(player);
                    } else if (ci.equals(ShopBuyItems.getGrassItem())) {
                        PlayerBuyGuiNaturBlocks.open(player);
                    } else if (ci.equals(ShopBuyItems.getDropsItem())) {
                        PlayerBuyGuiDrops.open(player);
                    } else if (ci.equals(ShopBuyItems.getSpecialItem())) {
                        PlayerBuyGuiSpecial.open(player);
                    }// top line
                    else if (ci.equals(ShopBuyItems.getStone())) {
                        ShopHandler.buy(player, ShopBuyItems.getStone());
                    } else if (ci.equals(ShopBuyItems.getCobble())) {
                        ShopHandler.buy(player, ShopBuyItems.getCobble());
                    } else if (ci.equals(ShopBuyItems.getMossyCobble())) {
                        ShopHandler.buy(player, ShopBuyItems.getMossyCobble());
                    } else if (ci.equals(ShopBuyItems.getStoneBricks())) {
                        ShopHandler.buy(player, ShopBuyItems.getStoneBricks());
                    } else if (ci.equals(ShopBuyItems.getSmoothStone())) {
                        ShopHandler.buy(player, ShopBuyItems.getSmoothStone());
                    } else if (ci.equals(ShopBuyItems.getDripStoneBlock())) {
                        ShopHandler.buy(player, ShopBuyItems.getDripStoneBlock());
                    } else if (ci.equals(ShopBuyItems.getDripStonePointed())) {
                        ShopHandler.buy(player, ShopBuyItems.getDripStonePointed());
                    } else if (ci.equals(ShopBuyItems.getBlackStone())) {
                        ShopHandler.buy(player, ShopBuyItems.getBlackStone());
                    } else if (ci.equals(ShopBuyItems.getGlowStone())) {
                        ShopHandler.buy(player, ShopBuyItems.getGlowStone());
                    } else if (ci.equals(ShopBuyItems.getEndStone())) {
                        ShopHandler.buy(player, ShopBuyItems.getEndStone());
                    } else if (ci.equals(ShopBuyItems.getTerracotta())) {
                        ShopHandler.buy(player, ShopBuyItems.getTerracotta());
                    }
                }
            }
        }
    }
}
