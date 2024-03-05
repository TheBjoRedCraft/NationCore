package dev.thebjoredcraft.nationcore.region;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public enum Regions {
//    FIRE(MiniMessage.miniMessage().deserialize(""), new Location(Bukkit.getWorld("world"), 2691, -64, -588), new Location(Bukkit.getWorld("world"), 2192, 319, -1087)),
//    SPAWN(MiniMessage.miniMessage().deserialize(""), new Location(Bukkit.getWorld("world"), 1800, -64, -1499), new Location(Bukkit.getWorld("world"), 1638, 319, -1684)),
//    WATER(MiniMessage.miniMessage().deserialize(""), new Location(Bukkit.getWorld("world"), 2691, -64, -588), new Location(Bukkit.getWorld("world"), 2192, 319, -1087)),
//    EVENT(MiniMessage.miniMessage().deserialize(""), new Location(Bukkit.getWorld("world"), 870, -64, -761), new Location(Bukkit.getWorld("world"), 1090, 319, -985));

    FIRE("<color:#f9ff82>Wüsten-Region<reset>", new Location(Bukkit.getWorld("map"), -360, -64, 510), new Location(Bukkit.getWorld("map"), -1023, 319, -511)),
    SPAWN("<color:#3b92d1>Spawn<reset>", new Location(Bukkit.getWorld("map"), -116, -64, -291), new Location(Bukkit.getWorld("map"), 110, 319, 298)),
    SPAWN_REGION("<color:#40d1db>Spawn-Region<reset>", new Location(Bukkit.getWorld("map"), 437, -64, 510), new Location(Bukkit.getWorld("map"), -359, 319, -511)),
    WATER("<color:#b5e2ff>Berg-Region", new Location(Bukkit.getWorld("map"), 1023, -64, -512), new Location(Bukkit.getWorld("map"), 439, 319, 510)),
    MAP("<red>Map", new Location(Bukkit.getWorld("map"), -1024, -64, 511), new Location(Bukkit.getWorld("map"), 1023, 319, -512));

    private final String name;
    private final Location loc1;
    private final Location loc2;
    Regions(String name, Location loc1, Location loc2){
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

    public String getName() {
        return name;
    }
}
