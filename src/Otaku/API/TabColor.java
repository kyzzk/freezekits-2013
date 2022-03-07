package Otaku.API;

import org.bukkit.craftbukkit.v1_7_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.minecraft.server.v1_7_R3.ChatSerializer;
import net.minecraft.server.v1_7_R3.IChatBaseComponent;
import net.minecraft.server.v1_7_R3.PlayerConnection;

public class TabColor implements Listener
{
  private static int VERSION = 47;
  
  @EventHandler
  public void onPlayerConnect(PlayerJoinEvent e)
  {
    Player p = e.getPlayer();
    PlayerConnection connect = ((CraftPlayer)p).getHandle().playerConnection;
    IChatBaseComponent top = ChatSerializer.a(
      "{'extra': [{text: ' §8» §aServidor 1.7 e 1.8 \n§aJogue livre de LAG!', color: 'aqua'}],'color': gold, 'text': '§bFreeze§fKits'}");
    IChatBaseComponent bottom = ChatSerializer.a(
      "{'extra': [{'color': 'aqua', 'text': '§c/site', 'underline': 'true'}], 'color': 'gold', 'text': '§8Visite nosso Site usando: '}");
    if (((CraftPlayer)p).getHandle().playerConnection.networkManager.getVersion() < VERSION) {
      return;
    }
   // connect.sendPacket(new ProtocolInjector.PacketTabHeader(top, bottom));
  }
}
