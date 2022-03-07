package Otaku.Skill;
/*     */ 
/*     */ import java.util.Random;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Effect;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Sound;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.block.Block;
/*     */ import org.bukkit.block.BlockFace;
/*     */ import org.bukkit.entity.Entity;
/*     */ import org.bukkit.entity.Fish;
/*     */ import org.bukkit.entity.LivingEntity;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.entity.Snowball;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.EventPriority;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.block.Action;
/*     */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*     */ import org.bukkit.event.entity.EntityDamageEvent;
/*     */ import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
/*     */ import org.bukkit.event.entity.EntityDeathEvent;
/*     */ import org.bukkit.event.entity.PlayerDeathEvent;
/*     */ import org.bukkit.event.player.PlayerFishEvent;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.event.player.PlayerMoveEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ import org.bukkit.potion.PotionEffect;
/*     */ import org.bukkit.potion.PotionEffectType;
/*     */ import org.bukkit.scheduler.BukkitScheduler;
/*     */ import org.bukkit.util.Vector;

import Otaku.Main;
/*     */ 
/*     */ public class Kits implements Listener
/*     */ {
/*     */   @EventHandler
/*     */   public void onEntityDamage(EntityDamageByEntityEvent e)
/*     */   {
/*  44 */     if (((e.getDamager() instanceof Player)) && ((e.getEntity() instanceof LivingEntity)))
/*     */     {
/*  46 */       LivingEntity entity = (LivingEntity)e.getEntity();
/*  47 */       Player p = (Player)e.getDamager();
/*  48 */       if (Metodos.getAbility(p) == "Viper")
/*     */       {
/*  50 */         Random rand = new Random();
/*  51 */         int percent = rand.nextInt(100);
/*  52 */         if (percent <= 33)
/*     */         {
/*  54 */           entity.addPotionEffect(
/*  55 */             new PotionEffect(PotionEffectType.POISON, 60, 0));
/*  56 */           return;
/*     */         }
/*  58 */         return;
/*     */       }
/*  60 */       return;
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onEntityDamage(EntityDamageEvent e) {
/*  78 */     if (!(e.getEntity() instanceof Player)) {
/*  79 */       return;
/*     */     }
/*  81 */     Player p = (Player)e.getEntity();
/*  82 */     if ((Metodos.getAbility(p) == "Turtle") && 
/*  83 */       (p.isSneaking()) && (
/*  84 */       (e.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION) || 
/*  85 */       (e.getCause() == EntityDamageEvent.DamageCause.CONTACT) || 
/*  86 */       (e.getCause() == EntityDamageEvent.DamageCause.CUSTOM) || 
/*  87 */       (e.getCause() == EntityDamageEvent.DamageCause.DROWNING) || 
/*  88 */       (e.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK) || 
/*  89 */       (e.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION) || 
/*  90 */       (e.getCause() == EntityDamageEvent.DamageCause.FALL) || 
/*  91 */       (e.getCause() == EntityDamageEvent.DamageCause.FALLING_BLOCK) || 
/*  92 */       (e.getCause() == EntityDamageEvent.DamageCause.FIRE) || 
/*  93 */       (e.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK) || 
/*  94 */       (e.getCause() == EntityDamageEvent.DamageCause.LAVA) || 
/*  95 */       (e.getCause() == EntityDamageEvent.DamageCause.LIGHTNING) || 
/*  96 */       (e.getCause() == EntityDamageEvent.DamageCause.MAGIC) || 
/*  97 */       (e.getCause() == EntityDamageEvent.DamageCause.MELTING) || 
/*  98 */       (e.getCause() == EntityDamageEvent.DamageCause.POISON) || 
/*  99 */       (e.getCause() == EntityDamageEvent.DamageCause.PROJECTILE) || 
/* 100 */       (e.getCause() == EntityDamageEvent.DamageCause.STARVATION) || 
/* 101 */       (e.getCause() == EntityDamageEvent.DamageCause.SUFFOCATION) || 
/* 102 */       (e.getCause() == EntityDamageEvent.DamageCause.THORNS) || 
/* 103 */       (e.getCause() == EntityDamageEvent.DamageCause.VOID) || 
/* 104 */       (e.getCause() == EntityDamageEvent.DamageCause.WITHER)))
/*     */     {
/* 106 */       e.setDamage(0.5D);
/* 107 */       return;
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler(priority=EventPriority.HIGH)
/*     */   public void onPlayerTurleDamage(EntityDamageByEntityEvent e) {
/* 113 */     if (!(e.getEntity() instanceof Player)) {
/* 114 */       return;
/*     */     }
/* 116 */     if (!(e.getDamager() instanceof Player)) {
/* 117 */       return;
/*     */     }
/* 119 */     Player p = (Player)e.getDamager();
/* 120 */     if (p.isSneaking())
/*     */     {
/* 122 */       if (Metodos.getAbility(p) == "Turtle")
/*     */       {
/* 124 */         e.setCancelled(true);
/* 125 */         p.sendMessage("§3>>§cVoce NÃ£o Consegue Bater de Shift!");
/* 126 */         return;
/*     */       }
/* 128 */       return;
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void snowball(EntityDamageByEntityEvent e) {
/* 134 */     if (((e.getDamager() instanceof Snowball)) && 
/* 135 */       ((e.getEntity() instanceof Player)))
/*     */     {
/* 137 */       Snowball s = (Snowball)e.getDamager();
/* 138 */       if ((s.getShooter() instanceof Player))
/*     */       {
/* 140 */         Player shooter = (Player)s.getShooter();
/* 141 */         if (Metodos.getAbility(shooter) == "Switcher")
/*     */         {
/* 143 */           Location shooterLoc = shooter.getLocation();
/* 144 */           shooter.teleport(e.getEntity().getLocation());
/* 145 */           e.getEntity().teleport(shooterLoc);
/* 146 */           shooter.getPlayer().getWorld().playEffect(shooterLoc, Effect.ENDER_SIGNAL, 10);
/* 147 */           shooter.getPlayer().getWorld().playEffect(shooterLoc, Effect.EXTINGUISH, 10);
/* 148 */           shooter.getWorld().playSound(shooter.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.2F);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   
/*     */   @EventHandler
/*     */   public void onIasnteract(PlayerInteractEvent event) {
/* 196 */     Player p = event.getPlayer();
/* 197 */     if ((Metodos.getAbility(p) == "Specialist") && 
/* 198 */       ((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK) || (event.getAction() == Action.LEFT_CLICK_AIR) || (event.getAction() == Action.LEFT_CLICK_BLOCK)) && 
/* 199 */       (p.getItemInHand().getType() == Material.BOOK)) {
/* 200 */       p.openEnchanting(null, true);
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onVampire(EntityDeathEvent event) {
/* 206 */     if ((event.getEntity() instanceof Player))
/*     */     {
/* 208 */       Player killed = (Player)event.getEntity();
/* 209 */       if ((killed.getKiller() instanceof Player))
/*     */       {
/* 211 */         Player player = event.getEntity().getKiller();
/* 212 */         if (Metodos.getAbility(player) == "Specialist")
/*     */         {
/* 214 */           player.getInventory().addItem(new ItemStack[] { new ItemStack(384, 1) });
/* 215 */           player.sendMessage("§3>>§aVoce ganhou um pote de EXP por matar " + killed.getName());
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onSlow(EntityDamageByEntityEvent e) {
/* 223 */     if (((e.getDamager() instanceof Player)) && ((e.getEntity() instanceof Player)))
/*     */     {
/* 225 */       Player p = (Player)e.getEntity();
/* 226 */       Player d = (Player)e.getDamager();
/* 227 */       if ((Metodos.getAbility(d) == "Snail") && (Metodos.getAbility(p) == "Snail"))
/*     */       {
/* 229 */         Random r = new Random();
/* 230 */         int rand = r.nextInt(100);
/* 231 */         if (rand >= 67)
/* 232 */           p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 80, 1));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void darEfeito(Player p, PotionEffectType effect, int ticks, int amplifier) {
/* 238 */     p.addPotionEffect(new PotionEffect(effect, ticks, amplifier), true);
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void poseidon(PlayerMoveEvent event) {
/* 243 */     Player p = event.getPlayer();
/* 244 */     if ((p.getLocation().getBlock().getType().equals(Material.STATIONARY_WATER)) && (Metodos.getAbility(p) == "Poseidon"))
/*     */     {
/* 246 */       darEfeito(p, PotionEffectType.INCREASE_DAMAGE, 100, 1);
/* 247 */       darEfeito(p, PotionEffectType.SPEED, 100, 1);
/* 248 */       darEfeito(p, PotionEffectType.REGENERATION, 100, 1);
/*     */     } }
/*     */   
/*     */ 
/*     */ 
/*     */   @EventHandler
/*     */   public void onTomarDano(EntityDamageEvent event)
/*     */   {
/* 313 */     Entity e = event.getEntity();
/* 314 */     if ((e instanceof Player))
/*     */     {
/* 316 */       Player player = (Player)e;
/* 317 */       if (((event.getEntity() instanceof Player)) && 
/* 318 */         (event.getCause() == EntityDamageEvent.DamageCause.FALL) && 
/* 319 */         (player.getInventory().contains(Material.FIREWORK)) && 
/* 320 */         (event.getDamage() >= 2.0D))
/* 321 */         event.setDamage(2.0D);
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onPlayerFish(PlayerFishEvent event) {
/* 327 */     Entity caught = event.getCaught();
/* 328 */     Block block = event.getHook().getLocation().getBlock();
/* 329 */     if ((caught != null) && (caught != block) && 
/* 330 */       (Metodos.getAbility(event.getPlayer()) == "Fisherman"))
/* 331 */       caught.teleport(event.getPlayer().getLocation());
/*     */   }
/*     */   
/*     */   @EventHandler
/* 335 */   public void damage(EntityDamageEvent e) { if ((e.getEntity() instanceof Player))
/*     */     {
/* 337 */       Player p = (Player)e.getEntity();
/* 338 */       if ((Metodos.getAbility(p) == "Fireman") && (
/* 339 */         (e.getCause() == EntityDamageEvent.DamageCause.LAVA) || 
/* 340 */         (e.getCause() == EntityDamageEvent.DamageCause.FIRE) || 
/* 341 */         (e.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK))) {
/* 342 */         e.setCancelled(true);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void Fogo(EntityDamageByEntityEvent e) {
/* 349 */     if ((e.getDamager() instanceof Player))
/*     */     {
/* 351 */       Player p = (Player)e.getDamager();
/* 352 */       if ((Metodos.getAbility(p) == "Fireman") && 
/* 353 */         (p.getInventory().getItemInHand() != null) && 
/* 354 */         (p.getInventory().getItemInHand().getType() == Material.STONE_SWORD) && 
/* 355 */         ((e.getEntity() instanceof LivingEntity)))
/*     */       {
/* 357 */         LivingEntity en = (LivingEntity)e.getEntity();
/* 358 */         if (en.isDead()) {
/* 359 */           return;
/*     */         }
/* 361 */         en.setFireTicks(100);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onAnchorDamage(EntityDamageByEntityEvent e) {
/* 368 */     if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
/*     */     {
/* 370 */       final Player p = (Player)e.getEntity();
/* 371 */       final Player d = (Player)e.getDamager();
/*     */       
/* 373 */       if ((Metodos.getAbility(p) == "Anchor") || (Metodos.getAbility(p) == "Anchor"))
/* 374 */         Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/* 378 */             double x = 0.0D;
/* 379 */             double y = 0.0D;
/* 380 */             double z = 0.0D;
/* 381 */             Vector v = new Vector(x, y, z);
/* 382 */             p.setVelocity(v);
/* 383 */             d.setVelocity(v);
/*     */           }
/*     */           
/* 386 */         }, 1L);
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onPlayerCamel(PlayerMoveEvent e) {
/* 392 */     Player p = e.getPlayer();
/* 393 */     if (((e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SAND) || (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SANDSTONE)) && 
/* 394 */       (Metodos.getAbility(p) == "Camel"))
/*     */     {
/* 396 */       p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 80, 0));
/* 397 */       p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 80, 0));
/* 398 */       return;
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onEntityDamage1(EntityDamageByEntityEvent e) {
/* 404 */     if (((e.getDamager() instanceof Player)) && 
/* 405 */       ((e.getEntity() instanceof LivingEntity)))
/*     */     {
/* 407 */       LivingEntity entity = (LivingEntity)e.getEntity();
/* 408 */       Player p = (Player)e.getDamager();
/* 409 */       if (Metodos.getAbility(p) == "Confuser")
/*     */       {
/* 411 */         Random rand = new Random();
/* 412 */         int percent = rand.nextInt(100);
/* 413 */         if (percent <= 33)
/*     */         {
/* 415 */           entity.addPotionEffect(
/* 416 */             new PotionEffect(PotionEffectType.CONFUSION, 120, 0));
/* 417 */           return;
/*     */         }
/* 419 */         return;
/*     */       }
/* 421 */       return;
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void forca(PlayerDeathEvent e) {
/* 427 */     if ((e.getEntity().getKiller() instanceof Player))
/*     */     {
/* 429 */       Player p = e.getEntity().getKiller();
/* 430 */       if (Metodos.getAbility(p) == "Berserker")
/*     */       {
/* 432 */         p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 400, 0));
/* 433 */         p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 400, 0));
/* 434 */         p.playSound(p.getLocation(), Sound.AMBIENCE_THUNDER, 1.0F, 1.0F);
/* 435 */         return;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void main1(EntityDamageByEntityEvent e) {
/* 442 */     if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
/*     */     {
/* 444 */       Player p = (Player)e.getEntity();
/* 445 */       Player d = (Player)e.getDamager();
/* 446 */       if ((Metodos.getAbility(d) == "Woodman") && 
/* 447 */         (
/* 448 */         d.getItemInHand().getType() == Material.WOOD_SWORD)) {
/* 449 */         e.setDamage(4.5D);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void Viking(EntityDamageByEntityEvent e) {
/* 456 */     if (((e.getEntity() instanceof Player)) && 
/* 457 */       ((e.getDamager() instanceof Player))) {
/* 458 */       Player damager = (Player)e.getDamager();
/* 459 */       if (Metodos.getAbility(damager) == "Viking")
/*     */       {
/* 462 */         if ((damager.getItemInHand().getItemMeta().getDisplayName().contains("§cViking")) && 
/* 463 */           (damager.isOnGround())) {
	
/* 464 */           e.setDamage(e.getDamage() - 4.5D);

/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\pcnote\Desktop\PublicG2.jar!\zKits\Kits.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */