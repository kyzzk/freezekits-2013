package Otaku.Comandos;

import java.util.ArrayList;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import Otaku.Main;
import Otaku.API.Title;
import Otaku.Skill.ArrayL;

@SuppressWarnings("deprecation")
public class Admin implements CommandExecutor, Listener {
	
	
	public static ArrayList<String> inAdmin = new ArrayList<String>();
	
    public static ArrayList<String> chekado = new ArrayList<String>();
    public static ArrayList<String> vanish = new ArrayList<String>();
    public static ArrayList<String> arenao = new ArrayList<String>();
    public static ArrayList<Player> specs = new ArrayList<>();
    public HashMap<String, ItemStack[]> hotbar = new HashMap<String, ItemStack[]>();
    public static HashMap<Player, ItemStack[]> saveinv = new HashMap<>();  
    public static HashMap<Player, ItemStack[]> savearmor = new HashMap<>();
    public static HashMap<String, ItemStack[]> coisas = new HashMap<String, ItemStack[]>();
  
    @EventHandler
    public void invsee(PlayerInteractEntityEvent e) {
    	if (e.getRightClicked() instanceof Player) {
        	Player p = e.getPlayer();
        	Player h = (Player) e.getRightClicked();
        	
        	if (inAdmin.contains(p.getName())) {
        		p.openInventory(h.getInventory());
        	}
    	}
    }
    
  public void setininAdminMode(Player p, boolean ininAdminmode)
  {
    if (ininAdminmode)
    {
      Player[] arrayOfPlayer;
      int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
      for (int i = 0; i < j; i++)
      {
        Player gamers = arrayOfPlayer[i];
        gamers.hidePlayer(p);
      }
    }
    else
    {
      Player[] arrayOfPlayer;
      int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
      for (int i = 0; i < j; i++)
      {
        Player gamers = arrayOfPlayer[i];
        gamers.showPlayer(p);
      }
    }
  }
          
