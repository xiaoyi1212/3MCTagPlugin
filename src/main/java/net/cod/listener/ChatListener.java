package net.cod.listener;

import net.cod.Manager;
import net.cod.PlayerData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class ChatListener implements Listener {
    @EventHandler
    public void onChat(PlayerChatEvent event){
        for(PlayerData data: Manager.getDatas()){
            if(data.getPlayer().getName().equals(event.getPlayer().getName())){
                event.setFormat(data.message());
                return;
            }
        }
    }
}
