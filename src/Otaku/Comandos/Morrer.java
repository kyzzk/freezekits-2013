package Otaku.Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Morrer implements CommandExecutor{
	
	 public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args)
	  {
	    Player p = (Player)Sender;
	    if (Cmd.getName().equalsIgnoreCase("Morrer")) {
	      p.setHealth(0);
	      p.sendMessage("§cVoce Se Matou!");
	    }
	    return false;
}
}