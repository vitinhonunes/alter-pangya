package work.fking.pangya.game.packet.handler;

import io.netty.channel.Channel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import work.fking.pangya.game.packet.inbound.HandoverPacket;
import work.fking.pangya.game.packet.outbound.CaddieRosterPacket;
import work.fking.pangya.game.packet.outbound.CharacterRosterPacket;
import work.fking.pangya.game.packet.outbound.CookieBalancePacket;
import work.fking.pangya.game.packet.outbound.EquipmentPacket;
import work.fking.pangya.game.packet.outbound.HandoverJunkPacket;
import work.fking.pangya.game.packet.outbound.InventoryPacket;
import work.fking.pangya.game.packet.outbound.MascotRosterPacket;
import work.fking.pangya.game.packet.outbound.PangBalancePacket;
import work.fking.pangya.game.packet.outbound.PlayerDataPacket;
import work.fking.pangya.game.packet.outbound.ServerChannelsPacket;
import work.fking.pangya.networking.protocol.InboundPacketHandler;

import javax.inject.Singleton;

@Singleton
public class HandoverPacketHandler implements InboundPacketHandler<HandoverPacket> {

    private static final Logger LOGGER = LogManager.getLogger(HandoverPacketHandler.class);

    @Override
    public void handle(Channel channel, HandoverPacket packet) {
        LOGGER.debug(packet);

        // https://github.com/hsreina/pangya-server/blob/449140f97592d5d403ef0df01d19ca2c6c834361/src/Server/Sync/SyncServer.pas#L430

        channel.write(new HandoverJunkPacket());
        channel.writeAndFlush(new PlayerDataPacket());
        channel.writeAndFlush(new CharacterRosterPacket()); // known ok
        channel.writeAndFlush(new CaddieRosterPacket()); // known ok
        channel.writeAndFlush(new EquipmentPacket()); // known ok
        channel.writeAndFlush(new MascotRosterPacket());
        channel.writeAndFlush(new InventoryPacket());
        channel.writeAndFlush(new CookieBalancePacket()); // known ok
        channel.writeAndFlush(new PangBalancePacket()); // known ok
        channel.writeAndFlush(new ServerChannelsPacket());
    }
}
