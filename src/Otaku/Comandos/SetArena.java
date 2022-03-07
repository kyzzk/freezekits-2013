package Otaku.Comandos;

import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class SetArena
  implements CommandExecutor
{
  public static Otaku.Main plugin;
  
  public SetArena(Otaku.Main main)
  {
    plugin = main;
  }
  
  public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args)
  {
    Player p = (Player)Sender;
    if ((Cmd.getName().equalsIgnoreCase("SetArena")) && 
      (!p.hasPermission("kitpvp.admin")))
    {
      p.sendMessage("§c Voce não tem permissão para este comando!");
      return true;
    }
    if (Args.length == 0)
    {
      p.sendMessage("§7[§c!§7]§c Use: /SetArena 1:3");
      return true;
    }
    if (Args[0].equalsIgnoreCase("1"))
    {
      p.sendMessage("§7[§c!§7] §aArena 1 Setada Com Sucesso ");
      plugin.getConfig().set("Arena1.x", Double.valueOf(p.getLocation().getX()));
      plugin.getConfig().set("Arena1.y", Double.valueOf(p.getLocation().getY()));
      plugin.getConfig().set("Arena1.z", Double.valueOf(p.getLocation().getZ()));
      World w = p.getWorld();
      plugin.getConfig().set("Arena1.pitch", Float.valueOf(p.getLocation().getPitch()));
      plugin.getConfig().set("Arena1.yaw", Float.valueOf(p.getLocation().getYaw()));
      plugin.getConfig().set("Arena1.world", p.getLocation().getWorld().getName());
      plugin.saveConfig();
    }
    if (Args[0].equalsIgnoreCase("2"))
    {
      p.sendMessage("§7[§c!§7] §aArena 2 Setada Com Sucesso ");
      plugin.getConfig().set("Arena2.x", Double.valueOf(p.getLocation().getX()));
      plugin.getConfig().set("Arena2.y", Double.valueOf(p.getLocation().getY()));
      plugin.getConfig().set("Arena2.z", Double.valueOf(p.getLocation().getZ()));
      World w = p.getWorld();
      plugin.getConfig().set("Arena2.pitch", Float.valueOf(p.getLocation().getPitch()));
      plugin.getConfig().set("Arena2.yaw", Float.valueOf(p.getLocation().getYaw()));
      plugin.getConfig().set("Arena2.world", p.getLocation().getWorld().getName());
      plugin.saveConfig();
    }
    if (Args[0].equalsIgnoreCase("3"))
    {
      p.sendMessage("§7[§c!§7] §aArena 3 Setada Com Sucesso");
      plugin.getConfig().set("Arena3.x", Double.valueOf(p.getLocation().getX()));
      plugin.getConfig().set("Arena3.y", Double.valueOf(p.getLocation().getY()));
      plugin.getConfig().set("Arena3.z", Double.valueOf(p.getLocation().getZ()));
      World w = p.getWorld();
      plugin.getConfig().set("Arena3.pitch", Float.valueOf(p.getLocation().getPitch()));
      plugin.getConfig().set("Arena3.yaw", Float.valueOf(p.getLocation().getYaw()));
      plugin.getConfig().set("Arena3.world", p.getLocation().getWorld().getName());
      plugin.saveConfig();
    }
    return false;
  }
  
  public static void TeleportArenaRandom(Player p)
  {
    Random dice = new Random();
    
    int number = dice.nextInt(3);
    switch (number)
    {
    case 0: 
      World w = Bukkit.getServer().getWorld(plugin.getConfig().getString("Arena1.world"));
      double x = plugin.getConfig().getDouble("Arena1.x");
      double y = plugin.getConfig().getDouble("Arena1.y");
      double z = plugin.getConfig().getDouble("Arena1.z");
      Location lobby = new Location(w, x, y, z);
      lobby.setPitch((float)plugin.getConfig().getDouble("Arena1.pitch"));
      lobby.setYaw((float)plugin.getConfig().getDouble("Arena1.yaw"));
      
      p.teleport(lobby);
      
      break;
    case 1: 
      World w2 = Bukkit.getServer().getWorld(plugin.getConfig().getString("Arena2.world"));
      double x2 = plugin.getConfig().getDouble("Arena2.x");
      double y2 = plugin.getConfig().getDouble("Arena2.y");
      double z2 = plugin.getConfig().getDouble("Arena2.z");
      Location lobby2 = new Location(w2, x2, y2, z2);
      lobby2.setPitch((float)plugin.getConfig().getDouble("Arena2.pitch"));
      lobby2.setYaw((float)plugin.getConfig().getDouble("Arena2.yaw"));
      
      p.teleport(lobby2);
      
      break;
    case 2: 
      World w3 = Bukkit.getServer().getWorld(plugin.getConfig().getString("Arena3.world"));
      double x3 = plugin.getConfig().getDouble("Arena3.x");
      double y3 = plugin.getConfig().getDouble("Arena3.y");
      double z3 = plugin.getConfig().getDouble("Arena3.z");
      Location lobby3 = new Location(w3, x3, y3, z3);
      lobby3.setPitch((float)plugin.getConfig().getDouble("Arena3.pitch"));
      lobby3.setYaw((float)plugin.getConfig().getDouble("Arena3.yaw"));
      
      p.teleport(lobby3);
    }
  }
}
