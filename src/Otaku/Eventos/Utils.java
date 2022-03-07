/*      */ package Otaku.Eventos;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
import java.util.Iterator;
/*      */ import java.util.List;

/*      */ import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
/*      */ import org.bukkit.GameMode;
/*      */ import org.bukkit.Location;
/*      */ import org.bukkit.Material;
import org.bukkit.Sound;
/*      */ import org.bukkit.block.BlockFace;
/*      */ import org.bukkit.block.Sign;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
/*      */ import org.bukkit.entity.Player;
/*      */ import org.bukkit.event.EventHandler;
/*      */ import org.bukkit.event.EventPriority;
/*      */ import org.bukkit.event.Listener;
/*      */ import org.bukkit.event.block.Action;
/*      */ import org.bukkit.event.block.BlockBreakEvent;
/*      */ import org.bukkit.event.block.BlockIgniteEvent;
/*      */ import org.bukkit.event.block.BlockPlaceEvent;
/*      */ import org.bukkit.event.block.SignChangeEvent;
/*      */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*      */ import org.bukkit.event.entity.EntityDamageEvent;
/*      */ import org.bukkit.event.entity.FoodLevelChangeEvent;
/*      */ import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
/*      */ import org.bukkit.event.player.AsyncPlayerChatEvent;
/*      */ import org.bukkit.event.player.PlayerCommandPreprocessEvent;
/*      */ import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
/*      */ import org.bukkit.event.player.PlayerJoinEvent;
/*      */ import org.bukkit.event.player.PlayerLoginEvent;
/*      */ import org.bukkit.event.player.PlayerMoveEvent;
/*      */ import org.bukkit.event.player.PlayerQuitEvent;
/*      */ import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.server.ServerListPingEvent;
/*      */ import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.help.HelpTopic;
/*      */ import org.bukkit.inventory.Inventory;
/*      */ import org.bukkit.inventory.ItemStack;
/*      */ import org.bukkit.inventory.meta.ItemMeta;
/*      */ import org.bukkit.potion.PotionEffect;
/*      */ import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import Otaku.Main;
import Otaku.API.API;
import Otaku.API.BarAPI;
import Otaku.API.KitAPI;
import Otaku.Files.Stats;
import Otaku.Skill.ArrayL;
import Otaku.Warps.mlg;
import ca.wacos.nametagedit.NametagAPI;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class Utils
/*      */   implements Listener
/*      */ {
	
	public static Main plugin;
	public static HashMap<String, String> bars = new HashMap<String, String>();
	private static Stats s = Stats.getClasse();
	
	
/*      */   @EventHandler
/*      */   public void Death(final PlayerDeathEvent e)
/*      */   {
/*   75 */     Player p = e.getEntity();
/*   76 */     e.setDeathMessage(null);
Otaku.Skill.AvatarSV.cooldown.remove(p);
mlg.MLG.remove(p.getName());
/*      */     p.removePotionEffect(PotionEffectType.INVISIBILITY);
               p.removePotionEffect(PotionEffectType.POISON);
               p.getInventory().setArmorContents(null);
API.darItemsSpawn(p);
/*   84 */     e.setDeathMessage(null);
MostrarHabilidades.removeAbility(p);
/*   85 */     e.setDroppedExp(0);
Main.getPlugin().getConfig().getInt("status." + p.getName().toLowerCase() + ".streak");
/*   87 */     Main.getPlugin().getConfig().set("status." + p.getName().toLowerCase() + ".streak", Integer.valueOf(0));
/*      */     
/*   89 */     Otaku.Skill.ArrayL.resetKit(p);
/*   90 */     e.getDrops().clear();
new BukkitRunnable() {
	
		@Override
		public void run() {
			if(e.getEntity() instanceof Player){
				e.getEntity().spigot().respawn();
			}
		}
}.runTask(Main.getPlugin());
}
/*      */   

@EventHandler
public void onOpen(PlayerInteractEvent e){
Player player = e.getPlayer();
if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
if(e.getClickedBlock().getType().equals(Material.ENDER_CHEST)){
e.setCancelled(true);
				 player.sendMessage("§aCaixa Aberta");
 }
 }
}


@EventHandler
public void onLoginEvent(PlayerLoginEvent e)
{
  Player p = e.getPlayer();
  if (p.getName().length() >= 30)
  {
    e.disallow(PlayerLoginEvent.Result.KICK_OTHER, "§cSeu nick  muito grande!");
    return;
  }
  if ((p.getName().contains("'")) || (p.getName().contains("~")) || (p.getName().contains("^")) || (p.getName().contains(":")) || (p.getName().contains("?")) || (p.getName().contains("=")) || (p.getName().contains("-")) || (p.getName().contains("(")) || (p.getName().contains(")")) || (p.getName().contains("+")) || (p.getName().contains("*")) || (p.getName().contains("§")) || (p.getName().contains("%")) || (p.getName().contains("$")) || (p.getName().contains("#")) || (p.getName().contains("@")) || (p.getName().contains("!")) || (p.getName().contains("`")))
  {
    e.disallow(PlayerLoginEvent.Result.KICK_OTHER, "§cSeu nick possui caracter's invalidas!\nuse nicks com apenas numeros e letras!");
    return;
  }
}

