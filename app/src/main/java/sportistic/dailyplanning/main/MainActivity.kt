package sportistic.dailyplanning.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import sportistic.dailyplanning.GoalsActivity
import sportistic.dailyplanning.HistoryActivity
import sportistic.dailyplanning.R
import sportistic.dailyplanning.SettingsActivity
import sportistic.dailyplanning.animation.Animations
import sportistic.dailyplanning.daily.DailyActivity



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
