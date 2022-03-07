package Otaku.Warps;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import Otaku.Main;
import Otaku.API.API;
import Otaku.API.Title;
import Otaku.Eventos.MostrarHabilidades;
import Otaku.Skill.ArrayL;
import Otaku.Skill.AvatarSV;

public class Todas implements CommandExecutor{
	
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
		final Player p = (Player)sender;
	    if (cmd.getName().equalsIgnoreCase("setfps")) {
	      if (p.hasPermission("kitpvp.setar"))
	      {
	        Main.getPlugin().getConfig().set("fps.world", p.getLocation().getWorld().getName());
	        Main.getPlugin().getConfig().set("fps.x", Double.valueOf(p.getLocation().getX()));
	        Main.getPlugin().getConfig().set("fps.y", Double.valueOf(p.getLocation().getY()));
	        Main.getPlugin().getConfig().set("fps.z", Double.valueOf(p.getLocation().getZ()));
	        Main.getPlugin().saveConfig();
	        p.sendMessage(Main.m.getConfig().getString("SV").replace("&", "§") + " §6× §7Warp Setada Com Sucesso");
	        return true;
	      }
	    }
	    if (cmd.getName().equalsIgnoreCase("setlava")) {
	      if (p.hasPermission("kitpvp.setar"))
	      {
	    	  Main.getPlugin().getConfig().set("lava.world", p.getLocation().getWorld().getName());
	    	  Main.getPlugin().getConfig().set("lava.x", Double.valueOf(p.getLocation().getX()));
	    	  Main.getPlugin().getConfig().set("lava.y", Double.valueOf(p.getLocation().getY()));
	    	  Main.getPlugin().getConfig().set("lava.z", Double.valueOf(p.getLocation().getZ()));
	    	  Main.getPlugin().saveConfig();
	        p.sendMessage(Main.m.getConfig().getString("SV").replace("&", "§") + " §6× §7Warp Setada Com Sucesso");
	        return true;
	      }
	    }
	    if (cmd.getName().equalsIgnoreCase("setRDM")) {
	      if (p.hasPermission("kitpvp.setar"))
	      {
	    	  Main.getPlugin().getConfig().set("rdm.world", p.getLocation().getWorld().getName());
	    	  Main.getPlugin().getConfig().set("rdm.x", Double.valueOf(p.getLocation().getX()));
	    	  Main.getPlugin().getConfig().set("rdm.y", Double.valueOf(p.getLocation().getY()));
	    	  Main.getPlugin().getConfig().set("rdm.z", Double.valueOf(p.getLocation().getZ()));
	    	  Main.getPlugin().saveConfig();
	        p.sendMessage(Main.m.getConfig().getString("SV").replace("&", "§") + " §6× §7Warp Setada Com Sucesso");
	        return true;
	      }
	    }
	    if (cmd.getName().equalsIgnoreCase("setMDR")) {
	        if (p.hasPermission("kitpvp.setar"))
	        {
	        	 Main.getPlugin().getConfig().set("mdr.world", p.getLocation().getWorld().getName());
	        	 Main.getPlugin().getConfig().set("mdr.x", Double.valueOf(p.getLocation().getX()));
	        	 Main.getPlugin().getConfig().set("mdr.y", Double.valueOf(p.getLocation().getY()));
	        	 Main.getPlugin().getConfig().set("mdr.z", Double.valueOf(p.getLocation().getZ()));
	        	 Main.getPlugin().saveConfig();
	          p.sendMessage(Main.m.getConfig().getString("SV").replace("&", "§") + " §6× §7Warp Setada Com Sucesso");
	          return true;
	        }
	      }
	    if (cmd.getName().equalsIgnoreCase("setSpawn")) {
	      if (p.hasPermission("kitpvp.setar"))
	      {
	    	  Main.getPlugin().getConfig().set("spawn.world", p.getLocation().getWorld().getName());
	    	  Main.getPlugin().getConfig().set("spawn.x", Double.valueOf(p.getLocation().getX()));
	    	  Main.getPlugin().getConfig().set("spawn.y", Double.valueOf(p.getLocation().getY()));
	    	  Main.getPlugin().getConfig().set("spawn.z", Double.valueOf(p.getLocation().getZ()));
	        p.getWorld().setSpawnLocation(p.getLocation().getBlockX(), p.getLocation().getBlockY(), p.getLocation().getBlockZ());
	        Main.getPlugin().saveConfig();
	        p.sendMessage(API.prefix + " §6× §7Warp Setada Com Sucesso");
	        return true;
	      }
	    }
	    if (cmd.getName().equalsIgnoreCase("fps"))
	    {
	      if ( Main.getPlugin().getConfig().getConfigurationSection("fps") == null)
	      {
	        p.sendMessage("§cFps Nao Setado!");
	        return true;
	      }
	      World w = Bukkit.getServer().getWorld( Main.getPlugin().getConfig().getString("fps.world"));
	      double x =  Main.getPlugin().getConfig().getDouble("fps.x");
	      double y =  Main.getPlugin().getConfig().getDouble("fps.y");
	      double z =  Main.getPlugin().getConfig().getDouble("fps.z");
	      final Location lobby = new Location(w, x, y, z);
	      lobby.setPitch((float) Main.getPlugin().getConfig().getDouble("fps.pitch"));
	      lobby.setYaw((float) Main.getPlugin().getConfig().getDouble("fps.yaw"));
	      p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 500, 100));
	      p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 100));
	      p.sendMessage(Main.m.getConfig().getString("SV").replace("&", "§") + " §eAguarde você está sendo teleportado!");
	      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
	      {
	        public void run()
	        {
	        	p.teleport(lobby);
	      ItemStack espada = new ItemStack(Material.DIAMOND_SWORD);
	      espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
	      ItemStack capacete = new ItemStack(Material.IRON_HELMET);
	      ItemStack peitoral = new ItemStack(Material.IRON_CHESTPLATE);
	      ItemStack calca = new ItemStack(Material.IRON_LEGGINGS);
	      ItemStack bota = new ItemStack(Material.IRON_BOOTS);
	      p.getInventory().clear();
	    //  Title.sendTitle(p, "§6Warp");
	      MostrarHabilidades.setAbility(p, "Warp");
	      mlg.MLG.remove(p.getName());
	      
	   //   Title.sendSubTitle(p, "§7Fps");
	      p.getInventory().setItem(0, espada);
	      MostrarHabilidades.removeAbility(p);
	      p.getPlayer().playSound(p.getPlayer().getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
	      p.getInventory().setHelmet(capacete);
	      p.getInventory().setChestplate(peitoral);
	      p.getInventory().setLeggings(calca);
	      p.getInventory().setBoots(bota);
	      API.darSopas(p);
	      p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
	      p.removePotionEffect(PotionEffectType.SPEED);
	      ArrayL.resetKit(p);
	      for (PotionEffect effect : p.getActivePotionEffects()) {
	          p.removePotionEffect(effect.getType());
	      }
	        }
	    }, 90L);
	      }
	    if (cmd.getName().equalsIgnoreCase("knock"))
	    {
	      if ( Main.getPlugin().getConfig().getConfigurationSection("knock") == null)
	      {
	        p.sendMessage("§cKnock Nao Setado!");
	        return true;
	      }
	      World w = Bukkit.getServer().getWorld(Main.getPlugin().getConfig().getString("knock.world"));
	      double x =  Main.getPlugin().getConfig().getDouble("knock.x");
	      double y =  Main.getPlugin().getConfig().getDouble("knock.y");
	      double z =  Main.getPlugin().getConfig().getDouble("knock.z");
	      final Location lobby = new Location(w, x, y, z);
	      lobby.setPitch((float)Main.getPlugin().getConfig().getDouble("knock.pitch"));
	      lobby.setYaw((float)Main.getPlugin().getConfig().getDouble("knock.yaw"));
	      p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 500, 100));
	      p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 100));
	      p.sendMessage(Main.m.getConfig().getString("SV").replace("&", "§") + " §eAguarde você está sendo teleportado!");
	      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
	      {
	        public void run()
	        {
	        	p.teleport(lobby);
	      p.getInventory().clear();
	//      Title.sendTitle(p, "§6Warp ");
	      mlg.MLG.remove(p.getName());
	  //    Title.sendSubTitle(p, "§7Knock");
	      MostrarHabilidades.removeAbility(p);
	      MostrarHabilidades.setAbility(p, "Warp");
	      ItemStack bow71 = new ItemStack(Material.STICK);
	      ItemMeta bowmeta71 = bow71.getItemMeta();
	      bowmeta71.setDisplayName("§cWarp §7Knock");
	      bowmeta71.addEnchant(Enchantment.KNOCKBACK, 2, true);
	      bow71.setItemMeta(bowmeta71);
	      p.getInventory().setItem(0, bow71);
	      p.getInventory().setHelmet(null);
	      p.getInventory().setChestplate(null);
	      p.getInventory().setLeggings(null);
	      p.getInventory().setBoots(null);
	      p.getPlayer().playSound(p.getPlayer().getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
	      API.darSopas(p);
	      p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
	      p.removePotionEffect(PotionEffectType.SPEED);
	      ArrayL.resetKit(p);
	      for (PotionEffect effect : p.getActivePotionEffects()) {
	          p.removePotionEffect(effect.getType());
	      }
	        }
	    }, 90L);
	 }

	    if (cmd.getName().equalsIgnoreCase("mlg"))
	    {
	      if (Main.getPlugin().getConfig().getConfigurationSection("mlg") == null)
	      {
	        p.sendMessage("§cMlg Nao Setado!");
	        return true;
	      }
	      World w = Bukkit.getServer().getWorld(Main.getPlugin().getConfig().getString("mlg.world"));
	      double x = Main.getPlugin().getConfig().getDouble("mlg.x");
	      double y = Main.getPlugin().getConfig().getDouble("mlg.y");
	      double z = Main.getPlugin().getConfig().getDouble("mlg.z");
	      final Location lobby = new Location(w, x, y, z);
	      lobby.setPitch((float)Main.getPlugin().getConfig().getDouble("mlg.pitch"));
	      lobby.setYaw((float)Main.getPlugin().getConfig().getDouble("mlg.yaw"));
	      p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 500, 100));
	      p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 100));
	      p.sendMessage(Main.m.getConfig().getString("SV").replace("&", "§") + " §eAguarde você está sendo teleportado!");
	      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
	      {
	        public void run()
	        {
	        	p.teleport(lobby);
	      p.getInventory().clear();
	      API.setItem(p.getInventory(), 4, API.create(Material.WATER_BUCKET, 0, "§b§oMLG"));
	      API.som(p, Sound.LEVEL_UP, 2.0F);
	      p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
	      p.removePotionEffect(PotionEffectType.SPEED);
	      ArrayL.resetKit(p);
	      mlg.MLG.add(p.getName());
	      p.getInventory().setHelmet(null);
	      p.getInventory().setChestplate(null);
	      
	      MostrarHabilidades.setAbility(p, "Warp");
	      p.getInventory().setLeggings(null);
	      p.getInventory().setBoots(null);
	      for (PotionEffect effect : p.getActivePotionEffects()) {
	          p.removePotionEffect(effect.getType());
	      }
	        }
	    }, 20L);
	      }
	    if (cmd.getName().equalsIgnoreCase("spawn"))
	    {
	      if (Main.getPlugin().getConfig().getConfigurationSection("spawn") == null)
	      {
	        p.sendMessage("§cSpawn Nao Setado!");
	        return true;
	      }   
	      World w = Bukkit.getServer().getWorld(Main.getPlugin().getConfig().getString("spawn.world"));
	      double x = Main.getPlugin().getConfig().getDouble("spawn.x");
	      double y = Main.getPlugin().getConfig().getDouble("spawn.y");
	      double z = Main.getPlugin().getConfig().getDouble("spawn.z");
	      final Location lobby = new Location(w, x, y, z);
	      lobby.setPitch((float)Main.getPlugin().getConfig().getDouble("spawn.pitch"));
	      lobby.setYaw((float)Main.getPlugin().getConfig().getDouble("spawn.yaw"));
	      p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 500, 100));
	      p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 100));
	      p.sendMessage(Main.m.getConfig().getString("SV").replace("&", "§") + " §eAguarde você está sendo teleportado!");
	      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
	      {
	        public void run()
	        {
	        	p.teleport(lobby);
	      p.setHealth(20);
	  //   Title.sendTitle(p, "§6Bem Vindo");
	     // Title.sendSubTitle(p, "§7Spawn");
	      MostrarHabilidades.removeAbility(p);
	      p.getInventory().clear();
	      p.setExp(0.0F);
	      p.setLevel(0);
	      mlg.MLG.remove(p.getName());
	      p.setExhaustion(20.0F);
	      p.getPlayer().playSound(p.getPlayer().getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
	      p.setMaxHealth(20.0D);
	      p.setFoodLevel(20);
	      p.setGameMode(GameMode.ADVENTURE);
	      p.setAllowFlight(false);
	      ArrayL.resetKit(p);
	      MostrarHabilidades.setAbility(p, "Spawn");
	      AvatarSV.cooldown.remove(p);
	      ArrayL.resetKit(p);
	      API.darItemsSpawn(p);
	      
	      p.getInventory().setHelmet(null);
	      p.getInventory().setChestplate(null);
	      p.getInventory().setLeggings(null);
	      p.getInventory().setBoots(null);
	      
	      p.getInventory().setArmorContents(null);
	      p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
	      p.removePotionEffect(PotionEffectType.SPEED);
	      for (PotionEffect effect : p.getActivePotionEffects()) {
	          p.removePotionEffect(effect.getType());
	        }
	      }
	    }, 90L);
	  }
	    if (cmd.getName().equalsIgnoreCase("lava"))
	    {
	      if (Main.getPlugin().getConfig().getConfigurationSection("lava") == null)
	      {
	        p.sendMessage("§cLava Challeng Nao Setado!");
	        return true;
	      }
	        World w = Bukkit.getServer().getWorld(Main.getPlugin().getConfig().getString("lava.world"));
	        double x = Main.getPlugin().getConfig().getDouble("lava.x");
	        double y = Main.getPlugin().getConfig().getDouble("lava.y");
	        double z = Main.getPlugin().getConfig().getDouble("lava.z");
	        final Location lobby = new Location(w, x, y, z);
	        lobby.setPitch((float)Main.getPlugin().getConfig().getDouble("lava.pitch"));
	        lobby.setYaw((float)Main.getPlugin().getConfig().getDouble("lava.yaw"));
	        p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 500, 100));
	        p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 100));
	        p.sendMessage(Main.m.getConfig().getString("SV").replace("&", "§") + " §eAguarde você está sendo teleportado!");
	        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
	        {
	          public void run()
	          {
	        	  p.teleport(lobby);
	        MostrarHabilidades.removeAbility(p);
	        ArrayL.resetKit(p);
	    //    Title.sendTitle(p, "§6Warp");
	      //  Title.sendSubTitle(p, "§7Lava");
	        mlg.MLG.remove(p.getName());
	        MostrarHabilidades.setAbility(p, "Warp");
	        p.getInventory().clear();
	        API.darRecraft(p);
	        
	        p.getPlayer().playSound(p.getPlayer().getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
	        p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
	        p.removePotionEffect(PotionEffectType.SPEED);
	        for (PotionEffect effect : p.getActivePotionEffects()) {
	            p.removePotionEffect(effect.getType());
	          }
	        }
	      }, 90L);
	        }
	    return false;
	  }
}
