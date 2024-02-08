package dev.thebjoredcraft.nationcore.region;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public enum Regions {
    FIRE(MiniMessage.miniMessage().deserialize(""), new Location(Bukkit.getWorld("world"), 2691, -64, -588), new Location(Bukkit.getWorld("world"), 2192, 319, -1087)),
    SPAWN(MiniMessage.miniMessage().deserialize(""), new Location(Bukkit.getWorld("world"), 1800, -64, -1499), new Location(Bukkit.getWorld("world"), 1638, 319, -1684)),
    WATER(MiniMessage.miniMessage().deserialize(""), new Location(Bukkit.getWorld("world"), 2691, -64, -588), new Location(Bukkit.getWorld("world"), 2192, 319, -1087));
    private final Component name;
    private final Location loc1;
    private final Location loc2;
    Regions(Component name, Location loc1, Location loc2){
        this.loc1 = loc1;
        this.loc2 = loc2;
        this.name = name;
    }

    public Location getLoc2() {
        return loc2;
    }

    public Location getLoc1() {
        return loc1;
    }

    public Component getName() {
        return name;
    }
}
