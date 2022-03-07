package Otaku.Skill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

import Otaku.Main;

public class Hulk
  implements Listener
{
  
	public static ArrayList<Player> cooldown = new ArrayList();
  public static ArrayList<Player> hulk = new ArrayList();
  
  @EventHandler
  public void deathe(PlayerDeathEvent e)
  {
    Player p = e.getEntity();
    
    hulk.remove(p);
    cooldown.remove(p);
  }
  
  @EventHandler
  public void ent(PlayerJoinEvent e)
  {
    Player p = e.getPlayer();
    
    hulk.remove(p);
    cooldown.remove(p);
  }
  
  @EventHandler
  public void onPlayerDamage(EntityDamageByEntityEvent e)
  {
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Player p = (Player)e.getEntity();
      Player d = (Player)e.getDamager();
      if ((hulk.contains(d)) && (p == d.getPassenger()))
      {
        e.setCancelled(true);
        d.damage(1.0D, p);
        d.sendMessage(ChatColor.RED + "Bate com o Direito na Vitima !");
      }
    }
  }
  
  @EventHandler
  public void onThrow(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if (!hulk.contains(p)) {
      return;
    }
    if (p.getPassenger() == null) {
      return;
    }
    if (p.getItemInHand().getType() != Material.AIR) {
      return;
    }
    if ((e.getAction() != Action.LEFT_CLICK_AIR) && (e.getAction() != Action.LEFT_CLICK_BLOCK)) {
      return;
    }
    Entity hulked = p.getPassenger();
    hulked.getVehicle().eject();
    Location loc = p.getLocation();
    loc.setY(loc.getY() + 2.0D);
    hulked.teleport(loc);
    hulked.setVelocity(p.getEyeLocation().getDirection().multiply(2.0D));
  }
  
  @EventHandler
  public void PickUpPlayer(PlayerInteractEntityEvent e)
  {
    if (!hulk.contains(e.getPlayer())) {
      return;
    }
    if ((e.getRightClicked() instanceof Player))
    {
      final Player p = e.getPlayer();
      Player r = (Player)e.getRightClicked();
      if (p.getItemInHand().getType() != Material.AIR) {
        return;
      }
      if (p.getPassenger() != null) {
        return;
      }
      if (r.getPassenger() != null) {
        return;
      }
      if (hulk.contains(r))
      {
        p.sendMessage(ChatColor.RED + "Ja tem alguem na garupa !");
        return;
      }
      if (cooldown.contains(p))
      {
        p.sendMessage(ChatColor.RED + "§7× §c Kit em Cooldown, Aguarde !");
        return;
      }
      cooldown.add(p);
      p.setPassenger(r);
      r.sendMessage(ChatColor.RED + "Algum hulk te pegou, tente Fugir o mais rapido !");
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
      {
        public void run()
        {
          Hulk.cooldown.remove(p);
        }
      }, 60L);
    }
  }
}