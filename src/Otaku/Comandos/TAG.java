package Otaku.Comandos;

import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Otaku.Eventos.ScoreB;
import ca.wacos.nametagedit.NametagAPI;

public class TAG
  implements Listener, CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage("§cEste comando funciona apenas com jogadores!");
      {
    Player p = (Player)sender;
    if ((cmd.getName().equalsIgnoreCase("tag")));
      }
    }
    else
    {
      Player p = (Player)sender;
      if (args.length == 0) {
        if (p.hasPermission("tag.dono"))
        {
          p.sendMessage("§7§l====================");
          p.sendMessage("§7- §4Dono");
          p.sendMessage("§7- §cAdmin");
          p.sendMessage("§7- §5Mod");
          p.sendMessage("§7- §dTrial");
          p.sendMessage("§7- §bYoutuber");
          p.sendMessage("§7- §6Pro");
          p.sendMessage("§7- §9MVP");
          p.sendMessage("§7- §7Normal");
          p.sendMessage("§7§l====================");
        }
        else if (p.hasPermission("tag.admin"))
        {
          p.sendMessage("§7§l====================");
          p.sendMessage("§7- §cAdmin");
          p.sendMessage("§7- §7Normal");
          p.sendMessage("§7§l====================");
        }
        else if (p.hasPermission("tag.mod"))
        {
          p.sendMessage("§7§l====================");
          p.sendMessage("§7- §5Mod");
          p.sendMessage("§7- §7Normal");
          p.sendMessage("§7§l====================");
        }
        else if (p.hasPermission("tag.trial"))
        {
          p.sendMessage("§7§l====================");
          p.sendMessage("§7- §dTrial");
          p.sendMessage("§7- §7Normal");
          p.sendMessage("§7§l====================");
        }
        else if (p.hasPermission("tag.youtuber"))
        {
          p.sendMessage("§7§l====================");
          p.sendMessage("§7- §bYoutuber");
          p.sendMessage("§7- §7Normal");
          p.sendMessage("§7§l====================");
        }
        else if (p.hasPermission("tag.pro"))
        {
          p.sendMessage("§7§l====================");
          p.sendMessage("§7- §6Pro");
          p.sendMessage("§7- §9MVP");
          p.sendMessage("§7- §7Normal");
          p.sendMessage("§7§l====================");
        }
        else if (p.hasPermission("tag.mvp"))
        {
          p.sendMessage("§7§l====================");
          p.sendMessage("§7- §9MVP");
          p.sendMessage("§7- §7Normal");
          p.sendMessage("§7§l====================");
        }
        else if (p.hasPermission("tag.normal"))
        {
          p.sendMessage("§7§l====================");
          p.sendMessage("§7- §7Normal");
          p.sendMessage("§7§l====================");
        }
      }
      if (args.length == 1) {
        if (p.getName().length() < 10)
        {
          if ((args[0].equalsIgnoreCase("dono")) && 
            (p.hasPermission("tag.dono")))
          {
            p.sendMessage("§cVoce agora esta usando a tag: §4Dono");
            p.setPlayerListName("§4" + p.getName() + "§f");
            p.setDisplayName("§4DONO §4" + p.getName() + "§f");
            NametagAPI.setPrefix(p.getName(), "§4");

          }
          if ((args[0].equalsIgnoreCase("admin")) && 
            (p.hasPermission("tag.admin")))
          {
            p.sendMessage("§7Voca agora este usando a tag: §cAdmin");
            p.setPlayerListName("§c§o" + p.getName() + "§f");
            p.setDisplayName("§c§lADM §c" + p.getName() + "§f");
            NametagAPI.setPrefix(p.getName(), "§c§o");

          }
          if ((args[0].equalsIgnoreCase("mod")) && 
            (p.hasPermission("tag.mod")))
          {
            p.sendMessage("§cVoce agora esta usando a tag: §5Mod");
            p.setPlayerListName("§5§o" + p.getName() + "§f");
            p.setDisplayName("§5§lMOD §5" + p.getName() + "§f");
            NametagAPI.setPrefix(p.getName(), "§5§o");

          }
          if ((args[0].equalsIgnoreCase("trial")) && 
            (p.hasPermission("tag.trial")))
          {
            p.sendMessage("§cVoce agora esta usando a tag: §dTrial");
            p.setPlayerListName("§d§o" + p.getName() + "§f");
            p.setDisplayName("§d§lTRIAL §d" + p.getName() + "§f");
            NametagAPI.setPrefix(p.getName(), "§d§o");

          }
          if ((args[0].equalsIgnoreCase("youtuber")) && 
            (p.hasPermission("tag.youtuber")))
          {
            p.sendMessage("§cVoce agora esta usando a tag: §bYoutuber");
            p.setPlayerListName("§b§o" + p.getName() + "§f");
            p.setDisplayName("§b§lYT §b" + p.getName() + "§f");
            NametagAPI.setPrefix(p.getName(), "§b§o");

          }
          if ((args[0].equalsIgnoreCase("pro")) && 
            (p.hasPermission("tag.pro")))
          {
            p.sendMessage("§cVoce agora esta usando a tag: §6Pro");
            p.setPlayerListName("§6" + p.getName() + "§f");
            p.setDisplayName("§6§lPRO §6" + p.getName() + "§f");
            NametagAPI.setPrefix(p.getName(), "§6");

          }
          if ((args[0].equalsIgnoreCase("mvp")) && 
            (p.hasPermission("tag.mvp")))
          {
            p.sendMessage("§cVoce agora esta usando a tag: §9MVP");
            p.setPlayerListName("§9" + p.getName() + "§f");
            p.setDisplayName("§9§lMVP §9" + p.getName() + "§f");
            NametagAPI.setPrefix(p.getName(), "§9");

          }
          if ((args[0].equalsIgnoreCase("normal")) && 
            (p.hasPermission("tag.normal")))
          {
            p.sendMessage("§cVoce agora esta usando a tag: §7Normal");
            p.setPlayerListName("§f" + p.getName() + "§f");
            p.setDisplayName("§f" + p.getName() + "§f");
            NametagAPI.setPrefix(p.getName(), "§f");

          }
        }
        else
        {
          if ((args[0].equalsIgnoreCase("dono")) && 
            (p.hasPermission("tag.dono")))
          {
            p.sendMessage("§cVoce agora esta usando a tag: §4Dono");
            p.setPlayerListName("§4" + p.getName().substring(0, 10) + "§f");
            p.setDisplayName("§4Dono §4" + p.getName().substring(0, 10) + "§f");
            NametagAPI.setPrefix(p.getName(), "§4");

          }
          if ((args[0].equalsIgnoreCase("admin")) && 
            (p.hasPermission("tag.admin")))
          {
            p.sendMessage("§cVoce agora esta usando a tag: §cAdmin");
            p.setPlayerListName("§c§o" + p.getName().substring(0, 10) + "§f");
            p.setDisplayName("§c§lADM §c" + p.getName().substring(0, 10) + "§f");
            NametagAPI.setPrefix(p.getName(), "§c§o");

          }
          if ((args[0].equalsIgnoreCase("mod")) && 
            (p.hasPermission("tag.mod")))
          {
            p.sendMessage("§cVoce agora esta usando a tag: §5Mod");
            p.setPlayerListName("§5§o" + p.getName().substring(0, 10) + "§f");
            p.setDisplayName("§5§lMOD §5" + p.getName().substring(0, 10) + "§f");
            NametagAPI.setPrefix(p.getName(), "§5§o");

          }
          if ((args[0].equalsIgnoreCase("trial")) && 
            (p.hasPermission("tag.trial")))
          {
            p.sendMessage("§cVoce agora esta usando a tag: §dTrial");
            p.setPlayerListName("§d§o" + p.getName().substring(0, 10) + "§f");
            p.setDisplayName("§d§lTRIAL §d" + p.getName().substring(0, 10) + "§f");
            NametagAPI.setPrefix(p.getName(), "§d§o");

          }
          if ((args[0].equalsIgnoreCase("youtuber")) && 
            (p.hasPermission("tag.youtuber")))
          {
            p.sendMessage("§cVoce agora esta usando a tag: §bYoutuber");
            p.setPlayerListName("§b§o" + p.getName().substring(0, 10) + "§f");
            p.setDisplayName("§b§bYT §b" + p.getName().substring(0, 10) + "§f");
            NametagAPI.setPrefix(p.getName(), "§b§o");

          }
          if ((args[0].equalsIgnoreCase("pro")) && 
            (p.hasPermission("tag.pro")))
          {
            p.sendMessage("§cVoce agora esta usando a tag: §6Pro");
            p.setPlayerListName("§6" + p.getName().substring(0, 10) + "§f");
            p.setDisplayName("§6§lPRO §6" + p.getName().substring(0, 10) + "§f");
            NametagAPI.setPrefix(p.getName(), "§6");

          }
          if ((args[0].equalsIgnoreCase("mvp")) && 
            (p.hasPermission("tag.mvp")))
          {
            p.sendMessage("§cVoce agora esta usando a tag: §9MVP");
            p.setPlayerListName("§9" + p.getName().substring(0, 10) + "§f");
            p.setDisplayName("§9§lMVP §9" + p.getName().substring(0, 10) + "§f");
            NametagAPI.setPrefix(p.getName(), "§9");

          }
          if ((args[0].equalsIgnoreCase("normal")) && 
            (p.hasPermission("tag.normal")))
          {
            p.sendMessage("§cVoce agora esta usando a tag: §7Normal");
            p.setPlayerListName("§f" + p.getName().substring(0, 10) + "§f");
            p.setDisplayName("§f" + p.getName().substring(0, 10) + "§f");
            NametagAPI.setPrefix(p.getName(),"§f");
            
          }
        }
      }
    }
    return false;
  }
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
}
