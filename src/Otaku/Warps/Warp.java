package Otaku.Warps;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class Warp {

	public static ArrayList<String> inWarp = new ArrayList<>();
	
	public static void removeW(Player p) {
		inWarp.remove(p.getName());
	}
}
