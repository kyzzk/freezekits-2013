package Otaku.Skill;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

import Otaku.Main;

public class Anchor
  implements Listener
{
  public static Main plugin;
  
  public Anchor(Main main)
  {
    plugin = main;
  }
  
  @EventHandler
  public void EventoAnchor(EntityDamageByEntityEvent e)
  {
    if (((e.getEntity() instanceof Player)) && 
      ((e.getDamager() instanceof Player)))
    {
      final Player p = (Player)e.getEntity();
      Player d = (Player)e.getDamager();
      if (ArrayL.anchor.contains(d.getName()))
      {
        p.setVelocity(new Vector());
        p.getPlayer().playSound(p.getPlayer().getLocation(), Sound.ANVIL_USE, 5.0F, 5.0F);
        Bukkit.getServer().getScheduler()
          .scheduleAsyncDelayedTask(plugin, new Runnable()
          {
            public void run()
            {
              p.setVelocity(new Vector());
            }
          }, 1L);
      }
    }
  }
  
  @EventHandler
  public void AnchorEvento(EntityDamageByEntityEvent e)
  {
    if (((e.getEntity() instanceof Player)) && 
      ((e.getDamager() instanceof Player)))
    {
      final Player p = (Player)e.getEntity();
      if (ArrayL.anchor.contains(p.getName()))
      {
        p.setVelocity(new Vector());
        p.getPlayer().playSound(p.getPlayer().getLocation(), Sound.ANVIL_USE, 5.0F, 5.0F);
        Bukkit.getServer().getScheduler()
          .scheduleAsyncDelayedTask(plugin, new Runnable()
          {
            public void run()
            {
              p.setVelocity(new Vector());
            }
          }, 1L);
      }
    }
  }
}
