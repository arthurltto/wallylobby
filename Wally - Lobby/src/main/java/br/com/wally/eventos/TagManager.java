package br.com.wally.eventos;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class TagManager {

    private JavaPlugin plugin;

    public void setPlayerTag(Player p) {
        String tag = getPlayerTag(p);
        setTagOnPlayer(p, tag);
    }

    public String getPlayerTag(Player p) {
        String tag = "";

        if (p.hasPermission("grupo.admin")) {
            tag = "§c§lADMIN §f";
        } else if (p.hasPermission("grupo.cod")) {
            tag = "§c§lCOORD §f";
        } else if (p.hasPermission("grupo.mod")) {
            tag = "§c§lMOD §f";
        } else if (p.hasPermission("grupo.ajd")) {
            tag = "§c§lAJD §f";
        } else if (p.hasPermission("grupo.mvp")) {
            tag = "§c§lMVP §f";
        } else if (p.hasPermission("grupo.vip+")) {
            tag = "§c§lVIP+ §f";
        } else if (p.hasPermission("grupo.vip")) {
            tag = "§c§lVIP §f";
        } else {
            tag = "";
        }

        return tag;
    }

    private void setTagOnPlayer(Player p, String tag) {
        p.setDisplayName(tag + p.getName());
        p.setPlayerListName(tag + p.getName());
    }
}
