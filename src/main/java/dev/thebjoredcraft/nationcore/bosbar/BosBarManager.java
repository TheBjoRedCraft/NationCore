package dev.thebjoredcraft.nationcore.bosbar;

import dev.thebjoredcraft.nationcore.utils.Runnable;
import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;

public class BosBarManager {
    public static String arg =
            "<color:#40d1db>" + Runnable.getCount() + " <color:#3b92d1>                                                                                                                                      " +
                    "<color:#40d1db>" + Runnable.getRealInGameTime() + "<color:#3b92d1>                                                                                                                                      s";
    public static BossBar bar = BossBar.bossBar(MiniMessage.miniMessage().deserialize(arg), 0, BossBar.Color.GREEN, BossBar.Overlay.PROGRESS);

    public static void show(Player player){
        player.showBossBar(bar);
    }
    public static void update(Player player){
        hide(player);
        show(player);
    }
    public static void hide(Player player){
        player.hideBossBar(bar);
    }
}
