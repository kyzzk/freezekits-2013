/*     */ package Otaku.Skill;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Random;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Server;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.block.Action;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.potion.PotionEffect;
/*     */ import org.bukkit.potion.PotionEffectType;
/*     */ import org.bukkit.scheduler.BukkitScheduler;

import Otaku.Main;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Mago
/*     */   implements Listener
/*     */ {
/*  35 */   public static ArrayList<Player> cooldownm = new ArrayList();
/*     */   
/*     */   @EventHandler
/*     */   public void interact(PlayerInteractEvent e)
/*     */   {
/*  40 */     final Player p = e.getPlayer();
/*  41 */     if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
/*  42 */       (Metodos.getAbility(p) == "Mago") && 
/*  43 */       (p.getItemInHand().getType() == Material.POTION)) {
/*  44 */       e.setCancelled(true);
/*  45 */       p.updateInventory();
/*  46 */       if (cooldownm.contains(p))
/*     */       {
/*  48 */         p.sendMessage("§7× §c Kit em Cooldown, Aguarde !");
/*  49 */         return;
/*     */       }
/*     */       
/*  52 */       Random random = new Random();
/*  53 */       int i = random.nextInt(5);
/*     */       
/*  55 */       if (i == 0)
/*     */       {
/*  57 */         p.addPotionEffect(
/*  58 */           new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 300, 0));
/*  59 */         p.sendMessage("§7Voce recebeu o efeito §6Força");
/*     */       }
/*  61 */       if (i == 1)
/*     */       {
/*  63 */         p.addPotionEffect(
/*  64 */           new PotionEffect(PotionEffectType.WEAKNESS, 300, 0));
/*  65 */         p.sendMessage("§7Voce recebeu o efeito §6Fraqueza");
/*     */       }
/*     */       
/*  68 */       if (i == 2)
/*     */       {
/*  70 */         p.addPotionEffect(
/*  71 */           new PotionEffect(PotionEffectType.BLINDNESS, 300, 0));
/*  72 */         p.sendMessage("§7Voce recebeu o efeito §6Cegueira");
/*     */       }
/*  74 */       if (i == 3)
/*     */       {
/*  76 */         p.addPotionEffect(
/*  77 */           new PotionEffect(PotionEffectType.SPEED, 300, 0));
/*  78 */         p.sendMessage("§7Voce recebeu o efeito §6Velocidade");
/*     */       }
/*     */       
/*  81 */       if (i == 3)
/*     */       {
/*  83 */         p.addPotionEffect(
/*  84 */           new PotionEffect(PotionEffectType.REGENERATION, 300, 0));
/*  85 */         p.sendMessage("§7Voce recebeu o efeito §6Regeneraçao");
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  92 */       if (i == 4) {
/*  93 */         p.addPotionEffect(
/*  94 */           new PotionEffect(PotionEffectType.POISON, 300, 0));
/*  95 */         p.sendMessage("§7Voce recebeu o efeito §6Veneno");
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 100 */       cooldownm.add(p);
/* 101 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 105 */           Mago.cooldownm.remove(p);
/*     */           
/* 107 */           p.sendMessage("§6× §aVoce pode usar novamente!");
/*     */         }
/*     */         
/*     */ 
/* 111 */       }, 600L);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\pcnote\Desktop\PublicG2.jar!\zKits\Mago.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */