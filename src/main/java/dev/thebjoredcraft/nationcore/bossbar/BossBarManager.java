package dev.thebjoredcraft.nationcore.bossbar;

import dev.thebjoredcraft.nationcore.NationCore;
import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BossBarManager {
    public static BossBar bossBar;
    public static BukkitRunnable runnable;
    public static List<String> messages = new ArrayList<>();
    public static int currentIndex = 0;
    public static boolean bossBarEnabled = true;
    public static final String FILE_NAME = "bossbar.txt";

    public static void startRunnable(){
        runnable = new BukkitRunnable() {
            @Override
            public void run() {
                updateBossBar();
            }
        };
        BukkitTask bukkitTask = runnable.runTaskTimer(NationCore.getInstance(), 0, 20);
        loadMessagesFromFile();
    }
    public static void stopRunnable(){
        if(!runnable.isCancelled()) {
            runnable.cancel();
        }
        saveMessagesToFile();
    }
    public static void updateBossBar() {
        if (!bossBarEnabled || messages.isEmpty()) {
            return;
        }

        String message = messages.get(currentIndex);
        currentIndex = (currentIndex + 1) % messages.size();

        if (bossBar == null) {
            bossBar = BossBar.bossBar(MiniMessage.miniMessage().deserialize(message), 0, BossBar.Color.WHITE, BossBar.Overlay.PROGRESS);
        } else {
            bossBar.name(MiniMessage.miniMessage().deserialize(message));
        }

        for (Player player : Bukkit.getOnlinePlayers()) {
            bossBar.addViewer(player);
        }
    }

    public static void sendMessages(Player sender) {
        sender.sendMessage("Current messages in the boss bar:");
        for (int i = 0; i < messages.size(); i++) {
            sender.sendMessage(i + ": " + messages.get(i));
        }
    }

    public static void toggleBossBar() {
        bossBarEnabled = !bossBarEnabled;
    }

    public static void loadMessagesFromFile() {
        File file = new File(NationCore.getInstance().getDataFolder(), FILE_NAME);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    messages.add(line);
                }
            } catch (IOException e) {
                Bukkit.getConsoleSender().sendMessage("<red>" + MiniMessage.miniMessage().deserialize(e.getMessage()));
            }
        }
    }

    public static void saveMessagesToFile() {
        File file = new File(NationCore.getInstance().getDataFolder(), FILE_NAME);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String message : messages) {
                writer.write(message);
                writer.newLine();
            }
        } catch (IOException e) {
            Bukkit.getConsoleSender().sendMessage("<red>" + MiniMessage.miniMessage().deserialize(e.getMessage()));
        }
    }
}
