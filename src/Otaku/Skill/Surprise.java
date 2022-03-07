package Otaku.Skill;

import java.util.ArrayList;
import java.util.Random;
import org.bukkit.event.Listener;

public class Surprise implements Listener {
	
	private static ArrayList<String> kits = new ArrayList<String>();
	
	public static String get() {
		if (kits.size() > 0) {
			return (String)kits.get(new Random().nextInt(kits.size()));
		}
		return null;
	}
	public Surprise() {
		kits.add("Anchor");
		kits.add("Avatar");
		kits.add("DeshFire");
		kits.add("Gladiator");
		kits.add("Hulk");
		kits.add("Kangaroo");
		kits.add("Mago");
		kits.add("Ninja");
		kits.add("Sonic");
		kits.add("Sumo");
		kits.add("SuperNova");
		kits.add("Thor");
	}
}
