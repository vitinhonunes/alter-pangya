package work.fking.pangya.game.packet.handler;

import io.netty.buffer.ByteBuf;
import work.fking.pangya.game.net.ClientPacketHandler;
import work.fking.pangya.game.GameServer;
import work.fking.pangya.game.player.Player;

public class LockerInventoryRequestPacketHandler implements ClientPacketHandler {

    @Override
    public void handle(GameServer server, Player player, ByteBuf packet) {

    }
}
