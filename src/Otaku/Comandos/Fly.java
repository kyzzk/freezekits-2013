package Otaku.Comandos;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import Otaku.Main;

public class Fly
  implements CommandExecutor, Listener
{
  public static ArrayList<String> flay = new ArrayList();
  
  public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args)
  {
    if ((sender instanceof Player))
    {
      if (cmd.getName().equalsIgnoreCase("fly"))
      {
        Player player = (Player)sender;
        if ((args.length == 0) && 
          (sender.hasPermission("kitpvp.admin"))) {
          if (!player.getAllowFlight())
          {
            player.sendMessage(Main.m.getConfig().getString("SV").replace("&", "§") + " §bFly Ligado");
            flay.add(player.getName());
            player.setAllowFlight(true);
          }
          else
          {
            player.sendMessage(Main.m.getConfig().getString("SV").replace("&", "§") + " §bFly Desligado");
            flay.remove(player.getName());
            player.setAllowFlight(false);
          }
        }
        if ((args.length == 1) && 
          (sender.hasPermission("kit.admin")))
        {
          Player player2 = Bukkit.getPlayer(args[0]);
          if (player2 == null)
          {
            sender.sendMessage(ChatColor.RED + "Jogador Offline");
            return true;
          }
          if (!player.getAllowFlight())
          {
            sender.sendMessage(ChatColor.GREEN + "Voo Habilitado para " + player2.getName());
            player2.setAllowFlight(true);
            flay.add(player2.getName());
            player2.sendMessage(ChatColor.GREEN + "Voo Habilitado por " + player.getName());
          }
          else
          {
            sender.sendMessage(ChatColor.GREEN + "Voo Desabilitado para " + player2.getName());
            player.setAllowFlight(false);
            flay.remove(player2.getName());
            player2.sendMessage(ChatColor.GREEN + "Voo Desabilitado por " + player.getName());
          }
        }
      }
    }
    else {
      sender.sendMessage(ChatColor.RED + "Voce deve ser um usuario!");
    }
    return false;
  }
  
  public void voarpralongedoplayer(PlayerMoveEvent p)
  {
    if (flay.contains(p)) {
      for (Entity pertos : p.getPlayer().getNearbyEntities(8.0D, 8.0D, 8.0D)) {
        p.getPlayer().setVelocity(new Vector(0, 3, 0));
      }
    }
  }
}
