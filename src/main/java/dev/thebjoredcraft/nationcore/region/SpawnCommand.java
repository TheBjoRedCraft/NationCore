package dev.thebjoredcraft.nationcore.region;

import dev.thebjoredcraft.nationcore.NationCore;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

public class SpawnCommand implements CommandExecutor {
    public static BukkitRunnable runnable;
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player) {
            Location before = player.getLocation();
            player.sendMessage(MiniMessage.miniMessage().deserialize("<bold>Teleportiere... <red>Bewege dich nicht!"));
            if (!player.hasPermission("nations.cmd.spawn.bypass")) {

                runnable = new BukkitRunnable() {
                    int time = 10;

                    @Override
                    public void run() {
                        player.sendMessage(MiniMessage.miniMessage().deserialize("<bold>" + time));
                        time--;
                        if (time == 0) {
                            if (before.equals(player.getLocation())) {
                                player.teleport(player.getWorld().getSpawnLocation());
                            } else {
                                player.sendMessage(MiniMessage.miniMessage().deserialize("<bold>Du hast dich bewegt!"));
                            }
                            runnable.cancel();
                        }
                    }
                };
                BukkitTask bukkitTask = runnable.runTaskTimer(NationCore.getInstance(), 0, 20);
            }else{
                player.teleport(player.getWorld().getSpawnLocation());
            }
        }
        return false;
    }
}