/*      */   @EventHandler
/*      */   public void Quit(PlayerQuitEvent e) {
/*   95 */     Player p = e.getPlayer();
MostrarHabilidades.removeAbility(p);
/*  102 */     e.setQuitMessage(null);
/*  103 */     Otaku.Skill.ArrayL.resetKit(p);
/*      */   }
/*      */   
/*      */   @EventHandler
/*  107 */   public void Respawn(PlayerRespawnEvent e) { Player p = e.getPlayer();
/*  108 */     p.getInventory().clear();
/*  109 */     p.teleport(p.getWorld().getSpawnLocation());
/*  110 */     p.getInventory().clear();
/*  111 */     p.setExp(0.0F);
/*  112 */     p.setExp(0.0F);
mlg.MLG.remove(p.getName());
/*  113 */     p.setExhaustion(20.0F);
/*  114 */     p.setMaxHealth(20.0D);
/*  115 */     p.setFoodLevel(20);
/*  116 */     p.setGameMode(GameMode.SURVIVAL);
/*      */     
API.darItemsSpawn(p);
/*  165 */     Otaku.Skill.ArrayL.resetKit(p);
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  174 */     for (PotionEffect effect : p.getActivePotionEffects()) {
/*  175 */       p.removePotionEffect(effect.getType());
/*      */     }
/*  177 */     p.teleport(p.getWorld().getSpawnLocation());
/*  178 */     p.getInventory().setArmorContents(null);
/*      */   }
/*      */   @EventHandler
/*      */   public void nuncaChover(WeatherChangeEvent evento)
/*      */   {
/*  184 */     evento.setCancelled(true);
/*      */   }
/*      */   

/*      */   
@EventHandler(priority=EventPriority.LOWEST)
public void falarChatColorido(AsyncPlayerChatEvent e)
{
  Player p = e.getPlayer();
  if (!p.hasPermission("kit.falarcolorido")) {
    return;
  }
  String msg = e.getMessage();
  msg = msg.replace("&", "§");
  
  e.setMessage(msg);
}


/*      */   @EventHandler
/*      */   public void nuncaFome(FoodLevelChangeEvent evento) {
/*  194 */     evento.setFoodLevel(20);
/*      */   }

@EventHandler
public void ServerListPing(ServerListPingEvent e)
{
  e.setMotd("\u00A77           \u00A76•  \u00A7bFreeze\u00A77 - \u00A7fKits  \u00A76•  \n    \u00A7cVenha Superar Seus Desafios !");
}

@EventHandler
public void onPlayerKit(EntityDamageByEntityEvent e) {
	   if (!(e.getEntity() instanceof Player)) {
	   return;
	   }
	   if (!(e.getDamager() instanceof Player)) {
	   return;
	   }
	   final Player t = (Player)e.getEntity();
	   final Player p = (Player)e.getDamager();
	   final String KitName = MostrarHabilidades.NomeDoKit(MostrarHabilidades.getAbility(t));
	   BarAPI.setName(p, "§e" + t.getName() + "§7 - Kit " + KitName, 400L);
	   Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
	   public void run() {
	   BarAPI.removeBar(p);
	   }
	   }, 80L);
	   return;
	   
}

