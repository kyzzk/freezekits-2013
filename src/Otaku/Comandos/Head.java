package Otaku.Comandos;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.SkullMeta;

import Otaku.Main;

public class Head
  implements CommandExecutor
{
  public static Main plugin;
  
  public Head(Main main)
  {
    plugin = main;
  }
  
  public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args)
  {
    Player p = (Player)Sender;
    if (Cmd.getName().equalsIgnoreCase("Head"))
    {
      if (!p.hasPermission("kitpvp.admin"))
      {
        p.sendMessage("§7[§c!§7]§c Voce nao tem permissao para este comando!");
        return true;
      }
      if (Args.length == 0)
      {
        p.sendMessage("§7[§c!§7]§c Use: /Head <Jogador>");
        return true;
      }
      ItemStack kCabeca = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
      SkullMeta mCabeca = (SkullMeta)kCabeca.getItemMeta();
      mCabeca.setOwner(Args[0]);
      kCabeca.setItemMeta(mCabeca);
      p.getInventory().addItem(new ItemStack[] { kCabeca });
      p.updateInventory();
      p.sendMessage("§cCABEÇA PEGADA COM SUCESSO");
    }
    return false;
  }
}
