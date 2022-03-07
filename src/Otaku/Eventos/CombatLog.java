package Otaku.Eventos;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import Otaku.API.API;

public class CombatLog
  implements Listener
{
  public static List<String> NoLog = new ArrayList<String>();

  @EventHandler
  public void onEntityDamage(EntityDamageByEntityEvent e)
  {
    if (((e.getDamager() instanceof Player)) && ((e.getEntity() instanceof Player)))
    {
      final Player p = (Player)e.getEntity();
      final Player hitter = (Player)e.getDamager();
      if (!Otaku.Main.SemPvP(p)) {
        return;
      }
      if (!Otaku.Main.SemPvP(hitter)) {
        return;
      }
      if ((!NoLog.contains(p.getName())) && (!NoLog.contains(hitter.getName())))
      {
        NoLog.add(p.getName());
        NoLog.add(hitter.getName());
        
        Bukkit.getScheduler().scheduleSyncDelayedTask(Otaku.Main.getPlugin(), new Runnable()
        {
          public void run()
          {
            CombatLog.NoLog.remove(p.getName());
            CombatLog.NoLog.remove(hitter.getName());
          }
        }, 200L);
      }
    }
  }
  
  @EventHandler
  public void onCommando(PlayerCommandPreprocessEvent e)
  {
    Player p = e.getPlayer();
    if (NoLog.contains(p.getName()))
    {
      if (p.hasPermission("fkits.staff")) {
        return;
      }
      p.sendMessage(API.prefix + "§cVoce nao pode executar comandos em combate.");
      e.setCancelled(true);
      return;
    }
  }
}