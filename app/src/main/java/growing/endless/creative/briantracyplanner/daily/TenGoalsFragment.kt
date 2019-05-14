package growing.endless.creative.briantracyplanner.daily

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import growing.endless.creative.briantracyplanner.R
import growing.endless.creative.briantracyplanner.database.DatabaseCollector
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
                val topgoals = databaseCollecter.getTopGoals(id)
                activity!!.runOnUiThread {
                    rootView.et1.setText(topgoals.one)
                    rootView.et1.isEnabled = false
                    rootView.et2.setText(topgoals.two)
                    rootView.et2.isEnabled = false
                    rootView.et3.setText(topgoals.three)
                    rootView.et3.isEnabled = false
                    rootView.et4.setText(topgoals.four)
                    rootView.et4.isEnabled = false
                    rootView.et5.setText(topgoals.five)
                    rootView.et5.isEnabled = false
                    rootView.et6.setText(topgoals.six)
                    rootView.et6.isEnabled = false
                    rootView.et7.setText(topgoals.seven)
                    rootView.et7.isEnabled = false
                    rootView.et8.setText(topgoals.eigth)
                    rootView.et8.isEnabled = false
                    rootView.et9.setText(topgoals.nine)
                    rootView.et9.isEnabled = false
                    rootView.et10.setText(topgoals.ten)
                    rootView.et10.isEnabled = false
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