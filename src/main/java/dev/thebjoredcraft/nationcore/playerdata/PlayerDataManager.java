package dev.thebjoredcraft.nationcore.playerdata;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class PlayerDataManager {
    public static void saveData(Player player){
        UUID uuid = player.getUniqueId();
        String address = player.getAddress().toString();
        String name = player.getName();
        String displayName = player.getUniqueId().toString();
        Location latestLocation = player.getLocation();


        double x = latestLocation.getX();
        double y = latestLocation.getY();
        double z = latestLocation.getZ();

    }
    public static FileConfiguration dataConfig;
    public static File dataFile;

    public static void saveDataFile() {
        try {
            dataConfig.save(dataFile);
        } catch (IOException e) {
            Bukkit.getConsoleSender().sendMessage("[NationCore] " + e.getMessage());
        }
    }
    public static void setLatestLocation(Player player){
        Location location = player.getLocation();
        String worldName = location.getWorld().getName();
        double x = location.getX();
        double y = location.getY();
        double z = location.getZ();

        dataConfig.set(player.getUniqueId() + ".world", worldName);
        dataConfig.set(player.getUniqueId() + ".x", x);
        dataConfig.set(player.getUniqueId() + ".y", y);
        dataConfig.set(player.getUniqueId() + ".z", z);

    }
}