@EventHandler(priority=EventPriority.MONITOR)
public void onPlayerJoin(PlayerJoinEvent e)
{
  Player p = e.getPlayer();
  Player p1 = e.getPlayer();
  if (p1.hasPermission("tag.dono"))
  {
    p1.setPlayerListName(ChatColor.DARK_RED + p1.getName());
    p1.setDisplayName("§4GER §4" + p.getName() + ChatColor.RESET);
    NametagAPI.setPrefix(p1.getName(), "§4");
  }
  else if (p1.hasPermission("tag.youtuber"))
  {
    p1.setPlayerListName("§b§o" + p1.getName());
    p1.setDisplayName("§b§lYT §b" + p.getName() + ChatColor.RESET);
    NametagAPI.setPrefix(p1.getName(), "§b§o");
  }

  else if (p1.hasPermission("tag.admin"))
  {
    p1.setPlayerListName("§c§o" + p1.getName());
    p1.setDisplayName("§c§lADM §c" + p.getName() + ChatColor.RESET);
    NametagAPI.setPrefix(p1.getName(), "§c§o");
  }
  else if (p1.hasPermission("tag.mod"))
  {
    p1.setPlayerListName("§5§o" + p1.getName());
    p1.setDisplayName("§5§lMOD §5" + p.getName() + ChatColor.RESET);
    NametagAPI.setPrefix(p1.getName(), "§5§o");
  }
  else if (p1.hasPermission("tag.trial"))
  {
    p1.setPlayerListName("§d§o" + p1.getName());
    p1.setDisplayName("§d§lTRIAL §d" + p.getName() + ChatColor.RESET);
    NametagAPI.setPrefix(p1.getName(), "§d§o");
  }
  else if (p1.hasPermission("tag.pro"))
  {
    p1.setPlayerListName(ChatColor.GOLD + p1.getName());
    p1.setDisplayName("§6§oPRO §6" + p.getName() + ChatColor.RESET);
    NametagAPI.setPrefix(p1.getName(), "§6");
  }
  else if (p1.hasPermission("tag.mvp"))
  {
    p1.setPlayerListName(ChatColor.GOLD + p1.getName());
    p1.setDisplayName("§9§lMVP §9" + p.getName() + ChatColor.RESET);
    NametagAPI.setPrefix(p1.getName(), "§9");
  }
  else
  {
    p1.setPlayerListName(ChatColor.WHITE + p1.getName());
    p1.setDisplayName(ChatColor.WHITE + p1.getName() + ChatColor.RESET);
    NametagAPI.setPrefix(p1.getName(), "§f");
  }
}


@EventHandler
public void entityDamagePedra(EntityDamageByEntityEvent e)
{
  if (((e.getDamager() instanceof Player)) && 
    (((Player)e.getDamager() instanceof Player)))
  {
    Player p = (Player)e.getDamager();
    if (((e.getEntity() instanceof Player)) && 
      (p.getItemInHand().getType() == Material.STONE_SWORD)){
      e.setDamage(e.getDamage() * 0.6D);
       return;
        }
    if(p.getItemInHand().getType() == Material.WOOD_SWORD){
      e.setDamage(e.getDamage() * 0.5D);
       return;
    }
    }
  }
/*      */   @EventHandler
/*      */   public void onEntityDamageByEntity1(EntityDamageByEntityEvent e)
/*      */   {
/*  279 */     if ((e.getDamager() instanceof Player))
/*      */     {
/*  281 */       Player d = (Player)e.getDamager();
/*  282 */       if ((d.getItemInHand().getType() == Material.DIAMOND_SWORD) || 
/*  283 */         (d.getItemInHand().getType() == Material.WOOD_SWORD) || 
                   (d.getItemInHand().getType() == Material.STONE_AXE) || 
/*  284 */         (d.getItemInHand().getType() == Material.STONE_SWORD) || 
/*  285 */         (d.getItemInHand().getType() == Material.IRON_SWORD) || 
/*  287 */         (d.getItemInHand().getType() == Material.FISHING_ROD) || 
/*  288 */         (d.getItemInHand().getType() == Material.WOOD_AXE))
/*  289 */         d.getItemInHand().setDurability((short)0);
/*      */     }
/*      */   }
/*      */   @EventHandler
/*      */   public void onEntityDamage(EntityDamageEvent e) {
/*  295 */     if ((e.getEntity() instanceof Player))
/*      */     {
/*  297 */       Player p = (Player)e.getEntity();
/*  298 */       if (p.getInventory().getChestplate() != null) {
/*  299 */         p.getInventory().getChestplate().setDurability((short)0);
/*      */       }
/*  301 */       if (p.getInventory().getBoots() != null) {
/*  302 */         p.getInventory().getBoots().setDurability((short)0);
/*      */       }
/*  304 */       if (p.getInventory().getLeggings() != null) {
/*  305 */         p.getInventory().getLeggings().setDurability((short)0);
/*      */       }
/*  307 */       if (p.getInventory().getHelmet() != null)
/*  308 */         p.getInventory().getHelmet().setDurability((short)0);
/*      */     }
/*      */   }


