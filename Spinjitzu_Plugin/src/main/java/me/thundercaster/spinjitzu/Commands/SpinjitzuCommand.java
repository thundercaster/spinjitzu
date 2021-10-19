package me.thundercaster.spinjitzu.Commands;

import me.thundercaster.spinjitzu.Spinjitzu;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SpinjitzuCommand implements CommandExecutor, Listener {
    public List<Player> plist = new ArrayList<>();

    Spinjitzu plugin;
    public SpinjitzuCommand(Spinjitzu plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender == null){
            return false;
        }
        if (sender instanceof Player p){
            if(args.length==1){
                if (args[0].equalsIgnoreCase("on")) {
                    plist.add(p);
                    }
                if (args[0].equalsIgnoreCase("off")){
                    plist.remove(p);
                    }
                else {
                    p.sendMessage(ChatColor.RED + "please add on or off after the command");
                    }
                }
            else {
                p.sendMessage(ChatColor.RED + "please add on or off after the command");
                }
            }
        return true;
    }

    @EventHandler
    public void Move(PlayerMoveEvent e){
        Player p = e.getPlayer();
        Location loc = p.getLocation();
        float k = (float) loc.getY();
        while (plist.contains(p)){
            for (int i = 0; i<6; i++){
                float y = (float) (0.5*i);
                float r = (float) (0.5*i);
                circle(r,y,loc,p);

            }
        }



    }



    public void circle(float r, double y, Location l, Player p){
        final double[] a = {0};
        new BukkitRunnable(){
            @Override
            public void run() {
                double x = r*Math.cos(a[0]);
                double z = r*Math.sin(a[0]);
                p.spawnParticle(Particle.DRIP_LAVA, l.add(x,y,z), 50);
                a[0] = a[0] + 0.1;
            }
        }.runTaskTimerAsynchronously(Spinjitzu.getPlugin(), 0, 1);
    }
}

