package dev.thebjoredcraft.nationcore.region;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public enum Regions {
    FIRE(MiniMessage.miniMessage().deserialize(""), new Location(Bukkit.getWorld("world"), 2691, -64, -588), new Location(Bukkit.getWorld("world"), 2192, 319, -1087)),
    WATER(MiniMessage.miniMessage().deserialize(""), new Location(Bukkit.getWorld("world"), 1190, -64, -2089), new Location(Bukkit.getWorld("world"), 691, 319, -2588));
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
