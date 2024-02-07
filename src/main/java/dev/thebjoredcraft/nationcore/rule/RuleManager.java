package dev.thebjoredcraft.nationcore.rule;

import dev.thebjoredcraft.nationcore.NationCore;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RuleManager {
    public static NamespacedKey rules = new NamespacedKey(NationCore.getInstance(), "accepted_rules");

    public static void setAcceptedRules(Player player, Boolean arg){
        player.getPersistentDataContainer().set(rules, PersistentDataType.BOOLEAN, arg);
    }
    public static Boolean getAcceptedRules(Player player){
        return player.getPersistentDataContainer().get(rules, PersistentDataType.BOOLEAN);
    }
    public static void sendRules(Player player){
        File rulesFile = new File("plugins/BunnyNationsCore/rules.txt");

        if (!rulesFile.exists()) {
            Bukkit.getConsoleSender().sendMessage("Die Regeln-Datei wurde nicht gefunden.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(rulesFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                player.sendMessage(MiniMessage.miniMessage().deserialize(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
            Bukkit.getConsoleSender().sendMessage("Fehler beim Lesen der Regeln-Datei.");
        }
    }
}
