package dev.thebjoredcraft.nationcore.rule;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class RuleCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player){
            if(args.length == 1) {
                if (args[0].equalsIgnoreCase("accept")) {
                    RuleManager.setAcceptedRules(player, true);
                    player.sendMessage(MiniMessage.miniMessage().deserialize("<#3b92d1>Viel Spass auf dem Server!"));
                } else if (args[0].equalsIgnoreCase("reject")) {
                    RuleManager.setAcceptedRules(player, false);
                    player.kick(MiniMessage.miniMessage().deserialize("<red>Du musst die Regeln akzeptieren um auf dem Server zu spielen!"));
                }
            }else{
                RuleManager.sendRules(player);
            }
        }
        return false;
    }
}