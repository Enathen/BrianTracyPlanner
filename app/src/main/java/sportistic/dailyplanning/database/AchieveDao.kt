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
interface AchieveDao {
    @Query("SELECT * FROM Achieve")
    fun getAll(): List<Achieve>
    @Query("SELECT * FROM Achieve where id = :id")
    fun get(id: Int): Achieve
    @Insert
    fun insert( abcde: Achieve)

    @Delete
    fun delete(abcde: Achieve)
}