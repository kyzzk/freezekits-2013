package Otaku.Files;

import java.io.File;
import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class Stats
  implements Listener
{
  private static Stats classe = new Stats();
  private FileConfiguration file;
  private File cfile;
  
  public static Stats getClasse()
  {
    return classe;
  }
  
  public void setup(Plugin p)
  {
    this.cfile = new File(p.getDataFolder(), "StatsF.yml");
    if (!this.cfile.exists()) {
      try
      {
        this.cfile.createNewFile();
      }
      catch (IOException e)
      {
        Bukkit.getServer().getConsoleSender().sendMessage("[FreezeKits] StatsF.yml criada com sucesso.");
      }
    }
    this.file = YamlConfiguration.loadConfiguration(this.cfile);
  }
  
  public void save()
  {
    try
    {
      this.file.save(this.cfile);
    }
    catch (IOException e)
    {
      Bukkit.getServer().getConsoleSender().sendMessage("[FreezeKits] StatsF.yml salvado com sucesso.");
    }
  }
  public void giveStats(Player p) {
	  file.set(p.getName().toLowerCase() + ".Kills", 0);
	  file.set(p.getName().toLowerCase() + ".Deaths", 0);
	  file.set(p.getName().toLowerCase() + ".Streak", 0);
	  file.set(p.getName().toLowerCase() + ".Valis", 0);
	  file.set(p.getName().toLowerCase() + ".Keys", 0);
	  if (p.getName().equals("GuiDev_")) {
		  file.set(p.getName().toLowerCase() + ".Clan", "ODR");
		  return;
	  }
	  file.set(p.getName().toLowerCase() + ".Clan", "Nenhum");
  }
  public String getClan(Player p) {
	  return file.getString(p.getName().toLowerCase() + ".Clan");
  }
  public void clearStreak(Player p) {
	  file.set(p.getName().toLowerCase() + ".Streak", Integer.valueOf(0));
	  save();
  }
  public int getStreak(Player p) {
	  return file.getInt(p.getName().toLowerCase()+ ".Streak");
  }
  public void addStreak(Player p, int qnt) {
	  file.set(p.getName().toLowerCase() + ".Streak", Integer.valueOf(getValis(p) + 1));
	  save();
  }
  public void removeValis(Player p, int qnt) {
	  file.set(p.getName().toLowerCase() + ".Valis", Integer.valueOf(getValis(p) - qnt));
	  save();
  }
  public void removeKey(Player p) {
	  file.set(p.getName().toLowerCase() + ".Keys", Integer.valueOf(getValis(p) - 1));
	  save();
  }
  public void addValis(Player p, int qnt) {
	  file.set(p.getName().toLowerCase() + ".Valis", Integer.valueOf(getValis(p) + qnt));
	  save();
  }
  public int getValis(Player p) {
	  return file.getInt(p.getName().toLowerCase() + ".Valis");
  }
  public int getKeys(Player p) {
	  return file.getInt(p.getName().toLowerCase() + ".Keys");
  }
  public void addKeys(Player p) {
	  file.set(p.getName().toLowerCase() + ".Keys", Integer.valueOf(getKeys(p) + 1));
	  save();
  }
  public int getKills(Player p)
  {
    return this.file.getInt(p.getName().toLowerCase() + ".Kills");
  }
  
  public int getDeaths(Player p)
  {
    return this.file.getInt(p.getName().toLowerCase() + ".Deaths");
  }
  public void addKills(Player p)
  {
    this.file.set(p.getName().toLowerCase() + ".Kills", Integer.valueOf(getKills(p) + 1));
    save();
  }
  
  public void addDeaths(Player p)
  {
    this.file.set(p.getName().toLowerCase() + ".Deaths", Integer.valueOf(getDeaths(p) + 1));
    save();
  }
  public FileConfiguration getStats()
  {
    return this.file;
  }
}
