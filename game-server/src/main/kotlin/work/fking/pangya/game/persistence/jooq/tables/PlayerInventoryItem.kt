/*
 * This file is generated by jOOQ.
 */
package work.fking.pangya.game.persistence.jooq.tables


import java.util.function.Function

import kotlin.collections.List

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
import org.jooq.Name
import org.jooq.Record
import org.jooq.Records
import org.jooq.Row7
import org.jooq.Schema
import org.jooq.SelectField
import org.jooq.Table
import org.jooq.TableField
import org.jooq.TableOptions
import org.jooq.UniqueKey
import org.jooq.impl.DSL
import org.jooq.impl.Internal
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl
import org.jooq.jackson.extensions.converters.JSONtoJacksonConverter

import work.fking.pangya.game.persistence.jooq.AlterPangya
import work.fking.pangya.game.persistence.jooq.keys.PLAYER_INVENTORY_ITEM_PKEY
import work.fking.pangya.game.persistence.jooq.keys.PLAYER_INVENTORY_ITEM__FK_PLAYER_INVENTORY_ITEM__ACCOUNT
import work.fking.pangya.game.persistence.jooq.tables.records.PlayerInventoryItemRecord
import work.fking.pangya.game.player.ItemClubWorkshop
import work.fking.pangya.game.player.ItemUcc


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class PlayerInventoryItem(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, PlayerInventoryItemRecord>?,
    aliased: Table<PlayerInventoryItemRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<PlayerInventoryItemRecord>(
    alias,
    AlterPangya.ALTER_PANGYA,
    child,
    path,
    aliased,
    parameters,
    DSL.comment(""),
    TableOptions.table()
) {
    companion object {

        /**
         * The reference instance of
         * <code>alter_pangya.player_inventory_item</code>
         */
        val PLAYER_INVENTORY_ITEM: PlayerInventoryItem = PlayerInventoryItem()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<PlayerInventoryItemRecord> = PlayerInventoryItemRecord::class.java

    /**
     * The column <code>alter_pangya.player_inventory_item.uid</code>.
     */
    val UID: TableField<PlayerInventoryItemRecord, Int?> = createField(DSL.name("uid"), SQLDataType.INTEGER.nullable(false).identity(true), this, "")

    /**
     * The column <code>alter_pangya.player_inventory_item.account_uid</code>.
     */
    val ACCOUNT_UID: TableField<PlayerInventoryItemRecord, Int?> = createField(DSL.name("account_uid"), SQLDataType.INTEGER.nullable(false), this, "")

    /**
     * The column <code>alter_pangya.player_inventory_item.iff_id</code>.
     */
    val IFF_ID: TableField<PlayerInventoryItemRecord, Int?> = createField(DSL.name("iff_id"), SQLDataType.INTEGER.nullable(false), this, "")

    /**
     * The column <code>alter_pangya.player_inventory_item.quantity</code>.
     */
    val QUANTITY: TableField<PlayerInventoryItemRecord, Int?> = createField(DSL.name("quantity"), SQLDataType.INTEGER.defaultValue(DSL.field(DSL.raw("0"), SQLDataType.INTEGER)), this, "")

    /**
     * The column <code>alter_pangya.player_inventory_item.stats</code>.
     */
    val STATS: TableField<PlayerInventoryItemRecord, IntArray?> = createField(DSL.name("stats"), SQLDataType.JSON, this, "", JSONtoJacksonConverter<IntArray>(IntArray::class.java))

    /**
     * The column <code>alter_pangya.player_inventory_item.ucc</code>.
     */
    val UCC: TableField<PlayerInventoryItemRecord, ItemUcc?> = createField(DSL.name("ucc"), SQLDataType.JSON, this, "", JSONtoJacksonConverter<ItemUcc>(ItemUcc::class.java))

    /**
     * The column <code>alter_pangya.player_inventory_item.club_workshop</code>.
     */
    val CLUB_WORKSHOP: TableField<PlayerInventoryItemRecord, ItemClubWorkshop?> = createField(DSL.name("club_workshop"), SQLDataType.JSON, this, "", JSONtoJacksonConverter<ItemClubWorkshop>(ItemClubWorkshop::class.java))

    private constructor(alias: Name, aliased: Table<PlayerInventoryItemRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<PlayerInventoryItemRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>alter_pangya.player_inventory_item</code> table
     * reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>alter_pangya.player_inventory_item</code> table
     * reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>alter_pangya.player_inventory_item</code> table reference
     */
    constructor(): this(DSL.name("player_inventory_item"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, PlayerInventoryItemRecord>): this(Internal.createPathAlias(child, key), child, key, PLAYER_INVENTORY_ITEM, null)
    override fun getSchema(): Schema? = if (aliased()) null else AlterPangya.ALTER_PANGYA
    override fun getIdentity(): Identity<PlayerInventoryItemRecord, Int?> = super.getIdentity() as Identity<PlayerInventoryItemRecord, Int?>
    override fun getPrimaryKey(): UniqueKey<PlayerInventoryItemRecord> = PLAYER_INVENTORY_ITEM_PKEY
    override fun getReferences(): List<ForeignKey<PlayerInventoryItemRecord, *>> = listOf(PLAYER_INVENTORY_ITEM__FK_PLAYER_INVENTORY_ITEM__ACCOUNT)

    private lateinit var _account: Account

    /**
     * Get the implicit join path to the <code>alter_pangya.account</code>
     * table.
     */
    fun account(): Account {
        if (!this::_account.isInitialized)
            _account = Account(this, PLAYER_INVENTORY_ITEM__FK_PLAYER_INVENTORY_ITEM__ACCOUNT)

        return _account;
    }

    val account: Account
        get(): Account = account()
    override fun `as`(alias: String): PlayerInventoryItem = PlayerInventoryItem(DSL.name(alias), this)
    override fun `as`(alias: Name): PlayerInventoryItem = PlayerInventoryItem(alias, this)
    override fun `as`(alias: Table<*>): PlayerInventoryItem = PlayerInventoryItem(alias.getQualifiedName(), this)

    /**
     * Rename this table
     */
    override fun rename(name: String): PlayerInventoryItem = PlayerInventoryItem(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): PlayerInventoryItem = PlayerInventoryItem(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): PlayerInventoryItem = PlayerInventoryItem(name.getQualifiedName(), null)

    // -------------------------------------------------------------------------
    // Row7 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row7<Int?, Int?, Int?, Int?, IntArray?, ItemUcc?, ItemClubWorkshop?> = super.fieldsRow() as Row7<Int?, Int?, Int?, Int?, IntArray?, ItemUcc?, ItemClubWorkshop?>

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    fun <U> mapping(from: (Int?, Int?, Int?, Int?, IntArray?, ItemUcc?, ItemClubWorkshop?) -> U): SelectField<U> = convertFrom(Records.mapping(from))

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    fun <U> mapping(toType: Class<U>, from: (Int?, Int?, Int?, Int?, IntArray?, ItemUcc?, ItemClubWorkshop?) -> U): SelectField<U> = convertFrom(toType, Records.mapping(from))
}
