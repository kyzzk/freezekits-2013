package Otaku.Skill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import Otaku.Main;
import Otaku.API.API;
import Otaku.Comandos.Fly;

public class Metodos
  implements Listener
{
  private int amountOfLeather = 0;
  private int amountOfIron = 0;
  private int amountOfGold = 0;
  private int amountOfDiamond = 0;
  private int amountOfChainmail = 0;
  private ArrayList<Integer> allAmounts = new ArrayList();
  private final ArrayList<Player> noLavaDamage = new ArrayList();
  private final ArrayList<Player> noFireDamage = new ArrayList();
  public static Map<String, String> powerMap = new HashMap();
  public static Map<String, String> powerMapT = new HashMap();
  public Main plugin;
  
  public Metodos(Main instance)
  {
    this.plugin = instance;
  }
  
  public static String getAbility(Player player)
  {
    if (!powerMap.containsKey(player.getName())) {
      powerMap.put(player.getName(), "Nenhum");
    }
    return (String)powerMap.get(player.getName());
  }
  
  public static void setAbility(Player player, String ability)
  {
    powerMap.put(player.getName(), ability);
  }
  
  public static void removeAbility(Player p)
  {
    powerMap.remove(p.getName());
  }
  
  public static void strikeLightning(Entity entity)
  {
    Location coords = entity.getLocation();
    coords.getWorld().strikeLightningEffect(coords);
    Block block = coords.getBlock();
    block.setType(Material.AIR);
  }
  public ItemStack setColor(ItemStack item, Color args) {
      LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
      meta.setColor(args);
      item.setItemMeta(meta);
      return item;
}
  
  public static void DarosKits(Player p)
  {
    if (getAbility(p) == "PvP")
    {
      p.getInventory().clear();
      ItemStack bussola = new ItemStack(Material.COMPASS);
      ItemMeta kbussola = bussola.getItemMeta();
      kbussola.setDisplayName("§cBussola");
      bussola.setItemMeta(kbussola);
      
      ItemStack peirotal = new ItemStack(Material.LEATHER_CHESTPLATE);
      LeatherArmorMeta peitoralk = (LeatherArmorMeta) peirotal.getItemMeta();
      peitoralk.setDisplayName("§dPeitoral");
      peitoralk.setColor(Color.RED);
      peirotal.setItemMeta(peitoralk);
      p.getInventory().setChestplate(peirotal);
      
      p.getInventory().setItem(8, bussola);
      ItemStack espada = new ItemStack(Material.STONE_SWORD);
      ItemMeta m = espada.getItemMeta();
      m.setDisplayName("§aEspada");
      espada.setItemMeta(m);
      
      p.getInventory().setItem(0, espada);
      espada.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 0);
      
      ArrayL.usandokit.add(p.getName());
      p.setGameMode(GameMode.SURVIVAL);
      
      p.setAllowFlight(false);
      API.darRecraft(p);
    }
    if (getAbility(p) == "Sonic")
    {
      p.getInventory().clear();
      ItemStack bussola = new ItemStack(Material.COMPASS);
      ItemMeta kbussola = bussola.getItemMeta();
      kbussola.setDisplayName("§cBussola");
      bussola.setItemMeta(kbussola);
      
      ItemStack peirotal = new ItemStack(Material.LEATHER_CHESTPLATE);
      LeatherArmorMeta peitoralk = (LeatherArmorMeta) peirotal.getItemMeta();
      peitoralk.setDisplayName("§dPeitoral");
      peitoralk.setColor(Color.RED);
      peirotal.setItemMeta(peitoralk);
      p.getInventory().setChestplate(peirotal);
      
      p.getInventory().setItem(8, bussola);
      p.getInventory().setItem(1, new ItemStack(Material.LAPIS_BLOCK));
      ItemStack espada = new ItemStack(Material.STONE_SWORD);
      ItemMeta m = espada.getItemMeta();
      m.setDisplayName("§aEspada");
      espada.setItemMeta(m);
      p.setGameMode(GameMode.SURVIVAL);
      
      p.setAllowFlight(false);
      p.getInventory().setItem(0, espada);
      ArrayL.usandokit.add(p.getName());
      
      API.darRecraft(p);
    }
    if (getAbility(p) == "ForceField")
    {
      p.getInventory().clear();
      ItemStack bussola = new ItemStack(Material.COMPASS);
      ItemMeta kbussola = bussola.getItemMeta();
      kbussola.setDisplayName("§cBussola");
      bussola.setItemMeta(kbussola);
      p.setGameMode(GameMode.SURVIVAL);
      
      p.setAllowFlight(false);
      
      ItemStack peirotal = new ItemStack(Material.LEATHER_CHESTPLATE);
      LeatherArmorMeta peitoralk = (LeatherArmorMeta) peirotal.getItemMeta();
      peitoralk.setDisplayName("§dPeitoral");
      peitoralk.setColor(Color.RED);
      peirotal.setItemMeta(peitoralk);
      p.getInventory().setChestplate(peirotal);
      p.getInventory().setItem(8, bussola);
      ItemStack bussola1 = new ItemStack(Material.NETHER_FENCE);
      ItemMeta kbussola1 = bussola1.getItemMeta();
      kbussola1.setDisplayName("§5Huzuni");
      bussola1.setItemMeta(kbussola1);
      p.getInventory().setItem(1, bussola1);
      ItemStack espada = new ItemStack(Material.STONE_SWORD);
      ItemMeta m = espada.getItemMeta();
      m.setDisplayName("§aEspada");
      espada.setItemMeta(m);
      
      p.getInventory().setItem(0, espada);
      ArrayL.usandokit.add(p.getName());
      ArrayL.Forcefield.add(p.getName());
      
      API.darRecraft(p);
    }
    if (getAbility(p) == "C4")
    {
      p.getInventory().clear();
      ItemStack bussola = new ItemStack(Material.COMPASS);
      ItemMeta kbussola = bussola.getItemMeta();
      kbussola.setDisplayName("§cBussola");
      bussola.setItemMeta(kbussola);
      p.setGameMode(GameMode.SURVIVAL);
      
      p.setAllowFlight(false);
      ItemStack peirotal = new ItemStack(Material.LEATHER_CHESTPLATE);
      LeatherArmorMeta peitoralk = (LeatherArmorMeta) peirotal.getItemMeta();
      peitoralk.setDisplayName("§dPeitoral");
      peitoralk.setColor(Color.RED);
      peirotal.setItemMeta(peitoralk);
      p.getInventory().setChestplate(peirotal);
      p.getInventory().setItem(8, bussola);
      ItemStack bussola1 = new ItemStack(Material.SLIME_BALL);
      ItemMeta kbussola1 = bussola1.getItemMeta();
      kbussola1.setDisplayName("§cC4");
      bussola1.setItemMeta(kbussola1);
      p.getInventory().setItem(1, bussola1);
      ItemStack espada = new ItemStack(Material.STONE_SWORD);
      ItemMeta m = espada.getItemMeta();
      m.setDisplayName("§aEspada");
      espada.setItemMeta(m);
      
      p.getInventory().setItem(0, espada);
      ArrayL.usandokit.add(p.getName());
      ArrayL.C4.add(p.getName());
      
      API.darRecraft(p);
    }
    if (getAbility(p) == "Supernova")
    {
      p.getInventory().clear();
      ItemStack bussola = new ItemStack(Material.COMPASS);
      ItemMeta kbussola = bussola.getItemMeta();
      kbussola.setDisplayName("§cBussola");
      bussola.setItemMeta(kbussola);
      p.setGameMode(GameMode.SURVIVAL);
      
      ItemStack peirotal = new ItemStack(Material.LEATHER_CHESTPLATE);
      LeatherArmorMeta peitoralk = (LeatherArmorMeta) peirotal.getItemMeta();
      peitoralk.setDisplayName("§dPeitoral");
      peitoralk.setColor(Color.RED);
      peirotal.setItemMeta(peitoralk);
      p.getInventory().setChestplate(peirotal);
      p.setAllowFlight(false);
      p.getInventory().setItem(8, bussola);
      p.getInventory().setItem(1, new ItemStack(Material.SUGAR));
      ItemStack espada = new ItemStack(Material.STONE_SWORD);
      ItemMeta m = espada.getItemMeta();
      m.setDisplayName("§aEspada");
      espada.setItemMeta(m);
      
      p.getInventory().setItem(0, espada);
      ArrayL.usandokit.add(p.getName());
      
      API.darRecraft(p);
    }
    if (getAbility(p) == "Velotrol")
    {
      p.getInventory().clear();
      ItemStack bussola = new ItemStack(Material.COMPASS);
      ItemMeta kbussola = bussola.getItemMeta();
      kbussola.setDisplayName("§cBussola");
      bussola.setItemMeta(kbussola);
      p.setGameMode(GameMode.SURVIVAL);
      
      ItemStack peirotal = new ItemStack(Material.LEATHER_CHESTPLATE);
      LeatherArmorMeta peitoralk = (LeatherArmorMeta) peirotal.getItemMeta();
      peitoralk.setDisplayName("§dPeitoral");
      peitoralk.setColor(Color.RED);
      peirotal.setItemMeta(peitoralk);
      p.getInventory().setChestplate(peirotal);
      p.setAllowFlight(false);
      p.getInventory().setItem(8, bussola);
      ItemStack Velotrol = new ItemStack(Material.MINECART);
      ItemMeta kVelotrol = Velotrol.getItemMeta();
      kVelotrol.setDisplayName("§aVelotrol");
      Velotrol.setItemMeta(kVelotrol);
      ItemStack espada = new ItemStack(Material.STONE_SWORD);
      ItemMeta m = espada.getItemMeta();
      m.setDisplayName("§aEspada");
      espada.setItemMeta(m);
      p.getInventory().setItem(1, Velotrol);
      p.getInventory().setItem(0, espada);
      ArrayL.usandokit.add(p.getName());
      
      API.darRecraft(p);
    }
    if (getAbility(p) == "Grandpa")
    {
      p.getInventory().clear();
      ItemStack bussola = new ItemStack(Material.COMPASS);
      ItemMeta kbussola = bussola.getItemMeta();
      kbussola.setDisplayName("§cBussola");
      bussola.setItemMeta(kbussola);
      p.setGameMode(GameMode.SURVIVAL);
      ItemStack peirotal = new ItemStack(Material.LEATHER_CHESTPLATE);
      LeatherArmorMeta peitoralk = (LeatherArmorMeta) peirotal.getItemMeta();
      peitoralk.setDisplayName("§dPeitoral");
      peitoralk.setColor(Color.RED);
      peirotal.setItemMeta(peitoralk);
      p.getInventory().setChestplate(peirotal);
      
      p.setAllowFlight(false);
      p.getInventory().setItem(8, bussola);
      ItemStack Velotrol = new ItemStack(Material.STICK);
      ItemMeta kVelotrol = Velotrol.getItemMeta();
      kVelotrol.addEnchant(Enchantment.KNOCKBACK, 5, true); 
      kVelotrol.setDisplayName("§aGrandPá");
      Velotrol.setItemMeta(kVelotrol);
      ItemStack espada = new ItemStack(Material.STONE_SWORD);
      ItemMeta m = espada.getItemMeta();
      m.setDisplayName("§aEspada");
      espada.setItemMeta(m);
      p.getInventory().setItem(1, Velotrol);
      p.getInventory().setItem(0, espada);
      ArrayL.usandokit.add(p.getName());
      
      API.darRecraft(p);
    }
    if (getAbility(p) == "Rain")
    {
      p.getInventory().clear();
      ItemStack bussola = new ItemStack(Material.COMPASS);
      ItemMeta kbussola = bussola.getItemMeta();
      kbussola.setDisplayName("§cBussola");
      bussola.setItemMeta(kbussola);
      p.setGameMode(GameMode.SURVIVAL);
      
      ItemStack peirotal = new ItemStack(Material.LEATHER_CHESTPLATE);
      LeatherArmorMeta peitoralk = (LeatherArmorMeta) peirotal.getItemMeta();
      peitoralk.setDisplayName("§dPeitoral");
      peitoralk.setColor(Color.RED);
      peirotal.setItemMeta(peitoralk);
      p.getInventory().setChestplate(peirotal);
      p.setAllowFlight(false);
      p.getInventory().setItem(8, bussola);
      ItemStack Velotrol = new ItemStack(Material.ARROW);
      ItemMeta kVelotrol = Velotrol.getItemMeta();
      kVelotrol.setDisplayName("§aRain");
      Velotrol.setItemMeta(kVelotrol);
      ItemStack espada = new ItemStack(Material.STONE_SWORD);
      ItemMeta m = espada.getItemMeta();
      m.setDisplayName("§aEspada");
      espada.setItemMeta(m);
      p.getInventory().setItem(1, Velotrol);
      p.getInventory().setItem(0, espada);
      ArrayL.usandokit.add(p.getName());
      ArrayL.rain.add(p.getName());
      
      API.darRecraft(p);
    }
    if (getAbility(p) == "Criticals")
    {
      p.getInventory().clear();
      ItemStack bussola = new ItemStack(Material.COMPASS);
      ItemMeta kbussola = bussola.getItemMeta();
      kbussola.setDisplayName("§cBussola");
      bussola.setItemMeta(kbussola);
      p.setGameMode(GameMode.SURVIVAL);
      
      ItemStack peirotal = new ItemStack(Material.LEATHER_CHESTPLATE);
      LeatherArmorMeta peitoralk = (LeatherArmorMeta) peirotal.getItemMeta();
      peitoralk.setDisplayName("§dPeitoral");
      peitoralk.setColor(Color.RED);
      peirotal.setItemMeta(peitoralk);
      p.getInventory().setChestplate(peirotal);
      p.setAllowFlight(false);
      p.getInventory().setItem(8, bussola);
      ItemStack espada = new ItemStack(Material.STONE_SWORD);
      ItemMeta m = espada.getItemMeta();
      m.setDisplayName("§aEspada");
      espada.setItemMeta(m);
      p.getInventory().setItem(0, espada);
      ArrayL.usandokit.add(p.getName());
      ArrayL.critical.add(p.getName());
      
      API.darRecraft(p);
    }
    
    if (getAbility(p) == "Deshfire")
    {
      p.getInventory().clear();
      ItemStack bussola = new ItemStack(Material.COMPASS);
      ItemMeta kbussola = bussola.getItemMeta();
      kbussola.setDisplayName("§cBussola");
      bussola.setItemMeta(kbussola);
      p.setGameMode(GameMode.SURVIVAL);
      
      p.setAllowFlight(false);
      ItemStack peirotal = new ItemStack(Material.LEATHER_CHESTPLATE);
      LeatherArmorMeta peitoralk = (LeatherArmorMeta) peirotal.getItemMeta();
      peitoralk.setDisplayName("§dPeitoral");
      peitoralk.setColor(Color.RED);
      peirotal.setItemMeta(peitoralk);
      p.getInventory().setChestplate(peirotal);
      p.getInventory().setItem(8, bussola);
      p.getInventory().setItem(1, new ItemStack(Material.REDSTONE_BLOCK));
      ItemStack espada = new ItemStack(Material.STONE_SWORD);
      ItemMeta m = espada.getItemMeta();
      m.setDisplayName("§aEspada");
      espada.setItemMeta(m);
      p.getInventory().setItem(0, espada);
      ArrayL.usandokit.add(p.getName());
      
      API.darRecraft(p);
    }
    if (getAbility(p) == "Anchor")
    {
      p.getInventory().clear();
      ItemStack bussola = new ItemStack(Material.COMPASS);
      ItemMeta kbussola = bussola.getItemMeta();
      kbussola.setDisplayName("§cBussola");
      bussola.setItemMeta(kbussola);
      p.setGameMode(GameMode.SURVIVAL);
      
      p.setAllowFlight(false);
      ItemStack peirotal = new ItemStack(Material.LEATHER_CHESTPLATE);
      LeatherArmorMeta peitoralk = (LeatherArmorMeta) peirotal.getItemMeta();
      peitoralk.setDisplayName("§dPeitoral");
      peitoralk.setColor(Color.RED);
      peirotal.setItemMeta(peitoralk);
      p.getInventory().setChestplate(peirotal);
      p.getInventory().setItem(8, bussola);
      ItemStack espada = new ItemStack(Material.STONE_SWORD);
      ItemMeta m = espada.getItemMeta();
      m.setDisplayName("§aEspada");
      espada.setItemMeta(m);
      
      p.getInventory().setItem(0, espada);
      
      ArrayL.usandokit.add(p.getName());
      ArrayL.anchor.add(p.getName());
      API.darRecraft(p);
    }
    if (getAbility(p) == "Woodman")
    {
      p.getInventory().clear();
      ItemStack bussola = new ItemStack(Material.COMPASS);
      ItemMeta kbussola = bussola.getItemMeta();
      kbussola.setDisplayName("§cBussola");
      bussola.setItemMeta(kbussola);
      
      ItemStack espada = new ItemStack(Material.STONE_SWORD);
      ItemMeta m = espada.getItemMeta();
      m.setDisplayName("§aEspada");
      espada.setItemMeta(m);
      p.setGameMode(GameMode.SURVIVAL);
      
      ItemStack peirotal = new ItemStack(Material.LEATHER_CHESTPLATE);
      LeatherArmorMeta peitoralk = (LeatherArmorMeta) peirotal.getItemMeta();
      peitoralk.setDisplayName("§dPeitoral");
      peitoralk.setColor(Color.RED);
      peirotal.setItemMeta(peitoralk);
      p.getInventory().setChestplate(peirotal);
      p.setAllowFlight(false);
      p.getInventory().setItem(0, espada);
      
      ArrayL.usandokit.add(p.getName());
      
      API.darRecraft(p);
    }
    if (getAbility(p) == "Berserker")
    {
      p.getInventory().clear();
      ItemStack bussola = new ItemStack(Material.COMPASS);
      ItemMeta kbussola = bussola.getItemMeta();
      kbussola.setDisplayName("§cBussola");
      bussola.setItemMeta(kbussola);
      
      p.getInventory().setItem(8, bussola);
      ItemStack espada = new ItemStack(Material.STONE_SWORD);
      ItemMeta m = espada.getItemMeta();
      m.setDisplayName("§aEspada");
      espada.setItemMeta(m);
      p.setGameMode(GameMode.SURVIVAL);
      ItemStack peirotal = new ItemStack(Material.LEATHER_CHESTPLATE);
      LeatherArmorMeta peitoralk = (LeatherArmorMeta) peirotal.getItemMeta();
      peitoralk.setDisplayName("§dPeitoral");
      peitoralk.setColor(Color.RED);
      peirotal.setItemMeta(peitoralk);
      p.getInventory().setChestplate(peirotal);
      
      p.setAllowFlight(false);
      p.getInventory().setItem(0, espada);
      
      ArrayL.usandokit.add(p.getName());
      
      API.darRecraft(p);
    }
    if (getAbility(p) == "Whiter")
    {
      p.getInventory().clear();
      ItemStack bussola = new ItemStack(Material.COMPASS);
      ItemMeta kbussola = bussola.getItemMeta();
      kbussola.setDisplayName("§cBussola");
      bussola.setItemMeta(kbussola);
      ItemStack bussola1 = new ItemStack(Material.NETHER_STAR);
      ItemMeta kbussola1 = bussola1.getItemMeta();
      kbussola1.setDisplayName("§cWHITER");
      bussola1.setItemMeta(kbussola1);
      p.setGameMode(GameMode.SURVIVAL);
      
      ItemStack peirotal = new ItemStack(Material.LEATHER_CHESTPLATE);
      LeatherArmorMeta peitoralk = (LeatherArmorMeta) peirotal.getItemMeta();
      peitoralk.setDisplayName("§dPeitoral");
      peitoralk.setColor(Color.RED);
      peirotal.setItemMeta(peitoralk);
      p.getInventory().setChestplate(peirotal);
      p.setAllowFlight(false);
      p.getInventory().setItem(8, bussola);
      p.getInventory().setItem(1, bussola1);
      ItemStack espada = new ItemStack(Material.STONE_SWORD);
      ItemMeta m = espada.getItemMeta();
      m.setDisplayName("§aEspada");
      espada.setItemMeta(m);
      
      p.getInventory().setItem(0, espada);
      ArrayL.usandokit.add(p.getName());
      
      API.darRecraft(p);
    }
    if (getAbility(p) == "Camel")
    {
      p.getInventory().clear();
      ItemStack bussola = new ItemStack(Material.COMPASS);
      ItemMeta kbussola = bussola.getItemMeta();
      kbussola.setDisplayName("§cBussola");
      bussola.setItemMeta(kbussola);
      p.setGameMode(GameMode.SURVIVAL);
      
      p.setAllowFlight(false);
      ItemStack peirotal = new ItemStack(Material.LEATHER_CHESTPLATE);
      LeatherArmorMeta peitoralk = (LeatherArmorMeta) peirotal.getItemMeta();
      peitoralk.setDisplayName("§dPeitoral");
      peitoralk.setColor(Color.RED);
      peirotal.setItemMeta(peitoralk);
      p.getInventory().setChestplate(peirotal);
      p.getInventory().setItem(8, bussola);
      ItemStack espada = new ItemStack(Material.STONE_SWORD);
      ItemMeta m = espada.getItemMeta();
      m.setDisplayName("§aEspada");
      espada.setItemMeta(m);
      
      p.getInventory().setItem(0, espada);
      
      ArrayL.usandokit.add(p.getName());
      API.darRecraft(p);
    }
    if (getAbility(p) == "Grappler")
    {
      p.getInventory().clear();
      ItemStack bussola = new ItemStack(Material.COMPASS);
      ItemMeta kbussola = bussola.getItemMeta();
      kbussola.setDisplayName("§cBussola");
      bussola.setItemMeta(kbussola);
      p.setGameMode(GameMode.SURVIVAL);
      
      ItemStack peirotal = new ItemStack(Material.LEATHER_CHESTPLATE);
      LeatherArmorMeta peitoralk = (LeatherArmorMeta) peirotal.getItemMeta();
      peitoralk.setDisplayName("§dPeitoral");
      peitoralk.setColor(Color.RED);
      peirotal.setItemMeta(peitoralk);
      p.getInventory().setChestplate(peirotal);
      p.setAllowFlight(false);
      p.getInventory().setItem(8, bussola);
      p.getInventory().setItem(1, new ItemStack(Material.LEASH));
      ItemStack espada = new ItemStack(Material.STONE_SWORD);
      ItemMeta m = espada.getItemMeta();
      m.setDisplayName("§aEspada");
      espada.setItemMeta(m);
      
      p.getInventory().setItem(0, espada);
      ArrayL.usandokit.add(p.getName());
      ArrayL.grappler.add(p.getName());
      
      API.darRecraft(p);
    }
    if (getAbility(p) == "Avatar")
    {
      p.getInventory().clear();
      ItemStack bussola = new ItemStack(Material.COMPASS);
      ItemMeta kbussola = bussola.getItemMeta();
      kbussola.setDisplayName("§cBussola");
      bussola.setItemMeta(kbussola);
      p.setGameMode(GameMode.SURVIVAL);
      
      ItemStack peirotal = new ItemStack(Material.LEATHER_CHESTPLATE);
      LeatherArmorMeta peitoralk = (LeatherArmorMeta) peirotal.getItemMeta();
      peitoralk.setDisplayName("§dPeitoral");
      peitoralk.setColor(Color.RED);
      peirotal.setItemMeta(peitoralk);
      p.getInventory().setChestplate(peirotal);
      p.setAllowFlight(false);
      p.getInventory().setItem(8, bussola);
      p.getInventory().setItem(1, new ItemStack(Material.BEACON));
      ItemStack espada = new ItemStack(Material.STONE_SWORD);
      ItemMeta m = espada.getItemMeta();
      m.setDisplayName("§aEspada");
      espada.setItemMeta(m);
      
      p.getInventory().setItem(0, espada);
      ArrayL.usandokit.add(p.getName());
      ArrayL.Avatar.add(p.getName());
      ArrayL.AvatarH.add(p.getName());
      
      API.darRecraft(p);
    }
    if (getAbility(p) == "Gladiador")
    {
      p.getInventory().clear();
      ItemStack bussola = new ItemStack(Material.COMPASS);
      ItemMeta kbussola = bussola.getItemMeta();
      kbussola.setDisplayName("§cBussola");
      bussola.setItemMeta(kbussola);
      
      p.getInventory().setItem(8, bussola);
      p.setGameMode(GameMode.SURVIVAL);
      ItemStack peirotal = new ItemStack(Material.LEATHER_CHESTPLATE);
      LeatherArmorMeta peitoralk = (LeatherArmorMeta) peirotal.getItemMeta();
      peitoralk.setDisplayName("§dPeitoral");
      peitoralk.setColor(Color.RED);
      peirotal.setItemMeta(peitoralk);
      p.getInventory().setChestplate(peirotal);
      p.setAllowFlight(false);
      ItemStack bussola1 = new ItemStack(Material.IRON_FENCE);
      ItemMeta kbussola1 = bussola1.getItemMeta();
      kbussola1.setDisplayName("§aGladiator");
      bussola1.setItemMeta(kbussola1);
      
      p.getInventory().setItem(1, bussola1);
     
      ItemStack espada = new ItemStack(Material.STONE_SWORD);
      ItemMeta m = espada.getItemMeta();
      m.setDisplayName("§aEspada");
      espada.setItemMeta(m);
      p.getInventory().setItem(0, espada);
      ArrayL.usandokit.add(p.getName());
      ArrayL.gladiator.add(p.getName());
      
      API.darRecraft(p);
    }
    if (getAbility(p) == "Sumo")
    {
      p.getInventory().clear();
      ItemStack bussola = new ItemStack(Material.COMPASS);
      ItemMeta kbussola = bussola.getItemMeta();
      kbussola.setDisplayName("§cBussola");
      bussola.setItemMeta(kbussola);
      ItemStack peirotal = new ItemStack(Material.LEATHER_CHESTPLATE);
      LeatherArmorMeta peitoralk = (LeatherArmorMeta) peirotal.getItemMeta();
      peitoralk.setDisplayName("§dPeitoral");
      peitoralk.setColor(Color.RED);
      peirotal.setItemMeta(peitoralk);
      p.getInventory().setChestplate(peirotal);
      p.getInventory().setItem(8, bussola);
      p.setGameMode(GameMode.SURVIVAL);
      
      p.setAllowFlight(false);
      ItemStack bussola1 = new ItemStack(Material.APPLE);
      ItemMeta kbussola1 = bussola1.getItemMeta();
      kbussola1.setDisplayName("§cSumo");
      bussola1.setItemMeta(kbussola1);
      
      p.getInventory().setItem(1, bussola1);
     
      ItemStack espada = new ItemStack(Material.STONE_SWORD);
      ItemMeta m = espada.getItemMeta();
      m.setDisplayName("§aEspada");
      espada.setItemMeta(m);
      
      p.getInventory().setItem(0, espada);
      ArrayL.usandokit.add(p.getName());
      Sumo.sumo.add(p);
      API.darRecraft(p);
    }
    if (getAbility(p) == "BurstMaster")
    {
      p.getInventory().clear();
      ItemStack bussola = new ItemStack(Material.COMPASS);
      ItemMeta kbussola = bussola.getItemMeta();
      kbussola.setDisplayName("§cBussola");
      bussola.setItemMeta(kbussola);
      ItemStack peirotal = new ItemStack(Material.LEATHER_CHESTPLATE);
      LeatherArmorMeta peitoralk = (LeatherArmorMeta) peirotal.getItemMeta();
      peitoralk.setDisplayName("§dPeitoral");
      peitoralk.setColor(Color.RED);
      peirotal.setItemMeta(peitoralk);
      p.getInventory().setChestplate(peirotal);
      p.getInventory().setItem(8, bussola);
      p.setGameMode(GameMode.SURVIVAL);
      
      p.setAllowFlight(false);
      ItemStack bussola1 = new ItemStack(Material.GOLD_HOE);
      ItemMeta kbussola1 = bussola1.getItemMeta();
      kbussola1.setDisplayName("§cBurstMaster");
      bussola1.setItemMeta(kbussola1);
      
      p.getInventory().setItem(1, bussola1);
     
      ItemStack espada = new ItemStack(Material.STONE_SWORD);
      ItemMeta m = espada.getItemMeta();
      m.setDisplayName("§aEspada");
      espada.setItemMeta(m);
      
      p.getInventory().setItem(0, espada);
      ArrayL.usandokit.add(p.getName());
      API.darRecraft(p);
    }
    if (getAbility(p) == "Confuser")
    {
    	ItemStack espada = new ItemStack(Material.STONE_SWORD);
        ItemMeta m = espada.getItemMeta();
        m.setDisplayName("§aEspada");
        espada.setItemMeta(m);
        ItemStack peirotal = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta peitoralk = (LeatherArmorMeta) peirotal.getItemMeta();
        peitoralk.setDisplayName("§dPeitoral");
        peitoralk.setColor(Color.RED);
        peirotal.setItemMeta(peitoralk);
        p.getInventory().setChestplate(peirotal);
      ItemStack bussola = new ItemStack(Material.COMPASS);
      ItemMeta kbussola = bussola.getItemMeta();
      kbussola.setDisplayName("§cBussola");
      bussola.setItemMeta(kbussola);
      p.setGameMode(GameMode.SURVIVAL);
      
      p.setAllowFlight(false);
      p.getInventory().setItem(8, bussola);
      p.getInventory().setItem(0, espada);
      
      ArrayL.usandokit.add(p.getName());
      
      API.darRecraft(p);
    }
    if (getAbility(p) == "Fireman")
    {
      p.getInventory().clear();
      ItemStack bussola = new ItemStack(Material.COMPASS);
      ItemMeta kbussola = bussola.getItemMeta();
      kbussola.setDisplayName("§cBussola");
      bussola.setItemMeta(kbussola);
      p.setGameMode(GameMode.SURVIVAL);
      ItemStack peirotal = new ItemStack(Material.LEATHER_CHESTPLATE);
      LeatherArmorMeta peitoralk = (LeatherArmorMeta) peirotal.getItemMeta();
      peitoralk.setDisplayName("§dPeitoral");
      peitoralk.setColor(Color.RED);
      peirotal.setItemMeta(peitoralk);
      p.getInventory().setChestplate(peirotal);
      p.setAllowFlight(false);
      p.getInventory().setItem(8, bussola);
      ItemStack espada = new ItemStack(Material.STONE_SWORD);
      ItemMeta m = espada.getItemMeta();
      m.setDisplayName("§aEspada");
      espada.setItemMeta(m);
      
      p.getInventory().setItem(0, espada);
      
      ArrayL.usandokit.add(p.getName());
      
      API.darRecraft(p);
    }
    if (getAbility(p) == "Fisherman")
    {
      p.getInventory().clear();
      ItemStack bussola = new ItemStack(Material.COMPASS);
      ItemMeta kbussola = bussola.getItemMeta();
      kbussola.setDisplayName("§cBussola");
      bussola.setItemMeta(kbussola);
      ItemStack peirotal = new ItemStack(Material.LEATHER_CHESTPLATE);
      LeatherArmorMeta peitoralk = (LeatherArmorMeta) peirotal.getItemMeta();
      peitoralk.setDisplayName("§dPeitoral");
      peitoralk.setColor(Color.RED);
      peirotal.setItemMeta(peitoralk);
      p.getInventory().setChestplate(peirotal);
      p.getInventory().setItem(8, bussola);
      ItemStack espada = new ItemStack(Material.STONE_SWORD);
      ItemMeta m = espada.getItemMeta();
      m.setDisplayName("§aEspada");
      espada.setItemMeta(m);
      p.setGameMode(GameMode.SURVIVAL);
      
      p.setAllowFlight(false);
      p.getInventory().setItem(0, espada);
      
      p.getInventory().setItem(1, new ItemStack(Material.FISHING_ROD));
      ArrayL.usandokit.add(p.getName());
      
      API.darRecraft(p);
    }
    if (getAbility(p) == "Hulk")
    {
      p.getInventory().clear();
      ItemStack bussola = new ItemStack(Material.COMPASS);
      ItemMeta kbussola = bussola.getItemMeta();
      kbussola.setDisplayName("§cBussola");
      bussola.setItemMeta(kbussola);
      ItemStack peirotal = new ItemStack(Material.LEATHER_CHESTPLATE);
      LeatherArmorMeta peitoralk = (LeatherArmorMeta) peirotal.getItemMeta();
      peitoralk.setDisplayName("§dPeitoral");
      peitoralk.setColor(Color.RED);
      peirotal.setItemMeta(peitoralk);
      p.getInventory().setChestplate(peirotal);
      p.getInventory().setItem(8, bussola);
      p.setGameMode(GameMode.SURVIVAL);
      
      p.setAllowFlight(false);
      ItemStack espada = new ItemStack(Material.STONE_SWORD);
      ItemMeta m = espada.getItemMeta();
      m.setDisplayName("§aEspada");
      espada.setItemMeta(m);
      
      p.getInventory().setItem(0, espada);
      
      ArrayL.usandokit.add(p.getName());
      Hulk.hulk.add(p);
      
      API.darRecraft(p);
    }
    if (getAbility(p) == "Kangaroo")
    {
      p.getInventory().clear();
      ItemStack bussola = new ItemStack(Material.COMPASS);
      ItemMeta kbussola = bussola.getItemMeta();
      kbussola.setDisplayName("§cBussola");
      bussola.setItemMeta(kbussola);
      ItemStack peirotal = new ItemStack(Material.LEATHER_CHESTPLATE);
      LeatherArmorMeta peitoralk = (LeatherArmorMeta) peirotal.getItemMeta();
      peitoralk.setDisplayName("§dPeitoral");
      peitoralk.setColor(Color.RED);
      peirotal.setItemMeta(peitoralk);
      p.getInventory().setChestplate(peirotal);
      p.getInventory().setItem(8, bussola);
      ItemStack espada = new ItemStack(Material.STONE_SWORD);
      ItemMeta m = espada.getItemMeta();
      m.setDisplayName("§aEspada");
      espada.setItemMeta(m);
      p.setGameMode(GameMode.SURVIVAL);
      
      p.setAllowFlight(false);
      p.getInventory().setItem(0, espada);
      
      ItemStack leash = new ItemStack(Material.FIREWORK);
      ItemMeta m1 = leash.getItemMeta();
      m1.setDisplayName("§4Kangaroo");
      leash.setItemMeta(m1);
      p.getInventory().setItem(1, leash);
      ArrayL.usandokit.add(p.getName());
      
      API.darRecraft(p);
    }
    if (getAbility(p) == "Ninja")
    {
      p.getInventory().clear();
      ItemStack bussola = new ItemStack(Material.COMPASS);
      ItemMeta kbussola = bussola.getItemMeta();
      kbussola.setDisplayName("§cBussola");
      bussola.setItemMeta(kbussola);
      ItemStack peirotal = new ItemStack(Material.LEATHER_CHESTPLATE);
      LeatherArmorMeta peitoralk = (LeatherArmorMeta) peirotal.getItemMeta();
      peitoralk.setDisplayName("§dPeitoral");
      peitoralk.setColor(Color.RED);
      peirotal.setItemMeta(peitoralk);
      p.getInventory().setChestplate(peirotal);
      p.getInventory().setItem(8, bussola);
      ItemStack espada = new ItemStack(Material.STONE_SWORD);
      ItemMeta m = espada.getItemMeta();
      m.setDisplayName("§aEspada");
      espada.setItemMeta(m);
      p.setGameMode(GameMode.SURVIVAL);
      
      p.setAllowFlight(false);
      p.getInventory().setItem(0, espada);
      ArrayL.usandokit.add(p.getName());
      ArrayL.ninja.add(p.getName());
      
      API.darRecraft(p);
    }
    if (getAbility(p) == "Terrorista")
    {
      p.getInventory().clear();
      ItemStack bussola = new ItemStack(Material.COMPASS);
      ItemMeta kbussola = bussola.getItemMeta();
      kbussola.setDisplayName("§cBussola");
      bussola.setItemMeta(kbussola);
      p.setGameMode(GameMode.SURVIVAL);
      ItemStack peirotal = new ItemStack(Material.LEATHER_CHESTPLATE);
      LeatherArmorMeta peitoralk = (LeatherArmorMeta) peirotal.getItemMeta();
      peitoralk.setDisplayName("§dPeitoral");
      peitoralk.setColor(Color.RED);
      peirotal.setItemMeta(peitoralk);
      p.getInventory().setChestplate(peirotal);
      p.setAllowFlight(false);
      p.getInventory().setItem(8, bussola);
      ItemStack espada = new ItemStack(Material.STONE_SWORD);
      ItemMeta m = espada.getItemMeta();
      m.setDisplayName("§aEspada");
      espada.setItemMeta(m);
      
      p.getInventory().setItem(0, espada);
      p.getInventory().setItem(1, new ItemStack(Material.MAGMA_CREAM));
      ArrayL.usandokit.add(p.getName());
      
      API.darRecraft(p);
    }
    if (getAbility(p) == "Poseidon")
    {
      p.getInventory().clear();
      ItemStack bussola = new ItemStack(Material.COMPASS);
      ItemMeta kbussola = bussola.getItemMeta();
      kbussola.setDisplayName("§cBussola");
      bussola.setItemMeta(kbussola);
      ItemStack peirotal = new ItemStack(Material.LEATHER_CHESTPLATE);
      LeatherArmorMeta peitoralk = (LeatherArmorMeta) peirotal.getItemMeta();
      peitoralk.setDisplayName("§dPeitoral");
      peitoralk.setColor(Color.RED);
      peirotal.setItemMeta(peitoralk);
      p.getInventory().setChestplate(peirotal);
      p.getInventory().setItem(8, bussola);
      ItemStack espada = new ItemStack(Material.STONE_SWORD);
      ItemMeta m = espada.getItemMeta();
      m.setDisplayName("§aEspada");
      espada.setItemMeta(m);
      p.setGameMode(GameMode.SURVIVAL);
      
      p.setAllowFlight(false);
      p.getInventory().setItem(0, espada);
      ArrayL.usandokit.add(p.getName());
      
      API.darRecraft(p);
    }
    if (getAbility(p) == "Snail")
    {
      p.getInventory().clear();
      ItemStack bussola = new ItemStack(Material.COMPASS);
      ItemMeta kbussola = bussola.getItemMeta();
      kbussola.setDisplayName("§cBussola");
      bussola.setItemMeta(kbussola);
      p.setGameMode(GameMode.SURVIVAL);
      ItemStack peirotal = new ItemStack(Material.LEATHER_CHESTPLATE);
      LeatherArmorMeta peitoralk = (LeatherArmorMeta) peirotal.getItemMeta();
      peitoralk.setDisplayName("§dPeitoral");
      peitoralk.setColor(Color.RED);
      peirotal.setItemMeta(peitoralk);
      p.getInventory().setChestplate(peirotal);
      p.setAllowFlight(false);
      p.getInventory().setItem(8, bussola);
      ItemStack espada = new ItemStack(Material.STONE_SWORD);
      ItemMeta m = espada.getItemMeta();
      m.setDisplayName("§aEspada");
      espada.setItemMeta(m);
      
      p.getInventory().setItem(0, espada);
      ArrayL.usandokit.add(p.getName());
      
      API.darRecraft(p);
    }
    if (getAbility(p) == "Specialist")
    {
      p.getInventory().clear();
      ItemStack bussola = new ItemStack(Material.COMPASS);
      ItemMeta kbussola = bussola.getItemMeta();
      kbussola.setDisplayName("§cBussola");
      bussola.setItemMeta(kbussola);
      p.setGameMode(GameMode.SURVIVAL);
      ItemStack peirotal = new ItemStack(Material.LEATHER_CHESTPLATE);
      LeatherArmorMeta peitoralk = (LeatherArmorMeta) peirotal.getItemMeta();
      peitoralk.setDisplayName("§dPeitoral");
      peitoralk.setColor(Color.RED);
      peirotal.setItemMeta(peitoralk);
      p.getInventory().setChestplate(peirotal);
      p.setAllowFlight(false);
      p.getInventory().setItem(8, bussola);
      p.getInventory().setItem(1, new ItemStack(Material.BOOK));
      ItemStack espada = new ItemStack(Material.STONE_SWORD);
      ItemMeta m = espada.getItemMeta();
      m.setDisplayName("§aEspada");
      espada.setItemMeta(m);
      p.getInventory().setItem(0, espada);
      ArrayL.usandokit.add(p.getName());
      
      API.darRecraft(p);
    }
    if (getAbility(p) == "Stomper")
    {
      p.getInventory().clear();
      p.setGameMode(GameMode.SURVIVAL);
      
      p.setAllowFlight(false);
      ItemStack Velotrol = new ItemStack(Material.GOLDEN_APPLE);
      ItemMeta kVelotrol = Velotrol.getItemMeta();
      kVelotrol.setDisplayName("§6Stomper");
      Velotrol.setItemMeta(kVelotrol);
      ItemStack espada = new ItemStack(Material.STONE_SWORD);
      ItemMeta m = espada.getItemMeta();
      m.setDisplayName("§aEspada");
      espada.setItemMeta(m);
      ItemStack peirotal = new ItemStack(Material.LEATHER_CHESTPLATE);
      LeatherArmorMeta peitoralk = (LeatherArmorMeta) peirotal.getItemMeta();
      peitoralk.setDisplayName("§dPeitoral");
      peitoralk.setColor(Color.RED);
      peirotal.setItemMeta(peitoralk);
      p.getInventory().setChestplate(peirotal);
      p.getInventory().setItem(0, espada);
      ItemStack bussola = new ItemStack(Material.COMPASS);
      ItemMeta kbussola = bussola.getItemMeta();
      kbussola.setDisplayName("§cBussola");
      bussola.setItemMeta(kbussola);
      
      p.getInventory().setItem(8, bussola);
      
      p.getInventory().setItem(1, Velotrol);
      ArrayL.usandokit.add(p.getName());
      ArrayL.stomper.add(p.getName());
      API.darRecraft(p);
    }
    if (getAbility(p) == "Mago")
    {
      p.getInventory().clear();
      ItemStack bussola = new ItemStack(Material.COMPASS);
      ItemMeta kbussola = bussola.getItemMeta();
      kbussola.setDisplayName("§cBussola");
      bussola.setItemMeta(kbussola);
      p.setGameMode(GameMode.SURVIVAL);
      ItemStack peirotal = new ItemStack(Material.LEATHER_CHESTPLATE);
      LeatherArmorMeta peitoralk = (LeatherArmorMeta) peirotal.getItemMeta();
      peitoralk.setDisplayName("§dPeitoral");
      peitoralk.setColor(Color.RED);
      peirotal.setItemMeta(peitoralk);
      p.getInventory().setChestplate(peirotal);
      p.setAllowFlight(false);
      p.getInventory().setItem(8, bussola);
      p.getInventory().setItem(1, new ItemStack(Material.POTION));
      ItemStack espada = new ItemStack(Material.STONE_SWORD);
      ItemMeta m = espada.getItemMeta();
      m.setDisplayName("§aEspada");
      espada.setItemMeta(m);
      
      p.getInventory().setItem(0, espada);
      ArrayL.usandokit.add(p.getName());
      
      API.darRecraft(p);
    }
    if (getAbility(p) == "Thor")
    {
      p.getInventory().clear();
      ItemStack bussola = new ItemStack(Material.COMPASS);
      ItemMeta kbussola = bussola.getItemMeta();
      kbussola.setDisplayName("§cBussola");
      bussola.setItemMeta(kbussola);
      ItemStack peirotal = new ItemStack(Material.LEATHER_CHESTPLATE);
      LeatherArmorMeta peitoralk = (LeatherArmorMeta) peirotal.getItemMeta();
      peitoralk.setDisplayName("§dPeitoral");
      peitoralk.setColor(Color.RED);
      peirotal.setItemMeta(peitoralk);
      p.getInventory().setChestplate(peirotal);
      p.getInventory().setItem(8, bussola);
      p.getInventory().setItem(1, new ItemStack(Material.GOLD_AXE));
      ItemStack espada = new ItemStack(Material.STONE_SWORD);
      ItemMeta m = espada.getItemMeta();
      m.setDisplayName("§aEspada");
      espada.setItemMeta(m);
      
      p.getInventory().setItem(0, espada);
      p.setGameMode(GameMode.SURVIVAL);
      
      p.setAllowFlight(false);
      ArrayL.usandokit.add(p.getName());
      ArrayL.thor.add(p.getName());
      
      API.darRecraft(p);
    }
    if (getAbility(p) == "Turtle")
    {
      p.getInventory().clear();
      ItemStack bussola = new ItemStack(Material.COMPASS);
      ItemMeta kbussola = bussola.getItemMeta();
      kbussola.setDisplayName("§cBussola");
      bussola.setItemMeta(kbussola);
      ItemStack peirotal = new ItemStack(Material.LEATHER_CHESTPLATE);
      LeatherArmorMeta peitoralk = (LeatherArmorMeta) peirotal.getItemMeta();
      peitoralk.setDisplayName("§dPeitoral");
      peitoralk.setColor(Color.RED);
      peirotal.setItemMeta(peitoralk);
      p.getInventory().setChestplate(peirotal);
      p.getInventory().setItem(8, bussola);
      ItemStack espada = new ItemStack(Material.STONE_SWORD);
      ItemMeta m = espada.getItemMeta();
      espada.setItemMeta(m);
      p.setGameMode(GameMode.SURVIVAL);
      
      p.setAllowFlight(false);
      p.getInventory().setItem(0, espada);
      ArrayL.usandokit.add(p.getName());
      
      API.darRecraft(p);
    }
    if (getAbility(p) == "Viking")
    {
      p.getInventory().clear();
      ItemStack bussola = new ItemStack(Material.COMPASS);
      ItemMeta kbussola = bussola.getItemMeta();
      kbussola.setDisplayName("§cBussola");
      bussola.setItemMeta(kbussola);
      p.getInventory().setItem(8, bussola);
      ItemStack peirotal = new ItemStack(Material.LEATHER_CHESTPLATE);
      LeatherArmorMeta peitoralk = (LeatherArmorMeta) peirotal.getItemMeta();
      peitoralk.setDisplayName("§dPeitoral");
      peitoralk.setColor(Color.RED);
      peirotal.setItemMeta(peitoralk);
      p.getInventory().setChestplate(peirotal);
      ItemStack bussola1 = new ItemStack(Material.STONE_AXE);
      ItemMeta kbussola1 = bussola1.getItemMeta();
      kbussola1.setDisplayName("§cViking");
      bussola1.setItemMeta(kbussola1);
      p.getInventory().setItem(0, bussola1);
      ArrayL.usandokit.add(p.getName());
      ArrayL.viking.add(p.getName());
      p.setGameMode(GameMode.SURVIVAL);
      
      p.setAllowFlight(false);
      API.darRecraft(p);
    }
    if (getAbility(p) == "Viper")
    {
      p.getInventory().clear();
      
      ItemStack espada = new ItemStack(Material.STONE_SWORD);
      ItemMeta m = espada.getItemMeta();
      m.setDisplayName("§aEspada");
      espada.setItemMeta(m);
      ItemStack peirotal = new ItemStack(Material.LEATHER_CHESTPLATE);
      LeatherArmorMeta peitoralk = (LeatherArmorMeta) peirotal.getItemMeta();
      peitoralk.setDisplayName("§dPeitoral");
      peitoralk.setColor(Color.RED);
      peirotal.setItemMeta(peitoralk);
      p.getInventory().setChestplate(peirotal);
      ItemStack bussola = new ItemStack(Material.COMPASS);
      ItemMeta kbussola = bussola.getItemMeta();
      kbussola.setDisplayName("§cBussola");
      bussola.setItemMeta(kbussola);
      p.setGameMode(GameMode.SURVIVAL);
      
      p.setAllowFlight(false);
      p.getInventory().setItem(8, bussola);
      p.getInventory().setItem(0, espada);
      
      ArrayL.usandokit.add(p.getName());
      
      API.darRecraft(p);
    }
    if (getAbility(p) == "QuickDropper")
    {
      p.getInventory().clear();
      
      ItemStack espada = new ItemStack(Material.STONE_SWORD);
      ItemMeta m = espada.getItemMeta();
      m.setDisplayName("§aEspada");
      espada.setItemMeta(m);
      ItemStack peirotal = new ItemStack(Material.LEATHER_CHESTPLATE);
      LeatherArmorMeta peitoralk = (LeatherArmorMeta) peirotal.getItemMeta();
      peitoralk.setDisplayName("§dPeitoral");
      peitoralk.setColor(Color.RED);
      peirotal.setItemMeta(peitoralk);
      p.getInventory().setChestplate(peirotal);
      ItemStack bussola = new ItemStack(Material.COMPASS);
      ItemMeta kbussola = bussola.getItemMeta();
      kbussola.setDisplayName("§cBussola");
      bussola.setItemMeta(kbussola);
      
      p.getInventory().setItem(8, bussola);
      p.getInventory().setItem(0, espada);
      p.setGameMode(GameMode.SURVIVAL);
      
      p.setAllowFlight(false);
      ArrayL.usandokit.add(p.getName());
      ArrayL.quickdropper.add(p.getName());
      
      API.darRecraft(p);
    }
    if (getAbility(p) == "Switcher")
    {
      p.getInventory().clear();
      
      ItemStack espada = new ItemStack(Material.STONE_SWORD);
      ItemMeta m = espada.getItemMeta();
      m.setDisplayName("§aEspada");
      espada.setItemMeta(m);
      ItemStack bussola = new ItemStack(Material.COMPASS);
      ItemMeta kbussola = bussola.getItemMeta();
      kbussola.setDisplayName("§cBussola");
      bussola.setItemMeta(kbussola);
      p.setGameMode(GameMode.SURVIVAL);
      ItemStack peirotal = new ItemStack(Material.LEATHER_CHESTPLATE);
      LeatherArmorMeta peitoralk = (LeatherArmorMeta) peirotal.getItemMeta();
      peitoralk.setDisplayName("§dPeitoral");
      peitoralk.setColor(Color.RED);
      peirotal.setItemMeta(peitoralk);
      p.getInventory().setChestplate(peirotal);
      
      p.setAllowFlight(false);
      p.getInventory().setItem(8, bussola);
      ItemStack espada1 = new ItemStack(Material.SNOW_BALL);
      ItemMeta m1 = espada1.getItemMeta();
      espada1.setItemMeta(m1);
      espada1.setAmount(32);
      p.getInventory().setItem(0, espada);
      p.getInventory().setItem(1, espada1);
      
      ArrayL.usandokit.add(p.getName());
      
      API.darRecraft(p);
    }
  }
}
