package Otaku.Skill;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

public class Sumo
  implements Listener
{
  public static int maca = Material.APPLE.getId();
  public static ArrayList<Player> sumo = new ArrayList();
  public Plugin plugin;
  public ArrayList<String> Cima = new ArrayList();
  ArrayList<String> tempo = new ArrayList();
  private ArrayList<Block> remover = new ArrayList();
  
  public Sumo(Otaku.Main plugin)
  {
    this.plugin = plugin;
  }
  
  @EventHandler
  public void Morrer(PlayerDeathEvent e)
  {
    Player p = e.getEntity();
    sumo.remove(p);
    this.tempo.remove(p.getName());
    this.Cima.remove(p.getName());
  }
  
  @EventHandler
  public void Sair(PlayerQuitEvent e)
  {
    Player p = e.getPlayer();
    sumo.remove(p);
    this.tempo.remove(p.getName());
    this.Cima.remove(p.getName());
  }
  
  @EventHandler
  public void Clicar(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if (((p instanceof Player)) && 
      (sumo.contains(p)))
    {
      if (p.getItemInHand().equals(Integer.valueOf(maca))) {
        return;
      }
      if (!e.getAction().name().contains("RIGHT")) {
        return;
      }
      if (p.getItemInHand().getTypeId() != maca) {
        return;
      }
      e.setCancelled(true);
      if (!this.tempo.contains(p.getName()))
      {
        Location Local = e.getPlayer().getLocation();
        Local = Local.getWorld().getHighestBlockAt(Local).getLocation().add(0.0D, 22.0D, 0.0D);
        for (int x = 0; x <= 0; x++) {
          for (int z = 0; z <= 0; z++)
          {
            final Block a = Local.add(x, 0.0D, z).getBlock();
            a.setType(Material.BEDROCK);
            e.getPlayer().teleport(Local.add(0.0D, 1.0D, 0.0D));
            this.tempo.add(p.getName());
            this.Cima.add(p.getName());
            Bukkit.getServer().getScheduler().runTaskLater(this.plugin, new Runnable()
            {
              public void run()
              {
                a.setType(Material.AIR);
                Sumo.this.remover.remove(a);
              }
            }, 50L);
          }
        }
      }
      else
      {
        p.sendMessage("§7× §c Kit em Cooldown, Aguarde !");
      }
    }
  }
  
  @EventHandler
  public void Cair(EntityDamageEvent e)
  {
    if (!(e.getEntity() instanceof Player)) {
      return;
    }
    final Player p = (Player)e.getEntity();
    if ((e.getCause() == EntityDamageEvent.DamageCause.FALL) && 
      (this.Cima.contains(p.getName())))
    {
      e.setCancelled(true);
      for (Entity Altura : p.getNearbyEntities(8.0D, 8.0D, 8.0D)) {
        if ((Altura instanceof Player))
        {
          Player Pular = (Player)Altura;
          Vector v = p.getLocation().getDirection().multiply(0).setY(2.0D);
          Pular.setVelocity(v);
        }
      }
      this.Cima.remove(p.getName());
      e.setDamage(9.0D);
      Bukkit.getServer().getScheduler().runTaskLater(this.plugin, new Runnable()
      {
        public void run()
        {
          Sumo.this.tempo.remove(p.getName());
        }
      }, 600L);
      
      return;
    }
  }
}
