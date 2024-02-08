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
}
