/*     */ package Otaku.Skill;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Color;
/*     */ import org.bukkit.Effect;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Server;
/*     */ import org.bukkit.Sound;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.entity.Entity;
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
/*     */ public class Deshfire implements Listener, CommandExecutor
/*     */ {
/*  33 */   public static ArrayList<Player> Cooldown = new ArrayList();
/*  34 */   public static HashMap<String, ItemStack[]> Armadura = new HashMap();
/*     */   
/*     */ 
/*  37 */   public static ArrayList<Player> cooldownm = new ArrayList();
/*     */   
/*     */   @EventHandler
/*     */   public void interact(PlayerInteractEvent e) {
/*  41 */     final Player p = e.getPlayer();
/*  42 */     if ((Metodos.getAbility(p) == "Deshfire") && (
/*  43 */       (e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)))
/*     */     {
/*  45 */       if (p.getItemInHand().getType() == Material.REDSTONE_BLOCK) {
/*  46 */         e.setCancelled(true);
/*  47 */         p.updateInventory();
/*  48 */         if (cooldownm.contains(p))
/*     */         {
/*  50 */           p.sendMessage("§7× §c Kit em Cooldown, Aguarde !");
/*  51 */           return;
/*     */         }
/*  53 */         Armadura.put(p.getName(), p.getInventory().getArmorContents());
/*     */         
/*  55 */         ItemStack Peitoral = new ItemStack(Material.LEATHER_CHESTPLATE);
/*  56 */         LeatherArmorMeta kPeitoral = (LeatherArmorMeta)Peitoral.getItemMeta();
/*  57 */         kPeitoral.setColor(Color.RED);
/*  58 */         Peitoral.setItemMeta(kPeitoral);
/*     */         
/*     */ 
/*  61 */         p.getInventory().setChestplate(Peitoral);
/*     */         
/*  63 */         ItemStack Capacete = new ItemStack(Material.LEATHER_HELMET);
/*  64 */         LeatherArmorMeta kCapacete = (LeatherArmorMeta)Capacete.getItemMeta();
/*  65 */         kCapacete.setColor(Color.RED);
/*  66 */         Capacete.setItemMeta(kCapacete);
/*     */         
/*     */ 
/*     */ 
/*  70 */         ItemStack Calca = new ItemStack(Material.LEATHER_LEGGINGS);
/*  71 */         LeatherArmorMeta kCalca = (LeatherArmorMeta)Calca.getItemMeta();
/*  72 */         kCalca.setColor(Color.RED);
/*  73 */         Calca.setItemMeta(kCalca);
/*     */         
/*  75 */         ItemStack Bota = new ItemStack(Material.LEATHER_BOOTS);
/*  76 */         LeatherArmorMeta kBota = (LeatherArmorMeta)Bota.getItemMeta();
/*  77 */         kBota.setColor(Color.RED);
/*  78 */         Bota.setItemMeta(kBota);
/*     */         
/*     */ 
/*  81 */         p.getInventory().setHelmet(Capacete);
/*     */         
/*  83 */         p.getInventory().setLeggings(Calca);
/*  84 */         p.getInventory().setBoots(Bota);
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  93 */         p.sendMessage("§7× §7DeshFire Usado!");
/*     */         
/*  95 */         p.playSound(p.getLocation(), Sound.BLAZE_HIT, 1.0F, 1.0F);
/*     */         
/*  97 */         p.updateInventory();
/*     */         
/*     */ 
/* 100 */         final Vector Vector = p.getEyeLocation().getDirection();
/* 101 */         Vector.multiply(5);
/* 102 */         p.setVelocity(Vector);
/*     */         
/* 104 */         java.util.List<Entity> Local = p.getNearbyEntities(10.0D, 10.0D, 10.0D);
/* 105 */         for (Entity Inimigos : Local) {
/* 106 */           Inimigos.setFireTicks(100);
/*     */           
/*     */ 
/*     */ 
/* 110 */           Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
/*     */             public void run() {
/* 112 */               p.setVelocity(Vector);
/* 113 */               p.getWorld().playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 100, 1);
/*     */ 
/*     */             }
/*     */             
/*     */ 
/* 118 */           }, 20L);
/*     */           
/* 120 */           Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
/*     */           {
/*     */             public void run() {
/* 123 */               p.getWorld().playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 100, 1);
/*     */             }
/*     */             
/*     */ 
/* 127 */           }, 30L);
/*     */           
/* 129 */           Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
/*     */           {
/*     */             public void run() {
/* 132 */               p.getWorld().playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 100, 1);
/*     */             }
/*     */             
/* 135 */           }, 40L);
/*     */           
/* 137 */           Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
/*     */           {
/*     */             public void run() {
/* 140 */               p.getWorld().playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 100, 1);
/*     */             }
/*     */             
/* 143 */           }, 50L);
/*     */         }
/*     */         
/* 146 */         Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
/*     */         {
/*     */           public void run() {
/* 149 */             p.getWorld().playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 100, 1);
/* 150 */             p.getInventory().setArmorContents((ItemStack[])Deshfire.Armadura.get(p.getName()));
/* 151 */             p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 0));
/*     */ 
/*     */ 
/*     */ 
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */ 
/* 160 */         }, 60L);
/*     */         
/*     */ 
/* 163 */         cooldownm.add(p);
/* 164 */         Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/* 168 */             Deshfire.cooldownm.remove(p);
/*     */             
/* 170 */             p.sendMessage("§6× §aVoce pode usar novamente!");
/*     */           }
/*     */           
/*     */ 
/* 174 */         }, 500L);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
/* 180 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\pcnote\Desktop\PublicG2.jar!\zKits\Deshfire.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */