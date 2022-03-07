package Otaku.Skill;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import Otaku.Main;

public class Ninja
  implements Listener
{
  public static HashMap<Player, Player> a = new HashMap();
  public static HashMap<Player, Long> b = new HashMap();
  public static List<Player> cooldownbk = new ArrayList();
  
  @EventHandler
  public void a(EntityDamageByEntityEvent paramEntityDamageByEntityEvent)
  {
    if (((paramEntityDamageByEntityEvent.getDamager() instanceof Player)) && ((paramEntityDamageByEntityEvent.getEntity() instanceof Player)))
    {
      final Player localPlayer1 = (Player)paramEntityDamageByEntityEvent.getDamager();
      Player localPlayer2 = (Player)paramEntityDamageByEntityEvent.getEntity();
      if (ArrayL.ninja.contains(localPlayer1.getName()))
      {
        a.put(localPlayer1, localPlayer2);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
        {
          public void run()
          {
            Ninja.cooldownbk.remove(localPlayer1);
          }
        }, 200L);
      }
    }
  }
  
  @EventHandler
  public void a(PlayerToggleSneakEvent paramPlayerToggleSneakEvent)
  {
    Player localPlayer1 = paramPlayerToggleSneakEvent.getPlayer();
    if ((paramPlayerToggleSneakEvent.isSneaking()) && (ArrayL.ninja.contains(localPlayer1.getName())) && (a.containsKey(localPlayer1)))
    {
      Player localPlayer2 = (Player)a.get(localPlayer1);
      if ((localPlayer2 != null) && (!localPlayer2.isDead()))
      {
        String str = null;
        if (b.get(localPlayer1) != null)
        {
          long l = ((Long)b.get(localPlayer1)).longValue() - System.currentTimeMillis();
          DecimalFormat localDecimalFormat = new DecimalFormat("##");
          int i = (int)l / 1000;
          str = localDecimalFormat.format(i);
        }
        if ((b.get(localPlayer1) == null) || (((Long)b.get(localPlayer1)).longValue() < System.currentTimeMillis()))
        {
          if (localPlayer1.getLocation().distance(localPlayer2.getLocation()) < 100.0D)
          {
            localPlayer1.teleport(localPlayer2.getLocation());
            localPlayer1.sendMessage(ChatColor.GREEN + "Teleportado");
            b.put(localPlayer1, Long.valueOf(System.currentTimeMillis() + 10000L));
          }
          else
          {
            localPlayer1.sendMessage(ChatColor.RED + "O Ultimo jogador hitado esta muito longe!");
          }
        }
        else {
          localPlayer1.sendMessage("§7× §c Kit em Cooldown, Aguarde " + str + " segundos!");
        }
      }
    }
  }
}
