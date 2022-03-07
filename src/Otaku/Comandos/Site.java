package Otaku.Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Otaku.Main;

	public class Site
	  implements CommandExecutor, Listener
	{
	  public static Main plugin;
	  
	  public Site(Main main)
	  {
	    plugin = main;
	  }
	  
	  public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args)
	  {
	    Player p = (Player)Sender;
	    if (Cmd.getName().equalsIgnoreCase("Site")) {
	    	p.sendMessage("           §6Loja           ");
	      Otaku.API.JsonMessage jm = new Otaku.API.JsonMessage("§c       Clique aqui!");
	    	jm.addURL("http://goo.gl/4A2Pg4");
	    	jm.enviar(p);
	    }
	    return false;
	  }

}
