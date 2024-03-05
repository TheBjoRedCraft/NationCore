package dev.thebjoredcraft.nationcore.nation;

import dev.thebjoredcraft.nationcore.region.Regions;

public enum Nation {
    DESERT("<color:#f9ff82>Wüste", Regions.FIRE),
    MOUNTAINS("<color:#b5e2ff>Berge", Regions.WATER),
    NOTHING("<red>Keine Region", Regions.SPAWN);

    public final String displayName;
    public final Regions region;
    Nation(String displayName, Regions region){
        this.displayName = displayName;
        this.region = region;
    }

    public String getDisplayName() {
        return displayName;
    }

    public Regions getRegion() {
        return region;
    }
}
