package dev.thebjoredcraft.nationcore.economy.shop;

import dev.thebjoredcraft.nationcore.economy.MoneyManager;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.sound.Sound;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;//
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ShopHandler {
    public static String traderTag = "45865873473903265772360867548067854";
    public static Boolean isVisible;
    public static void buy(Player buyer, ItemStack toBuy) {
        int prize = toBuy.getItemMeta().getCustomModelData();
        int amount = toBuy.getAmount();
        Material type = toBuy.getType();
        Sound sound = Sound.sound(Key.key("block.note_block.bit"), Sound.Source.MASTER, 10f, 0f);
        if (prize != -1) {
            try{
                ItemStack stack = new ItemStack(type);

                stack.setAmount(amount);
                if(MoneyManager.getMoney(buyer) != -1) {
                    if (MoneyManager.getMoney(buyer) >= prize) {
                        MoneyManager.removeMoney(buyer, prize);

                        buyer.playSound(sound);
                        buyer.getInventory().addItem(stack);
                    } else {
                        buyer.sendMessage(MiniMessage.miniMessage().deserialize("<bold>Du hast nicht genügend Geld!"));
                    }
                }else{
                    buyer.playSound(sound);
                    buyer.getInventory().addItem(stack);
                }
            }catch (NullPointerException e){
                buyer.sendMessage(MiniMessage.miniMessage().deserialize("<bold>Du hast kein Platz im Inventar!"));
            }
        }else{
            buyer.sendMessage(MiniMessage.miniMessage().deserialize("<bold>Du kannst dieses Item nicht kaufen!"));
        }
    }
    public static void summon(Location loc){
        Entity trader = loc.getWorld().spawnEntity(loc, EntityType.VILLAGER);

        trader.setCustomNameVisible(true);
        trader.customName(MiniMessage.miniMessage().deserialize("<bold>Shop"));

        trader.setInvulnerable(true);
        trader.setSilent(true);
        trader.setGravity(false);
        trader.addScoreboardTag(traderTag);

        LivingEntity livingEntity = (LivingEntity) trader;
        livingEntity.setAI(false);
    }
    public static void hide() {
        isVisible = false;
        for(Entity entity : Bukkit.getWorld("map").getEntities()) {
            if(entity instanceof Villager villager) {
                if(villager.getScoreboardTags().contains(traderTag)){
                    villager.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 255, false, false));
                }
            }
        }
    }
    public static void show(){
        isVisible = true;
        for(Entity entity : Bukkit.getWorld("map").getEntities()) {
            if(entity instanceof Villager villager) {
                if(villager.getScoreboardTags().contains(traderTag)){
                    if(villager.getPotionEffect(PotionEffectType.INVISIBILITY) == null) {
                        villager.removePotionEffect(PotionEffectType.INVISIBILITY);
                    }
                }
            }
        }
    }
}
