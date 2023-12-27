/*
 * This file is generated by jOOQ.
 */
package work.fking.pangya.game.persistence.jooq.tables


import java.util.function.Function

import kotlin.collections.List

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
import org.jooq.Index
import org.jooq.Name
import org.jooq.Record
import org.jooq.Records
import org.jooq.Row5
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
import work.fking.pangya.game.persistence.jooq.indexes.IDX_PLAYER_CADDIE
import work.fking.pangya.game.persistence.jooq.keys.PLAYER_CADDIE_PKEY
import work.fking.pangya.game.persistence.jooq.keys.PLAYER_CADDIE__FK_PLAYER_CADDIE__ACCOUNT
import work.fking.pangya.game.persistence.jooq.tables.records.PlayerCaddieRecord


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class PlayerCaddie(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, PlayerCaddieRecord>?,
    aliased: Table<PlayerCaddieRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<PlayerCaddieRecord>(
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
         * The reference instance of <code>alter_pangya.player_caddie</code>
         */
        val PLAYER_CADDIE: PlayerCaddie = PlayerCaddie()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<PlayerCaddieRecord> = PlayerCaddieRecord::class.java

    /**
     * The column <code>alter_pangya.player_caddie.uid</code>.
     */
    val UID: TableField<PlayerCaddieRecord, Int?> = createField(DSL.name("uid"), SQLDataType.INTEGER.nullable(false).identity(true), this, "")

    /**
     * The column <code>alter_pangya.player_caddie.account_uid</code>.
     */
    val ACCOUNT_UID: TableField<PlayerCaddieRecord, Int?> = createField(DSL.name("account_uid"), SQLDataType.INTEGER.nullable(false), this, "")

    /**
     * The column <code>alter_pangya.player_caddie.iff_id</code>.
     */
    val IFF_ID: TableField<PlayerCaddieRecord, Int?> = createField(DSL.name("iff_id"), SQLDataType.INTEGER.nullable(false), this, "")

    /**
     * The column <code>alter_pangya.player_caddie.level</code>.
     */
    val LEVEL: TableField<PlayerCaddieRecord, Int?> = createField(DSL.name("level"), SQLDataType.INTEGER.nullable(false), this, "")

    /**
     * The column <code>alter_pangya.player_caddie.experience</code>.
     */
    val EXPERIENCE: TableField<PlayerCaddieRecord, Int?> = createField(DSL.name("experience"), SQLDataType.INTEGER.nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<PlayerCaddieRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<PlayerCaddieRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>alter_pangya.player_caddie</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>alter_pangya.player_caddie</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>alter_pangya.player_caddie</code> table reference
     */
    constructor(): this(DSL.name("player_caddie"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, PlayerCaddieRecord>): this(Internal.createPathAlias(child, key), child, key, PLAYER_CADDIE, null)
    override fun getSchema(): Schema? = if (aliased()) null else AlterPangya.ALTER_PANGYA
    override fun getIndexes(): List<Index> = listOf(IDX_PLAYER_CADDIE)
    override fun getIdentity(): Identity<PlayerCaddieRecord, Int?> = super.getIdentity() as Identity<PlayerCaddieRecord, Int?>
    override fun getPrimaryKey(): UniqueKey<PlayerCaddieRecord> = PLAYER_CADDIE_PKEY
    override fun getReferences(): List<ForeignKey<PlayerCaddieRecord, *>> = listOf(PLAYER_CADDIE__FK_PLAYER_CADDIE__ACCOUNT)

    private lateinit var _account: Account

    /**
     * Get the implicit join path to the <code>alter_pangya.account</code>
     * table.
     */
    fun account(): Account {
        if (!this::_account.isInitialized)
            _account = Account(this, PLAYER_CADDIE__FK_PLAYER_CADDIE__ACCOUNT)

        return _account;
    }

    val account: Account
        get(): Account = account()
    override fun `as`(alias: String): PlayerCaddie = PlayerCaddie(DSL.name(alias), this)
    override fun `as`(alias: Name): PlayerCaddie = PlayerCaddie(alias, this)
    override fun `as`(alias: Table<*>): PlayerCaddie = PlayerCaddie(alias.getQualifiedName(), this)

    /**
     * Rename this table
     */
    override fun rename(name: String): PlayerCaddie = PlayerCaddie(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): PlayerCaddie = PlayerCaddie(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): PlayerCaddie = PlayerCaddie(name.getQualifiedName(), null)

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row5<Int?, Int?, Int?, Int?, Int?> = super.fieldsRow() as Row5<Int?, Int?, Int?, Int?, Int?>

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    fun <U> mapping(from: (Int?, Int?, Int?, Int?, Int?) -> U): SelectField<U> = convertFrom(Records.mapping(from))

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    fun <U> mapping(toType: Class<U>, from: (Int?, Int?, Int?, Int?, Int?) -> U): SelectField<U> = convertFrom(toType, Records.mapping(from))
}
