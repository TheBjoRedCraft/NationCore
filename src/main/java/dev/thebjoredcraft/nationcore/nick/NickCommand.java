package dev.thebjoredcraft.nationcore.nick;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class NickCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player){
            player.displayName(MiniMessage.miniMessage().deserialize(args[0]));
            player.sendMessage(MiniMessage.miniMessage().deserialize("<red>Dein DisplayName ist nun " + args[0]));
        }
        return false;
    }
}
