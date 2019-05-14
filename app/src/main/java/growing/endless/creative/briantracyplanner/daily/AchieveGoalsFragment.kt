package growing.endless.creative.briantracyplanner.daily

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import growing.endless.creative.briantracyplanner.R
import growing.endless.creative.briantracyplanner.database.DatabaseCollector
import kotlinx.android.synthetic.main.activity_daily.*
import kotlinx.android.synthetic.main.fragment_how_to_achieve_one_goal.view.*

/**
 *
 * @author Jonathan Alexander Norberg
 * @version 10/05/2019
 */
class AchieveGoalsFragment : Fragment() {
    public lateinit var rootViewAchieve: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootViewAchieve = inflater.inflate(R.layout.fragment_how_to_achieve_one_goal, container, false)
        setupNavigation(rootViewAchieve)
        viewOnly()
        return rootViewAchieve
    }

    private fun setupNavigation(rootView: View) {
        rootView.ivLeft.setOnClickListener { activity!!.container.currentItem = 1 }
        rootView.ivRight.visibility = View.INVISIBLE

        rootView.btnSave.setOnClickListener{(activity as DailyActivity).save()}

    }
    private fun viewOnly() {
        val id = arguments!!.getInt("id", -1)
        if (id > -1) {
            val databaseCollecter = DatabaseCollector(this.context!!)
            Thread(Runnable {
                val achieve = databaseCollecter.getAchieve(id)
                activity!!.runOnUiThread {
                    rootViewAchieve.et1.setText(achieve.one)
                    rootViewAchieve.et1.isEnabled = false
                    rootViewAchieve.et2.setText(achieve.two)
                    rootViewAchieve.et2.isEnabled = false
                    rootViewAchieve.et3.setText(achieve.three)
                    rootViewAchieve.et3.isEnabled = false
                    rootViewAchieve.et4.setText(achieve.four)
                    rootViewAchieve.et4.isEnabled = false
                    rootViewAchieve.et5.setText(achieve.five)
                    rootViewAchieve.et5.isEnabled = false
                    rootViewAchieve.et6.setText(achieve.six)
                    rootViewAchieve.et6.isEnabled = false
                    rootViewAchieve.et7.setText(achieve.seven)
                    rootViewAchieve.et7.isEnabled = false
                    rootViewAchieve.et8.setText(achieve.eigth)
                    rootViewAchieve.et8.isEnabled = false
                    rootViewAchieve.et9.setText(achieve.nine)
                    rootViewAchieve.et9.isEnabled = false
                    rootViewAchieve.et10.setText(achieve.ten)
                    rootViewAchieve.et10.isEnabled = false
                    rootViewAchieve.btnSave.visibility = View.GONE
                }

            }).start()
        }
    }
    fun newInstance(index: Int): AchieveGoalsFragment{
        val f = AchieveGoalsFragment ()
        // Pass index input as an argument.
        val args = Bundle()
        args.putInt("id", index)
        f.setArguments(args)
        return f
    }


}