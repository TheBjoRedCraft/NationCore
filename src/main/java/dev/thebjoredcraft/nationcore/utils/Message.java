package dev.thebjoredcraft.nationcore.utils;

import dev.thebjoredcraft.nationcore.NationCore;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Message {
    public static void send(Audience audience, String message){
        File messageFile = new File(NationCore.getInstance().getDataFolder(), "messages.yml");

        if(message.startsWith("msg.")){
            if (!messageFile.exists()) {
                messageFile.getParentFile().mkdirs();

                NationCore.getInstance().saveResource("messages.yml", false);
            }
            YamlConfiguration messageConfig = YamlConfiguration.loadConfiguration(messageFile);

            message.replace("msg.", "");
            audience.sendMessage(MiniMessage.miniMessage().deserialize(messageConfig.get(message).toString()));
        }else{
            audience.sendMessage(MiniMessage.miniMessage().deserialize(message));
        }
    }
}