@EventHandler
public void antBreak(EntityDamageByEntityEvent e)
{
  if ((e.getEntity().getType() == EntityType.PLAYER) && 
    (e.getDamager().getType() == EntityType.PLAYER))
  {
    Player p = (Player)e.getDamager();
    Player b = (Player)e.getEntity();
    if ((p.getItemInHand().getType() == Material.WOOD_SWORD) || 
      (p.getItemInHand().getType() == Material.STONE_SWORD) || 
      (p.getItemInHand().getType() == Material.IRON_SWORD) || 
      (p.getItemInHand().getType() == Material.GOLD_SWORD) || 
      (p.getItemInHand().getType() == Material.DIAMOND_SWORD) || 
      (p.getItemInHand().getType() == Material.STONE_AXE) || 
      (p.getItemInHand().getType() == Material.BOW) || 
      (p.getItemInHand().getType() == Material.WOOD_AXE)) {
      p.getItemInHand().setDurability((short)0);
    }
    if ((b.getItemInHand().getType() == Material.WOOD_SWORD) || 
      (b.getItemInHand().getType() == Material.STONE_SWORD) || 
      (b.getItemInHand().getType() == Material.IRON_SWORD) || 
      (b.getItemInHand().getType() == Material.GOLD_SWORD) || 
      (b.getItemInHand().getType() == Material.DIAMOND_SWORD) || 
      (b.getItemInHand().getType() == Material.STONE_AXE) || 
      (p.getItemInHand().getType() == Material.BOW) || 
      (b.getItemInHand().getType() == Material.WOOD_AXE)) {
      b.getItemInHand().setDurability((short)0);
    }
    ItemStack[] arrayOfItemStack;
    int j = (arrayOfItemStack = p.getEquipment().getArmorContents()).length;
    for (int i = 0; i < j; i++)
    {
      ItemStack is = arrayOfItemStack[i];
      try
      {
        is.setDurability((short)0);
      }
      catch (NullPointerException localNullPointerException) {}
    }
    j = (arrayOfItemStack = b.getEquipment().getArmorContents()).length;
    for (int i = 0; i < j; i++)
    {
      ItemStack is = arrayOfItemStack[i];
      try
      {
        is.setDurability((short)0);
      }
      catch (NullPointerException localNullPointerException1) {}
    }
  }
}
@EventHandler
public void antBreak2(PlayerInteractEvent e)
{
  Player p = e.getPlayer();
  if ((p.getItemInHand().getType() == Material.WOOD_SWORD) || 
    (p.getItemInHand().getType() == Material.STONE_SWORD) || 
    (p.getItemInHand().getType() == Material.IRON_SWORD) || 
    (p.getItemInHand().getType() == Material.GOLD_SWORD) || 
    (p.getItemInHand().getType() == Material.DIAMOND_SWORD) || 
    (p.getItemInHand().getType() == Material.STONE_AXE) || 
    (p.getItemInHand().getType() == Material.BOW) || 
    (p.getItemInHand().getType() == Material.WOOD_AXE)) {
    p.getItemInHand().setDurability((short)0);
  }
  ItemStack[] arrayOfItemStack;
  int j = (arrayOfItemStack = p.getEquipment().getArmorContents()).length;
  for (int i = 0; i < j; i++)
  {
    ItemStack is = arrayOfItemStack[i];
    try
    {
      is.setDurability((short)0);
    }
    catch (NullPointerException localNullPointerException) {}
  }
}

