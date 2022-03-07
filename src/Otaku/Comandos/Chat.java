package Otaku.Comandos;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import Otaku.Main;

public class Chat
  implements Listener
{
  ArrayList<String> deley = new ArrayList<String>();
  
  @EventHandler
  public void onChat(AsyncPlayerChatEvent e)
  {
    final Player p = e.getPlayer();
    if ((ChatCommands.mutechat) && 
      (!p.hasPermission("kitpvp.admin")))
    {
      p.sendMessage("§cChat esta mutado.");
      e.setCancelled(true);
      return;
    }
    if ((this.deley.contains(p.getName())) && 
    (!p.hasPermission("kit.floodar")))
    {
      p.sendMessage("§cPor favor, fale mais de vagar!");
      e.setCancelled(true);
      return;
    }
      this.deley.add(p.getName());
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
      {
        public void run()
        {
          Chat.this.deley.remove(p.getName());
        }
      }, 100L);
    }
  }