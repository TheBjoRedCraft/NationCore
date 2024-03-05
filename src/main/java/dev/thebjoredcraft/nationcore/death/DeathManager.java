package dev.thebjoredcraft.nationcore.death;

import dev.thebjoredcraft.nationcore.NationCore;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DeathManager {
    public static NamespacedKey dead = new NamespacedKey(NationCore.getInstance(), "in_dead");

    public static void setDead(Player player, Boolean arg){
        player.getPersistentDataContainer().set(dead, PersistentDataType.BOOLEAN, arg);
    }
    public static Boolean getDead(Player player){
        return player.getPersistentDataContainer().get(dead, PersistentDataType.BOOLEAN);
    }

    public static void handleDeath(Player player){
        setDead(player, true);
        player.sendMessage(MiniMessage.miniMessage().deserialize("<bold>Du bist gestorben! Du kannst nur von anderen mit einem Diamant-Block gerettet werden!"));


    }
}
