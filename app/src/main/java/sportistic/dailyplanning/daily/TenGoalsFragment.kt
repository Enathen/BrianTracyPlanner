package sportistic.dailyplanning.daily

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import sportistic.dailyplanning.R
import sportistic.dailyplanning.database.DatabaseCollector
import kotlinx.android.synthetic.main.activity_daily.*
import kotlinx.android.synthetic.main.fragment_ten_goals.view.*

/**
 *
 * @author Jonathan Alexander Norberg
 * @version 10/05/2019
 */
class TenGoalsFragment : Fragment() {
    public lateinit var rootView: View
    private var boolean = true
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_ten_goals, container, false)
        setupNavigation(rootView)
        viewOnly()
        return rootView
    }

    private fun setupNavigation(rootView: View) {
            rootView.ivRight.setOnClickListener { activity!!.container.currentItem = 2 }
            rootView.ivLeft.setOnClickListener { activity!!.container.currentItem = 0 }


    }
    private fun viewOnly() {
        val id = arguments!!.getInt("id", -1)
        if (id > -1) {
            val databaseCollecter = DatabaseCollector(this.context!!)
            Thread(Runnable {
                val topGoals = databaseCollecter.getTopGoals(id)
                activity!!.runOnUiThread {
                    ViewHandler.editTextDisabled(rootView.et1,topGoals.one, ContextCompat.getColor(context!!,R.color.colorTransparent))
                    ViewHandler.editTextDisabled(rootView.et2,topGoals.two, ContextCompat.getColor(context!!,R.color.colorTransparent))
                    ViewHandler.editTextDisabled(rootView.et3,topGoals.three, ContextCompat.getColor(context!!,R.color.colorTransparent))
                    ViewHandler.editTextDisabled(rootView.et4,topGoals.four, ContextCompat.getColor(context!!,R.color.colorTransparent))
                    ViewHandler.editTextDisabled(rootView.et5,topGoals.five, ContextCompat.getColor(context!!,R.color.colorTransparent))
                    ViewHandler.editTextDisabled(rootView.et6,topGoals.six, ContextCompat.getColor(context!!,R.color.colorTransparent))
                    ViewHandler.editTextDisabled(rootView.et7,topGoals.seven, ContextCompat.getColor(context!!,R.color.colorTransparent))
                    ViewHandler.editTextDisabled(rootView.et8,topGoals.eigth, ContextCompat.getColor(context!!,R.color.colorTransparent))
                    ViewHandler.editTextDisabled(rootView.et9,topGoals.nine, ContextCompat.getColor(context!!,R.color.colorTransparent))
                    ViewHandler.editTextDisabled(rootView.et10,topGoals.ten, ContextCompat.getColor(context!!,R.color.colorTransparent))
                }

            }).start()
        }
    }
    fun newInstance(index: Int): TenGoalsFragment{
        val f = TenGoalsFragment ()
        // Pass index input as an argument.
        val args = Bundle()
        args.putInt("id", index)
        f.setArguments(args)
        return f
    }





}