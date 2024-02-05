package dev.thebjoredcraft.nationcore.region;

import org.bukkit.Location;

public class Region {
    public static boolean isInRegion(Location location, Regions regions) {
        double minX = Math.min(regions.getLoc1().getX(), regions.getLoc2().getX());
        double minY = Math.min(regions.getLoc1().getY(), regions.getLoc2().getY());
        double minZ = Math.min(regions.getLoc1().getZ(), regions.getLoc2().getZ());
        double maxX = Math.max(regions.getLoc1().getX(), regions.getLoc2().getX());
        double maxY = Math.max(regions.getLoc1().getY(), regions.getLoc2().getY());
        double maxZ = Math.max(regions.getLoc1().getZ(), regions.getLoc2().getZ());

        return location.getX() >= minX && location.getX() <= maxX && location.getY() >= minY && location.getY() <= maxY && location.getZ() >= minZ && location.getZ() <= maxZ;
    }
}
