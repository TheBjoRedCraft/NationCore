package dev.thebjoredcraft.nationcore.economy.shop.buy;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.awt.*;
import java.util.ArrayList;

public class ShopBuyItems {
    public static ItemStack getOakLog(){
        ItemStack stack = new ItemStack(Material.OAK_LOG);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(MiniMessage.miniMessage().deserialize("<bold>Preis: 10"));
        meta.lore(lore);

        stack.setItemMeta(meta);
        return stack;
    }
}
