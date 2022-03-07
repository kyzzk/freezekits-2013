package Otaku.API;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

public class KitAPI {

	public static HashMap<String, String> Skill = new HashMap<>();
	
	public static String getKit(Player p) {
		return Skill.get(p.getName());
	}
	public static void setKit(Player p, String kit) {
		Skill.put(p.getName(), kit);
		return;
	}
	public static void giveKit(Player p) {
		String kit = getKit(p);
		
		API.cI(p);
		API.setItem(p.getInventory(), 1, API.create(Material.STONE_SWORD, "§eEspada de Pedra"));
		API.firstEmpty(p.getInventory(), API.create(Material.MUSHROOM_SOUP, "Sopa"));
		
		if (kit == "PvP") {
			API.setItem(p.getInventory(), 1, API.create(Material.STONE_SWORD, "Es", Enchantment.DAMAGE_ALL, 1));
		}
		
		API.msg(p, API.prefix + "§aVoce selecionou o kit: §e" + kit);
		API.som(p, Sound.NOTE_PLING, 2.0F);
	}
}
