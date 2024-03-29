package dev.thebjoredcraft.nationcore.region;

import org.bukkit.Location;

public class Region {
    public static boolean isInRegion(Location location, Regions region) {
        double minX = Math.min(region.getLoc1().getX(), region.getLoc2().getX());
        double minY = Math.min(region.getLoc1().getY(), region.getLoc2().getY());
        double minZ = Math.min(region.getLoc1().getZ(), region.getLoc2().getZ());
        double maxX = Math.max(region.getLoc1().getX(), region.getLoc2().getX());
        double maxY = Math.max(region.getLoc1().getY(), region.getLoc2().getY());
        double maxZ = Math.max(region.getLoc1().getZ(), region.getLoc2().getZ());

        return location.getX() >= minX && location.getX() <= maxX && location.getY() >= minY && location.getY() <= maxY && location.getZ() >= minZ && location.getZ() <= maxZ;
    }
    private boolean isNearBorder(Location location) {
        return !isInRegion(location, Regions.MAP) && isInBorderRegion(location);
    }

    private boolean isInBorderRegion(Location location) {
        double minX = Math.min(Regions.MAP.getLoc1().getX(), Regions.MAP.getLoc2().getX()) - (double) 5;
        double minY = Math.min(Regions.MAP.getLoc1().getY(), Regions.MAP.getLoc2().getY()) - (double) 5;
        double minZ = Math.min(Regions.MAP.getLoc1().getZ(), Regions.MAP.getLoc2().getZ()) - (double) 5;
        double maxX = Math.max(Regions.MAP.getLoc1().getX(), Regions.MAP.getLoc2().getX()) + (double) 5;
        double maxY = Math.max(Regions.MAP.getLoc1().getY(), Regions.MAP.getLoc2().getY()) + (double) 5;
        double maxZ = Math.max(Regions.MAP.getLoc1().getZ(), Regions.MAP.getLoc2().getZ()) + (double) 5;

        return location.getX() >= minX && location.getX() <= maxX && location.getY() >= minY && location.getY() <= maxY && location.getZ() >= minZ && location.getZ() <= maxZ;
    }
}
