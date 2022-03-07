/*     */ package Otaku.Eventos;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import org.bukkit.Effect;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Sound;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.block.Block;
/*     */ import org.bukkit.block.BlockFace;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.EventPriority;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.entity.EntityDamageEvent;
/*     */ import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
/*     */ import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.potion.PotionEffect;
/*     */ import org.bukkit.potion.PotionEffectType;
/*     */ import org.bukkit.util.Vector;

import Otaku.Main;
import Otaku.API.Title;
import Otaku.Skill.ArrayL;
import Otaku.Skill.Metodos;
/*     */ 
/*     */ public class Jump implements Listener
/*     */ {
/*     */   Main main;
/*  26 */   public ArrayList<String> jump = new ArrayList<String>();
/*     */   
/*     */   public Jump(Main plugin)
/*     */   {
/*  38 */     plugin = this.main;
/*     */   }

@EventHandler(priority=EventPriority.MONITOR)
public void onPlayerSpongeDamage(EntityDamageEvent e)
{
  if (!(e.getEntity() instanceof Player)) {
    return;
  }
  Player p = (Player)e.getEntity();
  if (e.getCause() == EntityDamageEvent.DamageCause.FALL)
  {
    if (this.jump.contains(p.getName()))
    {
      e.setDamage(0.0D);
      this.jump.remove(p.getName());
      return;
    }
    return;
  }
}

@EventHandler
public void onPlayerFrente(PlayerMoveEvent e)
{
  Player p = e.getPlayer();
  if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.GOLD_BLOCK)
  {
    Location loc = e.getTo().getBlock().getLocation();
    p.playSound(loc, Sound.ENDERDRAGON_HIT, 6.0F, 1.0F);
    p.playEffect(loc, Effect.STEP_SOUND, 10);
    Vector sponge = p.getLocation().getDirection().multiply(6.0D).setY(0.5D);
    p.setVelocity(sponge);
    
    this.jump.add(p.getName());
  }
}
@EventHandler
public void onPlayerFrenteKit(PlayerMoveEvent e)
{
  Player p = e.getPlayer();
  if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.BEACON)
  {
    if (ArrayL.usandokit.contains(p.getName()))
    {
      this.jump.remove(p.getName());
      Location loc = e.getTo().getBlock().getLocation();
      p.playSound(loc, Sound.ENDERDRAGON_HIT, 6.0F, 1.0F);
      p.playEffect(loc, Effect.STEP_SOUND, 10);
      Vector sponge = p.getLocation().getDirection().multiply(4.0D).setY(0.5D);
      p.setVelocity(sponge);
      this.jump.add(p.getName());
      return;
    }
    this.jump.remove(p.getName());
    Location loc = e.getTo().getBlock().getLocation();
    p.playSound(loc, Sound.ENDERDRAGON_HIT, 6.0F, 1.0F);
    p.playEffect(loc, Effect.STEP_SOUND, 10);
    Vector sponge = p.getLocation().getDirection().multiply(4.0D).setY(0.5D);
    p.setVelocity(sponge);
    ArrayL.usandokit.add(p.getName());
  //  Title.sendTitle(p, "§7Kit");
    //Title.sendSubTitle(p, "§6PvP");
    p.sendMessage("§6× §7Voce Selecionou o Kit §6PvP");
    Metodos.setAbility(p, "PvP");
    Metodos.DarosKits(p);
    this.jump.add(p.getName());
  }
}
/*     */   
/*     */  @EventHandler(priority=EventPriority.HIGHEST)
public void onEntityDamageSponge1(EntityDamageEvent event)
{
  if ((event.getEntity() instanceof Player))
  {
    Player player = (Player)event.getEntity();
    Location loc = player.getLocation();
    Location below = loc.subtract(0.0D, 1.0D, 0.0D);
    Block blockBelow = below.getBlock();
    if (event.getCause() == EntityDamageEvent.DamageCause.FALL)
    {
      if (blockBelow.getType() == Material.SPONGE)
      {
        event.setDamage(0.0D);
        this.jump.remove(player.getName());
        return;
      }
      return;
    }
    return;
  }
}

@EventHandler(priority=EventPriority.MONITOR)
public void onPlayerJump2(PlayerMoveEvent e)
{
  Player p = e.getPlayer();
  if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SPONGE)
  {
    this.jump.remove(p.getName());
    Vector sponge = p.getLocation().getDirection().multiply(0).setY(4);
    p.setVelocity(sponge);
    
    Location loc = e.getTo().getBlock().getLocation();
    p.playSound(loc, Sound.ENDERDRAGON_HIT, 6.0F, 1.0F);
    p.playEffect(loc, Effect.STEP_SOUND, 10);
    
    this.jump.add(p.getName());
    this.jump.remove(p.getName());
    this.jump.add(p.getName());
    return;
  }
}
}

/* Location:              C:\Users\pcnote\Desktop\PublicG2.jar!\zEvents\Jump.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */