package dev.thebjoredcraft.nationcore.economy.shop.buy.guis;

import dev.thebjoredcraft.nationcore.economy.shop.ShopHandler;
import dev.thebjoredcraft.nationcore.economy.shop.buy.ShopBuyItems;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerBuyGuiOre {
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

        gui.setItem(28, ShopBuyItems.getEmerald());
        gui.setItem(29, ShopBuyItems.getDiamond());
        gui.setItem(30, ShopBuyItems.getLapisLazuli());
        gui.setItem(31, ShopBuyItems.getAmethyst());
        gui.setItem(32, ShopBuyItems.getGold());
        gui.setItem(33, ShopBuyItems.getCopper());
        gui.setItem(34, ShopBuyItems.getRedstone());
        gui.setItem(37, ShopBuyItems.getEnderPearl());
        gui.setItem(38, ShopBuyItems.getHeart());
        gui.setItem(39, ShopBuyItems.getEchoShard());
        gui.setItem(40, ShopBuyItems.getDiscFragment());
        gui.setItem(41, ShopBuyItems.getAncientDebris());
        gui.setItem(42, ShopBuyItems.getIron());
        gui.setItem(43, ShopBuyItems.getQuartz());

        player.openInventory(gui);
    }

    public static void handle(InventoryClickEvent event) {
        if (event.getClickedInventory() != null) {
            if (event.getClickedInventory().equals(gui)) {
                Player player = (Player) event.getWhoClicked();
                ItemStack ci = event.getCurrentItem();

                event.setCancelled(true);
                if (ci != null) {
                    if (ci.equals(ShopBuyItems.getWoodItem())) {
                        PlayerBuyGuiWood.open(player);
                    } else if (ci.equals(ShopBuyItems.getStoneItem())) {
                        PlayerBuyGuiStone.open(player);
                    } else if (ci.equals(ShopBuyItems.getOreItem())) {
                        open(player);
                    } else if (ci.equals(ShopBuyItems.getDyeItem())) {
                        PlayerBuyGuiDye.open(player);
                    } else if (ci.equals(ShopBuyItems.getGrassItem())) {
                        PlayerBuyGuiNaturBlocks.open(player);
                    } else if (ci.equals(ShopBuyItems.getDropsItem())) {
                        PlayerBuyGuiDrops.open(player);
                    } else if (ci.equals(ShopBuyItems.getSpecialItem())) {
                        PlayerBuyGuiSpecial.open(player);
                    }// top line
                    else if (ci.equals(ShopBuyItems.getEmerald())) {
                        ShopHandler.buy(player, ShopBuyItems.getEmerald());
                    } else if (ci.equals(ShopBuyItems.getDiamond())) {
                        ShopHandler.buy(player, ShopBuyItems.getDiamond());
                    } else if (ci.equals(ShopBuyItems.getLapisLazuli())) {
                        ShopHandler.buy(player, ShopBuyItems.getLapisLazuli());
                    } else if (ci.equals(ShopBuyItems.getAmethyst())) {
                        ShopHandler.buy(player, ShopBuyItems.getAmethyst());
                    } else if (ci.equals(ShopBuyItems.getGold())) {
                        ShopHandler.buy(player, ShopBuyItems.getGold());
                    } else if (ci.equals(ShopBuyItems.getCopper())) {
                        ShopHandler.buy(player, ShopBuyItems.getCopper());
                    } else if (ci.equals(ShopBuyItems.getRedstone())) {
                        ShopHandler.buy(player, ShopBuyItems.getRedstone());
                    } else if (ci.equals(ShopBuyItems.getEnderPearl())) {
                        ShopHandler.buy(player, ShopBuyItems.getEnderPearl());
                    } else if (ci.equals(ShopBuyItems.getHeart())) {
                        ShopHandler.buy(player, ShopBuyItems.getHeart());
                    } else if (ci.equals(ShopBuyItems.getEchoShard())) {
                        ShopHandler.buy(player, ShopBuyItems.getEchoShard());
                    } else if (ci.equals(ShopBuyItems.getDiscFragment())) {
                        ShopHandler.buy(player, ShopBuyItems.getDiscFragment());
                    } else if (ci.equals(ShopBuyItems.getAncientDebris())) {
                        ShopHandler.buy(player, ShopBuyItems.getAncientDebris());
                    } else if (ci.equals(ShopBuyItems.getIron())) {
                        ShopHandler.buy(player, ShopBuyItems.getIron());
                    } else if (ci.equals(ShopBuyItems.getQuartz())) {
                        ShopHandler.buy(player, ShopBuyItems.getQuartz());
                    }
                }
            }
        }
    }
}
