package net.cod.gui;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public interface BasicGUI {
    public void open(Player player);
    public Inventory update(Player player, Inventory inventory, int page);
    public String getName();
}
