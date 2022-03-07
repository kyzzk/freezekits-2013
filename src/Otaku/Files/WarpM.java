package Otaku.Files;

import java.io.File;
import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class WarpM
{
  Plugin p;
  FileConfiguration warps;
  File mConfig;
  static WarpM instance = new WarpM();

  public static WarpM getmulticonfig() {
    return instance;
  }

  public void setup(Plugin p) {
    this.mConfig = new File(p.getDataFolder(), "Warps.yml");
    if (!this.mConfig.exists()) {
      try
      {
        this.mConfig.createNewFile();
      }
      catch (IOException e)
      {
        Bukkit.getServer().getLogger().severe("[FreezeKits] Warps.yml criada com sucesso!");
      }
    }
    this.warps = YamlConfiguration.loadConfiguration(this.mConfig);
  }

  public FileConfiguration getWarps() {
    return this.warps;
  }

  public void saveWarps()
  {
    try {
      this.warps.save(this.mConfig);
    }
    catch (IOException e)
    {
      Bukkit.getServer().getLogger().severe("[FreezeKits] Warps.yml criada com sucesso!");
    }
  }

  public void reloadMessages() {
    this.warps = YamlConfiguration.loadConfiguration(this.mConfig);
  }
}