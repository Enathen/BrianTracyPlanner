package sportistic.dailyplanning.daily

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import kotlinx.android.synthetic.main.activity_daily.*
import kotlinx.android.synthetic.main.fragment_abcde.view.*
import kotlinx.android.synthetic.main.fragment_how_to_achieve_one_goal.view.*
import sportistic.dailyplanning.R
import sportistic.dailyplanning.database.ABCDE
import sportistic.dailyplanning.database.Achieve
import sportistic.dailyplanning.database.DatabaseCollector
import sportistic.dailyplanning.database.TenGoals


class DailyActivity : AppCompatActivity() {

    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null
    lateinit var abcdeFragment: ABCDEFragment
    lateinit var tenGoalsFragment: TenGoalsFragment
    lateinit var achieveGoalsFragment: AchieveGoalsFragment

    var id: Int = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily)
        id = intent.getIntExtra("id", -1)
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        // Set up the ViewPager with the sections adapter.
        container.adapter = mSectionsPagerAdapter
        showAd()

    }

    override fun onBackPressed() {
        if (id > -1) {
            finish()
        } else {

            val builder = AlertDialog.Builder(this)
            builder.setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes") { dialog, id -> this@DailyActivity.finish() }
                .setNegativeButton("No") { dialog, id -> dialog.cancel() }
            val alert = builder.create()
            alert.show()
        }

    }

    fun save() {

        val databaseCollecter = DatabaseCollector(applicationContext)
        Thread(Runnable {
            insertABCDE(databaseCollecter)
            insertTopTen(databaseCollecter)
            insertAchieve(databaseCollecter)
        }).start()
        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
        finish()

    }

    private fun insertTopTen(databaseCollecter: DatabaseCollector) {
        val tenGoals = TenGoals()
        tenGoals.one = tenGoalsFragment.rootView.et1.text.toString()
        tenGoals.two = tenGoalsFragment.rootView.et2.text.toString()
        tenGoals.three = tenGoalsFragment.rootView.et3.text.toString()
        tenGoals.four = tenGoalsFragment.rootView.et4.text.toString()
        tenGoals.five = tenGoalsFragment.rootView.et5.text.toString()
        tenGoals.six = tenGoalsFragment.rootView.et6.text.toString()
        tenGoals.seven = tenGoalsFragment.rootView.et7.text.toString()
        tenGoals.eigth = tenGoalsFragment.rootView.et8.text.toString()
        tenGoals.nine = tenGoalsFragment.rootView.et9.text.toString()
        tenGoals.ten = tenGoalsFragment.rootView.et10.text.toString()
        databaseCollecter.insertTenGoals(tenGoals)
    }

    private fun insertABCDE(databaseCollecter: DatabaseCollector) {
        val abcde = ABCDE()
        abcde.A = abcdeFragment.rootView.etA.text.toString()
        abcde.B = abcdeFragment.rootView.etB.text.toString()
        abcde.C = abcdeFragment.rootView.etC.text.toString()
        abcde.D = abcdeFragment.rootView.etD.text.toString()
        abcde.E = abcdeFragment.rootView.etE.text.toString()
        databaseCollecter.insertABCDE(abcde)
    }

    private fun insertAchieve(databaseCollecter: DatabaseCollector) {
        val achieve = Achieve()
        achieve.one = achieveGoalsFragment.rootViewAchieve.et1.text.toString()
        achieve.two = achieveGoalsFragment.rootViewAchieve.et2.text.toString()
        achieve.three = achieveGoalsFragment.rootViewAchieve.et3.text.toString()
        achieve.four = achieveGoalsFragment.rootViewAchieve.et4.text.toString()
        achieve.five = achieveGoalsFragment.rootViewAchieve.et5.text.toString()
        achieve.six = achieveGoalsFragment.rootViewAchieve.et6.text.toString()
        achieve.seven = achieveGoalsFragment.rootViewAchieve.et7.text.toString()
        achieve.eigth = achieveGoalsFragment.rootViewAchieve.et8.text.toString()
        achieve.nine = achieveGoalsFragment.rootViewAchieve.et9.text.toString()
        achieve.ten = achieveGoalsFragment.rootViewAchieve.et10.text.toString()
        achieve.title = achieveGoalsFragment.rootViewAchieve.etTitle.text.toString()
        databaseCollecter.insertAchieve(achieve)
    }

    fun showAd() {
        val interstitialAd = InterstitialAd(this)
        interstitialAd.adUnitId = "ca-app-pub-3607354849437438/2100279182"
        interstitialAd.loadAd(AdRequest.Builder().addTestDevice("85566EDEF434C46837B6373FFB555990").build())
        interstitialAd.adListener = object : AdListener() {
            override fun onAdLoaded() {
                interstitialAd.show()
            }
        }

    }

    /**
     * A [FragmentPagerAdapter] that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return when (position) {
                0 -> {
                    abcdeFragment = ABCDEFragment().newInstance(id)
                    abcdeFragment
                }
                1 -> {
                    tenGoalsFragment = TenGoalsFragment().newInstance(id)
                    tenGoalsFragment
                }
                2 -> {
                    achieveGoalsFragment = AchieveGoalsFragment().newInstance(id)
                    achieveGoalsFragment
                }
                else -> Fragment()
            }
        }

        override fun getCount(): Int {
            return 3
        }
    }


}
