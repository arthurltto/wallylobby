package br.com.wally.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemManager {
    public void addItem(Player jogador, String nomeItem, Material tipoItem, int local) {
        ItemStack item = new ItemStack(tipoItem);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(nomeItem);
            item.setItemMeta(meta);
        }
        if (jogador.getInventory().firstEmpty() == -1 || local >= 0 && local < jogador.getInventory().getSize()) {
            jogador.getInventory().setItem(local, item);
        } else {
            jogador.getInventory().addItem(item);
        }
    }
}