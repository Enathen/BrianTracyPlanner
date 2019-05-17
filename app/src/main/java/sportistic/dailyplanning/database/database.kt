package sportistic.dailyplanning.database


import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

/**
 *
 * @author Jonathan Alexander Norberg
 * @version 12/05/2019
 */
@Database(entities = [ABCDE::class,TenGoals::class,Achieve::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    public abstract fun abcdeDao(): ABCDEDao
    public abstract fun tenGoalsDao(): TenGoalsDao
    public abstract fun achieveDao(): AchieveDao

}