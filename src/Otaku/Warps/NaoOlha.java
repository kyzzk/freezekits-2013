package Otaku.Warps;

import java.util.ArrayList;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Builder;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitScheduler;

import Otaku.Main;
import Otaku.API.API;
import Otaku.API.Messages;
import Otaku.API.Title;
import Otaku.Comandos.Admin;
import Otaku.Eventos.MostrarHabilidades;
import Otaku.Skill.ArrayL;
import Otaku.Skill.Metodos;

public class NaoOlha
  implements Listener, CommandExecutor
{
  public static ArrayList<String> Na1v1 = new ArrayList();
  public static ArrayList<String> EmPvP = new ArrayList();
  public static ArrayList<String> DontMove = new ArrayList();
  public static ArrayList<String> Teleporting = new ArrayList();
  public static HashMap<String, String> Desafiar = new HashMap();
  public static ItemStack N1v1 = new ItemStack(Material.BLAZE_ROD);
  public static ItemMeta N1v1Meta = N1v1.getItemMeta();
  public static ItemStack R1v1 = new ItemStack(Material.getMaterial(351));
  public static ItemMeta R1v1Meta = R1v1.getItemMeta();
  public static ItemStack R2v1 = new ItemStack(Material.getMaterial(351));
  public static ItemMeta R2v1Meta = R2v1.getItemMeta();

  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage("§cNao");
      return true;
    }
    if (cmd.getName().equalsIgnoreCase("1v1"))
    {
    	 Player p = (Player)sender;
    	    if (!(sender instanceof Player)) {
    	      return true;
    	    }
      if (args.length == 0) {
        if (!ArrayL.usandokit.contains(p.getName()))
        {
          World w = Bukkit.getServer().getWorld(Main.getPlugin().getConfig().getString("spawn3.world"));
          double x = Main.getPlugin().getConfig().getDouble("spawn3.x");
          double y = Main.getPlugin().getConfig().getDouble("spawn3.y");
          double z = Main.getPlugin().getConfig().getDouble("spawn3.z");
          Location lobby = new Location(w, x, y, z);
          lobby.setPitch((float)Main.getPlugin().getConfig().getDouble("spawn3.pitch"));
          lobby.setYaw((float)Main.getPlugin().getConfig().getDouble("spawn3.yaw"));
          p.teleport(lobby);
          
         // Set1v1.daritens(p);
          Metodos.removeAbility(p);
     //     Title.sendTitle(p, "§7Warp");
        //  Title.sendSubTitle(p, "§61v1");
          p.sendMessage(Main.m.getConfig().getString("SV").replace("&", "§") + " §7Bem-vindo ao 1v1 !");
          p.sendMessage(Main.m.getConfig().getString("SV").replace("&", "§") + " §7Para sair digite §c/1v1");
          p.updateInventory();
          MostrarHabilidades.setAbility(p, "Warp");
          ArrayL.usandokit.add(p.getName());
          p.getInventory().setItem(0, N1v1);
          p.getInventory().setItem(8, R1v1);
          p.setAllowFlight(false);
        }
        else
        {
          World w = Bukkit.getServer().getWorld(Main.getPlugin().getConfig().getString("spawn.world"));
          double x = Main.getPlugin().getConfig().getDouble("spawn.x");
          double y = Main.getPlugin().getConfig().getDouble("spawn.y");
          double z = Main.getPlugin().getConfig().getDouble("spawn.z");
          Location lobby = new Location(w, x, y, z);
          lobby.setPitch((float)Main.getPlugin().getConfig().getDouble("spawn.pitch"));
          lobby.setYaw((float)Main.getPlugin().getConfig().getDouble("spawn.yaw"));
          p.teleport(lobby);
          p.getInventory().clear();
          API.darItemsSpawn(p);
          p.setAllowFlight(false);
          ArrayL.usandokit.remove(p.getName());
          p.updateInventory();
          p.sendMessage("§7Voce Saiu do 1v1");
        }
      }
    }
    return false;
  }
  
  @EventHandler
  public void fast1v1(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    
    R2v1.setDurability((short)10);
    R2v1Meta.setDisplayName(ChatColor.GOLD + "1v1 §7 §cEsperando...");
    R2v1.setItemMeta(R2v1Meta);
    if (p.getItemInHand().isSimilar(R1v1))
    {
      Player[] arrayOfPlayer;
      int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
      for (int i = 0; i < j; i++)
      {
        Player s1 = arrayOfPlayer[i];
        if (s1.getInventory().contains(R2v1))
        {
          começar1v1(p, s1);
          Desafiar.put(p.getName(), s1.getName());
          return;
        }
      }
      p.setItemInHand(R2v1);
      API.msg(p, " ");
      API.msg(p, "§7Você entrou na fila do §c1v1 §7rapido.");
      API.msg(p, " ");
    }
    else if (p.getItemInHand().isSimilar(R2v1))
    {
      p.setItemInHand(R1v1);
      API.msg(p, " ");
      API.msg(p, "§7Você saiu da fila do §c1v1 §7rapido.");
      API.msg(p, " ");
    }
  }
  
  @EventHandler
  public void desafiador(PlayerInteractEntityEvent e)
  {
    Player p = e.getPlayer();
    if (e.getRightClicked().getType() == EntityType.PLAYER)
    {
      Player target = (Player)e.getRightClicked();
      if ((p.getItemInHand().isSimilar(N1v1)) && 
        (!EmPvP.contains(target.getName()))) {
        try
        {
          if (check(p, target))
          {
            começar1v1(p, target);
            Desafiar.put(p.getName(), target.getName());
          }
          Desafiar.put(p.getName(), target.getName());
          API.msg(p, " ");
          API.msg(p, "§7Você desafiou §c" + target.getName() + " §7espere-o aceitar.");
          API.msg(p, " ");
          
          API.msg(target, " ");
          API.msg(target, "§7Você foi desafiado por §c" + p.getName() + " §7clique para aceitar.");
          API.msg(target, " ");
        }
        catch (Exception e2)
        {
          e2.printStackTrace();
        }
      }
    }
  }
  
  @EventHandler
  public void command(PlayerCommandPreprocessEvent e)
  {
    Player p = e.getPlayer();
    if ((Na1v1.contains(p.getName())) && (!EmPvP.contains(p.getName())))
    {
      if (e.getMessage().equalsIgnoreCase("/1v1"))
      {
        e.setCancelled(false);
        return;
      }
      e.setCancelled(true);
      API.msg(p, "§cComando cancelado, use /1v1.");
      return;
    }
    if ((Na1v1.contains(p.getName())) && (EmPvP.contains(p.getName())))
    {
      API.msg(p, "§cComando cancelado, Você esta em 1v1.");
      e.setCancelled(true);
      return;
    }
  }
  
  @EventHandler
  public void death(PlayerDeathEvent e)
  {
    Player p = e.getEntity();
    if ((p.getKiller() instanceof Player))
    {
      Player b = p.getKiller();
      if (check(p, b))
      {
        Desafiar.remove(p.getName());
        Desafiar.remove(b.getName());
        cancelarMorte(b, p);
      }
    }
  }
  
  @EventHandler
  public void onDrop(PlayerDropItemEvent e)
  {
    Player p = e.getPlayer();
    if (EmPvP.contains(p.getName())) {
      e.getItemDrop().remove();
    }
  }
  
  @EventHandler
  public void join(PlayerJoinEvent e)
  {
    Player p = e.getPlayer();
    Player[] arrayOfPlayer;
    int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
    for (int i = 0; i < j; i++)
    {
      Player s1 = arrayOfPlayer[i];
      if (EmPvP.contains(s1.getName())) {
        s1.hidePlayer(p);
      }
    }
  }
  
  @EventHandler
  public void onQuit(PlayerQuitEvent e)
  {
    if (EmPvP.contains(e.getPlayer()))
    {
      Player[] arrayOfPlayer;
      int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
      for (int i = 0; i < j; i++)
      {
        Player todos = arrayOfPlayer[i];
        if (e.getPlayer().canSee(todos)) {
          cancelarMorte(e.getPlayer(), todos);
        }
      }
    }
  }
  
  public void cancelarMorte(final Player matador, final Player p)
  {
    p.setHealth(20);
    matador.setHealth(20);
    Desafiar.remove(p.getName());
    Desafiar.remove(matador.getName());
    
    Firework f = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
    Firework f2 = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
    Firework f3 = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
    
    FireworkMeta fm = f.getFireworkMeta();
    fm.addEffect(FireworkEffect.builder().flicker(false).trail(true).with(FireworkEffect.Type.BALL_LARGE).withColor(Color.ORANGE).withFade(Color.RED).build());
    fm.setPower(3);
    f.setFireworkMeta(fm);
    f2.setFireworkMeta(fm);
    f3.setFireworkMeta(fm);
    
    Location loc = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY() + 3.0D, p.getLocation().getZ());
    
    API.teleport(p, loc);
    
    p.setAllowFlight(true);
    p.setFlying(true);
    
    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
    {
      public void run()
      {
        p.setAllowFlight(false);
        p.setFlying(false);
        
        World w2 = Bukkit.getServer().getWorld(Main.getPlugin().getConfig().getString("pos2.world"));
        double x2 = Main.getPlugin().getConfig().getDouble("pos2.x");
        double y2 = Main.getPlugin().getConfig().getDouble("pos2.y");
        double z2 = Main.getPlugin().getConfig().getDouble("pos2.z");
        Location lobby2 = new Location(w2, x2, y2, z2);
        lobby2.setPitch((float)Main.getPlugin().getConfig().getDouble("pos2.pitch"));
        lobby2.setYaw((float)Main.getPlugin().getConfig().getDouble("pos2.yaw"));
        
        p.getWorld().playEffect(lobby2, Effect.ENDER_SIGNAL, 5);
        p.getPlayer().playSound(p.getLocation(), Sound.ZOMBIE_REMEDY, 5.0F, 5.0F);
        p.teleport(lobby2);
        
        World w = Bukkit.getServer().getWorld(Main.getPlugin().getConfig().getString("pos1.world"));
        double x = Main.getPlugin().getConfig().getDouble("pos1.x");
        double y = Main.getPlugin().getConfig().getDouble("pos1.y");
        double z = Main.getPlugin().getConfig().getDouble("pos1.z");
        Location lobby = new Location(w, x, y, z);
        lobby.setPitch((float)Main.getPlugin().getConfig().getDouble("pos1.pitch"));
        lobby.setYaw((float)Main.getPlugin().getConfig().getDouble("pos1.yaw"));
        matador.getWorld().playEffect(lobby, Effect.ENDER_SIGNAL, 5);
        matador.getPlayer().playSound(matador.getLocation(), Sound.ZOMBIE_REMEDY, 5.0F, 5.0F);
        matador.teleport(lobby);
        Player[] arrayOfPlayer;
        int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
        for (int i = 0; i < j; i++)
        {
          Player s1 = arrayOfPlayer[i];
          if (Admin.inAdmin.contains(s1.getName()))
          {
            p.hidePlayer(s1);
            matador.hidePlayer(s1);
          }
          else
          {
            p.showPlayer(s1);
            matador.showPlayer(s1);
          }
        }
        NaoOlha.EmPvP.remove(p.getName());
        NaoOlha.EmPvP.remove(matador.getName());
        
        API.msg(p, " ");
        API.msg(p, "§cPuxa, você perdeu o 1v1 tente na proxima.");
        API.msg(p, " ");
        
        API.msg(matador, " ");
        API.msg(matador, "§aParabéns você venceu o 1v1.");
        API.msg(matador, " ");
      
        
        World w1 = Bukkit.getServer().getWorld(Main.getPlugin().getConfig().getString("spawn3.world"));
	      double x1 = Main.getPlugin().getConfig().getDouble("spawn3.x");
	      double y1 = Main.getPlugin().getConfig().getDouble("spawn3.y");
	      double z1 = Main.getPlugin().getConfig().getDouble("spawn3.z");
	      Location lobby1 = new Location(w1, x1, y1, z1);
	      lobby1.setPitch((float)Main.getPlugin().getConfig().getDouble("spawn3.pitch"));
	      lobby1.setYaw((float)Main.getPlugin().getConfig().getDouble("spawn3.yaw"));
	      p.teleport(lobby1);
	      matador.teleport(lobby1);
        
        NaoOlha.N1v1Meta.setDisplayName(ChatColor.GOLD.toString() + "1v1 §7§ §cNormal");
        NaoOlha.N1v1.setItemMeta(NaoOlha.N1v1Meta);
        
        NaoOlha.R1v1.setDurability((short)8);
        NaoOlha.R1v1Meta.setDisplayName(ChatColor.GOLD.toString() + "1v1 §7§ §cRapido");
        NaoOlha.R1v1.setItemMeta(NaoOlha.R1v1Meta);
        
        API.setItem(p.getInventory(), 0, NaoOlha.N1v1);
        API.setItem(p.getInventory(), 8, NaoOlha.R1v1);
        API.setItem(matador.getInventory(), 0, NaoOlha.N1v1);
        API.setItem(matador.getInventory(), 8, NaoOlha.R1v1);
      }
    }, 100L);
  }
  
  public boolean check(Player p, Player b)
  {
    if (Desafiar.containsKey(b.getName())) {
      return ((String)Desafiar.get(b.getName())).equals(p.getName());
    }
    return false;
  }
  
  public void começar1v1(Player p, Player target)
  {
    EmPvP.add(p.getName());
    EmPvP.add(p.getName());
    World w2 = Bukkit.getServer().getWorld(Main.getPlugin().getConfig().getString("pos2.world"));
    double x2 = Main.getPlugin().getConfig().getDouble("pos2.x");
    double y2 = Main.getPlugin().getConfig().getDouble("pos2.y");
    double z2 = Main.getPlugin().getConfig().getDouble("pos2.z");
    Location lobby2 = new Location(w2, x2, y2, z2);
    lobby2.setPitch((float)Main.getPlugin().getConfig().getDouble("pos2.pitch"));
    lobby2.setYaw((float)Main.getPlugin().getConfig().getDouble("pos2.yaw"));
    
    p.getWorld().playEffect(lobby2, Effect.ENDER_SIGNAL, 5);
    p.getPlayer().playSound(p.getLocation(), Sound.ZOMBIE_REMEDY, 5.0F, 5.0F);
    p.teleport(lobby2);
    
    World w = Bukkit.getServer().getWorld(Main.getPlugin().getConfig().getString("pos1.world"));
    double x = Main.getPlugin().getConfig().getDouble("pos1.x");
    double y = Main.getPlugin().getConfig().getDouble("pos1.y");
    double z = Main.getPlugin().getConfig().getDouble("pos1.z");
    Location lobby = new Location(w, x, y, z);
    lobby.setPitch((float)Main.getPlugin().getConfig().getDouble("pos1.pitch"));
    lobby.setYaw((float)Main.getPlugin().getConfig().getDouble("pos1.yaw"));
    target.getWorld().playEffect(lobby, Effect.ENDER_SIGNAL, 5);
    target.getPlayer().playSound(target.getLocation(), Sound.ZOMBIE_REMEDY, 5.0F, 5.0F);
    target.teleport(lobby);
    
    ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
    ItemMeta sopameta = sopa.getItemMeta();
    sopameta.setDisplayName("§aSopinha");
    ArrayList<String> sopalore = new ArrayList();
    sopalore.add("§7+ §c3.5");
    sopameta.setLore(sopalore);
    sopa.setItemMeta(sopameta);
    
    API.cI(p);
    API.darArmadura(p);
    API.darEspada(p, true);
    API.darItems(p, sopa, 8);
    
    API.cI(target);
    API.darArmadura(target);
    API.darEspada(target, true);
    API.darItems(target, sopa, 8);
    
    API.som(p, Sound.ANVIL_USE, 2.0F);
    API.som(target, Sound.ANVIL_USE, 2.0F);
    Player[] arrayOfPlayer;
    int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
    for (int i = 0; i < j; i++)
    {
      Player s1 = arrayOfPlayer[i];
      p.hidePlayer(s1);
      target.hidePlayer(s1);
      p.showPlayer(target);
      target.showPlayer(p);
    }
  }
}
