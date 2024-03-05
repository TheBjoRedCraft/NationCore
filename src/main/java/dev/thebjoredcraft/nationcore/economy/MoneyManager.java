package dev.thebjoredcraft.nationcore.economy;

import dev.thebjoredcraft.nationcore.NationCore;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class MoneyManager {
    public static NamespacedKey moneyKey = new NamespacedKey(NationCore.getInstance(), "money");

    public static void setMoney(Player player, int count) {
        player.getPersistentDataContainer().set(moneyKey, PersistentDataType.INTEGER, count);
    }

    public static int getMoney(Player player) {
        int money = 0;
        try {
            money = player.getPersistentDataContainer().get(moneyKey, PersistentDataType.INTEGER);
        } catch (NullPointerException ignored) {
        }
        return money;
    }

    public static void addMoney(Player player, int count) {
        player.getPersistentDataContainer().set(moneyKey, PersistentDataType.INTEGER, getMoney(player) + count);
    }

    public static void removeMoney(Player player, int count) {
        player.getPersistentDataContainer().set(moneyKey, PersistentDataType.INTEGER, getMoney(player) - count);
    }

    public static void giveDailyMoney() {
        for (Player target : Bukkit.getOnlinePlayers()) {
            if(MoneyManager.getMoney(target) != -1) {
                MoneyManager.addMoney(target, 500);
            }
            target.sendMessage(MiniMessage.miniMessage().deserialize("<bold>Guten Morgen, du hast 500 Coins erhalten!"));
        }
    }

//    public static void convertToItem(Player player, int amount) {
//        if (amount <= 64) {
//            ItemStack stack = new ItemStack(Material.PAPER);
//            ItemMeta meta = stack.getItemMeta();
//
//            meta.setCustomModelData(1);
//
//            stack.setItemMeta(meta);
//            stack.setAmount(amount);
//
//            if(player.getInventory().firstEmpty() != -1) {
//                if (getMoney(player) >= amount) {
//                    removeMoney(player, amount);
//                    player.getInventory().addItem(stack);
//                    player.sendMessage(MiniMessage.miniMessage().deserialize("<bold>Du hast " + amount + " Money abgehoben und bekommen!"));
//                } else {
//                    player.sendMessage(MiniMessage.miniMessage().deserialize("<bold>Du hast nicht genügend Money, um so viel von der Bank abzuheben!"));
//                }
//            }else{
//                player.sendMessage(MiniMessage.miniMessage().deserialize("Du brauchst einen leeren Inventar-Slot!"));
//            }
//        }else{
//            player.sendMessage(MiniMessage.miniMessage().deserialize("<bold>Du kannst maximal nur 64 Money pro Abhebung bekommen!"));
//        }
//    }
//    public static void convertToData(Player player) {
//        ItemStack toConvert = player.getItemInHand();
//        int amount = toConvert.getAmount();
//
//        if (toConvert.getItemMeta() != null) {
//            if (toConvert.getItemMeta().hasCustomModelData()) {
//                if (toConvert.getItemMeta().getCustomModelData() == 1 && toConvert.getType() == Material.PAPER) {
//                    addMoney(player, amount);
//                    player.getInventory().removeItem(toConvert);
//                    player.sendMessage(MiniMessage.miniMessage().deserialize("<bold>Du hast " + amount + " Money auf dein Konto aufgeladen!"));
//                } else {
//                    player.sendMessage(MiniMessage.miniMessage().deserialize("<bold>Du musst Money in der hand halten, um es auf dein Konto aufladen zu können!"));
//                }
//            }
//        }
//    }
}
