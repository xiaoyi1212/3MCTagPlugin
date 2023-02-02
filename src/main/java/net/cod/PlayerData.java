package net.cod;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class PlayerData {
    Player player;
    ArrayList<String> prefix;
    ArrayList<String> pring;

    public PlayerData(Player player){
        this.player = player;
        prefix = new ArrayList<>();
        pring = new ArrayList<>();
    }

    public Player getPlayer() {
        return player;
    }

    public String message(){
        StringBuilder sb = new StringBuilder();
        for(String str:pring)sb.append(str);
        String info = sb.toString()+"&b<%player%> &p";
        return CODPlugin.parser(info,player);
    }
}
