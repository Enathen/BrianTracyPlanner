package sportistic.dailyplanning.daily

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_daily.*
import kotlinx.android.synthetic.main.fragment_how_to_achieve_one_goal.view.*
import sportistic.dailyplanning.R
import sportistic.dailyplanning.database.DatabaseCollector

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
        rootViewAchieve.ivLeft.setOnClickListener { activity!!.container.currentItem = 1 }
        rootViewAchieve.ivRight.visibility = View.INVISIBLE

        rootView.btnSave.setOnClickListener{
            (activity as DailyActivity).save()

        }

    }
    private fun viewOnly() {
        val id = arguments!!.getInt("id", -1)
        if (id > -1) {
            val databaseCollecter = DatabaseCollector(this.context!!)
            Thread(Runnable {
                val achieve = databaseCollecter.getAchieve(id)
                activity!!.runOnUiThread {
                    ViewHandler.editTextDisabled(rootViewAchieve.et1,achieve.one, ContextCompat.getColor(context!!,R.color.colorTransparent))
                    ViewHandler.editTextDisabled(rootViewAchieve.et2,achieve.two, ContextCompat.getColor(context!!,R.color.colorTransparent))
                    ViewHandler.editTextDisabled(rootViewAchieve.et3,achieve.three, ContextCompat.getColor(context!!,R.color.colorTransparent))
                    ViewHandler.editTextDisabled(rootViewAchieve.et4,achieve.four, ContextCompat.getColor(context!!,R.color.colorTransparent))
                    ViewHandler.editTextDisabled(rootViewAchieve.et5,achieve.five, ContextCompat.getColor(context!!,R.color.colorTransparent))
                    ViewHandler.editTextDisabled(rootViewAchieve.et6,achieve.six, ContextCompat.getColor(context!!,R.color.colorTransparent))
                    ViewHandler.editTextDisabled(rootViewAchieve.et7,achieve.seven, ContextCompat.getColor(context!!,R.color.colorTransparent))
                    ViewHandler.editTextDisabled(rootViewAchieve.et8,achieve.eigth, ContextCompat.getColor(context!!,R.color.colorTransparent))
                    ViewHandler.editTextDisabled(rootViewAchieve.et9,achieve.nine, ContextCompat.getColor(context!!,R.color.colorTransparent))
                    ViewHandler.editTextDisabled(rootViewAchieve.et10,achieve.ten, ContextCompat.getColor(context!!,R.color.colorTransparent))
                    ViewHandler.editTextDisabled(rootViewAchieve.etTitle,achieve.title, ContextCompat.getColor(context!!,R.color.colorTransparent))
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