package growing.endless.creative.briantracyplanner.daily

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import growing.endless.creative.briantracyplanner.R
import growing.endless.creative.briantracyplanner.animation.Animations
import growing.endless.creative.briantracyplanner.database.DatabaseCollector
import kotlinx.android.synthetic.main.activity_daily.*
import kotlinx.android.synthetic.main.fragment_abcde.view.*

/**
 *
 * @author Jonathan Alexander Norberg
 * @version 10/05/2019
 */
class ABCDEFragment : Fragment() {
    public lateinit var rootView: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_abcde, container, false)
        viewOnly()
        animate()
        setupNavigation(rootView)

        return rootView
    }

    private fun viewOnly() {
        val id = arguments!!.getInt("id", -1)
        if (id > -1) {
            val databaseCollecter = DatabaseCollector(this.context!!)
            Thread(Runnable {
                val abcde = databaseCollecter.getABCDE(id)
                activity!!.runOnUiThread {
                    rootView.etA.setText(abcde.A)
                    rootView.etA.isEnabled = false
                    rootView.etB.setText(abcde.B)
                    rootView.etB.isEnabled = false
                    rootView.etC.setText(abcde.C)
                    rootView.etC.isEnabled = false
                    rootView.etD.setText(abcde.D)
                    rootView.etD.isEnabled = false
                    rootView.etE.setText(abcde.E)
                    rootView.etE.isEnabled = false
                }

            }).start()
        }
    }

    private fun setupNavigation(rootView: View) {
        rootView.ivRight.setOnClickListener { activity!!.container.currentItem = 1 }
        rootView.ivLeft.setOnClickListener { showHelpDialog()}
    }

    private fun showHelpDialog() {

        val dialog = Dialog(context!!)
        dialog.setContentView(R.layout.dialog_help)
        dialog.show()
    }

    private fun animate() {
        Animations.fade_in(listOf<View>(rootView.linLayTitle,rootView.tiA,rootView.tiB,rootView.tiC,rootView.tiD,rootView.tiE), this.context!!)
    }
    fun newInstance(index: Int): ABCDEFragment{
        val f = ABCDEFragment ()
        // Pass index input as an argument.
        val args = Bundle()
        args.putInt("id", index)
        f.setArguments(args)
        return f
    }

}