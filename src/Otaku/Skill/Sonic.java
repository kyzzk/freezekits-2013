/*     */ package Otaku.Skill;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Color;
/*     */ import org.bukkit.Effect;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Server;
/*     */ import org.bukkit.Sound;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.entity.Entity;
/*     */ import org.bukkit.entity.LivingEntity;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.block.Action;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ import org.bukkit.inventory.meta.LeatherArmorMeta;
/*     */ import org.bukkit.potion.PotionEffect;
/*     */ import org.bukkit.potion.PotionEffectType;
/*     */ import org.bukkit.scheduler.BukkitScheduler;
/*     */ import org.bukkit.util.Vector;

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
/*     */ public class Sonic
/*     */   implements Listener
/*     */ {
/*  46 */   public static ArrayList<Player> Cooldown = new ArrayList();
/*  47 */   public static HashMap<String, ItemStack[]> Armadura = new HashMap();
/*     */   
/*     */ 
/*  50 */   public static ArrayList<Player> cooldownm = new ArrayList();
/*     */   
/*     */   @EventHandler
/*     */   public void interact(PlayerInteractEvent e) {
/*  54 */     final Player p = e.getPlayer();
/*  55 */     if ((Metodos.getAbility(p) == "Sonic") && (
/*  56 */       (e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)))
/*     */     {
/*  58 */       if (p.getItemInHand().getType() == Material.LAPIS_BLOCK) {
/*  59 */         e.setCancelled(true);
/*  60 */         p.updateInventory();
/*  61 */         if (cooldownm.contains(p))
/*     */         {
/*  63 */           p.sendMessage(" §7× §c Kit em Cooldown, Aguarde !");
/*  64 */           return;
/*     */         }
/*  66 */         Armadura.put(p.getName(), p.getInventory().getArmorContents());
/*     */         
/*  68 */         ItemStack Peitoral = new ItemStack(Material.LEATHER_CHESTPLATE);
/*  69 */         LeatherArmorMeta kPeitoral = (LeatherArmorMeta)Peitoral.getItemMeta();
/*  70 */         kPeitoral.setColor(Color.BLUE);
/*  71 */         Peitoral.setItemMeta(kPeitoral);
/*     */         
/*     */ 
/*  74 */         p.getInventory().setChestplate(Peitoral);
/*     */         
/*  76 */         ItemStack Capacete = new ItemStack(Material.LEATHER_HELMET);
/*  77 */         LeatherArmorMeta kCapacete = (LeatherArmorMeta)Capacete.getItemMeta();
/*  78 */         kCapacete.setColor(Color.BLUE);
/*  79 */         Capacete.setItemMeta(kCapacete);
/*     */         
/*     */ 
/*     */ 
/*  83 */         ItemStack Calca = new ItemStack(Material.LEATHER_LEGGINGS);
/*  84 */         LeatherArmorMeta kCalca = (LeatherArmorMeta)Calca.getItemMeta();
/*  85 */         kCalca.setColor(Color.BLUE);
/*  86 */         Calca.setItemMeta(kCalca);
/*     */         
/*  88 */         ItemStack Bota = new ItemStack(Material.LEATHER_BOOTS);
/*  89 */         LeatherArmorMeta kBota = (LeatherArmorMeta)Bota.getItemMeta();
/*  90 */         kBota.setColor(Color.BLUE);
/*  91 */         Bota.setItemMeta(kBota);
/*     */         
/*     */ 
/*  94 */         p.getInventory().setHelmet(Capacete);
/*     */         
/*  96 */         p.getInventory().setLeggings(Calca);
/*  97 */         p.getInventory().setBoots(Bota);
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 106 */         p.sendMessage(" §6>>  §7Sonic Usado!");
/*     */         
/* 108 */         p.playSound(p.getLocation(), Sound.ANVIL_USE, 1.0F, 1.0F);
/*     */         
/* 110 */         p.updateInventory();
/*     */         
/*     */ 
/* 113 */         final Vector Vector = p.getEyeLocation().getDirection();
/* 114 */         Vector.multiply(5);
/* 115 */         p.setVelocity(Vector);
/*     */         
/* 117 */         List<Entity> Local = p.getNearbyEntities(10.0D, 10.0D, 10.0D);
/* 118 */         for (Entity Inimigos : Local) {
/* 119 */           ((LivingEntity)Inimigos).addPotionEffect(new PotionEffect(PotionEffectType.POISON, 150, 1));
/*     */           
/*     */ 
/*     */ 
/* 123 */           Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
/*     */             public void run() {
/* 125 */               p.setVelocity(Vector);
/* 126 */               p.getWorld().playEffect(p.getLocation(), Effect.POTION_BREAK, 100, 1);
/*     */ 
/*     */             }
/*     */             
/*     */ 
/* 131 */           }, 20L);
/*     */           
/* 133 */           Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
/*     */           {
/*     */             public void run() {
/* 136 */               p.getWorld().playEffect(p.getLocation(), Effect.POTION_BREAK, 100, 1);
/*     */             }
/*     */             
/*     */ 
/* 140 */           }, 30L);
/*     */           
/* 142 */           Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
/*     */           {
/*     */             public void run() {
/* 145 */               p.getWorld().playEffect(p.getLocation(), Effect.POTION_BREAK, 100, 1);
/*     */             }
/*     */             
/* 148 */           }, 40L);
/*     */           
/* 150 */           Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
/*     */           {
/*     */             public void run() {
/* 153 */               p.getWorld().playEffect(p.getLocation(), Effect.POTION_BREAK, 100, 1);
/*     */             }
/*     */             
/* 156 */           }, 50L);
/*     */         }
/*     */         
/* 159 */         Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
/*     */         {
/*     */           public void run() {
/* 162 */             p.getWorld().playEffect(p.getLocation(), Effect.POTION_BREAK, 100, 1);
/* 163 */             p.getInventory().setArmorContents((ItemStack[])Sonic.Armadura.get(p.getName()));
/* 164 */             p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 0));
/*     */ 
/*     */ 
/*     */ 
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */ 
/* 173 */         }, 60L);
/*     */         
/*     */ 
/* 176 */         cooldownm.add(p);
/* 177 */         Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/* 181 */             Sonic.cooldownm.remove(p);
/*     */             
/* 183 */             p.sendMessage("§6× §aVoce pode usar novamente!");
/*     */           }
/*     */           
/*     */ 
/* 187 */         }, 500L);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\pcnote\Desktop\PublicG2.jar!\zKits\Sonic.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */