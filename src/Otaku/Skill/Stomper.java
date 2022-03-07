package Otaku.Skill;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

import Otaku.Main;

public class Stomper
implements Listener
{
public static Main plugin;
static List<Player> cooldownm = new ArrayList();

public Stomper(Main main)
{
  plugin = main;
}

public Stomper() {}

@EventHandler(priority=EventPriority.HIGH)
public void onPlayerStomp(EntityDamageEvent e)
{
  if (!(e.getEntity() instanceof Player)) {
    return;
  }
  Player p = (Player)e.getEntity();
  if (e.getCause() == EntityDamageEvent.DamageCause.FALL)
  {
    if (ArrayL.stomper.contains(p.getName()))
    {
      for (Entity ent : p.getNearbyEntities(4.0D, 1.5D, 4.0D)) {
        if ((ent instanceof Player))
        {
          Player plr = (Player)ent;
          if (e.getDamage() <= 4.0D)
          {
            e.setCancelled(true);
            return;
          }
          if (plr.isSneaking())
          {
            plr.damage(6.0D, p);
            plr.sendMessage("§a§oVoce foi stompado por:§c§o " + p.getName());
          }
          else
          {
        	  Location loc = p.getLocation();
              p.playSound(loc, Sound.DIG_STONE, 5.0F, -5.0F);
              p.playSound(loc, Sound.DIG_STONE, 5.0F, -3.0F);
              p.playSound(loc, Sound.DIG_STONE, 5.0F, -1.0F);
              p.playSound(loc, Sound.DIG_STONE, 5.0F, 1.0F);
              p.playSound(loc, Sound.DIG_STONE, 5.0F, 3.0F);
              p.playSound(loc, Sound.DIG_STONE, 5.0F, 5.0F);
              plr.damage(e.getDamage(), p);
            plr.damage(e.getDamage(), p);
            plr.sendMessage("§a§oVoce foi stompado por:§c§o " + p.getName());
          }
        }
      }
      e.setDamage(4.0D);
      return;
    }
    return;
  }
}

@EventHandler
public void stomperApple(PlayerInteractEvent event)
{
  final Player p = event.getPlayer();
  if ((event.getPlayer().getItemInHand().getType() == Material.GOLDEN_APPLE) && 
    (ArrayL.stomper.contains(event.getPlayer().getName())))
  {
    if ((event.getAction() == Action.LEFT_CLICK_AIR) || 
      (event.getAction() == Action.LEFT_CLICK_BLOCK) || 
      (event.getAction() == Action.RIGHT_CLICK_BLOCK) || 
      (event.getAction() == Action.RIGHT_CLICK_AIR)) {
      event.setCancelled(true);
    }
    if (cooldownm.contains(p))
    {
      p.sendMessage("§7× §c Kit em Cooldown, Aguarde !");
      return;
    }
    Vector vector = p.getEyeLocation().getDirection();
    vector.multiply(0.0F);
    vector.setY(6.0F);
    p.setVelocity(vector);
    Location loc = p.getLocation();
    p.getWorld().playSound(loc, Sound.DIG_WOOL, 5.0F, -5.0F);
    cooldownm.add(p);
    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
    {
      public void run()
      {
        Stomper.cooldownm.remove(p);
        p.sendMessage(ChatColor.GREEN + "§6× §aVoce pode usar novamente!");
      }
    }, 1000L);
  }
}
@EventHandler
public void AoMorer(PlayerDeathEvent e){
	Player p = e.getEntity();
	Stomper.cooldownm.remove(p);
}
}