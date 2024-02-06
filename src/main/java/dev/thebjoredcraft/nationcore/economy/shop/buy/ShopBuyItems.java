package dev.thebjoredcraft.nationcore.economy.shop.buy;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.potion.Potion;

import java.util.ArrayList;

public class ShopBuyItems {
    public static ItemStack getWoodItem(){
        ItemStack stack = new ItemStack(Material.OAK_LOG);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Holz"));
        meta.lore(lore);
        meta.setCustomModelData(-1);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getStoneItem(){
        ItemStack stack = new ItemStack(Material.COBBLESTONE);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Stein"));
        meta.lore(lore);
        meta.setCustomModelData(-1);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getDyeItem(){
        ItemStack stack = new ItemStack(Material.WHITE_DYE);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Farbstoff"));
        meta.lore(lore);
        meta.setCustomModelData(-1);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getOreItem(){
        ItemStack stack = new ItemStack(Material.DIAMOND);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Erze"));
        meta.lore(lore);
        meta.setCustomModelData(-1);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getGrassItem(){
        ItemStack stack = new ItemStack(Material.GRASS_BLOCK);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Natur Blöcke"));
        meta.lore(lore);
        meta.setCustomModelData(-1);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getDropsItem(){
        ItemStack stack = new ItemStack(Material.GUNPOWDER);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Monster Drops"));
        meta.lore(lore);
        meta.setCustomModelData(-1);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getSpecialItem(){
        ItemStack stack = new ItemStack(Material.STRUCTURE_BLOCK);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Besondere Items"));
        meta.lore(lore);
        meta.setCustomModelData(-1);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getOak(){
        ItemStack stack = new ItemStack(Material.OAK_LOG);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 10"));
        meta.lore(lore);
        meta.setCustomModelData(10);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getSpruce(){
        ItemStack stack = new ItemStack(Material.SPRUCE_LOG);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 10"));
        meta.lore(lore);
        meta.setCustomModelData(10);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getBirch(){
        ItemStack stack = new ItemStack(Material.BIRCH_LOG);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 10"));
        meta.lore(lore);
        meta.setCustomModelData(10);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getJungle(){
        ItemStack stack = new ItemStack(Material.JUNGLE_LOG);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 20"));
        meta.lore(lore);
        meta.setCustomModelData(20);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getAcacia(){
        ItemStack stack = new ItemStack(Material.ACACIA_LOG);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 20"));
        meta.lore(lore);
        meta.setCustomModelData(20);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getDarkOak(){
        ItemStack stack = new ItemStack(Material.DARK_OAK_LOG);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 20"));
        meta.lore(lore);
        meta.setCustomModelData(20);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getMangrove(){
        ItemStack stack = new ItemStack(Material.MANGROVE_LOG);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 25"));
        meta.lore(lore);
        meta.setCustomModelData(25);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getCherry(){
        ItemStack stack = new ItemStack(Material.CHERRY_LOG);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 25"));
        meta.lore(lore);
        meta.setCustomModelData(25);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getStone(){
        ItemStack stack = new ItemStack(Material.STONE);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 15"));
        meta.lore(lore);
        meta.setCustomModelData(15);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getCobble(){
        ItemStack stack = new ItemStack(Material.COBBLESTONE);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 10"));
        meta.lore(lore);
        meta.setCustomModelData(10);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getMossyCobble(){
        ItemStack stack = new ItemStack(Material.MOSSY_COBBLESTONE);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 25"));
        meta.lore(lore);
        meta.setCustomModelData(25);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getStoneBricks(){
        ItemStack stack = new ItemStack(Material.STONE_BRICKS);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 20"));
        meta.lore(lore);
        meta.setCustomModelData(20);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getSmoothStone(){
        ItemStack stack = new ItemStack(Material.SMOOTH_STONE);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 20"));
        meta.lore(lore);
        meta.setCustomModelData(20);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getDripStoneBlock(){
        ItemStack stack = new ItemStack(Material.DRIPSTONE_BLOCK);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 25"));
        meta.lore(lore);
        meta.setCustomModelData(25);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getDripStonePointed(){
        ItemStack stack = new ItemStack(Material.POINTED_DRIPSTONE);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 20"));
        meta.lore(lore);
        meta.setCustomModelData(20);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getBlackStone(){
        ItemStack stack = new ItemStack(Material.BLACKSTONE);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 10"));
        meta.lore(lore);
        meta.setCustomModelData(10);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getGlowStone(){
        ItemStack stack = new ItemStack(Material.GLOWSTONE);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 20"));
        meta.lore(lore);
        meta.setCustomModelData(20);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getEndStone(){
        ItemStack stack = new ItemStack(Material.END_STONE);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 25"));
        meta.lore(lore);
        meta.setCustomModelData(25);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getTerracotta(){
        ItemStack stack = new ItemStack(Material.TERRACOTTA);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 15"));
        meta.lore(lore);
        meta.setCustomModelData(15);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getEmerald(){
        ItemStack stack = new ItemStack(Material.EMERALD);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 50"));
        meta.lore(lore);
        meta.setCustomModelData(50);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getDiamond(){
        ItemStack stack = new ItemStack(Material.DIAMOND);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 100"));
        meta.lore(lore);
        meta.setCustomModelData(100);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getLapisLazuli(){
        ItemStack stack = new ItemStack(Material.LAPIS_LAZULI);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 35"));
        meta.lore(lore);
        meta.setCustomModelData(35);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getAmethyst(){
        ItemStack stack = new ItemStack(Material.AMETHYST_SHARD);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 15"));
        meta.lore(lore);
        meta.setCustomModelData(15);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getGold(){
        ItemStack stack = new ItemStack(Material.GOLD_INGOT);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 50"));
        meta.lore(lore);
        meta.setCustomModelData(50);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getCopper(){
        ItemStack stack = new ItemStack(Material.COPPER_INGOT);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 30"));
        meta.lore(lore);
        meta.setCustomModelData(30);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getRedstone(){
        ItemStack stack = new ItemStack(Material.REDSTONE);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 25"));
        meta.lore(lore);
        meta.setCustomModelData(25);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getEnderPearl(){
        ItemStack stack = new ItemStack(Material.ENDER_PEARL);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 50"));
        meta.lore(lore);
        meta.setCustomModelData(50);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getHeart(){
        ItemStack stack = new ItemStack(Material.HEART_OF_THE_SEA);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 150"));
        meta.lore(lore);
        meta.setCustomModelData(150);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getEchoShard(){
        ItemStack stack = new ItemStack(Material.ECHO_SHARD);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 45"));
        meta.lore(lore);
        meta.setCustomModelData(45);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getDiscFragment(){
        ItemStack stack = new ItemStack(Material.DISC_FRAGMENT_5);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 60"));
        meta.lore(lore);
        meta.setCustomModelData(60);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getAncientDebris(){
        ItemStack stack = new ItemStack(Material.ANCIENT_DEBRIS);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 100"));
        meta.lore(lore);
        meta.setCustomModelData(100);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getIron(){
        ItemStack stack = new ItemStack(Material.IRON_INGOT);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 40"));
        meta.lore(lore);
        meta.setCustomModelData(40);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getQuartz(){
        ItemStack stack = new ItemStack(Material.QUARTZ);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 30"));
        meta.lore(lore);
        meta.setCustomModelData(30);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getRed(){
        ItemStack stack = new ItemStack(Material.RED_DYE);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 15"));
        meta.lore(lore);
        meta.setCustomModelData(15);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getOrange(){
        ItemStack stack = new ItemStack(Material.ORANGE_DYE);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 15"));
        meta.lore(lore);
        meta.setCustomModelData(15);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getYellow(){
        ItemStack stack = new ItemStack(Material.YELLOW_DYE);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 15"));
        meta.lore(lore);
        meta.setCustomModelData(15);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getLime(){
        ItemStack stack = new ItemStack(Material.LIME_DYE);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 15"));
        meta.lore(lore);
        meta.setCustomModelData(15);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getGreen(){
        ItemStack stack = new ItemStack(Material.GREEN_DYE);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 15"));
        meta.lore(lore);
        meta.setCustomModelData(15);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getCyan(){
        ItemStack stack = new ItemStack(Material.CYAN_DYE);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 15"));
        meta.lore(lore);
        meta.setCustomModelData(15);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getLight_Blue(){
        ItemStack stack = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 15"));
        meta.lore(lore);
        meta.setCustomModelData(15);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getBlue(){
        ItemStack stack = new ItemStack(Material.BLUE_DYE);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 15"));
        meta.lore(lore);
        meta.setCustomModelData(15);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getPurple(){
        ItemStack stack = new ItemStack(Material.PURPLE_DYE);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 15"));
        meta.lore(lore);
        meta.setCustomModelData(15);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getMagenta(){
        ItemStack stack = new ItemStack(Material.MAGENTA_DYE);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 15"));
        meta.lore(lore);
        meta.setCustomModelData(15);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getPink(){
        ItemStack stack = new ItemStack(Material.PINK_DYE);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 15"));
        meta.lore(lore);
        meta.setCustomModelData(15);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getWhite(){
        ItemStack stack = new ItemStack(Material.WHITE_DYE);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 15"));
        meta.lore(lore);
        meta.setCustomModelData(15);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getLight_Gray(){
        ItemStack stack = new ItemStack(Material.LIGHT_GRAY_DYE);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 15"));
        meta.lore(lore);
        meta.setCustomModelData(15);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getBlack(){
        ItemStack stack = new ItemStack(Material.BLACK_DYE);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 15"));
        meta.lore(lore);
        meta.setCustomModelData(15);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getGrass(){
        ItemStack stack = new ItemStack(Material.GRASS_BLOCK);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 2"));
        meta.lore(lore);
        meta.setCustomModelData(2);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getDirt(){
        ItemStack stack = new ItemStack(Material.DIRT);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 1"));
        meta.lore(lore);
        meta.setCustomModelData(1);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getCourseDirt(){
        ItemStack stack = new ItemStack(Material.COARSE_DIRT);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 10"));
        meta.lore(lore);
        meta.setCustomModelData(10);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getRootedDirt(){
        ItemStack stack = new ItemStack(Material.ROOTED_DIRT);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 10"));
        meta.lore(lore);
        meta.setCustomModelData(10);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getSandStone(){
        ItemStack stack = new ItemStack(Material.SANDSTONE);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 5"));
        meta.lore(lore);
        meta.setCustomModelData(5);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getSand(){
        ItemStack stack = new ItemStack(Material.SAND);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 5"));
        meta.lore(lore);
        meta.setCustomModelData(5);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getSusSand(){
        ItemStack stack = new ItemStack(Material.SUSPICIOUS_SAND);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 100"));
        meta.lore(lore);
        meta.setCustomModelData(100);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getRedSandStone(){
        ItemStack stack = new ItemStack(Material.RED_SANDSTONE);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 10"));
        meta.lore(lore);
        meta.setCustomModelData(10);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getRedSand(){
        ItemStack stack = new ItemStack(Material.RED_SAND);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 5"));
        meta.lore(lore);
        meta.setCustomModelData(5);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getSoulSand(){
        ItemStack stack = new ItemStack(Material.SOUL_SAND);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 30"));
        meta.lore(lore);
        meta.setCustomModelData(30);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getSpyGlass(){
        ItemStack stack = new ItemStack(Material.SPYGLASS);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 50"));
        meta.lore(lore);
        meta.setCustomModelData(50);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getBottle(){
        ItemStack stack = new ItemStack(Material.GLASS_BOTTLE);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 10"));
        meta.lore(lore);
        meta.setCustomModelData(10);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getGlass(){
        ItemStack stack = new ItemStack(Material.GLASS);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 10"));
        meta.lore(lore);
        meta.setCustomModelData(10);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getGravel(){
        ItemStack stack = new ItemStack(Material.GRAVEL);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 5"));
        meta.lore(lore);
        meta.setCustomModelData(5);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getBone(){
        ItemStack stack = new ItemStack(Material.BONE);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 10"));
        meta.lore(lore);
        meta.setCustomModelData(10);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getString(){
        ItemStack stack = new ItemStack(Material.STRING);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 5"));
        meta.lore(lore);
        meta.setCustomModelData(5);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getFeather(){
        ItemStack stack = new ItemStack(Material.FEATHER);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 5"));
        meta.lore(lore);
        meta.setCustomModelData(5);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getEgg(){
        ItemStack stack = new ItemStack(Material.EGG);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 5"));
        meta.lore(lore);
        meta.setCustomModelData(5);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getLeather(){
        ItemStack stack = new ItemStack(Material.LEATHER);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 10"));
        meta.lore(lore);
        meta.setCustomModelData(10);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getRabbitHide(){
        ItemStack stack = new ItemStack(Material.RABBIT_HIDE);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 10"));
        meta.lore(lore);
        meta.setCustomModelData(10);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getHoneyComb(){
        ItemStack stack = new ItemStack(Material.HONEYCOMB);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 5"));
        meta.lore(lore);
        meta.setCustomModelData(5);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getBlaze(){
        ItemStack stack = new ItemStack(Material.BLAZE_ROD);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 25"));
        meta.lore(lore);
        meta.setCustomModelData(25);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getShulker(){
        ItemStack stack = new ItemStack(Material.SHULKER_SHELL);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 100"));
        meta.lore(lore);
        meta.setCustomModelData(100);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getGunpowder(){
        ItemStack stack = new ItemStack(Material.GUNPOWDER);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 10"));
        meta.lore(lore);
        meta.setCustomModelData(10);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getCookedBeef(){
        ItemStack stack = new ItemStack(Material.COOKED_BEEF);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 20"));
        meta.lore(lore);
        meta.setCustomModelData(20);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getPotato(){
        ItemStack stack = new ItemStack(Material.BAKED_POTATO);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 20"));
        meta.lore(lore);
        meta.setCustomModelData(20);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getBread(){
        ItemStack stack = new ItemStack(Material.BREAD);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 10"));
        meta.lore(lore);
        meta.setCustomModelData(10);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getChicken(){
        ItemStack stack = new ItemStack(Material.COOKED_CHICKEN);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 20"));
        meta.lore(lore);
        meta.setCustomModelData(20);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getTurtleHelmet(){
        ItemStack stack = new ItemStack(Material.TURTLE_HELMET);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 250"));
        meta.lore(lore);
        meta.setCustomModelData(250);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getTrident(){
        ItemStack stack = new ItemStack(Material.TRIDENT);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 200"));
        meta.lore(lore);
        meta.setCustomModelData(200);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getShield(){
        ItemStack stack = new ItemStack(Material.SHIELD);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 20"));
        meta.lore(lore);
        meta.setCustomModelData(20);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getCrossBow(){
        ItemStack stack = new ItemStack(Material.CROSSBOW);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 20"));
        meta.lore(lore);
        meta.setCustomModelData(20);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getBow(){
        ItemStack stack = new ItemStack(Material.BOW);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 20"));
        meta.lore(lore);
        meta.setCustomModelData(20);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getTotem(){
        ItemStack stack = new ItemStack(Material.TOTEM_OF_UNDYING);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 1000"));
        meta.lore(lore);
        meta.setCustomModelData(1000);

        stack.setItemMeta(meta);
        return stack;
    }

    public static ItemStack getBed(){
        ItemStack stack = new ItemStack(Material.WHITE_BED);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 20"));
        meta.lore(lore);
        meta.setCustomModelData(20);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getBeacon(){
        ItemStack stack = new ItemStack(Material.BEACON);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 5000"));
        meta.lore(lore);
        meta.setCustomModelData(5000);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getEndPortalFrame(){
        ItemStack stack = new ItemStack(Material.END_PORTAL_FRAME);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 2500"));
        meta.lore(lore);
        meta.setCustomModelData(2500);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getDragonHead() {
        ItemStack stack = new ItemStack(Material.DRAGON_HEAD);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 2000"));
        meta.lore(lore);
        meta.setCustomModelData(2000);

        stack.setItemMeta(meta);
        return stack;
    }
    public static ItemStack getFiller(){
        ItemStack stack = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Shop"));
        meta.lore(lore);
        meta.setCustomModelData(-1);

        stack.setItemMeta(meta);
        return stack;
    }
}
