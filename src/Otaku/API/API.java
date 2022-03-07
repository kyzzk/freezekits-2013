package Otaku.API;

import java.util.ArrayList;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;
import org.bukkit.scheduler.BukkitScheduler;

import Otaku.Main;
import Otaku.Files.WarpM;

public class API {
	
  public static BukkitScheduler she = Bukkit.getScheduler();
  public static ArrayList<String> invencibilidade = new ArrayList<String>();
  public static ArrayList<String> contagem = new ArrayList<String>();
  public static ArrayList<String> teleporting = new ArrayList<String>();
  public static HashMap<String, String> Fake = new HashMap<String, String>();
  public static HashMap<String, String> Habilidade = new HashMap<String, String>();
  public static ItemStack Chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
  public static ItemStack bau;
  public static ItemMeta baumeta;
  public static String prefix = "§bFreeze§fKits §8» ";
  public static String noPerm = "§cVoce nao tem permissao para usar esse comando!";
  private static WarpM settings = WarpM.getmulticonfig();
  
  
  public static Location getLocationWarp(String name) {
	    World w = Main.getPlugin().getServer().getWorld(settings.getWarps().getString(name + ".World"));
	    double x = settings.getWarps().getDouble(name + ".X");
	    double y = settings.getWarps().getDouble(name + ".Y");
	    double z = settings.getWarps().getDouble(name + ".Z");
	    Location loc1 = new Location(w, x, y, z);
	    loc1.setPitch((float)settings.getWarps().getDouble(name + ".Pitch"));
	    loc1.setYaw((float)settings.getWarps().getDouble(name + ".Yaw"));
	    return loc1;
	  }
  public static void createWarp(String name, Location loc) {
	    settings.getWarps().set(name + ".World", loc.getWorld().getName());
	    settings.getWarps().set(name + ".X", Double.valueOf(loc.getX()));
	    settings.getWarps().set(name + ".Y", Double.valueOf(loc.getY()));
	    settings.getWarps().set(name + ".Z", Double.valueOf(loc.getZ()));
	    settings.getWarps().set(name + ".Yaw", Float.valueOf(loc.getYaw()));
	    settings.getWarps().set(name + ".Pitch", Float.valueOf(loc.getPitch()));
	    settings.saveWarps();
	  }
  public static void rT(Player p) {
	  p.setHealth(20.0D);
	  p.setLevel(0);
	  p.setExp(0.0F);
	  p.setExhaustion(0);
	  p.setGameMode(GameMode.SURVIVAL);
	  p.setAllowFlight(false);
	  p.setFlying(false);
	  p.setFireTicks(0);
	  for (PotionEffect effect : p.getActivePotionEffects()) {
		p.removePotionEffect(effect.getType());
	  }
  }
  public static boolean hP(Player p, String permission) {
	  if (p.hasPermission(permission)) {
		  return true;
	  }
	  return false;
  }
  
  public static void darArmadura(Player p) {
      PlayerInventory inv = p.getInventory();
    
      inv.setHelmet(create(Material.IRON_HELMET, "§c§oCapacete"));
      inv.setChestplate(create(Material.IRON_CHESTPLATE, "§c§oPeitoral"));
      inv.setLeggings(create(Material.IRON_LEGGINGS, "§b§oCal§a"));
      inv.setBoots(create(Material.IRON_BOOTS, "§b§oBota"));
  }
  public static void darEspada(Player p, boolean encantada)  {
      if (encantada) {
        p.getInventory().setItem(0, create(Material.DIAMOND_SWORD, "§b§oEspada de Diamante", Enchantment.DAMAGE_ALL, 1));
      }
      p.getInventory().setItem(0, create(Material.DIAMOND_SWORD, "§b§oEspada de Diamante"));
  }
  public static ItemStack create(Material tipo, String nome, Enchantment encantamento, int level) {
	  
      ItemStack i = new ItemStack(tipo);
      ItemMeta m = i.getItemMeta();
      m.addEnchant(encantamento, level, true);
      m.setDisplayName(nome);
      i.setItemMeta(m);
      return i;
  }
  public static void cI(Player p) {
      PlayerInventory inv = p.getInventory();
      inv.clear();
      inv.setArmorContents(null);
  }
  public static void tirarArmor(Player p)
  {
    PlayerInventory inv = p.getInventory();
    
    inv.setArmorContents(null);
  }
  
  public static void firstEmpty(Inventory inv, ItemStack item)
  {
    ItemStack[] arrayOfItemStack;
    int j = (arrayOfItemStack = inv.getContents()).length;
    for (int i = 0; i < j; i++)
    {
      ItemStack item2 = arrayOfItemStack[i];
      if (item2 == null) {
        inv.setItem(inv.firstEmpty(), item);
      }
    }
  }

