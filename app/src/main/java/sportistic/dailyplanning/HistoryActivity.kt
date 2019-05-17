package sportistic.dailyplanning

import android.content.Intent
import android.os.Bundle
import android.support.v4.widget.TextViewCompat
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import kotlinx.android.synthetic.main.activity_history.*
import sportistic.dailyplanning.daily.DailyActivity
import sportistic.dailyplanning.database.DatabaseCollector



class HistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        val databaseCollector = DatabaseCollector(this)


        Thread(Runnable {
            val abcde = databaseCollector.getAllABCDE()
            if(abcde.isEmpty()){
                runOnUiThread {finish()
                    Toast.makeText(this,"Empty",Toast.LENGTH_LONG).show()  }

            }
            for (ab in abcde) {
                runOnUiThread {
                    val view = TextView(this)
                    TextViewCompat.setTextAppearance(view, R.style.title)
                    view.gravity = Gravity.CENTER
                    view.text = ab.date
                    view.setOnLongClickListener {
                        AlertDialog.Builder(this)
                            .setTitle("Delete entry")
                            .setMessage("Are you sure you want to delete this entry?")

                            .setPositiveButton(android.R.string.yes) { _, _ ->
                                databaseCollector.delete(ab.id)
                                Toast.makeText(this,"Deleted",Toast.LENGTH_SHORT).show()
                                finish()
                                startActivity(intent)
                            }

                            .setNegativeButton(android.R.string.no, null)
                            .show()
                        return@setOnLongClickListener true
                    }
                    view.setOnClickListener {
                        val intent = Intent(this, DailyActivity::class.java)
                        intent.putExtra("id",ab.id)
                        startActivity(intent)

                    }
                    linLayHistory.addView(TextView(this))
                    linLayHistory.addView(view)
                    linLayHistory.addView(TextView(this))
                }
            }
        }).start()
    }
}
