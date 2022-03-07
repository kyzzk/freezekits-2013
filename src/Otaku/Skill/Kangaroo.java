package Otaku.Skill;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import Otaku.Main;
import Otaku.API.Messages;
import Otaku.Eventos.CombatLog;

public class Kangaroo
  implements Listener
{
  ArrayList<Player> kanga = new ArrayList();
  static List<Player> kangacd = new ArrayList();
  
  @EventHandler
  public void onClick(PlayerInteractEvent event)
  {
    Player p = event.getPlayer();
    if ((p.getItemInHand().getType() == Material.FIREWORK) && 
      (Metodos.getAbility(p) == "Kangaroo"))
    {
      if ((event.getAction() == Action.LEFT_CLICK_AIR) || 
        (event.getAction() == Action.LEFT_CLICK_BLOCK) || 
        (event.getAction() == Action.RIGHT_CLICK_BLOCK) || 
        (event.getAction() == Action.RIGHT_CLICK_AIR)) {
        event.setCancelled(true);
      }
      if ((event.getAction() == Action.LEFT_CLICK_AIR) || 
    	        (event.getAction() == Action.LEFT_CLICK_BLOCK) || 
    	        (event.getAction() == Action.RIGHT_CLICK_BLOCK) || 
    	        (event.getAction() == Action.RIGHT_CLICK_AIR)) {
    	        event.setCancelled(true);
    	      }
    	      if (CombatLog.NoLog.contains(p.getName()))
    	      {
    	        msg(p, "§cVocê nao pode usar esta Habilidade em combate!");
    	        return;
    	      }
    	      if (!Main.SemPvP(p))
    	      {
    	        Messages.PvP(p);
    	        return;
    	      }
    	      if (!this.kanga.contains(p))
    	      {
    	        if (!p.isSneaking())
    	        {
    	          p.setFallDistance(-5.0F);
    	          Vector vector = p.getEyeLocation().getDirection();
    	          vector.multiply(0.3F);
    	          vector.setY(0.85F);
    	          p.setVelocity(vector);
    	        }
    	        else
    	        {
    	          p.setFallDistance(-5.0F);
    	          Vector vector = p.getEyeLocation().getDirection();
    	          vector.multiply(1.2F);
    	          vector.setY(0.65D);
    	          p.setVelocity(vector);
    	        }
    	        this.kanga.add(p);
    	      }
    	    }
    	  }
  
  @EventHandler
  public void onMover(PlayerMoveEvent event)
  {
    Player p = event.getPlayer();
    if (this.kanga.contains(p))
    {
      Block b = p.getLocation().getBlock();
      if ((b.getType() != Material.AIR) || 
        (b.getRelative(BlockFace.DOWN).getType() != Material.AIR)) {
        this.kanga.remove(p);
      }
    }
  }
  
  @EventHandler
  public void onTomarDano(EntityDamageEvent event)
  {
    Entity e = event.getEntity();
    if ((e instanceof Player))
    {
      Player player = (Player)e;
      if (((event.getEntity() instanceof Player)) && 
        (event.getCause() == EntityDamageEvent.DamageCause.FALL) && 
        (player.getInventory().contains(Material.FIREWORK)) && 
        (event.getDamage() >= 5.0D)) {
        event.setDamage(3.0D);
      }
    }
  }
  
  public static void msg(Player p, String msg)
  {
    p.sendMessage(msg);
  }
}
