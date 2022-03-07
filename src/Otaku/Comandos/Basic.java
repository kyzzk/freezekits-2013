/*     */ package Otaku.Comandos;
/*     */ 
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.GameMode;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.enchantments.Enchantment;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.potion.PotionEffectType;

import Otaku.Main;
import Otaku.API.API;
import Otaku.Skill.ArrayL;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Basic
/*     */   implements CommandExecutor, Listener
/*     */ {
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String tag, String[] args)
/*     */   {
/*  36 */     if (!(sender instanceof Player)) {
/*  37 */       sender.sendMessage("§cVoce nao e um jogador");
/*  38 */       return true;
/*     */     }
/*  40 */     Player p = (Player)sender;
/*  41 */     if (tag.equalsIgnoreCase("gm")) {
/*  42 */       if (!p.hasPermission("kitpvp.admin")) {
/*  43 */         p.sendMessage(Main.m.getConfig().getString("SV").replace("&", "§") + "§cSem permissão!");
/*  44 */         return true;
/*     */       }
/*     */       
/*  47 */       if (args.length != 1)
/*     */       {
/*  49 */         p.sendMessage("§6» §7Digite Gm 1 ou Gm 0");
/*  50 */         return true;
/*     */       }
/*  52 */       if (args.length == 1)
/*     */       {
/*  54 */         if (args[0].equalsIgnoreCase("0"))
/*     */         {
/*  56 */           p.setGameMode(GameMode.SURVIVAL);
/*  57 */           p.sendMessage("§6»§7Modo de Jogo Alterado Para Sobrevivencia");
/*     */         }
/*  59 */         if (args[0].equalsIgnoreCase("1"))
/*     */         {
/*  61 */           p.setGameMode(GameMode.CREATIVE);
/*  62 */           p.sendMessage("§6»§7Modo de Jogo Alterado Para Criativo");
/*     */         }
/*     */         
/*  65 */         return true;
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/* 225 */     if ((cmd.getName().equalsIgnoreCase("resetkit")) && (p.hasPermission("kitpvp.admin")))
/*     */     {
/*     */ 
/*     */ 
/* 229 */       p.setHealth(20.0D);
/* 230 */       p.getInventory().clear();
/* 231 */       p.setExp(0.0F);
/* 232 */       p.setExp(0.0F);
/* 233 */       p.setExhaustion(20.0F);
/* 234 */       p.setMaxHealth(20.0D);
/* 235 */       p.setFoodLevel(20);
/*     */       
/*     */ 
/*     */ 
/* 239 */       p.getInventory().clear();
API.darItemsSpawn(p);
/*     */       
/*     */ 
/* 290 */       p.sendMessage(" §6»§7Kit removido.");
/*     */     }
/*     */     
/* 293 */     if (cmd.getName().equalsIgnoreCase("rdm")) {
/* 294 */       if (p.hasPermission("kitxc.pvp")) {
/* 295 */         if (Main.getPlugin().getConfig().getConfigurationSection("rdm") == null) {
/* 296 */           p.sendMessage("§cRDM Nao Setado!");
/* 297 */           return true;
/*     */         }
/*     */         
/*     */ 
/* 301 */         World w = Bukkit.getServer().getWorld(Main.getPlugin().getConfig().getString("rdm.world"));
/* 302 */         double x = Main.getPlugin().getConfig().getDouble("rdm.x");
/* 303 */         double y = Main.getPlugin().getConfig().getDouble("rdm.y");
/* 304 */         double z = Main.getPlugin().getConfig().getDouble("rdm.z");
/* 305 */         p.teleport(new Location(w, x, y, z));
/* 306 */         ItemStack espada = new ItemStack(Material.DIAMOND_SWORD);
/* 307 */         espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
/* 308 */         ItemStack capacete = new ItemStack(Material.IRON_HELMET);
/* 309 */         ItemStack peitoral = new ItemStack(Material.IRON_CHESTPLATE);
/* 310 */         ItemStack calca = new ItemStack(Material.IRON_LEGGINGS);
/* 311 */         ItemStack bota = new ItemStack(Material.IRON_BOOTS);
/* 312 */         p.getInventory().clear();
/* 313 */         p.getInventory().setItem(0, espada);
/* 314 */         p.getInventory().setHelmet(capacete);
/* 315 */         p.getInventory().setChestplate(peitoral);
/* 316 */         p.getInventory().setLeggings(calca);
/* 317 */         p.getInventory().setBoots(bota);
/* 318 */         API.darSopas(p);
/* 319 */         ArrayL.resetKit(p);
/*     */         
/*     */ 
/* 322 */         p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
/* 323 */         p.removePotionEffect(PotionEffectType.SPEED);
/*     */       }
}
/* 301 */         if (cmd.getName().equalsIgnoreCase("mdr")) {
	/* 294 */       if (p.hasPermission("kitxc.pvp")) {
		/* 295 */         if (Main.getPlugin().getConfig().getConfigurationSection("mdr") == null) {
		/* 296 */           p.sendMessage("§cMDR Nao Setado!");
		/* 297 */           return true;
		/*     */         }
		/*     */         
		/*     */ 
		/* 301 */         World w = Bukkit.getServer().getWorld(Main.getPlugin().getConfig().getString("mdr.world"));
		/* 302 */         double x = Main.getPlugin().getConfig().getDouble("mdr.x");
		/* 303 */         double y = Main.getPlugin().getConfig().getDouble("mdr.y");
		/* 304 */         double z = Main.getPlugin().getConfig().getDouble("mdr.z");
		/* 305 */         p.teleport(new Location(w, x, y, z));
		/* 306 */         ItemStack espada = new ItemStack(Material.WOOD_SWORD);
		/* 312 */         p.getInventory().clear();
		/* 313 */         p.getInventory().setItem(0, espada);
		/* 318 */         API.darSopas(p);
		/* 319 */         ArrayL.resetKit(p);
		/*     */         
		/*     */ 
		/* 322 */         p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
		/* 323 */         p.removePotionEffect(PotionEffectType.SPEED);
		/*     */       }
		}
				return false;
}
}