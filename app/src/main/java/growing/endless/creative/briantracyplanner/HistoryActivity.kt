package growing.endless.creative.briantracyplanner

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import growing.endless.creative.briantracyplanner.daily.DailyActivity
import growing.endless.creative.briantracyplanner.database.DatabaseCollector
import kotlinx.android.synthetic.main.activity_history.*



class HistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        val databaseCollector = DatabaseCollector(this)


        Thread(Runnable {
            val abcde = databaseCollector.getAllABCDE()
            for (ab in abcde) {
                runOnUiThread {
                    val view = TextView(this)
                    view.setTextAppearance(this,R.style.title)
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
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show()
                        return@setOnLongClickListener true
                    }
                    view.setOnClickListener {
                        val intent = Intent(this, DailyActivity::class.java)
                        intent.putExtra("id",ab.id)
                        startActivity(intent)}
                    linLayHistory.addView(view)
                }
            }
        }).start()
    }
}
