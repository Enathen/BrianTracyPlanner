package growing.endless.creative.briantracyplanner.animation

import android.content.Context
import android.view.View
import android.view.animation.AnimationUtils
import growing.endless.creative.briantracyplanner.R

/**
 *
 * @author Jonathan Alexander Norberg
 * @version 10/05/2019
 */
class Animations {
     companion object {
         fun fade_in(list: List<View>,context: Context) {
             for (view in list) {
                 view.startAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_in))
             }
         }
     }
}