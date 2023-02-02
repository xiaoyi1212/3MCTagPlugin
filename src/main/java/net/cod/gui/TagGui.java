package net.cod.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class TagGui implements BasicGUI{
    public static ItemStack connect,next,nul;
    static ItemMeta con_meta,next_meta;
    static {
        connect = new ItemStack(Material.DIAMOND_AXE);
        next = new ItemStack(Material.DIAMOND_SWORD);
        nul = new ItemStack(Material.STAINED_GLASS_PANE);

        con_meta = connect.getItemMeta();
        con_meta.setDisplayName(ChatColor.GOLD+"Back[上一页]");
        con_meta.addEnchant(Enchantment.ARROW_FIRE,1,false);
        next_meta.setLore(new ArrayList<>());
        connect.setItemMeta(con_meta);

        next_meta = next.getItemMeta();
        next_meta.setDisplayName(ChatColor.GREEN+"Next[下一页]");
        next_meta.addEnchant(Enchantment.ARROW_FIRE,1,false);
        next_meta.setLore(new ArrayList<>());
        next.setItemMeta(next_meta);
    }


    ItemStack[][] pane = {{nul,nul,nul,connect,nul,next,nul,nul,nul}};
    static String title;

    @Override
    public void open(Player player) {
        title = ChatColor.GREEN+""+ChatColor.BOLD+"["+ChatColor.AQUA+""+ChatColor.BOLD+""+"称号选择"+ChatColor.GREEN+""+ChatColor.BOLD+"]";
        Inventory shop = Bukkit.createInventory(null,6*9,title);
        for(int i = 0; i < pane.length; i++){
            for(int j = 0; j < pane[i].length; j++){
                shop.setItem((i+1)*j,pane[i][j]);
            }
        }
        player.openInventory(shop);
    }

    @Override
    public Inventory update(Player player,Inventory inventory, int page) {
        return inventory;
    }

    @Override
    public String getName() {
        return title;
    }
}
