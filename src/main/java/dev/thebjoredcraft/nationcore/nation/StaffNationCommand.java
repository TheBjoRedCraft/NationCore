package dev.thebjoredcraft.nationcore.nation;

import dev.thebjoredcraft.nationcore.bosbar.BosBarManager;
import dev.thebjoredcraft.nationcore.economy.shop.ShopHandler;
import dev.thebjoredcraft.nationcore.kingsystem.KingManager;
import dev.thebjoredcraft.nationcore.utils.Runnable;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StaffNationCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(sender instanceof Player player){
            if(args.length == 3 && args[0].equalsIgnoreCase("set")){
                String nation = args[2];
                Player target = Bukkit.getPlayer(args[1]);
                if(target != null){
                    if(nation.equalsIgnoreCase("water") || nation.equalsIgnoreCase("fire") || nation.equalsIgnoreCase("nothing")) {
                        PlayerNationManager.joinTeam(target.getName(), nation);
                    }else{
                        player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Es gibt nur diese Nationen: <color:#40d1db>Water, Fire, Nothing"));
                    }
                }
            }else if(args.length == 2 && args[0].equalsIgnoreCase("remove")){
                Player target = Bukkit.getPlayer(args[1]);
                if(target != null){
                    PlayerNationManager.leaveTeam(target.getName());
                }
            }else if(args.length == 2 && args[0].equalsIgnoreCase("get")){
                Player target = Bukkit.getPlayer(args[1]);
                if(target != null){
                    player.sendMessage(PlayerNationManager.getTeam(target.getName()).getDisplayName());
                }
            }else if(args.length == 1 && args[0].equalsIgnoreCase("time")){
                player.sendMessage(MiniMessage.miniMessage().deserialize("<red>" + Runnable.getRealInGameTime()));
                player.sendMessage(MiniMessage.miniMessage().deserialize("<red>---------"));
                player.sendMessage(MiniMessage.miniMessage().deserialize("<red>" + Runnable.getCount()));
            }else if(args.length == 1 && args[0].equalsIgnoreCase("sv")){
                if(ShopHandler.isVisible){
                    ShopHandler.hide();
                }else{
                    ShopHandler.show();
                }
                player.sendMessage(MiniMessage.miniMessage().deserialize("<red>The Shop Handler visibility is now: " + ShopHandler.isVisible));
            }else if(args.length == 2 && args[0].equalsIgnoreCase("crown")){
                Player target = Bukkit.getPlayer(args[1]);
                if(target != null){
                    KingManager.giveCrown(player, target);
                    player.sendMessage(MiniMessage.miniMessage().deserialize("<red>Der Spieler hat nun eine Krone!"));
                }
            }else{
                player.sendMessage(MiniMessage.miniMessage().deserialize("<red>/snations set <player> <nation>"));
                player.sendMessage(MiniMessage.miniMessage().deserialize("<red>/snations get <player>"));
                player.sendMessage(MiniMessage.miniMessage().deserialize("<red>/snations remove <player>"));
                player.sendMessage(MiniMessage.miniMessage().deserialize("<red>/snations sv"));
                player.sendMessage(MiniMessage.miniMessage().deserialize("<red>/snations crown <player>"));
            }
        }
        return false;
    }
    private final String[] sub1 = new String[]{"set","get", "remove", "time", "crown"};
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        List<String> completions = new ArrayList<>();
        if(args.length == 0) {
            StringUtil.copyPartialMatches(args[0], Arrays.asList(sub1), completions);
        }
        Collections.sort(completions);
        return completions;
    }
}
