package br.com.wally.eventos;

import br.com.wally.utils.ItemManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import javax.swing.text.html.HTML;

public class PlayerListener implements Listener {

    private TagManager tagManager;
    private ItemManager itemManager;

    public PlayerListener(TagManager tagManager) {
        this.tagManager = tagManager;
        this.itemManager = new ItemManager();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        e.setJoinMessage(null);
        tagManager.setPlayerTag(p);

        itemManager.addItem(p, "§lCompasso", Material.COMPASS, 4);

        if(p.hasPermission("grupo.vip")) {
            p.setAllowFlight(true);
            p.setFlying(true);

            if(p.hasPermission("staff.protection")) {
                e.setJoinMessage(null);
            } else {
                String tag = tagManager.getPlayerTag(p);
                e.setJoinMessage(tag + p.getName() + " entrou no lobby.");
            }
        }
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent e) {
        if (e.getEntity() instanceof Player) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onFallDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
                e.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof org.bukkit.entity.Player) {
            event.setCancelled(true);
        }
    }
}
