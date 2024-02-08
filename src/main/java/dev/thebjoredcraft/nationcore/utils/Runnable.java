package dev.thebjoredcraft.nationcore.utils;

import dev.thebjoredcraft.nationcore.NationCore;
import dev.thebjoredcraft.nationcore.economy.MoneyManager;
import dev.thebjoredcraft.nationcore.economy.shop.ShopHandler;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class Runnable {
    public static BukkitRunnable runnable;
    public static void startDailyRunnable(){
        runnable = new BukkitRunnable() {
            int count = 3;
            @Override
            public void run() {
                if (Bukkit.getServer().getWorld("world").getTime() == 10) {
                    MoneyManager.giveDailyMoney();
                    if(count == 0){
                        ShopHandler.summon(new Location(Bukkit.getWorld("world"), 1715, 139, -1609, 50, 0));
                        Bukkit.broadcast(MiniMessage.miniMessage().deserialize("<bold>Der Händler am Spawn ist gekommen!"));
                        BukkitRunnable delayed = new BukkitRunnable() {
                            @Override
                            public void run() {
                                ShopHandler.kill(Bukkit.getWorld("world"));
                                Bukkit.broadcast(MiniMessage.miniMessage().deserialize("<bold>Der Händler am Spawn ist verschwunden!"));
                            }
                        };
                        BukkitTask bt = delayed.runTaskLater(NationCore.getInstance(), 12000);
                        count = 3;
                    }
                    count--;
                }
            }
        };
        BukkitTask bukkitTask = runnable.runTaskTimer(NationCore.getInstance(), 0, 1);
    }
    public static void stopDailyRunnable() {
        runnable.cancel();
    }
}
