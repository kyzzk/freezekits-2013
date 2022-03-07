package Otaku;


import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.DefaultFlag;

import Otaku.API.*;
import Otaku.Comandos.*;
import Otaku.Eventos.*;
import Otaku.Files.*;
import Otaku.Menus.*;
import Otaku.Skill.*;
import Otaku.Warps.*;

public class Main extends JavaPlugin implements CommandExecutor {
	
	private static Plugin pl;
	private static Main instance;
	private static Stats s = Stats.getClasse();
	private static WarpM w = WarpM.getmulticonfig();
	public static Main m;
	
	public void onEnable() {
		
		s.setup(this);
		w.setup(this);
		m = this;

		getConfig().options().copyDefaults(true);
		saveDefaultConfig();

	                 new MandarMSG(this);
	                 MandarMSG.start();

	/* 122 */         super.onEnable();
	/* 123 */         onRegistro();
	/* 124 */         pl = this;
	/* 127 */         SFeast.start();
	/* 128 */         SFeast.start1();
	}
	public void registerEvents() {
		
	}
              
  public void onEnable2()
  {
    }
  
  public void onRegistro() {
/* 143 */     PluginManager pm = getServer().getPluginManager();
/* 144 */     pm.registerEvents(new Join(), this);
              pm.registerEvents(new LojaPerm(), this);
              pm.registerEvents(new TAG(), this);
pm.registerEvents(new JoinInventory(), this);
/* 150 */     pm.registerEvents(new Warps(), this);
              pm.registerEvents(new ScoreB(), this);
/* 151 */     pm.registerEvents(new Utils(), this);
/* 156 */     pm.registerEvents(new Admin(), this);
Bukkit.getPluginManager().registerEvents(new JoinBan(), this);
/* 158 */     pm.registerEvents(new Metodos(null), this);
/* 159 */     pm.registerEvents(new ArrayL(), this);
/* 160 */     pm.registerEvents(new Kits(), this);
pm.registerEvents(new CombatLog(), this);
pm.registerEvents(new CaixaAPI(), this);
              pm.registerEvents(new Stomper(), this);
/* 161 */     pm.registerEvents(new Ffeast(), this);
              pm.registerEvents(new Title(), this);
              pm.registerEvents(new TabColor(), this);
/* 162 */     pm.registerEvents(new SetFeast(), this);
/* 163 */     pm.registerEvents(new Jump(null), this);
/* 168 */     pm.registerEvents(new Ninja(), this);
/* 169 */     pm.registerEvents(new Supernova(), this);
/* 170 */     pm.registerEvents(new Thor(this), this);
/* 171 */     pm.registerEvents(new Terrorista(), this);
/* 172 */     pm.registerEvents(new Deshfire(), this);
/* 173 */     pm.registerEvents(new Mago(), this);
/* 174 */     pm.registerEvents(new Sonic(), this);
/* 175 */     pm.registerEvents(new Hulk(), this);
              pm.registerEvents(new QuandoDropar(), this);
/* 177 */     pm.registerEvents(new PegarKit(), this);
/* 179 */     pm.registerEvents(new Surprise(), this);
/* 180 */     pm.registerEvents(new Loja(), this);
              pm.registerEvents(new Form(this), this);
              pm.registerEvents(new Kit(), this);
              pm.registerEvents(new Site(this), this);
              pm.registerEvents(new Rain(this), this);
              pm.registerEvents(new TomarSopa(this), this);
              pm.registerEvents(new AjudaHelper(this), this);
              pm.registerEvents(new CrashPlayer(this), this);
              pm.registerEvents(new NaoDroparKit(this), this);
              pm.registerEvents(new Anchor(this), this);
              pm.registerEvents(new Grappler(), this);
              pm.registerEvents(new GladiatorHAB(), this);
              pm.registerEvents(new AvatarSV(), this);
              pm.registerEvents(new NaoOlha(), this);
              pm.registerEvents(new ForceField(), this);
              pm.registerEvents(new CMDInv(), this);
              pm.registerEvents(new ChatCommands(), this);
              pm.registerEvents(new Chat(), this);
              pm.registerEvents(new Kangaroo(), this);
              pm.registerEvents(new MenuMini(), this);
              pm.registerEvents(new mlg(), this);
              pm.registerEvents(new CaixaLoja(), this);
              pm.registerEvents(new Sumo(this), this);
              pm.registerEvents(new TesteMacro(), this);
              pm.registerEvents(new RegenerarBloco(this), this);
              
              getCommand("fly").setExecutor(new Fly());
              getCommand("setmlg").setExecutor(new SetMlg(this));
              getCommand("SetArena").setExecutor(new SetArena(this));
      		getCommand("inv").setExecutor(new CMDInv());
              getCommand("head").setExecutor(new Head(this));
              getCommand("v").setExecutor(new Admin());
              getCommand("tag").setExecutor(new TAG());
              getCommand("1v1").setExecutor(new NaoOlha());
              getCommand("score").setExecutor(new Cmds());

              getCommand("tag").setExecutor(new TAG());
              getCommand("mutechat").setExecutor(new ChatCommands());
/* 198 */     getCommand("kits").setExecutor(new PegarKit());
/* 199 */     getCommand("kit").setExecutor(new PegarKit());
/* 202 */     getCommand("gm").setExecutor(new Basic());
              getCommand("trial").setExecutor(new Form(this));
/* 204 */     getCommand("cc").setExecutor(new Basic());
/* 205 */     getCommand("resetkit").setExecutor(new Basic());
/* 206 */     getCommand("rdm").setExecutor(new Basic());
getCommand("setfps").setExecutor(new Todas());
getCommand("setrdm").setExecutor(new Todas());
getCommand("setmdr").setExecutor(new Todas());
getCommand("fps").setExecutor(new Todas());
getCommand("setlava").setExecutor(new Todas());
getCommand("lava").setExecutor(new Todas());
getCommand("knock").setExecutor(new Todas());
getCommand("mlg").setExecutor(new Todas());
getCommand("setspawn").setExecutor(new Todas());
getCommand("spawn").setExecutor(new Todas());
getCommand("testmacro").setExecutor(new TesteMacro());
getCommand("mdr").setExecutor(new Basic());
getCommand("cc").setExecutor(new ChatCommands());
getCommand("mutechat").setExecutor(new ChatCommands());
getCommand("tell").setExecutor(new ChatCommands());
getCommand("r").setExecutor(new ChatCommands());
getCommand("money").setExecutor(new Money());
getCommand("repass").setExecutor(new Money());

getCommand("clan").setExecutor(new Clan());
/* 207 */     getCommand("report").setExecutor(new Basic2());
              getCommand("sc").setExecutor(new ChatStaff());
/* 208 */     getCommand("bc").setExecutor(new Basic2());
              getCommand("site").setExecutor(new Site(this));
              getCommand("Tp").setExecutor(new Teletransporte());
/* 215 */     getCommand("admin").setExecutor(new Admin());
/* 216 */     getCommand("feast").setExecutor(new SetFeast());
/* 217 */     getCommand("rfeast").setExecutor(new SetFeast());
/* 219 */     getCommand("setfeast").setExecutor(new SetFeast());
              getCommand("say").setExecutor(new BC());
              getCommand("Morrer").setExecutor(new Morrer());
              getCommand("report").setExecutor(new Report());
              getCommand("setknock").setExecutor(new SetKnock(this));
              getCommand("ajuda").setExecutor(new AjudaHelper(this));
  }
public static Main getInstance()
{
  return instance;
}

public static Plugin getPlugin()
{
  return pl;
}
public static boolean SemPvP(Player p)
{
  ApplicableRegionSet region = 
    getWorldGuard().getRegionManager(p.getWorld()).getApplicableRegions(p.getLocation());
  if (region.allows(DefaultFlag.PVP)) {
    return true;
  }
  return false;
}

public static WorldGuardPlugin getWorldGuard()
{
  Plugin plugin = 
    Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");
  if ((plugin == null) || (!(plugin instanceof WorldGuardPlugin))) {
    return null;
  }
  return (WorldGuardPlugin)plugin;
}
}