  public static void darItems(Player p, ItemStack item, int quantidade)
  {
    Inventory inv = p.getInventory();
    for (int x = 0; x < quantidade; x++) {
      inv.addItem(new ItemStack[] { item });
    }
  }
  
  public static void darItems(Inventory inv, ItemStack item, int quantidade)
  {
    for (int x = 0; x < quantidade; x++) {
      inv.addItem(new ItemStack[] { item });
    }
  }
  
  public static void setItem(Inventory inv, int slot, ItemStack item)
  {
    inv.setItem(slot, item);
  }
  
  public static ItemStack create(Material tipo, int quantia, String nome)
  {
    ItemStack i = new ItemStack(tipo, 1, (byte)quantia);
    ItemMeta m = i.getItemMeta();
    m.setDisplayName(nome);
    i.setItemMeta(m);
    return i;
  }
  
  public static void bcast(String message)
  {
    Bukkit.broadcastMessage(message);
  }
  
  public static ItemStack create(Material tipo, String nome, ArrayList<String> lore)
  {
    ItemStack i = new ItemStack(tipo);
    ItemMeta m = i.getItemMeta();
    m.setDisplayName(nome);
    m.setLore(lore);
    i.setItemMeta(m);
    return i;
  }
  public static ItemStack create(Material tipo, String nome, int data, ArrayList<String> lore)
  {
    ItemStack i = new ItemStack(tipo, 1, (short) data);
    ItemMeta m = i.getItemMeta();
    m.setDisplayName(nome);
    m.setLore(lore);
    i.setItemMeta(m);
    return i;
  }
	public static ArrayList<String> lore(String lore1, String lore2, String lore3, String lore4) {
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(" ");
		if (lore1 != null) {
			lore.add(lore1);
		}
		if (lore2 != null) {
			lore.add(lore2);
		}
		if (lore3 != null) {
			lore.add(lore3);
		}
		if (lore4 != null) {
			lore.add(lore4);
		}
		return lore;
	}
	public static ArrayList<String> lore(String lore1, String lore2) {
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(" ");
		if (lore1 != null) {
			lore.add(lore1);
		}
		if (lore2 != null) {
			lore.add(lore2);
		}
		return lore;
	}
	public static ArrayList<String> lore(String lore1, String lore2, String lore3) {
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(" ");
		if (lore1 != null) {
			lore.add(lore1);
		}
		if (lore2 != null) {
			lore.add(lore2);
		}
		if (lore3 != null) {
			lore.add(lore3);
		}
		return lore;
	}
	public static ArrayList<String> lore(String lore1) {
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(" ");
		if (lore1 != null) {
			lore.add(lore1);
		}
		return lore;
	}
  @SuppressWarnings("deprecation")
public static ItemStack create(int p2, String nome, Enchantment encantamento, int level)
  {
    ItemStack i = new ItemStack(p2);
    ItemMeta m = i.getItemMeta();
    m.addEnchant(encantamento, level, true);
    m.setDisplayName(nome);
    i.setItemMeta(m);
    return i;
  }
  
  public static ItemStack create(Material tipo, String nome)
  {
    ItemStack i = new ItemStack(tipo);
    ItemMeta m = i.getItemMeta();
    m.setDisplayName(nome);
    i.setItemMeta(m);
    return i;
  }
  
  public static ItemStack create(Material tipo, int quantia, int data, String nome)
  {
    ItemStack i = new ItemStack(tipo, data, (byte)quantia);
    ItemMeta m = i.getItemMeta();
    m.setDisplayName(nome);
    i.setItemMeta(m);
    return i;
  }
  
  public static void removePotion(Player p)
  {
    for (PotionEffect ef : p.getActivePotionEffects()) {
      p.removePotionEffect(ef.getType());
    }
  }
  
  public static Inventory createInventory(int tamanho, String titulo)
  {
    Inventory inv = Bukkit.createInventory(null, tamanho, titulo);
    return inv;
  }
  
  public static void addPotion(Inventory inv, PotionType tipo, int força, int quantidade, boolean splash)
  {
    Potion poçao = new Potion(tipo, força);
    poçao.setSplash(splash);
    
    inv.addItem(new ItemStack[] { poçao.toItemStack(quantidade) });
  }
  
  public static void explosao(Location loc, float tamanho)
  {
    loc.getWorld().createExplosion(loc, tamanho);
  }
  
  public static void trovao(Location loc)
  {
    loc.getWorld().strikeLightning(loc);
  }
  
  public static void effet(Location loc, Effect efeito, int quantidade)
  {
    loc.getWorld().playEffect(loc, efeito, quantidade);
  }
  
