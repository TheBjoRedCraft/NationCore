package dev.thebjoredcraft.nationcore;

import dev.thebjoredcraft.nationcore.economy.MoneyCommand;
import dev.thebjoredcraft.nationcore.economy.MoneyConvertCommand;
import dev.thebjoredcraft.nationcore.economy.MoneyManager;
import dev.thebjoredcraft.nationcore.economy.shop.ShopCommand;
import dev.thebjoredcraft.nationcore.event.EventManager;
import dev.thebjoredcraft.nationcore.nation.NationAlertToggleCommand;
import dev.thebjoredcraft.nationcore.nation.PlayerNationManager;
import dev.thebjoredcraft.nationcore.nation.StaffNationCommand;
import dev.thebjoredcraft.nationcore.rule.RuleCommand;
import dev.thebjoredcraft.nationcore.teleport.TpaAcceptCommand;
import dev.thebjoredcraft.nationcore.teleport.TpaCommand;
import dev.thebjoredcraft.nationcore.teleport.TpaDenyCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
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
        getCommand("convertmoney").setExecutor(new MoneyConvertCommand());
        getCommand("tpaaccept").setExecutor(new TpaAcceptCommand());
        getCommand("tpa").setExecutor(new TpaCommand());
        getCommand("tpadeny").setExecutor(new TpaDenyCommand());
        getCommand("spawn").setExecutor(new TpaDenyCommand());
        getCommand("rules").setExecutor(new RuleCommand());


        PlayerNationManager.connectToDatabase();
        PlayerNationManager.createTables();

        MoneyManager.startDaily();

        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        MoneyManager.stopDaily();
        // Plugin shutdown logic
    }
    public static void setPermission(Player player, String permission, Boolean arg) {
        PermissionAttachment attachment = player.addAttachment(NationCore.getInstance());
        attachment.setPermission(permission, arg);

        player.recalculatePermissions();
    }
}
