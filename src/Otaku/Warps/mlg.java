package Otaku.Warps;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.block.Block;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import Otaku.Main;
import Otaku.API.API;
import Otaku.Files.Stats;

public class mlg implements Listener{
	
	
	Stats s = Stats.getClasse();
	public static ArrayList<String> MLG = new ArrayList();
	
	@EventHandler
	  public void onDamage(EntityDamageEvent e)
	  {
	    if ((e.getEntity() instanceof Player))
	    {
	      Player p = (Player)e.getEntity();
	      if ((e.getCause() == EntityDamageEvent.DamageCause.FALL) && 
	        (MLG.contains(p.getName())))
	      {
	    	  e.setDamage(0.0D);
	          Block b = e.getEntity().getLocation().getBlock();
	          int x = b.getX();
	          int y = b.getY() + 1;
	          int z = b.getZ();
	          Location agua = new Location(Bukkit.getWorld("world"), x, y, z);
	          agua.getBlock().setType(Material.AIR);
	        
	        API.msg(p, " ");
	        API.msg(p, "§7Voce errou o MLG.");
	        API.msg(p, "§7Foram descontadas §c5 Coins §7da sua conta");
	        API.msg(p, " ");
	        s.addValis(p, 5);
	        e.setCancelled(true);
	        p.getPlayer().getInventory().clear();
	        p.getPlayer().updateInventory();
	        p.chat("/mlg");
	        return;
	      }
	    }
	  }
	  
	  @SuppressWarnings("deprecation")
	@EventHandler
	  public void onColocar(PlayerInteractEvent e)
	  {
	    Player p = e.getPlayer();
	    Action a = e.getAction();
	    Block b = (Block) e.getClickedBlock();
	    if ((p.getItemInHand().getType() == Material.WATER_BUCKET) && (a == Action.RIGHT_CLICK_BLOCK) && 
	      (MLG.contains(p.getName())))
	    {
	      if (!Main.SemPvP(p))
	      {
	        p.sendMessage(ChatColor.RED + "Voce nao pode fazer MLG aqui!");
	        p.updateInventory();
	        e.setCancelled(true);
	        return;
	      }
	      int x = b.getX();
	      int y = b.getY() + 1;
	      int z = b.getZ();
	      Location agua = new Location(Bukkit.getWorld("world"), x, y, z);
	      if (Bukkit.getWorld("world").getBlockAt(agua).getType() != Material.AIR)
	      {
	        p.sendMessage(ChatColor.RED + "Voce nao pode fazer MLG aqui!");
	        p.updateInventory();
	        e.setCancelled(true);
	        return;
	      }
	      agua.getBlock().setType(Material.AIR);
	      API.msg(p, " ");
	      API.msg(p, "§7Parabéns, você acertou.");
	      API.msg(p, "§7Foram Adicionados §a10 Coins §7em sua conta");
	      API.msg(p, " ");
	      s.addValis(p, 10);
	      e.setCancelled(true);
	      p.getPlayer().getInventory().clear();
	      p.chat("/mlg");
	    }
	  }
	}
