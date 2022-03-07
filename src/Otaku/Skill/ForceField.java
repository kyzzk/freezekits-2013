package Otaku.Skill;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

public class ForceField
  implements Listener
{
  public static List<Player> cooldownm = new ArrayList();
  
  public ForceField() {}
  
  @EventHandler
  public void stomperApple(PlayerInteractEvent event)
  {
    final Player p = event.getPlayer();
    if ((event.getPlayer().getItemInHand().getType() == Material.NETHER_FENCE) && 
      (ArrayL.Forcefield.contains(event.getPlayer().getName())))
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
      Location loc = p.getLocation();
      p.getWorld().playSound(loc, Sound.MAGMACUBE_WALK2, 0.5F, 0.5F);
      cooldownm.add(p);
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Otaku.Main.getPlugin(), new Runnable()
      {
        public void run()
        {
          ArrayL.Forcefielddano.add(p.getName());
          p.sendMessage("§cO force-field foi ativado!");
        }
      }, 0L);
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Otaku.Main.getPlugin(), new Runnable()
      {
        public void run()
        {
          ArrayL.Forcefielddano.remove(p.getName());
        }
      }, 200L);
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Otaku.Main.getPlugin(), new Runnable()
      {
        public void run()
        {
          ForceField.cooldownm.remove(p);
          p.sendMessage("§6× §aVoce pode usar novamente!");
          p.getWorld().playSound(p.getLocation(), Sound.BURP, 0.5F, 0.5F);
        }
      }, 1200L);
    }
  }
  
  @EventHandler
  public void fraqueza(PlayerMoveEvent event)
  {
    Player p = event.getPlayer();
    if (ArrayL.Forcefielddano.contains(p.getName())) {
      for (Entity pertos : p.getNearbyEntities(8.0D, 8.0D, 8.0D)) {
        if ((pertos instanceof Player))
        {
          Player perto = (Player)pertos;
          if (ArrayL.Forcefield.contains(p.getName())) {
            ((Player)pertos).damage(1.0D);
          }
          pertos.setVelocity(new Vector(0.1D, 0.0D, 0.1D));
          Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Otaku.Main.getPlugin(), new Runnable()
          {
            public void run() {}
          }, 10L);
        }
      }
    }
  }
    @EventHandler
    public void AOMORRER(PlayerDeathEvent e){
  	  Player p = e.getEntity();
  	  ForceField.cooldownm.remove(p);
  }
}
 