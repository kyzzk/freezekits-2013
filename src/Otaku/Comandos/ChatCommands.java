package Otaku.Comandos;

import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import Otaku.API.Messages;

public class ChatCommands
  implements Listener, CommandExecutor
{
  public static HashMap<CommandSender, Player> replies = new HashMap<CommandSender, Player>();
  public static boolean mutechat = false;
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("cc"))
    {
      if (!p.hasPermission("kitpvp.admin"))
      {
        Otaku.API.Messages.semPerm(p);
        return true;
      }
      for (int i = 0; i < 100; i++) {
        Bukkit.broadcastMessage("");
      }
      Bukkit.broadcastMessage("§aChat Limpo!");
    }
    else if (cmd.getName().equalsIgnoreCase("mutechat"))
    {
      if (!p.hasPermission("kitpvp.admin"))
      {
        Messages.semPerm(p);
        return true;
      }
      if (mutechat)
      {
        mutechat = false;
        Bukkit.broadcastMessage("§aChat desmutado.");
      }
      else
      {
        mutechat = true;
        Bukkit.broadcastMessage("§cChat mutado.");
      }
    }
    else if (cmd.getName().equalsIgnoreCase("tell"))
    {
      if (args.length == 0) {
        p.sendMessage("§cUse: /tell <player> <mensagem>");
      }
      if (args.length > 1)
      {
        Player recipient = Bukkit.getServer().getPlayer(args[0]);
        if (recipient == null)
        {
          p.sendMessage(Otaku.API.Messages.ONLINE.replaceAll("@", args[0]));
          return true;
        }
        String msg = "";
        for (int i = 1; i < args.length; i++) {
          msg = msg + args[i] + " ";
        }
        if (mutechat)
        {
          p.sendMessage("§cChat esta mutado.");
          return true;
        }
        recipient.sendMessage(String.format("§7[%s] §cpara voce > §r%s", new Object[] { sender.getName(), msg }));
        Otaku.API.JsonMessage jm = new Otaku.API.JsonMessage("§cClique aqui para responder!");
        jm.addSugestao("/tell " + p.getName() + " ");
        jm.enviar(recipient);
        
        p.sendMessage(String.format("§cVoce para §7[%s] §c> §r%s§c", new Object[] { recipient.getName(), msg }));
        
        replies.put(p, recipient);
        replies.put(recipient, p);
        return true;
      }
    }
    else if (cmd.getName().equalsIgnoreCase("r"))
    {
      if (args.length > 0)
      {
        if (replies.containsKey(p))
        {
          Player recipient = (Player)replies.get(p);
          if (((recipient instanceof Player)) && (!recipient.isOnline()))
          {
            p.sendMessage(Otaku.API.Messages.ONLINE.replaceAll("@", recipient.getName()));
            replies.remove(p);
            return true;
          }
          String msg = "";
          for (int i = 0; i < args.length; i++) {
            msg = msg + args[i] + " ";
          }
          if (mutechat)
          {
            p.sendMessage("§cChat está mutado.");
            return true;
          }
          recipient.sendMessage(String.format("§7[%s] §cpara voce > §r%s", new Object[] { sender.getName(), msg }));
          Otaku.API.JsonMessage jm = new Otaku.API.JsonMessage("§cClique aqui para responder!");
          jm.addSugestao("/tell " + p.getName() + " ");
          jm.enviar(recipient);
          p.sendMessage(String.format("§cVoce para §7[%s] §c> §r%s§c", new Object[] { recipient.getName(), msg }));
          replies.put(recipient, p);
          return true;
        }
        p.sendMessage("§cNinguem para responder!");
        return true;
      }
      p.sendMessage("§cUse: /r <mensagem>");
      return true;
    }
    return true;
  }
  
  @EventHandler
  public void tellQuit(PlayerQuitEvent e)
  {
    if (replies.containsKey(e.getPlayer())) {
      replies.remove(e.getPlayer());
    }
  }
}
