package vcmsa.ci.mycalculatorapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import vcmsa.ci.mycalculatorapp.R.id.multiplybutton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
       val multiplybutton = findViewById<Button>(R.id.multiplybutton)
        val inputnumber = findViewById<EditText>(R.id.inputnumber)
        multiplybutton.setOnClickListener{
            // create the explicit intent
            val intent = Intent(this, MultiplicationTable::class.java)
            // add the table number to the intent
            intent.putExtra("tableNumber", inputnumber.text.toString())
            // start the next activity
            startActivity(intent)
        }
        // IMAD5112/p/w
        //Module Manual 2025.p 58-69
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}