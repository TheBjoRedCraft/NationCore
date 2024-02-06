package dev.thebjoredcraft.nationcore.economy.shop;

import dev.thebjoredcraft.nationcore.economy.MoneyManager;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ShopHandler {
    public static void buy(Player buyer, ItemStack toBuy) {
        int prize = toBuy.getItemMeta().getCustomModelData();
        int amount = toBuy.getAmount();
        Material type = toBuy.getType();
        if (prize != -1) {
            if (buyer.getInventory().getContents().length < 36) {
                ItemStack stack = new ItemStack(type);

                stack.setAmount(amount);
                if (MoneyManager.getMoney(buyer) >= prize) {
                    MoneyManager.removeMoney(buyer, prize);
                    buyer.getInventory().addItem(stack);
                } else {
                    buyer.sendMessage(MiniMessage.miniMessage().deserialize("<bold>Du hast nicht genügend Geld!"));
                }
            } else {
                buyer.sendMessage(MiniMessage.miniMessage().deserialize("<bold>Du hast kein Platz im Inventar!"));
            }
        }else{
            buyer.sendMessage(MiniMessage.miniMessage().deserialize("<bold>Du kannst dieses Item nicht kaufen!"));
        }
    }
    public static void open(Player player){

    }
}
