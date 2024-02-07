package dev.thebjoredcraft.nationcore.economy;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MoneyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player) {
            try{
            if (args.length == 2) {
                if (player.hasPermission("bunnynationscore.command.money.args")) {
                    if (args[0].equalsIgnoreCase("add")) {
                        int count = Integer.parseInt(args[1]);
                        MoneyManager.addMoney(player, count);
                        //<color:#3b92d1>
                        player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Deine Money haben sich veraendert. Du hast nun " + MoneyManager.getMoney(player) + " Money!"));
                    } else if (args[0].equalsIgnoreCase("remove")) {
                        int count = Integer.parseInt(args[1]);
                        MoneyManager.removeMoney(player, count);
                        player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Deine Money haben sich veraendert. Du hast nun " + MoneyManager.getMoney(player) + " Money!"));
                    } else if (args[0].equalsIgnoreCase("set")) {
                        int count = Integer.parseInt(args[1]);
                        MoneyManager.setMoney(player, count);
                        player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Deine Money haben sich veraendert. Du hast nun " + MoneyManager.getMoney(player) + " Money!"));
                    }
                }else{
                    player.sendMessage("No Permission!");
                }
            }else if(args.length == 3) {
                Player target = Bukkit.getPlayer(args[1]);

                if (target != null) {
                    if (player.hasPermission("bunnynationscore.command.money.args")) {
                        if (args[0].equalsIgnoreCase("add")) {
                            int count = Integer.parseInt(args[2]);
                            MoneyManager.addMoney(target, count);
                            target.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Dein Money hat sich veraendert. Du hast nun " + MoneyManager.getMoney(target) + " Money!"));
                            player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>"+ target.getName() + " Money hat sich veraendert. Nun " + MoneyManager.getMoney(target) + " Money!"));
                        } else if (args[0].equalsIgnoreCase("remove")) {
                            int count = Integer.parseInt(args[2]);
                            MoneyManager.removeMoney(target, count);
                            target.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Dein Money habt sich veraendert. Du hast nun " + MoneyManager.getMoney(target) + " Money!"));
                            player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>"+ target.getName() + " Money hat sich veraendert. Nun " + MoneyManager.getMoney(target) + " Money!"));
                        } else if (args[0].equalsIgnoreCase("set")) {
                            int count = Integer.parseInt(args[2]);
                            MoneyManager.setMoney(target, count);
                            target.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Dein Money hat sich veraendert. Du hast nun " + MoneyManager.getMoney(target) + " Money!"));
                            player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>"+ target.getName() + " Money hat sich veraendert. Nun " + MoneyManager.getMoney(target) + " Money!"));
                        } else if (args[0].equalsIgnoreCase("get")) {
                            player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>"+ target.getName() + " hat aktuell " + MoneyManager.getMoney(target) + " Money!"));
                        }
                    } else {
                        player.sendMessage("No Permission!");
                    }
                }else{
                    player.sendMessage("Der Spieler wurde nicht gefunden!");
                }
            }else if(args.length == 0){
                player.sendMessage("Deine Money: " + MoneyManager.getMoney(player));
            }else{
                player.sendMessage("Incorrect Usage!");
            }
        }catch (IllegalArgumentException e){
                player.sendMessage("Bitte weniger!");
            }
        }
        return false;
    }

}