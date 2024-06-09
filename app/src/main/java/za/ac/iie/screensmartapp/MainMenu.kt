package za.ac.iie.screensmartapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.reflect.Array

class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
        //declare variables
        val dateTv=findViewById<TextView>(R.id.edtDate)
        val amTimeTv=findViewById<TextView>(R.id.txtTimeam)
        val pmTimeTv=findViewById<TextView>(R.id.txtTimepm)
        val actNotesTv=findViewById<TextView>(R.id.txtNotes)

        //initialize variales
        var i: Int = 0//stores numbers
        var display : String = "" // Display blank first
        var maxEntries = 7 // Only allow 7 array entries

        var averageAM: Int=0
        var averagePM: Int=0
        var averageTotal: Int=0
        var displayAverage: String=""

        //Create arrays
        val day = Array(maxEntries){""}
        val morningTime=Array(maxEntries){0}
        val afternoonTime=Array(maxEntries){0}
        val actNotes=Array(maxEntries){""}

        val btnInsert:Button=findViewById(R.id.btnInsert)
        val BtnDetails:Button=findViewById(R.id.btnDetails)
        val btnClear:Button=findViewById(R.id.btnClear)

        btnInsert.setOnClickListener {
            // Check if there's enough entries
            if (i < maxEntries) {
                //Convert to display types
                day[i] = dateTv.text.toString()
                morningTime[i] =
                    amTimeTv.text.toString().toIntOrNull() ?: 0//0 is for error checking
                afternoonTime[i] =
                    pmTimeTv.text.toString().toIntOrNull() ?: 0
                actNotes[i] = actNotesTv.text.toString()
                i++//increment entry number

                Toast.makeText(this, "Entry added", Toast.LENGTH_SHORT).show()
            }else {
                    Toast.makeText(this,"Maximum entries reached",Toast.LENGTH_SHORT).show()
                }
            }



        val btnDetails:Button=findViewById(R.id.btnDetails)
        btnDetails.setOnClickListener {
            val intent=Intent(this,DetailViews::class.java)
            startActivity(intent)
        }
        // Clear the textviews
        btnClear.setOnClickListener {
            dateTv.text = ""
            amTimeTv.text=""
            pmTimeTv.text =""
            actNotesTv.text=""

        }
        //Button to navigate to Details View
        btnDetails.setOnClickListener {
            display=""
            for (counter in 0 until 1){
                display += "Date:${day[counter]}/nAM Time:${morningTime[counter]}/nPM Time:${afternoonTime[counter]}/nAverage Time:${averageTotal}/n"
                averageAM+= morningTime[counter]
                averagePM+= afternoonTime[counter]
                averageTotal+= morningTime[counter]+afternoonTime[counter]

            }

            averageTotal/=i
            averageAM/=i
            averagePM/=i

            displayAverage ="Average Time(AM):${averageAM}/nAverage Time(PM):${averagePM}Average Time:${averageTotal}/n"
            display += displayAverage

        } // Pass the data to DetailsViewActivity and start the activity
        val  intent= Intent(this,DetailViews::class.java)
        intent.putExtra("Display_Data",display)
        startActivity(intent)

    }
}