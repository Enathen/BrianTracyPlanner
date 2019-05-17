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
interface TenGoalsDao {
    @Query("SELECT * FROM TenGoals")
    fun getAll(): List<TenGoals>
    @Query("SELECT * FROM TenGoals where id = :id")
    fun get(id: Int): TenGoals
    @Insert
    fun insert( abcde: TenGoals)

    @Delete
    fun delete(abcde: TenGoals)
}