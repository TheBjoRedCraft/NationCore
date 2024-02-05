package dev.thebjoredcraft.nationcore.economy;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MoneyItem extends ItemStack {
    Component name = MiniMessage.miniMessage().deserialize("<gold>Money");
    public MoneyItem(int count){
        ItemMeta meta = this.getItemMeta();
        meta.setCustomModelData(1);
        meta.displayName(name);

        this.setAmount(count);
        this.setType(Material.PAPER);
        this.setItemMeta(meta);
    }
}
