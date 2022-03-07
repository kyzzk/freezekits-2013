package Otaku.Skill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.BlockIterator;
import org.bukkit.util.Vector;

public class AvatarSV
  implements Listener
{
  public static HashMap<String, Long> cooldown = new HashMap();
  public static HashMap<String, Egg> teias = new HashMap();
  
  @EventHandler
  public void Trocar(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    
    ItemStack Terra = new ItemStack(Material.GRASS);
    ItemMeta terram = Terra.getItemMeta();
    terram.setDisplayName(ChatColor.DARK_GREEN + "Terra");
    Terra.setItemMeta(terram);
    
    ItemStack Agua = new ItemStack(Material.LAPIS_BLOCK);
    ItemMeta Aguam = Agua.getItemMeta();
    Aguam.setDisplayName(ChatColor.DARK_AQUA + "Agua");
    Agua.setItemMeta(Aguam);
    
    ItemStack Aguac = new ItemStack(Material.BEACON);
    ItemMeta Aguacm = Aguac.getItemMeta();
    Aguacm.setDisplayName(ChatColor.DARK_AQUA + "B");
    Aguac.setItemMeta(Aguacm);
    
    ItemStack AR = new ItemStack(Material.WOOL);
    ItemMeta ARm = AR.getItemMeta();
    ARm.setDisplayName("AR");
    AR.setItemMeta(ARm);
    
    ItemStack Fogo = new ItemStack(Material.REDSTONE_BLOCK);
    ItemMeta Fogom = Fogo.getItemMeta();
    Fogom.setDisplayName(ChatColor.RED + "Fogo");
    Fogo.setItemMeta(Fogom);
    if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK) || (e.getAction() == Action.LEFT_CLICK_AIR) || (e.getAction() == Action.LEFT_CLICK_BLOCK)) && (ArrayL.Avatar.contains(p.getName())) && 
      (p.getItemInHand().getType() == Material.BEACON))
    {
      p.setItemInHand(AR);
      ArrayL.Ferro2.add(p.getName());
    }
    else if ((ArrayL.Ferro2.contains(p.getName())) && ((e.getAction() == Action.LEFT_CLICK_AIR) || (e.getAction() == Action.LEFT_CLICK_BLOCK)) && (ArrayL.Avatar.contains(p.getName())) && 
      (p.getItemInHand().equals(AR)))
    {
      p.setItemInHand(Agua);
      ArrayL.Ferro2.remove(p.getName());
      ArrayL.AvatarH.add(p.getName());
    }
    else if ((ArrayL.AvatarH.contains(p.getName())) && ((e.getAction() == Action.LEFT_CLICK_AIR) || (e.getAction() == Action.LEFT_CLICK_BLOCK)) && (ArrayL.Avatar.contains(p.getName())) && 
      (p.getItemInHand().equals(Agua)))
    {
      p.setItemInHand(Terra);
      ArrayL.AvatarH.remove(p.getName());
      ArrayL.Terra2.add(p.getName());
    }
    else if ((ArrayL.Terra2.contains(p.getName())) && (ArrayL.Terra2.contains(p.getName())) && ((e.getAction() == Action.LEFT_CLICK_AIR) || (e.getAction() == Action.LEFT_CLICK_BLOCK)) && (ArrayL.Avatar.contains(p.getName())) && 
      (p.getItemInHand().equals(Terra)))
    {
      p.setItemInHand(Fogo);
      ArrayL.Terra2.remove(p.getName());
      ArrayL.Red2.add(p.getName());
    }
    else if ((ArrayL.Red2.contains(p.getName())) && ((e.getAction() == Action.LEFT_CLICK_AIR) || (e.getAction() == Action.LEFT_CLICK_BLOCK)) && (ArrayL.Avatar.contains(p.getName())) && 
      (p.getItemInHand().equals(Fogo)))
    {
      p.setItemInHand(AR);
      ArrayL.Red2.remove(p.getName());
      ArrayL.Ferro2.add(p.getName());
    }
  }
  
  ArrayList<Snowball> Soltou = new ArrayList();
  public int id1;
  
  @EventHandler
  public void AvatarAr(PlayerInteractEvent event)
  {
    final Player p = event.getPlayer();
    if ((ArrayL.Ferro2.contains(p.getName())) && ((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK)) && (ArrayL.Avatar.contains(p.getName())) && 
      (p.getItemInHand().getType() == Material.WOOL)) {
      if (Otaku.Main.SemPvP(p))
      {
        event.setCancelled(true);
        if (!ArrayL.Tempo.contains(p))
        {
          ArrayL.Tempo.add(p);
          
          Vector Ferro = p.getLocation().getDirection().normalize().multiply(55);
          Snowball FerroH = (Snowball)p.launchProjectile(Snowball.class);
          FerroH.setVelocity(Ferro);
          FerroH.setMetadata("Ar", new FixedMetadataValue(Otaku.Main.getPlugin(), Boolean.valueOf(true)));
          
          Location pegou = p.getEyeLocation();
          
          BlockIterator Ferrao = new BlockIterator(pegou, 0.0D, 40);
          while (Ferrao.hasNext())
          {
            Location Ferrao2 = Ferrao.next().getLocation();
            
            Effect camelo = Effect.STEP_SOUND;
            p.playSound(p.getLocation(), Sound.STEP_WOOL, 5.5F, 5.5F);
            p.playSound(p.getLocation(), Sound.STEP_WOOL, 1.5F, 1.5F);
            p.playSound(p.getLocation(), Sound.STEP_WOOL, 2.5F, 2.5F);
            p.playSound(p.getLocation(), Sound.STEP_WOOL, 3.5F, 3.5F);
            p.playSound(p.getLocation(), Sound.STEP_WOOL, 4.5F, 4.5F);
            
            p.getWorld().playEffect(Ferrao2, camelo, 35);
          }
          this.id1 = Bukkit.getScheduler().scheduleSyncDelayedTask(Otaku.Main.getPlugin(), new Runnable()
          {
            public void run()
            {
              if (ArrayL.Tempo.contains(p))
              {
                ArrayL.Tempo.remove(p);
                p.sendMessage("�6� �aVoce pode usar novamente!");
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 15.5F, 15.5F);
              }
            }
          }, 250L);
        }
        else
        {
          p.sendMessage("�7� �c Kit em Cooldown, Aguarde !");
        }
      }
      else
      {
        p.sendMessage(ChatColor.RED + "Voce pode usar esta habilidade apenas em areas com PVP.");
      }
    }
  }
  
  @EventHandler
  public void EntityDamageEvent(EntityDamageByEntityEvent event)
  {
    Entity Tomou2 = event.getEntity();
    if ((event.getDamager() instanceof Snowball))
    {
      Snowball Tomou = (Snowball)event.getDamager();
      if (Tomou.hasMetadata("Ar"))
      {
        event.setDamage(16.0D);
        ((LivingEntity)Tomou2).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 0), true);
      }
    }
  }
  
  ArrayList<Snowball> Soltou1 = new ArrayList();
  public int id11;
  
  @EventHandler
  public void AvatarAr1(PlayerInteractEvent event)
  {
    final Player p = event.getPlayer();
    if ((ArrayL.AvatarH.contains(p.getName())) && ((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK)) && (ArrayL.Avatar.contains(p.getName())) && 
      (p.getItemInHand().getType() == Material.LAPIS_BLOCK)) {
      if (Otaku.Main.SemPvP(p))
      {
        event.setCancelled(true);
        if (!ArrayL.Tempo.contains(p))
        {
          ArrayL.Tempo.add(p);
          
          Vector Agua = p.getLocation().getDirection().normalize().multiply(55);
          Snowball AguaH = (Snowball)p.launchProjectile(Snowball.class);
          AguaH.setVelocity(Agua);
          AguaH.setMetadata("Agua", new FixedMetadataValue(Otaku.Main.getPlugin(), Boolean.valueOf(true)));
          
          Location pegou = p.getEyeLocation();
          
          BlockIterator Aguao = new BlockIterator(pegou, 0.0D, 40);
          while (Aguao.hasNext())
          {
            Location Aguao2 = Aguao.next().getLocation();
            
            Effect camelo = Effect.STEP_SOUND;
            p.playSound(p.getLocation(), Sound.STEP_WOOD, 5.5F, 5.5F);
            p.playSound(p.getLocation(), Sound.STEP_WOOD, 1.5F, 1.5F);
            p.playSound(p.getLocation(), Sound.STEP_WOOD, 2.5F, 2.5F);
            p.playSound(p.getLocation(), Sound.STEP_WOOD, 3.5F, 3.5F);
            p.playSound(p.getLocation(), Sound.STEP_WOOD, 4.5F, 4.5F);
            
            p.getWorld().playEffect(Aguao2, camelo, 9);
          }
          this.id1 = Bukkit.getScheduler().scheduleSyncDelayedTask(Otaku.Main.getPlugin(), new Runnable()
          {
            public void run()
            {
              if (ArrayL.Tempo.contains(p))
              {
                ArrayL.Tempo.remove(p);
                p.sendMessage("�6� �aVoce pode usar novamente!");
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 15.5F, 15.5F);
              }
            }
          }, 250L);
        }
        else
        {
          p.sendMessage("�7� �c Kit em Cooldown, Aguarde !");
        }
      }
      else
      {
        p.sendMessage(ChatColor.RED + "Voce pode usar esta habilidade apenas em areas com PVP.");
      }
    }
  }
  
  @EventHandler
  public void EntityDamageEvent11(EntityDamageByEntityEvent event)
  {
    Entity Tomou2 = event.getEntity();
    if ((event.getDamager() instanceof Snowball))
    {
      Snowball Tomou = (Snowball)event.getDamager();
      if (Tomou.hasMetadata("Agua"))
      {
        event.setDamage(11.0D);
        ((LivingEntity)Tomou2).addPotionEffect(new PotionEffect(PotionEffectType.POISON, 300, 0), true);
        
        Vector vector = Tomou2.getLocation().getDirection();
        vector.multiply(-1.0F);
        Tomou2.setVelocity(vector);
      }
    }
  }
  
  @EventHandler
  public void AvatarAr11(PlayerInteractEvent event)
  {
    final Player p = event.getPlayer();
    if ((ArrayL.Red2.contains(p.getName())) && ((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK)) && (ArrayL.Avatar.contains(p.getName())) && 
      (p.getItemInHand().getType() == Material.REDSTONE_BLOCK)) {
      if (Otaku.Main.SemPvP(p))
      {
        event.setCancelled(true);
        if (!ArrayL.Tempo.contains(p))
        {
          ArrayL.Tempo.add(p);
          
          Vector Fogo = p.getLocation().getDirection().normalize().multiply(55);
          Snowball FogoH = (Snowball)p.launchProjectile(Snowball.class);
          FogoH.setVelocity(Fogo);
          FogoH.setMetadata("Fogo", new FixedMetadataValue(Otaku.Main.getPlugin(), Boolean.valueOf(true)));
          
          Location pegou = p.getEyeLocation();
          
          BlockIterator Fogao = new BlockIterator(pegou, 0.0D, 40);
          while (Fogao.hasNext())
          {
            Location Fogao2 = Fogao.next().getLocation();
            
            Effect camelo = Effect.STEP_SOUND;
            p.playSound(p.getLocation(), Sound.FIRE, 5.5F, 5.5F);
            p.playSound(p.getLocation(), Sound.FIRE, 1.5F, 1.5F);
            p.playSound(p.getLocation(), Sound.FIRE, 2.5F, 2.5F);
            p.playSound(p.getLocation(), Sound.FIRE, 3.5F, 3.5F);
            p.playSound(p.getLocation(), Sound.FIRE, 4.5F, 4.5F);
            
            p.getWorld().playEffect(Fogao2, camelo, 10);
          }
          this.id1 = Bukkit.getScheduler().scheduleSyncDelayedTask(Otaku.Main.getPlugin(), new Runnable()
          {
            public void run()
            {
              if (ArrayL.Tempo.contains(p))
              {
                ArrayL.Tempo.remove(p);
                p.sendMessage("�6� �aVoce pode usar novamente!");
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 15.5F, 15.5F);
              }
            }
          }, 250L);
        }
        else
        {
          p.sendMessage("�7� �c Kit em Cooldown, Aguarde !");
        }
      }
      else
      {
        p.sendMessage(ChatColor.RED + "Voce pode usar esta habilidade apenas em areas com PVP.");
      }
    }
  }
  
  @EventHandler
  public void EntityDamageEvent1(EntityDamageByEntityEvent event)
  {
    Entity Tomou2 = event.getEntity();
    if ((event.getDamager() instanceof Snowball))
    {
      Snowball Tomou = (Snowball)event.getDamager();
      if (Tomou.hasMetadata("Fogo"))
      {
        event.setDamage(12.0D);
        Tomou2.setFireTicks(150);
      }
    }
  }
  
  @EventHandler
  public void AvatarTerra(PlayerInteractEvent event)
  {
    final Player p = event.getPlayer();
    if ((ArrayL.Terra2.contains(p.getName())) && ((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK)) && (ArrayL.Avatar.contains(p.getName())) && 
      (p.getItemInHand().getType() == Material.GRASS)) {
      if (Otaku.Main.SemPvP(p))
      {
        event.setCancelled(true);
        if (!ArrayL.Tempo.contains(p))
        {
          ArrayL.Tempo.add(p);
          Vector Terra = p.getLocation().getDirection().normalize().multiply(55);
          Snowball TerraH = (Snowball)p.launchProjectile(Snowball.class);
          TerraH.setVelocity(Terra);
          TerraH.setMetadata("Terra", new FixedMetadataValue(Otaku.Main.getPlugin(), Boolean.valueOf(true)));
          
          Location pegou = p.getEyeLocation();
          
          BlockIterator Terrao = new BlockIterator(pegou, 0.0D, 40);
          while (Terrao.hasNext())
          {
            Location Terrao2 = Terrao.next().getLocation();
            
            Effect camelo = Effect.STEP_SOUND;
            
            p.playSound(p.getLocation(), Sound.STEP_GRASS, 5.5F, 5.5F);
            p.playSound(p.getLocation(), Sound.STEP_GRASS, 1.5F, 1.5F);
            p.playSound(p.getLocation(), Sound.STEP_GRASS, 2.5F, 2.5F);
            p.playSound(p.getLocation(), Sound.STEP_GRASS, 3.5F, 3.5F);
            p.playSound(p.getLocation(), Sound.STEP_GRASS, 4.5F, 4.5F);
            
            p.getWorld().playEffect(Terrao2, camelo, 2);
          }
          this.id1 = Bukkit.getScheduler().scheduleSyncDelayedTask(Otaku.Main.getPlugin(), new Runnable()
          {
            public void run()
            {
              if (ArrayL.Tempo.contains(p))
              {
                ArrayL.Tempo.remove(p);
                p.sendMessage("�6� �aVoce pode usar novamente!");
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 15.5F, 15.5F);
              }
            }
          }, 250L);
        }
        else
        {
          p.sendMessage("�7� �c Kit em Cooldown, Aguarde !");
        }
      }
      else
      {
        p.sendMessage(ChatColor.RED + "Voce pode usar esta habilidade apenas em areas com PVP.");
      }
    }
  }
  
  @EventHandler
  public void EntityDamageEvent111(EntityDamageByEntityEvent event)
  {
    Entity Tomou2 = event.getEntity();
    if ((event.getDamager() instanceof Snowball))
    {
      Snowball Tomou = (Snowball)event.getDamager();
      if (Tomou.hasMetadata("Terra"))
      {
        event.setDamage(14.0D);
        
        Vector vector = Tomou2.getLocation().getDirection();
        vector.multiply(-3.2F);
        Tomou2.setVelocity(vector);
      }
    }
  }
  
  @EventHandler
  public void drop(PlayerDropItemEvent e)
  {
    Player p = e.getPlayer();
    ItemStack item = e.getItemDrop().getItemStack();
    if ((ArrayL.Ferro2.contains(p.getName())) && (item.getType() == Material.WOOL)) {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void drop2(PlayerDropItemEvent e)
  {
    Player p = e.getPlayer();
    ItemStack item = e.getItemDrop().getItemStack();
    if ((ArrayL.AvatarH.contains(p.getName())) && (item.getType() == Material.LAPIS_BLOCK)) {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void drop3(PlayerDropItemEvent e)
  {
    Player p = e.getPlayer();
    ItemStack item = e.getItemDrop().getItemStack();
    if ((ArrayL.Red2.contains(p.getName())) && (item.getType() == Material.REDSTONE_BLOCK)) {
      e.setCancelled(true);
    }
  }
  @EventHandler
  public void drop4(PlayerDropItemEvent e)
  {
    Player p = e.getPlayer();
    ItemStack item = e.getItemDrop().getItemStack();
    if ((ArrayL.Terra2.contains(p.getName())) && (item.getType() == Material.GRASS)) {
      e.setCancelled(true);
    }
  }
}
