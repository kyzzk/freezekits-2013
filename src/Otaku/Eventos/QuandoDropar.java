package Otaku.Eventos;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.scheduler.BukkitScheduler;

import Otaku.Main;

public class QuandoDropar
  implements Listener
{
	
	@EventHandler
	  public void onPegar(PlayerPickupItemEvent e)
	  {
	    if ((e.getItem().getItemStack().getType() == Material.MUSHROOM_SOUP) || 
	      (e.getItem().getItemStack().getType() == Material.RED_MUSHROOM) || 
	      (e.getItem().getItemStack().getType() == Material.BOWL) || 
	      (e.getItem().getItemStack().getType() == Material.BROWN_MUSHROOM)) {
	      e.setCancelled(false);
	    } else {
	      e.setCancelled(true);
	    }
	  }
	@EventHandler
	  public void onDrop(ItemSpawnEvent e)
	  {
	    final Item item = e.getEntity();
	    if (item.getItemStack().getType() == Material.TNT) {
	      return;
	    }
	    if ((item.getItemStack().getType() == Material.MUSHROOM_SOUP) || 
	      (item.getItemStack().getType() == Material.RED_MUSHROOM) || 
	      (item.getItemStack().getType() == Material.BROWN_MUSHROOM)) {
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
	      {
	        public void run()
	        {
	          item.remove();
	          item.getWorld().playEffect(item.getLocation(), Effect.SMOKE, 10);
	        }
	      }, 80L);
	    } else {
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
	      {
	        public void run()
	        {
	          item.remove();
	          item.getWorld().playEffect(item.getLocation(), Effect.SMOKE, 10);
	        }
	      }, 20L);
	    }
	  }
	}
