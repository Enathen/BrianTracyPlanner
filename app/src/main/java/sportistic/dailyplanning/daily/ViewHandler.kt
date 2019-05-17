package sportistic.dailyplanning.daily

import android.content.res.ColorStateList
import android.support.design.widget.TextInputEditText
import android.support.v4.view.ViewCompat

/**
 *
 * @author Jonathan Alexander Norberg
 * @version 15/05/2019
 */
class ViewHandler {
    companion object {
        fun editTextDisabled(
            etA: TextInputEditText,
            a1: String,
            color: Int
        ) {
            etA.setText(a1)
            etA.isEnabled = false
            val colorStateList = ColorStateList.valueOf(color)
            ViewCompat.setBackgroundTintList(etA, colorStateList)
        }
    }
}