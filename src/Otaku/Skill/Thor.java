/*    */ package Otaku.Skill;
/*    */ 
/*    */ import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/*    */ import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Server;
import org.bukkit.Sound;
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.block.Block;
/*    */ import org.bukkit.entity.EntityType;
/*    */ import org.bukkit.entity.LightningStrike;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.Action;
/*    */ import org.bukkit.event.entity.EntityDamageEvent;
/*    */ import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.scheduler.BukkitScheduler;

import Otaku.Main;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Thor
/*    */   implements Listener
/*    */ {
	public Main plugin;
	  
	  public Thor(Main plugin)
	  {
	    this.plugin = plugin;
	  }
	  public static ArrayList<String> cooldown = new ArrayList();
	  
	  
	  @EventHandler
	  public void onPlayerThor(PlayerInteractEvent e)
	  {
	    final Player p = e.getPlayer();
	    if (e.getAction() != Action.RIGHT_CLICK_BLOCK) {
	      return;
	    }
	    if ((p.getItemInHand().getType() == Material.GOLD_AXE) && 
	      (Metodos.getAbility(p) == "Thor"))
	    {
	      if (this.cooldown.contains(p.getName()))
	      {
	        e.setCancelled(true);
	        p.sendMessage(" §7× §c Kit em Cooldown, Aguarde !");
	        return;
	      }
	      e.setCancelled(true);
	      
	      Block b = e.getClickedBlock();
	      
	      World w = p.getWorld();
	      w.spawnEntity(w.getHighestBlockAt(b.getLocation()).getLocation(), EntityType.LIGHTNING);
	      LightningStrike strike = p.getWorld().strikeLightning(
	        p.getWorld()
	        .getHighestBlockAt(
	        e.getClickedBlock()
	        .getLocation())
	        .getLocation().clone().add(0.0D, 0.0D, 0.0D));
	      
	      this.cooldown.add(p.getName());
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
	      {
	        public void run()
	        {
	          Thor.this.cooldown.remove(p.getName());
	          p.sendMessage("§6× §aVoce pode usar novamente!");
	        }
	      }, 100L);
	    }
	  }
/*    */   @EventHandler
/* 74 */   public void idknow(EntityDamageEvent e) { if ((e.getEntity() instanceof Player))
/*    */     {
/* 76 */       Player p = (Player)e.getEntity();
/* 77 */       if (e.getCause() != EntityDamageEvent.DamageCause.LIGHTNING) {
/* 78 */         return;
/*    */       }
/* 80 */       if (Metodos.getAbility(p) == "Thor") {
/* 81 */         e.setCancelled(true);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\pcnote\Desktop\PublicG2.jar!\zKits\Thor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */