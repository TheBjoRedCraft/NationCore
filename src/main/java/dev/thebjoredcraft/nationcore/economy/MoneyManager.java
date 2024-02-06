package dev.thebjoredcraft.nationcore.economy;

import dev.thebjoredcraft.nationcore.NationCore;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;

public class MoneyManager {
    public static NamespacedKey moneyKey = new NamespacedKey(NationCore.getInstance(), "money");
    public static void setMoney(Player player, int count){
        player.getPersistentDataContainer().set(moneyKey, PersistentDataType.INTEGER, count);
    }
    public static int getMoney(Player player){
        int money = 0;
        try {
            money = player.getPersistentDataContainer().get(moneyKey, PersistentDataType.INTEGER);
        }catch (NullPointerException ignored){}
        return money;
    }
    public static void addMoney(Player player, int count){
        player.getPersistentDataContainer().set(moneyKey, PersistentDataType.INTEGER, getMoney(player) + count);
    }
    public static void removeMoney(Player player, int count){
        player.getPersistentDataContainer().set(moneyKey, PersistentDataType.INTEGER, getMoney(player) - count);
    }
}
