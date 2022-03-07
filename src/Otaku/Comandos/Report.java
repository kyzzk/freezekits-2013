package Otaku.Comandos;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitScheduler;

import Otaku.Main;

public class Report
  implements Listener, CommandExecutor
{
  public static ArrayList<String> cooldown = new ArrayList();
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    final Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("report"))
    {
      if (args.length == 0)
      {
        p.sendMessage("§cUse: /report <player> <motivo>");
        p.playSound(p.getLocation(), Sound.NOTE_BASS, 1.0F, 1.0F);
        return true;
      }
      if (args.length == 1)
      {
        Player target = Bukkit.getPlayer(args[0]);
        if (target == null)
        {
          p.sendMessage(Main.m.getConfig().getString("SV").replace("&", "§") + " §cEsse player nao esta online.");
          p.playSound(p.getLocation(), Sound.NOTE_BASS, 1.0F, 1.0F);
          return true;
        }
      }
      if (args.length >= 2)
      {
        StringBuilder sb = new StringBuilder();
        Player target = Bukkit.getPlayer(args[0]);
        for (int i = 1; i < args.length; i++) {
          sb.append(args[i]).append(" ");
        }
        String allArgs = sb.toString().trim();
        if (!cooldown.contains(p.getName()))
        {
          sender.sendMessage(Main.m.getConfig().getString("SV").replace("&", "§") + " §aSeu report foi enviado com sucesso!");
          Player[] arrayOfPlayer;
          int j = (arrayOfPlayer = Bukkit.getServer().getOnlinePlayers()).length;
          for (int i = 0; i < j; i++)
          {
            Player staff = arrayOfPlayer[i];
            if (staff.hasPermission("kitpvp.admin"))
            {
              if (target == null)
              {
                p.sendMessage(Otaku.API.Messages.ONLINE.replaceAll("@", args[0]));
                return true;
              }
              if (args[0] == p.getName())
              {
                p.sendMessage(Main.m.getConfig().getString("SV").replace("&", "§") + " §cVoce nao pode reportar si mesmo.");
                return true;
              }
              staff.playSound(staff.getLocation(), Sound.ENDERDRAGON_GROWL, 1.0F, 1.0F);
              staff.sendMessage("§c---===[§4§oREPORT§c]===---");
              staff.sendMessage("§aReportado: §c" + target.getName());
              staff.sendMessage("§aPor: §c" + p.getName());
              staff.sendMessage("§aMotivo: §c" + allArgs);
              staff.sendMessage("§c---===[§4§oREPORT§c]===---");
              cooldown.add(p.getName());
              Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
              {
                public void run()
                {
                  Report.cooldown.remove(p.getName());
                }
              }, 1200L);
            }
          }
        }
        else
        {
          p.sendMessage(Main.m.getConfig().getString("SV").replace("&", "§") + "§cEspere, um pouco para reportar novamente!");
          p.playSound(p.getLocation(), Sound.NOTE_BASS, 1.0F, 1.0F);
        }
      }
    }
    return true;
  }
}