@EventHandler
public void antBreak3(PlayerItemBreakEvent e)
{
  Player p = e.getPlayer();
  if ((p.getItemInHand().getType() == Material.WOOD_SWORD) || 
    (p.getItemInHand().getType() == Material.STONE_SWORD) || 
    (p.getItemInHand().getType() == Material.IRON_SWORD) || 
    (p.getItemInHand().getType() == Material.GOLD_SWORD) || 
    (p.getItemInHand().getType() == Material.DIAMOND_SWORD) || 
    (p.getItemInHand().getType() == Material.STONE_AXE) || 
    (p.getItemInHand().getType() == Material.BOW) || 
    (p.getItemInHand().getType() == Material.WOOD_AXE)) {
    p.getItemInHand().setDurability((short)0);
  }
  ItemStack[] arrayOfItemStack;
  int j = (arrayOfItemStack = p.getEquipment().getArmorContents()).length;
  for (int i = 0; i < j; i++)
  {
    ItemStack is = arrayOfItemStack[i];
    try
    {
      is.setDurability((short)0);
    }
    catch (NullPointerException localNullPointerException) {}
  }
}
/*      */   
/*      */   @EventHandler
/*      */   public void placaColorida(SignChangeEvent sign) {
/*  396 */     Player player = sign.getPlayer();
/*  397 */     if (player.hasPermission("kitKits.sign"))
/*      */     {
/*  399 */       if ((sign.getLine(0).contains("&1")) || (sign.getLine(0).contains("&2")) || (sign.getLine(0).contains("&3")) || (sign.getLine(0).contains("&4")) || (sign.getLine(0).contains("&5")) || (sign.getLine(0).contains("&6")) || (sign.getLine(0).contains("&7")) || (sign.getLine(0).contains("&8")) || (sign.getLine(0).contains("&9")) || (sign.getLine(0).contains("&0")) || (sign.getLine(0).contains("&a")) || (sign.getLine(0).contains("&b")) || (sign.getLine(0).contains("&c")) || (sign.getLine(0).contains("&d")) || (sign.getLine(0).contains("&e")) || (sign.getLine(0).contains("&f")) || (sign.getLine(0).contains("&o")) || (sign.getLine(0).contains("&l")) || (sign.getLine(0).contains("&k")) || (sign.getLine(0).contains("&n")) || (sign.getLine(0).contains("&m")) || (sign.getLine(0).contains("&r"))) {
/*  400 */         sign.setLine(0, sign.getLine(0).replace("&", "§"));
/*      */       }
/*  402 */       if ((sign.getLine(1).contains("&1")) || (sign.getLine(1).contains("&2")) || (sign.getLine(1).contains("&3")) || (sign.getLine(1).contains("&4")) || (sign.getLine(1).contains("&5")) || (sign.getLine(1).contains("&6")) || (sign.getLine(1).contains("&7")) || (sign.getLine(1).contains("&8")) || (sign.getLine(1).contains("&9")) || (sign.getLine(1).contains("&0")) || (sign.getLine(1).contains("&a")) || (sign.getLine(1).contains("&b")) || (sign.getLine(1).contains("&c")) || (sign.getLine(1).contains("&d")) || (sign.getLine(1).contains("&e")) || (sign.getLine(1).contains("&f")) || (sign.getLine(1).contains("&o")) || (sign.getLine(1).contains("&l")) || (sign.getLine(1).contains("&k")) || (sign.getLine(1).contains("&n")) || (sign.getLine(1).contains("&m")) || (sign.getLine(1).contains("&r"))) {
/*  403 */         sign.setLine(1, sign.getLine(1).replace("&", "§"));
/*      */       }
/*  405 */       if ((sign.getLine(2).contains("&1")) || (sign.getLine(2).contains("&2")) || (sign.getLine(2).contains("&3")) || (sign.getLine(2).contains("&4")) || (sign.getLine(2).contains("&5")) || (sign.getLine(2).contains("&6")) || (sign.getLine(2).contains("&7")) || (sign.getLine(2).contains("&8")) || (sign.getLine(2).contains("&9")) || (sign.getLine(2).contains("&0")) || (sign.getLine(2).contains("&a")) || (sign.getLine(2).contains("&b")) || (sign.getLine(2).contains("&c")) || (sign.getLine(2).contains("&d")) || (sign.getLine(2).contains("&e")) || (sign.getLine(2).contains("&f")) || (sign.getLine(2).contains("&o")) || (sign.getLine(2).contains("&l")) || (sign.getLine(2).contains("&k")) || (sign.getLine(2).contains("&n")) || (sign.getLine(2).contains("&m")) || (sign.getLine(2).contains("&r"))) {
/*  406 */         sign.setLine(2, sign.getLine(2).replace("&", "§"));
/*      */       }
/*  408 */       if ((sign.getLine(3).contains("&1")) || (sign.getLine(3).contains("&2")) || (sign.getLine(3).contains("&3")) || (sign.getLine(3).contains("&4")) || (sign.getLine(3).contains("&5")) || (sign.getLine(3).contains("&6")) || (sign.getLine(3).contains("&7")) || (sign.getLine(3).contains("&8")) || (sign.getLine(3).contains("&9")) || (sign.getLine(3).contains("&0")) || (sign.getLine(3).contains("&a")) || (sign.getLine(3).contains("&b")) || (sign.getLine(3).contains("&c")) || (sign.getLine(3).contains("&d")) || (sign.getLine(3).contains("&e")) || (sign.getLine(3).contains("&f")) || (sign.getLine(3).contains("&o")) || (sign.getLine(3).contains("&l")) || (sign.getLine(3).contains("&k")) || (sign.getLine(3).contains("&n")) || (sign.getLine(3).contains("&m")) || (sign.getLine(3).contains("&r"))) {
/*  409 */         sign.setLine(3, sign.getLine(3).replace("&", "§"));
/*      */       }
/*      */     }
/*      */   }
/*      */  
/*      */ 
/*  499 */   ArrayList<String> mecheu = new ArrayList<String>();

