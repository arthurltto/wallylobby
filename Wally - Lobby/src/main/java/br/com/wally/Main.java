package br.com.wally;

import br.com.wally.eventos.PlayerListener;
import br.com.wally.eventos.TagManager;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Main extends JavaPlugin {

    @Override
    public void onEnable(){
        Eventos();
        Comandos();
        CommandSender cs = Bukkit.getConsoleSender();
        cs.sendMessage(" ");
        cs.sendMessage(" §eWally §aAtivado");
        cs.sendMessage(" ");
        cs.sendMessage(" §fVersão §d1.0");
        cs.sendMessage(" §fLinguagem: §dPT-BR");
        cs.sendMessage(" §fAutor: §d@znltto");
        cs.sendMessage(" ");
    }

    @Override
    public void onDisable(){}

    public void Eventos(){
        TagManager tagManager = new TagManager();
        Bukkit.getPluginManager().registerEvents(new PlayerListener(tagManager), this);;

        new BukkitRunnable() {
            @Override
            public void run() {
                for (World world : Bukkit.getWorlds()) {
                    if (world.hasStorm()) {
                        world.setStorm(false);
                    }
                    world.setWeatherDuration(0);
                }
            }
        }.runTaskTimer(this, 0L, 20L);
    }

    public void Comandos(){}
}