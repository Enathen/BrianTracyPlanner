package sportistic.dailyplanning.database

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.*

/**
 *
 * @author Jonathan Alexander Norberg
 * @version 12/05/2019
 */
@Entity

data class ABCDE(

    var A: String = "",
    var B: String = "",
    var C: String = "",
    var D: String = "",
    var E: String = "",
    var date: String = SimpleDateFormat("MM/dd/yy hh:mm").format(Date())

) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}