/*      */   
/*      */   @EventHandler
/*      */   public void onPlayer(PlayerMoveEvent e) {
/*  503 */     Player p = e.getPlayer();
/*  504 */     if ((KitAPI.getKit(p).equals("Spawn")) && 
/*  505 */       (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.DIAMOND_ORE))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*  561 */       API.teleport(p, API.getLocationWarp("Lobby"));
/*      */       
/*      */ 
/*      */ 
/*  565 */       p.setGameMode(GameMode.SURVIVAL);
/*  566 */       p.sendMessage(API.prefix + "§aVoce obteve 1000 Valis por completar o Parkour.");
/*  567 */       p.teleport(p.getWorld().getSpawnLocation());
/*  568 */       s.addValis(p, 1000);
/*      */     }
/*      */   }
public static String getShortStr(String s)
{
  if (s.length() == 16)
  {
    String shorts = s.substring(0, s.length() - 6);
    return shorts;
  }
  if (s.length() == 15)
  {
    String shorts = s.substring(0, s.length() - 5);
    return shorts;
  }
  if (s.length() == 14)
  {
    String shorts = s.substring(0, s.length() - 4);
    return shorts;
  }
  if (s.length() == 13)
  {
    String shorts = s.substring(0, s.length() - 4);
    return shorts;
  }
  if (s.length() == 12)
  {
    String shorts = s.substring(0, s.length() - 2);
    return shorts;
  }
  if (s.length() == 11)
  {
    String shorts = s.substring(0, s.length() - 1);
    return shorts;
  }
  return s;
}
/*      */ 
/*      */   
/*      */   
/*      */   
/*      */   @EventHandler(priority=EventPriority.HIGHEST)
/*      */   public void onPlayerLogin(PlayerLoginEvent e)
/*      */   {
/*  802 */     if (e.getResult() == PlayerLoginEvent.Result.KICK_FULL)
/*      */     {
/*      */ 
/*  805 */       e.setKickMessage("§cServidor esta Lotado\n§cAdquira §cVIP §cPara poder entrar\n" + Main.m.getConfig().getString("SV").replace("&", "§"));
/*      */     }
/*  807 */     if (e.getResult() == PlayerLoginEvent.Result.KICK_WHITELIST)
/*      */     {
/*      */ 
/*  810 */       e.setKickMessage("§cServidor Em Manutençao \n\n Porfavor Aguarde ");
/*      */     }
}
/*      */   
/*      */    @EventHandler
public void onJoinFull(PlayerLoginEvent e)
{
  Player p = e.getPlayer();
  if ((e.getResult() == PlayerLoginEvent.Result.KICK_FULL) && (
    (p.hasPermission("kitpvp.cheio") && (p.hasPermission("tag.pro")) || (p.hasPermission("tag.mvp")) || (p.hasPermission("tag.youtuber") || (p.hasPermission("kitpvp.admin")))))) {
    e.allow();
  }
}
/*      */   
/*      */ 
/*      */ 
/*      */   @EventHandler
/*      */   public void onSignChangeSoup(SignChangeEvent event)
/*      */   {
/*  837 */     if (event.getLine(0).equals("sopas"))
/*      */     {
/*  839 */       event.setLine(0, "=======");
/*  840 */       event.setLine(1, Main.m.getConfig().getString("SV").replace("&", "§"));
/*  841 */       event.setLine(2, "§eSopas");
/*  842 */       event.setLine(3, "=======");
/*      */     }
/*      */   }
/*      */   
/*      */   @EventHandler
/*      */   public void SignClickEvent(PlayerInteractEvent e) {
/*  848 */     ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
/*  849 */     ItemMeta sopas = sopa.getItemMeta();
/*  850 */     sopas.setDisplayName("§eSopinha");
/*  851 */     sopa.setItemMeta(sopas);
/*  852 */     if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) && (
/*  853 */       (e.getClickedBlock().getType() == Material.SIGN) || 
/*  854 */       (e.getClickedBlock().getType() == Material.SIGN_POST) || 
/*  855 */       (e.getClickedBlock().getType() == Material.WALL_SIGN)))
/*      */     {
/*  857 */       Sign sign = (Sign)e.getClickedBlock().getState();
/*  858 */       if ((sign.getLine(0).equalsIgnoreCase("=======")) && 
/*  859 */         (sign.getLine(1).equalsIgnoreCase(Main.m.getConfig().getString("SV").replace("&", "§"))) && 
/*  860 */         (sign.getLine(2).equalsIgnoreCase("§eSopas")) && 
/*  861 */         (sign.getLine(3).equalsIgnoreCase("=======")))
/*      */       {
/*  863 */         Inventory v = Bukkit.createInventory(null, 54, "§cSopas");
/*  864 */         for (int i = 0; i < 54; i++) {
/*  865 */           v.addItem(new ItemStack[] { new ItemStack(sopa) });
/*      */         }
/*  867 */         e.getPlayer().openInventory(v);
/*      */       }
/*      */     }
/*      */   }
/*      */  

