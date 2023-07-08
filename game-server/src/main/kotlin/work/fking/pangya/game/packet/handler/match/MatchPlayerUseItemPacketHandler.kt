package work.fking.pangya.game.packet.handler.match

import io.netty.buffer.ByteBuf
import work.fking.pangya.game.GameServer
import work.fking.pangya.game.net.ClientPacketHandler
import work.fking.pangya.game.player.Player
import work.fking.pangya.game.room.match.PlayerUseItemEvent

class MatchPlayerUseItemPacketHandler : ClientPacketHandler {

    override fun handle(server: GameServer, player: Player, packet: ByteBuf) {
        val room = player.currentRoom ?: throw IllegalStateException("Player ${player.nickname} finished it's turn but is not in a room")
        val roomPlayer = room.findSelf(player)

        room.handleMatchEvent(PlayerUseItemEvent(roomPlayer, packet.readIntLE()))
    }
}