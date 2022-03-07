package Otaku.Menus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MenuMini implements Listener{
	
	public static LojaPerm perm;
	public static Loja lojakits;
	
	 public static void guiwarps(Player p)
	  {
	    Inventory inv = Bukkit.getServer().createInventory(p, 9, "§6Treinamentos §7[GUI]");
	    ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
	    /*  26 */     ItemMeta metav = vidro.getItemMeta();
	    /*  28 */     vidro.setItemMeta(metav);
	    ItemStack diamante1111111 = new ItemStack(Material.BOOK);
	    ItemMeta metadiamante1111111 = diamante1111111.getItemMeta();
	    metadiamante1111111.setDisplayName("§cWarps de Treino");
	    diamante1111111.setItemMeta(metadiamante1111111);
	    
	    inv.setItem(2, diamante1111111);
	    
	    ItemStack diamante1111112 = new ItemStack(Material.MAP);
	    ItemMeta metadiamante1111112 = diamante1111112.getItemMeta();
	    metadiamante1111112.setDisplayName("§cEventos");
	    diamante1111112.setItemMeta(metadiamante1111112);
	    inv.setItem(6, diamante1111112);
	    ItemStack[] arrayOfItemStack;
  	    int descpyro = (arrayOfItemStack = inv.getContents()).length;
  	    for (int metapyro = 0; metapyro < descpyro; metapyro++)
  	    {
  	      ItemStack item = arrayOfItemStack[metapyro];
  	      if (item == null) {
  	        inv.setItem(inv.firstEmpty(), vidro);
  	      }
  	    }
	    p.openInventory(inv);
	  }
	 
	 @EventHandler
	 /*     */   public void ASD(InventoryClickEvent e)
	 /*     */   {
	 /* 165 */     Player p = (Player)e.getWhoClicked();
	 /* 166 */     if ((e.getInventory().getTitle().equalsIgnoreCase("§6Treinamentos §7[GUI]")) && 
	 /* 167 */       (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))
	 /*     */     {
		 e.setCancelled(true);
	 /* 187 */       if (e.getCurrentItem().getType() == Material.MAP)
	 /*     */       {
	                   Warps.guiEventos(p);
	                   p.playSound(p.getLocation(), Sound.CAT_HIT, 1.5F, 1.5F);
	 /* 191 */         return;
	 /*     */       }
	 /*     */       
	                 if (e.getCurrentItem().getType() == Material.BOOK)
	 /*     */       {
     Warps.guiWarps(p);
	 p.playSound(p.getLocation(), Sound.BAT_LOOP, 1.5F, 1.5F);
	 /* 191 */         return;
	 /*     */       }
	 }
}
}