@EventHandler
public void move(EntityDamageEvent event)
{
  if (event.getCause() == EntityDamageEvent.DamageCause.VOID) {
    event.setDamage(30.0D);
  }
}
@EventHandler
/*      */   public void onrecraft(SignChangeEvent event)
/*      */   {
/*  837 */     if (event.getLine(0).equals("recraft"))
/*      */     {
/*  839 */       event.setLine(0, "======");
/*  840 */       event.setLine(1, Main.m.getConfig().getString("SV").replace("&", "§"));
/*  841 */       event.setLine(2, "§cRecraft");
/*  842 */       event.setLine(3, "======");
/*      */     }
/*      */   }
/*      */   
/*      */   @EventHandler
/*      */   public void SignClickEvent1(PlayerInteractEvent e) {
/*  886 */     ItemStack sopas = new ItemStack(Material.BOWL, 64);
/*  887 */     ItemMeta sopameta = sopas.getItemMeta();
/*  888 */     sopameta.setDisplayName("§8§oTigela");
/*  889 */     sopas.setItemMeta(sopameta);
/*      */     
/*  891 */     ItemStack recraft1 = new ItemStack(Material.BROWN_MUSHROOM, 64);
/*  892 */     ItemMeta recraft1meta = recraft1.getItemMeta();
/*  893 */     recraft1meta.setDisplayName("§b§oCogumelo marrom");
/*  894 */     recraft1.setItemMeta(recraft1meta);


               ItemStack recraft11 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
/*  892 */     ItemMeta recraft1meta1 = recraft11.getItemMeta();
/*  893 */     recraft1meta1.setDisplayName(API.prefix);
/*  894 */     recraft11.setItemMeta(recraft1meta1);
/*      */     
/*  896 */     ItemStack recraft = new ItemStack(Material.RED_MUSHROOM, 64);
/*  897 */     ItemMeta recraftmeta = recraft.getItemMeta();
/*  898 */     recraftmeta.setDisplayName("§c§oCogumelo vermelho");
/*  899 */     recraft.setItemMeta(recraftmeta);
{
                 if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) && (
/*  901 */       (e.getClickedBlock().getType() == Material.SIGN) || 
/*  902 */       (e.getClickedBlock().getType() == Material.SIGN_POST) || 
/*  903 */       (e.getClickedBlock().getType() == Material.WALL_SIGN)))
/*      */     {
/*  905 */       Sign sign = (Sign)e.getClickedBlock().getState();
/*  906 */       if ((sign.getLine(0).equalsIgnoreCase("======")) && 
/*  907 */         (sign.getLine(1).equalsIgnoreCase(Main.m.getConfig().getString("SV").replace("&", "§"))) && 
/*  908 */         (sign.getLine(2).equalsIgnoreCase("§cRecraft")) && 
/*  909 */         (sign.getLine(3).equalsIgnoreCase("======")))
/*      */       {
/*  911 */         Inventory inv = Bukkit.createInventory(null, 9, "§cRecraft");
/*      */         
/*  913 */         inv.setItem(0, recraft11);
/*  914 */         inv.setItem(1, recraft11);
/*  915 */         inv.setItem(2, recraft11);
/*  916 */         inv.setItem(3, sopas);
/*  917 */         inv.setItem(4, recraft);
/*  918 */         inv.setItem(5, recraft1);
/*  919 */         inv.setItem(6, recraft11);
/*  920 */         inv.setItem(7, recraft11);
/*  921 */         inv.setItem(8, recraft11);
/*      */ 
/*  951 */         e.getPlayer().openInventory(inv);
/*      */       }
                 }
}
}
@EventHandler
/*     */   public void onPlayerCLickInventry(InventoryClickEvent e)
/*     */   {
/* 165 */     Player p = (Player)e.getWhoClicked();
/* 166 */     if ((e.getInventory().getTitle().equalsIgnoreCase("§cRecraft")) && 
/* 167 */       (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) && (e.getCurrentItem().getDurability() == 15))
/*     */     {
/* 169 */       e.setCancelled(true);
                p.closeInventory();

/* 174 */}
}

  
/*      */ @EventHandler(priority=EventPriority.NORMAL)
public void comandoInvalido(PlayerCommandPreprocessEvent event)
{
  if (!event.isCancelled())
  {
    Player player = event.getPlayer();
    String cmd = event.getMessage().split(" ")[0];
    HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(cmd);
    if (topic == null)
    {
      player.sendMessage("§cComando inexistente ou invalido!");
      player.playSound(player.getLocation(), Sound.NOTE_BASS, 1.0F, 1.0F);
      event.setCancelled(true);
    }
  }
}
@EventHandler
public void onMessagesBlocked(PlayerCommandPreprocessEvent e)
{
  Player p = e.getPlayer();
  if ((e.getMessage().toLowerCase().startsWith("/me")) || (e.getMessage().toLowerCase().startsWith("/bukkit:me")))
  {
    e.setCancelled(true);
    p.sendMessage("§cComando inexistente ou invalido!");
  }
  if (e.getMessage().toLowerCase().startsWith("/bukkit:say"))
  {
    e.setCancelled(true);
    p.sendMessage("§cComando inexistente ou invalido!");
  }
  if ((e.getMessage().toLowerCase().startsWith("/plugin")) || (e.getMessage().toLowerCase().startsWith("/bukkit:plugin")) || (e.getMessage().toLowerCase().startsWith("/pl")) || (e.getMessage().toLowerCase().startsWith("/bukkit:pl")) || (e.getMessage().toLowerCase().startsWith("/plugins")) || (e.getMessage().toLowerCase().startsWith("/bukkit:plugins")))
  {
    e.setCancelled(true);
    p.sendMessage("§cComando inexistente ou invalido!");
  }
  if ((e.getMessage().toLowerCase().startsWith("/ver")) || (e.getMessage().toLowerCase().startsWith("/version")) || (e.getMessage().toLowerCase().startsWith("/versions")) || (e.getMessage().toLowerCase().startsWith("/bukkit:ver")) || (e.getMessage().toLowerCase().startsWith("/bukkit:versions")) || (e.getMessage().toLowerCase().startsWith("bukkit:version")))
  {
    e.setCancelled(true);
    p.sendMessage("§cComando inexistente ou invalido!");
  }
  if ((e.getMessage().toLowerCase().startsWith("about")) || (e.getMessage().toLowerCase().startsWith("bukkit:about")) || (e.getMessage().toLowerCase().startsWith("achievement")) || (e.getMessage().toLowerCase().startsWith("bukkit:achievement")))
  {
    e.setCancelled(true);
    p.sendMessage("§cComando inexistente ou invalido!");
  }
  if ((e.getMessage().toLowerCase().startsWith("/?")) || (e.getMessage().toLowerCase().startsWith("/bukkit:?")) || (e.getMessage().toLowerCase().startsWith("/help")) || (e.getMessage().toLowerCase().startsWith("/bukkit:help")))
  {
    e.setCancelled(true);
    p.sendMessage("§cComando inexistente ou invalido!");
  }
}


