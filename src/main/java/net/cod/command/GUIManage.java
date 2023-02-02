package net.cod.command;

import net.cod.Manager;
import net.cod.gui.ShopGUI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GUIManage implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.isOp()){
                switch (args[0]){
                    case "help":player.sendMessage(ChatColor.DARK_AQUA+"=[TagPluginCommandList-3MC]=\n" + ChatColor.AQUA+
                            "/tagui help -Get command list.\n" +
                            "/tagui open <name> -Open gui\n" +
                            "/tagui list -List all loaded gui.");
                    break;
                    case "list":
                        player.sendMessage(ChatColor.YELLOW+"-gui list-\n" +
                                "shop\n" +
                                "manage");
                        break;
                    case "open": Manager.open(player,args[1]);break;

                    default: player.sendMessage(ChatColor.RED+"Unknown command, Type '/taggui help'.");break;
                }
            }else player.sendMessage(ChatColor.RED+"Sorry you can't use this command.");
        }else Bukkit.getLogger().warning("You can't use this command in console.");
        return false;
    }
}
