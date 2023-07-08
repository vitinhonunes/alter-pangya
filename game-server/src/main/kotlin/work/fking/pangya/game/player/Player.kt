package work.fking.pangya.game.player

import io.netty.channel.Channel
import work.fking.pangya.game.ServerChannel
import work.fking.pangya.game.room.Room
import java.util.Objects
import kotlin.math.max

class Player(
    private val channel: Channel,
    val uid: Int,
    val connectionId: Int,
    val username: String,
    val nickname: String
) {
    val inventory = Inventory()
    val equipment = Equipment(this)
    val characterRoster = CharacterRoster()
    val caddieRoster = CaddieRoster()

    var rank = 0
        private set
    var experience = 0
        set(value) {
            require(value >= 0) { "Cannot add negative experience" }
            field += value
        }

    var pangBalance = 10000
        set(value) {
            field = max(0, value)
        }
    var cookieBalance = 0
        set(value) {
            field = max(0, value)
        }

    var currentChannel: ServerChannel? = null
        set(value) {
            require(currentChannel == null) { "Player is already in a channel" }
            field = value
        }
    var currentRoom: Room? = null
        set(value) {
            if (value != null) require(currentRoom == null) { "Player is already in a room" }
            field = value
        }

    fun equippedCharacter(): Character {
        return characterRoster.findByUid(equipment.equippedCharacterUid()) ?: throw IllegalStateException("Player does not have a equipped character")
    }

    fun activeCaddie(): Caddie? {
        return caddieRoster.findByUid(equipment.equippedCaddieUid())
    }

    fun write(message: Any) {
        channel.write(message, channel.voidPromise())
    }

    fun writeAndFlush(message: Any) {
        channel.writeAndFlush(message)
    }

    fun flush() {
        channel.flush()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other == null || javaClass != other.javaClass) {
            return false
        }
        val player = other as Player
        return uid == player.uid
    }

    override fun hashCode(): Int {
        return Objects.hash(uid)
    }
}