@EventHandler(priority=EventPriority.HIGHEST)
public void onPlayerInteract(PlayerInteractEvent event)
{
  Player p = event.getPlayer();
  if ((p.getItemInHand().getType() == Material.COMPASS) && (ArrayL.usandokit.contains(p.getName())))
  {
    Boolean found = Boolean.valueOf(false);
    for (int i = 0; i < 1000; i++)
    {
      List<Entity> entities = p.getNearbyEntities(i, 128.0D, i);
      Iterator<Entity> iterator = entities.iterator();
      if (iterator.hasNext())
      {
        Entity e = (Entity)iterator.next();
        if ((!e.getType().equals(EntityType.PLAYER)) || (e.getLocation().distance(p.getLocation()) < 1.0D)) {
          return;
        }
        p.setCompassTarget(e.getLocation());
        p.sendMessage("§7Bussola apontando para §c" + ((Player)e).getName() + " §7!");
        found = Boolean.valueOf(true);
      }
      if (found.booleanValue()) {
        break;
      }
    }
    if (!found.booleanValue())
    {
      p.sendMessage("§7× §cNenhum player encontrado");
      p.setCompassTarget(new Location(p.getWorld(), 0.0D, 60.0D, 0.0D));
    }
  }
}

@EventHandler(priority=EventPriority.LOWEST)
public void replaceChat(AsyncPlayerChatEvent e)
{
	Player p = e.getPlayer();
	 if (e.getMessage().toLowerCase().contains(".com") || e.getMessage().toLowerCase().contains(".net") ||
			 e.getMessage().toLowerCase().contains(".br") || e.getMessage().toLowerCase().contains(".tk")
			 || e.getMessage().toLowerCase().contains("http") || e.getMessage().toLowerCase().contains("battlehost")) {
		 if (p.isOp() || p.hasPermission("kitpvp.admin")) {
			 return;
		 }
		 else {
			 e.setCancelled(true);
			 p.kickPlayer("§bFreeze §fKits \n\n §cPorfavor Nao Divulgue !");
		 }
	 }
}

/*      */   @EventHandler
/*      */   public void NaoQueimar(BlockIgniteEvent evento)
/*      */   {
/*  981 */     evento.setCancelled(true);
/*      */   }
/*      */   
/*      */   @EventHandler
/*      */   public void aoColocarBlocos(BlockPlaceEvent e)
/*      */   {
/*  987 */     Player p = e.getPlayer();
/*  988 */     if (p.getGameMode() != GameMode.CREATIVE) {
/*  989 */       e.setCancelled(true);
/*      */     }
/*      */   }
/*      */   
/*      */   @EventHandler
/*      */   public void aoQuebrarBlocos(BlockBreakEvent e) {
/*  995 */     Player p = e.getPlayer();
/*  996 */     if (p.getGameMode() != GameMode.CREATIVE)
/*  997 */       e.setCancelled(true);
}
@EventHandler(priority=EventPriority.LOWEST)
public void MaconhaAki(AsyncPlayerChatEvent e)
{
  String msg = e.getMessage();
  msg = msg.replaceAll("%", "%%");
  e.setMessage(msg);
}
}
