package dev.thebjoredcraft.nationcore;

import dev.thebjoredcraft.nationcore.event.EventManager;
import dev.thebjoredcraft.nationcore.nation.NationAlertToggleCommand;
import dev.thebjoredcraft.nationcore.nation.PlayerNationManager;
import dev.thebjoredcraft.nationcore.nation.StaffNationCommand;
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

        PlayerNationManager.connectToDatabase();
        PlayerNationManager.createTables();

        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public static void setPermission(Player player, String permission, Boolean arg) {
        PermissionAttachment attachment = player.addAttachment(NationCore.getInstance());
        attachment.setPermission(permission, arg);

        player.recalculatePermissions();
    }
}
