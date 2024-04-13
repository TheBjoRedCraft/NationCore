package dev.thebjoredcraft.nationcore;

import dev.thebjoredcraft.nationcore.bossbar.BossBarManager;
import dev.thebjoredcraft.nationcore.death.DeathCommand;
import dev.thebjoredcraft.nationcore.economy.MoneyCommand;
import dev.thebjoredcraft.nationcore.economy.PayCommand;
import dev.thebjoredcraft.nationcore.economy.shop.ShopCommand;
import dev.thebjoredcraft.nationcore.economy.shop.ShopHandler;
import dev.thebjoredcraft.nationcore.event.EventManager;
import dev.thebjoredcraft.nationcore.nation.NationAlertToggleCommand;
import dev.thebjoredcraft.nationcore.nation.PlayerNationManager;
import dev.thebjoredcraft.nationcore.nation.StaffNationCommand;
import dev.thebjoredcraft.nationcore.nick.NickCommand;
import dev.thebjoredcraft.nationcore.region.SpawnCommand;
import dev.thebjoredcraft.nationcore.teleport.TpaAcceptCommand;
import dev.thebjoredcraft.nationcore.teleport.TpaCommand;
import dev.thebjoredcraft.nationcore.teleport.TpaDenyCommand;
import dev.thebjoredcraft.nationcore.utils.Runnable;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.entity.Pose;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.java.JavaPlugin;

public final class NationCore extends JavaPlugin {
    public static NationCore instance;

    public static NationCore getInstance() {
        return instance;
    }

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new EventManager(), this);

        getCommand("snations").setExecutor(new StaffNationCommand());
        getCommand("alerttoggle").setExecutor(new NationAlertToggleCommand());
        getCommand("shop").setExecutor(new ShopCommand());
        getCommand("money").setExecutor(new MoneyCommand());
        getCommand("tpaaccept").setExecutor(new TpaAcceptCommand());
        getCommand("tpa").setExecutor(new TpaCommand());
        getCommand("tpadeny").setExecutor(new TpaDenyCommand());
        getCommand("spawn").setExecutor(new SpawnCommand());
        getCommand("death").setExecutor(new DeathCommand());
        getCommand("pay").setExecutor(new PayCommand());
        getCommand("nick").setExecutor(new NickCommand());
        //PlayerNationManager.setupPlayerData();

        Runnable.startDailyRunnable();
        Runnable.startTenSecondRunnable();
        PlayerNationManager.setupPlayerData();
        ShopHandler.hide();
        BossBarManager.startRunnable();


//        PlayerDataManager.dataFile = new File(get DataFolder(), "data.yml");
//        if (!PlayerDataManager.dataFile.exists()) {
//            getDataFolder().mkdir();
//            saveResource("data.yml", false);
//        }
//        PlayerDataManager.dataConfig = YamlConfiguration.loadConfiguration(PlayerDataManager.dataFile);

        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        ShopHandler.hide();
        Runnable.stopDailyRunnable();
        Runnable.stopTenSecondRunnable();
        BossBarManager.stopRunnable();

        //PlayerNationManager.savePlayerData();
        PlayerNationManager.savePlayerData();

        // Plugin shutdown logic
    }
    public static void setPermission(Player player, String permission, Boolean arg) {
        PermissionAttachment attachment = player.addAttachment(NationCore.getInstance());
        attachment.setPermission(permission, arg);

        player.recalculatePermissions();
    }
}
