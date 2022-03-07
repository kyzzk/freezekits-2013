package Otaku.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Otaku.Eventos.ScoreB;
import Otaku.Files.Stats;

public class Money
  implements Listener, CommandExecutor
{

	Stats s = Stats.getClasse();
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("money")) {
      p.sendMessage("§aSaldo: §c" + s.getValis(p));
    }
    if (cmd.getName().equalsIgnoreCase("repass"))
    {
      if (args.length == 0)
      {
        msg(p, "§cUse /repass <player> <quantidade>");
        return true;
      }
      if (args.length == 1)
      {
        Player target = Bukkit.getPlayer(args[0]);
        if (target == null)
        {
          msg(p, Otaku.API.Messages.ONLINE.replaceAll("@", args[0]));
          return true;
        }
        msg(p, "§cEspecifique uma quantidade.");
      }
      if (args.length == 2)
      {
        Player target = Bukkit.getPlayer(args[0]);
        if (target == null)
        {
          msg(p, Otaku.API.Messages.ONLINE.replaceAll("@", args[0]));
          return true;
        }
        if (target == p)
        {
          msg(p, "§cVoce nao pode repassar as moedas para si mesmo.");
          return true;
        }
        try
        {
          int quantidade = Integer.valueOf(args[1]).intValue();
          if (s.getValis(target) < quantidade)
          {
            msg(p, "§cVoce nao tem essas moedas.");
            return true;
          }
          msg(p, "§cVoce deu " + quantidade + " moedas para " + target.getName());
          msg(target, "§cVoce recebeu " + quantidade + " moedas de" + p.getName());
          s.removeValis(p, quantidade);
          s.addValis(p, quantidade);
        }
        catch (NumberFormatException e)
        {
          msg(p, "§cUse apenas numeros.");
        }
      }
    }
    return true;
  }
  
  public static void msg(Player p, String msg)
  {
    p.sendMessage(msg);
  }
}
