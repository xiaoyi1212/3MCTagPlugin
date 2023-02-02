package net.cod;

import net.cod.command.GUIManage;
import net.cod.command.PlayerManage;
import net.cod.listener.InventoryClickListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class CODPlugin extends JavaPlugin {

    public static ArrayList<String> prefix;
    public static CODPlugin plugin;

    public static String parser(String data, Player player){
        return data.replace("&", ""+ChatColor.COLOR_CHAR).replace("{epx}",""+player.getExp());
    }

    private void command(){
        getCommand("tagui").setExecutor(new GUIManage());
        getCommand("tagpl").setExecutor(new PlayerManage());

    }
    private void event(){
        getServer().getPluginManager().registerEvents(new InventoryClickListener(),this);
    }

    @Override
    public void onLoad() {
        saveDefaultConfig();
    }

    @Override
    public void onEnable() {
        try {
            plugin = this;
            prefix = (ArrayList<String>) getConfig().get("prefix");
        }catch (Exception e){
            Bukkit.getLogger().warning("Loaded config error, Disabling plugin...");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        command();
        event();
        Manager.init();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        saveConfig();
    }
}
