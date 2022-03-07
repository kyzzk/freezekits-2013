package Otaku.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;

public class MandarMSG
  implements Listener
{
  public static Otaku.Main plugin;
  private static Otaku.Main main;
  
  public MandarMSG(Otaku.Main pl)
  {
    main = pl;
    plugin = main;
  }
  
  public static void start()
  {
    Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(main, new Runnable()
    {
      String[] Msg = {
        "                                  \n§7Ajude o servidor compando vip §c/site\n                             ",
        "                                  \n§7Servidor Pirata/Original 1.7x e 1.8x !\n                                 ", 
        "                                  \n§7Vendemos Vip via cartão e boleto !\n                                 ",
        "                                  \n§7Veja requisitos para tag Youtuber §c/ajuda !\n                                 ",
        "                                  \n§aVip apartir de R$5,90 em nossa Loja .\n                                 ",
        "                                  \n§7Obrigado por jogar em Nosso servidor .\n                                 ",
        "                                  \n§7Encontrou algum noob usando Hack? use o comando §c/report§7 .\n                                 ",
        "                                  \n§7Vagas staff §c/trial§7.\n                                 ",
        "                                  \n§7Obrigado por jogar em Nosso servidor .\n                                 ",
        "                                  \n§7Divulguem o servidor para amigos, obrigado !\n                                 " };
      
      public void run()
      {
        Bukkit.getServer().broadcastMessage(this.Msg[new java.util.Random().nextInt(this.Msg.length)]);
      }
    }, 0L, 1250L);
  }
}
