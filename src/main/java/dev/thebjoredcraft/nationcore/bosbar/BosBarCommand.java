package dev.thebjoredcraft.nationcore.bosbar;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BosBarCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player){
            if(args[0].equalsIgnoreCase("true")){
                BosBarManager.show(player);
            }else {
                BosBarManager.hide(player);
            }
        }
        return false;
    }
}
