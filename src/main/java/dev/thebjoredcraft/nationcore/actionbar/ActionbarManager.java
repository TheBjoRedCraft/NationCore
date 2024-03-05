package dev.thebjoredcraft.nationcore.actionbar;

import dev.thebjoredcraft.nationcore.economy.MoneyManager;
import dev.thebjoredcraft.nationcore.nation.PlayerNationManager;
import dev.thebjoredcraft.nationcore.utils.Runnable;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;

public class ActionbarManager {
    public static void send(Player player) {
        if (MoneyManager.getMoney(player) != -1) {
            player.sendActionBar(MiniMessage.miniMessage().deserialize("<color:#3b92d1><bold>Uhrzeit: %time%     Deine Nation: %nation%<color:#3b92d1>     Dein Geld: %money%"
                    .replace("%time%", Runnable.getRealInGameTime())
                    .replace("%money%", String.valueOf(MoneyManager.getMoney(player)))
                    .replace("%nation%", PlayerNationManager.getTeam(player.getName()).getDisplayName())));
        }else{
            player.sendActionBar(MiniMessage.miniMessage().deserialize("<color:#3b92d1><bold>Uhrzeit: %time%     Deine Nation: %nation%<color:#3b92d1>     Dein Geld: %money%"
                    .replace("%time%", Runnable.getRealInGameTime())
                    .replace("%money%", "Unendlich (oo)")
                    .replace("%nation%", PlayerNationManager.getTeam(player.getName()).getDisplayName())));
        }
    }
}
