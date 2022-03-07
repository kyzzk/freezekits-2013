package Otaku.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Teletransporte
  implements CommandExecutor
{
  public String[] aliases = { "tp" };
  public String description = "Sistema de teleporte.";
  
  public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args)
  {
    Player p = (Player)Sender;
    if (p.hasPermission("kitpvp.tp")) {
      if (Args.length == 0)
      {
        p.sendMessage("§7[§c!§7]§c Use: /Tp <Jogador> <Alvo> §7[§c!§7]");
      }
      else
      {
        int j;
        if (Args.length == 1)
        {
          Player target = p.getServer().getPlayer(Args[0]);
          if (target != null)
          {
            p.teleport(target.getLocation());
            Player[] arrayOfPlayer1;
            j = (arrayOfPlayer1 = Bukkit.getOnlinePlayers()).length;
            for (int i = 0; i < j; i++)
            {
              Player p1 = arrayOfPlayer1[i];
              if ((p1.hasPermission("kitpvp.tp")) || (p1.isOp())) {
                p1.sendMessage("§7[§c!§7]§7 " + p.getName() + "§a Foi Teleportado Para §7" + target.getName() + " ");
              }
            }
          }
          else
          {
            p.sendMessage("§7[§c!§7]§c " + Args[0] + " N§o Esta Online! §7[§c!§7]");
          }
        }
        else if (Args.length == 2)
        {
          Player target = p.getServer().getPlayer(Args[0]);
          Player starget = p.getServer().getPlayer(Args[1]);
          if (target != null)
          {
            if (starget != null)
            {
              target.teleport(starget.getLocation());
              Player[] arrayOfPlayer2;
              int k = (arrayOfPlayer2 = Bukkit.getOnlinePlayers()).length;
              for (j = 0; j < k; j++)
              {
                Player p1 = arrayOfPlayer2[j];
                if ((p1.hasPermission("kitpvp.tp")) || (p1.isOp())) {
                  p1.sendMessage("§7[§c!§7]§7 " + target.getName() + "§a Foi Teleportado Para §7" + starget.getName() + "");
                }
              }
            }
            else
            {
              p.sendMessage("§7[§c!§7]§c " + Args[0] + " N§o Esta Online! §7[§c!§7]");
            }
          }
          else {
            p.sendMessage("§7[§c!§7]§c " + Args[0] + " N§o Esta Online! §7[§c!§7]");
          }
        }
        else
        {
          int n;
          if (Args.length == 3)
          {
            double x2 = Args[0].startsWith("~") ? p.getLocation().getX() + Integer.parseInt(Args[0].substring(1)) : Integer.parseInt(Args[0]);
            double y2 = Args[1].startsWith("~") ? p.getLocation().getY() + Integer.parseInt(Args[1].substring(1)) : Integer.parseInt(Args[1]);
            double z2 = Args[2].startsWith("~") ? p.getLocation().getZ() + Integer.parseInt(Args[2].substring(1)) : Integer.parseInt(Args[2]);
            if ((x2 > 3.0E7D) || (y2 > 3.0E7D) || (z2 > 3.0E7D) || (x2 < -3.0E7D) || (y2 < -3.0E7D) || (z2 < -3.0E7D))
            {
              p.sendMessage("§7[§c!§7]§c Use: /Tp <Jogador> <Alvo> §7[§c!§7]");
              return true;
            }
            Location locpos = new Location(p.getWorld(), x2, y2, z2, p.getLocation().getYaw(), p.getLocation().getPitch());
            p.teleport(locpos);
            Player[] arrayOfPlayer3;
            n = (arrayOfPlayer3 = Bukkit.getOnlinePlayers()).length;
            for (int m = 0; m < n; m++)
            {
              Player p1 = arrayOfPlayer3[m];
              if ((p1.hasPermission("kitpvp.tp")) || (p1.isOp())) {
                p1.sendMessage("§7[§c!§7]§7 " + p.getName() + "§a Foi Teleportado Para§7 X §f" + locpos.getBlockX() + "§7 Y §f" + locpos.getBlockY() + "§7 Z §f" + locpos.getBlockZ() + "§7 . ");
              }
            }
          }
          else if (Args.length == 4)
          {
            Player target = p.getServer().getPlayer(Args[0]);
            double x2 = Args[1].startsWith("~") ? target.getLocation().getX() + Integer.parseInt(Args[0].substring(1)) : Integer.parseInt(Args[1]);
            double y2 = Args[2].startsWith("~") ? target.getLocation().getY() + Integer.parseInt(Args[1].substring(1)) : Integer.parseInt(Args[2]);
            double z2 = Args[3].startsWith("~") ? target.getLocation().getZ() + Integer.parseInt(Args[2].substring(1)) : Integer.parseInt(Args[3]);
            if ((x2 > 3.0E7D) || (y2 > 3.0E7D) || (z2 > 3.0E7D) || (x2 < -3.0E7D) || (y2 < -3.0E7D) || (z2 < -3.0E7D) || (target == null))
            {
              p.sendMessage("§7[§c!§7]§c Use: /Tp <Jogador> <Alvo> §7[§c!§7]");
              return true;
            }
            Location locpos = new Location(p.getWorld(), x2, y2, z2, target.getLocation().getYaw(), target.getLocation().getPitch());
            target.teleport(locpos);
            Player[] arrayOfPlayer4;
            int i1 = (arrayOfPlayer4 = Bukkit.getOnlinePlayers()).length;
            for (n = 0; n < i1; n++)
            {
              Player p1 = arrayOfPlayer4[n];
              if ((p1.hasPermission("kitpvp.tp")) || (p1.isOp())) {
                p1.sendMessage("§7[§c!§7]§7 " + target.getName() + "§a Foi Teleportado Para§7 X §f" + locpos.getBlockX() + "§7 Y §f" + locpos.getBlockY() + "§7 Z §f" + locpos.getBlockZ() + "§7 . ");
              }
            }
          }
        }
      }
    }
    return false;
  }
}
