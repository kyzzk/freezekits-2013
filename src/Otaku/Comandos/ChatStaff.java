package Otaku.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class ChatStaff
  implements CommandExecutor, Listener
{
  public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage("Comando apenas para players in-game.");
      return true;
    }
    Player p = (Player)sender;
    if (cmd.equalsIgnoreCase("sc")) {
      if (sender.hasPermission("kitpvp.admin"))
      {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
          sb.append(args[i] + " ");
        }
        String allArgs = sb.toString().trim();
        Player[] arrayOfPlayer;
        @SuppressWarnings("deprecation")
		int j = (arrayOfPlayer = Bukkit.getServer().getOnlinePlayers()).length;
        for (int i = 0; i < j; i++)
        {
          Player staff = arrayOfPlayer[i];
          if (staff.hasPermission("kitpvp.admin")) {
            staff.sendMessage("§7[§eStaffChat§7] " + p.getDisplayName() + " §e» §8" + allArgs);
          }
        }
      }
    }
    return false;
  }
}
