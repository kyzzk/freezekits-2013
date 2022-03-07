package Otaku.API;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Messages
{
  public static String TEMPBAN = ChatColor.GRAY + "Voce foi TempBanido do servidor por §c";
  public static String BAN = ChatColor.GRAY + "Voce foi Banido do servidor por §c";
  public static String KICK = ChatColor.GRAY + "Voce foi Kikado do servidor por §c";
  public static String ONLINE = ChatColor.RED + "Player '@' nao esta online!";
  
  public static void semPerm(Player p)
  {
    p.sendMessage("§cVoce nao tem permissao para este comando!");
  }
  
  public static void PvP(Player p)
  {
    p.sendMessage("§cVoce nao pode usar esta habilidade em areas Sem PvP.");
  }
  
}