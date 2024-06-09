package za.ac.iie.screensmartapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DetailViews : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_views)

        val btnMainMenu: Button=findViewById(R.id.btnMainMenu)
        val tvDetailViews=findViewById<TextView>(R.id.tvDetails)
        val displayDate=intent.getStringExtra("Display_Data")
        tvDetailViews.text=displayDate

       // val tvAvg = findViewById<TextView>(R.id.tvAvg)
       // val displayAverage=intent.getStringExtra("DISPLAY_DATA_AVG")
       // tvAvg.text=displayAverage


        btnMainMenu.setOnClickListener {
            val intent =Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }
}