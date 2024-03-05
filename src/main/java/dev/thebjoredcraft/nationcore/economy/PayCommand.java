package dev.thebjoredcraft.nationcore.economy;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PayCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player) {
            if (args.length == 2) {
                try {
                    Player target = Bukkit.getPlayer(args[0]);
                    int count = Integer.parseInt(args[1]);
                    if (target != null) {
                        if (count > 0) {
                            if(MoneyManager.getMoney(player) != -1) {
                                MoneyManager.removeMoney(player, count);
                                MoneyManager.addMoney(target, count);

                                player.sendMessage(MiniMessage.miniMessage().deserialize("<red>Du hast " + target.getName() + " " + count + " Money überwiesen!"));
                                target.sendMessage(MiniMessage.miniMessage().deserialize("<red>" + player.getName() + " hat dir " + count + " Money überwiesen!"));
                            }else{
                                MoneyManager.addMoney(target, count);

                                player.sendMessage(MiniMessage.miniMessage().deserialize("<red>Du hast " + target.getName() + " " + count + " Money überwiesen! (Du hast Unendlich)"));
                                target.sendMessage(MiniMessage.miniMessage().deserialize("<red>" + player.getName() + " hat dir " + count + " Money überwiesen!"));
                            }

                        } else {
                            player.sendMessage(MiniMessage.miniMessage().deserialize("<red>Der Betrag muss über 0 liegen!"));
                        }
                    } else {
                        player.sendMessage(MiniMessage.miniMessage().deserialize("<red>Der Spieler wurde nicht gefunden!"));
                    }
                }catch (NumberFormatException e){
                    player.sendMessage(MiniMessage.miniMessage().deserialize("<red>/pay <spieler> <betrag>"));
                }
            }else{
                player.sendMessage(MiniMessage.miniMessage().deserialize("<red>/pay <spieler> <betrag>"));
            }
        }else{
            sender.sendMessage(MiniMessage.miniMessage().deserialize("<red>Du musst ein Spieler sein!"));
        }
        return false;
    }
}
