package Otaku.Skill;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitScheduler;

import Otaku.Main;

public class Rain
  implements Listener
{
  public static Otaku.Main plugin;
  
  public Rain(Otaku.Main main)
  {
    plugin = main;
  }
  
  @EventHandler
  public void b(EntityDamageByEntityEvent e)
  {
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Arrow))) {
      e.setDamage(7.0D);
    }
  }
  
  public static List<Player> hab = new ArrayList();
  
  @EventHandler
  public void a(PlayerInteractEntityEvent event)
  {
    if (!(event.getRightClicked() instanceof Player)) {
      return;
    }
    final Player p1 = event.getPlayer();
    final Player r = (Player)event.getRightClicked();
    if (p1.getItemInHand().getType() == Material.ARROW)
    {
      if ((ArrayL.rain.contains(p1.getName())) && 
        (ArrayL.cooldownm.contains(p1)))
      {
        p1.sendMessage("§7× §c Kit em Cooldown, Aguarde !");
        return;
      }
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
      {
        public void run()
        {
          Location loc = r.getLocation();
          loc.setY(loc.getY() + 3.0D);
          
          Entity arrow2 = Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc, EntityType.ARROW);
        }
      }, 65L);
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
      {
        public void run()
        {
          Location loc = r.getLocation();
          loc.setY(loc.getY() + 3.0D);
          
          Entity arrow2 = Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc, EntityType.ARROW);
        }
      }, 60L);
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
      {
        public void run()
        {
          Location loc = r.getLocation();
          loc.setY(loc.getY() + 3.0D);
          
          Entity arrow2 = Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc, EntityType.ARROW);
        }
      }, 50L);
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
      {
        public void run()
        {
          Location loc = r.getLocation();
          loc.setY(loc.getY() + 3.0D);
          
          Entity arrow2 = Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc, EntityType.ARROW);
        }
      }, 45L);
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
      {
        public void run()
        {
          Location loc = r.getLocation();
          loc.setY(loc.getY() + 3.0D);
          
          Entity arrow2 = Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc, EntityType.ARROW);
        }
      }, 40L);
      
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
      {
        public void run()
        {
          Location loc2 = r.getLocation();
          loc2.setY(loc2.getY() + 3.0D);
          
          Entity arrow3 = Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc2, EntityType.ARROW);
        }
      }, 35L);
      
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
      {
        public void run()
        {
          Rain.hab.remove(p1.getName());
        }
      }, 50L);
      ArrayL.cooldownm.add(p1);
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
      {
        public void run()
        {
          ArrayL.cooldownm.remove(p1);
          p1.sendMessage("§6× §aVoce pode usar novamente!");
          p1.getWorld().playSound(p1.getLocation(), Sound.BURP, 5.0F, 5.0F);
        }
      }, 700L);
    }
  }
}