  public static void drop(Location loc, ItemStack item)
  {
    loc.getWorld().dropItemNaturally(loc, item);
  }
  
  public static Location getLocation(Player p)
  {
    Location loc2 = p.getLocation();
    Location loc = new Location(loc2.getWorld(), loc2.getX(), loc2.getY(), loc2.getZ());
    loc.setYaw(loc2.getYaw());
    loc.setPitch(loc2.getPitch());
    return loc;
  }
  
  public static void teleport(Player p, Location loc)
  {
    p.teleport(loc);
  }
  
  public static void msg(Player p, String mensagem)
  {
    p.sendMessage(mensagem);
  }
  
  public static void ban(Player p, String motivo)
  {
    p.kickPlayer("§cVoce foi banido do servidor \nMotivo: " + motivo + "\n\nCoordKits.wix.com/kitPvP");
  }
  
  
  public static void potion(LivingEntity entidade, PotionEffectType tipo, int duraçao)
  {
    entidade.addPotionEffect(new PotionEffect(tipo, 10 * duraçao, 0));
  }
  
  public static void potion(LivingEntity entidade, PotionEffectType tipo, int duraçao, int nivel)
  {
    entidade.addPotionEffect(new PotionEffect(tipo, 10 * duraçao, nivel));
  }
  
  public static void som(Player p, Sound som, float volume)
  {
    p.playSound(p.getLocation(), som, volume, volume);
  }
  
  public static boolean isFake(Player p)
  {
    return Fake.containsKey(p.getName());
  }
  
  public static void darRecraft(Player p)
  {
    PlayerInventory inv = p.getInventory();
    
    ItemStack coguver = new ItemStack(Material.RED_MUSHROOM, 64);
    ItemMeta coguverm = coguver.getItemMeta();
    coguverm.setDisplayName("§c§oCogumelo vermelho");
    coguver.setItemMeta(coguverm);
    
    ItemStack cogu = new ItemStack(Material.BROWN_MUSHROOM, 64);
    ItemMeta cogumeta = cogu.getItemMeta();
    cogumeta.setDisplayName("§b§oCogumelo marrom");
    cogu.setItemMeta(cogumeta);
    
    ItemStack pote = new ItemStack(Material.BOWL, 64);
    ItemMeta potemeta = pote.getItemMeta();
    potemeta.setDisplayName("§8§oTigela");
    pote.setItemMeta(potemeta);
    
    ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
    ItemMeta sopameta = sopa.getItemMeta();
    sopameta.setDisplayName("§eSopinha");
    ArrayList<String> sopalore = new ArrayList<String>();
    sopalore.add("§7+ §c3.5");
    sopameta.setLore(sopalore);
    sopa.setItemMeta(sopameta);
    
    inv.setItem(13, coguver);
    inv.setItem(14, cogu);
    inv.setItem(15, pote);
    for (int i = 0; i < 35; i++) {
      inv.addItem(new ItemStack[] { sopa });
    }
  }
  public static void darItemsSpawn(Player p) {
	  Inventory inv = p.getInventory();
	  setItem(inv, 3, create(Material.ANVIL, "§8» §eMenu", API.lore("§7➥ Use para tirar duvidas", "§7➥ Compras e para abrir suas caixas.")));
	  setItem(inv, 4, create(Material.ENDER_CHEST, "§8» §eKits", API.lore("§7➥ Use para selecionar um kit.")));
	  setItem(inv, 5, create(Material.BOOK, "§8» §eWarps", API.lore("§7➥ Use para treinar em Warps.")));
  }
  
  public static void darSopas(Player p)
  {
    PlayerInventory inv = p.getInventory();
    for (int i = 0; i < 35; i++) {
      inv.addItem(new ItemStack[] { create(Material.MUSHROOM_SOUP, "§aSopinha", API.lore("§7+ §c3.5", "", "", "")) });
    }
  }
  
  public static ItemStack[] darSopas1v1(Player p)
  {
    PlayerInventory inv = p.getInventory();
    for (int i = 0; i < 35; i++) {
        inv.addItem(new ItemStack[] { create(Material.MUSHROOM_SOUP, "§aSopinha", API.lore("§7+ §c3.5", "", "", "")) });
    }
	return null;
  }
  
  public static void removeFake(Player p)
  {
    if (Fake.containsKey(p.getName())) {
      Fake.remove(p.getName());
    }
  }
  
  public static ItemStack Armadura(Color cor)
  {
    LeatherArmorMeta meta = (LeatherArmorMeta)Chestplate.getItemMeta();
    meta.setColor(cor);
    Chestplate.setItemMeta(meta);
    return Chestplate;
  }

public static ItemStack create(Player p2, String nome, Enchantment damageAll, int level) {
	return null;
}
}
