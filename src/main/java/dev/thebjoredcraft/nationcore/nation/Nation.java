package dev.thebjoredcraft.nationcore.nation;

import dev.thebjoredcraft.nationcore.region.Regions;

public enum Nation {
    DESERT("<color:#f9ff82>Wüste", Regions.FIRE, "fire"),
    MOUNTAINS("<color:#b5e2ff>Berge", Regions.WATER, "water"),
    NOTHING("<red>Keine Region", Regions.SPAWN, "nothing");

    public final String displayName;
    public final Regions region;
    public final String name;
    Nation(String displayName, Regions region, String name){
        this.displayName = displayName;
        this.region = region;
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public Regions getRegion() {
        return region;
    }

    public String getName() {
        return name;
    }
}
