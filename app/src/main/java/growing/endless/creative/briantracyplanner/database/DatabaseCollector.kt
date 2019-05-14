package growing.endless.creative.briantracyplanner.database

import android.arch.persistence.room.Room
import android.content.Context

/**
 *
 * @author Jonathan Alexander Norberg
 * @version 13/05/2019
 */
class DatabaseCollector constructor(applicationContext: Context) {
    private val db: AppDatabase = Room.databaseBuilder(
        applicationContext,
        AppDatabase::class.java, "database-name"
    ).fallbackToDestructiveMigration().build()

    fun insertABCDE(abcde: ABCDE) {

        db.abcdeDao().insert(abcde)

    }

    fun getAllABCDE(): List<ABCDE> {
        return db.abcdeDao().getAll()
    }

    fun getAllTenGoals(): List<TenGoals> {
        return db.tenGoalsDao().getAll()
    }

    fun getAllAchieve(): List<Achieve> {
        return db.achieveDao().getAll()
    }

    fun insertTenGoals(tenGoals: TenGoals) {
        db.tenGoalsDao().insert(tenGoals)
    }

    fun insertAchieve(achieve: Achieve) {
        db.achieveDao().insert(achieve)
    }

    fun getABCDE(id: Int): ABCDE {
        return db.abcdeDao().get(id)
    }
    fun getTopGoals(id: Int): TenGoals {
        return db.tenGoalsDao().get(id)
    }
    fun getAchieve(id: Int): Achieve {
        return db.achieveDao().get(id)
    }

    fun delete(id: Int): Boolean {
        Thread(Runnable {
            db.abcdeDao().delete(db.abcdeDao().get(id))
            db.tenGoalsDao().delete(db.tenGoalsDao().get(id))
            db.achieveDao().delete(db.achieveDao().get(id)) }).start()

        return true
    }


}