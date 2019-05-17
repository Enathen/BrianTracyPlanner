package sportistic.dailyplanning.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

/**
 *
 * @author Jonathan Alexander Norberg
 * @version 12/05/2019
 */
@Dao
interface ABCDEDao {
    @Query("SELECT * FROM ABCDE order by id Desc")
    fun getAll(): List<ABCDE>
    @Query("SELECT * FROM ABCDE where id = :id ")
    fun get(id: Int): ABCDE
    @Insert
    fun insert( abcde: ABCDE)

    @Delete
    fun delete(abcde: ABCDE)
}