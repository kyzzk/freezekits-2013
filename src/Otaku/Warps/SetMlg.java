package Otaku.Warps;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class SetMlg
  implements CommandExecutor, Listener
{
  public static Otaku.Main plugin;
  
  public SetMlg(Otaku.Main main)
  {
    plugin = main;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if ((cmd.getName().equalsIgnoreCase("setmlg")) && 
      ((sender instanceof Player)))
    {
      if (!sender.hasPermission("dkits.setwarp"))
      {
        Player p1 = (Player)sender;
        p1.sendMessage("§cVoce nao tem permissao!");
      }
      if (sender.hasPermission("kitpvp.setwarp"))
      {
        Player p1 = (Player)sender;
        plugin.getConfig().set("mlg.x", Double.valueOf(p1.getLocation().getX()));
        plugin.getConfig().set("mlg.y", Double.valueOf(p1.getLocation().getY()));
        plugin.getConfig().set("mlg.z", Double.valueOf(p1.getLocation().getZ()));
        plugin.getConfig().set("mlg.pitch", Float.valueOf(p1.getLocation().getPitch()));
        plugin.getConfig().set("mlg.yaw", Float.valueOf(p1.getLocation().getYaw()));
        plugin.getConfig().set("mlg.world", p1.getLocation().getWorld().getName());
        plugin.saveConfig();
        p1.sendMessage("§7Warp MLG setada com sucesso");
      }
    }
    return false;
  }
}