          public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args)
          {
            if (!(sender instanceof Player))
            {
              sender.sendMessage("Comando apenas para players.");
              return true;
            }
            Player p = (Player)sender;
            if (!p.hasPermission("kitpvp.ininAdmin"))
            {
              p.sendMessage("§cVoce nao tem permissao.");
              return true;
            }
            if (cmd.equalsIgnoreCase("v"))
            {
              if (vanish.contains(p.getName()))
              {
                vanish.remove(p.getName());
                Player[] arrayOfPlayer1;
                int j = (arrayOfPlayer1 = Bukkit.getOnlinePlayers()).length;
                for (int i = 0; i < j; i++)
                {
                  Player o = arrayOfPlayer1[i];
                  o.showPlayer(p);
                }
                p.sendMessage(ChatColor.GOLD + "Todos podem te ver agora.");
              }
              else
              {
                vanish.add(p.getName());
                Player[] arrayOfPlayer1;
                int j = (arrayOfPlayer1 = Bukkit.getOnlinePlayers()).length;
                for (int i = 0; i < j; i++)
                {
                  Player o = arrayOfPlayer1[i];
                  o.hidePlayer(p);
                }
                p.sendMessage(ChatColor.GOLD + "Ninguem consegue te ver agora.");
              }
            }
            else if (cmd.equalsIgnoreCase("ininAdmin"))
            {
              if (inAdmin.contains(p.getName()))
              {
                inAdmin.remove(p.getName());
                Player[] onlinePlayers;
                int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length;
                for (int i = 0; i < length; i++)
                {
                  Player jogadores;
                  if ((jogadores = onlinePlayers[i]).hasPermission("sp.ininAdmin")) {
                    jogadores.hidePlayer(p);
                  }
                }
                setininAdminMode(p, false);
                p.sendMessage("§cVoce saiu do modo ininAdmin.");
                p.getInventory().clear();
                p.removePotionEffect(PotionEffectType.INVISIBILITY);
                p.setGameMode(GameMode.SURVIVAL);
                ArrayL.resetKit(p);
                Otaku.API.API.darItemsSpawn(p);
                p.showPlayer(p);
                p.updateInventory();
                p.getInventory().setContents((ItemStack[])this.hotbar.get(p.getName()));
              }
              else
              {
                inAdmin.add(p.getName());
                Player[] onlinePlayers2;
                int length2 = (onlinePlayers2 = Bukkit.getOnlinePlayers()).length;
                for (int j = 0; j < length2; j++) {
                  onlinePlayers2[j].showPlayer(p);
                }
                this.hotbar.put(p.getName(), p.getInventory().getContents());
                p.getInventory().clear();
                p.setGameMode(GameMode.CREATIVE);
                p.setAllowFlight(true);
                p.setFlying(true);
                p.sendMessage("§cVoce entrou no Modo ininAdmin");
                
                ItemStack inve1 = new ItemStack(Material.FEATHER);
                ItemMeta invem1 = inve1.getItemMeta();
                ArrayList<String> lore1 = new ArrayList<String>();
                invem1.setDisplayName("§cNoFall");
                lore1.add("§7Clique com o direito no Hacker");
                invem1.setLore(lore1);
                inve1.setItemMeta(invem1);
                
                ItemStack inve2 = new ItemStack(Material.MAGMA_CREAM);
                ItemMeta invem2 = inve2.getItemMeta();
                ArrayList<String> lore2 = new ArrayList<String>();
                invem2.setDisplayName("§cFastininAdmin");
                lore2.add("§7Clique com o direito no Hacker");
                invem2.setLore(lore2);
                inve2.setItemMeta(invem2);
                
                
                ItemStack inve23 = new ItemStack(Material.MUSHROOM_SOUP);
                ItemMeta invem23 = inve23.getItemMeta();
                ArrayList<String> lore23 = new ArrayList<String>();
                invem23.setDisplayName("§cAutoSoup");
                lore23.add("§7Clique com o direito no Hacker");
                invem23.setLore(lore23);
                inve23.setItemMeta(invem23);
                
                ItemStack bow6 = new ItemStack(Material.GOLD_INGOT);
                ItemMeta bowmeta6 = bow6.getItemMeta();
                bowmeta6.setDisplayName("§cCrashador");
                ArrayList<String> lore8 = new ArrayList<String>();
                lore8.add("§7TrialMod/Mod nao pode crashar!");
                bowmeta6.setLore(lore8);
                bow6.setItemMeta(bowmeta6);
                
                ItemStack bow7 = new ItemStack(Material.IRON_FENCE);
                ItemMeta bowmeta7 = bow7.getItemMeta();
                bowmeta7.setDisplayName("§cArena");
                ArrayList<String> lore9 = new ArrayList<String>();
                lore9.add("§7Clique com o direito no Hacker");
                bowmeta7.setLore(lore9);
                bow7.setItemMeta(bowmeta7);
                
                ItemStack bow72 = new ItemStack(Material.NETHER_BRICK_ITEM);
                ItemMeta bowmeta72 = bow72.getItemMeta();
                bowmeta72.setDisplayName("§cTeste Macro");
                ArrayList<String> lore92 = new ArrayList<String>();
                lore92.add("§7Clique com o direito no Hacker");
                bowmeta72.setLore(lore92);
                bow72.setItemMeta(bowmeta72);
                
                ItemStack bow71 = new ItemStack(Material.STICK);
                ItemMeta bowmeta71 = bow71.getItemMeta();
                bowmeta71.setDisplayName("§cKnockBack");
                bowmeta71.addEnchant(Enchantment.KNOCKBACK, 5, true);         
                ArrayList<String> lore91 = new ArrayList<String>();
                lore91.add("§7TESTE KNOCKBACK");
                bowmeta71.setLore(lore91);
                bow71.setItemMeta(bowmeta71);
                
                setininAdminMode(p, true);
              //  Title.sendTitle(p, "§cVoce Entrou");
               // Title.sendSubTitle(p, "§7Modo Admin");
                p.sendMessage("§cVoce entrou no modo ininAdmin.");
                p.sendMessage("§eNinguem pode te ver agora!");
                Otaku.Skill.ArrayL.resetKit(p);
                p.hidePlayer(p);
                p.getInventory().clear();
                p.setGameMode(GameMode.CREATIVE);
                p.getInventory().clear();
                p.getInventory().setItem(3, inve1);
                p.getInventory().setItem(1, inve23);
                p.getInventory().setItem(4, inve2);
                p.getInventory().setItem(5, bow7);
                p.getInventory().setItem(8, bow71);
                p.getInventory().setItem(7, bow6);
                p.getInventory().setItem(0, bow72);
                p.updateInventory();
                Player[] arrayOfPlayer;
                int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
                for (int i = 0; i < j; i++)
                {
                  Player p2 = arrayOfPlayer[i];
                  if (p2.hasPermission("kitpvp.ininAdmin"))
                  {
                    p2.sendMessage(Main.m.getConfig().getString("SV").replace("&", "§") + "§7 " + p.getName() + " §centrou no modo ininAdmin");
                    p2.showPlayer(p);
                  }
                }
              }
            }
            return false;
            }
          
  @EventHandler
  public void onininAdminAbririnv(PlayerInteractEntityEvent event)
  {
    if (!(event.getRightClicked() instanceof Player)) {
      return;
    }
    Player p1 = event.getPlayer();
    Player r = (Player)event.getRightClicked();
    if ((inAdmin.contains(p1.getName())) && (p1.getItemInHand().getType() == Material.AIR)) {
      p1.openInventory(r.getInventory());
    }
  }
  @EventHandler
  public void ininAdminListener(PlayerQuitEvent e)
  {
    Player p = e.getPlayer();
    inAdmin.remove(p.getName());
  }
  
  @EventHandler
  public void nofall(PlayerInteractEntityEvent e)
  {
    if ((e.getRightClicked() instanceof Player))
    {
      Player p = e.getPlayer();
      Player r = (Player)e.getRightClicked();
      if ((inAdmin.contains(p.getName()) && (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§cNoFall"))))
      {
        Vector sponge = r.getLocation().getDirection().multiply(0).setY(1.4D);
        r.setVelocity(sponge);
      }
    }
  }
  @EventHandler
  public void autoSoup(PlayerInteractEntityEvent e)
  {
    final Player p = e.getPlayer();
    if (!(e.getRightClicked() instanceof Player)) {
      return;
    }
    final Player target = (Player)e.getRightClicked();
    if (chekado.contains(target.getName()))
    {
      p.sendMessage("§cJa estao checando o AutoSoup nesse player!");
      return;
    }
    if ((inAdmin.contains(p.getName())) && 
      (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§cAutoSoup")))
    {
      coisas.put(target.getName(), target.getInventory().getContents());
      Inventory inv = target.getInventory();
      inv.clear();
      verInv(p, target);
      target.setHealth(10.0D);
      target.getInventory().setItem(10, new ItemStack(Material.MUSHROOM_SOUP));
      chekado.add(target.getName());
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
      {
        public void run()
        {
          target.setHealth(10.0D);
          target.getInventory().setItem(11, new ItemStack(Material.MUSHROOM_SOUP));
        }
      }, 10L);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
      {
        public void run()
        {
          target.setHealth(10.0D);
          target.getInventory().setItem(12, new ItemStack(Material.MUSHROOM_SOUP));
        }
      }, 20L);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
      {
        public void run()
        {
          target.setHealth(20.0D);
          if (getAmount(target, Material.BOWL) == 0)
          {
            p.sendMessage("§cProvabilidade: Nula!");
            target.getInventory().setContents((ItemStack[])coisas.get(target.getName()));
            chekado.remove(target.getName());
            return;
          }
          if (getAmount(target, Material.BOWL) == 1)
          {
            p.sendMessage("§cProvabilidade: Provavelmente!");
            target.getInventory().setContents((ItemStack[])coisas.get(target.getName()));
            chekado.remove(target.getName());
            return;
          }
          if (getAmount(target, Material.BOWL) == 3)
          {
            p.sendMessage("§cProvabilidade: Definitavente!");
            target.getInventory().setContents((ItemStack[])coisas.get(target.getName()));
            chekado.remove(target.getName());
            return;
          }
        }
      }, 40L);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
      {
        public void run()
        {
          p.closeInventory();
        }
      }, 70L);
    }
  }

  @EventHandler
  public void aoInteragir(PlayerInteractEvent e)
  {
    final Player p = e.getPlayer();
    if ((inAdmin.contains(p.getName())) && (
      (e.getAction() == Action.RIGHT_CLICK_BLOCK) || (e.getAction() == Action.RIGHT_CLICK_AIR))) {
      if (p.getItemInHand().getType() == Material.MAGMA_CREAM)
      {
        p.chat("/ininAdmin");
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
        {
          public void run()
          {
            p.chat("/ininAdmin");
          }
        }, 10L);
      }
    }
  }
  
  @EventHandler
  public void TestarOMacroDoJogador(PlayerInteractEntityEvent Event)
  {
    if (!(Event.getRightClicked() instanceof Player)) {
      return;
    }
    Player P1 = Event.getPlayer();
    Player R = (Player)Event.getRightClicked();
    if ((inAdmin.contains(P1.getName())) && (P1.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§cTeste Macro"))) {
      P1.chat("/testmacro " + R.getName());
    }
  }
  
  @EventHandler
  public void CrasharP(PlayerInteractEntityEvent Event)
  {
    if (!(Event.getRightClicked() instanceof Player)) {
      return;
    }
    Player P1 = Event.getPlayer();
    Player R = (Player)Event.getRightClicked();
    if ((inAdmin.contains(P1.getName())) && (P1.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§cCrashador"))) {
      P1.chat("/crash " + R.getName());
    }
  }
  
  @EventHandler
  public void ininAdminListener6(PlayerJoinEvent e)
  {
    Player p = e.getPlayer();
    Player[] arrayOfPlayer;
	int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
    for (int i = 0; i < j; i++)
    {
      Player a = arrayOfPlayer[i];
      if (vanish.contains(a)) {
        p.hidePlayer(a);
      }
    }
  }
  
  public static void verInv(Player p, Player de)
  {
    PlayerInventory inv = de.getInventory();
    p.openInventory(inv);
  }
  public static int getAmount(Player p, Material m)
  {
    int quantidade = 0;
    ItemStack[] arrayOfItemStack;
    int j = (arrayOfItemStack = p.getInventory().getContents()).length;
    for (int i = 0; i < j; i++)
    {
      ItemStack item = arrayOfItemStack[i];
      if ((item != null) && (item.getType() == m) && (item.getAmount() > 0)) {
        quantidade += item.getAmount();
      }
    }
    return quantidade;
  }
}
