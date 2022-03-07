package Otaku.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class BC
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args)
  {
    if ((commandLabel.equalsIgnoreCase("say")) && (sender.hasPermission("kit.admin")))
    {
      if (args.length >= 1)
      {
        String bcast = "";
        for (int x = 0; x < args.length; x++) {
          bcast = bcast + args[x] + " ";
        }
        bcast = ChatColor.translateAlternateColorCodes('&', bcast);
        Bukkit.broadcastMessage("§7[§c§lAVISO§7] §f" + ChatColor.RED + bcast);
      }
      else
      {
        sender.sendMessage("§3Use: /say [mensagem]");
      }
    }
    else {
      sender.sendMessage("§cVoce nao tem permissão!");
    }
    return false;
  }
}
