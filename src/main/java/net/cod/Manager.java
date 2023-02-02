package net.cod;

import net.cod.gui.BasicGUI;
import net.cod.gui.ShopGUI;
import net.cod.gui.TagGui;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Manager {
    static ArrayList<BasicGUI> uis = new ArrayList<>();
    static ArrayList<PlayerData> datas = new ArrayList<>();

    public static ArrayList<PlayerData> getDatas() {
        return datas;
    }

    public static void init(){
        uis.add(new TagGui());
        uis.add(new ShopGUI());
    }

    public static void open(Player player,String name){
        switch (name){
            case "shop":
                for(BasicGUI ui:uis)if(ui instanceof ShopGUI) {
                    ui.open(player);
                    break;
                }
                break;
            case "tag":
                for(BasicGUI ui:uis)if(ui instanceof TagGui) {
                    ui.open(player);
                    break;
                }
                break;
        }
    }
}
