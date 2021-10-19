package me.thundercaster.spinjitzu;

import me.thundercaster.spinjitzu.Commands.SpinjitzuCommand;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class Spinjitzu extends JavaPlugin {
    private static Spinjitzu plugin;
    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

        getCommand("spinjitzu").setExecutor(new SpinjitzuCommand(this));


    }

    public static Spinjitzu getPlugin() {
        return plugin;
    }
}
