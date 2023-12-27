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
import org.jooq.Row4
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

import work.fking.pangya.game.persistence.jooq.AlterPangya
import work.fking.pangya.game.persistence.jooq.keys.PLAYER_INVENTORY_CARD_PKEY
import work.fking.pangya.game.persistence.jooq.keys.PLAYER_INVENTORY_CARD__FK_PLAYER_INVENTORY_ITEM__ACCOUNT
import work.fking.pangya.game.persistence.jooq.tables.records.PlayerInventoryCardRecord


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class PlayerInventoryCard(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, PlayerInventoryCardRecord>?,
    aliased: Table<PlayerInventoryCardRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<PlayerInventoryCardRecord>(
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
         * <code>alter_pangya.player_inventory_card</code>
         */
        val PLAYER_INVENTORY_CARD: PlayerInventoryCard = PlayerInventoryCard()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<PlayerInventoryCardRecord> = PlayerInventoryCardRecord::class.java

    /**
     * The column <code>alter_pangya.player_inventory_card.uid</code>.
     */
    val UID: TableField<PlayerInventoryCardRecord, Int?> = createField(DSL.name("uid"), SQLDataType.INTEGER.nullable(false).identity(true), this, "")

    /**
     * The column <code>alter_pangya.player_inventory_card.account_uid</code>.
     */
    val ACCOUNT_UID: TableField<PlayerInventoryCardRecord, Int?> = createField(DSL.name("account_uid"), SQLDataType.INTEGER.nullable(false), this, "")

    /**
     * The column <code>alter_pangya.player_inventory_card.iff_id</code>.
     */
    val IFF_ID: TableField<PlayerInventoryCardRecord, Int?> = createField(DSL.name("iff_id"), SQLDataType.INTEGER.nullable(false), this, "")

    /**
     * The column <code>alter_pangya.player_inventory_card.quantity</code>.
     */
    val QUANTITY: TableField<PlayerInventoryCardRecord, Int?> = createField(DSL.name("quantity"), SQLDataType.INTEGER, this, "")

    private constructor(alias: Name, aliased: Table<PlayerInventoryCardRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<PlayerInventoryCardRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>alter_pangya.player_inventory_card</code> table
     * reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>alter_pangya.player_inventory_card</code> table
     * reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>alter_pangya.player_inventory_card</code> table reference
     */
    constructor(): this(DSL.name("player_inventory_card"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, PlayerInventoryCardRecord>): this(Internal.createPathAlias(child, key), child, key, PLAYER_INVENTORY_CARD, null)
    override fun getSchema(): Schema? = if (aliased()) null else AlterPangya.ALTER_PANGYA
    override fun getIdentity(): Identity<PlayerInventoryCardRecord, Int?> = super.getIdentity() as Identity<PlayerInventoryCardRecord, Int?>
    override fun getPrimaryKey(): UniqueKey<PlayerInventoryCardRecord> = PLAYER_INVENTORY_CARD_PKEY
    override fun getReferences(): List<ForeignKey<PlayerInventoryCardRecord, *>> = listOf(PLAYER_INVENTORY_CARD__FK_PLAYER_INVENTORY_ITEM__ACCOUNT)

    private lateinit var _account: Account

    /**
     * Get the implicit join path to the <code>alter_pangya.account</code>
     * table.
     */
    fun account(): Account {
        if (!this::_account.isInitialized)
            _account = Account(this, PLAYER_INVENTORY_CARD__FK_PLAYER_INVENTORY_ITEM__ACCOUNT)

        return _account;
    }

    val account: Account
        get(): Account = account()
    override fun `as`(alias: String): PlayerInventoryCard = PlayerInventoryCard(DSL.name(alias), this)
    override fun `as`(alias: Name): PlayerInventoryCard = PlayerInventoryCard(alias, this)
    override fun `as`(alias: Table<*>): PlayerInventoryCard = PlayerInventoryCard(alias.getQualifiedName(), this)

    /**
     * Rename this table
     */
    override fun rename(name: String): PlayerInventoryCard = PlayerInventoryCard(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): PlayerInventoryCard = PlayerInventoryCard(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): PlayerInventoryCard = PlayerInventoryCard(name.getQualifiedName(), null)

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row4<Int?, Int?, Int?, Int?> = super.fieldsRow() as Row4<Int?, Int?, Int?, Int?>

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    fun <U> mapping(from: (Int?, Int?, Int?, Int?) -> U): SelectField<U> = convertFrom(Records.mapping(from))

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    fun <U> mapping(toType: Class<U>, from: (Int?, Int?, Int?, Int?) -> U): SelectField<U> = convertFrom(toType, Records.mapping(from))
}
