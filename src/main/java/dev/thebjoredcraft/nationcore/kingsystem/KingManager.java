package dev.thebjoredcraft.nationcore.kingsystem;

import dev.thebjoredcraft.nationcore.NationCore;
import dev.thebjoredcraft.nationcore.nation.Nation;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KingManager {
    public static Component name = MiniMessage.miniMessage().deserialize("<gold>Königs-Krone");
    public static void giveCrown(Player player, Player target){
        ItemStack is = new ItemStack(Material.CARVED_PUMPKIN);
        ItemMeta im = is.getItemMeta();

        im.displayName(name);
        im.setCustomModelData(1);
        im.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
        im.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 4, false);
        im.addEnchant(Enchantment.PROTECTION_FIRE, 4, false);
        im.addEnchant(Enchantment.PROTECTION_PROJECTILE, 4, false);

        is.setItemMeta(im);

        if(target.getInventory().getHelmet() == null) {
            target.getInventory().setHelmet(is);
        }else{
            try {
                target.getInventory().addItem(target.getInventory().getHelmet());
            }catch (IllegalArgumentException e){
                target.getWorld().dropItemNaturally(target.getLocation(), target.getInventory().getHelmet());
                if(target.getInventory().getHelmet() == null) {
                    target.getInventory().setHelmet(is);
                }else{
                    player.sendMessage(MiniMessage.miniMessage().deserialize("<red>Error during setting helmet (crown) for player " + target.getName()));
                }
            }
        }
    }
    public static void setKing(Player player, Player target, Nation nation, Boolean booLean){
        NationCore.setPermission(target, "nations.king", booLean);
        NationCore.setPermission(target, "nations.region." + nation.getName() + ".king", booLean);
    }
}
