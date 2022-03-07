/*    */ package Otaku.Comandos;
/*    */ 
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.Listener;

import Otaku.Eventos.Ffeast;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SetFeast
/*    */   implements CommandExecutor, Listener
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String tag, String[] args)
/*    */   {
/* 59 */     if (!(sender instanceof Player)) {
/* 60 */       sender.sendMessage("§cVoce nao é um jogador");
/* 61 */       return true;
/*    */     }
/* 63 */     Player p = (Player)sender;
/* 64 */     if (tag.equalsIgnoreCase("setfeast")) {
/* 65 */       if (!p.hasPermission("kitpvp.admin")) {
/* 66 */         p.sendMessage("§cSem Permissação!");
/* 67 */         return true;
/*    */       }
/*    */       
/* 70 */       p.sendMessage("§6>> §7Feast Setado Com Sucesso");
/* 71 */       Ffeast.setSimulatorCords1(p);
/*    */       
/* 73 */       return true;
/*    */     }
/* 75 */     if ((cmd.getName().equalsIgnoreCase("feast")) && (p.hasPermission("kitpvp.admin")))
/*    */     {
/* 77 */       Ffeast.miniFeast();
/* 78 */       p.sendMessage("§6>> §7Feast Criado Com Sucesso");
/*    */     }
/* 80 */     if ((cmd.getName().equalsIgnoreCase("rfeast")) && (p.hasPermission("kitpvp.admin")))
/*    */     {
/* 82 */       Ffeast.miniFeast1();
/* 83 */       p.sendMessage("§6>> §7Feast Removido Com Sucesso");
/* 84 */       Ffeast.setSimulatorCords1(p);
/*    */     }
/*    */     
/* 87 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\pcnote\Desktop\PublicG2.jar!\zCommands\SetFeast.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */