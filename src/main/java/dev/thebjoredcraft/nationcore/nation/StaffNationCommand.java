package dev.thebjoredcraft.nationcore.nation;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class StaffNationCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(sender instanceof Player player){
            if(args.length == 3 && args[0].equalsIgnoreCase("set")){
                String nation = args[2];
                Player target = Bukkit.getPlayer(args[1]);
                if(target != null){
                    if(nation.equalsIgnoreCase("water") || nation.equalsIgnoreCase("fire")) {
                        PlayerNationManager.joinTeam(target, nation);
                        if(nation.equalsIgnoreCase("fire")) {
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "region removemember water " + target.getName() + " -w world");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "region addmember " + nation + " " + target.getName() + " -w world");
                        }else{
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "region removemember fire " + target.getName() + " -w world");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "region addmember " + nation + " " + target.getName() + " -w world");
                        }
                    }else{
                        player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Es gibt nur diese Nationen: <color:#40d1db>Water, Fire"));
                    }
                }
            }else if(args.length == 2 && args[0].equalsIgnoreCase("remove")){
                Player target = Bukkit.getPlayer(args[1]);
                if(target != null){
                    String nation = PlayerNationManager.getTeam(target);

                    PlayerNationManager.leaveTeam(target);

                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "region removemember " + nation + " " + target.getName() + " -w world");
                }
            }else if(args.length == 2 && args[0].equalsIgnoreCase("get")){
                Player target = Bukkit.getPlayer(args[1]);
                if(target != null){
                    player.sendMessage(PlayerNationManager.getTeam(target));
                }
            }
        }
        return false;
    }
}
