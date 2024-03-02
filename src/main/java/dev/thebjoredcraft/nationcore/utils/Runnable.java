package dev.thebjoredcraft.nationcore.utils;

import dev.thebjoredcraft.nationcore.NationCore;
import dev.thebjoredcraft.nationcore.bosbar.BosBarManager;
import dev.thebjoredcraft.nationcore.economy.MoneyManager;
import dev.thebjoredcraft.nationcore.economy.shop.ShopHandler;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;


public class Runnable {
    public static BukkitRunnable runnable;
    public static BukkitRunnable runnable2;
    public static String count = "";
    public static long inGameTime;
    public static void startDailyRunnable(){
        count = "3";
        runnable = new BukkitRunnable() {

            @Override
            public void run() {
                if (Bukkit.getServer().getWorld("world").getTime() == 10) {
                    MoneyManager.giveDailyMoney();
                    if(count.equalsIgnoreCase("0")){
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
                        count = "3";
                    }
                    int countI = Integer.parseInt(count);
                    countI--;
                    count = String.valueOf(countI);
                }
                
                inGameTime = Bukkit.getWorld("world").getTime();
                for(Player target : Bukkit.getOnlinePlayers()) {
                    BosBarManager.update(target);
                }
            }
        };
        BukkitTask bukkitTask = runnable.runTaskTimer(NationCore.getInstance(), 0, 1);
    }

    public static void stopDailyRunnable() {
        runnable.cancel();
    }

    public static int getCount(){
        return Integer.parseInt(count);
    }
    public static String getRealInGameTime(){
        long time = inGameTime;

        long hours = (time / 1000 + 6) % 24;
        long minutes = (long) ((time % 1000) * 0.06);

        String formattedHours = String.format("%02d", hours);
        String formattedMinutes = String.format("%02d", minutes);

        return formattedHours + ":" + formattedMinutes + " Uhr";
    }
}
