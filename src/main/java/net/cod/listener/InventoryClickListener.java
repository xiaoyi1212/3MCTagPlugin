package net.cod.listener;

import net.cod.gui.ShopGUI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(event.getClickedInventory().getName().equals(ShopGUI.title)){

        }else event.setCancelled(false);
    }
}
