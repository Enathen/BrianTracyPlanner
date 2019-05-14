package growing.endless.creative.briantracyplanner.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import growing.endless.creative.briantracyplanner.GoalsActivity
import growing.endless.creative.briantracyplanner.HistoryActivity
import growing.endless.creative.briantracyplanner.R
import growing.endless.creative.briantracyplanner.SettingsActivity
import growing.endless.creative.briantracyplanner.animation.Animations
import growing.endless.creative.briantracyplanner.daily.DailyActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startAnimations()
        setupButtons()
    }

    private fun startAnimations() {
        val list = listOf<Button>(
            findViewById(R.id.btnDaily),
            findViewById(R.id.btnGoals),
            findViewById(R.id.btnHistory),
            findViewById(R.id.btnSettings)
        )
        Animations.fade_in(list,this)
    }

    private fun setupButtons(){
        findViewById<Button>(R.id.btnDaily).setOnClickListener { startActivity(Intent(this,
            DailyActivity::class.java)) }
        findViewById<Button>(R.id.btnGoals).setOnClickListener { startActivity(Intent(this,
            GoalsActivity::class.java)) }
        findViewById<Button>(R.id.btnHistory).setOnClickListener { startActivity(Intent(this,
            HistoryActivity::class.java)) }
        findViewById<Button>(R.id.btnSettings).setOnClickListener { startActivity(Intent(this,
            SettingsActivity::class.java)) }
    }

}
