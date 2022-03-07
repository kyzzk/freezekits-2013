/*    */ package Otaku.Skill;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Server;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerInteractEntityEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ import org.bukkit.potion.PotionEffectType;
/*    */ import org.bukkit.scheduler.BukkitScheduler;
/*    */ import org.bukkit.util.Vector;

import Otaku.Main;
/*    */ 
/*    */ public class Supernova implements Listener
/*    */ {
/* 20 */   public static ArrayList<Player> cooldownm = new ArrayList();
/*    */   @EventHandler
/* 22 */   public void onInteract123455(PlayerInteractEntityEvent e) { final Player p = e.getPlayer();
/* 23 */     if (p.getItemInHand().getType() == Material.SUGAR) {
/* 24 */       final Player r = (Player)e.getRightClicked();
/* 25 */       if (cooldownm.contains(p))
/*    */       {
/* 27 */         p.sendMessage(" §7× §c Kit em Cooldown, Aguarde !");
/* 28 */         return;
/*    */       }
/* 30 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
/*    */       {
/*    */ 
/*    */         public void run()
/*    */         {
/* 35 */           r.setVelocity(new Vector(0, 2, 0));
/*    */         }
/*    */         
/*    */ 
/* 39 */       }, 10L);
/*    */       
/*    */ 
/*    */ 
/* 43 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
/*    */         public void run() {
/* 45 */           r.getWorld().createExplosion(r.getLocation(), 0.5F);
/*    */         }
/*    */         
/*    */ 
/* 49 */       }, 20L);
/*    */       
/* 51 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
/*    */         public void run() {
/* 53 */           r.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 1));
/*    */         }
/*    */         
/*    */ 
/* 57 */       }, 25L);
/* 58 */       cooldownm.add(p);
/* 59 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
/*    */       {
/*    */         public void run()
/*    */         {
/* 63 */           Supernova.cooldownm.remove(p);
/*    */           
/* 65 */           p.sendMessage("§6× §aVoce pode usar novamente!");
/*    */         }
/*    */         
/*    */ 
/* 69 */       }, 500L);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\pcnote\Desktop\PublicG2.jar!\zKits\Supernova.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */