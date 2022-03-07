/*     */ package Otaku.Comandos;
/*     */ 
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.Listener;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Basic2
/*     */   implements CommandExecutor, Listener
/*     */ {
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String tag, String[] args)
/*     */   {
/*  32 */     if (!(sender instanceof Player)) {
/*  33 */       sender.sendMessage("§cVoce nao é um jogador");
/*  34 */       return true;
/*     */     }
/*  36 */     Player p = (Player)sender;
/*     */ 
/*     */ 
/*  86 */     if ((cmd.getName().equalsIgnoreCase("bc")) && (p.hasPermission("kitpvp.admin")))
/*     */     {
/*     */ 
/*  89 */       if (args.length == 0) {
/*  90 */         p.sendMessage(ChatColor.RED + "Use /bc (Mensagem)");
/*  91 */         return true;
/*     */       }
/*  93 */       String msg = "";
/*     */       String[] arrayOfStrings;
/*  95 */       int j = (arrayOfStrings = args).length;
/*  96 */       for (int i = 0; i < j; i++) {
/*  97 */         String msg2 = arrayOfStrings[i];
/*  98 */         msg = msg + msg2 + " ";
/*     */       }
/*     */       
/* 101 */       Bukkit.broadcastMessage("§7[§c§lAVISO§7] §f" + msg);
/*     */     }
return false;
}
}


/* Location:              C:\Users\pcnote\Desktop\PublicG2.jar!\zCommands\Basic2.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */