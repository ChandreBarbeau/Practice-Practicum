package za.ac.iie.screensmartapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnMainMenu: Button=findViewById(R.id.btnMainMenu)
        btnMainMenu.setOnClickListener {
            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
        }

        val btnExit:Button=findViewById(R.id.btnExit)
        btnExit.setOnClickListener {
            val intent =Intent(this,MainActivity::class.java)
            System.exit(0)
        }
    }
}